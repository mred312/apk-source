package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzclm implements zzepf<Set<zzbxy<zzva>>> {

    /* renamed from: a */
    private final zzeps<zzcln> f14553a;

    /* renamed from: b */
    private final zzeps<Executor> f14554b;

    private zzclm(zzcld zzcld, zzeps<zzcln> zzeps, zzeps<Executor> zzeps2) {
        this.f14553a = zzeps;
        this.f14554b = zzeps2;
    }

    public static zzclm zzg(zzcld zzcld, zzeps<zzcln> zzeps, zzeps<Executor> zzeps2) {
        return new zzclm(zzcld, zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(zzcld.zzg(this.f14553a.get(), this.f14554b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
