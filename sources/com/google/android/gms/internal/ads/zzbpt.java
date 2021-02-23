package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbpt implements zzepf<zzbxy<zzbtj>> {

    /* renamed from: a */
    private final zzeps<zzbjv> f13636a;

    /* renamed from: b */
    private final zzeps<Executor> f13637b;

    private zzbpt(zzeps<zzbjv> zzeps, zzeps<Executor> zzeps2) {
        this.f13636a = zzeps;
        this.f13637b = zzeps2;
    }

    public static zzbxy<zzbtj> zza(zzbjv zzbjv, Executor executor) {
        return (zzbxy) zzepl.zza(new zzbxy(zzbjv, executor), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static zzbpt zzi(zzeps<zzbjv> zzeps, zzeps<Executor> zzeps2) {
        return new zzbpt(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return zza(this.f13636a.get(), this.f13637b.get());
    }
}
