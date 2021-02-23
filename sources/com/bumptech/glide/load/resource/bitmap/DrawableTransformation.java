package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class DrawableTransformation implements Transformation<Drawable> {

    /* renamed from: a */
    private final Transformation<Bitmap> f6136a;

    /* renamed from: b */
    private final boolean f6137b;

    public DrawableTransformation(Transformation<Bitmap> transformation, boolean z) {
        this.f6136a = transformation;
        this.f6137b = z;
    }

    /* renamed from: a */
    private Resource<Drawable> m4543a(Context context, Resource<Bitmap> resource) {
        return LazyBitmapDrawableResource.obtain(context.getResources(), resource);
    }

    public Transformation<BitmapDrawable> asBitmapDrawable() {
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DrawableTransformation) {
            return this.f6136a.equals(((DrawableTransformation) obj).f6136a);
        }
        return false;
    }

    public int hashCode() {
        return this.f6136a.hashCode();
    }

    @NonNull
    public Resource<Drawable> transform(@NonNull Context context, @NonNull Resource<Drawable> resource, int i, int i2) {
        BitmapPool bitmapPool = Glide.get(context).getBitmapPool();
        Drawable drawable = resource.get();
        Resource<Bitmap> a = C1318a.m4571a(bitmapPool, drawable, i, i2);
        if (a != null) {
            Resource<Bitmap> transform = this.f6136a.transform(context, a, i, i2);
            if (!transform.equals(a)) {
                return m4543a(context, transform);
            }
            transform.recycle();
            return resource;
        } else if (!this.f6137b) {
            return resource;
        } else {
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.f6136a.updateDiskCacheKey(messageDigest);
    }
}
