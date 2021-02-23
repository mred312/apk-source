package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzclf implements zzepf<Set<zzbxy<zzbrz>>> {

    /* renamed from: a */
    private final zzeps<zzcln> f14540a;

    /* renamed from: b */
    private final zzeps<Executor> f14541b;

    private zzclf(zzcld zzcld, zzeps<zzcln> zzeps, zzeps<Executor> zzeps2) {
        this.f14540a = zzeps;
        this.f14541b = zzeps2;
    }

    public static zzclf zza(zzcld zzcld, zzeps<zzcln> zzeps, zzeps<Executor> zzeps2) {
        return new zzclf(zzcld, zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(zzcld.zzd(this.f14540a.get(), this.f14541b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
