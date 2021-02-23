package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzaoi extends zzanr {

    /* renamed from: a */
    private final Adapter f12570a;

    /* renamed from: b */
    private final zzauw f12571b;

    zzaoi(Adapter adapter, zzauw zzauw) {
        this.f12570a = adapter;
        this.f12571b = zzauw;
    }

    public final void onAdClicked() {
        zzauw zzauw = this.f12571b;
        if (zzauw != null) {
            zzauw.zzak(ObjectWrapper.wrap(this.f12570a));
        }
    }

    public final void onAdClosed() {
        zzauw zzauw = this.f12571b;
        if (zzauw != null) {
            zzauw.zzaj(ObjectWrapper.wrap(this.f12570a));
        }
    }

    public final void onAdFailedToLoad(int i) {
        zzauw zzauw = this.f12571b;
        if (zzauw != null) {
            zzauw.zze(ObjectWrapper.wrap(this.f12570a), i);
        }
    }

    public final void onAdImpression() {
    }

    public final void onAdLeftApplication() {
    }

    public final void onAdLoaded() {
        zzauw zzauw = this.f12571b;
        if (zzauw != null) {
            zzauw.zzag(ObjectWrapper.wrap(this.f12570a));
        }
    }

    public final void onAdOpened() {
        zzauw zzauw = this.f12571b;
        if (zzauw != null) {
            zzauw.zzah(ObjectWrapper.wrap(this.f12570a));
        }
    }

    public final void onAppEvent(String str, String str2) {
    }

    public final void onVideoEnd() {
    }

    public final void onVideoPause() {
    }

    public final void onVideoPlay() {
    }

    public final void zza(zzaff zzaff, String str) {
    }

    public final void zza(zzant zzant) {
    }

    public final void zza(zzavc zzavc) {
        zzauw zzauw = this.f12571b;
        if (zzauw != null) {
            zzauw.zza(ObjectWrapper.wrap(this.f12570a), new zzava(zzavc.getType(), zzavc.getAmount()));
        }
    }

    public final void zzb(Bundle bundle) {
    }

    public final void zzb(zzava zzava) {
    }

    public final void zzc(int i, String str) {
    }

    public final void zzc(zzve zzve) {
    }

    public final void zzdc(int i) {
    }

    public final void zzdj(String str) {
    }

    public final void zzdk(String str) {
    }

    public final void zze(zzve zzve) {
    }

    public final void zzun() {
        zzauw zzauw = this.f12571b;
        if (zzauw != null) {
            zzauw.zzai(ObjectWrapper.wrap(this.f12570a));
        }
    }

    public final void zzuo() {
        zzauw zzauw = this.f12571b;
        if (zzauw != null) {
            zzauw.zzam(ObjectWrapper.wrap(this.f12570a));
        }
    }
}
