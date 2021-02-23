package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdfj;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzddx<S extends zzdfj<?>> implements zzdfi<S> {

    /* renamed from: a */
    private final zzdfi<S> f15469a;

    /* renamed from: b */
    private final long f15470b;

    /* renamed from: c */
    private final ScheduledExecutorService f15471c;

    public zzddx(zzdfi<S> zzdfi, long j, ScheduledExecutorService scheduledExecutorService) {
        this.f15469a = zzdfi;
        this.f15470b = j;
        this.f15471c = scheduledExecutorService;
    }

    public final zzdyz<S> zzasm() {
        zzdyz<S> zzasm = this.f15469a.zzasm();
        long j = this.f15470b;
        if (j > 0) {
            zzasm = zzdyr.zza(zzasm, j, TimeUnit.MILLISECONDS, this.f15471c);
        }
        return zzdyr.zzb(zzasm, Throwable.class, C2600xt.f11958a, zzazj.zzegu);
    }
}
