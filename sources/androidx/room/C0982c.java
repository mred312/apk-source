package androidx.room;

import android.annotation.SuppressLint;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.LiveData;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: androidx.room.c */
/* compiled from: RoomTrackingLiveData */
class C0982c<T> extends LiveData<T> {

    /* renamed from: l */
    final RoomDatabase f4580l;

    /* renamed from: m */
    final boolean f4581m;

    /* renamed from: n */
    final Callable<T> f4582n;

    /* renamed from: o */
    private final C0973a f4583o;

    /* renamed from: p */
    final InvalidationTracker.Observer f4584p;

    /* renamed from: q */
    final AtomicBoolean f4585q = new AtomicBoolean(true);

    /* renamed from: r */
    final AtomicBoolean f4586r = new AtomicBoolean(false);

    /* renamed from: s */
    final AtomicBoolean f4587s = new AtomicBoolean(false);

    /* renamed from: t */
    final Runnable f4588t = new C0983a();

    /* renamed from: u */
    final Runnable f4589u = new C0984b();

    /* renamed from: androidx.room.c$a */
    /* compiled from: RoomTrackingLiveData */
    class C0983a implements Runnable {
        C0983a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:5:0x0025  */
        @androidx.annotation.WorkerThread
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
                androidx.room.c r0 = androidx.room.C0982c.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.f4587s
                r1 = 0
                r2 = 1
                boolean r0 = r0.compareAndSet(r1, r2)
                if (r0 == 0) goto L_0x001b
                androidx.room.c r0 = androidx.room.C0982c.this
                androidx.room.RoomDatabase r0 = r0.f4580l
                androidx.room.InvalidationTracker r0 = r0.getInvalidationTracker()
                androidx.room.c r3 = androidx.room.C0982c.this
                androidx.room.InvalidationTracker$Observer r3 = r3.f4584p
                r0.addWeakObserver(r3)
            L_0x001b:
                androidx.room.c r0 = androidx.room.C0982c.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.f4586r
                boolean r0 = r0.compareAndSet(r1, r2)
                if (r0 == 0) goto L_0x005c
                r0 = 0
                r3 = 0
            L_0x0027:
                androidx.room.c r4 = androidx.room.C0982c.this     // Catch:{ all -> 0x0053 }
                java.util.concurrent.atomic.AtomicBoolean r4 = r4.f4585q     // Catch:{ all -> 0x0053 }
                boolean r4 = r4.compareAndSet(r2, r1)     // Catch:{ all -> 0x0053 }
                if (r4 == 0) goto L_0x0044
                androidx.room.c r0 = androidx.room.C0982c.this     // Catch:{ Exception -> 0x003b }
                java.util.concurrent.Callable<T> r0 = r0.f4582n     // Catch:{ Exception -> 0x003b }
                java.lang.Object r0 = r0.call()     // Catch:{ Exception -> 0x003b }
                r3 = 1
                goto L_0x0027
            L_0x003b:
                r0 = move-exception
                java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x0053 }
                java.lang.String r3 = "Exception while computing database live data."
                r2.<init>(r3, r0)     // Catch:{ all -> 0x0053 }
                throw r2     // Catch:{ all -> 0x0053 }
            L_0x0044:
                if (r3 == 0) goto L_0x004b
                androidx.room.c r4 = androidx.room.C0982c.this     // Catch:{ all -> 0x0053 }
                r4.postValue(r0)     // Catch:{ all -> 0x0053 }
            L_0x004b:
                androidx.room.c r0 = androidx.room.C0982c.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.f4586r
                r0.set(r1)
                goto L_0x005d
            L_0x0053:
                r0 = move-exception
                androidx.room.c r2 = androidx.room.C0982c.this
                java.util.concurrent.atomic.AtomicBoolean r2 = r2.f4586r
                r2.set(r1)
                throw r0
            L_0x005c:
                r3 = 0
            L_0x005d:
                if (r3 == 0) goto L_0x0069
                androidx.room.c r0 = androidx.room.C0982c.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.f4585q
                boolean r0 = r0.get()
                if (r0 != 0) goto L_0x001b
            L_0x0069:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.C0982c.C0983a.run():void");
        }
    }

    /* renamed from: androidx.room.c$b */
    /* compiled from: RoomTrackingLiveData */
    class C0984b implements Runnable {
        C0984b() {
        }

        @MainThread
        public void run() {
            boolean hasActiveObservers = C0982c.this.hasActiveObservers();
            if (C0982c.this.f4585q.compareAndSet(false, true) && hasActiveObservers) {
                C0982c.this.mo7900g().execute(C0982c.this.f4588t);
            }
        }
    }

    /* renamed from: androidx.room.c$c */
    /* compiled from: RoomTrackingLiveData */
    class C0985c extends InvalidationTracker.Observer {
        C0985c(String[] strArr) {
            super(strArr);
        }

        public void onInvalidated(@NonNull Set<String> set) {
            ArchTaskExecutor.getInstance().executeOnMainThread(C0982c.this.f4589u);
        }
    }

    @SuppressLint({"RestrictedApi"})
    C0982c(RoomDatabase roomDatabase, C0973a aVar, boolean z, Callable<T> callable, String[] strArr) {
        this.f4580l = roomDatabase;
        this.f4581m = z;
        this.f4582n = callable;
        this.f4583o = aVar;
        this.f4584p = new C0985c(strArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public Executor mo7900g() {
        if (this.f4581m) {
            return this.f4580l.getTransactionExecutor();
        }
        return this.f4580l.getQueryExecutor();
    }

    /* access modifiers changed from: protected */
    public void onActive() {
        super.onActive();
        this.f4583o.mo7891b(this);
        mo7900g().execute(this.f4588t);
    }

    /* access modifiers changed from: protected */
    public void onInactive() {
        super.onInactive();
        this.f4583o.mo7892c(this);
    }
}
