package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

public final class Options implements Key {

    /* renamed from: a */
    private final ArrayMap<Option<?>, Object> f5611a = new CachedHashCodeArrayMap();

    /* renamed from: a */
    private static <T> void m4188a(@NonNull Option<T> option, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        option.update(obj, messageDigest);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Options) {
            return this.f5611a.equals(((Options) obj).f5611a);
        }
        return false;
    }

    @Nullable
    public <T> T get(@NonNull Option<T> option) {
        return this.f5611a.containsKey(option) ? this.f5611a.get(option) : option.getDefaultValue();
    }

    public int hashCode() {
        return this.f5611a.hashCode();
    }

    public void putAll(@NonNull Options options) {
        this.f5611a.putAll(options.f5611a);
    }

    @NonNull
    public <T> Options set(@NonNull Option<T> option, @NonNull T t) {
        this.f5611a.put(option, t);
        return this;
    }

    public String toString() {
        return "Options{values=" + this.f5611a + '}';
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        for (int i = 0; i < this.f5611a.size(); i++) {
            m4188a(this.f5611a.keyAt(i), this.f5611a.valueAt(i), messageDigest);
        }
    }
}
