package com.aaron.base.image.newloader;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;

import java.io.File;
import java.util.concurrent.ExecutionException;

/**
 * @author Aaron aaronzheng9603@gmail.com
 */
public interface IReqLoader<T> {

    IReqLoader<T> load(String string);

    IReqLoader<T> load(Uri uri);

    IReqLoader<T> load(Bitmap bitmap);

    IReqLoader<T> load(File file);

    IReqLoader<T> load(Drawable drawable);

    IReqLoader<T> load(@DrawableRes int drawableRes);

    IReqLoader<T> crossFade();

    IReqLoader<T> crossFade(int duration);

    IReqLoader<T> placeholder(Drawable placeholder);

    IReqLoader<T> placeholder(@DrawableRes int drawableRes);

    IReqLoader<T> error(Drawable error);

    IReqLoader<T> error(@DrawableRes int drawableRes);

    IReqLoader<T> listener(IReqListener<T> listener);

    IReqLoader<T> override(int resizeX, int resizeY);

    IReqLoader<T> fitCenter();

    IReqLoader<T> centerInside();

    IReqLoader<T> centerCrop();

    IReqLoader<T> circleCrop();

    IReqLoader<T> skipMemoryCache(boolean skip);

    IReqLoader<T> skipDiskCache(boolean skip);

    IReqLoader<T> thumbnail(float sizeMultiply);

    T get() throws ExecutionException, InterruptedException;

    void into(ImageView target);
}
