package com.medio.wallpaper;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class LibraryWallpaperBitmaps {
    public static final String LOG_NAME = "WallpaperBitmaps Library: ";
    public static final String LOG_PROV = "LibWallBitLog";

    public Bitmap prepareBitmap(Bitmap bitmap, WallpaperManager wallpaperManager, int i, int i2) {
        int i3 = i;
        int i4 = i2;
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int i5 = 0;
        if (i3 > width || i4 > height) {
            Bitmap bitmap2 = bitmap;
            int max = Math.max(0, i3 - width) / 2;
            int max2 = Math.max(0, i4 - height) / 2;
            int i6 = i3 < width ? width - i3 : 0;
            if (i4 < height) {
                i5 = height - i4;
            }
            Bitmap createBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
            int i7 = i6 / 2;
            int i8 = width - i6;
            int[] iArr = new int[(width * height)];
            int i9 = width;
            int i10 = i8;
            int i11 = height - i5;
            bitmap.getPixels(iArr, 0, i9, i7, i5 / 2, i10, i11);
            createBitmap.setPixels(iArr, 0, i9, max, max2, i10, i11);
            Log.i(LOG_PROV, "WallpaperBitmaps Library: : Inflated size of Bitmap to fit device height/width in prepareBitmap");
            return createBitmap;
        } else if (width > i3 || height > i4) {
            Bitmap createBitmap2 = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
            Rect rect = new Rect(0, 0, i3, i4);
            Rect rect2 = new Rect();
            if (width > i3) {
                int i12 = (width - i3) / 2;
                rect2 = new Rect(i12, 0, width - i12, height);
            } else if (height > i4) {
                int i13 = (height - i4) / 2;
                rect2 = new Rect(0, i13, width, height - i13);
            }
            new Canvas(createBitmap2).drawBitmap(bitmap, rect2, rect, (Paint) null);
            Log.i(LOG_PROV, "WallpaperBitmaps Library: Cropped size of Bitmap to fit device height/width in prepareBitmap");
            return createBitmap2;
        } else {
            Log.i(LOG_PROV, "WallpaperBitmaps Library: Did NOT inflate or crop Bitmap in prepareBitmap");
            return bitmap;
        }
    }

    public Bitmap scaleBitmap(Bitmap bitmap, String str, WallpaperManager wallpaperManager, DisplayMetrics displayMetrics, double d, double d2) {
        double d3;
        long round;
        long round2;
        String str2 = str;
        DisplayMetrics displayMetrics2 = displayMetrics;
        double height = (double) bitmap.getHeight();
        double width = (double) bitmap.getWidth();
        boolean equals = str.equals("height");
        double d4 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        if (equals) {
            Double.isNaN(height);
            Double.isNaN(width);
            round = Math.round(width * (d2 / height) * 1.0d);
        } else {
            if (str.equals("width")) {
                Double.isNaN(width);
                Double.isNaN(height);
                round2 = Math.round(height * (d / width) * 1.0d);
            } else {
                if (str.equals("autofit")) {
                    if (height >= width) {
                        Double.isNaN(height);
                        Double.isNaN(width);
                        double round3 = (double) Math.round(width * (d2 / height) * 1.0d);
                        int i = displayMetrics2.widthPixels;
                        if (round3 < ((double) i)) {
                            double d5 = (double) i;
                            Double.isNaN(d5);
                            Double.isNaN(round3);
                            d3 = (double) i;
                            d4 = (double) Math.round(d2 * (d5 / round3));
                        } else {
                            d4 = d2;
                            d3 = round3;
                        }
                    } else {
                        Double.isNaN(width);
                        Double.isNaN(height);
                        double round4 = (double) Math.round(height * (d / width) * 1.0d);
                        int i2 = displayMetrics2.heightPixels;
                        if (round4 < ((double) i2)) {
                            double d6 = (double) i2;
                            Double.isNaN(d6);
                            Double.isNaN(round4);
                            d4 = (double) i2;
                            d3 = (double) Math.round(d * (d6 / round4));
                        } else {
                            d4 = round4;
                            d3 = d;
                        }
                    }
                } else if (!str.equals("autofill")) {
                    d3 = 0.0d;
                } else if (height >= width) {
                    Double.isNaN(width);
                    Double.isNaN(height);
                    round2 = Math.round(height * (d / width) * 1.0d);
                } else {
                    Double.isNaN(height);
                    Double.isNaN(width);
                    round = Math.round(width * (d2 / height) * 1.0d);
                }
                int i3 = (int) d3;
                int i4 = (int) d4;
                Bitmap bitmap2 = bitmap;
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i3, i4, true);
                Log.i(LOG_PROV, "WallpaperBitmaps Library: Scaled Bitmap to fit width (" + i3 + "x" + i4 + ") in scaleBitmap, with aspect " + str);
                return createScaledBitmap;
            }
            d4 = (double) round2;
            d3 = d;
            int i32 = (int) d3;
            int i42 = (int) d4;
            Bitmap bitmap22 = bitmap;
            Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(bitmap, i32, i42, true);
            Log.i(LOG_PROV, "WallpaperBitmaps Library: Scaled Bitmap to fit width (" + i32 + "x" + i42 + ") in scaleBitmap, with aspect " + str);
            return createScaledBitmap2;
        }
        d3 = (double) round;
        d4 = d2;
        int i322 = (int) d3;
        int i422 = (int) d4;
        Bitmap bitmap222 = bitmap;
        Bitmap createScaledBitmap22 = Bitmap.createScaledBitmap(bitmap, i322, i422, true);
        Log.i(LOG_PROV, "WallpaperBitmaps Library: Scaled Bitmap to fit width (" + i322 + "x" + i422 + ") in scaleBitmap, with aspect " + str);
        return createScaledBitmap22;
    }
}
