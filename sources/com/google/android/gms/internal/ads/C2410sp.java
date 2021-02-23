package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.sp */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2410sp extends zzapm {

    /* renamed from: a */
    private zzcrb<zzapo, zzcst> f11105a;

    private C2410sp(zzcuv zzcuv, zzcrb<zzapo, zzcst> zzcrb) {
        this.f11105a = zzcrb;
    }

    public final void zzdm(String str) {
        ((zzcst) this.f11105a.zzgqp).zzc(0, str);
    }

    public final void zzf(zzve zzve) {
        ((zzcst) this.f11105a.zzgqp).zzc(zzve);
    }

    public final void zzuw() {
        ((zzcst) this.f11105a.zzgqp).onAdLoaded();
    }
}
