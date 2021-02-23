package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcfz extends zzafa {
    @Nullable

    /* renamed from: a */
    private final String f14287a;

    /* renamed from: b */
    private final zzcbt f14288b;

    /* renamed from: c */
    private final zzcce f14289c;

    public zzcfz(@Nullable String str, zzcbt zzcbt, zzcce zzcce) {
        this.f14287a = str;
        this.f14288b = zzcbt;
        this.f14289c = zzcce;
    }

    public final void destroy() {
        this.f14288b.destroy();
    }

    public final String getAdvertiser() {
        return this.f14289c.getAdvertiser();
    }

    public final String getBody() {
        return this.f14289c.getBody();
    }

    public final String getCallToAction() {
        return this.f14289c.getCallToAction();
    }

    public final Bundle getExtras() {
        return this.f14289c.getExtras();
    }

    public final String getHeadline() {
        return this.f14289c.getHeadline();
    }

    public final List<?> getImages() {
        return this.f14289c.getImages();
    }

    public final String getMediationAdapterClassName() {
        return this.f14287a;
    }

    public final zzys getVideoController() {
        return this.f14289c.getVideoController();
    }

    public final void performClick(Bundle bundle) {
        this.f14288b.zzf(bundle);
    }

    public final boolean recordImpression(Bundle bundle) {
        return this.f14288b.zzh(bundle);
    }

    public final void reportTouchEvent(Bundle bundle) {
        this.f14288b.zzg(bundle);
    }

    public final IObjectWrapper zzsv() {
        return ObjectWrapper.wrap(this.f14288b);
    }

    public final zzaeb zzsx() {
        return this.f14289c.zzsx();
    }

    public final IObjectWrapper zzsy() {
        return this.f14289c.zzsy();
    }

    public final zzaej zzsz() {
        return this.f14289c.zzsz();
    }
}
