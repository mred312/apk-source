package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcjc implements zzepf<zzbxy<zzbsm>> {

    /* renamed from: a */
    private final zzeps<zzcjj> f14457a;

    /* renamed from: b */
    private final zzeps<Executor> f14458b;

    private zzcjc(zzeps<zzcjj> zzeps, zzeps<Executor> zzeps2) {
        this.f14457a = zzeps;
        this.f14458b = zzeps2;
    }

    public static zzcjc zzad(zzeps<zzcjj> zzeps, zzeps<Executor> zzeps2) {
        return new zzcjc(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f14457a.get(), this.f14458b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
