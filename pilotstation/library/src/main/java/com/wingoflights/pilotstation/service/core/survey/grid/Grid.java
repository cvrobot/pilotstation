package com.wingoflights.pilotstation.service.core.survey.grid;

import com.wingoflights.pilotstation.api.lib.coordinate.LatLong;

import com.wingoflights.pilotstation.service.core.helpers.geoTools.PolylineTools;

import java.util.List;

public class Grid {
    public List<LatLong> gridPoints;
    private List<LatLong> cameraLocations;

    public Grid(List<LatLong> list, List<LatLong> cameraLocations) {
        this.gridPoints = list;
        this.cameraLocations = cameraLocations;
    }

    public double getLength() {
        return PolylineTools.getPolylineLength(gridPoints);
    }

    public int getNumberOfLines() {
        return gridPoints.size() / 2;
    }

    public List<LatLong> getCameraLocations() {
        return cameraLocations;
    }

    public int getCameraCount() {
        return cameraLocations.size();
    }

}