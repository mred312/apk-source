package com.google.android.gms.internal.ads;

import com.bumptech.glide.load.Key;

/* renamed from: com.google.android.gms.internal.ads.l1 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2122l1 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f9793a;

    /* renamed from: b */
    private final /* synthetic */ zzakq f9794b;

    C2122l1(zzakq zzakq, String str) {
        this.f9794b = zzakq;
        this.f9793a = str;
    }

    public final void run() {
        this.f9794b.f12502a.loadData(this.f9793a, "text/html", Key.STRING_CHARSET_NAME);
    }
}
