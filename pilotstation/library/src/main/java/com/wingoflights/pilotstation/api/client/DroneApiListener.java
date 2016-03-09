package com.wingoflights.pilotstation.api.client;

import android.os.RemoteException;

import com.wingoflights.pilotstation.api.lib.drone.connection.ConnectionResult;
import com.wingoflights.pilotstation.api.lib.model.IApiListener;
import com.wingoflights.pilotstation.api.lib.util.version.VersionUtils;

import com.wingoflights.pilotstation.BuildConfig;
/**
 * Created by fhuya on 12/15/14.
 */
public class DroneApiListener extends IApiListener.Stub {

    private final Drone drone;

    public DroneApiListener(Drone drone){
        this.drone = drone;
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) throws RemoteException {
        drone.notifyDroneConnectionFailed(connectionResult);
    }

    @Override
    public int getClientVersionCode() throws RemoteException {
        return BuildConfig.VERSION_CODE;
    }

    @Override
    public int getApiVersionCode(){
        return VersionUtils.getCoreLibVersion(drone.getContext());
    }
}
