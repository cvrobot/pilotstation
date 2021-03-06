package com.wingoflights.pilotstation.service.core.drone.autopilot.apm;

import android.content.Context;
import android.os.Handler;

import com.MAVLink.enums.MAV_TYPE;

import com.wingoflights.pilotstation.service.core.MAVLink.MAVLinkStreams;
import com.wingoflights.pilotstation.service.core.drone.DroneInterfaces;
import com.wingoflights.pilotstation.service.core.drone.LogMessageListener;
import com.wingoflights.pilotstation.service.core.drone.Preferences;
import com.wingoflights.pilotstation.service.core.firmware.FirmwareType;
import com.wingoflights.pilotstation.service.core.model.AutopilotWarningParser;

/**
 * Created by Fredia Huya-Kouadio on 7/27/15.
 */
public class ArduRover extends ArduPilot {

    public ArduRover(Context context, MAVLinkStreams.MAVLinkOutputStream mavClient, Handler handler, AutopilotWarningParser warningParser, LogMessageListener logListener, DroneInterfaces.AttributeEventListener listener) {
        super(context, mavClient, handler, warningParser, logListener, listener);
    }

    @Override
    public int getType(){
        return MAV_TYPE.MAV_TYPE_GROUND_ROVER;
    }

    @Override
    public void setType(int type){}

    @Override
    public FirmwareType getFirmwareType() {
        return FirmwareType.ARDU_ROVER;
    }
}
