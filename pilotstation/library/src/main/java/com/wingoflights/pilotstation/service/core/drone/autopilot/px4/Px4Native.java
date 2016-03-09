package com.wingoflights.pilotstation.service.core.drone.autopilot.px4;

import android.content.Context;
import android.os.Handler;

import com.wingoflights.pilotstation.service.core.MAVLink.MAVLinkStreams;
import com.wingoflights.pilotstation.service.core.MAVLink.WaypointManager;
import com.wingoflights.pilotstation.service.core.drone.DroneInterfaces;
import com.wingoflights.pilotstation.service.core.drone.LogMessageListener;
import com.wingoflights.pilotstation.service.core.drone.Preferences;
import com.wingoflights.pilotstation.service.core.drone.autopilot.generic.GenericMavLinkDrone;
import com.wingoflights.pilotstation.service.core.drone.profiles.ParameterManager;
import com.wingoflights.pilotstation.service.core.drone.profiles.VehicleProfile;
import com.wingoflights.pilotstation.service.core.drone.variables.Camera;
import com.wingoflights.pilotstation.service.core.drone.variables.GuidedPoint;
import com.wingoflights.pilotstation.service.core.drone.variables.Magnetometer;
import com.wingoflights.pilotstation.service.core.drone.variables.MissionStats;
import com.wingoflights.pilotstation.service.core.drone.variables.calibration.AccelCalibration;
import com.wingoflights.pilotstation.service.core.drone.variables.calibration.MagnetometerCalibrationImpl;
import com.wingoflights.pilotstation.service.core.firmware.FirmwareType;
import com.wingoflights.pilotstation.service.core.mission.Mission;
import com.wingoflights.pilotstation.service.core.model.AutopilotWarningParser;

/**
 * Created by Fredia Huya-Kouadio on 9/10/15.
 */
public class Px4Native extends GenericMavLinkDrone {

    public Px4Native(Context context, Handler handler, MAVLinkStreams.MAVLinkOutputStream mavClient, AutopilotWarningParser warningParser, LogMessageListener logListener, DroneInterfaces.AttributeEventListener listener) {
        super(context, handler, mavClient, warningParser, logListener, listener);
    }

    @Override
    public FirmwareType getFirmwareType() {
        return FirmwareType.PX4_NATIVE;
    }

}
