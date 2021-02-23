package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

public final class ObjectKey implements Key {

    /* renamed from: a */
    private final Object f6486a;

    public ObjectKey(@NonNull Object obj) {
        this.f6486a = Preconditions.checkNotNull(obj);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ObjectKey) {
            return this.f6486a.equals(((ObjectKey) obj).f6486a);
        }
        return false;
    }

    public int hashCode() {
        return this.f6486a.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f6486a + '}';
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f6486a.toString().getBytes(Key.CHARSET));
    }
}
