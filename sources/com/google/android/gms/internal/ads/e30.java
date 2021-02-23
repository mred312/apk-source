package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class e30 extends h30<V> {

    /* renamed from: f */
    private final Callable<V> f8311f;

    /* renamed from: g */
    private final /* synthetic */ f30 f8312g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    e30(f30 f30, Callable<V> callable, Executor executor) {
        super(f30, executor);
        this.f8312g = f30;
        this.f8311f = (Callable) zzdvv.checkNotNull(callable);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final V mo13733c() {
        return this.f8311f.call();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final String mo13734d() {
        return this.f8311f.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final void mo13866g(V v) {
        this.f8312g.set(v);
    }
}
