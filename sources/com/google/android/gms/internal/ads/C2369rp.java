package com.google.android.gms.internal.ads;

import android.content.Context;

/* renamed from: com.google.android.gms.internal.ads.rp */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2369rp implements zzcaf {

    /* renamed from: a */
    private final zzcrb f10816a;

    C2369rp(zzcrb zzcrb) {
        this.f10816a = zzcrb;
    }

    public final void zza(boolean z, Context context) {
        zzcrb zzcrb = this.f10816a;
        try {
            ((zzdoe) zzcrb.zzdmo).setImmersiveMode(z);
            ((zzdoe) zzcrb.zzdmo).zzck(context);
        } catch (zzdnr e) {
            throw new zzcai(e.getCause());
        }
    }
}
