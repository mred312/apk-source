package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class ComputableLiveData<T> {

    /* renamed from: a */
    final Executor f3461a;

    /* renamed from: b */
    final LiveData<T> f3462b;

    /* renamed from: c */
    final AtomicBoolean f3463c;

    /* renamed from: d */
    final AtomicBoolean f3464d;
    @VisibleForTesting

    /* renamed from: e */
    final Runnable f3465e;
    @VisibleForTesting

    /* renamed from: f */
    final Runnable f3466f;

    /* renamed from: androidx.lifecycle.ComputableLiveData$a */
    class C0739a extends LiveData<T> {
        C0739a() {
        }

        /* access modifiers changed from: protected */
        public void onActive() {
            ComputableLiveData computableLiveData = ComputableLiveData.this;
            computableLiveData.f3461a.execute(computableLiveData.f3465e);
        }
    }

    /* renamed from: androidx.lifecycle.ComputableLiveData$b */
    class C0740b implements Runnable {
        C0740b() {
        }

        /* JADX INFO: finally extract failed */
        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
        @androidx.annotation.WorkerThread
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
            L_0x0000:
                androidx.lifecycle.ComputableLiveData r0 = androidx.lifecycle.ComputableLiveData.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.f3464d
                r1 = 0
                r2 = 1
                boolean r0 = r0.compareAndSet(r1, r2)
                if (r0 == 0) goto L_0x003b
                r0 = 0
                r3 = 0
            L_0x000e:
                androidx.lifecycle.ComputableLiveData r4 = androidx.lifecycle.ComputableLiveData.this     // Catch:{ all -> 0x0032 }
                java.util.concurrent.atomic.AtomicBoolean r4 = r4.f3463c     // Catch:{ all -> 0x0032 }
                boolean r4 = r4.compareAndSet(r2, r1)     // Catch:{ all -> 0x0032 }
                if (r4 == 0) goto L_0x0020
                androidx.lifecycle.ComputableLiveData r0 = androidx.lifecycle.ComputableLiveData.this     // Catch:{ all -> 0x0032 }
                java.lang.Object r0 = r0.compute()     // Catch:{ all -> 0x0032 }
                r3 = 1
                goto L_0x000e
            L_0x0020:
                if (r3 == 0) goto L_0x0029
                androidx.lifecycle.ComputableLiveData r2 = androidx.lifecycle.ComputableLiveData.this     // Catch:{ all -> 0x0032 }
                androidx.lifecycle.LiveData<T> r2 = r2.f3462b     // Catch:{ all -> 0x0032 }
                r2.postValue(r0)     // Catch:{ all -> 0x0032 }
            L_0x0029:
                androidx.lifecycle.ComputableLiveData r0 = androidx.lifecycle.ComputableLiveData.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.f3464d
                r0.set(r1)
                r1 = r3
                goto L_0x003b
            L_0x0032:
                r0 = move-exception
                androidx.lifecycle.ComputableLiveData r2 = androidx.lifecycle.ComputableLiveData.this
                java.util.concurrent.atomic.AtomicBoolean r2 = r2.f3464d
                r2.set(r1)
                throw r0
            L_0x003b:
                if (r1 == 0) goto L_0x0047
                androidx.lifecycle.ComputableLiveData r0 = androidx.lifecycle.ComputableLiveData.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.f3463c
                boolean r0 = r0.get()
                if (r0 != 0) goto L_0x0000
            L_0x0047:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.ComputableLiveData.C0740b.run():void");
        }
    }

    /* renamed from: androidx.lifecycle.ComputableLiveData$c */
    class C0741c implements Runnable {
        C0741c() {
        }

        @MainThread
        public void run() {
            boolean hasActiveObservers = ComputableLiveData.this.f3462b.hasActiveObservers();
            if (ComputableLiveData.this.f3463c.compareAndSet(false, true) && hasActiveObservers) {
                ComputableLiveData computableLiveData = ComputableLiveData.this;
                computableLiveData.f3461a.execute(computableLiveData.f3465e);
            }
        }
    }

    public ComputableLiveData() {
        this(ArchTaskExecutor.getIOThreadExecutor());
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public abstract T compute();

    @NonNull
    public LiveData<T> getLiveData() {
        return this.f3462b;
    }

    public void invalidate() {
        ArchTaskExecutor.getInstance().executeOnMainThread(this.f3466f);
    }

    public ComputableLiveData(@NonNull Executor executor) {
        this.f3463c = new AtomicBoolean(true);
        this.f3464d = new AtomicBoolean(false);
        this.f3465e = new C0740b();
        this.f3466f = new C0741c();
        this.f3461a = executor;
        this.f3462b = new C0739a();
    }
}
