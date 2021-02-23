package com.bumptech.glide.request;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.RequestCoordinator;

public final class ErrorRequestCoordinator implements RequestCoordinator, Request {

    /* renamed from: a */
    private final Object f6334a;
    @Nullable

    /* renamed from: b */
    private final RequestCoordinator f6335b;

    /* renamed from: c */
    private volatile Request f6336c;

    /* renamed from: d */
    private volatile Request f6337d;
    @GuardedBy("requestLock")

    /* renamed from: e */
    private RequestCoordinator.RequestState f6338e;
    @GuardedBy("requestLock")

    /* renamed from: f */
    private RequestCoordinator.RequestState f6339f;

    public ErrorRequestCoordinator(Object obj, @Nullable RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f6338e = requestState;
        this.f6339f = requestState;
        this.f6334a = obj;
        this.f6335b = requestCoordinator;
    }

    @GuardedBy("requestLock")
    /* renamed from: a */
    private boolean m4678a(Request request) {
        return request.equals(this.f6336c) || (this.f6338e == RequestCoordinator.RequestState.FAILED && request.equals(this.f6337d));
    }

    @GuardedBy("requestLock")
    /* renamed from: b */
    private boolean m4679b() {
        RequestCoordinator requestCoordinator = this.f6335b;
        return requestCoordinator == null || requestCoordinator.canNotifyCleared(this);
    }

    @GuardedBy("requestLock")
    /* renamed from: c */
    private boolean m4680c() {
        RequestCoordinator requestCoordinator = this.f6335b;
        return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
    }

    @GuardedBy("requestLock")
    /* renamed from: d */
    private boolean m4681d() {
        RequestCoordinator requestCoordinator = this.f6335b;
        return requestCoordinator == null || requestCoordinator.canSetImage(this);
    }

    @GuardedBy("requestLock")
    /* renamed from: e */
    private boolean m4682e() {
        RequestCoordinator requestCoordinator = this.f6335b;
        return requestCoordinator != null && requestCoordinator.isAnyResourceSet();
    }

    public void begin() {
        synchronized (this.f6334a) {
            RequestCoordinator.RequestState requestState = this.f6338e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState != requestState2) {
                this.f6338e = requestState2;
                this.f6336c.begin();
            }
        }
    }

    public boolean canNotifyCleared(Request request) {
        boolean z;
        synchronized (this.f6334a) {
            z = m4679b() && m4678a(request);
        }
        return z;
    }

    public boolean canNotifyStatusChanged(Request request) {
        boolean z;
        synchronized (this.f6334a) {
            z = m4680c() && m4678a(request);
        }
        return z;
    }

    public boolean canSetImage(Request request) {
        boolean z;
        synchronized (this.f6334a) {
            z = m4681d() && m4678a(request);
        }
        return z;
    }

    public void clear() {
        synchronized (this.f6334a) {
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.f6338e = requestState;
            this.f6336c.clear();
            if (this.f6339f != requestState) {
                this.f6339f = requestState;
                this.f6337d.clear();
            }
        }
    }

    public boolean isAnyResourceSet() {
        boolean z;
        synchronized (this.f6334a) {
            if (!m4682e()) {
                if (!isComplete()) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public boolean isCleared() {
        boolean z;
        synchronized (this.f6334a) {
            RequestCoordinator.RequestState requestState = this.f6338e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.CLEARED;
            z = requestState == requestState2 && this.f6339f == requestState2;
        }
        return z;
    }

    public boolean isComplete() {
        boolean z;
        synchronized (this.f6334a) {
            RequestCoordinator.RequestState requestState = this.f6338e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.SUCCESS;
            if (requestState != requestState2) {
                if (this.f6339f != requestState2) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public boolean isEquivalentTo(Request request) {
        if (!(request instanceof ErrorRequestCoordinator)) {
            return false;
        }
        ErrorRequestCoordinator errorRequestCoordinator = (ErrorRequestCoordinator) request;
        if (!this.f6336c.isEquivalentTo(errorRequestCoordinator.f6336c) || !this.f6337d.isEquivalentTo(errorRequestCoordinator.f6337d)) {
            return false;
        }
        return true;
    }

    public boolean isRunning() {
        boolean z;
        synchronized (this.f6334a) {
            RequestCoordinator.RequestState requestState = this.f6338e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState != requestState2) {
                if (this.f6339f != requestState2) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequestFailed(com.bumptech.glide.request.Request r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f6334a
            monitor-enter(r0)
            com.bumptech.glide.request.Request r1 = r2.f6337d     // Catch:{ all -> 0x002b }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x002b }
            if (r3 != 0) goto L_0x001e
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x002b }
            r2.f6338e = r3     // Catch:{ all -> 0x002b }
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = r2.f6339f     // Catch:{ all -> 0x002b }
            com.bumptech.glide.request.RequestCoordinator$RequestState r1 = com.bumptech.glide.request.RequestCoordinator.RequestState.RUNNING     // Catch:{ all -> 0x002b }
            if (r3 == r1) goto L_0x001c
            r2.f6339f = r1     // Catch:{ all -> 0x002b }
            com.bumptech.glide.request.Request r3 = r2.f6337d     // Catch:{ all -> 0x002b }
            r3.begin()     // Catch:{ all -> 0x002b }
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x001e:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x002b }
            r2.f6339f = r3     // Catch:{ all -> 0x002b }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.f6335b     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x0029
            r3.onRequestFailed(r2)     // Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ErrorRequestCoordinator.onRequestFailed(com.bumptech.glide.request.Request):void");
    }

    public void onRequestSuccess(Request request) {
        synchronized (this.f6334a) {
            if (request.equals(this.f6336c)) {
                this.f6338e = RequestCoordinator.RequestState.SUCCESS;
            } else if (request.equals(this.f6337d)) {
                this.f6339f = RequestCoordinator.RequestState.SUCCESS;
            }
            RequestCoordinator requestCoordinator = this.f6335b;
            if (requestCoordinator != null) {
                requestCoordinator.onRequestSuccess(this);
            }
        }
    }

    public void pause() {
        synchronized (this.f6334a) {
            RequestCoordinator.RequestState requestState = this.f6338e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState == requestState2) {
                this.f6338e = RequestCoordinator.RequestState.PAUSED;
                this.f6336c.pause();
            }
            if (this.f6339f == requestState2) {
                this.f6339f = RequestCoordinator.RequestState.PAUSED;
                this.f6337d.pause();
            }
        }
    }

    public void setRequests(Request request, Request request2) {
        this.f6336c = request;
        this.f6337d = request2;
    }
}
