package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAppInstallAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzagt extends zzafi {

    /* renamed from: a */
    private final NativeAppInstallAd.OnAppInstallAdLoadedListener f12457a;

    public zzagt(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.f12457a = onAppInstallAdLoadedListener;
    }

    public final void zza(zzaex zzaex) {
        this.f12457a.onAppInstallAdLoaded(new zzaey(zzaex));
    }
}
