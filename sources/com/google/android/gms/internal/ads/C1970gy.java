package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.gy */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1970gy implements zzdyo<zzchc> {

    /* renamed from: a */
    private final /* synthetic */ zzcyn f8813a;

    /* renamed from: b */
    private final /* synthetic */ C2007hy f8814b;

    /* renamed from: c */
    final /* synthetic */ zzdma f8815c;

    C1970gy(zzdma zzdma, zzcyn zzcyn, C2007hy hyVar) {
        this.f8815c = zzdma;
        this.f8813a = zzcyn;
        this.f8814b = hyVar;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzchc zzchc = (zzchc) obj;
        synchronized (this.f8815c) {
            zzaaq zzaaq = zzabf.zzcyq;
            if (((Boolean) zzwq.zzqe().zzd(zzaaq)).booleanValue()) {
                zzchc.zzakb().zza(this.f8815c.f15752d);
            }
            this.f8813a.onSuccess(zzchc);
            if (((Boolean) zzwq.zzqe().zzd(zzaaq)).booleanValue()) {
                this.f8815c.f15750b.execute(new C1933fy(this));
            }
            this.f8815c.f15752d.onAdMetadataChanged();
        }
    }

    public final void zzb(Throwable th) {
        zzve zzve;
        zzchf zzchf = (zzchf) this.f8815c.f15753e.zzaty();
        if (zzchf == null) {
            zzve = zzdoi.zza(th, (zzcrg) null);
        } else {
            zzve = zzchf.zzagh().zze(th);
        }
        synchronized (this.f8815c) {
            if (zzchf != null) {
                zzchf.zzagi().zzk(zzve);
                if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyq)).booleanValue()) {
                    this.f8815c.f15750b.execute(new C2044iy(this, zzve));
                }
            } else {
                this.f8815c.f15752d.zzk(zzve);
                this.f8815c.mo17141g(this.f8814b).zzaho().zzagh().zzakk().zzalg();
            }
            zzdob.zza(zzve.errorCode, th, "RewardedAdLoader.onFailure");
            this.f8813a.zzarx();
        }
    }
}
