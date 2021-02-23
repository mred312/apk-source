package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdjc implements zzepf<zzdjd> {

    /* renamed from: a */
    private final zzeps<Context> f15683a;

    /* renamed from: b */
    private final zzeps<Executor> f15684b;

    /* renamed from: c */
    private final zzeps<zzbgm> f15685c;

    /* renamed from: d */
    private final zzeps<zzdkl<zzblp, zzblv>> f15686d;

    /* renamed from: e */
    private final zzeps<zzdir> f15687e;

    /* renamed from: f */
    private final zzeps<zzdnp> f15688f;

    public zzdjc(zzeps<Context> zzeps, zzeps<Executor> zzeps2, zzeps<zzbgm> zzeps3, zzeps<zzdkl<zzblp, zzblv>> zzeps4, zzeps<zzdir> zzeps5, zzeps<zzdnp> zzeps6) {
        this.f15683a = zzeps;
        this.f15684b = zzeps2;
        this.f15685c = zzeps3;
        this.f15686d = zzeps4;
        this.f15687e = zzeps5;
        this.f15688f = zzeps6;
    }

    public final /* synthetic */ Object get() {
        return new zzdjd(this.f15683a.get(), this.f15684b.get(), this.f15685c.get(), this.f15686d.get(), this.f15687e.get(), this.f15688f.get());
    }
}
