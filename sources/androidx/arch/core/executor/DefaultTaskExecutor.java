package androidx.arch.core.executor;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DefaultTaskExecutor extends TaskExecutor {

    /* renamed from: a */
    private final Object f1739a = new Object();

    /* renamed from: b */
    private final ExecutorService f1740b = Executors.newFixedThreadPool(4, new C0345a(this));
    @Nullable

    /* renamed from: c */
    private volatile Handler f1741c;

    /* renamed from: androidx.arch.core.executor.DefaultTaskExecutor$a */
    class C0345a implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f1742a = new AtomicInteger(0);

        C0345a(DefaultTaskExecutor defaultTaskExecutor) {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", new Object[]{Integer.valueOf(this.f1742a.getAndIncrement())}));
            return thread;
        }
    }

    /* renamed from: a */
    private static Handler m1175a(@NonNull Looper looper) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return Handler.createAsync(looper);
        }
        if (i >= 16) {
            Class<Handler> cls = Handler.class;
            try {
                return cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            } catch (InvocationTargetException unused2) {
                return new Handler(looper);
            }
        }
        return new Handler(looper);
    }

    public void executeOnDiskIO(Runnable runnable) {
        this.f1740b.execute(runnable);
    }

    public boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public void postToMainThread(Runnable runnable) {
        if (this.f1741c == null) {
            synchronized (this.f1739a) {
                if (this.f1741c == null) {
                    this.f1741c = m1175a(Looper.getMainLooper());
                }
            }
        }
        this.f1741c.post(runnable);
    }
}
