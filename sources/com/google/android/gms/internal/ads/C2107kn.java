package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.kn */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2107kn implements Callable {

    /* renamed from: a */
    private final zzcpp f9771a;

    private C2107kn(zzcpp zzcpp) {
        this.f9771a = zzcpp;
    }

    /* renamed from: a */
    static Callable m6430a(zzcpp zzcpp) {
        return new C2107kn(zzcpp);
    }

    public final Object call() {
        return this.f9771a.getWritableDatabase();
    }
}
