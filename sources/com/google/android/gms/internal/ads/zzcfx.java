package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcfx extends zzaew {
    @Nullable

    /* renamed from: a */
    private final String f14282a;

    /* renamed from: b */
    private final zzcbt f14283b;

    /* renamed from: c */
    private final zzcce f14284c;

    public zzcfx(@Nullable String str, zzcbt zzcbt, zzcce zzcce) {
        this.f14282a = str;
        this.f14283b = zzcbt;
        this.f14284c = zzcce;
    }

    public final void destroy() {
        this.f14283b.destroy();
    }

    public final String getBody() {
        return this.f14284c.getBody();
    }

    public final String getCallToAction() {
        return this.f14284c.getCallToAction();
    }

    public final Bundle getExtras() {
        return this.f14284c.getExtras();
    }

    public final String getHeadline() {
        return this.f14284c.getHeadline();
    }

    public final List<?> getImages() {
        return this.f14284c.getImages();
    }

    public final String getMediationAdapterClassName() {
        return this.f14282a;
    }

    public final String getPrice() {
        return this.f14284c.getPrice();
    }

    public final double getStarRating() {
        return this.f14284c.getStarRating();
    }

    public final String getStore() {
        return this.f14284c.getStore();
    }

    public final zzys getVideoController() {
        return this.f14284c.getVideoController();
    }

    public final void performClick(Bundle bundle) {
        this.f14283b.zzf(bundle);
    }

    public final boolean recordImpression(Bundle bundle) {
        return this.f14283b.zzh(bundle);
    }

    public final void reportTouchEvent(Bundle bundle) {
        this.f14283b.zzg(bundle);
    }

    public final IObjectWrapper zzsv() {
        return ObjectWrapper.wrap(this.f14283b);
    }

    public final zzaej zzsw() {
        return this.f14284c.zzsw();
    }

    public final zzaeb zzsx() {
        return this.f14284c.zzsx();
    }

    public final IObjectWrapper zzsy() {
        return this.f14284c.zzsy();
    }
}
