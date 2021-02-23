package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

@TargetApi(24)
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class he0 {

    /* renamed from: a */
    private final MediaCodec.CryptoInfo f9187a;

    /* renamed from: b */
    private final MediaCodec.CryptoInfo.Pattern f9188b;

    private he0(MediaCodec.CryptoInfo cryptoInfo) {
        this.f9187a = cryptoInfo;
        this.f9188b = new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m6285a(int i, int i2) {
        this.f9188b.set(0, 0);
        this.f9187a.setPattern(this.f9188b);
    }
}
