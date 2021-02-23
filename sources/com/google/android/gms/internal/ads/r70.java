package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class r70 extends ThreadLocal<Cipher> {
    r70() {
    }

    /* renamed from: a */
    private static Cipher m6798a() {
        try {
            return zzehh.zzihd.zzhq("AES/GCM/NoPadding");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object initialValue() {
        return m6798a();
    }
}
