package com.wingoflights.pilotstation.service.core.gcs.follow;

import android.os.Handler;

import com.wingoflights.pilotstation.service.core.drone.DroneManager;
import com.wingoflights.pilotstation.service.core.drone.autopilot.MavLinkDrone;

public class FollowRight extends FollowHeadingAngle {

    public FollowRight(DroneManager droneMgr, Handler handler, double radius) {
        super(droneMgr, handler, radius, 90.0);
    }

    @Override
    public FollowModes getType() {
        return FollowModes.RIGHT;
    }

}
