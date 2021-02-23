package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

/* renamed from: com.google.android.gms.internal.ads.kl */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2105kl implements zzdyb {

    /* renamed from: a */
    static final zzdyb f9769a = new C2105kl();

    private C2105kl() {
    }

    public final zzdyz zzf(Object obj) {
        return zzdyr.immediateFailedFuture(((ExecutionException) obj).getCause());
    }
}
