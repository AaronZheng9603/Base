package com.aaron.baselib.base;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity 收集器，方便移除与实现一键退出，在 {@link BaseActivity} 中使用。
 *
 * @author Aaron
 * @email aaronzheng9603@gmail.com
 * @date 2019/8/12
 */
public final class ActivityCollector {

    private static List<Activity> sActivities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        sActivities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        sActivities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : sActivities) {
            if (!activity.isFinishing()) activity.finish();
        }
    }

    private ActivityCollector() {

    }
}
