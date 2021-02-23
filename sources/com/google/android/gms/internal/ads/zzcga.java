package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcga implements zzepf<zzcfx> {

    /* renamed from: a */
    private final zzeps<String> f14290a;

    /* renamed from: b */
    private final zzeps<zzcbt> f14291b;

    /* renamed from: c */
    private final zzeps<zzcce> f14292c;

    private zzcga(zzeps<String> zzeps, zzeps<zzcbt> zzeps2, zzeps<zzcce> zzeps3) {
        this.f14290a = zzeps;
        this.f14291b = zzeps2;
        this.f14292c = zzeps3;
    }

    public static zzcga zzl(zzeps<String> zzeps, zzeps<zzcbt> zzeps2, zzeps<zzcce> zzeps3) {
        return new zzcga(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzcfx(this.f14290a.get(), this.f14291b.get(), this.f14292c.get());
    }
}
