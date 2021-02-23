package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxo;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
abstract class a30<OutputT> extends zzdxo.C2695k<OutputT> {

    /* renamed from: j */
    private static final C1716b f7780j;

    /* renamed from: k */
    private static final Logger f7781k = Logger.getLogger(a30.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: h */
    public volatile Set<Throwable> f7782h = null;

    /* renamed from: i */
    private volatile int f7783i;

    /* renamed from: com.google.android.gms.internal.ads.a30$a */
    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    static final class C1715a extends C1716b {

        /* renamed from: a */
        private final AtomicReferenceFieldUpdater<a30, Set<Throwable>> f7784a;

        /* renamed from: b */
        private final AtomicIntegerFieldUpdater<a30> f7785b;

        C1715a(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.f7784a = atomicReferenceFieldUpdater;
            this.f7785b = atomicIntegerFieldUpdater;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final void mo13530a(a30 a30, Set<Throwable> set, Set<Throwable> set2) {
            this.f7784a.compareAndSet(a30, (Object) null, set2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public final int mo13531b(a30 a30) {
            return this.f7785b.decrementAndGet(a30);
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.a30$b */
    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    static abstract class C1716b {
        private C1716b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo13530a(a30 a30, Set<Throwable> set, Set<Throwable> set2);

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract int mo13531b(a30 a30);
    }

    /* renamed from: com.google.android.gms.internal.ads.a30$c */
    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    static final class C1717c extends C1716b {
        private C1717c() {
            super();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final void mo13530a(a30 a30, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (a30) {
                if (a30.f7782h == null) {
                    Set unused = a30.f7782h = set2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public final int mo13531b(a30 a30) {
            int y;
            synchronized (a30) {
                y = a30.m5750y(a30);
            }
            return y;
        }
    }

    static {
        Throwable th;
        C1716b bVar;
        try {
            bVar = new C1715a(AtomicReferenceFieldUpdater.newUpdater(a30.class, Set.class, "h"), AtomicIntegerFieldUpdater.newUpdater(a30.class, "i"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            bVar = new C1717c();
        }
        f7780j = bVar;
        if (th != null) {
            f7781k.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    a30(int i) {
        this.f7783i = i;
    }

    /* renamed from: y */
    static /* synthetic */ int m5750y(a30 a30) {
        int i = a30.f7783i - 1;
        a30.f7783i = i;
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public final Set<Throwable> mo13526v() {
        Set<Throwable> set = this.f7782h;
        if (set != null) {
            return set;
        }
        Set newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        mo13529z(newSetFromMap);
        f7780j.mo13530a(this, (Set<Throwable>) null, newSetFromMap);
        return this.f7782h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public final int mo13527w() {
        return f7780j.mo13531b(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public final void mo13528x() {
        this.f7782h = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: z */
    public abstract void mo13529z(Set<Throwable> set);
}
