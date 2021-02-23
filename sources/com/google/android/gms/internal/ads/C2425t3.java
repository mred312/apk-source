package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.zzp;

/* renamed from: com.google.android.gms.internal.ads.t3 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2425t3 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ AdOverlayInfoParcel f11130a;

    /* renamed from: b */
    private final /* synthetic */ zzaqe f11131b;

    C2425t3(zzaqe zzaqe, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.f11131b = zzaqe;
        this.f11130a = adOverlayInfoParcel;
    }

    public final void run() {
        zzp.zzkp();
        zzo.zza(this.f11131b.f12604a, this.f11130a, true);
    }
}
