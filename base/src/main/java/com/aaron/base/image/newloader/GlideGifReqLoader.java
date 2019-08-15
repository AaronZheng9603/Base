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
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.util.concurrent.ExecutionException;

/**
 * @author Aaron aaronzheng9603@gmail.com
 */
public final class GlideGifReqLoader implements IReqLoader<GifDrawable> {

    private static RequestBuilder<GifDrawable> sRequestBuilder;

    @Override
    public IReqLoader<GifDrawable> load(String string) {
        sRequestBuilder = sRequestBuilder.load(string);
        return this;
    }

    @Override
    public IReqLoader<GifDrawable> load(Uri uri) {
        sRequestBuilder = sRequestBuilder.load(uri);
        return this;
    }

    @Override
    public IReqLoader<GifDrawable> load(Bitmap bitmap) {
        sRequestBuilder = sRequestBuilder.load(bitmap);
        return this;
    }

    @Override
    public IReqLoader<GifDrawable> load(File file) {
        sRequestBuilder = sRequestBuilder.load(file);
        return this;
    }

    @Override
    public IReqLoader<GifDrawable> load(Drawable drawable) {
        sRequestBuilder = sRequestBuilder.load(drawable);
        return this;
    }

    @Override
    public IReqLoader<GifDrawable> load(int drawableRes) {
        sRequestBuilder = sRequestBuilder.load(drawableRes);
        return this;
    }

    @Override
    public IReqLoader<GifDrawable> crossFade() {
        return this;
    }

    @Override
    public IReqLoader<GifDrawable> crossFade(int duration) {
        return this;
    }

    @Override
    public IReqLoader<GifDrawable> placeholder(Drawable placeholder) {
        sRequestBuilder = sRequestBuilder.placeholder(placeholder);
        return this;
    }

    @Override
    public IReqLoader<GifDrawable> placeholder(int drawableRes) {
        sRequestBuilder = sRequestBuilder.placeholder(drawableRes);
        return this;
    }

    @Override
    public IReqLoader<GifDrawable> error(Drawable error) {
        sRequestBuilder = sRequestBuilder.error(error);
        return this;
    }

    @Override
    public IReqLoader<GifDrawable> error(int drawableRes) {
        sRequestBuilder = sRequestBuilder.error(drawableRes);
        return this;
    }

    @Override
    public IReqLoader<GifDrawable> listener(IReqListener<GifDrawable> listener) {
        sRequestBuilder = sRequestBuilder.listener(new RequestListener<GifDrawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<GifDrawable> target, boolean isFirstResource) {
                return listener.onFailure(e);
            }

            @Override
            public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource) {
                return listener.onSuccess(resource);
            }
        });
        return this;
    }

    @Override
    public IReqLoader<GifDrawable> override(int resizeX, int resizeY) {
        sRequestBuilder = sRequestBuilder.override(resizeX, resizeY);
        return this;
    }

    @Override
    public IReqLoader<GifDrawable> fitCenter() {
        sRequestBuilder = sRequestBuilder.fitCenter();
        return this;
    }

    @Override
    public IReqLoader<GifDrawable> centerInside() {
        sRequestBuilder = sRequestBuilder.centerInside();
        return this;
    }

    @Override
    public IReqLoader<GifDrawable> centerCrop() {
        sRequestBuilder = sRequestBuilder.centerCrop();
        return this;
    }

    @Override
    public IReqLoader<GifDrawable> circleCrop() {
        sRequestBuilder = sRequestBuilder.circleCrop();
        return this;
    }

    @Override
    public IReqLoader<GifDrawable> skipMemoryCache(boolean skip) {
        sRequestBuilder = sRequestBuilder.skipMemoryCache(skip);
        return this;
    }

    @Override
    public IReqLoader<GifDrawable> skipDiskCache(boolean skip) {
        DiskCacheStrategy strategy = skip ? DiskCacheStrategy.NONE : DiskCacheStrategy.AUTOMATIC;
        sRequestBuilder = sRequestBuilder.diskCacheStrategy(strategy);
        return this;
    }

    @Override
    public IReqLoader<GifDrawable> thumbnail(float sizeMultiply) {
        sRequestBuilder = sRequestBuilder.thumbnail(sizeMultiply);
        return this;
    }

    @Override
    public GifDrawable get() throws ExecutionException, InterruptedException {
        GifDrawable resource = sRequestBuilder.submit().get();
        sRequestBuilder = null;
        return resource;
    }

    @Override
    public void into(ImageView target) {
        sRequestBuilder.into(target);
        sRequestBuilder = null;
    }

    public static GlideGifReqLoader getInstance(RequestBuilder<GifDrawable> builder) {
        sRequestBuilder = builder.dontAnimate();
        return GlideGifReqLoader.Holder.INSTANCE;
    }

    private GlideGifReqLoader() {}

    private static class Holder {
        private static final GlideGifReqLoader INSTANCE = new GlideGifReqLoader();
    }
}
