package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class w30 extends t30 implements zzdzc, ScheduledExecutorService {

    /* renamed from: b */
    private final ScheduledExecutorService f11661b;

    w30(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.f11661b = (ScheduledExecutorService) zzdvv.checkNotNull(scheduledExecutorService);
    }

    public final /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        d40 u = d40.m5923u(callable);
        return new v30(u, this.f11661b.schedule(u, j, timeUnit));
    }

    public final /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        x30 x30 = new x30(runnable);
        return new v30(x30, this.f11661b.scheduleAtFixedRate(x30, j, j2, timeUnit));
    }

    public final /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        x30 x30 = new x30(runnable);
        return new v30(x30, this.f11661b.scheduleWithFixedDelay(x30, j, j2, timeUnit));
    }

    public final /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        d40 t = d40.m5922t(runnable, null);
        return new v30(t, this.f11661b.schedule(t, j, timeUnit));
    }
}
