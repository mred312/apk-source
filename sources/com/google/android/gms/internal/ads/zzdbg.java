package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdbg implements zzdfi<zzdbh> {

    /* renamed from: a */
    private final ScheduledExecutorService f15174a;

    /* renamed from: b */
    private final Executor f15175b;

    public zzdbg(Context context, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.f15174a = scheduledExecutorService;
        this.f15175b = executor;
    }

    public final zzdyz<zzdbh> zzasm() {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcwz)).booleanValue()) {
            return zzdyr.zzag(null);
        }
        zzazq zzazq = new zzazq();
        try {
            new C2674zs(zzazq).zzbl(false);
        } catch (Throwable unused) {
            zzaza.zzey("ArCoreApk is not ready.");
            zzazq.set(Boolean.FALSE);
        }
        return zzdyr.zzb(zzdyr.zzb(zzdyr.zza(zzazq, 200, TimeUnit.MILLISECONDS, this.f15174a), new C2637ys(this), this.f15175b), Throwable.class, C1743at.f7851a, this.f15175b);
    }
}
