package com.wingoflights.pilotstation.service.core.drone.autopilot;

import com.wingoflights.pilotstation.api.lib.drone.property.DroneAttribute;
import com.wingoflights.pilotstation.api.lib.model.ICommandListener;
import com.wingoflights.pilotstation.api.lib.model.action.Action;

/**
 * Created by Fredia Huya-Kouadio on 7/27/15.
 */
public interface Drone {

    boolean isConnected();

    DroneAttribute getAttribute(String attributeType);

    boolean executeAsyncAction(Action action, ICommandListener listener);

    void destroy();
}
