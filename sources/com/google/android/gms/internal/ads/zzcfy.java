package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcfy implements zzepf<zzcft> {

    /* renamed from: a */
    private final zzeps<zzcbt> f14285a;

    /* renamed from: b */
    private final zzeps<zzcce> f14286b;

    private zzcfy(zzeps<zzcbt> zzeps, zzeps<zzcce> zzeps2) {
        this.f14285a = zzeps;
        this.f14286b = zzeps2;
    }

    public static zzcfy zzz(zzeps<zzcbt> zzeps, zzeps<zzcce> zzeps2) {
        return new zzcfy(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzcft(this.f14285a.get(), this.f14286b.get());
    }
}
