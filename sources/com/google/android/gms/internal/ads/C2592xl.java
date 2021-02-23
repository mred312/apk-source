package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeoutException;

/* renamed from: com.google.android.gms.internal.ads.xl */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2592xl implements zzdyb {

    /* renamed from: a */
    static final zzdyb f11947a = new C2592xl();

    private C2592xl() {
    }

    public final zzdyz zzf(Object obj) {
        TimeoutException timeoutException = (TimeoutException) obj;
        return zzdyr.immediateFailedFuture(new zzcme(zzdok.NETWORK_ERROR));
    }
}
