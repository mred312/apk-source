package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.ads.xc */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2583xc implements zzdyo<zzatl> {

    /* renamed from: a */
    private final /* synthetic */ zzboz f11882a;

    C2583xc(zzboz zzboz) {
        this.f11882a = zzboz;
    }

    public final /* synthetic */ void onSuccess(@NullableDecl Object obj) {
        zzatl zzatl = (zzatl) obj;
        this.f11882a.f13608g.zzbf(true);
    }

    public final void zzb(Throwable th) {
        this.f11882a.f13608g.zzbf(false);
    }
}
