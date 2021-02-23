package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* renamed from: com.google.firebase.crashlytics.internal.common.f */
/* compiled from: CrashlyticsBackgroundWorker */
class C3281f {

    /* renamed from: a */
    private final ExecutorService f19081a;

    /* renamed from: b */
    private Task<Void> f19082b = Tasks.forResult(null);

    /* renamed from: c */
    private final Object f19083c = new Object();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ThreadLocal<Boolean> f19084d = new ThreadLocal<>();

    /* renamed from: com.google.firebase.crashlytics.internal.common.f$a */
    /* compiled from: CrashlyticsBackgroundWorker */
    class C3282a implements Runnable {
        C3282a() {
        }

        public void run() {
            C3281f.this.f19084d.set(Boolean.TRUE);
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.f$b */
    /* compiled from: CrashlyticsBackgroundWorker */
    class C3283b implements Callable<Void> {

        /* renamed from: a */
        final /* synthetic */ Runnable f19086a;

        C3283b(C3281f fVar, Runnable runnable) {
            this.f19086a = runnable;
        }

        /* renamed from: a */
        public Void call() {
            this.f19086a.run();
            return null;
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.f$c */
    /* compiled from: CrashlyticsBackgroundWorker */
    class C3284c implements Continuation<Void, T> {

        /* renamed from: a */
        final /* synthetic */ Callable f19087a;

        C3284c(C3281f fVar, Callable callable) {
            this.f19087a = callable;
        }

        public T then(@NonNull Task<Void> task) {
            return this.f19087a.call();
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.f$d */
    /* compiled from: CrashlyticsBackgroundWorker */
    class C3285d implements Continuation<T, Void> {
        C3285d(C3281f fVar) {
        }

        /* renamed from: a */
        public Void then(@NonNull Task<T> task) {
            return null;
        }
    }

    public C3281f(ExecutorService executorService) {
        this.f19081a = executorService;
        executorService.submit(new C3282a());
    }

    /* renamed from: d */
    private <T> Task<Void> m11304d(Task<T> task) {
        return task.continueWith(this.f19081a, new C3285d(this));
    }

    /* renamed from: e */
    private boolean m11305e() {
        return Boolean.TRUE.equals(this.f19084d.get());
    }

    /* renamed from: f */
    private <T> Continuation<Void, T> m11306f(Callable<T> callable) {
        return new C3284c(this, callable);
    }

    /* renamed from: b */
    public void mo20954b() {
        if (!m11305e()) {
            throw new IllegalStateException("Not running on background worker thread as intended.");
        }
    }

    /* renamed from: c */
    public Executor mo20955c() {
        return this.f19081a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public Task<Void> mo20956g(Runnable runnable) {
        return mo20957h(new C3283b(this, runnable));
    }

    /* renamed from: h */
    public <T> Task<T> mo20957h(Callable<T> callable) {
        Task<TContinuationResult> continueWith;
        synchronized (this.f19083c) {
            continueWith = this.f19082b.continueWith(this.f19081a, m11306f(callable));
            this.f19082b = m11304d(continueWith);
        }
        return continueWith;
    }

    /* renamed from: i */
    public <T> Task<T> mo20958i(Callable<Task<T>> callable) {
        Task<TContinuationResult> continueWithTask;
        synchronized (this.f19083c) {
            continueWithTask = this.f19082b.continueWithTask(this.f19081a, m11306f(callable));
            this.f19082b = m11304d(continueWithTask);
        }
        return continueWithTask;
    }
}
