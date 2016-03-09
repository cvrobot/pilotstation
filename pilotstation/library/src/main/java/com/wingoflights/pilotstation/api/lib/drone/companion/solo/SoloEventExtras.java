package com.wingoflights.pilotstation.api.lib.drone.companion.solo;

/**
 * Holds handles used to retrieve additional information broadcast along a drone event.
 * Created by Fredia Huya-Kouadio on 7/31/15.
 */
public class SoloEventExtras {

    //Private to prevent instantiation
    private SoloEventExtras(){}

    private static final String PACKAGE_NAME = "com.wingoflights.pilotstation.api.lib.drone.companion.solo.event.extra";

    /**
     * Used to retrieve the {@link com.wingoflights.pilotstation.api.lib.drone.companion.solo.button.ButtonPacket} object describing the button event.
     */
    public static final String EXTRA_SOLO_BUTTON_EVENT = PACKAGE_NAME + ".EXTRA_SOLO_BUTTON_EVENT";
    /**
     * Used to retrieve the received sololink message data in bytes.
     */
    public static final String EXTRA_SOLO_MESSAGE_DATA = PACKAGE_NAME + ".EXTRA_SOLO_MESSAGE_DATA";
    /**
     * Used to retrieve the boolean value specifying whether the controller is compliant with the EU tx power levels.
     * @see {@link SoloEvents#SOLO_EU_TX_POWER_COMPLIANCE_UPDATED}
     */
    public static final String EXTRA_SOLO_EU_TX_POWER_COMPLIANT = PACKAGE_NAME + ".EXTRA_SOLO_EU_TX_POWER_COMPLIANT";

    /**
     * Used to retrieve the solo controller version.
     * @see {@link SoloEvents#SOLO_VERSIONS_UPDATED}
     */
    public static final String EXTRA_SOLO_CONTROLLER_VERSION = PACKAGE_NAME + ".EXTRA_SOLO_CONTROLLER_VERSION";

    /**
     * Used to retrieve the solo controller firmware version.
     * @see {@link SoloEvents#SOLO_VERSIONS_UPDATED}
     */
    public static final String EXTRA_SOLO_CONTROLLER_FIRMWARE_VERSION = PACKAGE_NAME + ".EXTRA_SOLO_CONTROLLER_FIRMWARE_VERSION";

    /**
     * Used to retrieve the solo vehicle version.
     * @see {@link SoloEvents#SOLO_VERSIONS_UPDATED}
     */
    public static final String EXTRA_SOLO_VEHICLE_VERSION = PACKAGE_NAME + ".EXTRA_SOLO_VEHICLE_VERSION";

    /**
     * Used to retrieve the solo autopilot version.
     * @see {@link SoloEvents#SOLO_VERSIONS_UPDATED}
     */
    public static final String EXTRA_SOLO_AUTOPILOT_VERSION = PACKAGE_NAME + ".EXTRA_SOLO_AUTOPILOT_VERSION";

    /**
     * Used to retrieve the solo gimbal version.
     * @see {@link SoloEvents#SOLO_VERSIONS_UPDATED}
     */
    public static final String EXTRA_SOLO_GIMBAL_VERSION = PACKAGE_NAME + ".EXTRA_SOLO_GIMBAL_VERSION";

    /**
     * Used to retrieve the controller mode.
     * @see {@link com.wingoflights.pilotstation.api.lib.drone.companion.solo.controller.SoloControllerMode.ControllerMode}
     * @see {@link SoloEvents#SOLO_CONTROLLER_MODE_UPDATED}
     */
    public static final String EXTRA_SOLO_CONTROLLER_MODE = PACKAGE_NAME + ".EXTRA_SOLO_CONTROLLER_MODE";

    /**
     * Used to retrieve the controller unit system.
     * @see {@link com.wingoflights.pilotstation.api.lib.drone.companion.solo.controller.SoloControllerUnits.ControllerUnit}
     * @see {@link SoloEvents#SOLO_CONTROLLER_UNIT_UPDATED}
     */
    public static final String EXTRA_SOLO_CONTROLLER_UNIT = PACKAGE_NAME + ".EXTRA_SOLO_CONTROLLER_UNIT";
}