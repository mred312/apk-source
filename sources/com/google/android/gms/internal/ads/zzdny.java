package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdny implements zzepf<zzdnv> {

    /* renamed from: a */
    private final zzeps<zzcqo> f15812a;

    /* renamed from: b */
    private final zzeps<zzdrz> f15813b;

    /* renamed from: c */
    private final zzeps<zzdmu> f15814c;

    /* renamed from: d */
    private final zzeps<zzdmz> f15815d;

    private zzdny(zzeps<zzcqo> zzeps, zzeps<zzdrz> zzeps2, zzeps<zzdmu> zzeps3, zzeps<zzdmz> zzeps4) {
        this.f15812a = zzeps;
        this.f15813b = zzeps2;
        this.f15814c = zzeps3;
        this.f15815d = zzeps4;
    }

    public static zzdny zzj(zzeps<zzcqo> zzeps, zzeps<zzdrz> zzeps2, zzeps<zzdmu> zzeps3, zzeps<zzdmz> zzeps4) {
        return new zzdny(zzeps, zzeps2, zzeps3, zzeps4);
    }

    public final /* synthetic */ Object get() {
        return new zzdnv(this.f15812a.get(), this.f15813b.get(), this.f15814c.get(), this.f15815d.get());
    }
}
