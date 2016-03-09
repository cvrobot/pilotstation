package com.wingoflights.pilotstation.service.core.drone.autopilot.apm.solo.sololink;

import com.wingoflights.pilotstation.service.core.drone.autopilot.apm.solo.AbstractLinkManager;
import com.wingoflights.pilotstation.api.lib.drone.companion.solo.tlv.SoloButtonSetting;
import com.wingoflights.pilotstation.api.lib.drone.companion.solo.tlv.TLVPacket;

/**
 * Created by Fredia Huya-Kouadio on 7/10/15.
 */
public interface SoloLinkListener extends AbstractLinkManager.LinkListener {

    void onTlvPacketReceived(TLVPacket packet);

    void onPresetButtonLoaded(int buttonType, SoloButtonSetting buttonSettings);
}
