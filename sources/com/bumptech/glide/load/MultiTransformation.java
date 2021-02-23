package com.bumptech.glide.load;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;

public class MultiTransformation<T> implements Transformation<T> {

    /* renamed from: a */
    private final Collection<? extends Transformation<T>> f5605a;

    @SafeVarargs
    public MultiTransformation(@NonNull Transformation<T>... transformationArr) {
        if (transformationArr.length != 0) {
            this.f5605a = Arrays.asList(transformationArr);
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    public boolean equals(Object obj) {
        if (obj instanceof MultiTransformation) {
            return this.f5605a.equals(((MultiTransformation) obj).f5605a);
        }
        return false;
    }

    public int hashCode() {
        return this.f5605a.hashCode();
    }

    @NonNull
    public Resource<T> transform(@NonNull Context context, @NonNull Resource<T> resource, int i, int i2) {
        Resource<T> resource2 = resource;
        for (Transformation transform : this.f5605a) {
            Resource<T> transform2 = transform.transform(context, resource2, i, i2);
            if (resource2 != null && !resource2.equals(resource) && !resource2.equals(transform2)) {
                resource2.recycle();
            }
            resource2 = transform2;
        }
        return resource2;
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        for (Transformation updateDiskCacheKey : this.f5605a) {
            updateDiskCacheKey.updateDiskCacheKey(messageDigest);
        }
    }

    public MultiTransformation(@NonNull Collection<? extends Transformation<T>> collection) {
        if (!collection.isEmpty()) {
            this.f5605a = collection;
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }
}
