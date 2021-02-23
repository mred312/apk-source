package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.sv */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2416sv implements zzdyo<AppOpenAd> {

    /* renamed from: a */
    private final /* synthetic */ zzcyn f11111a;

    /* renamed from: b */
    private final /* synthetic */ C2490uv f11112b;

    /* renamed from: c */
    final /* synthetic */ zzdil f11113c;

    C2416sv(zzdil zzdil, zzcyn zzcyn, C2490uv uvVar) {
        this.f11113c = zzdil;
        this.f11111a = zzcyn;
        this.f11112b = uvVar;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzboc zzboc = (zzboc) obj;
        synchronized (this.f11113c) {
            zzdyz unused = this.f11113c.f15674g = null;
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyr)).booleanValue()) {
                zzboc.zzakb().zza(this.f11113c.f15670c);
            }
            this.f11111a.onSuccess(zzboc);
        }
    }

    public final void zzb(Throwable th) {
        zzve zzve;
        zzblm zzblm = (zzblm) this.f11113c.f15671d.zzaty();
        if (zzblm == null) {
            zzve = zzdoi.zza(th, (zzcrg) null);
        } else {
            zzve = zzblm.zzagh().zze(th);
        }
        synchronized (this.f11113c) {
            zzdyz unused = this.f11113c.f15674g = null;
            if (zzblm != null) {
                zzblm.zzagi().zzk(zzve);
                if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyr)).booleanValue()) {
                    this.f11113c.f15669b.execute(new C2527vv(this, zzve));
                }
            } else {
                this.f11113c.f15670c.zzk(zzve);
                ((zzblm) this.f11113c.mo17113f(this.f11112b).zzafp()).zzagh().zzakk().zzalg();
            }
            zzdob.zza(zzve.errorCode, th, "AppOpenAdLoader.onFailure");
            this.f11111a.zzarx();
        }
    }
}
