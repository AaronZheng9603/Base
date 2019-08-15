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
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.util.concurrent.ExecutionException;

/**
 * @author Aaron aaronzheng9603@gmail.com
 */
public final class GlideBitmapReqLoader implements IReqLoader<Bitmap> {

    private static RequestBuilder<Bitmap> sRequestBuilder;

    @Override
    public IReqLoader<Bitmap> load(String string) {
        sRequestBuilder = sRequestBuilder.load(string);
        return this;
    }

    @Override
    public IReqLoader<Bitmap> load(Uri uri) {
        sRequestBuilder = sRequestBuilder.load(uri);
        return this;
    }

    @Override
    public IReqLoader<Bitmap> load(Bitmap bitmap) {
        sRequestBuilder = sRequestBuilder.load(bitmap);
        return this;
    }

    @Override
    public IReqLoader<Bitmap> load(File file) {
        sRequestBuilder = sRequestBuilder.load(file);
        return this;
    }

    @Override
    public IReqLoader<Bitmap> load(Drawable drawable) {
        sRequestBuilder = sRequestBuilder.load(drawable);
        return this;
    }

    @Override
    public IReqLoader<Bitmap> load(int drawableRes) {
        sRequestBuilder = sRequestBuilder.load(drawableRes);
        return this;
    }

    @Override
    public IReqLoader<Bitmap> crossFade() {
        sRequestBuilder = sRequestBuilder.transition(BitmapTransitionOptions.withCrossFade());
        return this;
    }

    @Override
    public IReqLoader<Bitmap> crossFade(int duration) {
        sRequestBuilder = sRequestBuilder.transition(BitmapTransitionOptions.withCrossFade(duration));
        return this;
    }

    @Override
    public IReqLoader<Bitmap> placeholder(Drawable placeholder) {
        sRequestBuilder = sRequestBuilder.placeholder(placeholder);
        return this;
    }

    @Override
    public IReqLoader<Bitmap> placeholder(int drawableRes) {
        sRequestBuilder = sRequestBuilder.placeholder(drawableRes);
        return this;
    }

    @Override
    public IReqLoader<Bitmap> error(Drawable error) {
        sRequestBuilder = sRequestBuilder.error(error);
        return this;
    }

    @Override
    public IReqLoader<Bitmap> error(int drawableRes) {
        sRequestBuilder = sRequestBuilder.error(drawableRes);
        return this;
    }

    @Override
    public IReqLoader<Bitmap> listener(IReqListener<Bitmap> listener) {
        sRequestBuilder = sRequestBuilder.listener(new RequestListener<Bitmap>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                return listener.onFailure(e);
            }

            @Override
            public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                return listener.onSuccess(resource);
            }
        });
        return this;
    }

    @Override
    public IReqLoader<Bitmap> override(int resizeX, int resizeY) {
        sRequestBuilder = sRequestBuilder.override(resizeX, resizeY);
        return this;
    }

    @Override
    public IReqLoader<Bitmap> fitCenter() {
        sRequestBuilder = sRequestBuilder.fitCenter();
        return this;
    }

    @Override
    public IReqLoader<Bitmap> centerInside() {
        sRequestBuilder = sRequestBuilder.centerInside();
        return this;
    }

    @Override
    public IReqLoader<Bitmap> centerCrop() {
        sRequestBuilder = sRequestBuilder.centerCrop();
        return this;
    }

    @Override
    public IReqLoader<Bitmap> circleCrop() {
        sRequestBuilder = sRequestBuilder.circleCrop();
        return this;
    }

    @Override
    public IReqLoader<Bitmap> skipMemoryCache(boolean skip) {
        sRequestBuilder = sRequestBuilder.skipMemoryCache(skip);
        return this;
    }

    @Override
    public IReqLoader<Bitmap> skipDiskCache(boolean skip) {
        DiskCacheStrategy strategy = skip ? DiskCacheStrategy.NONE : DiskCacheStrategy.AUTOMATIC;
        sRequestBuilder = sRequestBuilder.diskCacheStrategy(strategy);
        return this;
    }

    @Override
    public IReqLoader<Bitmap> thumbnail(float sizeMultiply) {
        sRequestBuilder = sRequestBuilder.thumbnail(sizeMultiply);
        return this;
    }

    @Override
    public Bitmap get() throws ExecutionException, InterruptedException {
        Bitmap resource = sRequestBuilder.submit().get();
        sRequestBuilder = null;
        return resource;
    }

    @Override
    public void into(ImageView target) {
        sRequestBuilder.into(target);
        sRequestBuilder = null;
    }

    public static GlideBitmapReqLoader getInstance(RequestBuilder<Bitmap> builder) {
        sRequestBuilder = builder.dontAnimate();
        return Holder.INSTANCE;
    }

    private GlideBitmapReqLoader() {}

    private static class Holder {
        private static final GlideBitmapReqLoader INSTANCE = new GlideBitmapReqLoader();
    }
}
