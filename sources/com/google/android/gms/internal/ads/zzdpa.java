package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdpa {

    /* renamed from: a */
    private zzdoz f15854a = null;

    public final void onAdClosed() {
        zzdoz zzdoz = this.f15854a;
        if (zzdoz != null) {
            zzdoz.execute();
        }
    }

    public final void zza(zzdoz zzdoz) {
        this.f15854a = zzdoz;
    }
}
