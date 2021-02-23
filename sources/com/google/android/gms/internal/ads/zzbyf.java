package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbyf implements zzepf<zzbyg> {

    /* renamed from: a */
    private final zzeps<zzdmu> f13850a;

    /* renamed from: b */
    private final zzeps<zzdrz> f13851b;

    private zzbyf(zzeps<zzdmu> zzeps, zzeps<zzdrz> zzeps2) {
        this.f13850a = zzeps;
        this.f13851b = zzeps2;
    }

    public static zzbyf zzw(zzeps<zzdmu> zzeps, zzeps<zzdrz> zzeps2) {
        return new zzbyf(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzbyg(this.f13850a.get(), this.f13851b.get());
    }
}
