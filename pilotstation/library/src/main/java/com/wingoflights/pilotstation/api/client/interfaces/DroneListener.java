package com.wingoflights.pilotstation.api.client.interfaces;

import android.os.Bundle;

import com.wingoflights.pilotstation.api.lib.drone.connection.ConnectionResult;

/**
 * Created by fhuya on 11/18/14.
 */
public interface DroneListener {

    void onDroneConnectionFailed(ConnectionResult result);

    void onDroneEvent(String event, Bundle extras);

    void onDroneServiceInterrupted(String errorMsg);
}
