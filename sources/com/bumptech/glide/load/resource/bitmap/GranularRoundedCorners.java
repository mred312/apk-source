package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class GranularRoundedCorners extends BitmapTransformation {

    /* renamed from: e */
    private static final byte[] f6139e = "com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners".getBytes(Key.CHARSET);

    /* renamed from: a */
    private final float f6140a;

    /* renamed from: b */
    private final float f6141b;

    /* renamed from: c */
    private final float f6142c;

    /* renamed from: d */
    private final float f6143d;

    public GranularRoundedCorners(float f, float f2, float f3, float f4) {
        this.f6140a = f;
        this.f6141b = f2;
        this.f6142c = f3;
        this.f6143d = f4;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GranularRoundedCorners)) {
            return false;
        }
        GranularRoundedCorners granularRoundedCorners = (GranularRoundedCorners) obj;
        if (this.f6140a == granularRoundedCorners.f6140a && this.f6141b == granularRoundedCorners.f6141b && this.f6142c == granularRoundedCorners.f6142c && this.f6143d == granularRoundedCorners.f6143d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Util.hashCode(this.f6143d, Util.hashCode(this.f6142c, Util.hashCode(this.f6141b, Util.hashCode(-2013597734, Util.hashCode(this.f6140a)))));
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        return TransformationUtils.roundedCorners(bitmapPool, bitmap, this.f6140a, this.f6141b, this.f6142c, this.f6143d);
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f6139e);
        messageDigest.update(ByteBuffer.allocate(16).putFloat(this.f6140a).putFloat(this.f6141b).putFloat(this.f6142c).putFloat(this.f6143d).array());
    }
}
