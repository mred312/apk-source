package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbnw implements zzepf<zzbnt> {

    /* renamed from: a */
    private final zzeps<zzdmu> f13566a;

    /* renamed from: b */
    private final zzeps<zzbsl> f13567b;

    /* renamed from: c */
    private final zzeps<zzbtn> f13568c;

    private zzbnw(zzeps<zzdmu> zzeps, zzeps<zzbsl> zzeps2, zzeps<zzbtn> zzeps3) {
        this.f13566a = zzeps;
        this.f13567b = zzeps2;
        this.f13568c = zzeps3;
    }

    public static zzbnw zzf(zzeps<zzdmu> zzeps, zzeps<zzbsl> zzeps2, zzeps<zzbtn> zzeps3) {
        return new zzbnw(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzbnt(this.f13566a.get(), this.f13567b.get(), this.f13568c.get());
    }
}
