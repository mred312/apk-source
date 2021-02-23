package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzapd extends zzaoa {

    /* renamed from: a */
    private final UnifiedNativeAdMapper f12591a;

    public zzapd(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        this.f12591a = unifiedNativeAdMapper;
    }

    public final String getAdvertiser() {
        return this.f12591a.getAdvertiser();
    }

    public final String getBody() {
        return this.f12591a.getBody();
    }

    public final String getCallToAction() {
        return this.f12591a.getCallToAction();
    }

    public final Bundle getExtras() {
        return this.f12591a.getExtras();
    }

    public final String getHeadline() {
        return this.f12591a.getHeadline();
    }

    public final List getImages() {
        List<NativeAd.Image> images = this.f12591a.getImages();
        ArrayList arrayList = new ArrayList();
        if (images != null) {
            for (NativeAd.Image next : images) {
                arrayList.add(new zzadv(next.getDrawable(), next.getUri(), next.getScale(), next.getWidth(), next.getHeight()));
            }
        }
        return arrayList;
    }

    public final float getMediaContentAspectRatio() {
        return this.f12591a.getMediaContentAspectRatio();
    }

    public final boolean getOverrideClickHandling() {
        return this.f12591a.getOverrideClickHandling();
    }

    public final boolean getOverrideImpressionRecording() {
        return this.f12591a.getOverrideImpressionRecording();
    }

    public final String getPrice() {
        return this.f12591a.getPrice();
    }

    public final double getStarRating() {
        if (this.f12591a.getStarRating() != null) {
            return this.f12591a.getStarRating().doubleValue();
        }
        return -1.0d;
    }

    public final String getStore() {
        return this.f12591a.getStore();
    }

    public final zzys getVideoController() {
        if (this.f12591a.getVideoController() != null) {
            return this.f12591a.getVideoController().zzdw();
        }
        return null;
    }

    public final float getVideoCurrentTime() {
        return this.f12591a.getCurrentTime();
    }

    public final float getVideoDuration() {
        return this.f12591a.getDuration();
    }

    public final void recordImpression() {
        this.f12591a.recordImpression();
    }

    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.f12591a.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final zzaej zzsw() {
        NativeAd.Image icon = this.f12591a.getIcon();
        if (icon != null) {
            return new zzadv(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        }
        return null;
    }

    public final zzaeb zzsx() {
        return null;
    }

    public final IObjectWrapper zzsy() {
        Object zzjw = this.f12591a.zzjw();
        if (zzjw == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzjw);
    }

    public final void zzu(IObjectWrapper iObjectWrapper) {
        this.f12591a.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final IObjectWrapper zzup() {
        View adChoicesContent = this.f12591a.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    public final IObjectWrapper zzuq() {
        View zzaee = this.f12591a.zzaee();
        if (zzaee == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzaee);
    }

    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.f12591a.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
