package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class MediaStoreSignature implements Key {
    @NonNull

    /* renamed from: a */
    private final String f6483a;

    /* renamed from: b */
    private final long f6484b;

    /* renamed from: c */
    private final int f6485c;

    public MediaStoreSignature(@Nullable String str, long j, int i) {
        this.f6483a = str == null ? "" : str;
        this.f6484b = j;
        this.f6485c = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediaStoreSignature mediaStoreSignature = (MediaStoreSignature) obj;
        return this.f6484b == mediaStoreSignature.f6484b && this.f6485c == mediaStoreSignature.f6485c && this.f6483a.equals(mediaStoreSignature.f6483a);
    }

    public int hashCode() {
        long j = this.f6484b;
        return (((this.f6483a.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.f6485c;
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ByteBuffer.allocate(12).putLong(this.f6484b).putInt(this.f6485c).array());
        messageDigest.update(this.f6483a.getBytes(Key.CHARSET));
    }
}
