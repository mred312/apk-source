package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzaal extends zzyw {

    /* renamed from: a */
    private final VideoController.VideoLifecycleCallbacks f12333a;

    public zzaal(VideoController.VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.f12333a = videoLifecycleCallbacks;
    }

    public final void onVideoEnd() {
        this.f12333a.onVideoEnd();
    }

    public final void onVideoMute(boolean z) {
        this.f12333a.onVideoMute(z);
    }

    public final void onVideoPause() {
        this.f12333a.onVideoPause();
    }

    public final void onVideoPlay() {
        this.f12333a.onVideoPlay();
    }

    public final void onVideoStart() {
        this.f12333a.onVideoStart();
    }
}
