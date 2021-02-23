package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbmv implements zzepf<zzbxy<zzqu>> {

    /* renamed from: a */
    private final zzeps<zzbnx> f13520a;

    /* renamed from: b */
    private final zzeps<Executor> f13521b;

    public zzbmv(zzbmh zzbmh, zzeps<zzbnx> zzeps, zzeps<Executor> zzeps2) {
        this.f13520a = zzeps;
        this.f13521b = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f13520a.get(), this.f13521b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
