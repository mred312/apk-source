package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdaz implements zzepf<zzdax> {

    /* renamed from: a */
    private final zzeps<zzdzc> f15158a;

    /* renamed from: b */
    private final zzeps<zzdnn> f15159b;

    /* renamed from: c */
    private final zzeps<zzazh> f15160c;

    private zzdaz(zzeps<zzdzc> zzeps, zzeps<zzdnn> zzeps2, zzeps<zzazh> zzeps3) {
        this.f15158a = zzeps;
        this.f15159b = zzeps2;
        this.f15160c = zzeps3;
    }

    public static zzdaz zzs(zzeps<zzdzc> zzeps, zzeps<zzdnn> zzeps2, zzeps<zzazh> zzeps3) {
        return new zzdaz(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzdax(this.f15158a.get(), this.f15159b.get(), this.f15160c.get());
    }
}
