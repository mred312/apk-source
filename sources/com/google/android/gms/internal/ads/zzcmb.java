package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcmb implements zzepf<zzclp> {

    /* renamed from: a */
    private final zzeps<Executor> f14582a;

    /* renamed from: b */
    private final zzeps<Context> f14583b;

    /* renamed from: c */
    private final zzeps<WeakReference<Context>> f14584c;

    /* renamed from: d */
    private final zzeps<Executor> f14585d;

    /* renamed from: e */
    private final zzeps<zzciq> f14586e;

    /* renamed from: f */
    private final zzeps<ScheduledExecutorService> f14587f;

    /* renamed from: g */
    private final zzeps<zzckz> f14588g;

    /* renamed from: h */
    private final zzeps<zzazh> f14589h;

    public zzcmb(zzeps<Executor> zzeps, zzeps<Context> zzeps2, zzeps<WeakReference<Context>> zzeps3, zzeps<Executor> zzeps4, zzeps<zzciq> zzeps5, zzeps<ScheduledExecutorService> zzeps6, zzeps<zzckz> zzeps7, zzeps<zzazh> zzeps8) {
        this.f14582a = zzeps;
        this.f14583b = zzeps2;
        this.f14584c = zzeps3;
        this.f14585d = zzeps4;
        this.f14586e = zzeps5;
        this.f14587f = zzeps6;
        this.f14588g = zzeps7;
        this.f14589h = zzeps8;
    }

    public final /* synthetic */ Object get() {
        return new zzclp(this.f14582a.get(), this.f14583b.get(), this.f14584c.get(), this.f14585d.get(), this.f14586e.get(), this.f14587f.get(), this.f14588g.get(), this.f14589h.get());
    }
}
