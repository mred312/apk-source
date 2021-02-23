package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbvt implements zzepf<zzbvr> {

    /* renamed from: a */
    private final zzeps<Set<zzbxy<zzbvs>>> f13789a;

    private zzbvt(zzeps<Set<zzbxy<zzbvs>>> zzeps) {
        this.f13789a = zzeps;
    }

    public static zzbvt zzp(zzeps<Set<zzbxy<zzbvs>>> zzeps) {
        return new zzbvt(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbvr(this.f13789a.get());
    }
}
