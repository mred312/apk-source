package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;

/* renamed from: com.google.android.gms.internal.ads.m6 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2164m6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ MediaPlayer f9914a;

    /* renamed from: b */
    private final /* synthetic */ zzbac f9915b;

    C2164m6(zzbac zzbac, MediaPlayer mediaPlayer) {
        this.f9915b = zzbac;
        this.f9914a = mediaPlayer;
    }

    public final void run() {
        this.f9915b.m7642b(this.f9914a);
        if (this.f9915b.f12998p != null) {
            this.f9915b.f12998p.zzfb();
        }
    }
}
