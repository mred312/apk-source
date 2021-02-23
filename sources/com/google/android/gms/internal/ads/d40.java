package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class d40<V> extends j30<V> implements RunnableFuture<V> {

    /* renamed from: h */
    private volatile q30<?> f8050h;

    private d40(Callable<V> callable) {
        this.f8050h = new e40(this, callable);
    }

    /* renamed from: t */
    static <V> d40<V> m5922t(Runnable runnable, @NullableDecl V v) {
        return new d40<>(Executors.callable(runnable, v));
    }

    /* renamed from: u */
    static <V> d40<V> m5923u(Callable<V> callable) {
        return new d40<>(callable);
    }

    /* access modifiers changed from: protected */
    public final void afterDone() {
        q30<?> q30;
        super.afterDone();
        if (wasInterrupted() && (q30 = this.f8050h) != null) {
            q30.mo14632a();
        }
        this.f8050h = null;
    }

    /* access modifiers changed from: protected */
    public final String pendingToString() {
        q30<?> q30 = this.f8050h;
        if (q30 == null) {
            return super.pendingToString();
        }
        String valueOf = String.valueOf(q30);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 7);
        sb.append("task=[");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }

    public final void run() {
        q30<?> q30 = this.f8050h;
        if (q30 != null) {
            q30.run();
        }
        this.f8050h = null;
    }

    d40(zzdxz<V> zzdxz) {
        this.f8050h = new c40(this, zzdxz);
    }
}
