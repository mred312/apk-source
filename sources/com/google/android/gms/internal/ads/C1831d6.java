package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.internal.ads.d6 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1831d6 extends zzdxr {

    /* renamed from: a */
    private final Executor f8052a;

    private C1831d6(Executor executor) {
        this.f8052a = executor;
    }

    public final boolean awaitTermination(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public final void execute(Runnable runnable) {
        this.f8052a.execute(runnable);
    }

    public final boolean isShutdown() {
        return false;
    }

    public final boolean isTerminated() {
        return false;
    }

    public final void shutdown() {
        throw new UnsupportedOperationException();
    }

    public final List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ C1831d6(Executor executor, C1720a6 a6Var) {
        this(executor);
    }
}
