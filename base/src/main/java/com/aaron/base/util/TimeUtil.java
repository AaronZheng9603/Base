package com.aaron.base.util;

import com.blankj.utilcode.util.TimeUtils;

import java.text.DateFormat;

/**
 * @author Aaron aaronzheng9603@gmail.com
 */
public final class TimeUtil {

    public static String getNowString(DateFormat format) {
        return TimeUtils.getNowString(format);
    }
}
