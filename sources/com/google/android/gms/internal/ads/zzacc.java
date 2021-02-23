package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzacc extends zzaca {

    /* renamed from: a */
    private final OnCustomRenderedAdLoadedListener f12378a;

    public zzacc(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.f12378a = onCustomRenderedAdLoadedListener;
    }

    public final void zza(zzabw zzabw) {
        this.f12378a.onCustomRenderedAdLoaded(new zzabx(zzabw));
    }
}
