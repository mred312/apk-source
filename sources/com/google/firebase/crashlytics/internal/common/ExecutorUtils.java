package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class ExecutorUtils {

    /* renamed from: com.google.firebase.crashlytics.internal.common.ExecutorUtils$a */
    class C3269a implements ThreadFactory {

        /* renamed from: a */
        final /* synthetic */ String f19044a;

        /* renamed from: b */
        final /* synthetic */ AtomicLong f19045b;

        /* renamed from: com.google.firebase.crashlytics.internal.common.ExecutorUtils$a$a */
        class C3270a extends BackgroundPriorityRunnable {

            /* renamed from: a */
            final /* synthetic */ Runnable f19046a;

            C3270a(C3269a aVar, Runnable runnable) {
                this.f19046a = runnable;
            }

            public void onRun() {
                this.f19046a.run();
            }
        }

        C3269a(String str, AtomicLong atomicLong) {
            this.f19044a = str;
            this.f19045b = atomicLong;
        }

        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(new C3270a(this, runnable));
            newThread.setName(this.f19044a + this.f19045b.getAndIncrement());
            return newThread;
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.ExecutorUtils$b */
    class C3271b extends BackgroundPriorityRunnable {

        /* renamed from: a */
        final /* synthetic */ String f19047a;

        /* renamed from: b */
        final /* synthetic */ ExecutorService f19048b;

        /* renamed from: c */
        final /* synthetic */ long f19049c;

        /* renamed from: d */
        final /* synthetic */ TimeUnit f19050d;

        C3271b(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
            this.f19047a = str;
            this.f19048b = executorService;
            this.f19049c = j;
            this.f19050d = timeUnit;
        }

        public void onRun() {
            try {
                Logger logger = Logger.getLogger();
                logger.mo20859d("Executing shutdown hook for " + this.f19047a);
                this.f19048b.shutdown();
                if (!this.f19048b.awaitTermination(this.f19049c, this.f19050d)) {
                    Logger logger2 = Logger.getLogger();
                    logger2.mo20859d(this.f19047a + " did not shut down in the allocated time. Requesting immediate shutdown.");
                    this.f19048b.shutdownNow();
                }
            } catch (InterruptedException unused) {
                Logger.getLogger().mo20859d(String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[]{this.f19047a}));
                this.f19048b.shutdownNow();
            }
        }
    }

    private ExecutorUtils() {
    }

    /* renamed from: a */
    private static final void m11273a(String str, ExecutorService executorService) {
        addDelayedShutdownHook(str, executorService, 2, TimeUnit.SECONDS);
    }

    public static final void addDelayedShutdownHook(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        Runtime runtime = Runtime.getRuntime();
        C3271b bVar = new C3271b(str, executorService, j, timeUnit);
        runtime.addShutdownHook(new Thread(bVar, "Crashlytics Shutdown Hook for " + str));
    }

    public static ExecutorService buildSingleThreadExecutorService(String str) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(getNamedThreadFactory(str));
        m11273a(str, newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    public static ScheduledExecutorService buildSingleThreadScheduledExecutorService(String str) {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(getNamedThreadFactory(str));
        m11273a(str, newSingleThreadScheduledExecutor);
        return newSingleThreadScheduledExecutor;
    }

    public static final ThreadFactory getNamedThreadFactory(String str) {
        return new C3269a(str, new AtomicLong(1));
    }
}
