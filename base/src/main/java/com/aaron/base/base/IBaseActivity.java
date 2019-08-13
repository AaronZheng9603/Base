package com.aaron.base.base;

import androidx.annotation.AnimRes;

/**
 * BaseActivity 扩展功能接口，详情看 {@link BaseActivity}。
 *
 * @author Aaron aaronzheng9603@gmail.com
 */
public interface IBaseActivity {

    /**
     * 是否禁止响应系统字体变化，子类调用
     *
     * @param yes 是否禁止系统可以修改 App 字体大小
     */
    void forbidScaleTextSize(boolean yes);

    /**
     * 入场动画，子类调用
     *
     * @param enterAnim startActivity 的入场动画
     * @param exitAnim  startActivity 的退场动画
     */
    void startAnim(@AnimRes int enterAnim, @AnimRes int exitAnim);

    /**
     * 退场动画，子类调用
     *
     * @param enterAnim finish 后的入场动画
     * @param exitAnim  finish 后的退场动画
     */
    void finishAnim(@AnimRes int enterAnim, @AnimRes int exitAnim);
}
