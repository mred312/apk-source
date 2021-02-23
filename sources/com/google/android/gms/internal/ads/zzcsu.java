package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcsu implements zzepf<zzcsq> {

    /* renamed from: a */
    private final zzeps<zzbna> f14803a;

    /* renamed from: b */
    private final zzeps<zzcrw> f14804b;

    /* renamed from: c */
    private final zzeps<zzbrx> f14805c;

    /* renamed from: d */
    private final zzeps<ScheduledExecutorService> f14806d;

    /* renamed from: e */
    private final zzeps<zzdzc> f14807e;

    public zzcsu(zzeps<zzbna> zzeps, zzeps<zzcrw> zzeps2, zzeps<zzbrx> zzeps3, zzeps<ScheduledExecutorService> zzeps4, zzeps<zzdzc> zzeps5) {
        this.f14803a = zzeps;
        this.f14804b = zzeps2;
        this.f14805c = zzeps3;
        this.f14806d = zzeps4;
        this.f14807e = zzeps5;
    }

    public final /* synthetic */ Object get() {
        return new zzcsq(this.f14803a.get(), this.f14804b.get(), this.f14805c.get(), this.f14806d.get(), this.f14807e.get());
    }
}
