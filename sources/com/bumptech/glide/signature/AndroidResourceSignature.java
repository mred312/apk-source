package com.bumptech.glide.signature;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class AndroidResourceSignature implements Key {

    /* renamed from: a */
    private final int f6479a;

    /* renamed from: b */
    private final Key f6480b;

    private AndroidResourceSignature(int i, Key key) {
        this.f6479a = i;
        this.f6480b = key;
    }

    @NonNull
    public static Key obtain(@NonNull Context context) {
        return new AndroidResourceSignature(context.getResources().getConfiguration().uiMode & 48, ApplicationVersionSignature.obtain(context));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AndroidResourceSignature)) {
            return false;
        }
        AndroidResourceSignature androidResourceSignature = (AndroidResourceSignature) obj;
        if (this.f6479a != androidResourceSignature.f6479a || !this.f6480b.equals(androidResourceSignature.f6480b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Util.hashCode((Object) this.f6480b, this.f6479a);
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.f6480b.updateDiskCacheKey(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f6479a).array());
    }
}
