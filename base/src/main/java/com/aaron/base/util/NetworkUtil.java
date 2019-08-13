package com.aaron.base.util;

import android.Manifest;
import androidx.annotation.RequiresPermission;
import com.blankj.utilcode.util.NetworkUtils;

/**
 * @author Aaron aaronzheng9603@gmail.com
 */
public final class NetworkUtil {

    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    public static boolean isConnected() {
        return NetworkUtils.isConnected();
    }

    private NetworkUtil() {}
}
