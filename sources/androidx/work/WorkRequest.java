package androidx.work;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public abstract class WorkRequest {
    public static final long DEFAULT_BACKOFF_DELAY_MILLIS = 30000;
    public static final long MAX_BACKOFF_MILLIS = 18000000;
    public static final long MIN_BACKOFF_MILLIS = 10000;
    @NonNull

    /* renamed from: a */
    private UUID f5065a;
    @NonNull

    /* renamed from: b */
    private WorkSpec f5066b;
    @NonNull

    /* renamed from: c */
    private Set<String> f5067c;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected WorkRequest(@NonNull UUID uuid, @NonNull WorkSpec workSpec, @NonNull Set<String> set) {
        this.f5065a = uuid;
        this.f5066b = workSpec;
        this.f5067c = set;
    }

    @NonNull
    public UUID getId() {
        return this.f5065a;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getStringId() {
        return this.f5065a.toString();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Set<String> getTags() {
        return this.f5067c;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkSpec getWorkSpec() {
        return this.f5066b;
    }

    public static abstract class Builder<B extends Builder, W extends WorkRequest> {

        /* renamed from: a */
        boolean f5068a = false;

        /* renamed from: b */
        UUID f5069b = UUID.randomUUID();

        /* renamed from: c */
        WorkSpec f5070c;

        /* renamed from: d */
        Set<String> f5071d = new HashSet();

        Builder(@NonNull Class<? extends ListenableWorker> cls) {
            this.f5070c = new WorkSpec(this.f5069b.toString(), cls.getName());
            addTag(cls.getName());
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: a */
        public abstract W mo8752a();

        @NonNull
        public final B addTag(@NonNull String str) {
            this.f5071d.add(str);
            return mo8753b();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: b */
        public abstract B mo8753b();

        @NonNull
        public final W build() {
            W a = mo8752a();
            this.f5069b = UUID.randomUUID();
            WorkSpec workSpec = new WorkSpec(this.f5070c);
            this.f5070c = workSpec;
            workSpec.f5281id = this.f5069b.toString();
            return a;
        }

        @NonNull
        public final B keepResultsForAtLeast(long j, @NonNull TimeUnit timeUnit) {
            this.f5070c.minimumRetentionDuration = timeUnit.toMillis(j);
            return mo8753b();
        }

        @NonNull
        public final B setBackoffCriteria(@NonNull BackoffPolicy backoffPolicy, long j, @NonNull TimeUnit timeUnit) {
            this.f5068a = true;
            WorkSpec workSpec = this.f5070c;
            workSpec.backoffPolicy = backoffPolicy;
            workSpec.setBackoffDelayDuration(timeUnit.toMillis(j));
            return mo8753b();
        }

        @NonNull
        public final B setConstraints(@NonNull Constraints constraints) {
            this.f5070c.constraints = constraints;
            return mo8753b();
        }

        @NonNull
        public B setInitialDelay(long j, @NonNull TimeUnit timeUnit) {
            this.f5070c.initialDelay = timeUnit.toMillis(j);
            return mo8753b();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        @NonNull
        public final B setInitialRunAttemptCount(int i) {
            this.f5070c.runAttemptCount = i;
            return mo8753b();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        @NonNull
        public final B setInitialState(@NonNull WorkInfo.State state) {
            this.f5070c.state = state;
            return mo8753b();
        }

        @NonNull
        public final B setInputData(@NonNull Data data) {
            this.f5070c.input = data;
            return mo8753b();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        @NonNull
        public final B setPeriodStartTime(long j, @NonNull TimeUnit timeUnit) {
            this.f5070c.periodStartTime = timeUnit.toMillis(j);
            return mo8753b();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        @NonNull
        public final B setScheduleRequestedAt(long j, @NonNull TimeUnit timeUnit) {
            this.f5070c.scheduleRequestedAt = timeUnit.toMillis(j);
            return mo8753b();
        }

        @RequiresApi(26)
        @NonNull
        public final B keepResultsForAtLeast(@NonNull Duration duration) {
            this.f5070c.minimumRetentionDuration = duration.toMillis();
            return mo8753b();
        }

        @RequiresApi(26)
        @NonNull
        public B setInitialDelay(@NonNull Duration duration) {
            this.f5070c.initialDelay = duration.toMillis();
            return mo8753b();
        }

        @RequiresApi(26)
        @NonNull
        public final B setBackoffCriteria(@NonNull BackoffPolicy backoffPolicy, @NonNull Duration duration) {
            this.f5068a = true;
            WorkSpec workSpec = this.f5070c;
            workSpec.backoffPolicy = backoffPolicy;
            workSpec.setBackoffDelayDuration(duration.toMillis());
            return mo8753b();
        }
    }
}
