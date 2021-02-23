package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzckn implements zzepf<zzcko> {

    /* renamed from: a */
    private final zzeps<zzckv> f14503a;

    /* renamed from: b */
    private final zzeps<zzayq> f14504b;

    private zzckn(zzeps<zzckv> zzeps, zzeps<zzayq> zzeps2) {
        this.f14503a = zzeps;
        this.f14504b = zzeps2;
    }

    public static zzckn zzao(zzeps<zzckv> zzeps, zzeps<zzayq> zzeps2) {
        return new zzckn(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzcko(this.f14503a.get(), this.f14504b.get());
    }
}
