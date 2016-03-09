package com.wingoflights.pilotstation.api.lib.util.version;

import android.content.Context;
import android.content.pm.PackageManager;

import com.wingoflights.pilotstation.R;

/**
 * Created by fhuya on 11/12/14.
 */
public class VersionUtils {

    public static int getCoreLibVersion(Context context){
        return context.getResources().getInteger(R.integer.server_version);
    }

    //Prevent instantiation.
    private VersionUtils(){}
}
