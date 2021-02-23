package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;

@TargetApi(19)
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class zd0 extends xd0 {

    /* renamed from: j */
    private final AudioTimestamp f12281j = new AudioTimestamp();

    /* renamed from: k */
    private long f12282k;

    /* renamed from: l */
    private long f12283l;

    /* renamed from: m */
    private long f12284m;

    public zd0() {
        super((yd0) null);
    }

    /* renamed from: b */
    public final void mo15019b(AudioTrack audioTrack, boolean z) {
        super.mo15019b(audioTrack, z);
        this.f12282k = 0;
        this.f12283l = 0;
        this.f12284m = 0;
    }

    /* renamed from: f */
    public final boolean mo15023f() {
        boolean timestamp = this.f11886a.getTimestamp(this.f12281j);
        if (timestamp) {
            long j = this.f12281j.framePosition;
            if (this.f12283l > j) {
                this.f12282k++;
            }
            this.f12283l = j;
            this.f12284m = j + (this.f12282k << 32);
        }
        return timestamp;
    }

    /* renamed from: g */
    public final long mo15024g() {
        return this.f12281j.nanoTime;
    }

    /* renamed from: h */
    public final long mo15025h() {
        return this.f12284m;
    }
}
