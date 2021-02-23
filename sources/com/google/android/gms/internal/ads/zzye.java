package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MuteThisAdListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzye extends zzyc {

    /* renamed from: a */
    private final MuteThisAdListener f17106a;

    public zzye(MuteThisAdListener muteThisAdListener) {
        this.f17106a = muteThisAdListener;
    }

    public final void onAdMuted() {
        this.f17106a.onAdMuted();
    }
}
