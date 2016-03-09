package com.wingoflights.pilotstation.api.client.apis.solo;

import com.wingoflights.pilotstation.api.client.Drone;
import com.wingoflights.pilotstation.api.lib.drone.companion.solo.tlv.TLVPacket;
import com.wingoflights.pilotstation.api.lib.model.AbstractCommandListener;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Fredia Huya-Kouadio on 7/31/15.
 */
public class SoloMessageApi extends SoloApi {

    private static final ConcurrentHashMap<Drone, SoloMessageApi> apiCache = new ConcurrentHashMap<>();
    private static final Builder<SoloMessageApi> apiBuilder = new Builder<SoloMessageApi>() {
        @Override
        public SoloMessageApi build(Drone drone) {
            return new SoloMessageApi(drone);
        }
    };

    public static SoloMessageApi getApi(final Drone drone){
        return getApi(drone, apiCache, apiBuilder);
    }

    protected SoloMessageApi(Drone drone) {
        super(drone);
    }

    @Override
    public void sendMessage(TLVPacket messagePacket, AbstractCommandListener listener){
        super.sendMessage(messagePacket, listener);
    }
}
