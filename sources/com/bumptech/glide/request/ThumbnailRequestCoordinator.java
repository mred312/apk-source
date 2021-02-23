package com.bumptech.glide.request;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.RequestCoordinator;

public class ThumbnailRequestCoordinator implements RequestCoordinator, Request {
    @Nullable

    /* renamed from: a */
    private final RequestCoordinator f6398a;

    /* renamed from: b */
    private final Object f6399b;

    /* renamed from: c */
    private volatile Request f6400c;

    /* renamed from: d */
    private volatile Request f6401d;
    @GuardedBy("requestLock")

    /* renamed from: e */
    private RequestCoordinator.RequestState f6402e;
    @GuardedBy("requestLock")

    /* renamed from: f */
    private RequestCoordinator.RequestState f6403f;
    @GuardedBy("requestLock")

    /* renamed from: g */
    private boolean f6404g;

    public ThumbnailRequestCoordinator(Object obj, @Nullable RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f6402e = requestState;
        this.f6403f = requestState;
        this.f6399b = obj;
        this.f6398a = requestCoordinator;
    }

    /* renamed from: a */
    private boolean m4704a() {
        boolean z;
        synchronized (this.f6399b) {
            RequestCoordinator.RequestState requestState = this.f6402e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.SUCCESS;
            if (requestState != requestState2) {
                if (this.f6403f != requestState2) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    @GuardedBy("requestLock")
    /* renamed from: b */
    private boolean m4705b() {
        RequestCoordinator requestCoordinator = this.f6398a;
        return requestCoordinator == null || requestCoordinator.canNotifyCleared(this);
    }

    @GuardedBy("requestLock")
    /* renamed from: c */
    private boolean m4706c() {
        RequestCoordinator requestCoordinator = this.f6398a;
        return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
    }

    @GuardedBy("requestLock")
    /* renamed from: d */
    private boolean m4707d() {
        RequestCoordinator requestCoordinator = this.f6398a;
        return requestCoordinator == null || requestCoordinator.canSetImage(this);
    }

    @GuardedBy("requestLock")
    /* renamed from: e */
    private boolean m4708e() {
        RequestCoordinator requestCoordinator = this.f6398a;
        return requestCoordinator != null && requestCoordinator.isAnyResourceSet();
    }

    public void begin() {
        RequestCoordinator.RequestState requestState;
        RequestCoordinator.RequestState requestState2;
        synchronized (this.f6399b) {
            this.f6404g = true;
            try {
                if (!(this.f6402e == RequestCoordinator.RequestState.SUCCESS || this.f6403f == (requestState2 = RequestCoordinator.RequestState.RUNNING))) {
                    this.f6403f = requestState2;
                    this.f6401d.begin();
                }
                if (this.f6404g && this.f6402e != (requestState = RequestCoordinator.RequestState.RUNNING)) {
                    this.f6402e = requestState;
                    this.f6400c.begin();
                }
            } finally {
                this.f6404g = false;
            }
        }
    }

    public boolean canNotifyCleared(Request request) {
        boolean z;
        synchronized (this.f6399b) {
            z = m4705b() && request.equals(this.f6400c) && this.f6402e != RequestCoordinator.RequestState.PAUSED;
        }
        return z;
    }

    public boolean canNotifyStatusChanged(Request request) {
        boolean z;
        synchronized (this.f6399b) {
            z = m4706c() && request.equals(this.f6400c) && !m4704a();
        }
        return z;
    }

    public boolean canSetImage(Request request) {
        boolean z;
        synchronized (this.f6399b) {
            z = m4707d() && (request.equals(this.f6400c) || this.f6402e != RequestCoordinator.RequestState.SUCCESS);
        }
        return z;
    }

    public void clear() {
        synchronized (this.f6399b) {
            this.f6404g = false;
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.f6402e = requestState;
            this.f6403f = requestState;
            this.f6401d.clear();
            this.f6400c.clear();
        }
    }

    public boolean isAnyResourceSet() {
        boolean z;
        synchronized (this.f6399b) {
            if (!m4708e()) {
                if (!m4704a()) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public boolean isCleared() {
        boolean z;
        synchronized (this.f6399b) {
            z = this.f6402e == RequestCoordinator.RequestState.CLEARED;
        }
        return z;
    }

    public boolean isComplete() {
        boolean z;
        synchronized (this.f6399b) {
            z = this.f6402e == RequestCoordinator.RequestState.SUCCESS;
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isEquivalentTo(com.bumptech.glide.request.Request r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof com.bumptech.glide.request.ThumbnailRequestCoordinator
            r1 = 0
            if (r0 == 0) goto L_0x002e
            com.bumptech.glide.request.ThumbnailRequestCoordinator r4 = (com.bumptech.glide.request.ThumbnailRequestCoordinator) r4
            com.bumptech.glide.request.Request r0 = r3.f6400c
            if (r0 != 0) goto L_0x0010
            com.bumptech.glide.request.Request r0 = r4.f6400c
            if (r0 != 0) goto L_0x002e
            goto L_0x001a
        L_0x0010:
            com.bumptech.glide.request.Request r0 = r3.f6400c
            com.bumptech.glide.request.Request r2 = r4.f6400c
            boolean r0 = r0.isEquivalentTo(r2)
            if (r0 == 0) goto L_0x002e
        L_0x001a:
            com.bumptech.glide.request.Request r0 = r3.f6401d
            if (r0 != 0) goto L_0x0023
            com.bumptech.glide.request.Request r4 = r4.f6401d
            if (r4 != 0) goto L_0x002e
            goto L_0x002d
        L_0x0023:
            com.bumptech.glide.request.Request r0 = r3.f6401d
            com.bumptech.glide.request.Request r4 = r4.f6401d
            boolean r4 = r0.isEquivalentTo(r4)
            if (r4 == 0) goto L_0x002e
        L_0x002d:
            r1 = 1
        L_0x002e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ThumbnailRequestCoordinator.isEquivalentTo(com.bumptech.glide.request.Request):boolean");
    }

    public boolean isRunning() {
        boolean z;
        synchronized (this.f6399b) {
            z = this.f6402e == RequestCoordinator.RequestState.RUNNING;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequestFailed(com.bumptech.glide.request.Request r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f6399b
            monitor-enter(r0)
            com.bumptech.glide.request.Request r1 = r2.f6400c     // Catch:{ all -> 0x001e }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x001e }
            if (r3 != 0) goto L_0x0011
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x001e }
            r2.f6403f = r3     // Catch:{ all -> 0x001e }
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return
        L_0x0011:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x001e }
            r2.f6402e = r3     // Catch:{ all -> 0x001e }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.f6398a     // Catch:{ all -> 0x001e }
            if (r3 == 0) goto L_0x001c
            r3.onRequestFailed(r2)     // Catch:{ all -> 0x001e }
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return
        L_0x001e:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ThumbnailRequestCoordinator.onRequestFailed(com.bumptech.glide.request.Request):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequestSuccess(com.bumptech.glide.request.Request r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f6399b
            monitor-enter(r0)
            com.bumptech.glide.request.Request r1 = r2.f6401d     // Catch:{ all -> 0x002b }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x0011
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS     // Catch:{ all -> 0x002b }
            r2.f6403f = r3     // Catch:{ all -> 0x002b }
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x0011:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS     // Catch:{ all -> 0x002b }
            r2.f6402e = r3     // Catch:{ all -> 0x002b }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.f6398a     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x001c
            r3.onRequestSuccess(r2)     // Catch:{ all -> 0x002b }
        L_0x001c:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = r2.f6403f     // Catch:{ all -> 0x002b }
            boolean r3 = r3.mo10132a()     // Catch:{ all -> 0x002b }
            if (r3 != 0) goto L_0x0029
            com.bumptech.glide.request.Request r3 = r2.f6401d     // Catch:{ all -> 0x002b }
            r3.clear()     // Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ThumbnailRequestCoordinator.onRequestSuccess(com.bumptech.glide.request.Request):void");
    }

    public void pause() {
        synchronized (this.f6399b) {
            if (!this.f6403f.mo10132a()) {
                this.f6403f = RequestCoordinator.RequestState.PAUSED;
                this.f6401d.pause();
            }
            if (!this.f6402e.mo10132a()) {
                this.f6402e = RequestCoordinator.RequestState.PAUSED;
                this.f6400c.pause();
            }
        }
    }

    public void setRequests(Request request, Request request2) {
        this.f6400c = request;
        this.f6401d = request2;
    }
}
