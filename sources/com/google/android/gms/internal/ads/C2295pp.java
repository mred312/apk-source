package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MobileAds;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

/* renamed from: com.google.android.gms.internal.ads.pp */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2295pp implements zzdyo<T> {

    /* renamed from: a */
    private final /* synthetic */ long f10643a;

    /* renamed from: b */
    private final /* synthetic */ String f10644b;

    /* renamed from: c */
    private final /* synthetic */ zzdmu f10645c;

    /* renamed from: d */
    private final /* synthetic */ zzdmz f10646d;

    /* renamed from: e */
    private final /* synthetic */ zzcum f10647e;

    C2295pp(zzcum zzcum, long j, String str, zzdmu zzdmu, zzdmz zzdmz) {
        this.f10647e = zzcum;
        this.f10643a = j;
        this.f10644b = str;
        this.f10645c = zzdmu;
        this.f10646d = zzdmz;
    }

    public final void onSuccess(T t) {
        long elapsedRealtime = this.f10647e.f14892a.elapsedRealtime() - this.f10643a;
        this.f10647e.m8275d(this.f10644b, 0, elapsedRealtime, this.f10645c.zzhhn);
        if (this.f10647e.f14895d) {
            this.f10647e.f14893b.zza(this.f10646d, this.f10645c, 0, (zzcrd) null, elapsedRealtime);
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzczb)).booleanValue()) {
            this.f10647e.f14896e.zza(this.f10645c, elapsedRealtime, (zzve) null);
        }
    }

    public final void zzb(Throwable th) {
        int i;
        zzve zzve;
        long elapsedRealtime = this.f10647e.f14892a.elapsedRealtime() - this.f10643a;
        if (th instanceof TimeoutException) {
            i = 2;
        } else if (th instanceof zzcuc) {
            i = 3;
        } else if (th instanceof CancellationException) {
            i = 4;
        } else if (th instanceof zzdnr) {
            i = 5;
        } else {
            i = (!(th instanceof zzcme) || zzdoi.zzh(th).errorCode != 3) ? 6 : 1;
        }
        this.f10647e.m8275d(this.f10644b, i, elapsedRealtime, this.f10645c.zzhhn);
        if (this.f10647e.f14895d) {
            this.f10647e.f14893b.zza(this.f10646d, this.f10645c, i, th instanceof zzcrd ? (zzcrd) th : null, elapsedRealtime);
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzczb)).booleanValue()) {
            zzve zzh = zzdoi.zzh(th);
            int i2 = zzh.errorCode;
            if ((i2 == 3 || i2 == 0) && (zzve = zzh.zzcgu) != null && !zzve.zzcgt.equals(MobileAds.ERROR_DOMAIN)) {
                zzh = zzdoi.zzh(new zzcrd(zzdok.MEDIATION_NO_FILL, zzh.zzcgu));
            }
            this.f10647e.f14896e.zza(this.f10645c, elapsedRealtime, zzh);
        }
    }
}
