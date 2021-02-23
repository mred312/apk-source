package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdgo implements zzepf<zzdgk> {

    /* renamed from: a */
    private final zzeps<zzayc> f15594a;

    /* renamed from: b */
    private final zzeps<Integer> f15595b;

    /* renamed from: c */
    private final zzeps<Context> f15596c;

    /* renamed from: d */
    private final zzeps<zzayg> f15597d;

    /* renamed from: e */
    private final zzeps<ScheduledExecutorService> f15598e;

    /* renamed from: f */
    private final zzeps<Executor> f15599f;

    public zzdgo(zzeps<zzayc> zzeps, zzeps<Integer> zzeps2, zzeps<Context> zzeps3, zzeps<zzayg> zzeps4, zzeps<ScheduledExecutorService> zzeps5, zzeps<Executor> zzeps6) {
        this.f15594a = zzeps;
        this.f15595b = zzeps2;
        this.f15596c = zzeps3;
        this.f15597d = zzeps4;
        this.f15598e = zzeps5;
        this.f15599f = zzeps6;
    }

    public final /* synthetic */ Object get() {
        return new zzdgk(this.f15594a.get(), this.f15595b.get().intValue(), this.f15596c.get(), this.f15597d.get(), this.f15598e.get(), this.f15599f.get());
    }
}
