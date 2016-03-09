package com.wingoflights.pilotstation.service.api;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;

import com.wingoflights.pilotstation.api.lib.drone.connection.ConnectionParameter;
import com.wingoflights.pilotstation.api.lib.gcs.event.GCSEvent;
import com.wingoflights.pilotstation.api.lib.model.IApiListener;
import com.wingoflights.pilotstation.api.lib.model.IPilotStationServices;
import com.wingoflights.pilotstation.api.lib.model.IDroneApi;
import com.wingoflights.pilotstation.api.lib.util.version.VersionUtils;

import com.wingoflights.pilotstation.BuildConfig;
import com.wingoflights.pilotstation.service.core.drone.DroneManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fhuya on 11/3/14.
 */
final class PTServices extends IPilotStationServices.Stub {

    private final static String TAG = PTServices.class.getSimpleName();

    private PilotStationService serviceRef;

    PTServices(PilotStationService service) {
        serviceRef = service;
    }

    void destroy(){
        serviceRef = null;
    }

    @Override
    public int getServiceVersionCode() throws RemoteException {
        return BuildConfig.VERSION_CODE;
    }

    @Override
    public int getApiVersionCode() throws RemoteException {
        return VersionUtils.getCoreLibVersion(serviceRef.getApplicationContext());
    }

    @Override
    public IDroneApi registerDroneApi(IApiListener listener, String appId) throws RemoteException {
        return serviceRef.registerDroneApi(listener, appId);
    }

    @Override
    public Bundle[] getConnectedApps(String requesterId) throws RemoteException {
        Log.d(TAG, "List of connected apps request from " + requesterId);

        List<Bundle> appsInfo = new ArrayList<>();
        for(DroneApi droneApi : serviceRef.droneApiStore.values()){
            if(droneApi.isConnected()){
                DroneManager droneManager = droneApi.getDroneManager();
                if(droneManager != null) {
                    final ConnectionParameter droneParams = droneApi.getDroneManager().getConnectionParameter();
                    final ConnectionParameter sanitizedParams = new ConnectionParameter(droneParams.getConnectionType(),
                            droneParams.getParamsBundle(), null);

                    Bundle info = new Bundle();
                    info.putString(GCSEvent.EXTRA_APP_ID, droneApi.getOwnerId());
                    info.putParcelable(GCSEvent.EXTRA_VEHICLE_CONNECTION_PARAMETER, sanitizedParams);

                    appsInfo.add(info);
                }
            }
        }

        return appsInfo.toArray(new Bundle[appsInfo.size()]);
    }

    @Override
    public void releaseDroneApi(IDroneApi dpApi) throws RemoteException {
        Log.d(TAG, "Releasing acquired drone api handle.");
        if(dpApi instanceof DroneApi) {
            serviceRef.releaseDroneApi(((DroneApi) dpApi).getOwnerId());
        }
    }
}
