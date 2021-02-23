package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class o70 extends ThreadLocal<Cipher> {
    o70() {
    }

    /* renamed from: a */
    private static Cipher m6575a() {
        try {
            return zzehh.zzihd.zzhq("AES/CTR/NoPadding");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object initialValue() {
        return m6575a();
    }
}
