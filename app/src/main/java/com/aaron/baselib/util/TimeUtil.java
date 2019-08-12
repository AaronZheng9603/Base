package com.aaron.baselib.util;

import com.blankj.utilcode.util.TimeUtils;

import java.text.DateFormat;

/**
 * @author Aaron
 * @email aaronzheng9603@gmail.com
 * @date 2019/8/12
 */
public final class TimeUtil {

    public static String getNowString(DateFormat format) {
        return TimeUtils.getNowString(format);
    }
}
