package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdrt implements zzepf<zzdro> {

    /* renamed from: a */
    private final zzeps<zzdzc> f15899a;

    /* renamed from: b */
    private final zzeps<ScheduledExecutorService> f15900b;

    /* renamed from: c */
    private final zzeps<d00> f15901c;

    private zzdrt(zzeps<zzdzc> zzeps, zzeps<ScheduledExecutorService> zzeps2, zzeps<d00> zzeps3) {
        this.f15899a = zzeps;
        this.f15900b = zzeps2;
        this.f15901c = zzeps3;
    }

    public static zzdrt zzx(zzeps<zzdzc> zzeps, zzeps<ScheduledExecutorService> zzeps2, zzeps<d00> zzeps3) {
        return new zzdrt(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzdro(this.f15899a.get(), this.f15900b.get(), this.f15901c.get());
    }
}
