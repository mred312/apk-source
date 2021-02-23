package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcpo implements zzepf<zzbxy<zzbrz>> {

    /* renamed from: a */
    private final zzeps<zzcpv> f14681a;

    /* renamed from: b */
    private final zzeps<Executor> f14682b;

    private zzcpo(zzeps<zzcpv> zzeps, zzeps<Executor> zzeps2) {
        this.f14681a = zzeps;
        this.f14682b = zzeps2;
    }

    public static zzcpo zzav(zzeps<zzcpv> zzeps, zzeps<Executor> zzeps2) {
        return new zzcpo(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f14681a.get(), this.f14682b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
