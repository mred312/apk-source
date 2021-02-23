package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpecDao;
import java.util.LinkedList;
import java.util.UUID;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class CancelWorkRunnable implements Runnable {

    /* renamed from: a */
    private final OperationImpl f5305a = new OperationImpl();

    /* renamed from: androidx.work.impl.utils.CancelWorkRunnable$a */
    static class C1125a extends CancelWorkRunnable {

        /* renamed from: b */
        final /* synthetic */ WorkManagerImpl f5306b;

        /* renamed from: c */
        final /* synthetic */ UUID f5307c;

        C1125a(WorkManagerImpl workManagerImpl, UUID uuid) {
            this.f5306b = workManagerImpl;
            this.f5307c = uuid;
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: package-private */
        @WorkerThread
        /* renamed from: d */
        public void mo9051d() {
            WorkDatabase workDatabase = this.f5306b.getWorkDatabase();
            workDatabase.beginTransaction();
            try {
                mo9049a(this.f5306b, this.f5307c.toString());
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
                mo9050c(this.f5306b);
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }

    /* renamed from: androidx.work.impl.utils.CancelWorkRunnable$b */
    static class C1126b extends CancelWorkRunnable {

        /* renamed from: b */
        final /* synthetic */ WorkManagerImpl f5308b;

        /* renamed from: c */
        final /* synthetic */ String f5309c;

        C1126b(WorkManagerImpl workManagerImpl, String str) {
            this.f5308b = workManagerImpl;
            this.f5309c = str;
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: package-private */
        @WorkerThread
        /* renamed from: d */
        public void mo9051d() {
            WorkDatabase workDatabase = this.f5308b.getWorkDatabase();
            workDatabase.beginTransaction();
            try {
                for (String a : workDatabase.workSpecDao().getUnfinishedWorkWithTag(this.f5309c)) {
                    mo9049a(this.f5308b, a);
                }
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
                mo9050c(this.f5308b);
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }

    /* renamed from: androidx.work.impl.utils.CancelWorkRunnable$c */
    static class C1127c extends CancelWorkRunnable {

        /* renamed from: b */
        final /* synthetic */ WorkManagerImpl f5310b;

        /* renamed from: c */
        final /* synthetic */ String f5311c;

        /* renamed from: d */
        final /* synthetic */ boolean f5312d;

        C1127c(WorkManagerImpl workManagerImpl, String str, boolean z) {
            this.f5310b = workManagerImpl;
            this.f5311c = str;
            this.f5312d = z;
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: package-private */
        @WorkerThread
        /* renamed from: d */
        public void mo9051d() {
            WorkDatabase workDatabase = this.f5310b.getWorkDatabase();
            workDatabase.beginTransaction();
            try {
                for (String a : workDatabase.workSpecDao().getUnfinishedWorkWithName(this.f5311c)) {
                    mo9049a(this.f5310b, a);
                }
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
                if (this.f5312d) {
                    mo9050c(this.f5310b);
                }
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }

    /* renamed from: androidx.work.impl.utils.CancelWorkRunnable$d */
    static class C1128d extends CancelWorkRunnable {

        /* renamed from: b */
        final /* synthetic */ WorkManagerImpl f5313b;

        C1128d(WorkManagerImpl workManagerImpl) {
            this.f5313b = workManagerImpl;
        }

        /* access modifiers changed from: package-private */
        @WorkerThread
        /* renamed from: d */
        public void mo9051d() {
            WorkDatabase workDatabase = this.f5313b.getWorkDatabase();
            workDatabase.beginTransaction();
            try {
                for (String a : workDatabase.workSpecDao().getAllUnfinishedWork()) {
                    mo9049a(this.f5313b, a);
                }
                workDatabase.setTransactionSuccessful();
                new Preferences(this.f5313b.getApplicationContext()).setLastCancelAllTimeMillis(System.currentTimeMillis());
            } finally {
                workDatabase.endTransaction();
            }
        }
    }

    /* renamed from: b */
    private void m4008b(WorkDatabase workDatabase, String str) {
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        DependencyDao dependencyDao = workDatabase.dependencyDao();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            WorkInfo.State state = workSpecDao.getState(str2);
            if (!(state == WorkInfo.State.SUCCEEDED || state == WorkInfo.State.FAILED)) {
                workSpecDao.setState(WorkInfo.State.CANCELLED, str2);
            }
            linkedList.addAll(dependencyDao.getDependentWorkIds(str2));
        }
    }

    public static CancelWorkRunnable forAll(@NonNull WorkManagerImpl workManagerImpl) {
        return new C1128d(workManagerImpl);
    }

    public static CancelWorkRunnable forId(@NonNull UUID uuid, @NonNull WorkManagerImpl workManagerImpl) {
        return new C1125a(workManagerImpl, uuid);
    }

    public static CancelWorkRunnable forName(@NonNull String str, @NonNull WorkManagerImpl workManagerImpl, boolean z) {
        return new C1127c(workManagerImpl, str, z);
    }

    public static CancelWorkRunnable forTag(@NonNull String str, @NonNull WorkManagerImpl workManagerImpl) {
        return new C1126b(workManagerImpl, str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9049a(WorkManagerImpl workManagerImpl, String str) {
        m4008b(workManagerImpl.getWorkDatabase(), str);
        workManagerImpl.getProcessor().stopAndCancelWork(str);
        for (Scheduler cancel : workManagerImpl.getSchedulers()) {
            cancel.cancel(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo9050c(WorkManagerImpl workManagerImpl) {
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract void mo9051d();

    public Operation getOperation() {
        return this.f5305a;
    }

    public void run() {
        try {
            mo9051d();
            this.f5305a.setState(Operation.SUCCESS);
        } catch (Throwable th) {
            this.f5305a.setState(new Operation.State.FAILURE(th));
        }
    }
}
