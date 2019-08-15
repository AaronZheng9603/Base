package com.aaron.base.image.newloader;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.gif.GifDrawable;

import java.io.File;

/**
 * @author Aaron aaronzheng9603@gmail.com
 */
public final class GlideTypeLoader implements ITypeLoader {

    private static RequestManager sRequestManager;

    @Override
    public IReqLoader<Drawable> asDrawable() {
        RequestBuilder<Drawable> builder = sRequestManager.asDrawable();
        sRequestManager = null;
        return GlideDrawableReqLoader.getInstance(builder);
    }

    @Override
    public IReqLoader<Bitmap> asBitmap() {
        RequestBuilder<Bitmap> builder = sRequestManager.asBitmap();
        sRequestManager = null;
        return GlideBitmapReqLoader.getInstance(builder);
    }

    @Override
    public IReqLoader<File> asFile() {
        RequestBuilder<File> builder = sRequestManager.asFile();
        sRequestManager = null;
        return GlideFileReqLoader.getInstance(builder);
    }

    @Override
    public IReqLoader<GifDrawable> asGif() {
        return null;
    }

    @Override
    public IReqLoader<File> downloadOnly() {
        RequestBuilder<File> builder = sRequestManager.downloadOnly();
        sRequestManager = null;
        return GlideFileReqLoader.getInstance(builder);
    }

    static GlideTypeLoader getInstance(Context context) {
        sRequestManager = Glide.with(context);
        return Holder.INSTANCE;
    }

    static GlideTypeLoader getInstance(Activity activity) {
        sRequestManager = Glide.with(activity);
        return Holder.INSTANCE;
    }

    static GlideTypeLoader getInstance(Fragment fragment) {
        sRequestManager = Glide.with(fragment);
        return Holder.INSTANCE;
    }

    static GlideTypeLoader getInstance(View view) {
        sRequestManager = Glide.with(view);
        return Holder.INSTANCE;
    }

    private GlideTypeLoader() {}

    private static class Holder {
        private static final GlideTypeLoader INSTANCE = new GlideTypeLoader();
    }
}
