package com.wingoflights.pilotstation.service.core.gcs.follow;

import android.os.Handler;

import com.wingoflights.pilotstation.api.lib.coordinate.LatLong;

import com.wingoflights.pilotstation.service.core.drone.DroneManager;
import com.wingoflights.pilotstation.service.core.gcs.location.Location;
import com.wingoflights.pilotstation.service.core.helpers.geoTools.GeoTools;
import com.wingoflights.pilotstation.service.core.helpers.math.MathUtil;

public class FollowCircle extends FollowWithRadiusAlgorithm {

    /**
     * °/s
     */
    private double circleStep = 2;
    private double circleAngle = 0.0;

    public FollowCircle(DroneManager droneMgr, Handler handler, double radius, double rate) {
        super(droneMgr, handler, radius);
        circleStep = rate;
    }

    @Override
    public FollowModes getType() {
        return FollowModes.CIRCLE;
    }

    @Override
    public void processNewLocation(Location location) {
        LatLong gcsCoord = new LatLong(location.getCoord());
        LatLong goCoord = GeoTools.newCoordFromBearingAndDistance(gcsCoord, circleAngle, radius);
        circleAngle = MathUtil.constrainAngle(circleAngle + circleStep);
        drone.getGuidedPoint().newGuidedCoord(goCoord);
    }
}
