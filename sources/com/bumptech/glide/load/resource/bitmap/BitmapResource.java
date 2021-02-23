package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;

public class BitmapResource implements Resource<Bitmap>, Initializable {

    /* renamed from: a */
    private final Bitmap f6113a;

    /* renamed from: b */
    private final BitmapPool f6114b;

    public BitmapResource(@NonNull Bitmap bitmap, @NonNull BitmapPool bitmapPool) {
        this.f6113a = (Bitmap) Preconditions.checkNotNull(bitmap, "Bitmap must not be null");
        this.f6114b = (BitmapPool) Preconditions.checkNotNull(bitmapPool, "BitmapPool must not be null");
    }

    @Nullable
    public static BitmapResource obtain(@Nullable Bitmap bitmap, @NonNull BitmapPool bitmapPool) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapResource(bitmap, bitmapPool);
    }

    @NonNull
    public Class<Bitmap> getResourceClass() {
        return Bitmap.class;
    }

    public int getSize() {
        return Util.getBitmapByteSize(this.f6113a);
    }

    public void initialize() {
        this.f6113a.prepareToDraw();
    }

    public void recycle() {
        this.f6114b.put(this.f6113a);
    }

    @NonNull
    public Bitmap get() {
        return this.f6113a;
    }
}
