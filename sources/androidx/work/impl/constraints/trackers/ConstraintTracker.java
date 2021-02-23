package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class ConstraintTracker<T> {

    /* renamed from: d */
    private static final String f5255d = Logger.tagWithPrefix("ConstraintTracker");

    /* renamed from: a */
    private final Object f5256a = new Object();

    /* renamed from: b */
    private final Set<ConstraintListener<T>> f5257b = new LinkedHashSet();

    /* renamed from: c */
    T f5258c;
    protected final Context mAppContext;
    protected final TaskExecutor mTaskExecutor;

    /* renamed from: androidx.work.impl.constraints.trackers.ConstraintTracker$a */
    class C1103a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ List f5259a;

        C1103a(List list) {
            this.f5259a = list;
        }

        public void run() {
            for (ConstraintListener onConstraintChanged : this.f5259a) {
                onConstraintChanged.onConstraintChanged(ConstraintTracker.this.f5258c);
            }
        }
    }

    ConstraintTracker(@NonNull Context context, @NonNull TaskExecutor taskExecutor) {
        this.mAppContext = context.getApplicationContext();
        this.mTaskExecutor = taskExecutor;
    }

    public void addListener(ConstraintListener<T> constraintListener) {
        synchronized (this.f5256a) {
            if (this.f5257b.add(constraintListener)) {
                if (this.f5257b.size() == 1) {
                    this.f5258c = getInitialState();
                    Logger.get().debug(f5255d, String.format("%s: initial state = %s", new Object[]{getClass().getSimpleName(), this.f5258c}), new Throwable[0]);
                    startTracking();
                }
                constraintListener.onConstraintChanged(this.f5258c);
            }
        }
    }

    public abstract T getInitialState();

    public void removeListener(ConstraintListener<T> constraintListener) {
        synchronized (this.f5256a) {
            if (this.f5257b.remove(constraintListener) && this.f5257b.isEmpty()) {
                stopTracking();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setState(T r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f5256a
            monitor-enter(r0)
            T r1 = r3.f5258c     // Catch:{ all -> 0x002b }
            if (r1 == r4) goto L_0x0029
            if (r1 == 0) goto L_0x0010
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x002b }
            if (r1 == 0) goto L_0x0010
            goto L_0x0029
        L_0x0010:
            r3.f5258c = r4     // Catch:{ all -> 0x002b }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x002b }
            java.util.Set<androidx.work.impl.constraints.ConstraintListener<T>> r1 = r3.f5257b     // Catch:{ all -> 0x002b }
            r4.<init>(r1)     // Catch:{ all -> 0x002b }
            androidx.work.impl.utils.taskexecutor.TaskExecutor r1 = r3.mTaskExecutor     // Catch:{ all -> 0x002b }
            java.util.concurrent.Executor r1 = r1.getMainThreadExecutor()     // Catch:{ all -> 0x002b }
            androidx.work.impl.constraints.trackers.ConstraintTracker$a r2 = new androidx.work.impl.constraints.trackers.ConstraintTracker$a     // Catch:{ all -> 0x002b }
            r2.<init>(r4)     // Catch:{ all -> 0x002b }
            r1.execute(r2)     // Catch:{ all -> 0x002b }
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x002b:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.constraints.trackers.ConstraintTracker.setState(java.lang.Object):void");
    }

    public abstract void startTracking();

    public abstract void stopTracking();
}
