package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.zzp;

/* renamed from: com.google.android.gms.internal.ads.to */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2446to implements zzcaf {

    /* renamed from: a */
    private final zzazq f11224a;

    C2446to(zzazq zzazq) {
        this.f11224a = zzazq;
    }

    public final void zza(boolean z, Context context) {
        zzazq zzazq = this.f11224a;
        try {
            zzp.zzkp();
            zzo.zza(context, (AdOverlayInfoParcel) zzazq.get(), true);
        } catch (Exception unused) {
        }
    }
}
