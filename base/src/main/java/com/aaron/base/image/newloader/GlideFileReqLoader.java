package com.aaron.base.image.newloader;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.util.concurrent.ExecutionException;

/**
 * @author Aaron aaronzheng9603@gmail.com
 */
public final class GlideFileReqLoader implements IReqLoader<File> {

    private static RequestBuilder<File> sRequestBuilder;

    @Override
    public IReqLoader<File> load(String string) {
        sRequestBuilder = sRequestBuilder.load(string);
        return this;
    }

    @Override
    public IReqLoader<File> load(Uri uri) {
        sRequestBuilder = sRequestBuilder.load(uri);
        return this;
    }

    @Override
    public IReqLoader<File> load(Bitmap bitmap) {
        sRequestBuilder = sRequestBuilder.load(bitmap);
        return this;
    }

    @Override
    public IReqLoader<File> load(File file) {
        sRequestBuilder = sRequestBuilder.load(file);
        return this;
    }

    @Override
    public IReqLoader<File> load(Drawable drawable) {
        sRequestBuilder = sRequestBuilder.load(drawable);
        return this;
    }

    @Override
    public IReqLoader<File> load(int drawableRes) {
        sRequestBuilder = sRequestBuilder.load(drawableRes);
        return this;
    }

    @Override
    public IReqLoader<File> crossFade() {
        return this;
    }

    @Override
    public IReqLoader<File> crossFade(int duration) {
        return this;
    }

    @Override
    public IReqLoader<File> placeholder(Drawable placeholder) {
        sRequestBuilder = sRequestBuilder.placeholder(placeholder);
        return this;
    }

    @Override
    public IReqLoader<File> placeholder(int drawableRes) {
        sRequestBuilder = sRequestBuilder.placeholder(drawableRes);
        return this;
    }

    @Override
    public IReqLoader<File> error(Drawable error) {
        sRequestBuilder = sRequestBuilder.error(error);
        return this;
    }

    @Override
    public IReqLoader<File> error(int drawableRes) {
        sRequestBuilder = sRequestBuilder.error(drawableRes);
        return this;
    }

    @Override
    public IReqLoader<File> listener(IReqListener<File> listener) {
        sRequestBuilder = sRequestBuilder.listener(new RequestListener<File>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<File> target, boolean isFirstResource) {
                return listener.onFailure(e);
            }

            @Override
            public boolean onResourceReady(File resource, Object model, Target<File> target, DataSource dataSource, boolean isFirstResource) {
                return listener.onSuccess(resource);
            }
        });
        return this;
    }

    @Override
    public IReqLoader<File> override(int resizeX, int resizeY) {
        sRequestBuilder = sRequestBuilder.override(resizeX, resizeY);
        return this;
    }

    @Override
    public IReqLoader<File> fitCenter() {
        sRequestBuilder = sRequestBuilder.fitCenter();
        return this;
    }

    @Override
    public IReqLoader<File> centerInside() {
        sRequestBuilder = sRequestBuilder.centerInside();
        return this;
    }

    @Override
    public IReqLoader<File> centerCrop() {
        sRequestBuilder = sRequestBuilder.centerCrop();
        return this;
    }

    @Override
    public IReqLoader<File> circleCrop() {
        sRequestBuilder = sRequestBuilder.circleCrop();
        return this;
    }

    @Override
    public IReqLoader<File> skipMemoryCache(boolean skip) {
        sRequestBuilder = sRequestBuilder.skipMemoryCache(skip);
        return this;
    }

    @Override
    public IReqLoader<File> skipDiskCache(boolean skip) {
        DiskCacheStrategy strategy = skip ? DiskCacheStrategy.NONE : DiskCacheStrategy.AUTOMATIC;
        sRequestBuilder = sRequestBuilder.diskCacheStrategy(strategy);
        return this;
    }

    @Override
    public IReqLoader<File> thumbnail(float sizeMultiply) {
        sRequestBuilder = sRequestBuilder.thumbnail(sizeMultiply);
        return this;
    }

    @Override
    public File get() throws ExecutionException, InterruptedException {
        File resource = sRequestBuilder.submit().get();
        sRequestBuilder = null;
        return resource;
    }

    @Override
    public void into(ImageView target) {
        sRequestBuilder.into(target);
        sRequestBuilder = null;
    }

    public static GlideFileReqLoader getInstance(RequestBuilder<File> builder) {
        sRequestBuilder = builder.dontAnimate();
        return GlideFileReqLoader.Holder.INSTANCE;
    }

    private GlideFileReqLoader() {}

    private static class Holder {
        private static final GlideFileReqLoader INSTANCE = new GlideFileReqLoader();
    }
}
