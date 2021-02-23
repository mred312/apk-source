package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class e40 extends q30<V> {

    /* renamed from: d */
    private final Callable<V> f8314d;

    /* renamed from: e */
    private final /* synthetic */ d40 f8315e;

    e40(d40 d40, Callable<V> callable) {
        this.f8315e = d40;
        this.f8314d = (Callable) zzdvv.checkNotNull(callable);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo13732b() {
        return this.f8315e.isDone();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final V mo13733c() {
        return this.f8314d.call();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final String mo13734d() {
        return this.f8314d.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final void mo13735e(V v, Throwable th) {
        if (th == null) {
            this.f8315e.set(v);
        } else {
            this.f8315e.setException(th);
        }
    }
}
