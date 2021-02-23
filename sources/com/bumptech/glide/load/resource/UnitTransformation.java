package com.bumptech.glide.load.resource;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

public final class UnitTransformation<T> implements Transformation<T> {

    /* renamed from: a */
    private static final Transformation<?> f6104a = new UnitTransformation();

    private UnitTransformation() {
    }

    @NonNull
    public static <T> UnitTransformation<T> get() {
        return (UnitTransformation) f6104a;
    }

    @NonNull
    public Resource<T> transform(@NonNull Context context, @NonNull Resource<T> resource, int i, int i2) {
        return resource;
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
    }
}
