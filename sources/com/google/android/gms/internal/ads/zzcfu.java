package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcfu implements zzepf<zzcff> {

    /* renamed from: a */
    private final zzeps<zzdnn> f14279a;

    /* renamed from: b */
    private final zzeps<Executor> f14280b;

    /* renamed from: c */
    private final zzeps<zzchp> f14281c;

    public zzcfu(zzeps<zzdnn> zzeps, zzeps<Executor> zzeps2, zzeps<zzchp> zzeps3) {
        this.f14279a = zzeps;
        this.f14280b = zzeps2;
        this.f14281c = zzeps3;
    }

    public final /* synthetic */ Object get() {
        return new zzcff(this.f14279a.get(), this.f14280b.get(), this.f14281c.get());
    }
}
