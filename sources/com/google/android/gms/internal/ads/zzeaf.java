package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzeaf {

    /* renamed from: a */
    private final zzefr f16095a;

    private zzeaf(zzefr zzefr) {
        this.f16095a = zzefr;
    }

    /* renamed from: a */
    static final zzeaf m8614a(zzefr zzefr) {
        if (zzefr != null && zzefr.zzbdu() > 0) {
            return new zzeaf(zzefr);
        }
        throw new GeneralSecurityException("empty keyset");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final zzefr mo17427b() {
        return this.f16095a;
    }

    public final String toString() {
        return n40.m6518a(this.f16095a).toString();
    }
}
