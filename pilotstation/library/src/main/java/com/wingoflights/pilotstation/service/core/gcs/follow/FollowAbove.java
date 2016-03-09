package com.wingoflights.pilotstation.service.core.gcs.follow;

import android.os.Handler;

import com.wingoflights.pilotstation.api.lib.coordinate.LatLong;

import com.wingoflights.pilotstation.service.core.drone.DroneManager;
import com.wingoflights.pilotstation.service.core.gcs.location.Location;
import com.wingoflights.pilotstation.service.core.drone.autopilot.MavLinkDrone;

public class FollowAbove extends FollowAlgorithm {

    protected final MavLinkDrone drone;

    public FollowAbove(DroneManager droneMgr, Handler handler) {
        super(droneMgr, handler);
        this.drone = droneMgr.getDrone();
    }

    @Override
    public FollowModes getType() {
        return FollowModes.ABOVE;
    }

    @Override
    protected void processNewLocation(Location location) {
        final LatLong gcsCoord = new LatLong(location.getCoord());
        drone.getGuidedPoint().newGuidedCoord(gcsCoord);
    }

}
