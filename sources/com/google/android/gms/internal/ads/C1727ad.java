package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.ads.ad */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1727ad implements zzdyo<Boolean> {

    /* renamed from: a */
    private final /* synthetic */ zzbqu f7804a;

    C1727ad(zzbqu zzbqu) {
        this.f7804a = zzbqu;
    }

    public final /* synthetic */ void onSuccess(@NullableDecl Object obj) {
        Boolean bool = (Boolean) obj;
        this.f7804a.f13688a.onAdImpression();
    }

    public final void zzb(Throwable th) {
    }
}
