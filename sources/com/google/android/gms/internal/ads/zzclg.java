package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzclg implements zzepf<Set<zzbxy<zzbru>>> {

    /* renamed from: a */
    private final zzeps<zzcln> f14542a;

    /* renamed from: b */
    private final zzeps<Executor> f14543b;

    private zzclg(zzcld zzcld, zzeps<zzcln> zzeps, zzeps<Executor> zzeps2) {
        this.f14542a = zzeps;
        this.f14543b = zzeps2;
    }

    public static zzclg zzb(zzcld zzcld, zzeps<zzcln> zzeps, zzeps<Executor> zzeps2) {
        return new zzclg(zzcld, zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(zzcld.zze(this.f14542a.get(), this.f14543b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
