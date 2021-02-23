package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.instream.InstreamAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzajw extends zzajs {

    /* renamed from: a */
    private final InstreamAd.InstreamAdLoadCallback f12491a;

    public zzajw(InstreamAd.InstreamAdLoadCallback instreamAdLoadCallback) {
        this.f12491a = instreamAdLoadCallback;
    }

    public final void onInstreamAdFailedToLoad(int i) {
        this.f12491a.onInstreamAdFailedToLoad(i);
    }

    public final void zza(zzajn zzajn) {
        this.f12491a.onInstreamAdLoaded(new zzaju(zzajn));
    }

    public final void zzd(zzve zzve) {
        this.f12491a.onInstreamAdFailedToLoad(zzve.zzpm());
    }
}
