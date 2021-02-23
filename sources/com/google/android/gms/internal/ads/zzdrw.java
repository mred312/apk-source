package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdrw implements zzepf<d00> {

    /* renamed from: a */
    private final zzeps<Set<zzbxy<zzdru>>> f15902a;

    private zzdrw(zzeps<Set<zzbxy<zzdru>>> zzeps) {
        this.f15902a = zzeps;
    }

    public static zzdrw zzar(zzeps<Set<zzbxy<zzdru>>> zzeps) {
        return new zzdrw(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new d00(this.f15902a.get());
    }
}
