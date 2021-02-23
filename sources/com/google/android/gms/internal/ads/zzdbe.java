package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdbe implements zzepf<zzdbc> {

    /* renamed from: a */
    private final zzeps<String> f15169a;

    /* renamed from: b */
    private final zzeps<String> f15170b;

    /* renamed from: c */
    private final zzeps<zzbpo> f15171c;

    /* renamed from: d */
    private final zzeps<zzdon> f15172d;

    /* renamed from: e */
    private final zzeps<zzdnn> f15173e;

    private zzdbe(zzeps<String> zzeps, zzeps<String> zzeps2, zzeps<zzbpo> zzeps3, zzeps<zzdon> zzeps4, zzeps<zzdnn> zzeps5) {
        this.f15169a = zzeps;
        this.f15170b = zzeps2;
        this.f15171c = zzeps3;
        this.f15172d = zzeps4;
        this.f15173e = zzeps5;
    }

    public static zzdbe zzg(zzeps<String> zzeps, zzeps<String> zzeps2, zzeps<zzbpo> zzeps3, zzeps<zzdon> zzeps4, zzeps<zzdnn> zzeps5) {
        return new zzdbe(zzeps, zzeps2, zzeps3, zzeps4, zzeps5);
    }

    public final /* synthetic */ Object get() {
        return new zzdbc(this.f15169a.get(), this.f15170b.get(), this.f15171c.get(), this.f15172d.get(), this.f15173e.get());
    }
}
