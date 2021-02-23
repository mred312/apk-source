package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzehx {

    /* renamed from: a */
    private static final ThreadLocal<SecureRandom> f16184a = new z70();

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static SecureRandom m8779a() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }

    public static byte[] zzfs(int i) {
        byte[] bArr = new byte[i];
        f16184a.get().nextBytes(bArr);
        return bArr;
    }
}
