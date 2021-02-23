package androidx.work;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public final class WorkInfo {
    @NonNull

    /* renamed from: a */
    private UUID f5059a;
    @NonNull

    /* renamed from: b */
    private State f5060b;
    @NonNull

    /* renamed from: c */
    private Data f5061c;
    @NonNull

    /* renamed from: d */
    private Set<String> f5062d;

    /* renamed from: e */
    private int f5063e;

    public enum State {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        public boolean isFinished() {
            return this == SUCCEEDED || this == FAILED || this == CANCELLED;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkInfo(@NonNull UUID uuid, @NonNull State state, @NonNull Data data, @NonNull List<String> list, int i) {
        this.f5059a = uuid;
        this.f5060b = state;
        this.f5061c = data;
        this.f5062d = new HashSet(list);
        this.f5063e = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WorkInfo.class != obj.getClass()) {
            return false;
        }
        WorkInfo workInfo = (WorkInfo) obj;
        if (this.f5063e == workInfo.f5063e && this.f5059a.equals(workInfo.f5059a) && this.f5060b == workInfo.f5060b && this.f5061c.equals(workInfo.f5061c)) {
            return this.f5062d.equals(workInfo.f5062d);
        }
        return false;
    }

    @NonNull
    public UUID getId() {
        return this.f5059a;
    }

    @NonNull
    public Data getOutputData() {
        return this.f5061c;
    }

    @IntRange(from = 0)
    public int getRunAttemptCount() {
        return this.f5063e;
    }

    @NonNull
    public State getState() {
        return this.f5060b;
    }

    @NonNull
    public Set<String> getTags() {
        return this.f5062d;
    }

    public int hashCode() {
        return (((((((this.f5059a.hashCode() * 31) + this.f5060b.hashCode()) * 31) + this.f5061c.hashCode()) * 31) + this.f5062d.hashCode()) * 31) + this.f5063e;
    }

    public String toString() {
        return "WorkInfo{mId='" + this.f5059a + '\'' + ", mState=" + this.f5060b + ", mOutputData=" + this.f5061c + ", mTags=" + this.f5062d + '}';
    }
}
