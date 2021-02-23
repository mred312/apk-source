package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.engine.d */
/* compiled from: DataCacheKey */
final class C1228d implements Key {

    /* renamed from: a */
    private final Key f5806a;

    /* renamed from: b */
    private final Key f5807b;

    C1228d(Key key, Key key2) {
        this.f5806a = key;
        this.f5807b = key2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1228d)) {
            return false;
        }
        C1228d dVar = (C1228d) obj;
        if (!this.f5806a.equals(dVar.f5806a) || !this.f5807b.equals(dVar.f5807b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f5806a.hashCode() * 31) + this.f5807b.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f5806a + ", signature=" + this.f5807b + '}';
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.f5806a.updateDiskCacheKey(messageDigest);
        this.f5807b.updateDiskCacheKey(messageDigest);
    }
}
