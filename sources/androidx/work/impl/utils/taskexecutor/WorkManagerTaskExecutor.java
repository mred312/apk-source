package androidx.work.impl.utils.taskexecutor;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.impl.utils.SerialExecutor;
import java.util.concurrent.Executor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkManagerTaskExecutor implements TaskExecutor {

    /* renamed from: a */
    private final Executor f5391a;

    /* renamed from: b */
    private final Handler f5392b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    private final Executor f5393c = new C1148a();

    /* renamed from: androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor$a */
    class C1148a implements Executor {
        C1148a() {
        }

        public void execute(@NonNull Runnable runnable) {
            WorkManagerTaskExecutor.this.postToMainThread(runnable);
        }
    }

    public WorkManagerTaskExecutor(@NonNull Executor executor) {
        this.f5391a = new SerialExecutor(executor);
    }

    public void executeOnBackgroundThread(Runnable runnable) {
        this.f5391a.execute(runnable);
    }

    public Executor getBackgroundExecutor() {
        return this.f5391a;
    }

    public Executor getMainThreadExecutor() {
        return this.f5393c;
    }

    public void postToMainThread(Runnable runnable) {
        this.f5392b.post(runnable);
    }
}
