package com.aaron.base.base;

import android.app.Application;
import android.content.Context;

/**
 * Application 的父类。
 *
 * @author Aaron
 * @email aaronzheng9603@gmail.com
 * @date 2019/8/12
 */
public abstract class BaseApp extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        initModuleApp(this);
        initModuleData(this);
    }

    public static Context getContext() {
        return sContext;
    }

    public abstract void initModuleApp(Application app);

    public abstract void initModuleData(Application app);
}
