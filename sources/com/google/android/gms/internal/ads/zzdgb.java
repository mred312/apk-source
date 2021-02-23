package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdgb implements zzepf<zzdfw> {

    /* renamed from: a */
    private final zzeps<zzayc> f15569a;

    /* renamed from: b */
    private final zzeps<Context> f15570b;

    /* renamed from: c */
    private final zzeps<ScheduledExecutorService> f15571c;

    /* renamed from: d */
    private final zzeps<Executor> f15572d;

    public zzdgb(zzeps<zzayc> zzeps, zzeps<Context> zzeps2, zzeps<ScheduledExecutorService> zzeps3, zzeps<Executor> zzeps4) {
        this.f15569a = zzeps;
        this.f15570b = zzeps2;
        this.f15571c = zzeps3;
        this.f15572d = zzeps4;
    }

    public final /* synthetic */ Object get() {
        return new zzdfw(this.f15569a.get(), this.f15570b.get(), this.f15571c.get(), this.f15572d.get());
    }
}
