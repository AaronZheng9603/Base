package com.aaron.base.util;

import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.PermissionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aaron
 * @email aaronzheng9603@gmail.com
 * @date 2019/8/12
 */
public final class PermissionUtil {

    private static boolean isGranted(String... permissions) {
        return PermissionUtils.isGranted(permissions);
    }

    public static void requestPermission(@PermissionConstants.Permission String[] permissions, Callback callback) {
        if (!PermissionUtils.isGranted(permissions)) {
            PermissionUtils.permission(permissions).callback(new PermissionUtils.FullCallback() {
                @Override
                public void onGranted(List<String> permissionsGranted) {
                    callback.onGranted(permissionsGranted);
                }

                @Override
                public void onDenied(List<String> permissionsDeniedForever, List<String> permissionsDenied) {
                    callback.onDenied(permissionsDeniedForever, permissionsDenied);
                }
            }).request();
        } else {
            List<String> permissionList = new ArrayList<>(Arrays.asList(permissions));
            callback.onGranted(permissionList);
        }
    }

    public static void launchAppDetailsSettings() {
        PermissionUtils.launchAppDetailsSettings();
    }

    public interface Callback {
        void onGranted(List<String> permissionsGranted);

        void onDenied(List<String> permissionsDeniedForever, List<String> permissionsDenied);
    }

    private PermissionUtil() {

    }
}
