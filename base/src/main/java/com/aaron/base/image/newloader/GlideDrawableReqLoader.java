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
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.util.concurrent.ExecutionException;

/**
 * @author Aaron aaronzheng9603@gmail.com
 */
public final class GlideDrawableReqLoader implements IReqLoader<Drawable> {

    private static RequestBuilder<Drawable> sRequestBuilder;

    @Override
    public IReqLoader<Drawable> load(String string) {
        sRequestBuilder = sRequestBuilder.load(string);
        return this;
    }

    @Override
    public IReqLoader<Drawable> load(Uri uri) {
        sRequestBuilder = sRequestBuilder.load(uri);
        return this;
    }

    @Override
    public IReqLoader<Drawable> load(Bitmap bitmap) {
        sRequestBuilder = sRequestBuilder.load(bitmap);
        return this;
    }

    @Override
    public IReqLoader<Drawable> load(File file) {
        sRequestBuilder = sRequestBuilder.load(file);
        return this;
    }

    @Override
    public IReqLoader<Drawable> load(Drawable drawable) {
        sRequestBuilder = sRequestBuilder.load(drawable);
        return this;
    }

    @Override
    public IReqLoader<Drawable> load(int drawableRes) {
        sRequestBuilder = sRequestBuilder.load(drawableRes);
        return this;
    }

    @Override
    public IReqLoader<Drawable> crossFade() {
        sRequestBuilder = sRequestBuilder.transition(DrawableTransitionOptions.withCrossFade());
        return this;
    }

    @Override
    public IReqLoader<Drawable> crossFade(int duration) {
        sRequestBuilder = sRequestBuilder.transition(DrawableTransitionOptions.withCrossFade(duration));
        return this;
    }

    @Override
    public IReqLoader<Drawable> placeholder(Drawable placeholder) {
        sRequestBuilder = sRequestBuilder.placeholder(placeholder);
        return this;
    }

    @Override
    public IReqLoader<Drawable> placeholder(int drawableRes) {
        sRequestBuilder = sRequestBuilder.placeholder(drawableRes);
        return this;
    }

    @Override
    public IReqLoader<Drawable> error(Drawable error) {
        sRequestBuilder = sRequestBuilder.error(error);
        return this;
    }

    @Override
    public IReqLoader<Drawable> error(int drawableRes) {
        sRequestBuilder = sRequestBuilder.error(drawableRes);
        return this;
    }

    @Override
    public IReqLoader<Drawable> listener(IReqListener<Drawable> listener) {
        sRequestBuilder = sRequestBuilder.listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return listener.onFailure(e);
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                return listener.onSuccess(resource);
            }
        });
        return this;
    }

    @Override
    public IReqLoader<Drawable> override(int resizeX, int resizeY) {
        sRequestBuilder = sRequestBuilder.override(resizeX, resizeY);
        return this;
    }

    @Override
    public IReqLoader<Drawable> fitCenter() {
        sRequestBuilder = sRequestBuilder.fitCenter();
        return this;
    }

    @Override
    public IReqLoader<Drawable> centerInside() {
        sRequestBuilder = sRequestBuilder.centerInside();
        return this;
    }

    @Override
    public IReqLoader<Drawable> centerCrop() {
        sRequestBuilder = sRequestBuilder.centerCrop();
        return this;
    }

    @Override
    public IReqLoader<Drawable> circleCrop() {
        sRequestBuilder = sRequestBuilder.circleCrop();
        return this;
    }

    @Override
    public IReqLoader<Drawable> skipMemoryCache(boolean skip) {
        sRequestBuilder = sRequestBuilder.skipMemoryCache(skip);
        return this;
    }

    @Override
    public IReqLoader<Drawable> skipDiskCache(boolean skip) {
        DiskCacheStrategy strategy = skip ? DiskCacheStrategy.NONE : DiskCacheStrategy.AUTOMATIC;
        sRequestBuilder = sRequestBuilder.diskCacheStrategy(strategy);
        return this;
    }

    @Override
    public IReqLoader<Drawable> thumbnail(float sizeMultiply) {
        sRequestBuilder = sRequestBuilder.thumbnail(sizeMultiply);
        return this;
    }

    @Override
    public Drawable get() throws ExecutionException, InterruptedException {
        Drawable resource = sRequestBuilder.submit().get();
        sRequestBuilder = null;
        return resource;
    }

    @Override
    public void into(ImageView target) {
        sRequestBuilder.into(target);
        sRequestBuilder = null;
    }

    static GlideDrawableReqLoader getInstance(RequestBuilder<Drawable> builder) {
        sRequestBuilder = builder.dontAnimate();
        return Holder.INSTANCE;
    }

    private GlideDrawableReqLoader() {}

    private static class Holder {
        private static final GlideDrawableReqLoader INSTANCE = new GlideDrawableReqLoader();
    }
}
