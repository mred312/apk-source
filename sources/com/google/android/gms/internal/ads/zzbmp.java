package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbmp implements zzepf<zzbxy<zzbtj>> {

    /* renamed from: a */
    private final zzbmh f13507a;

    /* renamed from: b */
    private final zzeps<Context> f13508b;

    /* renamed from: c */
    private final zzeps<zzazh> f13509c;

    /* renamed from: d */
    private final zzeps<zzdmu> f13510d;

    /* renamed from: e */
    private final zzeps<zzdnn> f13511e;

    public zzbmp(zzbmh zzbmh, zzeps<Context> zzeps, zzeps<zzazh> zzeps2, zzeps<zzdmu> zzeps3, zzeps<zzdnn> zzeps4) {
        this.f13507a = zzbmh;
        this.f13508b = zzeps;
        this.f13509c = zzeps2;
        this.f13510d = zzeps3;
        this.f13511e = zzeps4;
    }

    public static zzbxy<zzbtj> zza(zzbmh zzbmh, Context context, zzazh zzazh, zzdmu zzdmu, zzdnn zzdnn) {
        return (zzbxy) zzepl.zza(new zzbxy(new C1985hc(context, zzazh, zzdmu, zzdnn), zzazj.zzegu), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.f13507a, this.f13508b.get(), this.f13509c.get(), this.f13510d.get(), this.f13511e.get());
    }
}
