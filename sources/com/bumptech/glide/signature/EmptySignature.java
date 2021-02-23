package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

public final class EmptySignature implements Key {

    /* renamed from: a */
    private static final EmptySignature f6482a = new EmptySignature();

    private EmptySignature() {
    }

    @NonNull
    public static EmptySignature obtain() {
        return f6482a;
    }

    public String toString() {
        return "EmptySignature";
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
    }
}
