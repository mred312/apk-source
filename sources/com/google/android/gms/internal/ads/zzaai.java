package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.ShouldDelayBannerRenderingListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzaai extends zzagc {

    /* renamed from: a */
    private final ShouldDelayBannerRenderingListener f12332a;

    public zzaai(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
        this.f12332a = shouldDelayBannerRenderingListener;
    }

    public final boolean zzm(IObjectWrapper iObjectWrapper) {
        return this.f12332a.shouldDelayBannerRendering((Runnable) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
