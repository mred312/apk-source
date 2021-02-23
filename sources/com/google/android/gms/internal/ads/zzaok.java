package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzaok extends zzanz {

    /* renamed from: a */
    private final NativeContentAdMapper f12576a;

    public zzaok(NativeContentAdMapper nativeContentAdMapper) {
        this.f12576a = nativeContentAdMapper;
    }

    public final String getAdvertiser() {
        return this.f12576a.getAdvertiser();
    }

    public final String getBody() {
        return this.f12576a.getBody();
    }

    public final String getCallToAction() {
        return this.f12576a.getCallToAction();
    }

    public final Bundle getExtras() {
        return this.f12576a.getExtras();
    }

    public final String getHeadline() {
        return this.f12576a.getHeadline();
    }

    public final List getImages() {
        List<NativeAd.Image> images = this.f12576a.getImages();
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
        return this.f12576a.getOverrideClickHandling();
    }

    public final boolean getOverrideImpressionRecording() {
        return this.f12576a.getOverrideImpressionRecording();
    }

    public final zzys getVideoController() {
        if (this.f12576a.getVideoController() != null) {
            return this.f12576a.getVideoController().zzdw();
        }
        return null;
    }

    public final void recordImpression() {
        this.f12576a.recordImpression();
    }

    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.f12576a.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final zzaeb zzsx() {
        return null;
    }

    public final IObjectWrapper zzsy() {
        return null;
    }

    public final zzaej zzsz() {
        NativeAd.Image logo = this.f12576a.getLogo();
        if (logo != null) {
            return new zzadv(logo.getDrawable(), logo.getUri(), logo.getScale(), logo.getWidth(), logo.getHeight());
        }
        return null;
    }

    public final void zzu(IObjectWrapper iObjectWrapper) {
        this.f12576a.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final IObjectWrapper zzup() {
        View adChoicesContent = this.f12576a.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    public final IObjectWrapper zzuq() {
        View zzaee = this.f12576a.zzaee();
        if (zzaee == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzaee);
    }

    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.f12576a.trackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.f12576a.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
