package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzag;

/* renamed from: com.google.android.gms.internal.ads.yc */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2621yc implements zzdvm {

    /* renamed from: a */
    private final Context f12175a;

    /* renamed from: b */
    private final zzazh f12176b;

    /* renamed from: c */
    private final zzdnn f12177c;

    C2621yc(Context context, zzazh zzazh, zzdnn zzdnn) {
        this.f12175a = context;
        this.f12176b = zzazh;
        this.f12177c = zzdnn;
    }

    public final Object apply(Object obj) {
        Context context = this.f12175a;
        zzazh zzazh = this.f12176b;
        zzdnn zzdnn = this.f12177c;
        zzdmu zzdmu = (zzdmu) obj;
        zzag zzag = new zzag(context);
        zzag.zzep(zzdmu.zzdus);
        zzag.zzeq(zzdmu.zzhhc.toString());
        zzag.zzad(zzazh.zzbrf);
        zzag.setAdUnitId(zzdnn.zzhip);
        return zzag;
    }
}
