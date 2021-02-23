package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbty implements zzepf<zzbtw> {

    /* renamed from: a */
    private final zzeps<Set<zzbxy<zzbub>>> f13767a;

    /* renamed from: b */
    private final zzeps<zzdmu> f13768b;

    private zzbty(zzeps<Set<zzbxy<zzbub>>> zzeps, zzeps<zzdmu> zzeps2) {
        this.f13767a = zzeps;
        this.f13768b = zzeps2;
    }

    public static zzbty zzv(zzeps<Set<zzbxy<zzbub>>> zzeps, zzeps<zzdmu> zzeps2) {
        return new zzbty(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzbtw(this.f13767a.get(), this.f13768b.get());
    }
}
