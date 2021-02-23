package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.UUID;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class StatusRunnable<T> implements Runnable {

    /* renamed from: a */
    private final SettableFuture<T> f5348a = SettableFuture.create();

    /* renamed from: androidx.work.impl.utils.StatusRunnable$a */
    static class C1133a extends StatusRunnable<List<WorkInfo>> {

        /* renamed from: b */
        final /* synthetic */ WorkManagerImpl f5349b;

        /* renamed from: c */
        final /* synthetic */ List f5350c;

        C1133a(WorkManagerImpl workManagerImpl, List list) {
            this.f5349b = workManagerImpl;
            this.f5350c = list;
        }

        /* renamed from: b */
        public List<WorkInfo> mo9078a() {
            return WorkSpec.WORK_INFO_MAPPER.apply(this.f5349b.getWorkDatabase().workSpecDao().getWorkStatusPojoForIds(this.f5350c));
        }
    }

    /* renamed from: androidx.work.impl.utils.StatusRunnable$b */
    static class C1134b extends StatusRunnable<WorkInfo> {

        /* renamed from: b */
        final /* synthetic */ WorkManagerImpl f5351b;

        /* renamed from: c */
        final /* synthetic */ UUID f5352c;

        C1134b(WorkManagerImpl workManagerImpl, UUID uuid) {
            this.f5351b = workManagerImpl;
            this.f5352c = uuid;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public WorkInfo mo9078a() {
            WorkSpec.WorkInfoPojo workStatusPojoForId = this.f5351b.getWorkDatabase().workSpecDao().getWorkStatusPojoForId(this.f5352c.toString());
            if (workStatusPojoForId != null) {
                return workStatusPojoForId.toWorkInfo();
            }
            return null;
        }
    }

    /* renamed from: androidx.work.impl.utils.StatusRunnable$c */
    static class C1135c extends StatusRunnable<List<WorkInfo>> {

        /* renamed from: b */
        final /* synthetic */ WorkManagerImpl f5353b;

        /* renamed from: c */
        final /* synthetic */ String f5354c;

        C1135c(WorkManagerImpl workManagerImpl, String str) {
            this.f5353b = workManagerImpl;
            this.f5354c = str;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public List<WorkInfo> mo9078a() {
            return WorkSpec.WORK_INFO_MAPPER.apply(this.f5353b.getWorkDatabase().workSpecDao().getWorkStatusPojoForTag(this.f5354c));
        }
    }

    /* renamed from: androidx.work.impl.utils.StatusRunnable$d */
    static class C1136d extends StatusRunnable<List<WorkInfo>> {

        /* renamed from: b */
        final /* synthetic */ WorkManagerImpl f5355b;

        /* renamed from: c */
        final /* synthetic */ String f5356c;

        C1136d(WorkManagerImpl workManagerImpl, String str) {
            this.f5355b = workManagerImpl;
            this.f5356c = str;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public List<WorkInfo> mo9078a() {
            return WorkSpec.WORK_INFO_MAPPER.apply(this.f5355b.getWorkDatabase().workSpecDao().getWorkStatusPojoForName(this.f5356c));
        }
    }

    public static StatusRunnable<List<WorkInfo>> forStringIds(@NonNull WorkManagerImpl workManagerImpl, @NonNull List<String> list) {
        return new C1133a(workManagerImpl, list);
    }

    public static StatusRunnable<List<WorkInfo>> forTag(@NonNull WorkManagerImpl workManagerImpl, @NonNull String str) {
        return new C1135c(workManagerImpl, str);
    }

    public static StatusRunnable<WorkInfo> forUUID(@NonNull WorkManagerImpl workManagerImpl, @NonNull UUID uuid) {
        return new C1134b(workManagerImpl, uuid);
    }

    public static StatusRunnable<List<WorkInfo>> forUniqueWork(@NonNull WorkManagerImpl workManagerImpl, @NonNull String str) {
        return new C1136d(workManagerImpl, str);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: a */
    public abstract T mo9078a();

    public ListenableFuture<T> getFuture() {
        return this.f5348a;
    }

    public void run() {
        try {
            this.f5348a.set(mo9078a());
        } catch (Throwable th) {
            this.f5348a.setException(th);
        }
    }
}
