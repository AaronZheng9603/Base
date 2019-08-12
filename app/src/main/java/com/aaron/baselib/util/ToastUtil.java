package com.aaron.baselib.util;

import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;
import com.blankj.utilcode.util.ToastUtils;

/**
 * @author Aaron
 * @email aaronzheng9603@gmail.com
 * @date 2019/8/12
 */
public final class ToastUtil {

    public static void showShort(CharSequence text) {
        ToastUtils.showShort(text);
    }

    public static void showShort(@StringRes int strResId) {
        ToastUtils.showShort(strResId);
    }

    public static void showLong(CharSequence text) {
        ToastUtils.showLong(text);
    }

    public static void showLong(@StringRes int strResId) {
        ToastUtils.showLong(strResId);
    }

    public static View showCustomShort(@LayoutRes int layoutId) {
        return ToastUtils.showCustomShort(layoutId);
    }

    /**
     * Set the gravity.
     *
     * @param gravity The gravity.
     * @param xOffset X-axis offset, in pixel.
     * @param yOffset Y-axis offset, in pixel.
     */
    public static void setGravity(final int gravity, final int xOffset, final int yOffset) {
        ToastUtils.setGravity(gravity, xOffset, yOffset);
    }

    private ToastUtil() {

    }
}
