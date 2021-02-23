package androidx.work;

import android.net.Network;
import android.net.Uri;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class WorkerParameters {
    @NonNull

    /* renamed from: a */
    private UUID f5074a;
    @NonNull

    /* renamed from: b */
    private Data f5075b;
    @NonNull

    /* renamed from: c */
    private Set<String> f5076c;
    @NonNull

    /* renamed from: d */
    private RuntimeExtras f5077d;

    /* renamed from: e */
    private int f5078e;
    @NonNull

    /* renamed from: f */
    private Executor f5079f;
    @NonNull

    /* renamed from: g */
    private TaskExecutor f5080g;
    @NonNull

    /* renamed from: h */
    private WorkerFactory f5081h;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class RuntimeExtras {
        @RequiresApi(28)
        public Network network;
        @NonNull
        public List<String> triggeredContentAuthorities = Collections.emptyList();
        @NonNull
        public List<Uri> triggeredContentUris = Collections.emptyList();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkerParameters(@NonNull UUID uuid, @NonNull Data data, @NonNull Collection<String> collection, @NonNull RuntimeExtras runtimeExtras, @IntRange(from = 0) int i, @NonNull Executor executor, @NonNull TaskExecutor taskExecutor, @NonNull WorkerFactory workerFactory) {
        this.f5074a = uuid;
        this.f5075b = data;
        this.f5076c = new HashSet(collection);
        this.f5077d = runtimeExtras;
        this.f5078e = i;
        this.f5079f = executor;
        this.f5080g = taskExecutor;
        this.f5081h = workerFactory;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Executor getBackgroundExecutor() {
        return this.f5079f;
    }

    @NonNull
    public UUID getId() {
        return this.f5074a;
    }

    @NonNull
    public Data getInputData() {
        return this.f5075b;
    }

    @RequiresApi(28)
    @Nullable
    public Network getNetwork() {
        return this.f5077d.network;
    }

    @IntRange(from = 0)
    public int getRunAttemptCount() {
        return this.f5078e;
    }

    @NonNull
    public Set<String> getTags() {
        return this.f5076c;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public TaskExecutor getTaskExecutor() {
        return this.f5080g;
    }

    @RequiresApi(24)
    @NonNull
    public List<String> getTriggeredContentAuthorities() {
        return this.f5077d.triggeredContentAuthorities;
    }

    @RequiresApi(24)
    @NonNull
    public List<Uri> getTriggeredContentUris() {
        return this.f5077d.triggeredContentUris;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkerFactory getWorkerFactory() {
        return this.f5081h;
    }
}
