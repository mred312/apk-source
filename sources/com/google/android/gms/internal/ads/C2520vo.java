package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.vo */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2520vo implements zzdyo<zzbme> {

    /* renamed from: a */
    private final /* synthetic */ zzcsq f11635a;

    C2520vo(zzcsq zzcsq) {
        this.f11635a = zzcsq;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        ((zzbme) obj).zzajj();
    }

    public final void zzb(Throwable th) {
        zzve zze = this.f11635a.f14796a.zzagh().zze(th);
        this.f11635a.f14799d.zzk(zze);
        zzdob.zza(zze.errorCode, th, "DelayedBannerAd.onFailure");
    }
}
