package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.ads.he */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1987he implements Runnable {

    /* renamed from: a */
    private final WeakReference<zzbua> f9186a;

    private C1987he(zzbua zzbua) {
        this.f9186a = new WeakReference<>(zzbua);
    }

    public final void run() {
        zzbua zzbua = (zzbua) this.f9186a.get();
        if (zzbua != null) {
            zzbua.m7862c();
        }
    }
}
