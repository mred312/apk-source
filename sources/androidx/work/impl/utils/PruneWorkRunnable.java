package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.work.Operation;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.WorkManagerImpl;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class PruneWorkRunnable implements Runnable {

    /* renamed from: a */
    private final WorkManagerImpl f5337a;

    /* renamed from: b */
    private final OperationImpl f5338b = new OperationImpl();

    public PruneWorkRunnable(WorkManagerImpl workManagerImpl) {
        this.f5337a = workManagerImpl;
    }

    public Operation getOperation() {
        return this.f5338b;
    }

    public void run() {
        try {
            this.f5337a.getWorkDatabase().workSpecDao().pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast();
            this.f5338b.setState(Operation.SUCCESS);
        } catch (Throwable th) {
            this.f5338b.setState(new Operation.State.FAILURE(th));
        }
    }
}
