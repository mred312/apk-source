package com.google.android.gms.ads.internal.overlay;

import android.graphics.drawable.Drawable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class zzm implements Runnable {
    private final zzj zzdrj;
    private final Drawable zzdrk;

    zzm(zzj zzj, Drawable drawable) {
        this.zzdrj = zzj;
        this.zzdrk = drawable;
    }

    public final void run() {
        zzj zzj = this.zzdrj;
        zzj.zzdrb.zzaap.getWindow().setBackgroundDrawable(this.zzdrk);
    }
}
