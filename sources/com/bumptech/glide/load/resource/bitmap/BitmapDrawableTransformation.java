package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

@Deprecated
public class BitmapDrawableTransformation implements Transformation<BitmapDrawable> {

    /* renamed from: a */
    private final Transformation<Drawable> f6110a;

    public BitmapDrawableTransformation(Transformation<Bitmap> transformation) {
        this.f6110a = (Transformation) Preconditions.checkNotNull(new DrawableTransformation(transformation, false));
    }

    /* renamed from: a */
    private static Resource<BitmapDrawable> m4496a(Resource<Drawable> resource) {
        if (resource.get() instanceof BitmapDrawable) {
            return resource;
        }
        throw new IllegalArgumentException("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: " + resource.get());
    }

    /* renamed from: b */
    private static Resource<Drawable> m4497b(Resource<BitmapDrawable> resource) {
        return resource;
    }

    public boolean equals(Object obj) {
        if (obj instanceof BitmapDrawableTransformation) {
            return this.f6110a.equals(((BitmapDrawableTransformation) obj).f6110a);
        }
        return false;
    }

    public int hashCode() {
        return this.f6110a.hashCode();
    }

    @NonNull
    public Resource<BitmapDrawable> transform(@NonNull Context context, @NonNull Resource<BitmapDrawable> resource, int i, int i2) {
        m4497b(resource);
        Resource<Drawable> transform = this.f6110a.transform(context, resource, i, i2);
        m4496a(transform);
        return transform;
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.f6110a.updateDiskCacheKey(messageDigest);
    }
}
