package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcjk implements zzepf<Set<zzbxy<zzdru>>> {

    /* renamed from: a */
    private final zzeps<Executor> f14465a;

    /* renamed from: b */
    private final zzeps<zzcka> f14466b;

    private zzcjk(zzeps<Executor> zzeps, zzeps<zzcka> zzeps2) {
        this.f14465a = zzeps;
        this.f14466b = zzeps2;
    }

    public static zzcjk zzag(zzeps<Executor> zzeps, zzeps<zzcka> zzeps2) {
        return new zzcjk(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        Set set;
        Executor executor = this.f14465a.get();
        zzcka zzcka = this.f14466b.get();
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcuc)).booleanValue()) {
            set = Collections.singleton(new zzbxy(zzcka, executor));
        } else {
            set = Collections.emptySet();
        }
        return (Set) zzepl.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }
}
