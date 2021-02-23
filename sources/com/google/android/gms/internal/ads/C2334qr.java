package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.qr */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2334qr implements zzdyo<zzboc> {

    /* renamed from: a */
    private final /* synthetic */ zzcyn f10734a;

    /* renamed from: b */
    private final /* synthetic */ zzcat f10735b;

    /* renamed from: c */
    final /* synthetic */ zzcyp f10736c;

    C2334qr(zzcyp zzcyp, zzcyn zzcyn, zzcat zzcat) {
        this.f10736c = zzcyp;
        this.f10734a = zzcyn;
        this.f10735b = zzcat;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzboc zzboc = (zzboc) obj;
        synchronized (this.f10736c) {
            zzaaq zzaaq = zzabf.zzcyt;
            if (((Boolean) zzwq.zzqe().zzd(zzaaq)).booleanValue()) {
                zzboc.zzakb().zza(this.f10736c.f15073d.zzasa());
            }
            this.f10734a.onSuccess(zzboc);
            if (((Boolean) zzwq.zzqe().zzd(zzaaq)).booleanValue()) {
                this.f10736c.f15071b.zzaek().execute(new C2297pr(this));
            }
        }
    }

    public final void zzb(Throwable th) {
        zzve zze = this.f10735b.zzagh().zze(th);
        this.f10735b.zzagi().zzk(zze);
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyt)).booleanValue()) {
            this.f10736c.f15071b.zzaek().execute(new C2371rr(this, zze));
        }
        zzdob.zza(zze.errorCode, th, "NativeAdLoader.onFailure");
        this.f10734a.zzarx();
    }
}
