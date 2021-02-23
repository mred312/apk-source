package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class Rotate extends BitmapTransformation {

    /* renamed from: b */
    private static final byte[] f6162b = "com.bumptech.glide.load.resource.bitmap.Rotate".getBytes(Key.CHARSET);

    /* renamed from: a */
    private final int f6163a;

    public Rotate(int i) {
        this.f6163a = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Rotate) || this.f6163a != ((Rotate) obj).f6163a) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Util.hashCode(-950519196, Util.hashCode(this.f6163a));
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        return TransformationUtils.rotateImage(bitmap, this.f6163a);
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f6162b);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f6163a).array());
    }
}
