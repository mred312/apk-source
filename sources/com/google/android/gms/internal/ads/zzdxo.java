package com.google.android.gms.internal.ads;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
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
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzdxo<V> extends zzdzr implements zzdyz<V> {
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final boolean f16050d;

    /* renamed from: e */
    private static final Logger f16051e = Logger.getLogger(zzdxo.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final C2684b f16052f;

    /* renamed from: g */
    private static final Object f16053g = new Object();
    /* access modifiers changed from: private */
    @NullableDecl

    /* renamed from: a */
    public volatile Object f16054a;
    /* access modifiers changed from: private */
    @NullableDecl

    /* renamed from: b */
    public volatile C2688e f16055b;
    /* access modifiers changed from: private */
    @NullableDecl

    /* renamed from: c */
    public volatile C2696l f16056c;

    /* renamed from: com.google.android.gms.internal.ads.zzdxo$b */
    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    static abstract class C2684b {
        private C2684b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo17385a(C2696l lVar, C2696l lVar2);

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract void mo17386b(C2696l lVar, Thread thread);

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public abstract boolean mo17387c(zzdxo<?> zzdxo, C2688e eVar, C2688e eVar2);

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public abstract boolean mo17388d(zzdxo<?> zzdxo, C2696l lVar, C2696l lVar2);

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public abstract boolean mo17389e(zzdxo<?> zzdxo, Object obj, Object obj2);
    }

    /* renamed from: com.google.android.gms.internal.ads.zzdxo$c */
    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    static final class C2685c {

        /* renamed from: b */
        static final C2685c f16057b = new C2685c(new C2686a("Failure occurred while trying to finish a future."));

        /* renamed from: a */
        final Throwable f16058a;

        /* renamed from: com.google.android.gms.internal.ads.zzdxo$c$a */
        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        class C2686a extends Throwable {
            C2686a(String str) {
                super(str);
            }

            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        C2685c(Throwable th) {
            this.f16058a = (Throwable) zzdvv.checkNotNull(th);
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.zzdxo$d */
    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    static final class C2687d {

        /* renamed from: c */
        static final C2687d f16059c;

        /* renamed from: d */
        static final C2687d f16060d;

        /* renamed from: a */
        final boolean f16061a;
        @NullableDecl

        /* renamed from: b */
        final Throwable f16062b;

        static {
            if (zzdxo.f16050d) {
                f16060d = null;
                f16059c = null;
                return;
            }
            f16060d = new C2687d(false, (Throwable) null);
            f16059c = new C2687d(true, (Throwable) null);
        }

        C2687d(boolean z, @NullableDecl Throwable th) {
            this.f16061a = z;
            this.f16062b = th;
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.zzdxo$e */
    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    static final class C2688e {

        /* renamed from: d */
        static final C2688e f16063d = new C2688e((Runnable) null, (Executor) null);

        /* renamed from: a */
        final Runnable f16064a;

        /* renamed from: b */
        final Executor f16065b;
        @NullableDecl

        /* renamed from: c */
        C2688e f16066c;

        C2688e(Runnable runnable, Executor executor) {
            this.f16064a = runnable;
            this.f16065b = executor;
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.zzdxo$f */
    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    static final class C2689f<V> implements Runnable {

        /* renamed from: a */
        final zzdxo<V> f16067a;

        /* renamed from: b */
        final zzdyz<? extends V> f16068b;

        C2689f(zzdxo<V> zzdxo, zzdyz<? extends V> zzdyz) {
            this.f16067a = zzdxo;
            this.f16068b = zzdyz;
        }

        public final void run() {
            if (this.f16067a.f16054a == this) {
                if (zzdxo.f16052f.mo17389e(this.f16067a, this, zzdxo.m8568a(this.f16068b))) {
                    zzdxo.m8574h(this.f16067a);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.zzdxo$g */
    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    static final class C2690g extends C2684b {

        /* renamed from: a */
        final AtomicReferenceFieldUpdater<C2696l, Thread> f16069a;

        /* renamed from: b */
        final AtomicReferenceFieldUpdater<C2696l, C2696l> f16070b;

        /* renamed from: c */
        final AtomicReferenceFieldUpdater<zzdxo, C2696l> f16071c;

        /* renamed from: d */
        final AtomicReferenceFieldUpdater<zzdxo, C2688e> f16072d;

        /* renamed from: e */
        final AtomicReferenceFieldUpdater<zzdxo, Object> f16073e;

        C2690g(AtomicReferenceFieldUpdater<C2696l, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<C2696l, C2696l> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<zzdxo, C2696l> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<zzdxo, C2688e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<zzdxo, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f16069a = atomicReferenceFieldUpdater;
            this.f16070b = atomicReferenceFieldUpdater2;
            this.f16071c = atomicReferenceFieldUpdater3;
            this.f16072d = atomicReferenceFieldUpdater4;
            this.f16073e = atomicReferenceFieldUpdater5;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final void mo17385a(C2696l lVar, C2696l lVar2) {
            this.f16070b.lazySet(lVar, lVar2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public final void mo17386b(C2696l lVar, Thread thread) {
            this.f16069a.lazySet(lVar, thread);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public final boolean mo17387c(zzdxo<?> zzdxo, C2688e eVar, C2688e eVar2) {
            return this.f16072d.compareAndSet(zzdxo, eVar, eVar2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public final boolean mo17388d(zzdxo<?> zzdxo, C2696l lVar, C2696l lVar2) {
            return this.f16071c.compareAndSet(zzdxo, lVar, lVar2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public final boolean mo17389e(zzdxo<?> zzdxo, Object obj, Object obj2) {
            return this.f16073e.compareAndSet(zzdxo, obj, obj2);
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.zzdxo$h */
    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    interface C2691h<V> extends zzdyz<V> {
    }

    /* renamed from: com.google.android.gms.internal.ads.zzdxo$i */
    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    static final class C2692i extends C2684b {
        private C2692i() {
            super();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final void mo17385a(C2696l lVar, C2696l lVar2) {
            lVar.f16082b = lVar2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public final void mo17386b(C2696l lVar, Thread thread) {
            lVar.f16081a = thread;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public final boolean mo17387c(zzdxo<?> zzdxo, C2688e eVar, C2688e eVar2) {
            synchronized (zzdxo) {
                if (zzdxo.f16055b != eVar) {
                    return false;
                }
                C2688e unused = zzdxo.f16055b = eVar2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public final boolean mo17388d(zzdxo<?> zzdxo, C2696l lVar, C2696l lVar2) {
            synchronized (zzdxo) {
                if (zzdxo.f16056c != lVar) {
                    return false;
                }
                C2696l unused = zzdxo.f16056c = lVar2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public final boolean mo17389e(zzdxo<?> zzdxo, Object obj, Object obj2) {
            synchronized (zzdxo) {
                if (zzdxo.f16054a != obj) {
                    return false;
                }
                Object unused = zzdxo.f16054a = obj2;
                return true;
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.zzdxo$j */
    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    static final class C2693j extends C2684b {

        /* renamed from: a */
        static final Unsafe f16074a;

        /* renamed from: b */
        static final long f16075b;

        /* renamed from: c */
        static final long f16076c;

        /* renamed from: d */
        static final long f16077d;

        /* renamed from: e */
        static final long f16078e;

        /* renamed from: f */
        static final long f16079f;

        /* renamed from: com.google.android.gms.internal.ads.zzdxo$j$a */
        /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
        class C2694a implements PrivilegedExceptionAction<Unsafe> {
            C2694a() {
            }

            public /* synthetic */ Object run() {
                Class<Unsafe> cls = Unsafe.class;
                for (Field field : cls.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get((Object) null);
                    if (cls.isInstance(obj)) {
                        return cls.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x005d, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0069, code lost:
            throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
            r1 = (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.android.gms.internal.ads.zzdxo.C2693j.C2694a());
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
        static {
            /*
                java.lang.Class<com.google.android.gms.internal.ads.zzdxo$l> r0 = com.google.android.gms.internal.ads.zzdxo.C2696l.class
                sun.misc.Unsafe r1 = sun.misc.Unsafe.getUnsafe()     // Catch:{ SecurityException -> 0x0007 }
                goto L_0x0012
            L_0x0007:
                com.google.android.gms.internal.ads.zzdxo$j$a r1 = new com.google.android.gms.internal.ads.zzdxo$j$a     // Catch:{ PrivilegedActionException -> 0x005d }
                r1.<init>()     // Catch:{ PrivilegedActionException -> 0x005d }
                java.lang.Object r1 = java.security.AccessController.doPrivileged(r1)     // Catch:{ PrivilegedActionException -> 0x005d }
                sun.misc.Unsafe r1 = (sun.misc.Unsafe) r1     // Catch:{ PrivilegedActionException -> 0x005d }
            L_0x0012:
                java.lang.Class<com.google.android.gms.internal.ads.zzdxo> r2 = com.google.android.gms.internal.ads.zzdxo.class
                java.lang.String r3 = "c"
                java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
                long r3 = r1.objectFieldOffset(r3)     // Catch:{ Exception -> 0x0053 }
                f16076c = r3     // Catch:{ Exception -> 0x0053 }
                java.lang.String r3 = "b"
                java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
                long r3 = r1.objectFieldOffset(r3)     // Catch:{ Exception -> 0x0053 }
                f16075b = r3     // Catch:{ Exception -> 0x0053 }
                java.lang.String r3 = "a"
                java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
                long r2 = r1.objectFieldOffset(r2)     // Catch:{ Exception -> 0x0053 }
                f16077d = r2     // Catch:{ Exception -> 0x0053 }
                java.lang.String r2 = "a"
                java.lang.reflect.Field r2 = r0.getDeclaredField(r2)     // Catch:{ Exception -> 0x0053 }
                long r2 = r1.objectFieldOffset(r2)     // Catch:{ Exception -> 0x0053 }
                f16078e = r2     // Catch:{ Exception -> 0x0053 }
                java.lang.String r2 = "b"
                java.lang.reflect.Field r0 = r0.getDeclaredField(r2)     // Catch:{ Exception -> 0x0053 }
                long r2 = r1.objectFieldOffset(r0)     // Catch:{ Exception -> 0x0053 }
                f16079f = r2     // Catch:{ Exception -> 0x0053 }
                f16074a = r1     // Catch:{ Exception -> 0x0053 }
                return
            L_0x0053:
                r0 = move-exception
                com.google.android.gms.internal.ads.zzdwe.zzi(r0)
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                r1.<init>(r0)
                throw r1
            L_0x005d:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                java.lang.Throwable r0 = r0.getCause()
                java.lang.String r2 = "Could not initialize intrinsics"
                r1.<init>(r2, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdxo.C2693j.<clinit>():void");
        }

        private C2693j() {
            super();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final void mo17385a(C2696l lVar, C2696l lVar2) {
            f16074a.putObject(lVar, f16079f, lVar2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public final void mo17386b(C2696l lVar, Thread thread) {
            f16074a.putObject(lVar, f16078e, thread);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public final boolean mo17387c(zzdxo<?> zzdxo, C2688e eVar, C2688e eVar2) {
            return f16074a.compareAndSwapObject(zzdxo, f16075b, eVar, eVar2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public final boolean mo17388d(zzdxo<?> zzdxo, C2696l lVar, C2696l lVar2) {
            return f16074a.compareAndSwapObject(zzdxo, f16076c, lVar, lVar2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public final boolean mo17389e(zzdxo<?> zzdxo, Object obj, Object obj2) {
            return f16074a.compareAndSwapObject(zzdxo, f16077d, obj, obj2);
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.zzdxo$k */
    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    static abstract class C2695k<V> extends zzdxo<V> implements C2691h<V> {
        C2695k() {
        }

        public final V get(long j, TimeUnit timeUnit) {
            return zzdxo.super.get(j, timeUnit);
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.zzdxo$l */
    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    static final class C2696l {

        /* renamed from: c */
        static final C2696l f16080c = new C2696l(false);
        @NullableDecl

        /* renamed from: a */
        volatile Thread f16081a;
        @NullableDecl

        /* renamed from: b */
        volatile C2696l f16082b;

        private C2696l(boolean z) {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final void mo17393a(C2696l lVar) {
            zzdxo.f16052f.mo17385a(this, lVar);
        }

        C2696l() {
            zzdxo.f16052f.mo17386b(this, Thread.currentThread());
        }
    }

    static {
        boolean z;
        Throwable th;
        Throwable th2;
        C2684b bVar;
        Class<C2696l> cls = C2696l.class;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        f16050d = z;
        try {
            bVar = new C2693j();
            th2 = null;
            th = null;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            bVar = new C2692i();
        }
        f16052f = bVar;
        if (th != null) {
            Logger logger = f16051e;
            Level level = Level.SEVERE;
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    protected zzdxo() {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static Object m8568a(zzdyz<?> zzdyz) {
        Throwable zza;
        if (zzdyz instanceof C2691h) {
            Object obj = ((zzdxo) zzdyz).f16054a;
            if (!(obj instanceof C2687d)) {
                return obj;
            }
            C2687d dVar = (C2687d) obj;
            if (!dVar.f16061a) {
                return obj;
            }
            if (dVar.f16062b != null) {
                return new C2687d(false, dVar.f16062b);
            }
            return C2687d.f16060d;
        } else if ((zzdyz instanceof zzdzr) && (zza = zzdzu.zza((zzdzr) zzdyz)) != null) {
            return new C2685c(zza);
        } else {
            boolean isCancelled = zzdyz.isCancelled();
            if ((!f16050d) && isCancelled) {
                return C2687d.f16060d;
            }
            try {
                Object b = m8569b(zzdyz);
                if (!isCancelled) {
                    return b == null ? f16053g : b;
                }
                String valueOf = String.valueOf(zzdyz);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 84);
                sb.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
                sb.append(valueOf);
                return new C2687d(false, new IllegalArgumentException(sb.toString()));
            } catch (ExecutionException e) {
                if (!isCancelled) {
                    return new C2685c(e.getCause());
                }
                String valueOf2 = String.valueOf(zzdyz);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 84);
                sb2.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
                sb2.append(valueOf2);
                return new C2687d(false, new IllegalArgumentException(sb2.toString(), e));
            } catch (CancellationException e2) {
                if (isCancelled) {
                    return new C2687d(false, e2);
                }
                String valueOf3 = String.valueOf(zzdyz);
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 77);
                sb3.append("get() threw CancellationException, despite reporting isCancelled() == false: ");
                sb3.append(valueOf3);
                return new C2685c(new IllegalArgumentException(sb3.toString(), e2));
            } catch (Throwable th) {
                return new C2685c(th);
            }
        }
    }

    /* renamed from: b */
    private static <V> V m8569b(Future<V> future) {
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

    /* renamed from: g */
    private final void m8573g(C2696l lVar) {
        lVar.f16081a = null;
        while (true) {
            C2696l lVar2 = this.f16056c;
            if (lVar2 != C2696l.f16080c) {
                C2696l lVar3 = null;
                while (lVar2 != null) {
                    C2696l lVar4 = lVar2.f16082b;
                    if (lVar2.f16081a != null) {
                        lVar3 = lVar2;
                    } else if (lVar3 != null) {
                        lVar3.f16082b = lVar4;
                        if (lVar3.f16081a == null) {
                        }
                    } else if (f16052f.mo17388d(this, lVar2, lVar4)) {
                    }
                    lVar2 = lVar4;
                }
                return;
            }
            return;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public static void m8574h(zzdxo<?> zzdxo) {
        zzdxo<V> zzdxo2;
        C2688e eVar;
        C2688e eVar2;
        C2688e eVar3 = null;
        zzdxo<?> zzdxo3 = zzdxo;
        while (true) {
            C2696l lVar = zzdxo3.f16056c;
            if (f16052f.mo17388d(zzdxo3, lVar, C2696l.f16080c)) {
                while (lVar != null) {
                    Thread thread = lVar.f16081a;
                    if (thread != null) {
                        lVar.f16081a = null;
                        LockSupport.unpark(thread);
                    }
                    lVar = lVar.f16082b;
                }
                zzdxo3.afterDone();
                do {
                    eVar = zzdxo3.f16055b;
                } while (!f16052f.mo17387c(zzdxo3, eVar, C2688e.f16063d));
                while (true) {
                    eVar2 = eVar3;
                    eVar3 = eVar;
                    if (eVar3 == null) {
                        break;
                    }
                    eVar = eVar3.f16066c;
                    eVar3.f16066c = eVar2;
                }
                while (eVar2 != null) {
                    eVar3 = eVar2.f16066c;
                    Runnable runnable = eVar2.f16064a;
                    if (runnable instanceof C2689f) {
                        C2689f fVar = (C2689f) runnable;
                        zzdxo<V> zzdxo4 = fVar.f16067a;
                        if (zzdxo4.f16054a == fVar) {
                            if (f16052f.mo17389e(zzdxo4, fVar, m8568a(fVar.f16068b))) {
                                zzdxo2 = zzdxo4;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        m8575i(runnable, eVar2.f16065b);
                    }
                    eVar2 = eVar3;
                }
                return;
            }
            zzdxo2 = zzdxo3;
            zzdxo3 = zzdxo2;
        }
    }

    /* renamed from: i */
    private static void m8575i(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = f16051e;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57 + String.valueOf(valueOf2).length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(valueOf);
            sb.append(" with executor ");
            sb.append(valueOf2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "executeListener", sb.toString(), e);
        }
    }

    /* renamed from: j */
    private final void m8576j(StringBuilder sb) {
        try {
            Object b = m8569b(this);
            sb.append("SUCCESS, result=[");
            m8577k(sb, b);
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

    /* renamed from: k */
    private final void m8577k(StringBuilder sb, Object obj) {
        if (obj == this) {
            try {
                sb.append("this future");
            } catch (RuntimeException | StackOverflowError e) {
                sb.append("Exception thrown from implementation: ");
                sb.append(e.getClass());
            }
        } else {
            sb.append(obj);
        }
    }

    /* renamed from: l */
    private static V m8578l(Object obj) {
        if (obj instanceof C2687d) {
            Throwable th = ((C2687d) obj).f16062b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof C2685c) {
            throw new ExecutionException(((C2685c) obj).f16058a);
        } else if (obj == f16053g) {
            return null;
        } else {
            return obj;
        }
    }

    public void addListener(Runnable runnable, Executor executor) {
        C2688e eVar;
        zzdvv.checkNotNull(runnable, "Runnable was null.");
        zzdvv.checkNotNull(executor, "Executor was null.");
        if (isDone() || (eVar = this.f16055b) == C2688e.f16063d) {
            m8575i(runnable, executor);
        }
        C2688e eVar2 = new C2688e(runnable, executor);
        do {
            eVar2.f16066c = eVar;
            if (!f16052f.mo17387c(this, eVar, eVar2)) {
                eVar = this.f16055b;
            } else {
                return;
            }
        } while (eVar != C2688e.f16063d);
        m8575i(runnable, executor);
    }

    /* access modifiers changed from: protected */
    public void afterDone() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo17379c(@NullableDecl Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, com.google.android.gms.internal.ads.zzdyz<? extends V>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f16054a
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0008
            r3 = 1
            goto L_0x0009
        L_0x0008:
            r3 = 0
        L_0x0009:
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzdxo.C2689f
            r3 = r3 | r4
            if (r3 == 0) goto L_0x0061
            boolean r3 = f16050d
            if (r3 == 0) goto L_0x001f
            com.google.android.gms.internal.ads.zzdxo$d r3 = new com.google.android.gms.internal.ads.zzdxo$d
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0026
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzdxo$d r3 = com.google.android.gms.internal.ads.zzdxo.C2687d.f16059c
            goto L_0x0026
        L_0x0024:
            com.google.android.gms.internal.ads.zzdxo$d r3 = com.google.android.gms.internal.ads.zzdxo.C2687d.f16060d
        L_0x0026:
            r5 = 0
            r4 = r7
        L_0x0028:
            com.google.android.gms.internal.ads.zzdxo$b r6 = f16052f
            boolean r6 = r6.mo17389e(r4, r0, r3)
            if (r6 == 0) goto L_0x0059
            if (r8 == 0) goto L_0x0035
            r4.interruptTask()
        L_0x0035:
            m8574h(r4)
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzdxo.C2689f
            if (r4 == 0) goto L_0x0062
            com.google.android.gms.internal.ads.zzdxo$f r0 = (com.google.android.gms.internal.ads.zzdxo.C2689f) r0
            com.google.android.gms.internal.ads.zzdyz<? extends V> r0 = r0.f16068b
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzdxo.C2691h
            if (r4 == 0) goto L_0x0055
            r4 = r0
            com.google.android.gms.internal.ads.zzdxo r4 = (com.google.android.gms.internal.ads.zzdxo) r4
            java.lang.Object r0 = r4.f16054a
            if (r0 != 0) goto L_0x004d
            r5 = 1
            goto L_0x004e
        L_0x004d:
            r5 = 0
        L_0x004e:
            boolean r6 = r0 instanceof com.google.android.gms.internal.ads.zzdxo.C2689f
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0062
            r5 = 1
            goto L_0x0028
        L_0x0055:
            r0.cancel(r8)
            goto L_0x0062
        L_0x0059:
            java.lang.Object r0 = r4.f16054a
            boolean r6 = r0 instanceof com.google.android.gms.internal.ads.zzdxo.C2689f
            if (r6 != 0) goto L_0x0028
            r1 = r5
            goto L_0x0062
        L_0x0061:
            r1 = 0
        L_0x0062:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdxo.cancel(boolean):boolean");
    }

    public V get(long j, TimeUnit timeUnit) {
        long j2 = j;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j2);
        if (!Thread.interrupted()) {
            Object obj = this.f16054a;
            if ((obj != null) && (!(obj instanceof C2689f))) {
                return m8578l(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                C2696l lVar = this.f16056c;
                if (lVar != C2696l.f16080c) {
                    C2696l lVar2 = new C2696l();
                    do {
                        lVar2.mo17393a(lVar);
                        if (f16052f.mo17388d(this, lVar, lVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f16054a;
                                    if ((obj2 != null) && (!(obj2 instanceof C2689f))) {
                                        return m8578l(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    m8573g(lVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            m8573g(lVar2);
                        } else {
                            lVar = this.f16056c;
                        }
                    } while (lVar != C2696l.f16080c);
                }
                return m8578l(this.f16054a);
            }
            while (nanos > 0) {
                Object obj3 = this.f16054a;
                if ((obj3 != null) && (!(obj3 instanceof C2689f))) {
                    return m8578l(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String zzdxo = toString();
            String timeUnit3 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = timeUnit3.toLowerCase(locale);
            String lowerCase2 = timeUnit.toString().toLowerCase(locale);
            StringBuilder sb = new StringBuilder(String.valueOf(lowerCase2).length() + 28);
            sb.append("Waited ");
            sb.append(j2);
            sb.append(" ");
            sb.append(lowerCase2);
            String sb2 = sb.toString();
            if (nanos + 1000 < 0) {
                String concat = String.valueOf(sb2).concat(" (plus ");
                long j3 = -nanos;
                long convert = timeUnit2.convert(j3, TimeUnit.NANOSECONDS);
                long nanos2 = j3 - timeUnit2.toNanos(convert);
                boolean z = convert == 0 || nanos2 > 1000;
                if (convert > 0) {
                    String valueOf = String.valueOf(concat);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 21 + String.valueOf(lowerCase).length());
                    sb3.append(valueOf);
                    sb3.append(convert);
                    sb3.append(" ");
                    sb3.append(lowerCase);
                    String sb4 = sb3.toString();
                    if (z) {
                        sb4 = String.valueOf(sb4).concat(",");
                    }
                    concat = String.valueOf(sb4).concat(" ");
                }
                if (z) {
                    String valueOf2 = String.valueOf(concat);
                    StringBuilder sb5 = new StringBuilder(String.valueOf(valueOf2).length() + 33);
                    sb5.append(valueOf2);
                    sb5.append(nanos2);
                    sb5.append(" nanoseconds ");
                    concat = sb5.toString();
                }
                sb2 = String.valueOf(concat).concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(String.valueOf(sb2).concat(" but future completed as timeout expired"));
            }
            StringBuilder sb6 = new StringBuilder(String.valueOf(sb2).length() + 5 + String.valueOf(zzdxo).length());
            sb6.append(sb2);
            sb6.append(" for ");
            sb6.append(zzdxo);
            throw new TimeoutException(sb6.toString());
        }
        throw new InterruptedException();
    }

    /* access modifiers changed from: protected */
    public void interruptTask() {
    }

    public boolean isCancelled() {
        return this.f16054a instanceof C2687d;
    }

    public boolean isDone() {
        Object obj = this.f16054a;
        return (!(obj instanceof C2689f)) & (obj != null);
    }

    /* access modifiers changed from: protected */
    @NullableDecl
    public String pendingToString() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        StringBuilder sb = new StringBuilder(41);
        sb.append("remaining delay=[");
        sb.append(delay);
        sb.append(" ms]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public boolean set(@NullableDecl V v) {
        if (v == null) {
            v = f16053g;
        }
        if (!f16052f.mo17389e(this, (Object) null, v)) {
            return false;
        }
        m8574h(this);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean setException(Throwable th) {
        if (!f16052f.mo17389e(this, (Object) null, new C2685c((Throwable) zzdvv.checkNotNull(th)))) {
            return false;
        }
        m8574h(this);
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean setFuture(zzdyz<? extends V> zzdyz) {
        C2689f fVar;
        C2685c cVar;
        zzdvv.checkNotNull(zzdyz);
        Object obj = this.f16054a;
        if (obj == null) {
            if (zzdyz.isDone()) {
                if (!f16052f.mo17389e(this, (Object) null, m8568a(zzdyz))) {
                    return false;
                }
                m8574h(this);
                return true;
            }
            fVar = new C2689f(this, zzdyz);
            if (f16052f.mo17389e(this, (Object) null, fVar)) {
                try {
                    zzdyz.addListener(fVar, g30.INSTANCE);
                } catch (Throwable unused) {
                    cVar = C2685c.f16057b;
                }
                return true;
            }
            obj = this.f16054a;
        }
        if (obj instanceof C2687d) {
            zzdyz.cancel(((C2687d) obj).f16061a);
        }
        return false;
        f16052f.mo17389e(this, fVar, cVar);
        return true;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            m8576j(sb);
        } else {
            int length = sb.length();
            sb.append("PENDING");
            Object obj = this.f16054a;
            if (obj instanceof C2689f) {
                sb.append(", setFuture=[");
                m8577k(sb, ((C2689f) obj).f16068b);
                sb.append("]");
            } else {
                try {
                    str = zzdwc.emptyToNull(pendingToString());
                } catch (RuntimeException | StackOverflowError e) {
                    String valueOf = String.valueOf(e.getClass());
                    StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 38);
                    sb2.append("Exception thrown from implementation: ");
                    sb2.append(valueOf);
                    str = sb2.toString();
                }
                if (str != null) {
                    sb.append(", info=[");
                    sb.append(str);
                    sb.append("]");
                }
            }
            if (isDone()) {
                sb.delete(length, sb.length());
                m8576j(sb);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final boolean wasInterrupted() {
        Object obj = this.f16054a;
        return (obj instanceof C2687d) && ((C2687d) obj).f16061a;
    }

    /* access modifiers changed from: protected */
    @NullableDecl
    public final Throwable zzazc() {
        if (!(this instanceof C2691h)) {
            return null;
        }
        Object obj = this.f16054a;
        if (obj instanceof C2685c) {
            return ((C2685c) obj).f16058a;
        }
        return null;
    }

    public V get() {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f16054a;
            if ((obj2 != null) && (!(obj2 instanceof C2689f))) {
                return m8578l(obj2);
            }
            C2696l lVar = this.f16056c;
            if (lVar != C2696l.f16080c) {
                C2696l lVar2 = new C2696l();
                do {
                    lVar2.mo17393a(lVar);
                    if (f16052f.mo17388d(this, lVar, lVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f16054a;
                            } else {
                                m8573g(lVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof C2689f))));
                        return m8578l(obj);
                    }
                    lVar = this.f16056c;
                } while (lVar != C2696l.f16080c);
            }
            return m8578l(this.f16054a);
        }
        throw new InterruptedException();
    }
}
