package com.wingoflights.pilotstation.api.client;

import android.os.Bundle;
import android.os.RemoteException;

import com.wingoflights.pilotstation.api.lib.drone.connection.ConnectionResult;
import com.wingoflights.pilotstation.api.lib.model.IObserver;

/**
 * Created by fhuya on 10/29/14.
 */
final class DroneObserver extends IObserver.Stub {

    private final Drone drone;

    public DroneObserver(Drone drone) {
        this.drone = drone;
    }

    @Override
    public void onAttributeUpdated(String attributeEvent, Bundle eventExtras) throws
            RemoteException {
        drone.notifyAttributeUpdated(attributeEvent, eventExtras);
    }
}
