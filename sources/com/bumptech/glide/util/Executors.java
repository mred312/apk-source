package com.bumptech.glide.util;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public final class Executors {

    /* renamed from: a */
    private static final Executor f6499a = new C1356a();

    /* renamed from: b */
    private static final Executor f6500b = new C1357b();

    /* renamed from: com.bumptech.glide.util.Executors$a */
    class C1356a implements Executor {

        /* renamed from: a */
        private final Handler f6501a = new Handler(Looper.getMainLooper());

        C1356a() {
        }

        public void execute(@NonNull Runnable runnable) {
            this.f6501a.post(runnable);
        }
    }

    /* renamed from: com.bumptech.glide.util.Executors$b */
    class C1357b implements Executor {
        C1357b() {
        }

        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    }

    private Executors() {
    }

    public static Executor directExecutor() {
        return f6500b;
    }

    public static Executor mainThreadExecutor() {
        return f6499a;
    }

    @VisibleForTesting
    public static void shutdownAndAwaitTermination(ExecutorService executorService) {
        executorService.shutdownNow();
        try {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (!executorService.awaitTermination(5, timeUnit)) {
                executorService.shutdownNow();
                if (!executorService.awaitTermination(5, timeUnit)) {
                    throw new RuntimeException("Failed to shutdown");
                }
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
