package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzaol extends zzanu {

    /* renamed from: a */
    private final NativeAppInstallAdMapper f12577a;

    public zzaol(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.f12577a = nativeAppInstallAdMapper;
    }

    public final String getBody() {
        return this.f12577a.getBody();
    }

    public final String getCallToAction() {
        return this.f12577a.getCallToAction();
    }

    public final Bundle getExtras() {
        return this.f12577a.getExtras();
    }

    public final String getHeadline() {
        return this.f12577a.getHeadline();
    }

    public final List getImages() {
        List<NativeAd.Image> images = this.f12577a.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image next : images) {
            arrayList.add(new zzadv(next.getDrawable(), next.getUri(), next.getScale(), next.getWidth(), next.getHeight()));
        }
        return arrayList;
    }

    public final boolean getOverrideClickHandling() {
        return this.f12577a.getOverrideClickHandling();
    }

    public final boolean getOverrideImpressionRecording() {
        return this.f12577a.getOverrideImpressionRecording();
    }

    public final String getPrice() {
        return this.f12577a.getPrice();
    }

    public final double getStarRating() {
        return this.f12577a.getStarRating();
    }

    public final String getStore() {
        return this.f12577a.getStore();
    }

    public final zzys getVideoController() {
        if (this.f12577a.getVideoController() != null) {
            return this.f12577a.getVideoController().zzdw();
        }
        return null;
    }

    public final void recordImpression() {
        this.f12577a.recordImpression();
    }

    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.f12577a.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final zzaej zzsw() {
        NativeAd.Image icon = this.f12577a.getIcon();
        if (icon != null) {
            return new zzadv(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        }
        return null;
    }

    public final zzaeb zzsx() {
        return null;
    }

    public final IObjectWrapper zzsy() {
        return null;
    }

    public final void zzu(IObjectWrapper iObjectWrapper) {
        this.f12577a.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final IObjectWrapper zzup() {
        View adChoicesContent = this.f12577a.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    public final IObjectWrapper zzuq() {
        View zzaee = this.f12577a.zzaee();
        if (zzaee == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzaee);
    }

    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.f12577a.trackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.f12577a.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
