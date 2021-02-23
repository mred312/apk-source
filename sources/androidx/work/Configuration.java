package androidx.work;

import android.os.Build;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class Configuration {
    public static final int MIN_SCHEDULER_LIMIT = 20;
    @NonNull

    /* renamed from: a */
    private final Executor f5011a;
    @NonNull

    /* renamed from: b */
    private final Executor f5012b;
    @NonNull

    /* renamed from: c */
    private final WorkerFactory f5013c;

    /* renamed from: d */
    private final int f5014d;

    /* renamed from: e */
    private final int f5015e;

    /* renamed from: f */
    private final int f5016f;

    /* renamed from: g */
    private final int f5017g;

    public static final class Builder {

        /* renamed from: a */
        Executor f5018a;

        /* renamed from: b */
        WorkerFactory f5019b;

        /* renamed from: c */
        Executor f5020c;

        /* renamed from: d */
        int f5021d = 4;

        /* renamed from: e */
        int f5022e = 0;

        /* renamed from: f */
        int f5023f = Integer.MAX_VALUE;

        /* renamed from: g */
        int f5024g = 20;

        @NonNull
        public Configuration build() {
            return new Configuration(this);
        }

        @NonNull
        public Builder setExecutor(@NonNull Executor executor) {
            this.f5018a = executor;
            return this;
        }

        @NonNull
        public Builder setJobSchedulerJobIdRange(int i, int i2) {
            if (i2 - i >= 1000) {
                this.f5022e = i;
                this.f5023f = i2;
                return this;
            }
            throw new IllegalArgumentException("WorkManager needs a range of at least 1000 job ids.");
        }

        @NonNull
        public Builder setMaxSchedulerLimit(int i) {
            if (i >= 20) {
                this.f5024g = Math.min(i, 50);
                return this;
            }
            throw new IllegalArgumentException("WorkManager needs to be able to schedule at least 20 jobs in JobScheduler.");
        }

        @NonNull
        public Builder setMinimumLoggingLevel(int i) {
            this.f5021d = i;
            return this;
        }

        @NonNull
        public Builder setTaskExecutor(@NonNull Executor executor) {
            this.f5020c = executor;
            return this;
        }

        @NonNull
        public Builder setWorkerFactory(@NonNull WorkerFactory workerFactory) {
            this.f5019b = workerFactory;
            return this;
        }
    }

    public interface Provider {
        @NonNull
        Configuration getWorkManagerConfiguration();
    }

    Configuration(@NonNull Builder builder) {
        Executor executor = builder.f5018a;
        if (executor == null) {
            this.f5011a = m3872a();
        } else {
            this.f5011a = executor;
        }
        Executor executor2 = builder.f5020c;
        if (executor2 == null) {
            this.f5012b = m3872a();
        } else {
            this.f5012b = executor2;
        }
        WorkerFactory workerFactory = builder.f5019b;
        if (workerFactory == null) {
            this.f5013c = WorkerFactory.getDefaultWorkerFactory();
        } else {
            this.f5013c = workerFactory;
        }
        this.f5014d = builder.f5021d;
        this.f5015e = builder.f5022e;
        this.f5016f = builder.f5023f;
        this.f5017g = builder.f5024g;
    }

    @NonNull
    /* renamed from: a */
    private Executor m3872a() {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)));
    }

    @NonNull
    public Executor getExecutor() {
        return this.f5011a;
    }

    public int getMaxJobSchedulerId() {
        return this.f5016f;
    }

    @IntRange(from = 20, mo779to = 50)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxSchedulerLimit() {
        if (Build.VERSION.SDK_INT == 23) {
            return this.f5017g / 2;
        }
        return this.f5017g;
    }

    public int getMinJobSchedulerId() {
        return this.f5015e;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getMinimumLoggingLevel() {
        return this.f5014d;
    }

    @NonNull
    public Executor getTaskExecutor() {
        return this.f5012b;
    }

    @NonNull
    public WorkerFactory getWorkerFactory() {
        return this.f5013c;
    }
}
