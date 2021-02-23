package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.os.Handler;
import androidx.annotation.NonNull;

@TargetApi(23)
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class ug0 implements MediaCodec.OnFrameRenderedListener {

    /* renamed from: a */
    private final /* synthetic */ zzqa f11420a;

    private ug0(zzqa zzqa, MediaCodec mediaCodec) {
        this.f11420a = zzqa;
        mediaCodec.setOnFrameRenderedListener(this, new Handler());
    }

    public final void onFrameRendered(@NonNull MediaCodec mediaCodec, long j, long j2) {
        zzqa zzqa = this.f11420a;
        if (this == zzqa.f16879w0) {
            zzqa.mo18135o();
        }
    }
}
