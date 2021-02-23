package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.dx */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1858dx implements zzdyo<zzbyx> {

    /* renamed from: a */
    private final /* synthetic */ zzcyn f8293a;

    /* renamed from: b */
    private final /* synthetic */ zzbzx f8294b;

    /* renamed from: c */
    final /* synthetic */ zzdkv f8295c;

    C1858dx(zzdkv zzdkv, zzcyn zzcyn, zzbzx zzbzx) {
        this.f8295c = zzdkv;
        this.f8293a = zzcyn;
        this.f8294b = zzbzx;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzbyx zzbyx = (zzbyx) obj;
        synchronized (this.f8295c) {
            zzdyz unused = this.f8295c.f15732h = null;
            zzaaq zzaaq = zzabf.zzcys;
            if (((Boolean) zzwq.zzqe().zzd(zzaaq)).booleanValue()) {
                zzbyx.zzakb().zza(this.f8295c.f15728d).zza(this.f8295c.f15729e);
            }
            this.f8293a.onSuccess(zzbyx);
            if (((Boolean) zzwq.zzqe().zzd(zzaaq)).booleanValue()) {
                this.f8295c.f15726b.execute(new C1821cx(this));
                this.f8295c.f15726b.execute(new C1932fx(this));
            }
        }
    }

    public final void zzb(Throwable th) {
        zzve zze = this.f8294b.zzagh().zze(th);
        synchronized (this.f8295c) {
            zzdyz unused = this.f8295c.f15732h = null;
            this.f8294b.zzagi().zzk(zze);
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcys)).booleanValue()) {
                this.f8295c.f15726b.execute(new C1895ex(this, zze));
                this.f8295c.f15726b.execute(new C2006hx(this, zze));
            }
            zzdob.zza(zze.errorCode, th, "InterstitialAdLoader.onFailure");
            this.f8293a.zzarx();
        }
    }
}
