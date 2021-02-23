package com.bumptech.glide.load.engine;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.C1238g;
import com.bumptech.glide.load.engine.C1256l;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.bumptech.glide.load.engine.h */
/* compiled from: EngineJob */
class C1247h<R> implements C1238g.C1240b<R>, FactoryPools.Poolable {

    /* renamed from: y */
    private static final C1250c f5891y = new C1250c();

    /* renamed from: a */
    final C1252e f5892a;

    /* renamed from: b */
    private final StateVerifier f5893b;

    /* renamed from: c */
    private final C1256l.C1257a f5894c;

    /* renamed from: d */
    private final Pools.Pool<C1247h<?>> f5895d;

    /* renamed from: e */
    private final C1250c f5896e;

    /* renamed from: f */
    private final C1253i f5897f;

    /* renamed from: g */
    private final GlideExecutor f5898g;

    /* renamed from: h */
    private final GlideExecutor f5899h;

    /* renamed from: i */
    private final GlideExecutor f5900i;

    /* renamed from: j */
    private final GlideExecutor f5901j;

    /* renamed from: k */
    private final AtomicInteger f5902k;

    /* renamed from: l */
    private Key f5903l;

    /* renamed from: m */
    private boolean f5904m;

    /* renamed from: n */
    private boolean f5905n;

    /* renamed from: o */
    private boolean f5906o;

    /* renamed from: p */
    private boolean f5907p;

    /* renamed from: q */
    private Resource<?> f5908q;

    /* renamed from: r */
    DataSource f5909r;

    /* renamed from: s */
    private boolean f5910s;

    /* renamed from: t */
    GlideException f5911t;

    /* renamed from: u */
    private boolean f5912u;

    /* renamed from: v */
    C1256l<?> f5913v;

    /* renamed from: w */
    private C1238g<R> f5914w;

    /* renamed from: x */
    private volatile boolean f5915x;

    /* renamed from: com.bumptech.glide.load.engine.h$a */
    /* compiled from: EngineJob */
    private class C1248a implements Runnable {

        /* renamed from: a */
        private final ResourceCallback f5916a;

        C1248a(ResourceCallback resourceCallback) {
            this.f5916a = resourceCallback;
        }

        public void run() {
            synchronized (this.f5916a.getLock()) {
                synchronized (C1247h.this) {
                    if (C1247h.this.f5892a.mo9674b(this.f5916a)) {
                        C1247h.this.mo9657c(this.f5916a);
                    }
                    C1247h.this.mo9660f();
                }
            }
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.h$b */
    /* compiled from: EngineJob */
    private class C1249b implements Runnable {

        /* renamed from: a */
        private final ResourceCallback f5918a;

        C1249b(ResourceCallback resourceCallback) {
            this.f5918a = resourceCallback;
        }

        public void run() {
            synchronized (this.f5918a.getLock()) {
                synchronized (C1247h.this) {
                    if (C1247h.this.f5892a.mo9674b(this.f5918a)) {
                        C1247h.this.f5913v.mo9683a();
                        C1247h.this.mo9658d(this.f5918a);
                        C1247h.this.mo9666o(this.f5918a);
                    }
                    C1247h.this.mo9660f();
                }
            }
        }
    }

    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.h$c */
    /* compiled from: EngineJob */
    static class C1250c {
        C1250c() {
        }

        /* renamed from: a */
        public <R> C1256l<R> mo9670a(Resource<R> resource, boolean z, Key key, C1256l.C1257a aVar) {
            return new C1256l(resource, z, true, key, aVar);
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.h$d */
    /* compiled from: EngineJob */
    static final class C1251d {

        /* renamed from: a */
        final ResourceCallback f5920a;

        /* renamed from: b */
        final Executor f5921b;

        C1251d(ResourceCallback resourceCallback, Executor executor) {
            this.f5920a = resourceCallback;
            this.f5921b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C1251d) {
                return this.f5920a.equals(((C1251d) obj).f5920a);
            }
            return false;
        }

        public int hashCode() {
            return this.f5920a.hashCode();
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.h$e */
    /* compiled from: EngineJob */
    static final class C1252e implements Iterable<C1251d> {

        /* renamed from: a */
        private final List<C1251d> f5922a;

        C1252e() {
            this(new ArrayList(2));
        }

        /* renamed from: d */
        private static C1251d m4408d(ResourceCallback resourceCallback) {
            return new C1251d(resourceCallback, Executors.directExecutor());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo9673a(ResourceCallback resourceCallback, Executor executor) {
            this.f5922a.add(new C1251d(resourceCallback, executor));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo9674b(ResourceCallback resourceCallback) {
            return this.f5922a.contains(m4408d(resourceCallback));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public C1252e mo9675c() {
            return new C1252e(new ArrayList(this.f5922a));
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            this.f5922a.clear();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo9677e(ResourceCallback resourceCallback) {
            this.f5922a.remove(m4408d(resourceCallback));
        }

        /* access modifiers changed from: package-private */
        public boolean isEmpty() {
            return this.f5922a.isEmpty();
        }

        @NonNull
        public Iterator<C1251d> iterator() {
            return this.f5922a.iterator();
        }

        /* access modifiers changed from: package-private */
        public int size() {
            return this.f5922a.size();
        }

        C1252e(List<C1251d> list) {
            this.f5922a = list;
        }
    }

    C1247h(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, C1253i iVar, C1256l.C1257a aVar, Pools.Pool<C1247h<?>> pool) {
        this(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, iVar, aVar, pool, f5891y);
    }

    /* renamed from: g */
    private GlideExecutor m4391g() {
        if (this.f5905n) {
            return this.f5900i;
        }
        return this.f5906o ? this.f5901j : this.f5899h;
    }

    /* renamed from: j */
    private boolean m4392j() {
        return this.f5912u || this.f5910s || this.f5915x;
    }

    /* renamed from: n */
    private synchronized void m4393n() {
        if (this.f5903l != null) {
            this.f5892a.clear();
            this.f5903l = null;
            this.f5913v = null;
            this.f5908q = null;
            this.f5912u = false;
            this.f5915x = false;
            this.f5910s = false;
            this.f5914w.mo9643s(false);
            this.f5914w = null;
            this.f5911t = null;
            this.f5909r = null;
            this.f5895d.release(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: a */
    public void mo9645a(C1238g<?> gVar) {
        m4391g().execute(gVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo9656b(ResourceCallback resourceCallback, Executor executor) {
        this.f5893b.throwIfRecycled();
        this.f5892a.mo9673a(resourceCallback, executor);
        boolean z = true;
        if (this.f5910s) {
            mo9661h(1);
            executor.execute(new C1249b(resourceCallback));
        } else if (this.f5912u) {
            mo9661h(1);
            executor.execute(new C1248a(resourceCallback));
        } else {
            if (this.f5915x) {
                z = false;
            }
            Preconditions.checkArgument(z, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    /* access modifiers changed from: package-private */
    @GuardedBy("this")
    /* renamed from: c */
    public void mo9657c(ResourceCallback resourceCallback) {
        try {
            resourceCallback.onLoadFailed(this.f5911t);
        } catch (Throwable th) {
            throw new C1198b(th);
        }
    }

    /* access modifiers changed from: package-private */
    @GuardedBy("this")
    /* renamed from: d */
    public void mo9658d(ResourceCallback resourceCallback) {
        try {
            resourceCallback.onResourceReady(this.f5913v, this.f5909r);
        } catch (Throwable th) {
            throw new C1198b(th);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo9659e() {
        if (!m4392j()) {
            this.f5915x = true;
            this.f5914w.mo9637a();
            this.f5897f.onEngineJobCancelled(this, this.f5903l);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo9660f() {
        C1256l<?> lVar;
        synchronized (this) {
            this.f5893b.throwIfRecycled();
            Preconditions.checkArgument(m4392j(), "Not yet complete!");
            int decrementAndGet = this.f5902k.decrementAndGet();
            Preconditions.checkArgument(decrementAndGet >= 0, "Can't decrement below 0");
            if (decrementAndGet == 0) {
                lVar = this.f5913v;
                m4393n();
            } else {
                lVar = null;
            }
        }
        if (lVar != null) {
            lVar.mo9686d();
        }
    }

    @NonNull
    public StateVerifier getVerifier() {
        return this.f5893b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public synchronized void mo9661h(int i) {
        C1256l<?> lVar;
        Preconditions.checkArgument(m4392j(), "Not yet complete!");
        if (this.f5902k.getAndAdd(i) == 0 && (lVar = this.f5913v) != null) {
            lVar.mo9683a();
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: i */
    public synchronized C1247h<R> mo9662i(Key key, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f5903l = key;
        this.f5904m = z;
        this.f5905n = z2;
        this.f5906o = z3;
        this.f5907p = z4;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        r4.f5897f.onEngineJobComplete(r4, r1, (com.bumptech.glide.load.engine.C1256l<?>) null);
        r0 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        if (r0.hasNext() == false) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        r1 = r0.next();
        r1.f5921b.execute(new com.bumptech.glide.load.engine.C1247h.C1248a(r4, r1.f5920a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        mo9660f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        return;
     */
    /* renamed from: k */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo9663k() {
        /*
            r4 = this;
            monitor-enter(r4)
            com.bumptech.glide.util.pool.StateVerifier r0 = r4.f5893b     // Catch:{ all -> 0x0066 }
            r0.throwIfRecycled()     // Catch:{ all -> 0x0066 }
            boolean r0 = r4.f5915x     // Catch:{ all -> 0x0066 }
            if (r0 == 0) goto L_0x000f
            r4.m4393n()     // Catch:{ all -> 0x0066 }
            monitor-exit(r4)     // Catch:{ all -> 0x0066 }
            return
        L_0x000f:
            com.bumptech.glide.load.engine.h$e r0 = r4.f5892a     // Catch:{ all -> 0x0066 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0066 }
            if (r0 != 0) goto L_0x005e
            boolean r0 = r4.f5912u     // Catch:{ all -> 0x0066 }
            if (r0 != 0) goto L_0x0056
            r0 = 1
            r4.f5912u = r0     // Catch:{ all -> 0x0066 }
            com.bumptech.glide.load.Key r1 = r4.f5903l     // Catch:{ all -> 0x0066 }
            com.bumptech.glide.load.engine.h$e r2 = r4.f5892a     // Catch:{ all -> 0x0066 }
            com.bumptech.glide.load.engine.h$e r2 = r2.mo9675c()     // Catch:{ all -> 0x0066 }
            int r3 = r2.size()     // Catch:{ all -> 0x0066 }
            int r3 = r3 + r0
            r4.mo9661h(r3)     // Catch:{ all -> 0x0066 }
            monitor-exit(r4)     // Catch:{ all -> 0x0066 }
            com.bumptech.glide.load.engine.i r0 = r4.f5897f
            r3 = 0
            r0.onEngineJobComplete(r4, r1, r3)
            java.util.Iterator r0 = r2.iterator()
        L_0x0039:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0052
            java.lang.Object r1 = r0.next()
            com.bumptech.glide.load.engine.h$d r1 = (com.bumptech.glide.load.engine.C1247h.C1251d) r1
            java.util.concurrent.Executor r2 = r1.f5921b
            com.bumptech.glide.load.engine.h$a r3 = new com.bumptech.glide.load.engine.h$a
            com.bumptech.glide.request.ResourceCallback r1 = r1.f5920a
            r3.<init>(r1)
            r2.execute(r3)
            goto L_0x0039
        L_0x0052:
            r4.mo9660f()
            return
        L_0x0056:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0066 }
            java.lang.String r1 = "Already failed once"
            r0.<init>(r1)     // Catch:{ all -> 0x0066 }
            throw r0     // Catch:{ all -> 0x0066 }
        L_0x005e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0066 }
            java.lang.String r1 = "Received an exception without any callbacks to notify"
            r0.<init>(r1)     // Catch:{ all -> 0x0066 }
            throw r0     // Catch:{ all -> 0x0066 }
        L_0x0066:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0066 }
            goto L_0x006a
        L_0x0069:
            throw r0
        L_0x006a:
            goto L_0x0069
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.C1247h.mo9663k():void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        r5.f5897f.onEngineJobComplete(r5, r0, r2);
        r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
        if (r0.hasNext() == false) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
        r1 = r0.next();
        r1.f5921b.execute(new com.bumptech.glide.load.engine.C1247h.C1249b(r5, r1.f5920a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0068, code lost:
        mo9660f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006b, code lost:
        return;
     */
    /* renamed from: l */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo9664l() {
        /*
            r5 = this;
            monitor-enter(r5)
            com.bumptech.glide.util.pool.StateVerifier r0 = r5.f5893b     // Catch:{ all -> 0x007c }
            r0.throwIfRecycled()     // Catch:{ all -> 0x007c }
            boolean r0 = r5.f5915x     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x0014
            com.bumptech.glide.load.engine.Resource<?> r0 = r5.f5908q     // Catch:{ all -> 0x007c }
            r0.recycle()     // Catch:{ all -> 0x007c }
            r5.m4393n()     // Catch:{ all -> 0x007c }
            monitor-exit(r5)     // Catch:{ all -> 0x007c }
            return
        L_0x0014:
            com.bumptech.glide.load.engine.h$e r0 = r5.f5892a     // Catch:{ all -> 0x007c }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x007c }
            if (r0 != 0) goto L_0x0074
            boolean r0 = r5.f5910s     // Catch:{ all -> 0x007c }
            if (r0 != 0) goto L_0x006c
            com.bumptech.glide.load.engine.h$c r0 = r5.f5896e     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.Resource<?> r1 = r5.f5908q     // Catch:{ all -> 0x007c }
            boolean r2 = r5.f5904m     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.Key r3 = r5.f5903l     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.l$a r4 = r5.f5894c     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.l r0 = r0.mo9670a(r1, r2, r3, r4)     // Catch:{ all -> 0x007c }
            r5.f5913v = r0     // Catch:{ all -> 0x007c }
            r0 = 1
            r5.f5910s = r0     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.h$e r1 = r5.f5892a     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.h$e r1 = r1.mo9675c()     // Catch:{ all -> 0x007c }
            int r2 = r1.size()     // Catch:{ all -> 0x007c }
            int r2 = r2 + r0
            r5.mo9661h(r2)     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.Key r0 = r5.f5903l     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.l<?> r2 = r5.f5913v     // Catch:{ all -> 0x007c }
            monitor-exit(r5)     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.i r3 = r5.f5897f
            r3.onEngineJobComplete(r5, r0, r2)
            java.util.Iterator r0 = r1.iterator()
        L_0x004f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0068
            java.lang.Object r1 = r0.next()
            com.bumptech.glide.load.engine.h$d r1 = (com.bumptech.glide.load.engine.C1247h.C1251d) r1
            java.util.concurrent.Executor r2 = r1.f5921b
            com.bumptech.glide.load.engine.h$b r3 = new com.bumptech.glide.load.engine.h$b
            com.bumptech.glide.request.ResourceCallback r1 = r1.f5920a
            r3.<init>(r1)
            r2.execute(r3)
            goto L_0x004f
        L_0x0068:
            r5.mo9660f()
            return
        L_0x006c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x007c }
            java.lang.String r1 = "Already have resource"
            r0.<init>(r1)     // Catch:{ all -> 0x007c }
            throw r0     // Catch:{ all -> 0x007c }
        L_0x0074:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x007c }
            java.lang.String r1 = "Received a resource without any callbacks to notify"
            r0.<init>(r1)     // Catch:{ all -> 0x007c }
            throw r0     // Catch:{ all -> 0x007c }
        L_0x007c:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x007c }
            goto L_0x0080
        L_0x007f:
            throw r0
        L_0x0080:
            goto L_0x007f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.C1247h.mo9664l():void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public boolean mo9665m() {
        return this.f5907p;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public synchronized void mo9666o(ResourceCallback resourceCallback) {
        boolean z;
        this.f5893b.throwIfRecycled();
        this.f5892a.mo9677e(resourceCallback);
        if (this.f5892a.isEmpty()) {
            mo9659e();
            if (!this.f5910s) {
                if (!this.f5912u) {
                    z = false;
                    if (z && this.f5902k.get() == 0) {
                        m4393n();
                    }
                }
            }
            z = true;
            m4393n();
        }
    }

    public void onLoadFailed(GlideException glideException) {
        synchronized (this) {
            this.f5911t = glideException;
        }
        mo9663k();
    }

    public void onResourceReady(Resource<R> resource, DataSource dataSource) {
        synchronized (this) {
            this.f5908q = resource;
            this.f5909r = dataSource;
        }
        mo9664l();
    }

    /* renamed from: p */
    public synchronized void mo9667p(C1238g<R> gVar) {
        this.f5914w = gVar;
        (gVar.mo9644y() ? this.f5898g : m4391g()).execute(gVar);
    }

    @VisibleForTesting
    C1247h(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, C1253i iVar, C1256l.C1257a aVar, Pools.Pool<C1247h<?>> pool, C1250c cVar) {
        this.f5892a = new C1252e();
        this.f5893b = StateVerifier.newInstance();
        this.f5902k = new AtomicInteger();
        this.f5898g = glideExecutor;
        this.f5899h = glideExecutor2;
        this.f5900i = glideExecutor3;
        this.f5901j = glideExecutor4;
        this.f5897f = iVar;
        this.f5894c = aVar;
        this.f5895d = pool;
        this.f5896e = cVar;
    }
}
