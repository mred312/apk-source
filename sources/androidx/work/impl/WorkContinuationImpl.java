package androidx.work.impl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LiveData;
import androidx.work.ArrayCreatingInputMerger;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import androidx.work.impl.utils.EnqueueRunnable;
import androidx.work.impl.utils.StatusRunnable;
import androidx.work.impl.workers.CombineContinuationsWorker;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkContinuationImpl extends WorkContinuation {

    /* renamed from: j */
    private static final String f5098j = Logger.tagWithPrefix("WorkContinuationImpl");

    /* renamed from: a */
    private final WorkManagerImpl f5099a;

    /* renamed from: b */
    private final String f5100b;

    /* renamed from: c */
    private final ExistingWorkPolicy f5101c;

    /* renamed from: d */
    private final List<? extends WorkRequest> f5102d;

    /* renamed from: e */
    private final List<String> f5103e;

    /* renamed from: f */
    private final List<String> f5104f;

    /* renamed from: g */
    private final List<WorkContinuationImpl> f5105g;

    /* renamed from: h */
    private boolean f5106h;

    /* renamed from: i */
    private Operation f5107i;

    WorkContinuationImpl(@NonNull WorkManagerImpl workManagerImpl, @NonNull List<? extends WorkRequest> list) {
        this(workManagerImpl, (String) null, ExistingWorkPolicy.KEEP, list, (List<WorkContinuationImpl>) null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* renamed from: a */
    private static boolean m3891a(@NonNull WorkContinuationImpl workContinuationImpl, @NonNull Set<String> set) {
        set.addAll(workContinuationImpl.getIds());
        Set<String> prerequisitesFor = prerequisitesFor(workContinuationImpl);
        for (String contains : set) {
            if (prerequisitesFor.contains(contains)) {
                return true;
            }
        }
        List<WorkContinuationImpl> parents = workContinuationImpl.getParents();
        if (parents != null && !parents.isEmpty()) {
            for (WorkContinuationImpl a : parents) {
                if (m3891a(a, set)) {
                    return true;
                }
            }
        }
        set.removeAll(workContinuationImpl.getIds());
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Set<String> prerequisitesFor(WorkContinuationImpl workContinuationImpl) {
        HashSet hashSet = new HashSet();
        List<WorkContinuationImpl> parents = workContinuationImpl.getParents();
        if (parents != null && !parents.isEmpty()) {
            for (WorkContinuationImpl ids : parents) {
                hashSet.addAll(ids.getIds());
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public WorkContinuation combineInternal(@NonNull List<WorkContinuation> list) {
        OneTimeWorkRequest oneTimeWorkRequest = (OneTimeWorkRequest) new OneTimeWorkRequest.Builder(CombineContinuationsWorker.class).setInputMerger(ArrayCreatingInputMerger.class).build();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<WorkContinuation> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((WorkContinuationImpl) it.next());
        }
        return new WorkContinuationImpl(this.f5099a, (String) null, ExistingWorkPolicy.KEEP, Collections.singletonList(oneTimeWorkRequest), arrayList);
    }

    @NonNull
    public Operation enqueue() {
        if (!this.f5106h) {
            EnqueueRunnable enqueueRunnable = new EnqueueRunnable(this);
            this.f5099a.getWorkTaskExecutor().executeOnBackgroundThread(enqueueRunnable);
            this.f5107i = enqueueRunnable.getOperation();
        } else {
            Logger.get().warning(f5098j, String.format("Already enqueued work ids (%s)", new Object[]{TextUtils.join(", ", this.f5103e)}), new Throwable[0]);
        }
        return this.f5107i;
    }

    public List<String> getAllIds() {
        return this.f5104f;
    }

    public ExistingWorkPolicy getExistingWorkPolicy() {
        return this.f5101c;
    }

    @NonNull
    public List<String> getIds() {
        return this.f5103e;
    }

    @Nullable
    public String getName() {
        return this.f5100b;
    }

    public List<WorkContinuationImpl> getParents() {
        return this.f5105g;
    }

    @NonNull
    public List<? extends WorkRequest> getWork() {
        return this.f5102d;
    }

    @NonNull
    public ListenableFuture<List<WorkInfo>> getWorkInfos() {
        StatusRunnable<List<WorkInfo>> forStringIds = StatusRunnable.forStringIds(this.f5099a, this.f5104f);
        this.f5099a.getWorkTaskExecutor().executeOnBackgroundThread(forStringIds);
        return forStringIds.getFuture();
    }

    @NonNull
    public LiveData<List<WorkInfo>> getWorkInfosLiveData() {
        return this.f5099a.mo8862b(this.f5104f);
    }

    @NonNull
    public WorkManagerImpl getWorkManagerImpl() {
        return this.f5099a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean hasCycles() {
        return m3891a(this, new HashSet());
    }

    public boolean isEnqueued() {
        return this.f5106h;
    }

    public void markEnqueued() {
        this.f5106h = true;
    }

    @NonNull
    public WorkContinuation then(@NonNull List<OneTimeWorkRequest> list) {
        return new WorkContinuationImpl(this.f5099a, this.f5100b, ExistingWorkPolicy.KEEP, list, Collections.singletonList(this));
    }

    WorkContinuationImpl(@NonNull WorkManagerImpl workManagerImpl, String str, ExistingWorkPolicy existingWorkPolicy, @NonNull List<? extends WorkRequest> list) {
        this(workManagerImpl, str, existingWorkPolicy, list, (List<WorkContinuationImpl>) null);
    }

    WorkContinuationImpl(@NonNull WorkManagerImpl workManagerImpl, String str, ExistingWorkPolicy existingWorkPolicy, @NonNull List<? extends WorkRequest> list, @Nullable List<WorkContinuationImpl> list2) {
        this.f5099a = workManagerImpl;
        this.f5100b = str;
        this.f5101c = existingWorkPolicy;
        this.f5102d = list;
        this.f5105g = list2;
        this.f5103e = new ArrayList(list.size());
        this.f5104f = new ArrayList();
        if (list2 != null) {
            for (WorkContinuationImpl workContinuationImpl : list2) {
                this.f5104f.addAll(workContinuationImpl.f5104f);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            String stringId = ((WorkRequest) list.get(i)).getStringId();
            this.f5103e.add(stringId);
            this.f5104f.add(stringId);
        }
    }
}
