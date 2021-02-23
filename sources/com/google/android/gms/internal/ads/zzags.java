package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeContentAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzags extends zzafn {

    /* renamed from: a */
    private final NativeContentAd.OnContentAdLoadedListener f12456a;

    public zzags(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
        this.f12456a = onContentAdLoadedListener;
    }

    public final void zza(zzafb zzafb) {
        this.f12456a.onContentAdLoaded(new zzafc(zzafb));
    }
}
