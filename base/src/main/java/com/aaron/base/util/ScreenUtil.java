package com.aaron.base.util;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.blankj.utilcode.util.ScreenUtils;

/**
 * @author Aaron aaronzheng9603@gmail.com
 */
public final class ScreenUtil {

    public static int getScreenWidth() {
        return ScreenUtils.getScreenWidth();
    }

    public static int getScreenHeight() {
        return ScreenUtils.getScreenHeight();
    }

    public static float getScreenDensity() {
        return ScreenUtils.getScreenDensity();
    }

    public static float getScreenDensityDpi() {
        return ScreenUtils.getScreenDensityDpi();
    }

    public static void setFullScreen(Activity activity, boolean fullScreen) {
        View decorView = activity.getWindow().getDecorView();
        if (fullScreen) {
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        } else {
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    public static void setImmersiveFullScreen(Activity activity, boolean fullScreen) {
        View decorView = activity.getWindow().getDecorView();
        if (fullScreen) {
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        } else {
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
    }

    private ScreenUtil() {}
}
