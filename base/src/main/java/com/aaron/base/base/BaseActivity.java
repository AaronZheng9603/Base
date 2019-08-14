package com.aaron.base.base;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

/**
 * 所有业务 Activity 的基类，理论上应该都继承于它，统一管理。
 *
 * @author Aaron aaronzheng9603@gmail.com
 */
public abstract class BaseActivity extends AppCompatActivity implements IBaseActivity {

    static {
        // 设置启用 5.0 以下版本对矢量图形的支持
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    private boolean mForbidScaleTextSize;
    private int mStartEnterAnim  = -1;
    private int mStartExitAnim   = -1;
    private int mFinishEnterAnim = -1;
    private int mFinishExitAnim  = -1;

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        // 这里作用是决定能否随着系统字体大小变化而变化
        if (mForbidScaleTextSize && newConfig.fontScale != 1) {
            getResources();
        }
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public Resources getResources() {
        // 这里作用是决定能否随着系统字体大小变化而变化
        if (mForbidScaleTextSize) {
            Resources res = super.getResources();
            if (res.getConfiguration().fontScale != 1) {
                Configuration newConfig = new Configuration();
                newConfig.setToDefaults();
                res.updateConfiguration(newConfig, res.getDisplayMetrics());
            }
            return res;
        }
        return super.getResources();
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        // 指定入场动画
        if (mStartEnterAnim != -1 || mStartExitAnim != -1) {
            overridePendingTransition(mStartEnterAnim, mStartExitAnim);
        }
    }

    @Override
    public void finish() {
        super.finish();
        // 指定退场动画
        if (mFinishEnterAnim != -1 || mFinishExitAnim != -1) {
            overridePendingTransition(mFinishEnterAnim, mFinishExitAnim);
        }
    }

    @Override
    public void forbidScaleTextSize(boolean yes) {
        mForbidScaleTextSize = yes;
    }

    @Override
    public void startAnim(int enterAnim, int exitAnim) {
        mStartEnterAnim = enterAnim;
        mStartExitAnim = exitAnim;
    }

    @Override
    public void finishAnim(int enterAnim, int exitAnim) {
        mFinishEnterAnim = enterAnim;
        mFinishExitAnim = exitAnim;
    }
}
