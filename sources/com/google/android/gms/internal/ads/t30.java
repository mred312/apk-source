package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
class t30 extends zzdxr {

    /* renamed from: a */
    private final ExecutorService f11132a;

    t30(ExecutorService executorService) {
        this.f11132a = (ExecutorService) zzdvv.checkNotNull(executorService);
    }

    public final boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.f11132a.awaitTermination(j, timeUnit);
    }

    public final void execute(Runnable runnable) {
        this.f11132a.execute(runnable);
    }

    public final boolean isShutdown() {
        return this.f11132a.isShutdown();
    }

    public final boolean isTerminated() {
        return this.f11132a.isTerminated();
    }

    public final void shutdown() {
        this.f11132a.shutdown();
    }

    public final List<Runnable> shutdownNow() {
        return this.f11132a.shutdownNow();
    }
}
