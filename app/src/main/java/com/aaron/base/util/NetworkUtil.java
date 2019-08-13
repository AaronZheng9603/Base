package com.aaron.base.util;

import android.Manifest;
import androidx.annotation.RequiresPermission;
import com.blankj.utilcode.util.NetworkUtils;

/**
 * @author Aaron
 * @email aaronzheng9603@gmail.com
 * @date 2019/8/12
 */
public final class NetworkUtil {

    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    public static boolean isConnected() {
        return NetworkUtils.isConnected();
    }

    private NetworkUtil() {}
}
