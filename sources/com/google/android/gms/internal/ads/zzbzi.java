package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbzi implements zzepf<zzbxy<zzbtj>> {

    /* renamed from: a */
    private final zzeps<Context> f13872a;

    /* renamed from: b */
    private final zzeps<zzazh> f13873b;

    /* renamed from: c */
    private final zzeps<zzdmu> f13874c;

    /* renamed from: d */
    private final zzeps<zzdnn> f13875d;

    private zzbzi(zzbzc zzbzc, zzeps<Context> zzeps, zzeps<zzazh> zzeps2, zzeps<zzdmu> zzeps3, zzeps<zzdnn> zzeps4) {
        this.f13872a = zzeps;
        this.f13873b = zzeps2;
        this.f13874c = zzeps3;
        this.f13875d = zzeps4;
    }

    public static zzbzi zza(zzbzc zzbzc, zzeps<Context> zzeps, zzeps<zzazh> zzeps2, zzeps<zzdmu> zzeps3, zzeps<zzdnn> zzeps4) {
        return new zzbzi(zzbzc, zzeps, zzeps2, zzeps3, zzeps4);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(new C2401sg(this.f13872a.get(), this.f13873b.get(), this.f13874c.get(), this.f13875d.get()), zzazj.zzegu), "Cannot return null from a non-@Nullable @Provides method");
    }
}
