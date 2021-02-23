package androidx.work.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class AbstractFuture<V> implements ListenableFuture<V> {

    /* renamed from: d */
    static final boolean f5362d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: e */
    private static final Logger f5363e = Logger.getLogger(AbstractFuture.class.getName());

    /* renamed from: f */
    static final C1138b f5364f;

    /* renamed from: g */
    private static final Object f5365g = new Object();
    @Nullable

    /* renamed from: a */
    volatile Object f5366a;
    @Nullable

    /* renamed from: b */
    volatile C1142e f5367b;
    @Nullable

    /* renamed from: c */
    volatile C1146i f5368c;

    /* renamed from: androidx.work.impl.utils.futures.AbstractFuture$b */
    private static abstract class C1138b {
        private C1138b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract boolean mo9101a(AbstractFuture<?> abstractFuture, C1142e eVar, C1142e eVar2);

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract boolean mo9102b(AbstractFuture<?> abstractFuture, Object obj, Object obj2);

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public abstract boolean mo9103c(AbstractFuture<?> abstractFuture, C1146i iVar, C1146i iVar2);

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public abstract void mo9104d(C1146i iVar, C1146i iVar2);

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public abstract void mo9105e(C1146i iVar, Thread thread);
    }

    /* renamed from: androidx.work.impl.utils.futures.AbstractFuture$c */
    private static final class C1139c {

        /* renamed from: c */
        static final C1139c f5369c;

        /* renamed from: d */
        static final C1139c f5370d;

        /* renamed from: a */
        final boolean f5371a;
        @Nullable

        /* renamed from: b */
        final Throwable f5372b;

        static {
            if (AbstractFuture.f5362d) {
                f5370d = null;
                f5369c = null;
                return;
            }
            f5370d = new C1139c(false, (Throwable) null);
            f5369c = new C1139c(true, (Throwable) null);
        }

        C1139c(boolean z, @Nullable Throwable th) {
            this.f5371a = z;
            this.f5372b = th;
        }
    }

    /* renamed from: androidx.work.impl.utils.futures.AbstractFuture$d */
    private static final class C1140d {

        /* renamed from: b */
        static final C1140d f5373b = new C1140d(new C1141a("Failure occurred while trying to finish a future."));

        /* renamed from: a */
        final Throwable f5374a;

        /* renamed from: androidx.work.impl.utils.futures.AbstractFuture$d$a */
        static class C1141a extends Throwable {
            C1141a(String str) {
                super(str);
            }

            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        C1140d(Throwable th) {
            AbstractFuture.m4041c(th);
            this.f5374a = th;
        }
    }

    /* renamed from: androidx.work.impl.utils.futures.AbstractFuture$e */
    private static final class C1142e {

        /* renamed from: d */
        static final C1142e f5375d = new C1142e((Runnable) null, (Executor) null);

        /* renamed from: a */
        final Runnable f5376a;

        /* renamed from: b */
        final Executor f5377b;
        @Nullable

        /* renamed from: c */
        C1142e f5378c;

        C1142e(Runnable runnable, Executor executor) {
            this.f5376a = runnable;
            this.f5377b = executor;
        }
    }

    /* renamed from: androidx.work.impl.utils.futures.AbstractFuture$f */
    private static final class C1143f extends C1138b {

        /* renamed from: a */
        final AtomicReferenceFieldUpdater<C1146i, Thread> f5379a;

        /* renamed from: b */
        final AtomicReferenceFieldUpdater<C1146i, C1146i> f5380b;

        /* renamed from: c */
        final AtomicReferenceFieldUpdater<AbstractFuture, C1146i> f5381c;

        /* renamed from: d */
        final AtomicReferenceFieldUpdater<AbstractFuture, C1142e> f5382d;

        /* renamed from: e */
        final AtomicReferenceFieldUpdater<AbstractFuture, Object> f5383e;

        C1143f(AtomicReferenceFieldUpdater<C1146i, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<C1146i, C1146i> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, C1146i> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, C1142e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f5379a = atomicReferenceFieldUpdater;
            this.f5380b = atomicReferenceFieldUpdater2;
            this.f5381c = atomicReferenceFieldUpdater3;
            this.f5382d = atomicReferenceFieldUpdater4;
            this.f5383e = atomicReferenceFieldUpdater5;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo9101a(AbstractFuture<?> abstractFuture, C1142e eVar, C1142e eVar2) {
            return this.f5382d.compareAndSet(abstractFuture, eVar, eVar2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo9102b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return this.f5383e.compareAndSet(abstractFuture, obj, obj2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public boolean mo9103c(AbstractFuture<?> abstractFuture, C1146i iVar, C1146i iVar2) {
            return this.f5381c.compareAndSet(abstractFuture, iVar, iVar2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo9104d(C1146i iVar, C1146i iVar2) {
            this.f5380b.lazySet(iVar, iVar2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo9105e(C1146i iVar, Thread thread) {
            this.f5379a.lazySet(iVar, thread);
        }
    }

    /* renamed from: androidx.work.impl.utils.futures.AbstractFuture$g */
    private static final class C1144g<V> implements Runnable {

        /* renamed from: a */
        final AbstractFuture<V> f5384a;

        /* renamed from: b */
        final ListenableFuture<? extends V> f5385b;

        C1144g(AbstractFuture<V> abstractFuture, ListenableFuture<? extends V> listenableFuture) {
            this.f5384a = abstractFuture;
            this.f5385b = listenableFuture;
        }

        public void run() {
            if (this.f5384a.f5366a == this) {
                if (AbstractFuture.f5364f.mo9102b(this.f5384a, this, AbstractFuture.m4046h(this.f5385b))) {
                    AbstractFuture.m4043e(this.f5384a);
                }
            }
        }
    }

    /* renamed from: androidx.work.impl.utils.futures.AbstractFuture$h */
    private static final class C1145h extends C1138b {
        C1145h() {
            super();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo9101a(AbstractFuture<?> abstractFuture, C1142e eVar, C1142e eVar2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f5367b != eVar) {
                    return false;
                }
                abstractFuture.f5367b = eVar2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo9102b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f5366a != obj) {
                    return false;
                }
                abstractFuture.f5366a = obj2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public boolean mo9103c(AbstractFuture<?> abstractFuture, C1146i iVar, C1146i iVar2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f5368c != iVar) {
                    return false;
                }
                abstractFuture.f5368c = iVar2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo9104d(C1146i iVar, C1146i iVar2) {
            iVar.f5388b = iVar2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo9105e(C1146i iVar, Thread thread) {
            iVar.f5387a = thread;
        }
    }

    /* renamed from: androidx.work.impl.utils.futures.AbstractFuture$i */
    private static final class C1146i {

        /* renamed from: c */
        static final C1146i f5386c = new C1146i(false);
        @Nullable

        /* renamed from: a */
        volatile Thread f5387a;
        @Nullable

        /* renamed from: b */
        volatile C1146i f5388b;

        C1146i(boolean z) {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo9108a(C1146i iVar) {
            AbstractFuture.f5364f.mo9104d(this, iVar);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo9109b() {
            Thread thread = this.f5387a;
            if (thread != null) {
                this.f5387a = null;
                LockSupport.unpark(thread);
            }
        }

        C1146i() {
            AbstractFuture.f5364f.mo9105e(this, Thread.currentThread());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: androidx.work.impl.utils.futures.AbstractFuture$f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: androidx.work.impl.utils.futures.AbstractFuture$h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: androidx.work.impl.utils.futures.AbstractFuture$f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: androidx.work.impl.utils.futures.AbstractFuture$f} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.work.impl.utils.futures.AbstractFuture$i> r0 = androidx.work.impl.utils.futures.AbstractFuture.C1146i.class
            java.lang.String r1 = "guava.concurrent.generate_cancellation_cause"
            java.lang.String r2 = "false"
            java.lang.String r1 = java.lang.System.getProperty(r1, r2)
            boolean r1 = java.lang.Boolean.parseBoolean(r1)
            f5362d = r1
            java.lang.Class<androidx.work.impl.utils.futures.AbstractFuture> r1 = androidx.work.impl.utils.futures.AbstractFuture.class
            java.lang.String r1 = r1.getName()
            java.util.logging.Logger r1 = java.util.logging.Logger.getLogger(r1)
            f5363e = r1
            androidx.work.impl.utils.futures.AbstractFuture$f r1 = new androidx.work.impl.utils.futures.AbstractFuture$f     // Catch:{ all -> 0x004e }
            java.lang.Class<java.lang.Thread> r2 = java.lang.Thread.class
            java.lang.String r3 = "a"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r2, r3)     // Catch:{ all -> 0x004e }
            java.lang.String r2 = "b"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r0, r2)     // Catch:{ all -> 0x004e }
            java.lang.Class<androidx.work.impl.utils.futures.AbstractFuture> r2 = androidx.work.impl.utils.futures.AbstractFuture.class
            java.lang.String r5 = "c"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r2, r0, r5)     // Catch:{ all -> 0x004e }
            java.lang.Class<androidx.work.impl.utils.futures.AbstractFuture> r0 = androidx.work.impl.utils.futures.AbstractFuture.class
            java.lang.Class<androidx.work.impl.utils.futures.AbstractFuture$e> r2 = androidx.work.impl.utils.futures.AbstractFuture.C1142e.class
            java.lang.String r6 = "b"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r2, r6)     // Catch:{ all -> 0x004e }
            java.lang.Class<androidx.work.impl.utils.futures.AbstractFuture> r0 = androidx.work.impl.utils.futures.AbstractFuture.class
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            java.lang.String r7 = "a"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r2, r7)     // Catch:{ all -> 0x004e }
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x004e }
            r0 = 0
            goto L_0x0054
        L_0x004e:
            r0 = move-exception
            androidx.work.impl.utils.futures.AbstractFuture$h r1 = new androidx.work.impl.utils.futures.AbstractFuture$h
            r1.<init>()
        L_0x0054:
            f5364f = r1
            java.lang.Class<java.util.concurrent.locks.LockSupport> r1 = java.util.concurrent.locks.LockSupport.class
            if (r0 == 0) goto L_0x0063
            java.util.logging.Logger r1 = f5363e
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE
            java.lang.String r3 = "SafeAtomicHelper is broken!"
            r1.log(r2, r3, r0)
        L_0x0063:
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            f5365g = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.futures.AbstractFuture.<clinit>():void");
    }

    protected AbstractFuture() {
    }

    /* renamed from: a */
    private void m4039a(StringBuilder sb) {
        try {
            Object i = m4047i(this);
            sb.append("SUCCESS, result=[");
            sb.append(m4050l(i));
            sb.append("]");
        } catch (ExecutionException e) {
            sb.append("FAILURE, cause=[");
            sb.append(e.getCause());
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        }
    }

    /* renamed from: b */
    private static CancellationException m4040b(@Nullable String str, @Nullable Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    @NonNull
    /* renamed from: c */
    static <T> T m4041c(@Nullable T t) {
        t.getClass();
        return t;
    }

    /* renamed from: d */
    private C1142e m4042d(C1142e eVar) {
        C1142e eVar2;
        do {
            eVar2 = this.f5367b;
        } while (!f5364f.mo9101a(this, eVar2, C1142e.f5375d));
        C1142e eVar3 = eVar2;
        C1142e eVar4 = eVar;
        C1142e eVar5 = eVar3;
        while (eVar5 != null) {
            C1142e eVar6 = eVar5.f5378c;
            eVar5.f5378c = eVar4;
            eVar4 = eVar5;
            eVar5 = eVar6;
        }
        return eVar4;
    }

    /* renamed from: e */
    static void m4043e(AbstractFuture<?> abstractFuture) {
        C1142e eVar = null;
        AbstractFuture<V> abstractFuture2 = abstractFuture;
        while (true) {
            abstractFuture2.m4048j();
            abstractFuture2.afterDone();
            C1142e d = abstractFuture2.m4042d(eVar);
            while (true) {
                if (d != null) {
                    eVar = d.f5378c;
                    Runnable runnable = d.f5376a;
                    if (runnable instanceof C1144g) {
                        C1144g gVar = (C1144g) runnable;
                        AbstractFuture<V> abstractFuture3 = gVar.f5384a;
                        if (abstractFuture3.f5366a == gVar) {
                            if (f5364f.mo9102b(abstractFuture3, gVar, m4046h(gVar.f5385b))) {
                                abstractFuture2 = abstractFuture3;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        m4044f(runnable, d.f5377b);
                    }
                    d = eVar;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: f */
    private static void m4044f(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = f5363e;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e);
        }
    }

    /* renamed from: g */
    private V m4045g(Object obj) {
        if (obj instanceof C1139c) {
            throw m4040b("Task was cancelled.", ((C1139c) obj).f5372b);
        } else if (obj instanceof C1140d) {
            throw new ExecutionException(((C1140d) obj).f5374a);
        } else if (obj == f5365g) {
            return null;
        } else {
            return obj;
        }
    }

    /* renamed from: h */
    static Object m4046h(ListenableFuture<?> listenableFuture) {
        if (listenableFuture instanceof AbstractFuture) {
            Object obj = ((AbstractFuture) listenableFuture).f5366a;
            if (!(obj instanceof C1139c)) {
                return obj;
            }
            C1139c cVar = (C1139c) obj;
            if (cVar.f5371a) {
                return cVar.f5372b != null ? new C1139c(false, cVar.f5372b) : C1139c.f5370d;
            }
            return obj;
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!f5362d) && isCancelled) {
            return C1139c.f5370d;
        }
        try {
            Object i = m4047i(listenableFuture);
            return i == null ? f5365g : i;
        } catch (ExecutionException e) {
            return new C1140d(e.getCause());
        } catch (CancellationException e2) {
            if (isCancelled) {
                return new C1139c(false, e2);
            }
            return new C1140d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e2));
        } catch (Throwable th) {
            return new C1140d(th);
        }
    }

    /* renamed from: i */
    private static <V> V m4047i(Future<V> future) {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    /* renamed from: j */
    private void m4048j() {
        C1146i iVar;
        do {
            iVar = this.f5368c;
        } while (!f5364f.mo9103c(this, iVar, C1146i.f5386c));
        while (iVar != null) {
            iVar.mo9109b();
            iVar = iVar.f5388b;
        }
    }

    /* renamed from: k */
    private void m4049k(C1146i iVar) {
        iVar.f5387a = null;
        while (true) {
            C1146i iVar2 = this.f5368c;
            if (iVar2 != C1146i.f5386c) {
                C1146i iVar3 = null;
                while (iVar2 != null) {
                    C1146i iVar4 = iVar2.f5388b;
                    if (iVar2.f5387a != null) {
                        iVar3 = iVar2;
                    } else if (iVar3 != null) {
                        iVar3.f5388b = iVar4;
                        if (iVar3.f5387a == null) {
                        }
                    } else if (!f5364f.mo9103c(this, iVar2, iVar4)) {
                    }
                    iVar2 = iVar4;
                }
                return;
            }
            return;
        }
    }

    /* renamed from: l */
    private String m4050l(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    public final void addListener(Runnable runnable, Executor executor) {
        m4041c(runnable);
        m4041c(executor);
        C1142e eVar = this.f5367b;
        if (eVar != C1142e.f5375d) {
            C1142e eVar2 = new C1142e(runnable, executor);
            do {
                eVar2.f5378c = eVar;
                if (!f5364f.mo9101a(this, eVar, eVar2)) {
                    eVar = this.f5367b;
                } else {
                    return;
                }
            } while (eVar != C1142e.f5375d);
        }
        m4044f(runnable, executor);
    }

    /* access modifiers changed from: protected */
    public void afterDone() {
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, com.google.common.util.concurrent.ListenableFuture<? extends V>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f5366a
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0008
            r3 = 1
            goto L_0x0009
        L_0x0008:
            r3 = 0
        L_0x0009:
            boolean r4 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture.C1144g
            r3 = r3 | r4
            if (r3 == 0) goto L_0x0061
            boolean r3 = f5362d
            if (r3 == 0) goto L_0x001f
            androidx.work.impl.utils.futures.AbstractFuture$c r3 = new androidx.work.impl.utils.futures.AbstractFuture$c
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0026
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            androidx.work.impl.utils.futures.AbstractFuture$c r3 = androidx.work.impl.utils.futures.AbstractFuture.C1139c.f5369c
            goto L_0x0026
        L_0x0024:
            androidx.work.impl.utils.futures.AbstractFuture$c r3 = androidx.work.impl.utils.futures.AbstractFuture.C1139c.f5370d
        L_0x0026:
            r5 = 0
            r4 = r7
        L_0x0028:
            androidx.work.impl.utils.futures.AbstractFuture$b r6 = f5364f
            boolean r6 = r6.mo9102b(r4, r0, r3)
            if (r6 == 0) goto L_0x0059
            if (r8 == 0) goto L_0x0035
            r4.interruptTask()
        L_0x0035:
            m4043e(r4)
            boolean r4 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture.C1144g
            if (r4 == 0) goto L_0x0062
            androidx.work.impl.utils.futures.AbstractFuture$g r0 = (androidx.work.impl.utils.futures.AbstractFuture.C1144g) r0
            com.google.common.util.concurrent.ListenableFuture<? extends V> r0 = r0.f5385b
            boolean r4 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture
            if (r4 == 0) goto L_0x0055
            r4 = r0
            androidx.work.impl.utils.futures.AbstractFuture r4 = (androidx.work.impl.utils.futures.AbstractFuture) r4
            java.lang.Object r0 = r4.f5366a
            if (r0 != 0) goto L_0x004d
            r5 = 1
            goto L_0x004e
        L_0x004d:
            r5 = 0
        L_0x004e:
            boolean r6 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture.C1144g
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0062
            r5 = 1
            goto L_0x0028
        L_0x0055:
            r0.cancel(r8)
            goto L_0x0062
        L_0x0059:
            java.lang.Object r0 = r4.f5366a
            boolean r6 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture.C1144g
            if (r6 != 0) goto L_0x0028
            r1 = r5
            goto L_0x0062
        L_0x0061:
            r1 = 0
        L_0x0062:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.futures.AbstractFuture.cancel(boolean):boolean");
    }

    public final V get(long j, TimeUnit timeUnit) {
        long j2 = j;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j2);
        if (!Thread.interrupted()) {
            Object obj = this.f5366a;
            if ((obj != null) && (!(obj instanceof C1144g))) {
                return m4045g(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                C1146i iVar = this.f5368c;
                if (iVar != C1146i.f5386c) {
                    C1146i iVar2 = new C1146i();
                    do {
                        iVar2.mo9108a(iVar);
                        if (f5364f.mo9103c(this, iVar, iVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f5366a;
                                    if ((obj2 != null) && (!(obj2 instanceof C1144g))) {
                                        return m4045g(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    m4049k(iVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            m4049k(iVar2);
                        } else {
                            iVar = this.f5368c;
                        }
                    } while (iVar != C1146i.f5386c);
                }
                return m4045g(this.f5366a);
            }
            while (nanos > 0) {
                Object obj3 = this.f5366a;
                if ((obj3 != null) && (!(obj3 instanceof C1144g))) {
                    return m4045g(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractFuture = toString();
            String timeUnit3 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = timeUnit3.toLowerCase(locale);
            String str = "Waited " + j2 + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String str2 = str + " (plus ";
                long j3 = -nanos;
                long convert = timeUnit2.convert(j3, TimeUnit.NANOSECONDS);
                long nanos2 = j3 - timeUnit2.toNanos(convert);
                boolean z = convert == 0 || nanos2 > 1000;
                if (convert > 0) {
                    String str3 = str2 + convert + " " + lowerCase;
                    if (z) {
                        str3 = str3 + ",";
                    }
                    str2 = str3 + " ";
                }
                if (z) {
                    str2 = str2 + nanos2 + " nanoseconds ";
                }
                str = str2 + "delay)";
            }
            if (isDone()) {
                throw new TimeoutException(str + " but future completed as timeout expired");
            }
            throw new TimeoutException(str + " for " + abstractFuture);
        }
        throw new InterruptedException();
    }

    /* access modifiers changed from: protected */
    public void interruptTask() {
    }

    public final boolean isCancelled() {
        return this.f5366a instanceof C1139c;
    }

    public final boolean isDone() {
        Object obj = this.f5366a;
        return (!(obj instanceof C1144g)) & (obj != null);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public String pendingToString() {
        Object obj = this.f5366a;
        if (obj instanceof C1144g) {
            return "setFuture=[" + m4050l(((C1144g) obj).f5385b) + "]";
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
    }

    /* access modifiers changed from: protected */
    public boolean set(@Nullable V v) {
        if (v == null) {
            v = f5365g;
        }
        if (!f5364f.mo9102b(this, (Object) null, v)) {
            return false;
        }
        m4043e(this);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean setException(Throwable th) {
        m4041c(th);
        if (!f5364f.mo9102b(this, (Object) null, new C1140d(th))) {
            return false;
        }
        m4043e(this);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        C1144g gVar;
        C1140d dVar;
        m4041c(listenableFuture);
        Object obj = this.f5366a;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!f5364f.mo9102b(this, (Object) null, m4046h(listenableFuture))) {
                    return false;
                }
                m4043e(this);
                return true;
            }
            gVar = new C1144g(this, listenableFuture);
            if (f5364f.mo9102b(this, (Object) null, gVar)) {
                try {
                    listenableFuture.addListener(gVar, C1147a.INSTANCE);
                } catch (Throwable unused) {
                    dVar = C1140d.f5373b;
                }
                return true;
            }
            obj = this.f5366a;
        }
        if (obj instanceof C1139c) {
            listenableFuture.cancel(((C1139c) obj).f5371a);
        }
        return false;
        f5364f.mo9102b(this, gVar, dVar);
        return true;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            m4039a(sb);
        } else {
            try {
                str = pendingToString();
            } catch (RuntimeException e) {
                str = "Exception thrown from implementation: " + e.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                m4039a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final boolean wasInterrupted() {
        Object obj = this.f5366a;
        return (obj instanceof C1139c) && ((C1139c) obj).f5371a;
    }

    public final V get() {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f5366a;
            if ((obj2 != null) && (!(obj2 instanceof C1144g))) {
                return m4045g(obj2);
            }
            C1146i iVar = this.f5368c;
            if (iVar != C1146i.f5386c) {
                C1146i iVar2 = new C1146i();
                do {
                    iVar2.mo9108a(iVar);
                    if (f5364f.mo9103c(this, iVar, iVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f5366a;
                            } else {
                                m4049k(iVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof C1144g))));
                        return m4045g(obj);
                    }
                    iVar = this.f5368c;
                } while (iVar != C1146i.f5386c);
            }
            return m4045g(this.f5366a);
        }
        throw new InterruptedException();
    }
}
