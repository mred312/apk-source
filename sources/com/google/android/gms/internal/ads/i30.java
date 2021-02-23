package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class i30<V> extends zzdyi<V> {

    /* renamed from: h */
    private final zzdyz<V> f9253h;

    i30(zzdyz<V> zzdyz) {
        this.f9253h = (zzdyz) zzdvv.checkNotNull(zzdyz);
    }

    public final void addListener(Runnable runnable, Executor executor) {
        this.f9253h.addListener(runnable, executor);
    }

    public final boolean cancel(boolean z) {
        return this.f9253h.cancel(z);
    }

    public final V get() {
        return this.f9253h.get();
    }

    public final boolean isCancelled() {
        return this.f9253h.isCancelled();
    }

    public final boolean isDone() {
        return this.f9253h.isDone();
    }

    public final String toString() {
        return this.f9253h.toString();
    }

    public final V get(long j, TimeUnit timeUnit) {
        return this.f9253h.get(j, timeUnit);
    }
}
