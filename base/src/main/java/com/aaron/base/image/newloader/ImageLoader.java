package com.aaron.base.image.newloader;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;

/**
 * @author Aaron aaronzheng9603@gmail.com
 */
public final class ImageLoader {

    public static ITypeLoader with(Context context) {
        return GlideTypeLoader.getInstance(context);
    }

    public static ITypeLoader with(Activity activity) {
        return GlideTypeLoader.getInstance(activity);
    }

    public static ITypeLoader with(Fragment fragment) {
        return GlideTypeLoader.getInstance(fragment);
    }

    public static ITypeLoader with(View view) {
        return GlideTypeLoader.getInstance(view);
    }

    private ImageLoader() {}
}
