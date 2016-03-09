package com.wingoflights.pilotstation.service.api;

import android.os.Binder;

import java.util.ArrayList;
import java.util.List;

/**
* Created by fhuya on 11/3/14.
*/
public final class DroneAccess extends Binder {

    private final PilotStationService serviceRef;

    DroneAccess(PilotStationService service) {
        serviceRef = service;
    }

    public List<DroneApi> getDroneApiList() {
        return new ArrayList<>(serviceRef.droneApiStore.values());
    }
}
