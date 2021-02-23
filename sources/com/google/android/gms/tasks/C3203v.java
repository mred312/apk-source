package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.tasks.v */
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
final class C3203v implements Executor {
    C3203v() {
    }

    public final void execute(@NonNull Runnable runnable) {
        runnable.run();
    }
}
