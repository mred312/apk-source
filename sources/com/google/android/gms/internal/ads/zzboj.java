package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzboj {

    /* renamed from: a */
    private final Executor f13586a;

    /* renamed from: b */
    private final ScheduledExecutorService f13587b;

    /* renamed from: c */
    private final zzdyz<zzboi> f13588c;

    /* renamed from: d */
    private volatile boolean f13589d = true;

    public zzboj(Executor executor, ScheduledExecutorService scheduledExecutorService, zzdyz<zzboi> zzdyz) {
        this.f13586a = executor;
        this.f13587b = scheduledExecutorService;
        this.f13588c = zzdyz;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final void m7837d(List<? extends zzdyz<? extends zzboc>> list, zzdyo<zzboc> zzdyo) {
        if (list == null || list.isEmpty()) {
            this.f13586a.execute(new C2282pc(zzdyo));
            return;
        }
        zzdyz<O> zzag = zzdyr.zzag(null);
        for (zzdyz rcVar : list) {
            zzag = zzdyr.zzb(zzdyr.zzb(zzag, Throwable.class, new C2245oc(zzdyo), this.f13586a), new C2356rc(this, zzdyo, rcVar), this.f13586a);
        }
        zzdyr.zza(zzag, new C2397sc(this, zzdyo), this.f13586a);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public final void m7838e() {
        zzazj.zzegt.execute(new C2319qc(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdyz mo16386a(zzdyo zzdyo, zzdyz zzdyz, zzboc zzboc) {
        if (zzboc != null) {
            zzdyo.onSuccess(zzboc);
        }
        return zzdyr.zza(zzdyz, zzadk.zzddr.get().longValue(), TimeUnit.MILLISECONDS, this.f13587b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final /* synthetic */ void mo16387f() {
        this.f13589d = false;
    }

    public final boolean isLoading() {
        return this.f13589d;
    }

    public final void zza(zzdyo<zzboc> zzdyo) {
        zzdyr.zza(this.f13588c, new C2434tc(this, zzdyo), this.f13586a);
    }
}
