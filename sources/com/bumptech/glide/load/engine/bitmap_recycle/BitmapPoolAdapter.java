package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

public class BitmapPoolAdapter implements BitmapPool {
    public void clearMemory() {
    }

    @NonNull
    public Bitmap get(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    @NonNull
    public Bitmap getDirty(int i, int i2, Bitmap.Config config) {
        return get(i, i2, config);
    }

    public long getMaxSize() {
        return 0;
    }

    public void put(Bitmap bitmap) {
        bitmap.recycle();
    }

    public void setSizeMultiplier(float f) {
    }

    public void trimMemory(int i) {
    }
}
