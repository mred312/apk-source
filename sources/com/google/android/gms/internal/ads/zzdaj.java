package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdaj implements zzepf<zzdae> {

    /* renamed from: a */
    private final zzeps<zzdyz<String>> f15133a;

    /* renamed from: b */
    private final zzeps<Executor> f15134b;

    private zzdaj(zzeps<zzdyz<String>> zzeps, zzeps<Executor> zzeps2) {
        this.f15133a = zzeps;
        this.f15134b = zzeps2;
    }

    public static zzdaj zzay(zzeps<zzdyz<String>> zzeps, zzeps<Executor> zzeps2) {
        return new zzdaj(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzdae(this.f15133a.get(), this.f15134b.get());
    }
}
