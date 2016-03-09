package com.wingoflights.pilotstation.service.core.gcs.follow;

import android.os.Handler;

import com.wingoflights.pilotstation.api.lib.coordinate.LatLong;

import com.wingoflights.pilotstation.service.core.drone.DroneManager;
import com.wingoflights.pilotstation.service.core.gcs.location.Location;
import com.wingoflights.pilotstation.service.core.helpers.geoTools.GeoTools;
import com.wingoflights.pilotstation.service.core.drone.autopilot.MavLinkDrone;

public abstract class FollowHeadingAngle extends FollowWithRadiusAlgorithm {

    protected double angleOffset;
    protected final MavLinkDrone drone;

    protected FollowHeadingAngle(DroneManager droneMgr, Handler handler, double radius, double angleOffset) {
        super(droneMgr, handler, radius);
        this.angleOffset = angleOffset;

        this.drone = droneMgr.getDrone();
    }

    @Override
    public void processNewLocation(Location location) {
        LatLong gcsCoord = new LatLong(location.getCoord());
        double bearing = location.getBearing();

        LatLong goCoord = GeoTools.newCoordFromBearingAndDistance(gcsCoord, bearing + angleOffset, radius);
        drone.getGuidedPoint().newGuidedCoord(goCoord);
    }

}