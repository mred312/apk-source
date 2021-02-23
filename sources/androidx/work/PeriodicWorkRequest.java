package androidx.work;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.work.WorkRequest;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public final class PeriodicWorkRequest extends WorkRequest {
    public static final long MIN_PERIODIC_FLEX_MILLIS = 300000;
    public static final long MIN_PERIODIC_INTERVAL_MILLIS = 900000;

    PeriodicWorkRequest(Builder builder) {
        super(builder.f5069b, builder.f5070c, builder.f5071d);
    }

    public static final class Builder extends WorkRequest.Builder<Builder, PeriodicWorkRequest> {
        public Builder(@NonNull Class<? extends ListenableWorker> cls, long j, @NonNull TimeUnit timeUnit) {
            super(cls);
            this.f5070c.setPeriodic(timeUnit.toMillis(j));
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: b */
        public /* bridge */ /* synthetic */ WorkRequest.Builder mo8753b() {
            mo8764d();
            return this;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: c */
        public PeriodicWorkRequest mo8752a() {
            if (!this.f5068a || Build.VERSION.SDK_INT < 23 || !this.f5070c.constraints.requiresDeviceIdle()) {
                return new PeriodicWorkRequest(this);
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: d */
        public Builder mo8764d() {
            return this;
        }

        @RequiresApi(26)
        public Builder(@NonNull Class<? extends ListenableWorker> cls, @NonNull Duration duration) {
            super(cls);
            this.f5070c.setPeriodic(duration.toMillis());
        }

        public Builder(@NonNull Class<? extends ListenableWorker> cls, long j, @NonNull TimeUnit timeUnit, long j2, @NonNull TimeUnit timeUnit2) {
            super(cls);
            this.f5070c.setPeriodic(timeUnit.toMillis(j), timeUnit2.toMillis(j2));
        }

        @RequiresApi(26)
        public Builder(@NonNull Class<? extends ListenableWorker> cls, @NonNull Duration duration, @NonNull Duration duration2) {
            super(cls);
            this.f5070c.setPeriodic(duration.toMillis(), duration2.toMillis());
        }
    }
}
