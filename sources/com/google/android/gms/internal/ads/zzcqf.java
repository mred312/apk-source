package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcqf implements zzepf<zzcqe> {

    /* renamed from: a */
    private final zzeps<Context> f14711a;

    /* renamed from: b */
    private final zzeps<zzbqz> f14712b;

    /* renamed from: c */
    private final zzeps<zzcpx> f14713c;

    /* renamed from: d */
    private final zzeps<zzcpr> f14714d;

    private zzcqf(zzeps<Context> zzeps, zzeps<zzbqz> zzeps2, zzeps<zzcpx> zzeps3, zzeps<zzcpr> zzeps4) {
        this.f14711a = zzeps;
        this.f14712b = zzeps2;
        this.f14713c = zzeps3;
        this.f14714d = zzeps4;
    }

    public static zzcqf zze(zzeps<Context> zzeps, zzeps<zzbqz> zzeps2, zzeps<zzcpx> zzeps3, zzeps<zzcpr> zzeps4) {
        return new zzcqf(zzeps, zzeps2, zzeps3, zzeps4);
    }

    public final /* synthetic */ Object get() {
        return new zzcqe(this.f14711a.get(), this.f14712b.get(), this.f14713c.get(), this.f14714d.get());
    }
}
