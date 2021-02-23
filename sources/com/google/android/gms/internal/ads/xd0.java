package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
class xd0 {

    /* renamed from: a */
    protected AudioTrack f11886a;

    /* renamed from: b */
    private boolean f11887b;

    /* renamed from: c */
    private int f11888c;

    /* renamed from: d */
    private long f11889d;

    /* renamed from: e */
    private long f11890e;

    /* renamed from: f */
    private long f11891f;

    /* renamed from: g */
    private long f11892g;

    /* renamed from: h */
    private long f11893h;

    /* renamed from: i */
    private long f11894i;

    private xd0() {
    }

    /* renamed from: a */
    public final void mo15018a() {
        if (this.f11892g == -9223372036854775807L) {
            this.f11886a.pause();
        }
    }

    /* renamed from: b */
    public void mo15019b(AudioTrack audioTrack, boolean z) {
        this.f11886a = audioTrack;
        this.f11887b = z;
        this.f11892g = -9223372036854775807L;
        this.f11889d = 0;
        this.f11890e = 0;
        this.f11891f = 0;
        if (audioTrack != null) {
            this.f11888c = audioTrack.getSampleRate();
        }
    }

    /* renamed from: c */
    public final void mo15020c(long j) {
        this.f11893h = mo15021d();
        this.f11892g = SystemClock.elapsedRealtime() * 1000;
        this.f11894i = j;
        this.f11886a.stop();
    }

    /* renamed from: d */
    public final long mo15021d() {
        if (this.f11892g != -9223372036854775807L) {
            return Math.min(this.f11894i, this.f11893h + ((((SystemClock.elapsedRealtime() * 1000) - this.f11892g) * ((long) this.f11888c)) / 1000000));
        }
        int playState = this.f11886a.getPlayState();
        if (playState == 1) {
            return 0;
        }
        long playbackHeadPosition = 4294967295L & ((long) this.f11886a.getPlaybackHeadPosition());
        if (this.f11887b) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.f11891f = this.f11889d;
            }
            playbackHeadPosition += this.f11891f;
        }
        if (this.f11889d > playbackHeadPosition) {
            this.f11890e++;
        }
        this.f11889d = playbackHeadPosition;
        return playbackHeadPosition + (this.f11890e << 32);
    }

    /* renamed from: e */
    public final long mo15022e() {
        return (mo15021d() * 1000000) / ((long) this.f11888c);
    }

    /* renamed from: f */
    public boolean mo15023f() {
        return false;
    }

    /* renamed from: g */
    public long mo15024g() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: h */
    public long mo15025h() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ xd0(yd0 yd0) {
        this();
    }
}
