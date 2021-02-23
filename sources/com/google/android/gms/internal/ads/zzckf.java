package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzckf implements zzepf<zzckg> {

    /* renamed from: a */
    private final zzeps<zzcko> f14491a;

    /* renamed from: b */
    private final zzeps<zzckv> f14492b;

    private zzckf(zzeps<zzcko> zzeps, zzeps<zzckv> zzeps2) {
        this.f14491a = zzeps;
        this.f14492b = zzeps2;
    }

    public static zzckf zzaj(zzeps<zzcko> zzeps, zzeps<zzckv> zzeps2) {
        return new zzckf(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzckg(this.f14491a.get(), this.f14492b.get());
    }
}
