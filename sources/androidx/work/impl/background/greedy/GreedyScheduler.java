package androidx.work.impl.background.greedy;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class GreedyScheduler implements Scheduler, WorkConstraintsCallback, ExecutionListener {

    /* renamed from: f */
    private static final String f5162f = Logger.tagWithPrefix("GreedyScheduler");

    /* renamed from: a */
    private WorkManagerImpl f5163a;

    /* renamed from: b */
    private WorkConstraintsTracker f5164b;

    /* renamed from: c */
    private List<WorkSpec> f5165c = new ArrayList();

    /* renamed from: d */
    private boolean f5166d;

    /* renamed from: e */
    private final Object f5167e;

    public GreedyScheduler(Context context, TaskExecutor taskExecutor, WorkManagerImpl workManagerImpl) {
        this.f5163a = workManagerImpl;
        this.f5164b = new WorkConstraintsTracker(context, taskExecutor, this);
        this.f5167e = new Object();
    }

    /* renamed from: a */
    private void m3920a() {
        if (!this.f5166d) {
            this.f5163a.getProcessor().addExecutionListener(this);
            this.f5166d = true;
        }
    }

    /* renamed from: b */
    private void m3921b(@NonNull String str) {
        synchronized (this.f5167e) {
            int size = this.f5165c.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                } else if (this.f5165c.get(i).f5281id.equals(str)) {
                    Logger.get().debug(f5162f, String.format("Stopping tracking for %s", new Object[]{str}), new Throwable[0]);
                    this.f5165c.remove(i);
                    this.f5164b.replace(this.f5165c);
                    break;
                } else {
                    i++;
                }
            }
        }
    }

    public void cancel(@NonNull String str) {
        m3920a();
        Logger.get().debug(f5162f, String.format("Cancelling work ID %s", new Object[]{str}), new Throwable[0]);
        this.f5163a.stopWork(str);
    }

    public void onAllConstraintsMet(@NonNull List<String> list) {
        for (String next : list) {
            Logger.get().debug(f5162f, String.format("Constraints met: Scheduling work ID %s", new Object[]{next}), new Throwable[0]);
            this.f5163a.startWork(next);
        }
    }

    public void onAllConstraintsNotMet(@NonNull List<String> list) {
        for (String next : list) {
            Logger.get().debug(f5162f, String.format("Constraints not met: Cancelling work ID %s", new Object[]{next}), new Throwable[0]);
            this.f5163a.stopWork(next);
        }
    }

    public void onExecuted(@NonNull String str, boolean z) {
        m3921b(str);
    }

    public void schedule(@NonNull WorkSpec... workSpecArr) {
        m3920a();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (WorkSpec workSpec : workSpecArr) {
            if (workSpec.state == WorkInfo.State.ENQUEUED && !workSpec.isPeriodic() && workSpec.initialDelay == 0 && !workSpec.isBackedOff()) {
                if (!workSpec.hasConstraints()) {
                    Logger.get().debug(f5162f, String.format("Starting work for %s", new Object[]{workSpec.f5281id}), new Throwable[0]);
                    this.f5163a.startWork(workSpec.f5281id);
                } else if (Build.VERSION.SDK_INT < 24 || !workSpec.constraints.hasContentUriTriggers()) {
                    arrayList.add(workSpec);
                    arrayList2.add(workSpec.f5281id);
                }
            }
        }
        synchronized (this.f5167e) {
            if (!arrayList.isEmpty()) {
                Logger.get().debug(f5162f, String.format("Starting tracking for [%s]", new Object[]{TextUtils.join(",", arrayList2)}), new Throwable[0]);
                this.f5165c.addAll(arrayList);
                this.f5164b.replace(this.f5165c);
            }
        }
    }

    @VisibleForTesting
    public GreedyScheduler(WorkManagerImpl workManagerImpl, WorkConstraintsTracker workConstraintsTracker) {
        this.f5163a = workManagerImpl;
        this.f5164b = workConstraintsTracker;
        this.f5167e = new Object();
    }
}
