package com.wingoflights.pilotstation.api.lib.model;

import android.os.RemoteException;

/**
 * Created by Fredia Huya-Kouadio on 7/5/15.
 */
public abstract class AbstractCommandListener extends ICommandListener.Stub {

    @Override
    public abstract void onSuccess();

    @Override
    public abstract void onError(int executionError);

    @Override
    public abstract void onTimeout();
}
