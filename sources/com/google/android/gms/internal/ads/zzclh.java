package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzclh implements zzepf<Set<zzbxy<zzbtj>>> {

    /* renamed from: a */
    private final zzcld f14544a;

    /* renamed from: b */
    private final zzeps<zzcln> f14545b;

    /* renamed from: c */
    private final zzeps<Executor> f14546c;

    private zzclh(zzcld zzcld, zzeps<zzcln> zzeps, zzeps<Executor> zzeps2) {
        this.f14544a = zzcld;
        this.f14545b = zzeps;
        this.f14546c = zzeps2;
    }

    public static Set<zzbxy<zzbtj>> zza(zzcld zzcld, zzcln zzcln, Executor executor) {
        return (Set) zzepl.zza(zzcld.zzc(zzcln, executor), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static zzclh zzc(zzcld zzcld, zzeps<zzcln> zzeps, zzeps<Executor> zzeps2) {
        return new zzclh(zzcld, zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return zza(this.f14544a, this.f14545b.get(), this.f14546c.get());
    }
}
