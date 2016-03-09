package com.wingoflights.pilotstation.service.communication.connection;

import android.content.Context;

import com.wingoflights.pilotstation.service.core.MAVLink.connection.MavLinkConnection;
import com.wingoflights.pilotstation.service.core.model.Logger;
import com.wingoflights.pilotstation.service.utils.AndroidLogger;

public abstract class AndroidMavLinkConnection extends MavLinkConnection {

    private static final String TAG = AndroidMavLinkConnection.class.getSimpleName();

    protected final Context mContext;

    public AndroidMavLinkConnection(Context applicationContext) {
        this.mContext = applicationContext;
    }

    @Override
    protected final Logger initLogger() {
        return AndroidLogger.getLogger();
    }
}
