package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final /* synthetic */ class oj0 implements Runnable {

    /* renamed from: a */
    private final zzzd f10386a;

    /* renamed from: b */
    private final OnInitializationCompleteListener f10387b;

    oj0(zzzd zzzd, OnInitializationCompleteListener onInitializationCompleteListener) {
        this.f10386a = zzzd;
        this.f10387b = onInitializationCompleteListener;
    }

    public final void run() {
        this.f10386a.mo18471d(this.f10387b);
    }
}
