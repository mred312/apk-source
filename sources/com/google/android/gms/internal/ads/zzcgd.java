package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcgd implements zzepf<zzcgb> {

    /* renamed from: a */
    private final zzeps<Context> f14300a;

    /* renamed from: b */
    private final zzeps<zzcce> f14301b;

    /* renamed from: c */
    private final zzeps<zzcda> f14302c;

    /* renamed from: d */
    private final zzeps<zzcbt> f14303d;

    private zzcgd(zzeps<Context> zzeps, zzeps<zzcce> zzeps2, zzeps<zzcda> zzeps3, zzeps<zzcbt> zzeps4) {
        this.f14300a = zzeps;
        this.f14301b = zzeps2;
        this.f14302c = zzeps3;
        this.f14303d = zzeps4;
    }

    public static zzcgd zzc(zzeps<Context> zzeps, zzeps<zzcce> zzeps2, zzeps<zzcda> zzeps3, zzeps<zzcbt> zzeps4) {
        return new zzcgd(zzeps, zzeps2, zzeps3, zzeps4);
    }

    public final /* synthetic */ Object get() {
        return new zzcgb(this.f14300a.get(), this.f14301b.get(), this.f14302c.get(), this.f14303d.get());
    }
}
