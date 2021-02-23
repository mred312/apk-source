package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.ads.wc */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2545wc implements zzdyo<Void> {

    /* renamed from: a */
    private final /* synthetic */ zzboz f11696a;

    C2545wc(zzboz zzboz) {
        this.f11696a = zzboz;
    }

    public final /* synthetic */ void onSuccess(@NullableDecl Object obj) {
        Void voidR = (Void) obj;
        this.f11696a.f13608g.zzbg(true);
    }

    public final void zzb(Throwable th) {
        this.f11696a.f13608g.zzbg(false);
    }
}
