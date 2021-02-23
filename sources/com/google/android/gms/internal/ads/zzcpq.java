package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcpq implements zzepf<zzbxy<zzdru>> {

    /* renamed from: a */
    private final zzeps<zzcqc> f14683a;

    /* renamed from: b */
    private final zzeps<Executor> f14684b;

    private zzcpq(zzeps<zzcqc> zzeps, zzeps<Executor> zzeps2) {
        this.f14683a = zzeps;
        this.f14684b = zzeps2;
    }

    public static zzcpq zzaw(zzeps<zzcqc> zzeps, zzeps<Executor> zzeps2) {
        return new zzcpq(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f14683a.get(), this.f14684b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
