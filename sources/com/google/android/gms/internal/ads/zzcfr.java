package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcfr implements zzepf<zzcfo> {

    /* renamed from: a */
    private final zzeps<Executor> f14271a;

    /* renamed from: b */
    private final zzeps<zzbkr> f14272b;

    /* renamed from: c */
    private final zzeps<zzbxx> f14273c;

    public zzcfr(zzeps<Executor> zzeps, zzeps<zzbkr> zzeps2, zzeps<zzbxx> zzeps3) {
        this.f14271a = zzeps;
        this.f14272b = zzeps2;
        this.f14273c = zzeps3;
    }

    public final /* synthetic */ Object get() {
        return new zzcfo(this.f14271a.get(), this.f14272b.get(), this.f14273c.get());
    }
}
