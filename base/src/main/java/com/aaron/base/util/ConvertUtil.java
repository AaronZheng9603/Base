package com.aaron.base.util;

import com.blankj.utilcode.util.ConvertUtils;

/**
 * 尺寸转换器
 *
 * @author Aaron aaronzheng9603@gmail.com
 */
public final class ConvertUtil {

    public static int dp2px(float dpValue) {
        return ConvertUtils.dp2px(dpValue);
    }

    public static int px2dp(float pxValue) {
        return ConvertUtils.px2dp(pxValue);
    }

    public static int sp2px(float spValue) {
        return ConvertUtils.sp2px(spValue);
    }

    public static int px2sp(float pxValue) {
        return ConvertUtils.px2sp(pxValue);
    }

    private ConvertUtil() {

    }
}
