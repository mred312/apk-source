package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;

/* renamed from: com.google.android.gms.internal.ads.sg */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2401sg implements zzbtj {

    /* renamed from: a */
    private final Context f11083a;

    /* renamed from: b */
    private final zzazh f11084b;

    /* renamed from: c */
    private final zzdmu f11085c;

    /* renamed from: d */
    private final zzdnn f11086d;

    C2401sg(Context context, zzazh zzazh, zzdmu zzdmu, zzdnn zzdnn) {
        this.f11083a = context;
        this.f11084b = zzazh;
        this.f11085c = zzdmu;
        this.f11086d = zzdnn;
    }

    public final void onAdLoaded() {
        zzp.zzla().zzb(this.f11083a, this.f11084b.zzbrf, this.f11085c.zzhhc.toString(), this.f11086d.zzhip);
    }
}
