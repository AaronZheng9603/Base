package com.aaron.base.util;

import com.blankj.utilcode.util.SPStaticUtils;

/**
 * @author Aaron aaronzheng9603@gmail.com
 */
public final class SpUtil {

    public static void put(String key, int value) {
        SPStaticUtils.put(key, value);
    }

    public static void put(String key, boolean value) {
        SPStaticUtils.put(key, value);
    }

    public static void put(String key, String value) {
        SPStaticUtils.put(key, value);
    }

    public static void put(String key, float value) {
        SPStaticUtils.put(key, value);
    }

    public static void put(String key, long value) {
        SPStaticUtils.put(key, value);
    }

    public static int getInt(String key, int defaultValue) {
        return SPStaticUtils.getInt(key, defaultValue);
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        return SPStaticUtils.getBoolean(key, defaultValue);
    }

    public static String getString(String key, String defaultValue) {
        return SPStaticUtils.getString(key, defaultValue);
    }

    public static float getFloat(String key, float defaultValue) {
        return SPStaticUtils.getFloat(key, defaultValue);
    }

    public static long getLong(String key, long defaultValue) {
        return SPStaticUtils.getLong(key, defaultValue);
    }

    public static void remove(String key) {
        SPStaticUtils.remove(key);
    }

    public static void clear() {
        SPStaticUtils.clear();
    }

    private SpUtil() {

    }
}
