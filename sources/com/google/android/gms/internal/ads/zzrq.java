package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public abstract class zzrq {
    @Nullable

    /* renamed from: a */
    private static MessageDigest f16955a;
    protected Object mLock = new Object();

    /* access modifiers changed from: package-private */
    public abstract byte[] zzbp(String str);

    /* access modifiers changed from: protected */
    @Nullable
    public final MessageDigest zzmm() {
        synchronized (this.mLock) {
            MessageDigest messageDigest = f16955a;
            if (messageDigest != null) {
                return messageDigest;
            }
            for (int i = 0; i < 2; i++) {
                try {
                    f16955a = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            MessageDigest messageDigest2 = f16955a;
            return messageDigest2;
        }
    }
}
