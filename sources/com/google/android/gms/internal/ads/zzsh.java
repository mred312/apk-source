package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.FullScreenContentCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzsh extends zzst {

    /* renamed from: a */
    private final FullScreenContentCallback f16977a;

    public zzsh(FullScreenContentCallback fullScreenContentCallback) {
        this.f16977a = fullScreenContentCallback;
    }

    public final void onAdDismissedFullScreenContent() {
        this.f16977a.onAdDismissedFullScreenContent();
    }

    public final void onAdShowedFullScreenContent() {
        this.f16977a.onAdShowedFullScreenContent();
    }

    public final void zzb(zzve zzve) {
        this.f16977a.onAdFailedToShowFullScreenContent(zzve.zzpl());
    }
}
