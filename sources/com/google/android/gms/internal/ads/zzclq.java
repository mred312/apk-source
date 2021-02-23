package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzclq implements zzepf<zzcln> {

    /* renamed from: a */
    private final zzeps<zzclb> f14574a;

    /* renamed from: b */
    private final zzeps<zzbgm> f14575b;

    private zzclq(zzeps<zzclb> zzeps, zzeps<zzbgm> zzeps2) {
        this.f14574a = zzeps;
        this.f14575b = zzeps2;
    }

    public static zzclq zzap(zzeps<zzclb> zzeps, zzeps<zzbgm> zzeps2) {
        return new zzclq(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzcln(this.f14574a.get(), this.f14575b.get());
    }
}
