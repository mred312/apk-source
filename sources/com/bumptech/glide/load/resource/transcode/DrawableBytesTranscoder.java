package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;

public final class DrawableBytesTranscoder implements ResourceTranscoder<Drawable, byte[]> {

    /* renamed from: a */
    private final BitmapPool f6246a;

    /* renamed from: b */
    private final ResourceTranscoder<Bitmap, byte[]> f6247b;

    /* renamed from: c */
    private final ResourceTranscoder<GifDrawable, byte[]> f6248c;

    public DrawableBytesTranscoder(@NonNull BitmapPool bitmapPool, @NonNull ResourceTranscoder<Bitmap, byte[]> resourceTranscoder, @NonNull ResourceTranscoder<GifDrawable, byte[]> resourceTranscoder2) {
        this.f6246a = bitmapPool;
        this.f6247b = resourceTranscoder;
        this.f6248c = resourceTranscoder2;
    }

    @NonNull
    /* renamed from: a */
    private static Resource<GifDrawable> m4617a(@NonNull Resource<Drawable> resource) {
        return resource;
    }

    @Nullable
    public Resource<byte[]> transcode(@NonNull Resource<Drawable> resource, @NonNull Options options) {
        Drawable drawable = resource.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f6247b.transcode(BitmapResource.obtain(((BitmapDrawable) drawable).getBitmap(), this.f6246a), options);
        }
        if (!(drawable instanceof GifDrawable)) {
            return null;
        }
        ResourceTranscoder<GifDrawable, byte[]> resourceTranscoder = this.f6248c;
        m4617a(resource);
        return resourceTranscoder.transcode(resource, options);
    }
}
