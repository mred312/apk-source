package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;

/* renamed from: com.google.android.gms.internal.ads.pq */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2296pq implements zzg {

    /* renamed from: a */
    private final /* synthetic */ zzbyz f10648a;

    C2296pq(zzcwu zzcwu, zzbyz zzbyz) {
        this.f10648a = zzbyz;
    }

    public final void zzh(View view) {
    }

    public final void zzkb() {
        this.f10648a.zzafs().onAdClicked();
    }

    public final void zzkc() {
        this.f10648a.zzaft().onAdImpression();
        this.f10648a.zzafu().zzalx();
    }
}
