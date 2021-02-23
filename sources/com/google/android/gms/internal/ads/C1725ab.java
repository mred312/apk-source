package com.google.android.gms.internal.ads;

import android.content.Context;

/* renamed from: com.google.android.gms.internal.ads.ab */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1725ab implements zzdlc {

    /* renamed from: a */
    private Context f7799a;

    /* renamed from: b */
    private String f7800b;

    /* renamed from: c */
    private zzvn f7801c;

    /* renamed from: d */
    private final /* synthetic */ zzbhg f7802d;

    private C1725ab(zzbhg zzbhg) {
        this.f7802d = zzbhg;
    }

    public final zzdld zzahk() {
        zzepl.zza(this.f7799a, Context.class);
        zzepl.zza(this.f7800b, String.class);
        zzepl.zza(this.f7801c, zzvn.class);
        return new C2656za(this.f7802d, this.f7799a, this.f7800b, this.f7801c);
    }

    public final /* synthetic */ zzdlc zzc(zzvn zzvn) {
        this.f7801c = (zzvn) zzepl.checkNotNull(zzvn);
        return this;
    }

    public final /* synthetic */ zzdlc zzca(Context context) {
        this.f7799a = (Context) zzepl.checkNotNull(context);
        return this;
    }

    public final /* synthetic */ zzdlc zzfs(String str) {
        this.f7800b = (String) zzepl.checkNotNull(str);
        return this;
    }
}
