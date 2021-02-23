package com.google.android.gms.internal.ads;

import com.bumptech.glide.load.Key;

/* renamed from: com.google.android.gms.internal.ads.o1 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2233o1 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f10241a;

    /* renamed from: b */
    private final /* synthetic */ zzakq f10242b;

    C2233o1(zzakq zzakq, String str) {
        this.f10242b = zzakq;
        this.f10241a = str;
    }

    public final void run() {
        this.f10242b.f12502a.loadData(this.f10241a, "text/html", Key.STRING_CHARSET_NAME);
    }
}
