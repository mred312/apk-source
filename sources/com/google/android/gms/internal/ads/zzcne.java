package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcne extends zzcnc {
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final Pattern f14623g = Pattern.compile("Received error HTTP response code: (.*)");

    /* renamed from: b */
    private final zzcmd f14624b;

    /* renamed from: c */
    private final zzdzc f14625c;

    /* renamed from: d */
    private final zzdnn f14626d;

    /* renamed from: e */
    private final ScheduledExecutorService f14627e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final zzcpx f14628f;

    zzcne(zzbuh zzbuh, zzdnn zzdnn, zzcmd zzcmd, zzdzc zzdzc, ScheduledExecutorService scheduledExecutorService, zzcpx zzcpx) {
        super(zzbuh);
        this.f14626d = zzdnn;
        this.f14624b = zzcmd;
        this.f14625c = zzdzc;
        this.f14627e = scheduledExecutorService;
        this.f14628f = zzcpx;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ zzdyz mo16929d(InputStream inputStream) {
        return zzdyr.zzag(new zzdnj(new zzdne(this.f14626d), zzdnh.zza(new InputStreamReader(inputStream))));
    }

    public final zzdyz<zzdnj> zzb(zzatl zzatl) {
        zzdyz<zzdnj> zzb = zzdyr.zzb(this.f14624b.zze(zzatl), new C2480ul(this), (Executor) this.f14625c);
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcvi)).booleanValue()) {
            zzb = zzdyr.zzb(zzdyr.zza(zzb, (long) ((Integer) zzwq.zzqe().zzd(zzabf.zzcvj)).intValue(), TimeUnit.SECONDS, this.f14627e), TimeoutException.class, C2554wl.f11720a, zzazj.zzegu);
        }
        zzdyr.zza(zzb, new C2517vl(this), zzazj.zzegu);
        return zzb;
    }
}
