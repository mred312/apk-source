package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbzy implements zzepf<zzbzv> {

    /* renamed from: a */
    private final zzeps<zzbtr> f13892a;

    /* renamed from: b */
    private final zzeps<zzbxu> f13893b;

    private zzbzy(zzeps<zzbtr> zzeps, zzeps<zzbxu> zzeps2) {
        this.f13892a = zzeps;
        this.f13893b = zzeps2;
    }

    public static zzbzy zzx(zzeps<zzbtr> zzeps, zzeps<zzbxu> zzeps2) {
        return new zzbzy(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzbzv(this.f13892a.get(), this.f13893b.get());
    }
}
