package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzciz implements zzepf<zzbxy<zzbrz>> {

    /* renamed from: a */
    private final zzeps<zzcjj> f14451a;

    /* renamed from: b */
    private final zzeps<Executor> f14452b;

    private zzciz(zzeps<zzcjj> zzeps, zzeps<Executor> zzeps2) {
        this.f14451a = zzeps;
        this.f14452b = zzeps2;
    }

    public static zzciz zzaa(zzeps<zzcjj> zzeps, zzeps<Executor> zzeps2) {
        return new zzciz(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f14451a.get(), this.f14452b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
