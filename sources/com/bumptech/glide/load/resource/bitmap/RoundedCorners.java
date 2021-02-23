package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class RoundedCorners extends BitmapTransformation {

    /* renamed from: b */
    private static final byte[] f6164b = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(Key.CHARSET);

    /* renamed from: a */
    private final int f6165a;

    public RoundedCorners(int i) {
        Preconditions.checkArgument(i > 0, "roundingRadius must be greater than 0.");
        this.f6165a = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RoundedCorners) || this.f6165a != ((RoundedCorners) obj).f6165a) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Util.hashCode(-569625254, Util.hashCode(this.f6165a));
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        return TransformationUtils.roundedCorners(bitmapPool, bitmap, this.f6165a);
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f6164b);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f6165a).array());
    }
}
