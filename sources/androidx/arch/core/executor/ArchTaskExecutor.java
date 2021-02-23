package androidx.arch.core.executor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ArchTaskExecutor extends TaskExecutor {

    /* renamed from: c */
    private static volatile ArchTaskExecutor f1734c;
    @NonNull

    /* renamed from: d */
    private static final Executor f1735d = new C0343a();
    @NonNull

    /* renamed from: e */
    private static final Executor f1736e = new C0344b();
    @NonNull

    /* renamed from: a */
    private TaskExecutor f1737a;
    @NonNull

    /* renamed from: b */
    private TaskExecutor f1738b;

    /* renamed from: androidx.arch.core.executor.ArchTaskExecutor$a */
    static class C0343a implements Executor {
        C0343a() {
        }

        public void execute(Runnable runnable) {
            ArchTaskExecutor.getInstance().postToMainThread(runnable);
        }
    }

    /* renamed from: androidx.arch.core.executor.ArchTaskExecutor$b */
    static class C0344b implements Executor {
        C0344b() {
        }

        public void execute(Runnable runnable) {
            ArchTaskExecutor.getInstance().executeOnDiskIO(runnable);
        }
    }

    private ArchTaskExecutor() {
        DefaultTaskExecutor defaultTaskExecutor = new DefaultTaskExecutor();
        this.f1738b = defaultTaskExecutor;
        this.f1737a = defaultTaskExecutor;
    }

    @NonNull
    public static Executor getIOThreadExecutor() {
        return f1736e;
    }

    @NonNull
    public static ArchTaskExecutor getInstance() {
        if (f1734c != null) {
            return f1734c;
        }
        synchronized (ArchTaskExecutor.class) {
            if (f1734c == null) {
                f1734c = new ArchTaskExecutor();
            }
        }
        return f1734c;
    }

    @NonNull
    public static Executor getMainThreadExecutor() {
        return f1735d;
    }

    public void executeOnDiskIO(Runnable runnable) {
        this.f1737a.executeOnDiskIO(runnable);
    }

    public boolean isMainThread() {
        return this.f1737a.isMainThread();
    }

    public void postToMainThread(Runnable runnable) {
        this.f1737a.postToMainThread(runnable);
    }

    public void setDelegate(@Nullable TaskExecutor taskExecutor) {
        if (taskExecutor == null) {
            taskExecutor = this.f1738b;
        }
        this.f1737a = taskExecutor;
    }
}
