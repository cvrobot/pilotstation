package com.wingoflights.pilotstation.api.client;

import com.wingoflights.pilotstation.api.lib.mavlink.MavlinkMessageWrapper;
import com.wingoflights.pilotstation.api.lib.model.IMavlinkObserver;

/**
 * Allows to register for mavlink message updates.
 */
public abstract class MavlinkObserver extends IMavlinkObserver.Stub {

    @Override
    public abstract void onMavlinkMessageReceived(MavlinkMessageWrapper mavlinkMessageWrapper);
}
