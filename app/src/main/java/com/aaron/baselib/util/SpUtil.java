package com.aaron.baselib.util;

import com.blankj.utilcode.util.SPStaticUtils;

/**
 * @author Aaron
 * @email aaronzheng9603@gmail.com
 * @date 2019/8/12
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

    public static int getInt(String key) {
        return SPStaticUtils.getInt(key);
    }

    public static boolean getBoolean(String key) {
        return SPStaticUtils.getBoolean(key);
    }

    public static String getString(String key) {
        return SPStaticUtils.getString(key);
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
