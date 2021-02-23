package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcsq implements zzcqz<zzbme> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzbna f14796a;

    /* renamed from: b */
    private final zzcrw f14797b;

    /* renamed from: c */
    private final zzdzc f14798c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzbrx f14799d;

    /* renamed from: e */
    private final ScheduledExecutorService f14800e;

    public zzcsq(zzbna zzbna, zzcrw zzcrw, zzbrx zzbrx, ScheduledExecutorService scheduledExecutorService, zzdzc zzdzc) {
        this.f14796a = zzbna;
        this.f14797b = zzcrw;
        this.f14799d = zzbrx;
        this.f14800e = scheduledExecutorService;
        this.f14798c = zzdzc;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ zzbme mo16991c(zzdnj zzdnj, zzdmu zzdmu) {
        return this.f14796a.zza(new zzbos(zzdnj, zzdmu, (String) null), new zzbno(zzdnj.zzhij.zzfvl.zzaun(), new C2557wo(this, zzdnj, zzdmu))).zzaha();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ void mo16992d(zzdnj zzdnj, zzdmu zzdmu) {
        zzdyr.zza(zzdyr.zza(this.f14797b.zzb(zzdnj, zzdmu), (long) zzdmu.zzhhh, TimeUnit.SECONDS, this.f14800e), new C2520vo(this), this.f14798c);
    }

    public final boolean zza(zzdnj zzdnj, zzdmu zzdmu) {
        return zzdnj.zzhij.zzfvl.zzaun() != null && this.f14797b.zza(zzdnj, zzdmu);
    }

    public final zzdyz<zzbme> zzb(zzdnj zzdnj, zzdmu zzdmu) {
        return this.f14798c.zze(new C2483uo(this, zzdnj, zzdmu));
    }
}
