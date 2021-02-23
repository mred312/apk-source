package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdhi implements zzdfi<zzdhj> {

    /* renamed from: a */
    private zzarr f15629a;

    /* renamed from: b */
    private ScheduledExecutorService f15630b;

    /* renamed from: c */
    private Context f15631c;

    public zzdhi(zzarr zzarr, ScheduledExecutorService scheduledExecutorService, Context context) {
        this.f15629a = zzarr;
        this.f15630b = scheduledExecutorService;
        this.f15631c = context;
    }

    public final zzdyz<zzdhj> zzasm() {
        return zzdyr.zzb(zzdyr.zza(this.f15629a.zzo(this.f15631c), ((Long) zzwq.zzqe().zzd(zzabf.zzcsv)).longValue(), TimeUnit.MILLISECONDS, this.f15630b), C2041iv.f9354a, (Executor) zzazj.zzegp);
    }
}
