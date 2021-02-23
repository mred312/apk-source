package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;

/* renamed from: com.google.android.gms.internal.ads.hc */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C1985hc implements zzbtj {

    /* renamed from: a */
    private final Context f9180a;

    /* renamed from: b */
    private final zzazh f9181b;

    /* renamed from: c */
    private final zzdmu f9182c;

    /* renamed from: d */
    private final zzdnn f9183d;

    C1985hc(Context context, zzazh zzazh, zzdmu zzdmu, zzdnn zzdnn) {
        this.f9180a = context;
        this.f9181b = zzazh;
        this.f9182c = zzdmu;
        this.f9183d = zzdnn;
    }

    public final void onAdLoaded() {
        zzp.zzla().zzb(this.f9180a, this.f9181b.zzbrf, this.f9182c.zzhhc.toString(), this.f9183d.zzhip);
    }
}
