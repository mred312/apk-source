package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbsg implements zzepf<zzbsf> {

    /* renamed from: a */
    private final zzeps<Set<zzbxy<zzbsi>>> f13752a;

    private zzbsg(zzeps<Set<zzbxy<zzbsi>>> zzeps) {
        this.f13752a = zzeps;
    }

    public static zzbsg zzh(zzeps<Set<zzbxy<zzbsi>>> zzeps) {
        return new zzbsg(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbsf(this.f13752a.get());
    }
}
