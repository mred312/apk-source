package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcgg extends zzagi {
    @Nullable

    /* renamed from: a */
    private final String f14307a;

    /* renamed from: b */
    private final zzcbt f14308b;

    /* renamed from: c */
    private final zzcce f14309c;

    public zzcgg(@Nullable String str, zzcbt zzcbt, zzcce zzcce) {
        this.f14307a = str;
        this.f14308b = zzcbt;
        this.f14309c = zzcce;
    }

    public final void cancelUnconfirmedClick() {
        this.f14308b.cancelUnconfirmedClick();
    }

    public final void destroy() {
        this.f14308b.destroy();
    }

    public final String getAdvertiser() {
        return this.f14309c.getAdvertiser();
    }

    public final String getBody() {
        return this.f14309c.getBody();
    }

    public final String getCallToAction() {
        return this.f14309c.getCallToAction();
    }

    public final Bundle getExtras() {
        return this.f14309c.getExtras();
    }

    public final String getHeadline() {
        return this.f14309c.getHeadline();
    }

    public final List<?> getImages() {
        return this.f14309c.getImages();
    }

    public final String getMediationAdapterClassName() {
        return this.f14307a;
    }

    public final List<?> getMuteThisAdReasons() {
        if (isCustomMuteThisAdEnabled()) {
            return this.f14309c.getMuteThisAdReasons();
        }
        return Collections.emptyList();
    }

    public final String getPrice() {
        return this.f14309c.getPrice();
    }

    public final double getStarRating() {
        return this.f14309c.getStarRating();
    }

    public final String getStore() {
        return this.f14309c.getStore();
    }

    public final zzys getVideoController() {
        return this.f14309c.getVideoController();
    }

    public final boolean isCustomClickGestureEnabled() {
        return this.f14308b.isCustomClickGestureEnabled();
    }

    public final boolean isCustomMuteThisAdEnabled() {
        return !this.f14309c.getMuteThisAdReasons().isEmpty() && this.f14309c.zzanf() != null;
    }

    public final void performClick(Bundle bundle) {
        this.f14308b.zzf(bundle);
    }

    public final void recordCustomClickGesture() {
        this.f14308b.recordCustomClickGesture();
    }

    public final boolean recordImpression(Bundle bundle) {
        return this.f14308b.zzh(bundle);
    }

    public final void reportTouchEvent(Bundle bundle) {
        this.f14308b.zzg(bundle);
    }

    public final void zza(zzage zzage) {
        this.f14308b.zza(zzage);
    }

    public final zzyn zzkh() {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcxv)).booleanValue()) {
            return null;
        }
        return this.f14308b.zzajz();
    }

    public final IObjectWrapper zzsv() {
        return ObjectWrapper.wrap(this.f14308b);
    }

    public final zzaej zzsw() {
        return this.f14309c.zzsw();
    }

    public final zzaeb zzsx() {
        return this.f14309c.zzsx();
    }

    public final IObjectWrapper zzsy() {
        return this.f14309c.zzsy();
    }

    public final void zztg() {
        this.f14308b.zztg();
    }

    public final zzaee zzth() {
        return this.f14308b.zzamz().zzth();
    }

    public final void zza(@Nullable zzyd zzyd) {
        this.f14308b.zza(zzyd);
    }

    public final void zza(zzxz zzxz) {
        this.f14308b.zza(zzxz);
    }

    public final void zza(zzym zzym) {
        this.f14308b.zza(zzym);
    }
}
