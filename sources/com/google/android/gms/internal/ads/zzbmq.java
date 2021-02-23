package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbmq implements zzepf<zzbme> {

    /* renamed from: a */
    private final zzbmh f13512a;

    /* renamed from: b */
    private final zzeps<C1911fc> f13513b;

    public zzbmq(zzbmh zzbmh, zzeps<C1911fc> zzeps) {
        this.f13512a = zzbmh;
        this.f13513b = zzeps;
    }

    public static zzbme zza(zzbmh zzbmh, Object obj) {
        return (zzbme) zzepl.zza((C1911fc) obj, "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.f13512a, this.f13513b.get());
    }
}
