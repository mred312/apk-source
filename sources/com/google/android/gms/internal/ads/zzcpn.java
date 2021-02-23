package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcpn implements zzepf<zzbxy<zzbtj>> {

    /* renamed from: a */
    private final zzeps<zzcpv> f14679a;

    /* renamed from: b */
    private final zzeps<Executor> f14680b;

    private zzcpn(zzeps<zzcpv> zzeps, zzeps<Executor> zzeps2) {
        this.f14679a = zzeps;
        this.f14680b = zzeps2;
    }

    public static zzcpn zzau(zzeps<zzcpv> zzeps, zzeps<Executor> zzeps2) {
        return new zzcpn(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f14679a.get(), this.f14680b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
