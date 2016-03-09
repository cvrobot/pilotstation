package com.wingoflights.pilotstation.service.core.gcs.follow;

import android.os.Handler;

import com.wingoflights.pilotstation.api.lib.coordinate.LatLong;
import com.wingoflights.pilotstation.api.lib.coordinate.LatLongAlt;
import com.wingoflights.pilotstation.api.lib.drone.attribute.AttributeType;
import com.wingoflights.pilotstation.api.lib.drone.property.Gps;

import com.wingoflights.pilotstation.service.core.drone.DroneManager;
import com.wingoflights.pilotstation.service.core.gcs.location.Location;
import com.wingoflights.pilotstation.service.core.helpers.geoTools.GeoTools;

/**
 * Created by fhuya on 1/5/15.
 */
public class FollowSplineLeash extends FollowWithRadiusAlgorithm {
    @Override
    public void processNewLocation(Location location) {
        final LatLongAlt userLoc = location.getCoord();

        final Gps droneGps = (Gps) drone.getAttribute(AttributeType.GPS);
        final LatLong droneLoc = droneGps.getPosition();

        if (userLoc == null || droneLoc == null)
            return;

        if (GeoTools.getDistance(userLoc, droneLoc) > radius) {
            double headingGCSToDrone = GeoTools.getHeadingFromCoordinates(userLoc, droneLoc);
            LatLong goCoord = GeoTools.newCoordFromBearingAndDistance(userLoc, headingGCSToDrone, radius);

            //TODO: some device (nexus 6) do not report the speed (always 0).. figure out workaround.
            double speed = location.getSpeed();
            double bearing = location.getBearing();
            double bearingInRad = Math.toRadians(bearing);
            double xVel = speed * Math.cos(bearingInRad);
            double yVel = speed * Math.sin(bearingInRad);
            drone.getGuidedPoint().newGuidedCoordAndVelocity(goCoord, xVel, yVel, 0);
        }

    }

    @Override
    public FollowModes getType() {
        return FollowModes.SPLINE_LEASH;
    }

    public FollowSplineLeash(DroneManager droneMgr, Handler handler, double length) {
        super(droneMgr, handler, length);
    }
}
