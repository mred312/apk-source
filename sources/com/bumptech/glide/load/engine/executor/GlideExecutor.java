package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class GlideExecutor implements ExecutorService {

    /* renamed from: b */
    private static final long f5811b = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: c */
    private static volatile int f5812c;

    /* renamed from: a */
    private final ExecutorService f5813a;

    public interface UncaughtThrowableStrategy {
        public static final UncaughtThrowableStrategy DEFAULT;
        public static final UncaughtThrowableStrategy IGNORE = new C1230a();
        public static final UncaughtThrowableStrategy LOG;
        public static final UncaughtThrowableStrategy THROW = new C1232c();

        /* renamed from: com.bumptech.glide.load.engine.executor.GlideExecutor$UncaughtThrowableStrategy$a */
        class C1230a implements UncaughtThrowableStrategy {
            C1230a() {
            }

            public void handle(Throwable th) {
            }
        }

        /* renamed from: com.bumptech.glide.load.engine.executor.GlideExecutor$UncaughtThrowableStrategy$b */
        class C1231b implements UncaughtThrowableStrategy {
            C1231b() {
            }

            public void handle(Throwable th) {
                if (th != null && Log.isLoggable("GlideExecutor", 6)) {
                    Log.e("GlideExecutor", "Request threw uncaught throwable", th);
                }
            }
        }

        /* renamed from: com.bumptech.glide.load.engine.executor.GlideExecutor$UncaughtThrowableStrategy$c */
        class C1232c implements UncaughtThrowableStrategy {
            C1232c() {
            }

            public void handle(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        }

        static {
            C1231b bVar = new C1231b();
            LOG = bVar;
            DEFAULT = bVar;
        }

        void handle(Throwable th);
    }

    /* renamed from: com.bumptech.glide.load.engine.executor.GlideExecutor$a */
    private static final class C1233a implements ThreadFactory {

        /* renamed from: a */
        private final String f5814a;

        /* renamed from: b */
        final UncaughtThrowableStrategy f5815b;

        /* renamed from: c */
        final boolean f5816c;

        /* renamed from: d */
        private int f5817d;

        /* renamed from: com.bumptech.glide.load.engine.executor.GlideExecutor$a$a */
        class C1234a extends Thread {
            C1234a(Runnable runnable, String str) {
                super(runnable, str);
            }

            public void run() {
                Process.setThreadPriority(9);
                if (C1233a.this.f5816c) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th) {
                    C1233a.this.f5815b.handle(th);
                }
            }
        }

        C1233a(String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z) {
            this.f5814a = str;
            this.f5815b = uncaughtThrowableStrategy;
            this.f5816c = z;
        }

        public synchronized Thread newThread(@NonNull Runnable runnable) {
            C1234a aVar;
            aVar = new C1234a(runnable, "glide-" + this.f5814a + "-thread-" + this.f5817d);
            this.f5817d = this.f5817d + 1;
            return aVar;
        }
    }

    @VisibleForTesting
    GlideExecutor(ExecutorService executorService) {
        this.f5813a = executorService;
    }

    public static int calculateBestThreadCount() {
        if (f5812c == 0) {
            f5812c = Math.min(4, C1235a.m4328a());
        }
        return f5812c;
    }

    public static GlideExecutor newAnimationExecutor() {
        return newAnimationExecutor(calculateBestThreadCount() >= 4 ? 2 : 1, UncaughtThrowableStrategy.DEFAULT);
    }

    public static GlideExecutor newDiskCacheExecutor() {
        return newDiskCacheExecutor(1, "disk-cache", UncaughtThrowableStrategy.DEFAULT);
    }

    public static GlideExecutor newSourceExecutor() {
        return newSourceExecutor(calculateBestThreadCount(), FirebaseAnalytics.Param.SOURCE, UncaughtThrowableStrategy.DEFAULT);
    }

    public static GlideExecutor newUnlimitedSourceExecutor() {
        return new GlideExecutor(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f5811b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new C1233a("source-unlimited", UncaughtThrowableStrategy.DEFAULT, false)));
    }

    public boolean awaitTermination(long j, @NonNull TimeUnit timeUnit) {
        return this.f5813a.awaitTermination(j, timeUnit);
    }

    public void execute(@NonNull Runnable runnable) {
        this.f5813a.execute(runnable);
    }

    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) {
        return this.f5813a.invokeAll(collection);
    }

    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) {
        return this.f5813a.invokeAny(collection);
    }

    public boolean isShutdown() {
        return this.f5813a.isShutdown();
    }

    public boolean isTerminated() {
        return this.f5813a.isTerminated();
    }

    public void shutdown() {
        this.f5813a.shutdown();
    }

    @NonNull
    public List<Runnable> shutdownNow() {
        return this.f5813a.shutdownNow();
    }

    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.f5813a.submit(runnable);
    }

    public String toString() {
        return this.f5813a.toString();
    }

    public static GlideExecutor newDiskCacheExecutor(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newDiskCacheExecutor(1, "disk-cache", uncaughtThrowableStrategy);
    }

    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) {
        return this.f5813a.invokeAll(collection, j, timeUnit);
    }

    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) {
        return this.f5813a.invokeAny(collection, j, timeUnit);
    }

    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t) {
        return this.f5813a.submit(runnable, t);
    }

    public static GlideExecutor newAnimationExecutor(int i, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return new GlideExecutor(new ThreadPoolExecutor(i, i, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C1233a("animation", uncaughtThrowableStrategy, true)));
    }

    public static GlideExecutor newDiskCacheExecutor(int i, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return new GlideExecutor(new ThreadPoolExecutor(i, i, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C1233a(str, uncaughtThrowableStrategy, true)));
    }

    public static GlideExecutor newSourceExecutor(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newSourceExecutor(calculateBestThreadCount(), FirebaseAnalytics.Param.SOURCE, uncaughtThrowableStrategy);
    }

    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.f5813a.submit(callable);
    }

    public static GlideExecutor newSourceExecutor(int i, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return new GlideExecutor(new ThreadPoolExecutor(i, i, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C1233a(str, uncaughtThrowableStrategy, false)));
    }
}
