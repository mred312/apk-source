package com.google.android.gms.internal.ads;

import com.facebook.ads.AdError;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class h40 implements Runnable {
    h40() {
    }

    public final void run() {
        try {
            zzdx.f16039g.mo17208f();
            zzdx.f16039g.zzbr();
        } catch (Exception e) {
            zzdx.f16041i.zza(AdError.INTERNAL_ERROR_CODE, -1, e);
        }
    }
}
