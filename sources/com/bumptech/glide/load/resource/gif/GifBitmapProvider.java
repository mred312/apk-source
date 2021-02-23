package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public final class GifBitmapProvider implements GifDecoder.BitmapProvider {

    /* renamed from: a */
    private final BitmapPool f6200a;
    @Nullable

    /* renamed from: b */
    private final ArrayPool f6201b;

    public GifBitmapProvider(BitmapPool bitmapPool) {
        this(bitmapPool, (ArrayPool) null);
    }

    @NonNull
    public Bitmap obtain(int i, int i2, @NonNull Bitmap.Config config) {
        return this.f6200a.getDirty(i, i2, config);
    }

    @NonNull
    public byte[] obtainByteArray(int i) {
        ArrayPool arrayPool = this.f6201b;
        if (arrayPool == null) {
            return new byte[i];
        }
        return (byte[]) arrayPool.get(i, byte[].class);
    }

    @NonNull
    public int[] obtainIntArray(int i) {
        ArrayPool arrayPool = this.f6201b;
        if (arrayPool == null) {
            return new int[i];
        }
        return (int[]) arrayPool.get(i, int[].class);
    }

    public void release(@NonNull Bitmap bitmap) {
        this.f6200a.put(bitmap);
    }

    public GifBitmapProvider(BitmapPool bitmapPool, @Nullable ArrayPool arrayPool) {
        this.f6200a = bitmapPool;
        this.f6201b = arrayPool;
    }

    public void release(@NonNull byte[] bArr) {
        ArrayPool arrayPool = this.f6201b;
        if (arrayPool != null) {
            arrayPool.put(bArr);
        }
    }

    public void release(@NonNull int[] iArr) {
        ArrayPool arrayPool = this.f6201b;
        if (arrayPool != null) {
            arrayPool.put(iArr);
        }
    }
}
