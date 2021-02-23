package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcjb implements zzepf<zzbxy<zzbwl>> {

    /* renamed from: a */
    private final zzeps<zzcjj> f14455a;

    /* renamed from: b */
    private final zzeps<Executor> f14456b;

    private zzcjb(zzeps<zzcjj> zzeps, zzeps<Executor> zzeps2) {
        this.f14455a = zzeps;
        this.f14456b = zzeps2;
    }

    public static zzcjb zzac(zzeps<zzcjj> zzeps, zzeps<Executor> zzeps2) {
        return new zzcjb(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f14455a.get(), this.f14456b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
