package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.io.InputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcmx {

    /* renamed from: a */
    private final ScheduledExecutorService f14611a;

    /* renamed from: b */
    private final zzdzc f14612b;

    /* renamed from: c */
    private final zzcnw f14613c;

    /* renamed from: d */
    private final zzeoz<zzcou> f14614d;

    public zzcmx(ScheduledExecutorService scheduledExecutorService, zzdzc zzdzc, zzcnw zzcnw, zzeoz<zzcou> zzeoz) {
        this.f14611a = scheduledExecutorService;
        this.f14612b = zzdzc;
        this.f14613c = zzcnw;
        this.f14614d = zzeoz;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdyz mo16925a(zzatl zzatl, int i, Throwable th) {
        return this.f14614d.get().zzd(zzatl, i);
    }

    public final zzdyz<InputStream> zzg(zzatl zzatl) {
        zzdyz<InputStream> zzdyz;
        String str = zzatl.packageName;
        zzp.zzkq();
        if (zzm.zzen(str)) {
            zzdyz = zzdyr.immediateFailedFuture(new zzcoh(zzdok.INTERNAL_ERROR));
        } else {
            zzdyz = this.f14613c.zzj(zzatl);
        }
        int callingUid = Binder.getCallingUid();
        return zzdyi.zzg(zzdyz).zza((long) ((Integer) zzwq.zzqe().zzd(zzabf.zzcvj)).intValue(), TimeUnit.SECONDS, this.f14611a).zza(Throwable.class, new C2406sl(this, zzatl, callingUid), (Executor) this.f14612b);
    }
}
