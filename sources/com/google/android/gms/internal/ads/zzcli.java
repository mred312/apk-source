package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcli implements zzepf<Set<zzbxy<zzbsp>>> {

    /* renamed from: a */
    private final zzeps<zzcln> f14547a;

    /* renamed from: b */
    private final zzeps<Executor> f14548b;

    private zzcli(zzcld zzcld, zzeps<zzcln> zzeps, zzeps<Executor> zzeps2) {
        this.f14547a = zzeps;
        this.f14548b = zzeps2;
    }

    public static zzcli zzd(zzcld zzcld, zzeps<zzcln> zzeps, zzeps<Executor> zzeps2) {
        return new zzcli(zzcld, zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(zzcld.zza(this.f14547a.get(), this.f14548b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
