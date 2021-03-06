package com.wingoflights.pilotstation.service.utils.video;

import java.nio.ByteBuffer;

/**
 * Created by fhuya on 12/4/14.
 */
public class NALUChunk {
    public static final byte[] START_CODE = {0, 0, 0, 1};
    public static final int SPS_NAL_TYPE = 7;
    public static final int PPS_NAL_TYPE = 8;

    public final ByteBuffer[] payloads;

    public NALUChunk(int payloadCount, int payloadSize, byte[] payloadInitData) {
        this.payloads = new ByteBuffer[payloadCount];
        for (int i = 0; i < payloadCount; i++) {
            this.payloads[i] = ByteBuffer.allocate(payloadSize);
            if (payloadInitData != null) {
                this.payloads[i].put(payloadInitData);
                this.payloads[i].mark();
            }
        }
    }

    public int type;
    public int sequenceNumber;
    public int flags;
    public long presentationTime;
}
