package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.bo */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C1775bo implements zzbsm {

    /* renamed from: a */
    private final zzbdv f7931a;

    C1775bo(zzbdv zzbdv) {
        this.f7931a = zzbdv;
    }

    public final void onAdImpression() {
        zzbdv zzbdv = this.f7931a;
        if (zzbdv.zzacs() != null) {
            zzbdv.zzacs().zzace();
        }
    }
}
