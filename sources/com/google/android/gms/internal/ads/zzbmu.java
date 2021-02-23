package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbmu implements zzepf<zzbxy<zzbtj>> {

    /* renamed from: a */
    private final zzbmh f13518a;

    /* renamed from: b */
    private final zzeps<zzbnr> f13519b;

    public zzbmu(zzbmh zzbmh, zzeps<zzbnr> zzeps) {
        this.f13518a = zzbmh;
        this.f13519b = zzeps;
    }

    public static zzbxy<zzbtj> zza(zzbmh zzbmh, zzbnr zzbnr) {
        return (zzbxy) zzepl.zza(new zzbxy(zzbnr, zzazj.zzegt), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.f13518a, this.f13519b.get());
    }
}
