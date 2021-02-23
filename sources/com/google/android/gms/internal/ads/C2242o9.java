package com.google.android.gms.internal.ads;

import android.view.View;

/* renamed from: com.google.android.gms.internal.ads.o9 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2242o9 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ View f10263a;

    /* renamed from: b */
    private final /* synthetic */ zzawq f10264b;

    /* renamed from: c */
    private final /* synthetic */ int f10265c;

    /* renamed from: d */
    private final /* synthetic */ zzbfm f10266d;

    C2242o9(zzbfm zzbfm, View view, zzawq zzawq, int i) {
        this.f10266d = zzbfm;
        this.f10263a = view;
        this.f10264b = zzawq;
        this.f10265c = i;
    }

    public final void run() {
        this.f10266d.m7742b(this.f10263a, this.f10264b, this.f10265c - 1);
    }
}
