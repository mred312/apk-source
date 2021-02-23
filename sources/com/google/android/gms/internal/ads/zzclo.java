package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzclo implements zzepf<Set<zzbxy<zzdru>>> {

    /* renamed from: a */
    private final zzeps<zzcln> f14558a;

    /* renamed from: b */
    private final zzeps<Executor> f14559b;

    private zzclo(zzcld zzcld, zzeps<zzcln> zzeps, zzeps<Executor> zzeps2) {
        this.f14558a = zzeps;
        this.f14559b = zzeps2;
    }

    public static zzclo zzh(zzcld zzcld, zzeps<zzcln> zzeps, zzeps<Executor> zzeps2) {
        return new zzclo(zzcld, zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(zzcld.zzh(this.f14558a.get(), this.f14559b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
