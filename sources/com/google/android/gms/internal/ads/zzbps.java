package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbps implements zzepf<zzbxy<zzbru>> {

    /* renamed from: a */
    private final zzeps<zzbjv> f13634a;

    /* renamed from: b */
    private final zzeps<Executor> f13635b;

    private zzbps(zzeps<zzbjv> zzeps, zzeps<Executor> zzeps2) {
        this.f13634a = zzeps;
        this.f13635b = zzeps2;
    }

    public static zzbps zzh(zzeps<zzbjv> zzeps, zzeps<Executor> zzeps2) {
        return new zzbps(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f13634a.get(), this.f13635b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
