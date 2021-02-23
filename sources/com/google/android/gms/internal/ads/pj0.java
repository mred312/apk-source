package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final /* synthetic */ class pj0 implements Runnable {

    /* renamed from: a */
    private final zzzd f10637a;

    /* renamed from: b */
    private final Context f10638b;

    pj0(zzzd zzzd, Context context) {
        this.f10637a = zzzd;
        this.f10638b = context;
    }

    public final void run() {
        this.f10637a.getRewardedVideoAdInstance(this.f10638b);
    }
}
