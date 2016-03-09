package com.wingoflights.pilotstation.service.core.model;

import com.wingoflights.pilotstation.service.core.drone.autopilot.MavLinkDrone;

/**
 * Parse received autopilot warning messages.
 */
public interface AutopilotWarningParser {

    String getDefaultWarning();

    String parseWarning(MavLinkDrone drone, String warning);
}
