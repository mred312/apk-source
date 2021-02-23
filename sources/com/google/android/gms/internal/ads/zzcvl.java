package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcvl implements zzepf<zzcve> {

    /* renamed from: a */
    private final zzeps<Context> f14941a;

    /* renamed from: b */
    private final zzeps<zzazh> f14942b;

    /* renamed from: c */
    private final zzeps<zzdnn> f14943c;

    /* renamed from: d */
    private final zzeps<Executor> f14944d;

    /* renamed from: e */
    private final zzeps<zzchf> f14945e;

    /* renamed from: f */
    private final zzeps<zzchp> f14946f;

    public zzcvl(zzeps<Context> zzeps, zzeps<zzazh> zzeps2, zzeps<zzdnn> zzeps3, zzeps<Executor> zzeps4, zzeps<zzchf> zzeps5, zzeps<zzchp> zzeps6) {
        this.f14941a = zzeps;
        this.f14942b = zzeps2;
        this.f14943c = zzeps3;
        this.f14944d = zzeps4;
        this.f14945e = zzeps5;
        this.f14946f = zzeps6;
    }

    public final /* synthetic */ Object get() {
        return new zzcve(this.f14941a.get(), this.f14942b.get(), this.f14943c.get(), this.f14944d.get(), this.f14945e.get(), this.f14946f.get());
    }
}
