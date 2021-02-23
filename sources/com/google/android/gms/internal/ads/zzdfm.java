package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdfm<T> implements zzepf<zzdfl<T>> {

    /* renamed from: a */
    private final zzeps<Executor> f15535a;

    /* renamed from: b */
    private final zzeps<Set<zzdfi<? extends zzdfj<T>>>> f15536b;

    private zzdfm(zzeps<Executor> zzeps, zzeps<Set<zzdfi<? extends zzdfj<T>>>> zzeps2) {
        this.f15535a = zzeps;
        this.f15536b = zzeps2;
    }

    public static <T> zzdfl<T> zza(Executor executor, Set<zzdfi<? extends zzdfj<T>>> set) {
        return new zzdfl<>(executor, set);
    }

    public static <T> zzdfm<T> zzbi(zzeps<Executor> zzeps, zzeps<Set<zzdfi<? extends zzdfj<T>>>> zzeps2) {
        return new zzdfm<>(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return zza(this.f15535a.get(), this.f15536b.get());
    }
}
