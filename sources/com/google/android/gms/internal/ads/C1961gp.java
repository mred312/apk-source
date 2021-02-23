package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.gp */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1961gp extends zzapg {

    /* renamed from: a */
    private zzcrb<zzapo, zzcst> f8802a;

    private C1961gp(zzcth zzcth, zzcrb<zzapo, zzcst> zzcrb) {
        this.f8802a = zzcrb;
    }

    public final void zzdm(String str) {
        ((zzcst) this.f8802a.zzgqp).zzc(0, str);
    }

    public final void zzf(zzve zzve) {
        ((zzcst) this.f8802a.zzgqp).zzc(zzve);
    }

    public final void zzuw() {
        ((zzcst) this.f8802a.zzgqp).onAdLoaded();
    }
}
