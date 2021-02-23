package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.ev */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C1893ev implements Callable {

    /* renamed from: a */
    private final zzdyz f8403a;

    /* renamed from: b */
    private final zzdyz f8404b;

    C1893ev(zzdyz zzdyz, zzdyz zzdyz2) {
        this.f8403a = zzdyz;
        this.f8404b = zzdyz2;
    }

    public final Object call() {
        return new zzdgw((String) this.f8403a.get(), (String) this.f8404b.get());
    }
}
