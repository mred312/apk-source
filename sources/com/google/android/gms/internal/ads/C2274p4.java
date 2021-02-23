package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

/* renamed from: com.google.android.gms.internal.ads.p4 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2274p4 implements Runnable {

    /* renamed from: a */
    private final zzawh f10427a;

    /* renamed from: b */
    private final Bitmap f10428b;

    C2274p4(zzawh zzawh, Bitmap bitmap) {
        this.f10427a = zzawh;
        this.f10428b = bitmap;
    }

    public final void run() {
        this.f10427a.mo15803a(this.f10428b);
    }
}
