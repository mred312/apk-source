package com.google.android.gms.internal.ads;

import android.content.Context;

/* renamed from: com.google.android.gms.internal.ads.ra */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2354ra implements zzdii {

    /* renamed from: a */
    private Context f10774a;

    /* renamed from: b */
    private String f10775b;

    /* renamed from: c */
    private final /* synthetic */ zzbhg f10776c;

    private C2354ra(zzbhg zzbhg) {
        this.f10776c = zzbhg;
    }

    public final zzdij zzagw() {
        zzepl.zza(this.f10774a, Context.class);
        zzepl.zza(this.f10775b, String.class);
        return new C2317qa(this.f10776c, this.f10774a, this.f10775b);
    }

    public final /* synthetic */ zzdii zzbz(Context context) {
        this.f10774a = (Context) zzepl.checkNotNull(context);
        return this;
    }

    public final /* synthetic */ zzdii zzfr(String str) {
        this.f10775b = (String) zzepl.checkNotNull(str);
        return this;
    }
}
