package androidx.work.impl.background.systemalarm;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: androidx.work.impl.background.systemalarm.c */
/* compiled from: WorkTimer */
class C1096c {

    /* renamed from: f */
    private static final String f5215f = Logger.tagWithPrefix("WorkTimer");

    /* renamed from: a */
    private final ThreadFactory f5216a;

    /* renamed from: b */
    private final ScheduledExecutorService f5217b;

    /* renamed from: c */
    final Map<String, C1099c> f5218c = new HashMap();

    /* renamed from: d */
    final Map<String, C1098b> f5219d = new HashMap();

    /* renamed from: e */
    final Object f5220e = new Object();

    /* renamed from: androidx.work.impl.background.systemalarm.c$a */
    /* compiled from: WorkTimer */
    class C1097a implements ThreadFactory {

        /* renamed from: a */
        private int f5221a = 0;

        C1097a(C1096c cVar) {
        }

        public Thread newThread(@NonNull Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            newThread.setName("WorkManager-WorkTimer-thread-" + this.f5221a);
            this.f5221a = this.f5221a + 1;
            return newThread;
        }
    }

    /* renamed from: androidx.work.impl.background.systemalarm.c$b */
    /* compiled from: WorkTimer */
    interface C1098b {
        void onTimeLimitExceeded(@NonNull String str);
    }

    /* renamed from: androidx.work.impl.background.systemalarm.c$c */
    /* compiled from: WorkTimer */
    static class C1099c implements Runnable {

        /* renamed from: a */
        private final C1096c f5222a;

        /* renamed from: b */
        private final String f5223b;

        C1099c(@NonNull C1096c cVar, @NonNull String str) {
            this.f5222a = cVar;
            this.f5223b = str;
        }

        public void run() {
            synchronized (this.f5222a.f5220e) {
                if (this.f5222a.f5218c.remove(this.f5223b) != null) {
                    C1098b remove = this.f5222a.f5219d.remove(this.f5223b);
                    if (remove != null) {
                        remove.onTimeLimitExceeded(this.f5223b);
                    }
                } else {
                    Logger.get().debug("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", new Object[]{this.f5223b}), new Throwable[0]);
                }
            }
        }
    }

    C1096c() {
        C1097a aVar = new C1097a(this);
        this.f5216a = aVar;
        this.f5217b = Executors.newSingleThreadScheduledExecutor(aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8920a() {
        if (!this.f5217b.isShutdown()) {
            this.f5217b.shutdownNow();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8921b(@NonNull String str, long j, @NonNull C1098b bVar) {
        synchronized (this.f5220e) {
            Logger.get().debug(f5215f, String.format("Starting timer for %s", new Object[]{str}), new Throwable[0]);
            mo8922c(str);
            C1099c cVar = new C1099c(this, str);
            this.f5218c.put(str, cVar);
            this.f5219d.put(str, bVar);
            this.f5217b.schedule(cVar, j, TimeUnit.MILLISECONDS);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo8922c(@NonNull String str) {
        synchronized (this.f5220e) {
            if (this.f5218c.remove(str) != null) {
                Logger.get().debug(f5215f, String.format("Stopping timer for %s", new Object[]{str}), new Throwable[0]);
                this.f5219d.remove(str);
            }
        }
    }
}
