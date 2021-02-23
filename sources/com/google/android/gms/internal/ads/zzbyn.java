package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbyn extends zzbwk<VideoController.VideoLifecycleCallbacks> {
    @GuardedBy("this")

    /* renamed from: b */
    private boolean f13856b;

    protected zzbyn(Set<zzbxy<VideoController.VideoLifecycleCallbacks>> set) {
        super(set);
    }

    public final void onVideoEnd() {
        zza(C2100kg.f9755a);
    }

    public final void onVideoPause() {
        zza(C2137lg.f9863a);
    }

    public final synchronized void onVideoPlay() {
        if (!this.f13856b) {
            zza(C2174mg.f9983a);
            this.f13856b = true;
        }
        zza(C2249og.f10367a);
    }

    public final synchronized void onVideoStart() {
        zza(C2211ng.f10191a);
        this.f13856b = true;
    }
}
