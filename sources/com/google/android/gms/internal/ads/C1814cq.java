package com.google.android.gms.internal.ads;

import android.content.Context;

/* renamed from: com.google.android.gms.internal.ads.cq */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C1814cq implements zzcaf {

    /* renamed from: a */
    private final zzcrb f8030a;

    C1814cq(zzcrb zzcrb) {
        this.f8030a = zzcrb;
    }

    public final void zza(boolean z, Context context) {
        zzcrb zzcrb = this.f8030a;
        try {
            ((zzdoe) zzcrb.zzdmo).setImmersiveMode(z);
            ((zzdoe) zzcrb.zzdmo).showVideo();
        } catch (zzdnr e) {
            zzaza.zzd("Cannot show rewarded video.", e);
            throw new zzcai(e.getCause());
        }
    }
}
