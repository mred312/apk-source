package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdcd implements zzepf<zzdcb> {

    /* renamed from: a */
    private final zzeps<zzdzc> f15407a;

    /* renamed from: b */
    private final zzeps<zzcis> f15408b;

    /* renamed from: c */
    private final zzeps<zzdnn> f15409c;

    /* renamed from: d */
    private final zzeps<String> f15410d;

    private zzdcd(zzeps<zzdzc> zzeps, zzeps<zzcis> zzeps2, zzeps<zzdnn> zzeps3, zzeps<String> zzeps4) {
        this.f15407a = zzeps;
        this.f15408b = zzeps2;
        this.f15409c = zzeps3;
        this.f15410d = zzeps4;
    }

    public static zzdcd zzh(zzeps<zzdzc> zzeps, zzeps<zzcis> zzeps2, zzeps<zzdnn> zzeps3, zzeps<String> zzeps4) {
        return new zzdcd(zzeps, zzeps2, zzeps3, zzeps4);
    }

    public final /* synthetic */ Object get() {
        return new zzdcb(this.f15407a.get(), this.f15408b.get(), this.f15409c.get(), this.f15410d.get());
    }
}
