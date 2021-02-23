package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* renamed from: com.google.android.gms.internal.ads.ro */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2368ro extends zzapf {

    /* renamed from: a */
    private zzcrb<zzapo, zzcst> f10814a;

    /* renamed from: b */
    private final /* synthetic */ zzcsf f10815b;

    private C2368ro(zzcsf zzcsf, zzcrb<zzapo, zzcst> zzcrb) {
        this.f10815b = zzcsf;
        this.f10814a = zzcrb;
    }

    public final void zzdm(String str) {
        ((zzcst) this.f10814a.zzgqp).zzc(0, str);
    }

    public final void zzf(zzve zzve) {
        ((zzcst) this.f10814a.zzgqp).zzc(zzve);
    }

    public final void zzx(IObjectWrapper iObjectWrapper) {
        View unused = this.f10815b.f14781c = (View) ObjectWrapper.unwrap(iObjectWrapper);
        ((zzcst) this.f10814a.zzgqp).onAdLoaded();
    }
}
