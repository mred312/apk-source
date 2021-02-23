package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdbk implements zzepf<zzdbg> {

    /* renamed from: a */
    private final zzeps<Context> f15177a;

    /* renamed from: b */
    private final zzeps<ScheduledExecutorService> f15178b;

    /* renamed from: c */
    private final zzeps<Executor> f15179c;

    private zzdbk(zzeps<Context> zzeps, zzeps<ScheduledExecutorService> zzeps2, zzeps<Executor> zzeps3) {
        this.f15177a = zzeps;
        this.f15178b = zzeps2;
        this.f15179c = zzeps3;
    }

    public static zzdbk zzt(zzeps<Context> zzeps, zzeps<ScheduledExecutorService> zzeps2, zzeps<Executor> zzeps3) {
        return new zzdbk(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzdbg(this.f15177a.get(), this.f15178b.get(), this.f15179c.get());
    }
}
