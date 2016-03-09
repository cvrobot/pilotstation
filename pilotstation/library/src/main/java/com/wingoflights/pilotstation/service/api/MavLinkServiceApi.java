package com.wingoflights.pilotstation.service.api;

import com.MAVLink.MAVLinkPacket;
import com.wingoflights.pilotstation.api.lib.drone.connection.ConnectionParameter;

import com.wingoflights.pilotstation.service.core.MAVLink.connection.MavLinkConnection;
import com.wingoflights.pilotstation.service.core.MAVLink.connection.MavLinkConnectionListener;
import com.wingoflights.pilotstation.service.communication.connection.AndroidMavLinkConnection;

import java.lang.ref.SoftReference;

/**
 * MavLinkService app api.
 */
public class MavLinkServiceApi {

    private final PilotStationService mService;

    public MavLinkServiceApi(PilotStationService service) {
        mService = service;
    }

    private PilotStationService getService() {
        return mService;
    }

    public boolean sendData(ConnectionParameter connParams, MAVLinkPacket packet) {
        final AndroidMavLinkConnection mavConnection = getService().mavConnections.get(connParams.getUniqueId());
        if (mavConnection == null) return false;

        if (mavConnection.getConnectionStatus() != MavLinkConnection.MAVLINK_DISCONNECTED) {
            mavConnection.sendMavPacket(packet);
            return true;
        }

        return false;
    }

    public int getConnectionStatus(ConnectionParameter connParams, String tag) {
        final AndroidMavLinkConnection mavConnection = getService().mavConnections.get(connParams.getUniqueId());
        if (mavConnection == null || !mavConnection.hasMavLinkConnectionListener(tag)) {
            return MavLinkConnection.MAVLINK_DISCONNECTED;
        }

        return mavConnection.getConnectionStatus();
    }

    public void connectMavLink(ConnectionParameter connParams, String tag, MavLinkConnectionListener listener) {
        getService().connectMAVConnection(connParams, tag, listener);
    }

    public void addLoggingFile(ConnectionParameter connParams, String tag, String loggingFilePath){
        getService().addLoggingFile(connParams, tag, loggingFilePath);
    }

    public void removeLoggingFile(ConnectionParameter connParams, String tag){
        getService().removeLoggingFile(connParams, tag);
    }

    public void disconnectMavLink(ConnectionParameter connParams, String tag) {
        getService().disconnectMAVConnection(connParams, tag);
    }
}
