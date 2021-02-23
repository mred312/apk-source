package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdia implements zzepf<zzdib> {

    /* renamed from: a */
    private final zzeps<Context> f15646a;

    /* renamed from: b */
    private final zzeps<Executor> f15647b;

    /* renamed from: c */
    private final zzeps<zzbgm> f15648c;

    /* renamed from: d */
    private final zzeps<zzdkl<zzblg, zzbll>> f15649d;

    /* renamed from: e */
    private final zzeps<zzdir> f15650e;

    /* renamed from: f */
    private final zzeps<zzdnp> f15651f;

    public zzdia(zzeps<Context> zzeps, zzeps<Executor> zzeps2, zzeps<zzbgm> zzeps3, zzeps<zzdkl<zzblg, zzbll>> zzeps4, zzeps<zzdir> zzeps5, zzeps<zzdnp> zzeps6) {
        this.f15646a = zzeps;
        this.f15647b = zzeps2;
        this.f15648c = zzeps3;
        this.f15649d = zzeps4;
        this.f15650e = zzeps5;
        this.f15651f = zzeps6;
    }

    public final /* synthetic */ Object get() {
        return new zzdib(this.f15646a.get(), this.f15647b.get(), this.f15648c.get(), this.f15649d.get(), this.f15650e.get(), this.f15651f.get());
    }
}
