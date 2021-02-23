package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdhe implements zzdfi<zzdhf> {

    /* renamed from: a */
    private zzamy f15620a;

    /* renamed from: b */
    private ScheduledExecutorService f15621b;

    /* renamed from: c */
    private boolean f15622c;

    /* renamed from: d */
    private ApplicationInfo f15623d;

    public zzdhe(zzamy zzamy, ScheduledExecutorService scheduledExecutorService, boolean z, ApplicationInfo applicationInfo) {
        this.f15620a = zzamy;
        this.f15621b = scheduledExecutorService;
        this.f15622c = z;
        this.f15623d = applicationInfo;
    }

    public final zzdyz<zzdhf> zzasm() {
        if (!zzacq.zzdbe.get().booleanValue()) {
            return zzdyr.immediateFailedFuture(new Exception("Auto Collect Location by gms is disabled."));
        }
        if (!this.f15622c) {
            return zzdyr.immediateFailedFuture(new Exception("Auto Collect Location is false."));
        }
        return zzdyr.zzb(zzdyr.zza(this.f15620a.zza(this.f15623d), ((Long) zzwq.zzqe().zzd(zzabf.zzcsn)).longValue(), TimeUnit.MILLISECONDS, this.f15621b), C2004hv.f9238a, (Executor) zzazj.zzegp);
    }
}
