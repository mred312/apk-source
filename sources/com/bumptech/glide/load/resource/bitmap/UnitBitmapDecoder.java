package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Util;

public final class UnitBitmapDecoder implements ResourceDecoder<Bitmap, Bitmap> {

    /* renamed from: com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder$a */
    private static final class C1311a implements Resource<Bitmap> {

        /* renamed from: a */
        private final Bitmap f6180a;

        C1311a(@NonNull Bitmap bitmap) {
            this.f6180a = bitmap;
        }

        @NonNull
        /* renamed from: a */
        public Bitmap get() {
            return this.f6180a;
        }

        @NonNull
        public Class<Bitmap> getResourceClass() {
            return Bitmap.class;
        }

        public int getSize() {
            return Util.getBitmapByteSize(this.f6180a);
        }

        public void recycle() {
        }
    }

    public boolean handles(@NonNull Bitmap bitmap, @NonNull Options options) {
        return true;
    }

    public Resource<Bitmap> decode(@NonNull Bitmap bitmap, int i, int i2, @NonNull Options options) {
        return new C1311a(bitmap);
    }
}
