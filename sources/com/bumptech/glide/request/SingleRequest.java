package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.List;
import java.util.concurrent.Executor;

public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback {

    /* renamed from: D */
    private static final boolean f6361D = Log.isLoggable("Request", 2);
    @GuardedBy("requestLock")

    /* renamed from: A */
    private int f6362A;
    @GuardedBy("requestLock")

    /* renamed from: B */
    private boolean f6363B;
    @Nullable

    /* renamed from: C */
    private RuntimeException f6364C;
    @Nullable

    /* renamed from: a */
    private final String f6365a;

    /* renamed from: b */
    private final StateVerifier f6366b;

    /* renamed from: c */
    private final Object f6367c;
    @Nullable

    /* renamed from: d */
    private final RequestListener<R> f6368d;

    /* renamed from: e */
    private final RequestCoordinator f6369e;

    /* renamed from: f */
    private final Context f6370f;

    /* renamed from: g */
    private final GlideContext f6371g;
    @Nullable

    /* renamed from: h */
    private final Object f6372h;

    /* renamed from: i */
    private final Class<R> f6373i;

    /* renamed from: j */
    private final BaseRequestOptions<?> f6374j;

    /* renamed from: k */
    private final int f6375k;

    /* renamed from: l */
    private final int f6376l;

    /* renamed from: m */
    private final Priority f6377m;

    /* renamed from: n */
    private final Target<R> f6378n;
    @Nullable

    /* renamed from: o */
    private final List<RequestListener<R>> f6379o;

    /* renamed from: p */
    private final TransitionFactory<? super R> f6380p;

    /* renamed from: q */
    private final Executor f6381q;
    @GuardedBy("requestLock")

    /* renamed from: r */
    private Resource<R> f6382r;
    @GuardedBy("requestLock")

    /* renamed from: s */
    private Engine.LoadStatus f6383s;
    @GuardedBy("requestLock")

    /* renamed from: t */
    private long f6384t;

    /* renamed from: u */
    private volatile Engine f6385u;
    @GuardedBy("requestLock")

    /* renamed from: v */
    private C1341a f6386v;
    @GuardedBy("requestLock")
    @Nullable

    /* renamed from: w */
    private Drawable f6387w;
    @GuardedBy("requestLock")
    @Nullable

    /* renamed from: x */
    private Drawable f6388x;
    @GuardedBy("requestLock")
    @Nullable

    /* renamed from: y */
    private Drawable f6389y;
    @GuardedBy("requestLock")

    /* renamed from: z */
    private int f6390z;

    /* renamed from: com.bumptech.glide.request.SingleRequest$a */
    private enum C1341a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private SingleRequest(Context context, GlideContext glideContext, @NonNull Object obj, @Nullable Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i, int i2, Priority priority, Target<R> target, @Nullable RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        this.f6365a = f6361D ? String.valueOf(super.hashCode()) : null;
        this.f6366b = StateVerifier.newInstance();
        this.f6367c = obj;
        this.f6370f = context;
        this.f6371g = glideContext;
        this.f6372h = obj2;
        this.f6373i = cls;
        this.f6374j = baseRequestOptions;
        this.f6375k = i;
        this.f6376l = i2;
        this.f6377m = priority;
        this.f6378n = target;
        this.f6368d = requestListener;
        this.f6379o = list;
        this.f6369e = requestCoordinator;
        this.f6385u = engine;
        this.f6380p = transitionFactory;
        this.f6381q = executor;
        this.f6386v = C1341a.PENDING;
        if (this.f6364C == null && glideContext.isLoggingRequestOriginsEnabled()) {
            this.f6364C = new RuntimeException("Glide request origin trace");
        }
    }

    @GuardedBy("requestLock")
    /* renamed from: a */
    private void m4687a() {
        if (this.f6363B) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @GuardedBy("requestLock")
    /* renamed from: b */
    private boolean m4688b() {
        RequestCoordinator requestCoordinator = this.f6369e;
        return requestCoordinator == null || requestCoordinator.canNotifyCleared(this);
    }

    @GuardedBy("requestLock")
    /* renamed from: c */
    private boolean m4689c() {
        RequestCoordinator requestCoordinator = this.f6369e;
        return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
    }

    @GuardedBy("requestLock")
    /* renamed from: d */
    private boolean m4690d() {
        RequestCoordinator requestCoordinator = this.f6369e;
        return requestCoordinator == null || requestCoordinator.canSetImage(this);
    }

    @GuardedBy("requestLock")
    /* renamed from: e */
    private void m4691e() {
        m4687a();
        this.f6366b.throwIfRecycled();
        this.f6378n.removeCallback(this);
        Engine.LoadStatus loadStatus = this.f6383s;
        if (loadStatus != null) {
            loadStatus.cancel();
            this.f6383s = null;
        }
    }

    @GuardedBy("requestLock")
    /* renamed from: f */
    private Drawable m4692f() {
        if (this.f6387w == null) {
            Drawable errorPlaceholder = this.f6374j.getErrorPlaceholder();
            this.f6387w = errorPlaceholder;
            if (errorPlaceholder == null && this.f6374j.getErrorId() > 0) {
                this.f6387w = m4696j(this.f6374j.getErrorId());
            }
        }
        return this.f6387w;
    }

    @GuardedBy("requestLock")
    /* renamed from: g */
    private Drawable m4693g() {
        if (this.f6389y == null) {
            Drawable fallbackDrawable = this.f6374j.getFallbackDrawable();
            this.f6389y = fallbackDrawable;
            if (fallbackDrawable == null && this.f6374j.getFallbackId() > 0) {
                this.f6389y = m4696j(this.f6374j.getFallbackId());
            }
        }
        return this.f6389y;
    }

    @GuardedBy("requestLock")
    /* renamed from: h */
    private Drawable m4694h() {
        if (this.f6388x == null) {
            Drawable placeholderDrawable = this.f6374j.getPlaceholderDrawable();
            this.f6388x = placeholderDrawable;
            if (placeholderDrawable == null && this.f6374j.getPlaceholderId() > 0) {
                this.f6388x = m4696j(this.f6374j.getPlaceholderId());
            }
        }
        return this.f6388x;
    }

    @GuardedBy("requestLock")
    /* renamed from: i */
    private boolean m4695i() {
        RequestCoordinator requestCoordinator = this.f6369e;
        return requestCoordinator == null || !requestCoordinator.isAnyResourceSet();
    }

    @GuardedBy("requestLock")
    /* renamed from: j */
    private Drawable m4696j(@DrawableRes int i) {
        return DrawableDecoderCompat.getDrawable((Context) this.f6371g, i, this.f6374j.getTheme() != null ? this.f6374j.getTheme() : this.f6370f.getTheme());
    }

    /* renamed from: k */
    private void m4697k(String str) {
        Log.v("Request", str + " this: " + this.f6365a);
    }

    /* renamed from: l */
    private static int m4698l(int i, float f) {
        return i == Integer.MIN_VALUE ? i : Math.round(f * ((float) i));
    }

    @GuardedBy("requestLock")
    /* renamed from: m */
    private void m4699m() {
        RequestCoordinator requestCoordinator = this.f6369e;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestFailed(this);
        }
    }

    @GuardedBy("requestLock")
    /* renamed from: n */
    private void m4700n() {
        RequestCoordinator requestCoordinator = this.f6369e;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestSuccess(this);
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: o */
    private void m4701o(GlideException glideException, int i) {
        boolean z;
        this.f6366b.throwIfRecycled();
        synchronized (this.f6367c) {
            glideException.setOrigin(this.f6364C);
            int logLevel = this.f6371g.getLogLevel();
            if (logLevel <= i) {
                Log.w("Glide", "Load failed for " + this.f6372h + " with size [" + this.f6390z + "x" + this.f6362A + "]", glideException);
                if (logLevel <= 4) {
                    glideException.logRootCauses("Glide");
                }
            }
            this.f6383s = null;
            this.f6386v = C1341a.FAILED;
            boolean z2 = true;
            this.f6363B = true;
            try {
                List<RequestListener<R>> list = this.f6379o;
                if (list != null) {
                    z = false;
                    for (RequestListener<R> onLoadFailed : list) {
                        z |= onLoadFailed.onLoadFailed(glideException, this.f6372h, this.f6378n, m4695i());
                    }
                } else {
                    z = false;
                }
                RequestListener<R> requestListener = this.f6368d;
                if (requestListener == null || !requestListener.onLoadFailed(glideException, this.f6372h, this.f6378n, m4695i())) {
                    z2 = false;
                }
                if (!z && !z2) {
                    m4703q();
                }
                this.f6363B = false;
                m4699m();
            } catch (Throwable th) {
                this.f6363B = false;
                throw th;
            }
        }
    }

    public static <R> SingleRequest<R> obtain(Context context, GlideContext glideContext, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i, int i2, Priority priority, Target<R> target, RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        return new SingleRequest(context, glideContext, obj, obj2, cls, baseRequestOptions, i, i2, priority, target, requestListener, list, requestCoordinator, engine, transitionFactory, executor);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a7 A[Catch:{ all -> 0x00b8 }] */
    @androidx.annotation.GuardedBy("requestLock")
    /* renamed from: p */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4702p(com.bumptech.glide.load.engine.Resource<R> r11, R r12, com.bumptech.glide.load.DataSource r13) {
        /*
            r10 = this;
            boolean r6 = r10.m4695i()
            com.bumptech.glide.request.SingleRequest$a r0 = com.bumptech.glide.request.SingleRequest.C1341a.COMPLETE
            r10.f6386v = r0
            r10.f6382r = r11
            com.bumptech.glide.GlideContext r11 = r10.f6371g
            int r11 = r11.getLogLevel()
            r0 = 3
            if (r11 > r0) goto L_0x006a
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Finished loading "
            r11.append(r0)
            java.lang.Class r0 = r12.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r11.append(r0)
            java.lang.String r0 = " from "
            r11.append(r0)
            r11.append(r13)
            java.lang.String r0 = " for "
            r11.append(r0)
            java.lang.Object r0 = r10.f6372h
            r11.append(r0)
            java.lang.String r0 = " with size ["
            r11.append(r0)
            int r0 = r10.f6390z
            r11.append(r0)
            java.lang.String r0 = "x"
            r11.append(r0)
            int r0 = r10.f6362A
            r11.append(r0)
            java.lang.String r0 = "] in "
            r11.append(r0)
            long r0 = r10.f6384t
            double r0 = com.bumptech.glide.util.LogTime.getElapsedMillis(r0)
            r11.append(r0)
            java.lang.String r0 = " ms"
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            java.lang.String r0 = "Glide"
            android.util.Log.d(r0, r11)
        L_0x006a:
            r11 = 1
            r10.f6363B = r11
            r7 = 0
            java.util.List<com.bumptech.glide.request.RequestListener<R>> r0 = r10.f6379o     // Catch:{ all -> 0x00b8 }
            if (r0 == 0) goto L_0x0090
            java.util.Iterator r8 = r0.iterator()     // Catch:{ all -> 0x00b8 }
            r9 = 0
        L_0x0077:
            boolean r0 = r8.hasNext()     // Catch:{ all -> 0x00b8 }
            if (r0 == 0) goto L_0x0091
            java.lang.Object r0 = r8.next()     // Catch:{ all -> 0x00b8 }
            com.bumptech.glide.request.RequestListener r0 = (com.bumptech.glide.request.RequestListener) r0     // Catch:{ all -> 0x00b8 }
            java.lang.Object r2 = r10.f6372h     // Catch:{ all -> 0x00b8 }
            com.bumptech.glide.request.target.Target<R> r3 = r10.f6378n     // Catch:{ all -> 0x00b8 }
            r1 = r12
            r4 = r13
            r5 = r6
            boolean r0 = r0.onResourceReady(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00b8 }
            r9 = r9 | r0
            goto L_0x0077
        L_0x0090:
            r9 = 0
        L_0x0091:
            com.bumptech.glide.request.RequestListener<R> r0 = r10.f6368d     // Catch:{ all -> 0x00b8 }
            if (r0 == 0) goto L_0x00a3
            java.lang.Object r2 = r10.f6372h     // Catch:{ all -> 0x00b8 }
            com.bumptech.glide.request.target.Target<R> r3 = r10.f6378n     // Catch:{ all -> 0x00b8 }
            r1 = r12
            r4 = r13
            r5 = r6
            boolean r0 = r0.onResourceReady(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00b8 }
            if (r0 == 0) goto L_0x00a3
            goto L_0x00a4
        L_0x00a3:
            r11 = 0
        L_0x00a4:
            r11 = r11 | r9
            if (r11 != 0) goto L_0x00b2
            com.bumptech.glide.request.transition.TransitionFactory<? super R> r11 = r10.f6380p     // Catch:{ all -> 0x00b8 }
            com.bumptech.glide.request.transition.Transition r11 = r11.build(r13, r6)     // Catch:{ all -> 0x00b8 }
            com.bumptech.glide.request.target.Target<R> r13 = r10.f6378n     // Catch:{ all -> 0x00b8 }
            r13.onResourceReady(r12, r11)     // Catch:{ all -> 0x00b8 }
        L_0x00b2:
            r10.f6363B = r7
            r10.m4700n()
            return
        L_0x00b8:
            r11 = move-exception
            r10.f6363B = r7
            goto L_0x00bd
        L_0x00bc:
            throw r11
        L_0x00bd:
            goto L_0x00bc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.m4702p(com.bumptech.glide.load.engine.Resource, java.lang.Object, com.bumptech.glide.load.DataSource):void");
    }

    @GuardedBy("requestLock")
    /* renamed from: q */
    private void m4703q() {
        if (m4689c()) {
            Drawable drawable = null;
            if (this.f6372h == null) {
                drawable = m4693g();
            }
            if (drawable == null) {
                drawable = m4692f();
            }
            if (drawable == null) {
                drawable = m4694h();
            }
            this.f6378n.onLoadFailed(drawable);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void begin() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f6367c
            monitor-enter(r0)
            r5.m4687a()     // Catch:{ all -> 0x00a7 }
            com.bumptech.glide.util.pool.StateVerifier r1 = r5.f6366b     // Catch:{ all -> 0x00a7 }
            r1.throwIfRecycled()     // Catch:{ all -> 0x00a7 }
            long r1 = com.bumptech.glide.util.LogTime.getLogTime()     // Catch:{ all -> 0x00a7 }
            r5.f6384t = r1     // Catch:{ all -> 0x00a7 }
            java.lang.Object r1 = r5.f6372h     // Catch:{ all -> 0x00a7 }
            if (r1 != 0) goto L_0x003c
            int r1 = r5.f6375k     // Catch:{ all -> 0x00a7 }
            int r2 = r5.f6376l     // Catch:{ all -> 0x00a7 }
            boolean r1 = com.bumptech.glide.util.Util.isValidDimensions(r1, r2)     // Catch:{ all -> 0x00a7 }
            if (r1 == 0) goto L_0x0027
            int r1 = r5.f6375k     // Catch:{ all -> 0x00a7 }
            r5.f6390z = r1     // Catch:{ all -> 0x00a7 }
            int r1 = r5.f6376l     // Catch:{ all -> 0x00a7 }
            r5.f6362A = r1     // Catch:{ all -> 0x00a7 }
        L_0x0027:
            android.graphics.drawable.Drawable r1 = r5.m4693g()     // Catch:{ all -> 0x00a7 }
            if (r1 != 0) goto L_0x002f
            r1 = 5
            goto L_0x0030
        L_0x002f:
            r1 = 3
        L_0x0030:
            com.bumptech.glide.load.engine.GlideException r2 = new com.bumptech.glide.load.engine.GlideException     // Catch:{ all -> 0x00a7 }
            java.lang.String r3 = "Received null model"
            r2.<init>(r3)     // Catch:{ all -> 0x00a7 }
            r5.m4701o(r2, r1)     // Catch:{ all -> 0x00a7 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
            return
        L_0x003c:
            com.bumptech.glide.request.SingleRequest$a r1 = r5.f6386v     // Catch:{ all -> 0x00a7 }
            com.bumptech.glide.request.SingleRequest$a r2 = com.bumptech.glide.request.SingleRequest.C1341a.RUNNING     // Catch:{ all -> 0x00a7 }
            if (r1 == r2) goto L_0x009f
            com.bumptech.glide.request.SingleRequest$a r3 = com.bumptech.glide.request.SingleRequest.C1341a.COMPLETE     // Catch:{ all -> 0x00a7 }
            if (r1 != r3) goto L_0x004f
            com.bumptech.glide.load.engine.Resource<R> r1 = r5.f6382r     // Catch:{ all -> 0x00a7 }
            com.bumptech.glide.load.DataSource r2 = com.bumptech.glide.load.DataSource.MEMORY_CACHE     // Catch:{ all -> 0x00a7 }
            r5.onResourceReady(r1, r2)     // Catch:{ all -> 0x00a7 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
            return
        L_0x004f:
            com.bumptech.glide.request.SingleRequest$a r1 = com.bumptech.glide.request.SingleRequest.C1341a.WAITING_FOR_SIZE     // Catch:{ all -> 0x00a7 }
            r5.f6386v = r1     // Catch:{ all -> 0x00a7 }
            int r3 = r5.f6375k     // Catch:{ all -> 0x00a7 }
            int r4 = r5.f6376l     // Catch:{ all -> 0x00a7 }
            boolean r3 = com.bumptech.glide.util.Util.isValidDimensions(r3, r4)     // Catch:{ all -> 0x00a7 }
            if (r3 == 0) goto L_0x0065
            int r3 = r5.f6375k     // Catch:{ all -> 0x00a7 }
            int r4 = r5.f6376l     // Catch:{ all -> 0x00a7 }
            r5.onSizeReady(r3, r4)     // Catch:{ all -> 0x00a7 }
            goto L_0x006a
        L_0x0065:
            com.bumptech.glide.request.target.Target<R> r3 = r5.f6378n     // Catch:{ all -> 0x00a7 }
            r3.getSize(r5)     // Catch:{ all -> 0x00a7 }
        L_0x006a:
            com.bumptech.glide.request.SingleRequest$a r3 = r5.f6386v     // Catch:{ all -> 0x00a7 }
            if (r3 == r2) goto L_0x0070
            if (r3 != r1) goto L_0x007f
        L_0x0070:
            boolean r1 = r5.m4689c()     // Catch:{ all -> 0x00a7 }
            if (r1 == 0) goto L_0x007f
            com.bumptech.glide.request.target.Target<R> r1 = r5.f6378n     // Catch:{ all -> 0x00a7 }
            android.graphics.drawable.Drawable r2 = r5.m4694h()     // Catch:{ all -> 0x00a7 }
            r1.onLoadStarted(r2)     // Catch:{ all -> 0x00a7 }
        L_0x007f:
            boolean r1 = f6361D     // Catch:{ all -> 0x00a7 }
            if (r1 == 0) goto L_0x009d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a7 }
            r1.<init>()     // Catch:{ all -> 0x00a7 }
            java.lang.String r2 = "finished run method in "
            r1.append(r2)     // Catch:{ all -> 0x00a7 }
            long r2 = r5.f6384t     // Catch:{ all -> 0x00a7 }
            double r2 = com.bumptech.glide.util.LogTime.getElapsedMillis(r2)     // Catch:{ all -> 0x00a7 }
            r1.append(r2)     // Catch:{ all -> 0x00a7 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a7 }
            r5.m4697k(r1)     // Catch:{ all -> 0x00a7 }
        L_0x009d:
            monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
            return
        L_0x009f:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00a7 }
            java.lang.String r2 = "Cannot restart a running request"
            r1.<init>(r2)     // Catch:{ all -> 0x00a7 }
            throw r1     // Catch:{ all -> 0x00a7 }
        L_0x00a7:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.begin():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        if (r1 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
        r5.f6385u.release(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f6367c
            monitor-enter(r0)
            r5.m4687a()     // Catch:{ all -> 0x0039 }
            com.bumptech.glide.util.pool.StateVerifier r1 = r5.f6366b     // Catch:{ all -> 0x0039 }
            r1.throwIfRecycled()     // Catch:{ all -> 0x0039 }
            com.bumptech.glide.request.SingleRequest$a r1 = r5.f6386v     // Catch:{ all -> 0x0039 }
            com.bumptech.glide.request.SingleRequest$a r2 = com.bumptech.glide.request.SingleRequest.C1341a.CLEARED     // Catch:{ all -> 0x0039 }
            if (r1 != r2) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            return
        L_0x0013:
            r5.m4691e()     // Catch:{ all -> 0x0039 }
            com.bumptech.glide.load.engine.Resource<R> r1 = r5.f6382r     // Catch:{ all -> 0x0039 }
            r3 = 0
            if (r1 == 0) goto L_0x001e
            r5.f6382r = r3     // Catch:{ all -> 0x0039 }
            goto L_0x001f
        L_0x001e:
            r1 = r3
        L_0x001f:
            boolean r3 = r5.m4688b()     // Catch:{ all -> 0x0039 }
            if (r3 == 0) goto L_0x002e
            com.bumptech.glide.request.target.Target<R> r3 = r5.f6378n     // Catch:{ all -> 0x0039 }
            android.graphics.drawable.Drawable r4 = r5.m4694h()     // Catch:{ all -> 0x0039 }
            r3.onLoadCleared(r4)     // Catch:{ all -> 0x0039 }
        L_0x002e:
            r5.f6386v = r2     // Catch:{ all -> 0x0039 }
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0038
            com.bumptech.glide.load.engine.Engine r0 = r5.f6385u
            r0.release(r1)
        L_0x0038:
            return
        L_0x0039:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.clear():void");
    }

    public Object getLock() {
        this.f6366b.throwIfRecycled();
        return this.f6367c;
    }

    public boolean isCleared() {
        boolean z;
        synchronized (this.f6367c) {
            z = this.f6386v == C1341a.CLEARED;
        }
        return z;
    }

    public boolean isComplete() {
        boolean z;
        synchronized (this.f6367c) {
            z = this.f6386v == C1341a.COMPLETE;
        }
        return z;
    }

    public boolean isEquivalentTo(Request request) {
        int i;
        int i2;
        Object obj;
        Class<R> cls;
        BaseRequestOptions<?> baseRequestOptions;
        Priority priority;
        int size;
        int i3;
        int i4;
        Object obj2;
        Class<R> cls2;
        BaseRequestOptions<?> baseRequestOptions2;
        Priority priority2;
        int size2;
        Request request2 = request;
        if (!(request2 instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.f6367c) {
            i = this.f6375k;
            i2 = this.f6376l;
            obj = this.f6372h;
            cls = this.f6373i;
            baseRequestOptions = this.f6374j;
            priority = this.f6377m;
            List<RequestListener<R>> list = this.f6379o;
            size = list != null ? list.size() : 0;
        }
        SingleRequest singleRequest = (SingleRequest) request2;
        synchronized (singleRequest.f6367c) {
            i3 = singleRequest.f6375k;
            i4 = singleRequest.f6376l;
            obj2 = singleRequest.f6372h;
            cls2 = singleRequest.f6373i;
            baseRequestOptions2 = singleRequest.f6374j;
            priority2 = singleRequest.f6377m;
            List<RequestListener<R>> list2 = singleRequest.f6379o;
            size2 = list2 != null ? list2.size() : 0;
        }
        return i == i3 && i2 == i4 && Util.bothModelsNullEquivalentOrEquals(obj, obj2) && cls.equals(cls2) && baseRequestOptions.equals(baseRequestOptions2) && priority == priority2 && size == size2;
    }

    public boolean isRunning() {
        boolean z;
        synchronized (this.f6367c) {
            C1341a aVar = this.f6386v;
            if (aVar != C1341a.RUNNING) {
                if (aVar != C1341a.WAITING_FOR_SIZE) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public void onLoadFailed(GlideException glideException) {
        m4701o(glideException, 5);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.bumptech.glide.load.engine.Engine$LoadStatus, com.bumptech.glide.load.engine.Resource<R>] */
    /* JADX WARNING: type inference failed for: r0v2, types: [com.bumptech.glide.load.engine.Resource] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
        if (r6 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        r5.f6385u.release(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResourceReady(com.bumptech.glide.load.engine.Resource<?> r6, com.bumptech.glide.load.DataSource r7) {
        /*
            r5 = this;
            com.bumptech.glide.util.pool.StateVerifier r0 = r5.f6366b
            r0.throwIfRecycled()
            r0 = 0
            java.lang.Object r1 = r5.f6367c     // Catch:{ all -> 0x00b9 }
            monitor-enter(r1)     // Catch:{ all -> 0x00b9 }
            r5.f6383s = r0     // Catch:{ all -> 0x00b6 }
            if (r6 != 0) goto L_0x002f
            com.bumptech.glide.load.engine.GlideException r6 = new com.bumptech.glide.load.engine.GlideException     // Catch:{ all -> 0x00b6 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b6 }
            r7.<init>()     // Catch:{ all -> 0x00b6 }
            java.lang.String r2 = "Expected to receive a Resource<R> with an object of "
            r7.append(r2)     // Catch:{ all -> 0x00b6 }
            java.lang.Class<R> r2 = r5.f6373i     // Catch:{ all -> 0x00b6 }
            r7.append(r2)     // Catch:{ all -> 0x00b6 }
            java.lang.String r2 = " inside, but instead got null."
            r7.append(r2)     // Catch:{ all -> 0x00b6 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00b6 }
            r6.<init>(r7)     // Catch:{ all -> 0x00b6 }
            r5.onLoadFailed(r6)     // Catch:{ all -> 0x00b6 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b6 }
            return
        L_0x002f:
            java.lang.Object r2 = r6.get()     // Catch:{ all -> 0x00b6 }
            if (r2 == 0) goto L_0x005c
            java.lang.Class<R> r3 = r5.f6373i     // Catch:{ all -> 0x00b6 }
            java.lang.Class r4 = r2.getClass()     // Catch:{ all -> 0x00b6 }
            boolean r3 = r3.isAssignableFrom(r4)     // Catch:{ all -> 0x00b6 }
            if (r3 != 0) goto L_0x0042
            goto L_0x005c
        L_0x0042:
            boolean r3 = r5.m4690d()     // Catch:{ all -> 0x00b6 }
            if (r3 != 0) goto L_0x0057
            r5.f6382r = r0     // Catch:{ all -> 0x00b2 }
            com.bumptech.glide.request.SingleRequest$a r7 = com.bumptech.glide.request.SingleRequest.C1341a.COMPLETE     // Catch:{ all -> 0x00b2 }
            r5.f6386v = r7     // Catch:{ all -> 0x00b2 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b2 }
            if (r6 == 0) goto L_0x0056
            com.bumptech.glide.load.engine.Engine r7 = r5.f6385u
            r7.release(r6)
        L_0x0056:
            return
        L_0x0057:
            r5.m4702p(r6, r2, r7)     // Catch:{ all -> 0x00b6 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b6 }
            return
        L_0x005c:
            r5.f6382r = r0     // Catch:{ all -> 0x00b2 }
            com.bumptech.glide.load.engine.GlideException r7 = new com.bumptech.glide.load.engine.GlideException     // Catch:{ all -> 0x00b2 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b2 }
            r0.<init>()     // Catch:{ all -> 0x00b2 }
            java.lang.String r3 = "Expected to receive an object of "
            r0.append(r3)     // Catch:{ all -> 0x00b2 }
            java.lang.Class<R> r3 = r5.f6373i     // Catch:{ all -> 0x00b2 }
            r0.append(r3)     // Catch:{ all -> 0x00b2 }
            java.lang.String r3 = " but instead got "
            r0.append(r3)     // Catch:{ all -> 0x00b2 }
            if (r2 == 0) goto L_0x007b
            java.lang.Class r3 = r2.getClass()     // Catch:{ all -> 0x00b2 }
            goto L_0x007d
        L_0x007b:
            java.lang.String r3 = ""
        L_0x007d:
            r0.append(r3)     // Catch:{ all -> 0x00b2 }
            java.lang.String r3 = "{"
            r0.append(r3)     // Catch:{ all -> 0x00b2 }
            r0.append(r2)     // Catch:{ all -> 0x00b2 }
            java.lang.String r3 = "} inside Resource{"
            r0.append(r3)     // Catch:{ all -> 0x00b2 }
            r0.append(r6)     // Catch:{ all -> 0x00b2 }
            java.lang.String r3 = "}."
            r0.append(r3)     // Catch:{ all -> 0x00b2 }
            if (r2 == 0) goto L_0x009a
            java.lang.String r2 = ""
            goto L_0x009c
        L_0x009a:
            java.lang.String r2 = " To indicate failure return a null Resource object, rather than a Resource object containing null data."
        L_0x009c:
            r0.append(r2)     // Catch:{ all -> 0x00b2 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00b2 }
            r7.<init>(r0)     // Catch:{ all -> 0x00b2 }
            r5.onLoadFailed(r7)     // Catch:{ all -> 0x00b2 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b2 }
            if (r6 == 0) goto L_0x00b1
            com.bumptech.glide.load.engine.Engine r7 = r5.f6385u
            r7.release(r6)
        L_0x00b1:
            return
        L_0x00b2:
            r7 = move-exception
            r0 = r6
            r6 = r7
            goto L_0x00b7
        L_0x00b6:
            r6 = move-exception
        L_0x00b7:
            monitor-exit(r1)     // Catch:{ all -> 0x00b6 }
            throw r6     // Catch:{ all -> 0x00b9 }
        L_0x00b9:
            r6 = move-exception
            if (r0 == 0) goto L_0x00c1
            com.bumptech.glide.load.engine.Engine r7 = r5.f6385u
            r7.release(r0)
        L_0x00c1:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.onResourceReady(com.bumptech.glide.load.engine.Resource, com.bumptech.glide.load.DataSource):void");
    }

    public void onSizeReady(int i, int i2) {
        Object obj;
        this.f6366b.throwIfRecycled();
        Object obj2 = this.f6367c;
        synchronized (obj2) {
            try {
                boolean z = f6361D;
                if (z) {
                    m4697k("Got onSizeReady in " + LogTime.getElapsedMillis(this.f6384t));
                }
                if (this.f6386v == C1341a.WAITING_FOR_SIZE) {
                    C1341a aVar = C1341a.RUNNING;
                    this.f6386v = aVar;
                    float sizeMultiplier = this.f6374j.getSizeMultiplier();
                    this.f6390z = m4698l(i, sizeMultiplier);
                    this.f6362A = m4698l(i2, sizeMultiplier);
                    if (z) {
                        m4697k("finished setup for calling load in " + LogTime.getElapsedMillis(this.f6384t));
                    }
                    C1341a aVar2 = aVar;
                    boolean z2 = z;
                    C1341a aVar3 = aVar2;
                    obj = obj2;
                    try {
                        this.f6383s = this.f6385u.load(this.f6371g, this.f6372h, this.f6374j.getSignature(), this.f6390z, this.f6362A, this.f6374j.getResourceClass(), this.f6373i, this.f6377m, this.f6374j.getDiskCacheStrategy(), this.f6374j.getTransformations(), this.f6374j.isTransformationRequired(), this.f6374j.mo10038a(), this.f6374j.getOptions(), this.f6374j.isMemoryCacheable(), this.f6374j.getUseUnlimitedSourceGeneratorsPool(), this.f6374j.getUseAnimationPool(), this.f6374j.getOnlyRetrieveFromCache(), this, this.f6381q);
                        if (this.f6386v != aVar3) {
                            this.f6383s = null;
                        }
                        if (z2) {
                            m4697k("finished onSizeReady in " + LogTime.getElapsedMillis(this.f6384t));
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                obj = obj2;
                throw th;
            }
        }
    }

    public void pause() {
        synchronized (this.f6367c) {
            if (isRunning()) {
                clear();
            }
        }
    }
}
