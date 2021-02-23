package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcmz implements zzepf<zzcmx> {

    /* renamed from: a */
    private final zzeps<ScheduledExecutorService> f14615a;

    /* renamed from: b */
    private final zzeps<zzdzc> f14616b;

    /* renamed from: c */
    private final zzeps<zzcnw> f14617c;

    /* renamed from: d */
    private final zzeps<zzcou> f14618d;

    public zzcmz(zzeps<ScheduledExecutorService> zzeps, zzeps<zzdzc> zzeps2, zzeps<zzcnw> zzeps3, zzeps<zzcou> zzeps4) {
        this.f14615a = zzeps;
        this.f14616b = zzeps2;
        this.f14617c = zzeps3;
        this.f14618d = zzeps4;
    }

    public final /* synthetic */ Object get() {
        return new zzcmx(this.f14615a.get(), this.f14616b.get(), this.f14617c.get(), zzepg.zzat(this.f14618d));
    }
}
