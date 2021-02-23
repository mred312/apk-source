package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcll implements zzepf<Set<zzbxy<zzbsm>>> {

    /* renamed from: a */
    private final zzeps<zzcln> f14551a;

    /* renamed from: b */
    private final zzeps<Executor> f14552b;

    private zzcll(zzcld zzcld, zzeps<zzcln> zzeps, zzeps<Executor> zzeps2) {
        this.f14551a = zzeps;
        this.f14552b = zzeps2;
    }

    public static zzcll zzf(zzcld zzcld, zzeps<zzcln> zzeps, zzeps<Executor> zzeps2) {
        return new zzcll(zzcld, zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(zzcld.zzf(this.f14551a.get(), this.f14552b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
