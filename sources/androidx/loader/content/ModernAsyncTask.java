package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class ModernAsyncTask<Params, Progress, Result> {

    /* renamed from: f */
    private static final ThreadFactory f3606f;

    /* renamed from: g */
    private static final BlockingQueue<Runnable> f3607g;

    /* renamed from: h */
    public static final Executor f3608h;

    /* renamed from: i */
    private static C0787f f3609i;

    /* renamed from: a */
    private final C0788g<Params, Result> f3610a;

    /* renamed from: b */
    private final FutureTask<Result> f3611b;

    /* renamed from: c */
    private volatile Status f3612c = Status.PENDING;

    /* renamed from: d */
    final AtomicBoolean f3613d = new AtomicBoolean();

    /* renamed from: e */
    final AtomicBoolean f3614e = new AtomicBoolean();

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* renamed from: androidx.loader.content.ModernAsyncTask$a */
    static class C0782a implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f3616a = new AtomicInteger(1);

        C0782a() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f3616a.getAndIncrement());
        }
    }

    /* renamed from: androidx.loader.content.ModernAsyncTask$b */
    class C0783b extends C0788g<Params, Result> {
        C0783b() {
        }

        public Result call() {
            ModernAsyncTask.this.f3614e.set(true);
            Result result = null;
            try {
                Process.setThreadPriority(10);
                result = ModernAsyncTask.this.mo6339b(this.f3622a);
                Binder.flushPendingCommands();
                ModernAsyncTask.this.mo6394l(result);
                return result;
            } catch (Throwable th) {
                ModernAsyncTask.this.mo6394l(result);
                throw th;
            }
        }
    }

    /* renamed from: androidx.loader.content.ModernAsyncTask$c */
    class C0784c extends FutureTask<Result> {
        C0784c(Callable callable) {
            super(callable);
        }

        /* access modifiers changed from: protected */
        public void done() {
            try {
                ModernAsyncTask.this.mo6395m(get());
            } catch (InterruptedException e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
            } catch (CancellationException unused) {
                ModernAsyncTask.this.mo6395m(null);
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    }

    /* renamed from: androidx.loader.content.ModernAsyncTask$d */
    static /* synthetic */ class C0785d {

        /* renamed from: a */
        static final /* synthetic */ int[] f3619a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.loader.content.ModernAsyncTask$Status[] r0 = androidx.loader.content.ModernAsyncTask.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3619a = r0
                androidx.loader.content.ModernAsyncTask$Status r1 = androidx.loader.content.ModernAsyncTask.Status.RUNNING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3619a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.loader.content.ModernAsyncTask$Status r1 = androidx.loader.content.ModernAsyncTask.Status.FINISHED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.loader.content.ModernAsyncTask.C0785d.<clinit>():void");
        }
    }

    /* renamed from: androidx.loader.content.ModernAsyncTask$e */
    private static class C0786e<Data> {

        /* renamed from: a */
        final ModernAsyncTask f3620a;

        /* renamed from: b */
        final Data[] f3621b;

        C0786e(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.f3620a = modernAsyncTask;
            this.f3621b = dataArr;
        }
    }

    /* renamed from: androidx.loader.content.ModernAsyncTask$f */
    private static class C0787f extends Handler {
        C0787f() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            C0786e eVar = (C0786e) message.obj;
            int i = message.what;
            if (i == 1) {
                eVar.f3620a.mo6389d(eVar.f3621b[0]);
            } else if (i == 2) {
                eVar.f3620a.mo6393k(eVar.f3621b);
            }
        }
    }

    /* renamed from: androidx.loader.content.ModernAsyncTask$g */
    private static abstract class C0788g<Params, Result> implements Callable<Result> {

        /* renamed from: a */
        Params[] f3622a;

        C0788g() {
        }
    }

    static {
        C0782a aVar = new C0782a();
        f3606f = aVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        f3607g = linkedBlockingQueue;
        f3608h = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
    }

    ModernAsyncTask() {
        C0783b bVar = new C0783b();
        this.f3610a = bVar;
        this.f3611b = new C0784c(bVar);
    }

    /* renamed from: e */
    private static Handler m2645e() {
        C0787f fVar;
        synchronized (ModernAsyncTask.class) {
            if (f3609i == null) {
                f3609i = new C0787f();
            }
            fVar = f3609i;
        }
        return fVar;
    }

    /* renamed from: a */
    public final boolean mo6387a(boolean z) {
        this.f3613d.set(true);
        return this.f3611b.cancel(z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract Result mo6339b(Params... paramsArr);

    /* renamed from: c */
    public final ModernAsyncTask<Params, Progress, Result> mo6388c(Executor executor, Params... paramsArr) {
        if (this.f3612c != Status.PENDING) {
            int i = C0785d.f3619a[this.f3612c.ordinal()];
            if (i == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            } else if (i != 2) {
                throw new IllegalStateException("We should never reach this state");
            } else {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        } else {
            this.f3612c = Status.RUNNING;
            mo6392j();
            this.f3610a.f3622a = paramsArr;
            executor.execute(this.f3611b);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo6389d(Result result) {
        if (mo6390f()) {
            mo6340h(result);
        } else {
            mo6341i(result);
        }
        this.f3612c = Status.FINISHED;
    }

    /* renamed from: f */
    public final boolean mo6390f() {
        return this.f3613d.get();
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo6391g() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo6340h(Result result) {
        mo6391g();
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public void mo6341i(Result result) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void mo6392j() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public void mo6393k(Progress... progressArr) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public Result mo6394l(Result result) {
        m2645e().obtainMessage(1, new C0786e(this, result)).sendToTarget();
        return result;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo6395m(Result result) {
        if (!this.f3614e.get()) {
            mo6394l(result);
        }
    }
}
