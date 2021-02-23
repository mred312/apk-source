package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcez implements zzepf<zzces> {

    /* renamed from: a */
    private final zzeps<Context> f14210a;

    /* renamed from: b */
    private final zzeps<zzcej> f14211b;

    /* renamed from: c */
    private final zzeps<zzef> f14212c;

    /* renamed from: d */
    private final zzeps<zzazh> f14213d;

    /* renamed from: e */
    private final zzeps<zzb> f14214e;

    /* renamed from: f */
    private final zzeps<zzts> f14215f;

    /* renamed from: g */
    private final zzeps<Executor> f14216g;

    /* renamed from: h */
    private final zzeps<zzdnn> f14217h;

    /* renamed from: i */
    private final zzeps<zzcff> f14218i;

    /* renamed from: j */
    private final zzeps<ScheduledExecutorService> f14219j;

    public zzcez(zzeps<Context> zzeps, zzeps<zzcej> zzeps2, zzeps<zzef> zzeps3, zzeps<zzazh> zzeps4, zzeps<zzb> zzeps5, zzeps<zzts> zzeps6, zzeps<Executor> zzeps7, zzeps<zzdnn> zzeps8, zzeps<zzcff> zzeps9, zzeps<ScheduledExecutorService> zzeps10) {
        this.f14210a = zzeps;
        this.f14211b = zzeps2;
        this.f14212c = zzeps3;
        this.f14213d = zzeps4;
        this.f14214e = zzeps5;
        this.f14215f = zzeps6;
        this.f14216g = zzeps7;
        this.f14217h = zzeps8;
        this.f14218i = zzeps9;
        this.f14219j = zzeps10;
    }

    public final /* synthetic */ Object get() {
        return new zzces(this.f14210a.get(), this.f14211b.get(), this.f14212c.get(), this.f14213d.get(), this.f14214e.get(), this.f14215f.get(), this.f14216g.get(), this.f14217h.get(), this.f14218i.get(), this.f14219j.get());
    }
}
