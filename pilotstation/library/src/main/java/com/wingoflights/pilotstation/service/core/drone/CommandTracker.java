package com.wingoflights.pilotstation.service.core.drone;

import com.MAVLink.Messages.MAVLinkMessage;
import com.wingoflights.pilotstation.api.lib.model.ICommandListener;

/**
 * Created by Fredia Huya-Kouadio on 6/24/15.
 */
public interface CommandTracker {

    void onCommandSubmitted(MAVLinkMessage command, ICommandListener listener);

    void onCommandAck(int commandId, Object ack);
}
