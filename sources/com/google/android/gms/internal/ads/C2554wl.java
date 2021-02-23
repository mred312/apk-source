package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeoutException;

/* renamed from: com.google.android.gms.internal.ads.wl */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2554wl implements zzdyb {

    /* renamed from: a */
    static final zzdyb f11720a = new C2554wl();

    private C2554wl() {
    }

    public final zzdyz zzf(Object obj) {
        TimeoutException timeoutException = (TimeoutException) obj;
        return zzdyr.immediateFailedFuture(new zzcme(zzdok.NETWORK_ERROR, "Timed out waiting for ad response."));
    }
}
