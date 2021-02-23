package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
abstract class h30<T> extends q30<T> {

    /* renamed from: d */
    private final Executor f8827d;

    /* renamed from: e */
    private final /* synthetic */ f30 f8828e;

    h30(f30 f30, Executor executor) {
        this.f8828e = f30;
        this.f8827d = (Executor) zzdvv.checkNotNull(executor);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo13732b() {
        return this.f8828e.isDone();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final void mo13735e(T t, Throwable th) {
        h30 unused = this.f8828e.f8424p = null;
        if (th == null) {
            mo13866g(t);
        } else if (th instanceof ExecutionException) {
            this.f8828e.setException(th.getCause());
        } else if (th instanceof CancellationException) {
            this.f8828e.cancel(false);
        } else {
            this.f8828e.setException(th);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final void mo14078f() {
        try {
            this.f8827d.execute(this);
        } catch (RejectedExecutionException e) {
            this.f8828e.setException(e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public abstract void mo13866g(T t);
}
