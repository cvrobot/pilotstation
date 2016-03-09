package com.wingoflights.pilotstation.service.core.drone.autopilot;

import com.MAVLink.Messages.MAVLinkMessage;

import com.wingoflights.pilotstation.service.core.MAVLink.MAVLinkStreams;
import com.wingoflights.pilotstation.service.core.MAVLink.WaypointManager;
import com.wingoflights.pilotstation.service.core.drone.DroneInterfaces;
import com.wingoflights.pilotstation.service.core.drone.Preferences;
import com.wingoflights.pilotstation.service.core.drone.profiles.ParameterManager;
import com.wingoflights.pilotstation.service.core.drone.profiles.VehicleProfile;
import com.wingoflights.pilotstation.service.core.drone.variables.Camera;
import com.wingoflights.pilotstation.service.core.drone.variables.GuidedPoint;
import com.wingoflights.pilotstation.service.core.drone.variables.Magnetometer;
import com.wingoflights.pilotstation.service.core.drone.variables.MissionStats;
import com.wingoflights.pilotstation.service.core.drone.variables.State;
import com.wingoflights.pilotstation.service.core.drone.variables.StreamRates;
import com.wingoflights.pilotstation.service.core.drone.variables.calibration.AccelCalibration;
import com.wingoflights.pilotstation.service.core.drone.variables.calibration.MagnetometerCalibrationImpl;
import com.wingoflights.pilotstation.service.core.firmware.FirmwareType;
import com.wingoflights.pilotstation.service.core.mission.Mission;

public interface MavLinkDrone extends Drone {

    String PACKAGE_NAME = "com.wingoflights.pilotstation.service.core.drone.autopilot";

    String ACTION_REQUEST_HOME_UPDATE = PACKAGE_NAME + ".action.REQUEST_HOME_UPDATE";

    boolean isConnectionAlive();

    int getMavlinkVersion();

    void onMavLinkMessageReceived(MAVLinkMessage message);

    public void addDroneListener(DroneInterfaces.OnDroneListener listener);

    public void removeDroneListener(DroneInterfaces.OnDroneListener listener);

    public void notifyDroneEvent(DroneInterfaces.DroneEventsType event);

    public byte getSysid();

    public byte getCompid();

    public State getState();

    public ParameterManager getParameterManager();

    public int getType();

    public FirmwareType getFirmwareType();

    public MAVLinkStreams.MAVLinkOutputStream getMavClient();

    public WaypointManager getWaypointManager();

    public Mission getMission();

    public StreamRates getStreamRates();

    public MissionStats getMissionStats();

    public GuidedPoint getGuidedPoint();

    public AccelCalibration getCalibrationSetup();

    public MagnetometerCalibrationImpl getMagnetometerCalibration();

    public String getFirmwareVersion();

    public Camera getCamera();

}
