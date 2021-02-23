package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

/* renamed from: com.google.android.gms.internal.ads.mm */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2180mm implements zzdyb {

    /* renamed from: a */
    static final zzdyb f9997a = new C2180mm();

    private C2180mm() {
    }

    public final zzdyz zzf(Object obj) {
        return zzdyr.immediateFailedFuture(((ExecutionException) obj).getCause());
    }
}
