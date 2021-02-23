package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdgk implements zzdfi<zzdgl> {

    /* renamed from: a */
    private final zzayc f15587a;

    /* renamed from: b */
    private final int f15588b;

    /* renamed from: c */
    private final Context f15589c;

    /* renamed from: d */
    private final zzayg f15590d;

    /* renamed from: e */
    private final ScheduledExecutorService f15591e;

    /* renamed from: f */
    private final Executor f15592f;

    public zzdgk(zzayc zzayc, int i, Context context, zzayg zzayg, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.f15587a = zzayc;
        this.f15588b = i;
        this.f15589c = context;
        this.f15590d = zzayg;
        this.f15591e = scheduledExecutorService;
        this.f15592f = executor;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdyz mo17098a() {
        return this.f15587a.zza(this.f15589c, this.f15588b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ zzdgl mo17099b(Exception exc) {
        this.f15590d.zza(exc, "AttestationTokenSignal");
        return null;
    }

    public final zzdyz<zzdgl> zzasm() {
        return zzdyi.zzg(zzdyr.zza(new C2676zu(this), this.f15592f)).zza(C2639yu.f12232a, this.f15592f).zza(((Long) zzwq.zzqe().zzd(zzabf.zzcor)).longValue(), TimeUnit.MILLISECONDS, this.f15591e).zza(Exception.class, new C1745av(this), zzdzb.zzazo());
    }
}
