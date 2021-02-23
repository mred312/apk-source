package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.ek */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C1882ek implements zzbfj {

    /* renamed from: a */
    private final zzazq f8373a;

    C1882ek(zzazq zzazq) {
        this.f8373a = zzazq;
    }

    public final void zzai(boolean z) {
        zzazq zzazq = this.f8373a;
        if (z) {
            zzazq.set(null);
        } else {
            zzazq.setException(new Exception("Ad Web View failed to load."));
        }
    }
}
