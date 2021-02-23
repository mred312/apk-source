package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcjd implements zzepf<zzbxy<zzbui>> {

    /* renamed from: a */
    private final zzeps<zzcjj> f14459a;

    /* renamed from: b */
    private final zzeps<Executor> f14460b;

    private zzcjd(zzeps<zzcjj> zzeps, zzeps<Executor> zzeps2) {
        this.f14459a = zzeps;
        this.f14460b = zzeps2;
    }

    public static zzcjd zzae(zzeps<zzcjj> zzeps, zzeps<Executor> zzeps2) {
        return new zzcjd(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f14459a.get(), this.f14460b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
