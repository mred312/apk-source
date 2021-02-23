package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import com.google.android.gms.ads.internal.util.zzf;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdcg implements zzdfi<zzdch> {

    /* renamed from: a */
    private zzamy f15414a;

    /* renamed from: b */
    private ScheduledExecutorService f15415b;

    /* renamed from: c */
    private zzf f15416c;

    /* renamed from: d */
    private ApplicationInfo f15417d;

    /* renamed from: e */
    zzdnn f15418e;

    public zzdcg(zzamy zzamy, ScheduledExecutorService scheduledExecutorService, zzf zzf, ApplicationInfo applicationInfo, zzdnn zzdnn) {
        this.f15414a = zzamy;
        this.f15415b = scheduledExecutorService;
        this.f15416c = zzf;
        this.f15417d = applicationInfo;
        this.f15418e = zzdnn;
    }

    public final zzdyz<zzdch> zzasm() {
        zzdyz<V> zzdyz;
        if (!zzacq.zzdbd.get().booleanValue()) {
            zzdyz = zzdyr.zzag(null);
        } else if (!this.f15416c.zzxt()) {
            zzdyz = zzdyr.zzag(null);
        } else {
            zzdyz = zzdyr.zzb(zzdyr.zza(this.f15414a.zza(this.f15417d), ((Long) zzwq.zzqe().zzd(zzabf.zzcsn)).longValue(), TimeUnit.MILLISECONDS, this.f15415b), Throwable.class, C2039it.f9352a, zzazj.zzegu);
        }
        return zzdyr.zzb(zzdyr.zzb(zzdyz, new C1965gt(this), (Executor) this.f15415b), C2002ht.f9236a, (Executor) zzazj.zzegp);
    }
}
