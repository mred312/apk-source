package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcrt implements zzepf<zzcrp> {

    /* renamed from: a */
    private final zzeps<zzblg> f14753a;

    /* renamed from: b */
    private final zzeps<Context> f14754b;

    /* renamed from: c */
    private final zzeps<Executor> f14755c;

    /* renamed from: d */
    private final zzeps<zzchp> f14756d;

    public zzcrt(zzeps<zzblg> zzeps, zzeps<Context> zzeps2, zzeps<Executor> zzeps3, zzeps<zzchp> zzeps4) {
        this.f14753a = zzeps;
        this.f14754b = zzeps2;
        this.f14755c = zzeps3;
        this.f14756d = zzeps4;
    }

    public final /* synthetic */ Object get() {
        return new zzcrp(this.f14753a.get(), this.f14754b.get(), this.f14755c.get(), this.f14756d.get());
    }
}
