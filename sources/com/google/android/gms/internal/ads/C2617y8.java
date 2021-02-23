package com.google.android.gms.internal.ads;

import android.view.View;

/* renamed from: com.google.android.gms.internal.ads.y8 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2617y8 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ View f11995a;

    /* renamed from: b */
    private final /* synthetic */ zzawq f11996b;

    /* renamed from: c */
    private final /* synthetic */ int f11997c;

    /* renamed from: d */
    private final /* synthetic */ zzbdu f11998d;

    C2617y8(zzbdu zzbdu, View view, zzawq zzawq, int i) {
        this.f11998d = zzbdu;
        this.f11995a = view;
        this.f11996b = zzawq;
        this.f11997c = i;
    }

    public final void run() {
        this.f11998d.m7726a(this.f11995a, this.f11996b, this.f11997c - 1);
    }
}
