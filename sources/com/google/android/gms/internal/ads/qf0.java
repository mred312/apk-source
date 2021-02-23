package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class qf0 implements rf0 {
    private qf0() {
    }

    /* renamed from: a */
    public final MediaCodecInfo mo14694a(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    /* renamed from: b */
    public final boolean mo14695b() {
        return false;
    }

    /* renamed from: c */
    public final int mo14696c() {
        return MediaCodecList.getCodecCount();
    }

    /* renamed from: d */
    public final boolean mo14697d(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return "video/avc".equals(str);
    }
}
