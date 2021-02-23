package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpecDao;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class StopWorkRunnable implements Runnable {

    /* renamed from: c */
    private static final String f5357c = Logger.tagWithPrefix("StopWorkRunnable");

    /* renamed from: a */
    private WorkManagerImpl f5358a;

    /* renamed from: b */
    private String f5359b;

    public StopWorkRunnable(WorkManagerImpl workManagerImpl, String str) {
        this.f5358a = workManagerImpl;
        this.f5359b = str;
    }

    public void run() {
        WorkDatabase workDatabase = this.f5358a.getWorkDatabase();
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        workDatabase.beginTransaction();
        try {
            if (workSpecDao.getState(this.f5359b) == WorkInfo.State.RUNNING) {
                workSpecDao.setState(WorkInfo.State.ENQUEUED, this.f5359b);
            }
            boolean stopWork = this.f5358a.getProcessor().stopWork(this.f5359b);
            Logger.get().debug(f5357c, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", new Object[]{this.f5359b, Boolean.valueOf(stopWork)}), new Throwable[0]);
            workDatabase.setTransactionSuccessful();
        } finally {
            workDatabase.endTransaction();
        }
    }
}
