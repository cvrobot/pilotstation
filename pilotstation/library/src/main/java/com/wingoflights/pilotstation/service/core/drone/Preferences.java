package com.wingoflights.pilotstation.service.core.drone;

import com.wingoflights.pilotstation.service.core.drone.profiles.VehicleProfile;
import com.wingoflights.pilotstation.service.core.drone.variables.StreamRates;
import com.wingoflights.pilotstation.service.core.firmware.FirmwareType;

public interface Preferences {

	public abstract VehicleProfile loadVehicleProfile(FirmwareType firmwareType);

    public StreamRates.Rates getRates();
}
