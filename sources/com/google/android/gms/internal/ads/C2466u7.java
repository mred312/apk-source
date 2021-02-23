package com.google.android.gms.internal.ads;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.u7 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2466u7 implements Runnable {

    /* renamed from: a */
    private final zzbbe f11253a;

    /* renamed from: b */
    private final Map f11254b;

    C2466u7(zzbbe zzbbe, Map map) {
        this.f11253a = zzbbe;
        this.f11254b = map;
    }

    public final void run() {
        this.f11253a.zza("onGcacheInfoEvent", this.f11254b);
    }
}
