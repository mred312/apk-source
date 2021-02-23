package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

@TargetApi(21)
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class sf0 implements rf0 {

    /* renamed from: a */
    private final int f11081a;

    /* renamed from: b */
    private MediaCodecInfo[] f11082b;

    public sf0(boolean z) {
        this.f11081a = z ? 1 : 0;
    }

    /* renamed from: e */
    private final void m6970e() {
        if (this.f11082b == null) {
            this.f11082b = new MediaCodecList(this.f11081a).getCodecInfos();
        }
    }

    /* renamed from: a */
    public final MediaCodecInfo mo14694a(int i) {
        m6970e();
        return this.f11082b[i];
    }

    /* renamed from: b */
    public final boolean mo14695b() {
        return true;
    }

    /* renamed from: c */
    public final int mo14696c() {
        m6970e();
        return this.f11082b.length;
    }

    /* renamed from: d */
    public final boolean mo14697d(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }
}
