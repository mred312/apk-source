package androidx.core.p003os;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* renamed from: androidx.core.os.HandlerExecutor */
public class HandlerExecutor implements Executor {

    /* renamed from: a */
    private final Handler f2419a;

    public HandlerExecutor(@NonNull Handler handler) {
        this.f2419a = (Handler) Preconditions.checkNotNull(handler);
    }

    public void execute(@NonNull Runnable runnable) {
        if (!this.f2419a.post((Runnable) Preconditions.checkNotNull(runnable))) {
            throw new RejectedExecutionException(this.f2419a + " is shutting down");
        }
    }
}
