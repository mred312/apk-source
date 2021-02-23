package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzckk implements zzepf<zzbxy<zzbtj>> {

    /* renamed from: a */
    private final zzeps<zzckg> f14501a;

    /* renamed from: b */
    private final zzeps<Executor> f14502b;

    private zzckk(zzeps<zzckg> zzeps, zzeps<Executor> zzeps2) {
        this.f14501a = zzeps;
        this.f14502b = zzeps2;
    }

    public static zzckk zzan(zzeps<zzckg> zzeps, zzeps<Executor> zzeps2) {
        return new zzckk(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f14501a.get(), this.f14502b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
