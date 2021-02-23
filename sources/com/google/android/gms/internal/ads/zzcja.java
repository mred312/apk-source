package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcja implements zzepf<zzbxy<zzva>> {

    /* renamed from: a */
    private final zzeps<zzcjj> f14453a;

    /* renamed from: b */
    private final zzeps<Executor> f14454b;

    private zzcja(zzeps<zzcjj> zzeps, zzeps<Executor> zzeps2) {
        this.f14453a = zzeps;
        this.f14454b = zzeps2;
    }

    public static zzcja zzab(zzeps<zzcjj> zzeps, zzeps<Executor> zzeps2) {
        return new zzcja(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f14453a.get(), this.f14454b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
