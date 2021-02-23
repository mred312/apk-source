package com.google.android.gms.internal.ads;

import android.view.View;

/* renamed from: com.google.android.gms.internal.ads.r9 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2353r9 implements View.OnAttachStateChangeListener {

    /* renamed from: a */
    private final /* synthetic */ zzawq f10772a;

    /* renamed from: b */
    private final /* synthetic */ zzbfm f10773b;

    C2353r9(zzbfm zzbfm, zzawq zzawq) {
        this.f10773b = zzbfm;
        this.f10772a = zzawq;
    }

    public final void onViewAttachedToWindow(View view) {
        this.f10773b.m7742b(view, this.f10772a, 10);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}
