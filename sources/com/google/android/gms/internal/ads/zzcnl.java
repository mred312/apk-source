package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcnl implements zzepf<zzcnh> {

    /* renamed from: a */
    private final zzeps<zzdnn> f14635a;

    /* renamed from: b */
    private final zzeps<zzcmd> f14636b;

    /* renamed from: c */
    private final zzeps<zzdzc> f14637c;

    /* renamed from: d */
    private final zzeps<ScheduledExecutorService> f14638d;

    /* renamed from: e */
    private final zzeps<zzcpx> f14639e;

    private zzcnl(zzeps<zzdnn> zzeps, zzeps<zzcmd> zzeps2, zzeps<zzdzc> zzeps3, zzeps<ScheduledExecutorService> zzeps4, zzeps<zzcpx> zzeps5) {
        this.f14635a = zzeps;
        this.f14636b = zzeps2;
        this.f14637c = zzeps3;
        this.f14638d = zzeps4;
        this.f14639e = zzeps5;
    }

    public static zzcnl zzf(zzeps<zzdnn> zzeps, zzeps<zzcmd> zzeps2, zzeps<zzdzc> zzeps3, zzeps<ScheduledExecutorService> zzeps4, zzeps<zzcpx> zzeps5) {
        return new zzcnl(zzeps, zzeps2, zzeps3, zzeps4, zzeps5);
    }

    public final /* synthetic */ Object get() {
        return new zzcnh(this.f14635a.get(), this.f14636b.get(), this.f14637c.get(), this.f14638d.get(), this.f14639e.get());
    }
}
