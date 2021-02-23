package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbpu implements zzepf<zzbxy<zzbsm>> {

    /* renamed from: a */
    private final zzeps<zzbjv> f13638a;

    /* renamed from: b */
    private final zzeps<Executor> f13639b;

    private zzbpu(zzeps<zzbjv> zzeps, zzeps<Executor> zzeps2) {
        this.f13638a = zzeps;
        this.f13639b = zzeps2;
    }

    public static zzbpu zzj(zzeps<zzbjv> zzeps, zzeps<Executor> zzeps2) {
        return new zzbpu(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f13638a.get(), this.f13639b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
