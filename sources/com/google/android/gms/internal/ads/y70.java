package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class y70 extends ThreadLocal<Mac> {

    /* renamed from: a */
    private final /* synthetic */ zzehw f11994a;

    y70(zzehw zzehw) {
        this.f11994a = zzehw;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final Mac initialValue() {
        try {
            Mac zzhq = zzehh.zzihe.zzhq(this.f11994a.f16181b);
            zzhq.init(this.f11994a.f16182c);
            return zzhq;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
