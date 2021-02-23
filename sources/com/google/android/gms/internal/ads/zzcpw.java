package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcpw implements zzepf<zzcpr> {

    /* renamed from: a */
    private final zzeps<zzcpp> f14691a;

    /* renamed from: b */
    private final zzeps<zzdzc> f14692b;

    private zzcpw(zzeps<zzcpp> zzeps, zzeps<zzdzc> zzeps2) {
        this.f14691a = zzeps;
        this.f14692b = zzeps2;
    }

    public static zzcpw zzax(zzeps<zzcpp> zzeps, zzeps<zzdzc> zzeps2) {
        return new zzcpw(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzcpr(this.f14691a.get(), this.f14692b.get());
    }
}
