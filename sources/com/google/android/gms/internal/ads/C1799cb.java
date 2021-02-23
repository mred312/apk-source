package com.google.android.gms.internal.ads;

import android.content.Context;

/* renamed from: com.google.android.gms.internal.ads.cb */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1799cb implements zzdmp {

    /* renamed from: a */
    private Context f7982a;

    /* renamed from: b */
    private String f7983b;

    /* renamed from: c */
    private final /* synthetic */ zzbhg f7984c;

    private C1799cb(zzbhg zzbhg) {
        this.f7984c = zzbhg;
    }

    public final zzdmm zzahn() {
        zzepl.zza(this.f7982a, Context.class);
        return new C1762bb(this.f7984c, this.f7982a, this.f7983b);
    }

    public final /* synthetic */ zzdmp zzcb(Context context) {
        this.f7982a = (Context) zzepl.checkNotNull(context);
        return this;
    }

    public final /* synthetic */ zzdmp zzft(String str) {
        this.f7983b = str;
        return this;
    }
}
