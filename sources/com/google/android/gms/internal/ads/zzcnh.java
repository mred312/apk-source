package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcnh implements zzcoi {
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final Pattern f14629f = Pattern.compile("Received error HTTP response code: (.*)");

    /* renamed from: a */
    private final zzcmd f14630a;

    /* renamed from: b */
    private final zzdzc f14631b;

    /* renamed from: c */
    private final zzdnn f14632c;

    /* renamed from: d */
    private final ScheduledExecutorService f14633d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final zzcpx f14634e;

    zzcnh(zzdnn zzdnn, zzcmd zzcmd, zzdzc zzdzc, ScheduledExecutorService scheduledExecutorService, zzcpx zzcpx) {
        this.f14632c = zzdnn;
        this.f14630a = zzcmd;
        this.f14631b = zzdzc;
        this.f14633d = scheduledExecutorService;
        this.f14634e = zzcpx;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ zzdyz mo16930c(InputStream inputStream) {
        return zzdyr.zzag(new zzdnj(new zzdne(this.f14632c), zzdnh.zza(new InputStreamReader(inputStream))));
    }

    public final zzdyz<zzdnj> zzh(zzatl zzatl) {
        zzdyz<zzdnj> zzb = zzdyr.zzb(this.f14630a.zze(zzatl), new C2630yl(this), (Executor) this.f14631b);
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcvi)).booleanValue()) {
            zzb = zzdyr.zzb(zzdyr.zza(zzb, (long) ((Integer) zzwq.zzqe().zzd(zzabf.zzcvj)).intValue(), TimeUnit.SECONDS, this.f14633d), TimeoutException.class, C2592xl.f11947a, zzazj.zzegu);
        }
        zzdyr.zza(zzb, new C2667zl(this), zzazj.zzegu);
        return zzb;
    }
}
