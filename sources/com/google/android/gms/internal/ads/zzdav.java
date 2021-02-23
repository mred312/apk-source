package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdav implements zzepf<zzdat> {

    /* renamed from: a */
    private final zzeps<String> f15150a;

    /* renamed from: b */
    private final zzeps<zzdzc> f15151b;

    /* renamed from: c */
    private final zzeps<zzciq> f15152c;

    private zzdav(zzeps<String> zzeps, zzeps<zzdzc> zzeps2, zzeps<zzciq> zzeps3) {
        this.f15150a = zzeps;
        this.f15151b = zzeps2;
        this.f15152c = zzeps3;
    }

    public static zzdav zzr(zzeps<String> zzeps, zzeps<zzdzc> zzeps2, zzeps<zzciq> zzeps3) {
        return new zzdav(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzdat(this.f15150a.get(), this.f15151b.get(), this.f15152c.get());
    }
}
