package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.tasks.zzb;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
public final class TaskExecutors {
    public static final Executor MAIN_THREAD = new C3179a();

    /* renamed from: a */
    static final Executor f18756a = new C3203v();

    /* renamed from: com.google.android.gms.tasks.TaskExecutors$a */
    /* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
    private static final class C3179a implements Executor {

        /* renamed from: a */
        private final Handler f18757a = new zzb(Looper.getMainLooper());

        public final void execute(@NonNull Runnable runnable) {
            this.f18757a.post(runnable);
        }
    }

    private TaskExecutors() {
    }
}
