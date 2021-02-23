package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcgc implements zzepf<zzcfz> {

    /* renamed from: a */
    private final zzeps<String> f14297a;

    /* renamed from: b */
    private final zzeps<zzcbt> f14298b;

    /* renamed from: c */
    private final zzeps<zzcce> f14299c;

    private zzcgc(zzeps<String> zzeps, zzeps<zzcbt> zzeps2, zzeps<zzcce> zzeps3) {
        this.f14297a = zzeps;
        this.f14298b = zzeps2;
        this.f14299c = zzeps3;
    }

    public static zzcgc zzm(zzeps<String> zzeps, zzeps<zzcbt> zzeps2, zzeps<zzcce> zzeps3) {
        return new zzcgc(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzcfz(this.f14297a.get(), this.f14298b.get(), this.f14299c.get());
    }
}
