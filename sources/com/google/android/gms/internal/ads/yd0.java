package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class yd0 extends Thread {

    /* renamed from: a */
    private final /* synthetic */ AudioTrack f12182a;

    /* renamed from: b */
    private final /* synthetic */ zzip f12183b;

    yd0(zzip zzip, AudioTrack audioTrack) {
        this.f12183b = zzip;
        this.f12182a = audioTrack;
    }

    public final void run() {
        try {
            this.f12182a.flush();
            this.f12182a.release();
        } finally {
            this.f12183b.f16500e.open();
        }
    }
}
