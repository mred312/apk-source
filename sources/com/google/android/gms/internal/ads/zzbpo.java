package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbpo implements zzbru, zzbsm, zzbtj, zzbui, zzva {

    /* renamed from: a */
    private final Clock f13626a;

    /* renamed from: b */
    private final zzayf f13627b;

    public zzbpo(Clock clock, zzayf zzayf) {
        this.f13626a = clock;
        this.f13627b = zzayf;
    }

    public final void onAdClicked() {
        this.f13627b.zzwq();
    }

    public final void onAdClosed() {
        this.f13627b.zzwr();
    }

    public final void onAdImpression() {
        this.f13627b.zzwp();
    }

    public final void onAdLeftApplication() {
    }

    public final void onAdLoaded() {
        this.f13627b.zzan(true);
    }

    public final void onAdOpened() {
    }

    public final void onRewardedVideoCompleted() {
    }

    public final void onRewardedVideoStarted() {
    }

    public final void zzb(zzauf zzauf, String str, String str2) {
    }

    public final void zzb(zzdnj zzdnj) {
        this.f13627b.zzey(this.f13626a.elapsedRealtime());
    }

    public final void zzd(zzatl zzatl) {
    }

    public final void zzf(zzvk zzvk) {
        this.f13627b.zze(zzvk);
    }

    public final String zzws() {
        return this.f13627b.zzws();
    }
}
