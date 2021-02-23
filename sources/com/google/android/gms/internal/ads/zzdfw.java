package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdfw implements zzdfi<zzdfx> {

    /* renamed from: a */
    private final zzayc f15563a;

    /* renamed from: b */
    private final Context f15564b;

    /* renamed from: c */
    private final ScheduledExecutorService f15565c;

    /* renamed from: d */
    private final Executor f15566d;

    public zzdfw(zzayc zzayc, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.f15563a = zzayc;
        this.f15564b = context;
        this.f15565c = scheduledExecutorService;
        this.f15566d = executor;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdfx mo17095a(Throwable th) {
        zzwq.zzqa();
        return new zzdfx((AdvertisingIdClient.Info) null, zzayr.zzbo(this.f15564b));
    }

    public final zzdyz<zzdfx> zzasm() {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcoq)).booleanValue()) {
            return zzdyr.immediateFailedFuture(new Exception("Did not ad Ad ID into query param."));
        }
        return zzdyi.zzg(this.f15563a.zzai(this.f15564b)).zza(C2452tu.f11228a, this.f15566d).zza(((Long) zzwq.zzqe().zzd(zzabf.zzcor)).longValue(), TimeUnit.MILLISECONDS, this.f15565c).zza(Throwable.class, new C2415su(this), this.f15566d);
    }
}
