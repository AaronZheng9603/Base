package com.aaron.baselib.util;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import androidx.core.content.FileProvider;
import com.blankj.utilcode.util.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Aaron
 * @email aaronzheng9603@gmail.com
 * @date 2019/8/12
 */
public final class FileUtil {

    public static void notifyMedia(Context context, String path, String authority) {
        // 通知相册更新
        File file = new File(path);
        MediaStore.Images.Media.insertImage(context.getContentResolver(), BitmapFactory.decodeFile(file.getAbsolutePath()), file.getName(), null);
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri uri = getUri(context, authority, file);
        intent.setData(uri);
        context.sendBroadcast(intent);
    }

    public static boolean isFileExists(String path) {
        return FileUtils.isFileExists(path);
    }

    public static Uri getUri(Context context, String authority, File file) {
        Uri uri;
        if (Build.VERSION.SDK_INT >= 24) {
            uri = FileProvider.getUriForFile(context, authority, file);
        } else {
            uri = Uri.fromFile(file);
        }
        return uri;
    }

    public static String getPathFromUri(Context context, Uri uri) {
        String path = "";
        if (Build.VERSION.SDK_INT > 19) {
            if (DocumentsContract.isDocumentUri(context, uri)) {
                String docId = DocumentsContract.getDocumentId(uri);
                if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                    String id = docId.split(":")[1]; // 解除数字格式id
                    String selection = MediaStore.Images.Media._ID + "=" + id;
                    path = getPath(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);

                } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                    Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(docId));
                    path = getPath(context, contentUri, null);
                }

            } else if ("content".equalsIgnoreCase(uri.getScheme())) {
                path = getPath(context, uri, null);

            } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                path = uri.getPath();
            }
        } else {
            getPath(context, uri, null);
        }
        return path;
    }

    public static String getPath(Context context, Uri uri, String selection) {
        String path = "";
        Cursor cursor = context.getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            cursor.close();
        }
        return path;
    }

    public static String saveBitmap(Bitmap bitmap, String path) throws IOException {
        File file = new File(path);
        if (isFileExists(path)) file.delete();
        FileOutputStream out = new FileOutputStream(file);
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
        out.flush();
        out.close();
        return path;
    }

    public static void deleteFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    deleteFile(files[i]);
                }
            }
            file.delete();
        }
    }

    private FileUtil() {

    }
}
