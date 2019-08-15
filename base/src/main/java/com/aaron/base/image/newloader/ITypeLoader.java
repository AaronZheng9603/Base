package com.aaron.base.image.newloader;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;

import java.io.File;

/**
 * @author Aaron aaronzheng9603@gmail.com
 */
public interface ITypeLoader {

    IReqLoader<Drawable> asDrawable();

    IReqLoader<Bitmap> asBitmap();

    IReqLoader<File> asFile();

    IReqLoader<GifDrawable> asGif();

    IReqLoader<File> downloadOnly();
}
