package com.aaron.base.util;

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

import java.io.*;
import java.util.List;

/**
 * @author Aaron aaronzheng9603@gmail.com
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

    public static boolean isFileExists(File file) {
        return FileUtils.isFileExists(file);
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

    public static boolean saveBitmap(Bitmap bitmap, String path) {
        boolean success = false;
        File file = new File(path);
        if (isFileExists(new File(path))) file.delete();
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return success;
    }

    public static boolean deleteFile(File file) {
        return FileUtils.deleteFile(file);
    }

    public static boolean rename(File file, String newName) {
        return FileUtils.rename(file, newName);
    }

    public static boolean copyFile(File srcFile, File destFile) {
        return FileUtils.copyFile(srcFile, destFile);
    }

    public static boolean moveFile(File srcFile, File destFile) {
        return FileUtils.moveFile(srcFile, destFile);
    }

    public static boolean copyDir(File srcFile, File destFile) {
        return FileUtils.copyDir(srcFile, destFile);
    }

    public static boolean moveDir(File srcFile, File destFile) {
        return FileUtils.moveDir(srcFile, destFile);
    }

    public static boolean deleteDir(File file) {
        return FileUtils.deleteDir(file);
    }

    /**
     * 遍历
     *
     * @param file        目标
     * @param isRecursive 是否递归遍历子目录
     * @return            List of File
     */
    public static List<File> listFilesInDir(File file, boolean isRecursive) {
        return FileUtils.listFilesInDir(file, isRecursive);
    }

    public static boolean saveFile(File srcFile, File destFile) {
        boolean success = false;
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(srcFile);
            os = new FileOutputStream(destFile);
            BufferedInputStream bis = new BufferedInputStream(is);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = bis.read(buffer, 0, buffer.length)) != -1) {
                bos.write(buffer, 0, length);
            }
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
                if (os != null) {
                    os.flush();
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return success;
    }

    private FileUtil() {

    }
}
