package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcje implements zzepf<zzbxy<zzbtj>> {

    /* renamed from: a */
    private final zzeps<zzcjj> f14461a;

    /* renamed from: b */
    private final zzeps<Executor> f14462b;

    private zzcje(zzeps<zzcjj> zzeps, zzeps<Executor> zzeps2) {
        this.f14461a = zzeps;
        this.f14462b = zzeps2;
    }

    public static zzcje zzaf(zzeps<zzcjj> zzeps, zzeps<Executor> zzeps2) {
        return new zzcje(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f14461a.get(), this.f14462b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
