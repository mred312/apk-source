package com.google.android.gms.internal.ads;

import android.view.View;

/* renamed from: com.google.android.gms.internal.ads.x8 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2579x8 implements View.OnAttachStateChangeListener {

    /* renamed from: a */
    private final /* synthetic */ zzawq f11765a;

    /* renamed from: b */
    private final /* synthetic */ zzbdu f11766b;

    C2579x8(zzbdu zzbdu, zzawq zzawq) {
        this.f11766b = zzbdu;
        this.f11765a = zzawq;
    }

    public final void onViewAttachedToWindow(View view) {
        this.f11766b.m7726a(view, this.f11765a, 10);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}
