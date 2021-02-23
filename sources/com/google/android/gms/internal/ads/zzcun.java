package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcun implements zzepf<zzcuo> {

    /* renamed from: a */
    private final zzeps<zzdoa> f14897a;

    /* renamed from: b */
    private final zzeps<zzcil> f14898b;

    /* renamed from: c */
    private final zzeps<zzckq> f14899c;

    private zzcun(zzeps<zzdoa> zzeps, zzeps<zzcil> zzeps2, zzeps<zzckq> zzeps3) {
        this.f14897a = zzeps;
        this.f14898b = zzeps2;
        this.f14899c = zzeps3;
    }

    public static zzcun zzq(zzeps<zzdoa> zzeps, zzeps<zzcil> zzeps2, zzeps<zzckq> zzeps3) {
        return new zzcun(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzcuo(this.f14897a.get(), this.f14898b.get(), this.f14899c.get());
    }
}
