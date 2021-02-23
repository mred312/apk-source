package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.rn */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2367rn implements Callable {

    /* renamed from: a */
    private final zzcqo f10813a;

    C2367rn(zzcqo zzcqo) {
        this.f10813a = zzcqo;
    }

    public final Object call() {
        return this.f10813a.getWritableDatabase();
    }
}
