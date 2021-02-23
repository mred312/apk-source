package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzckj implements zzepf<zzbxy<zzdru>> {

    /* renamed from: a */
    private final zzeps<zzcku> f14499a;

    /* renamed from: b */
    private final zzeps<Executor> f14500b;

    private zzckj(zzeps<zzcku> zzeps, zzeps<Executor> zzeps2) {
        this.f14499a = zzeps;
        this.f14500b = zzeps2;
    }

    public static zzckj zzam(zzeps<zzcku> zzeps, zzeps<Executor> zzeps2) {
        return new zzckj(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f14499a.get(), this.f14500b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
