package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class q70 extends ThreadLocal<Cipher> {
    q70() {
    }

    /* renamed from: a */
    private static Cipher m6707a() {
        try {
            return zzehh.zzihd.zzhq("AES/ECB/NOPADDING");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object initialValue() {
        return m6707a();
    }
}
