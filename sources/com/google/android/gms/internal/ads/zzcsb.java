package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzag;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcsb implements zzepf<zzcrw> {

    /* renamed from: a */
    private final zzeps<zzbna> f14769a;

    /* renamed from: b */
    private final zzeps<Context> f14770b;

    /* renamed from: c */
    private final zzeps<Executor> f14771c;

    /* renamed from: d */
    private final zzeps<zzchp> f14772d;

    /* renamed from: e */
    private final zzeps<zzdnn> f14773e;

    /* renamed from: f */
    private final zzeps<zzdvm<zzdmu, zzag>> f14774f;

    public zzcsb(zzeps<zzbna> zzeps, zzeps<Context> zzeps2, zzeps<Executor> zzeps3, zzeps<zzchp> zzeps4, zzeps<zzdnn> zzeps5, zzeps<zzdvm<zzdmu, zzag>> zzeps6) {
        this.f14769a = zzeps;
        this.f14770b = zzeps2;
        this.f14771c = zzeps3;
        this.f14772d = zzeps4;
        this.f14773e = zzeps5;
        this.f14774f = zzeps6;
    }

    public final /* synthetic */ Object get() {
        return new zzcrw(this.f14769a.get(), this.f14770b.get(), this.f14771c.get(), this.f14772d.get(), this.f14773e.get(), this.f14774f.get());
    }
}
