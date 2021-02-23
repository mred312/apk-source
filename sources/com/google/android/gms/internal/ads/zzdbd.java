package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdbd implements zzepf<zzday> {

    /* renamed from: a */
    private final zzeps<Executor> f15167a;

    /* renamed from: b */
    private final zzeps<zzayg> f15168b;

    private zzdbd(zzeps<Executor> zzeps, zzeps<zzayg> zzeps2) {
        this.f15167a = zzeps;
        this.f15168b = zzeps2;
    }

    public static zzday zza(Executor executor, zzayg zzayg) {
        return new zzday(executor, zzayg);
    }

    public static zzdbd zzaz(zzeps<Executor> zzeps, zzeps<zzayg> zzeps2) {
        return new zzdbd(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return zza(this.f15167a.get(), this.f15168b.get());
    }
}
