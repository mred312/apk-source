package androidx.work.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class Processor implements ExecutionListener {

    /* renamed from: j */
    private static final String f5084j = Logger.tagWithPrefix("Processor");

    /* renamed from: a */
    private Context f5085a;

    /* renamed from: b */
    private Configuration f5086b;

    /* renamed from: c */
    private TaskExecutor f5087c;

    /* renamed from: d */
    private WorkDatabase f5088d;

    /* renamed from: e */
    private Map<String, WorkerWrapper> f5089e = new HashMap();

    /* renamed from: f */
    private List<Scheduler> f5090f;

    /* renamed from: g */
    private Set<String> f5091g;

    /* renamed from: h */
    private final List<ExecutionListener> f5092h;

    /* renamed from: i */
    private final Object f5093i;

    /* renamed from: androidx.work.impl.Processor$a */
    private static class C1079a implements Runnable {
        @NonNull

        /* renamed from: a */
        private ExecutionListener f5094a;
        @NonNull

        /* renamed from: b */
        private String f5095b;
        @NonNull

        /* renamed from: c */
        private ListenableFuture<Boolean> f5096c;

        C1079a(@NonNull ExecutionListener executionListener, @NonNull String str, @NonNull ListenableFuture<Boolean> listenableFuture) {
            this.f5094a = executionListener;
            this.f5095b = str;
            this.f5096c = listenableFuture;
        }

        public void run() {
            boolean z;
            try {
                z = this.f5096c.get().booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z = true;
            }
            this.f5094a.onExecuted(this.f5095b, z);
        }
    }

    public Processor(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, List<Scheduler> list) {
        this.f5085a = context;
        this.f5086b = configuration;
        this.f5087c = taskExecutor;
        this.f5088d = workDatabase;
        this.f5090f = list;
        this.f5091g = new HashSet();
        this.f5092h = new ArrayList();
        this.f5093i = new Object();
    }

    public void addExecutionListener(ExecutionListener executionListener) {
        synchronized (this.f5093i) {
            this.f5092h.add(executionListener);
        }
    }

    public boolean hasWork() {
        boolean z;
        synchronized (this.f5093i) {
            z = !this.f5089e.isEmpty();
        }
        return z;
    }

    public boolean isCancelled(String str) {
        boolean contains;
        synchronized (this.f5093i) {
            contains = this.f5091g.contains(str);
        }
        return contains;
    }

    public boolean isEnqueued(@NonNull String str) {
        boolean containsKey;
        synchronized (this.f5093i) {
            containsKey = this.f5089e.containsKey(str);
        }
        return containsKey;
    }

    public void onExecuted(@NonNull String str, boolean z) {
        synchronized (this.f5093i) {
            this.f5089e.remove(str);
            Logger.get().debug(f5084j, String.format("%s %s executed; reschedule = %s", new Object[]{getClass().getSimpleName(), str, Boolean.valueOf(z)}), new Throwable[0]);
            for (ExecutionListener onExecuted : this.f5092h) {
                onExecuted.onExecuted(str, z);
            }
        }
    }

    public void removeExecutionListener(ExecutionListener executionListener) {
        synchronized (this.f5093i) {
            this.f5092h.remove(executionListener);
        }
    }

    public boolean startWork(String str) {
        return startWork(str, (WorkerParameters.RuntimeExtras) null);
    }

    public boolean stopAndCancelWork(String str) {
        synchronized (this.f5093i) {
            Logger logger = Logger.get();
            String str2 = f5084j;
            logger.debug(str2, String.format("Processor cancelling %s", new Object[]{str}), new Throwable[0]);
            this.f5091g.add(str);
            WorkerWrapper remove = this.f5089e.remove(str);
            if (remove != null) {
                remove.interrupt(true);
                Logger.get().debug(str2, String.format("WorkerWrapper cancelled for %s", new Object[]{str}), new Throwable[0]);
                return true;
            }
            Logger.get().debug(str2, String.format("WorkerWrapper could not be found for %s", new Object[]{str}), new Throwable[0]);
            return false;
        }
    }

    public boolean stopWork(String str) {
        synchronized (this.f5093i) {
            Logger logger = Logger.get();
            String str2 = f5084j;
            logger.debug(str2, String.format("Processor stopping %s", new Object[]{str}), new Throwable[0]);
            WorkerWrapper remove = this.f5089e.remove(str);
            if (remove != null) {
                remove.interrupt(false);
                Logger.get().debug(str2, String.format("WorkerWrapper stopped for %s", new Object[]{str}), new Throwable[0]);
                return true;
            }
            Logger.get().debug(str2, String.format("WorkerWrapper could not be found for %s", new Object[]{str}), new Throwable[0]);
            return false;
        }
    }

    public boolean startWork(String str, WorkerParameters.RuntimeExtras runtimeExtras) {
        synchronized (this.f5093i) {
            if (this.f5089e.containsKey(str)) {
                Logger.get().debug(f5084j, String.format("Work %s is already enqueued for processing", new Object[]{str}), new Throwable[0]);
                return false;
            }
            WorkerWrapper build = new WorkerWrapper.Builder(this.f5085a, this.f5086b, this.f5087c, this.f5088d, str).withSchedulers(this.f5090f).withRuntimeExtras(runtimeExtras).build();
            ListenableFuture<Boolean> future = build.getFuture();
            future.addListener(new C1079a(this, str, future), this.f5087c.getMainThreadExecutor());
            this.f5089e.put(str, build);
            this.f5087c.getBackgroundExecutor().execute(build);
            Logger.get().debug(f5084j, String.format("%s: processing %s", new Object[]{getClass().getSimpleName(), str}), new Throwable[0]);
            return true;
        }
    }
}
