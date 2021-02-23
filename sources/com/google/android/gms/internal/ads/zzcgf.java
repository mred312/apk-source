package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcgf implements zzepf<zzcgg> {

    /* renamed from: a */
    private final zzeps<String> f14304a;

    /* renamed from: b */
    private final zzeps<zzcbt> f14305b;

    /* renamed from: c */
    private final zzeps<zzcce> f14306c;

    private zzcgf(zzeps<String> zzeps, zzeps<zzcbt> zzeps2, zzeps<zzcce> zzeps3) {
        this.f14304a = zzeps;
        this.f14305b = zzeps2;
        this.f14306c = zzeps3;
    }

    public static zzcgf zzn(zzeps<String> zzeps, zzeps<zzcbt> zzeps2, zzeps<zzcce> zzeps3) {
        return new zzcgf(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzcgg(this.f14304a.get(), this.f14305b.get(), this.f14306c.get());
    }
}
