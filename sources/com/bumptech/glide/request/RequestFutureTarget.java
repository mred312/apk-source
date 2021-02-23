package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestFutureTarget<R> implements FutureTarget<R>, RequestListener<R> {

    /* renamed from: k */
    private static final C1340a f6342k = new C1340a();

    /* renamed from: a */
    private final int f6343a;

    /* renamed from: b */
    private final int f6344b;

    /* renamed from: c */
    private final boolean f6345c;

    /* renamed from: d */
    private final C1340a f6346d;
    @GuardedBy("this")
    @Nullable

    /* renamed from: e */
    private R f6347e;
    @GuardedBy("this")
    @Nullable

    /* renamed from: f */
    private Request f6348f;
    @GuardedBy("this")

    /* renamed from: g */
    private boolean f6349g;
    @GuardedBy("this")

    /* renamed from: h */
    private boolean f6350h;
    @GuardedBy("this")

    /* renamed from: i */
    private boolean f6351i;
    @GuardedBy("this")
    @Nullable

    /* renamed from: j */
    private GlideException f6352j;

    @VisibleForTesting
    /* renamed from: com.bumptech.glide.request.RequestFutureTarget$a */
    static class C1340a {
        C1340a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo10140a(Object obj) {
            obj.notifyAll();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo10141b(Object obj, long j) {
            obj.wait(j);
        }
    }

    public RequestFutureTarget(int i, int i2) {
        this(i, i2, true, f6342k);
    }

    /* renamed from: a */
    private synchronized R m4684a(Long l) {
        if (this.f6345c && !isDone()) {
            Util.assertBackgroundThread();
        }
        if (this.f6349g) {
            throw new CancellationException();
        } else if (this.f6351i) {
            throw new ExecutionException(this.f6352j);
        } else if (this.f6350h) {
            return this.f6347e;
        } else {
            if (l == null) {
                this.f6346d.mo10141b(this, 0);
            } else if (l.longValue() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long longValue = l.longValue() + currentTimeMillis;
                while (!isDone() && currentTimeMillis < longValue) {
                    this.f6346d.mo10141b(this, longValue - currentTimeMillis);
                    currentTimeMillis = System.currentTimeMillis();
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            } else if (this.f6351i) {
                throw new ExecutionException(this.f6352j);
            } else if (this.f6349g) {
                throw new CancellationException();
            } else if (this.f6350h) {
                return this.f6347e;
            } else {
                throw new TimeoutException();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        if (r1 == null) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        r1.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancel(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.isDone()     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x000a
            r3 = 0
            monitor-exit(r2)     // Catch:{ all -> 0x0021 }
            return r3
        L_0x000a:
            r0 = 1
            r2.f6349g = r0     // Catch:{ all -> 0x0021 }
            com.bumptech.glide.request.RequestFutureTarget$a r1 = r2.f6346d     // Catch:{ all -> 0x0021 }
            r1.mo10140a(r2)     // Catch:{ all -> 0x0021 }
            r1 = 0
            if (r3 == 0) goto L_0x001a
            com.bumptech.glide.request.Request r3 = r2.f6348f     // Catch:{ all -> 0x0021 }
            r2.f6348f = r1     // Catch:{ all -> 0x0021 }
            r1 = r3
        L_0x001a:
            monitor-exit(r2)     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x0020
            r1.clear()
        L_0x0020:
            return r0
        L_0x0021:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0021 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.RequestFutureTarget.cancel(boolean):boolean");
    }

    public R get() {
        try {
            return m4684a((Long) null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Nullable
    public synchronized Request getRequest() {
        return this.f6348f;
    }

    public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.f6343a, this.f6344b);
    }

    public synchronized boolean isCancelled() {
        return this.f6349g;
    }

    public synchronized boolean isDone() {
        return this.f6349g || this.f6350h || this.f6351i;
    }

    public void onDestroy() {
    }

    public void onLoadCleared(@Nullable Drawable drawable) {
    }

    public synchronized void onLoadFailed(@Nullable Drawable drawable) {
    }

    public void onLoadStarted(@Nullable Drawable drawable) {
    }

    public synchronized void onResourceReady(@NonNull R r, @Nullable Transition<? super R> transition) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    public synchronized void setRequest(@Nullable Request request) {
        this.f6348f = request;
    }

    RequestFutureTarget(int i, int i2, boolean z, C1340a aVar) {
        this.f6343a = i;
        this.f6344b = i2;
        this.f6345c = z;
        this.f6346d = aVar;
    }

    public synchronized boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<R> target, boolean z) {
        this.f6351i = true;
        this.f6352j = glideException;
        this.f6346d.mo10140a(this);
        return false;
    }

    public synchronized boolean onResourceReady(R r, Object obj, Target<R> target, DataSource dataSource, boolean z) {
        this.f6350h = true;
        this.f6347e = r;
        this.f6346d.mo10140a(this);
        return false;
    }

    public R get(long j, @NonNull TimeUnit timeUnit) {
        return m4684a(Long.valueOf(timeUnit.toMillis(j)));
    }
}
