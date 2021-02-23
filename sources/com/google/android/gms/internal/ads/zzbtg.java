package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbtg implements zzepf<zzbte> {

    /* renamed from: a */
    private final zzeps<Set<zzbxy<zzbtj>>> f13760a;

    private zzbtg(zzeps<Set<zzbxy<zzbtj>>> zzeps) {
        this.f13760a = zzeps;
    }

    public static zzbtg zzl(zzeps<Set<zzbxy<zzbtj>>> zzeps) {
        return new zzbtg(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbte(this.f13760a.get());
    }
}
