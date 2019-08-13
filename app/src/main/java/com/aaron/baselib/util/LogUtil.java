package com.aaron.baselib.util;

import androidx.annotation.Nullable;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * @author Aaron
 * @email aaronzheng9603@gmail.com
 * @date 2019/8/13
 */
public final class LogUtil {

    private static boolean sEnable = true;

    static {
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, @Nullable String tag) {
                return sEnable;
            }
        });
    }

    public static void init(String tag) {
        Logger.t(tag);
    }

    public static void setEnabled(boolean enable) {
        sEnable = enable;
    }

    public static void v(String message, Object... obj) {
        Logger.v(message, obj);
    }

    public static void d(String message, Object... obj) {
        Logger.d(message, obj);
    }

    public static void i(String message, Object... obj) {
        Logger.i(message, obj);
    }

    public static void e(String message, Object... obj) {
        Logger.e(message, obj);
    }

    public static void w(String message, Object... obj) {
        Logger.w(message, obj);
    }

    public static void wtf(String message, Object... obj) {
        Logger.wtf(message, obj);
    }

    public static void json(String json) {
        Logger.json(json);
    }

    public static void xml(String xml) {
        Logger.xml(xml);
    }

    private LogUtil() {

    }
}
