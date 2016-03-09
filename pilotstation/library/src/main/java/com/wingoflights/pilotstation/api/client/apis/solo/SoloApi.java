package com.wingoflights.pilotstation.api.client.apis.solo;

import android.os.Bundle;

import com.wingoflights.pilotstation.api.client.Drone;
import com.wingoflights.pilotstation.api.client.apis.Api;
import com.wingoflights.pilotstation.api.lib.drone.companion.solo.tlv.TLVPacket;
import com.wingoflights.pilotstation.api.lib.model.AbstractCommandListener;
import com.wingoflights.pilotstation.api.lib.model.action.Action;

import static com.wingoflights.pilotstation.api.lib.drone.companion.solo.action.SoloActions.ACTION_SEND_MESSAGE;
import static com.wingoflights.pilotstation.api.lib.drone.companion.solo.action.SoloActions.EXTRA_MESSAGE_DATA;

/**
 * Created by Fredia Huya-Kouadio on 7/31/15.
 */
public abstract class SoloApi extends Api {

    protected final Drone drone;

    protected SoloApi(Drone drone){
        this.drone = drone;
    }

    /**
     * Sends a message to the solo vehicle.
     * @param messagePacket TLV message data.
     * @param listener Register a callback to receive update of the command execution status.
     */
    protected void sendMessage(TLVPacket messagePacket, AbstractCommandListener listener){
        Bundle params = new Bundle();
        params.putParcelable(EXTRA_MESSAGE_DATA, messagePacket);
        drone.performAsyncActionOnDroneThread(new Action(ACTION_SEND_MESSAGE, params), listener);
    }
}
