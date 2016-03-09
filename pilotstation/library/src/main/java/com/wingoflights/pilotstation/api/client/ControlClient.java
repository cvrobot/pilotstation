package com.wingoflights.pilotstation.api.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.wingoflights.pilotstation.api.client.apis.ApiAvailability;
import com.wingoflights.pilotstation.api.client.interfaces.ClientListener;
import com.wingoflights.pilotstation.api.lib.drone.connection.ConnectionParameter;
import com.wingoflights.pilotstation.api.lib.model.IPilotStationServices;
import com.wingoflights.pilotstation.service.api.PilotStationService;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by fhuya on 11/12/14.
 */
public class ControlClient {

    private static final String TAG = ControlClient.class.getSimpleName();

    private final Intent serviceIntent = new Intent(IPilotStationServices.class.getName());

    private final IBinder.DeathRecipient binderDeathRecipient = new IBinder.DeathRecipient() {
        @Override
        public void binderDied() {
            notifyClientDisconnected();
        }
    };

    private final ServiceConnection psServicesConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            isServiceConnecting.set(false);

            psServices = IPilotStationServices.Stub.asInterface(service);
            try {
                psServices.asBinder().linkToDeath(binderDeathRecipient, 0);
                notifyClientConnected();
            } catch (RemoteException e) {
                notifyClientDisconnected();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isServiceConnecting.set(false);
            notifyClientDisconnected();
        }
    };

    private final AtomicBoolean isServiceConnecting = new AtomicBoolean(false);

    private final Context context;
    private ClientListener clientListener;
    private IPilotStationServices psServices;

    public ControlClient(Context context) {
        this.context = context;
    }

    IPilotStationServices getpsServices() {
        return psServices;
    }

    public boolean isClientConnected() {
        return psServices != null && psServices.asBinder().pingBinder();
    }

    void notifyClientConnected() {
        if (clientListener == null)
            return;

        clientListener.onClientConnected();
    }

    void notifyClientDisconnected() {
        if (clientListener == null)
            return;

        clientListener.onClientDisconnected();
    }

    public Bundle[] getConnectedApps() {
        Bundle[] connectedApps = new Bundle[0];
        if (isClientConnected()) {
            try {
                connectedApps = psServices.getConnectedApps(getApplicationId());
                if (connectedApps != null) {
                    final ClassLoader classLoader = ConnectionParameter.class.getClassLoader();
                    for (Bundle appInfo : connectedApps) {
                        appInfo.setClassLoader(classLoader);
                    }
                }
            } catch (RemoteException e) {
                Log.e(TAG, e.getMessage(), e);
            }
        }

        return connectedApps;
    }

    public void registerDrone(Drone drone, Handler handler) {
        if (drone == null)
            return;

        if (!isClientConnected())
            throw new IllegalStateException("Control Tower must be connected.");

        drone.init(this, handler);
        drone.start();
    }

    public void unregisterDrone(Drone drone) {
        if (drone != null)
            drone.destroy();
    }

    public void connect(ClientListener listener) {
        if (clientListener != null && (isServiceConnecting.get() || isClientConnected()))
            return;

        if (listener == null) {
            throw new IllegalArgumentException("ServiceListener argument cannot be null.");
        }

        clientListener = listener;

        if (!isClientConnected() && !isServiceConnecting.get()) {
            final ResolveInfo info = context.getPackageManager().resolveService(serviceIntent, 0);
            if (info != null) {
                Log.d(TAG, "bindService global");
                serviceIntent.setClassName(info.serviceInfo.packageName, info.serviceInfo.name);
                Log.d(TAG, info.serviceInfo.packageName + " " + info.serviceInfo.name);
                isServiceConnecting.set(context.bindService(serviceIntent, psServicesConnection,
                        Context.BIND_AUTO_CREATE));
            }else{
                serviceIntent.setClass(this.context,PilotStationService.class);
                boolean flag = context.bindService(serviceIntent, psServicesConnection,
                        this.context.BIND_AUTO_CREATE);
                Log.d(TAG, "bindService local flg " + flag);
                isServiceConnecting.set(flag);
            }
            /*
            final int apiAvailableResult = ApiAvailability.getInstance().checkApiAvailability(context);
            Log.d(TAG,"apiAvailableResult "+ apiAvailableResult);
            switch(apiAvailableResult){
                case ApiAvailability.API_AVAILABLE:
                    final ResolveInfo info = context.getPackageManager().resolveService(serviceIntent, 0);
                    if (info != null) {
                        Log.d(TAG, "package:"+ info.serviceInfo.packageName + " name:" + info.serviceInfo.name + "IPilotStationServices: " + IPilotStationServices.class.getName());
                        serviceIntent.setClassName(info.serviceInfo.packageName, info.serviceInfo.name);
                        isServiceConnecting.set(context.bindService(serviceIntent, psServicesConnection,
                                Context.BIND_AUTO_CREATE));
                    }
                    break;

                default:
                    //ApiAvailability.getInstance().showErrorDialog(context, apiAvailableResult);
                    break;
            }*/
        }
    }

    public void disconnect() {
        if (psServices != null) {
            psServices.asBinder().unlinkToDeath(binderDeathRecipient, 0);
            psServices = null;
        }

        notifyClientDisconnected();

        clientListener = null;

        try {
            context.unbindService(psServicesConnection);
        } catch (Exception e) {
            Log.e(TAG, "Error occurred while unbinding from 3DR Services.");
        }
    }

    String getApplicationId() {
        return context.getPackageName();
    }
}
