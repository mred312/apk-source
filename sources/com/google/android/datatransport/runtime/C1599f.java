package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.logging.Logging;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.datatransport.runtime.f */
/* compiled from: SafeLoggingExecutor */
class C1599f implements Executor {

    /* renamed from: a */
    private final Executor f7243a;

    /* renamed from: com.google.android.datatransport.runtime.f$a */
    /* compiled from: SafeLoggingExecutor */
    static class C1600a implements Runnable {

        /* renamed from: a */
        private final Runnable f7244a;

        C1600a(Runnable runnable) {
            this.f7244a = runnable;
        }

        public void run() {
            try {
                this.f7244a.run();
            } catch (Exception e) {
                Logging.m5075e("Executor", "Background execution failure.", e);
            }
        }
    }

    C1599f(Executor executor) {
        this.f7243a = executor;
    }

    public void execute(Runnable runnable) {
        this.f7243a.execute(new C1600a(runnable));
    }
}
