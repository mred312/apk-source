package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import androidx.annotation.RequiresApi;
import androidx.work.WorkRequest;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C1611c;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.auto.value.AutoValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@AutoValue
public abstract class SchedulerConfig {

    public static class Builder {

        /* renamed from: a */
        private Clock f7285a;

        /* renamed from: b */
        private Map<Priority, ConfigValue> f7286b = new HashMap();

        public Builder addConfig(Priority priority, ConfigValue configValue) {
            this.f7286b.put(priority, configValue);
            return this;
        }

        public SchedulerConfig build() {
            if (this.f7285a == null) {
                throw new NullPointerException("missing required property: clock");
            } else if (this.f7286b.keySet().size() >= Priority.values().length) {
                Map<Priority, ConfigValue> map = this.f7286b;
                this.f7286b = new HashMap();
                return SchedulerConfig.m5090b(this.f7285a, map);
            } else {
                throw new IllegalStateException("Not all priorities have been configured");
            }
        }

        public Builder setClock(Clock clock) {
            this.f7285a = clock;
            return this;
        }
    }

    @AutoValue
    public static abstract class ConfigValue {

        @AutoValue.Builder
        public static abstract class Builder {
            public abstract ConfigValue build();

            public abstract Builder setDelta(long j);

            public abstract Builder setFlags(Set<Flag> set);

            public abstract Builder setMaxAllowedDelay(long j);
        }

        public static Builder builder() {
            C1611c.C1613b bVar = new C1611c.C1613b();
            bVar.setFlags(Collections.emptySet());
            return bVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract long mo11475a();

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract Set<Flag> mo11476b();

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public abstract long mo11477c();
    }

    public enum Flag {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    /* renamed from: a */
    private long m5089a(int i, long j) {
        int i2 = i - 1;
        double max = Math.max(1.0d, Math.log(10000.0d) / Math.log((double) ((j > 1 ? j : 2) * ((long) i2))));
        double pow = Math.pow(3.0d, (double) i2);
        double d = (double) j;
        Double.isNaN(d);
        return (long) (pow * d * max);
    }

    /* renamed from: b */
    static SchedulerConfig m5090b(Clock clock, Map<Priority, ConfigValue> map) {
        return new C1610b(clock, map);
    }

    public static Builder builder() {
        return new Builder();
    }

    /* renamed from: e */
    private static <T> Set<T> m5091e(T... tArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(tArr)));
    }

    @RequiresApi(api = 21)
    /* renamed from: f */
    private void m5092f(JobInfo.Builder builder, Set<Flag> set) {
        if (set.contains(Flag.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(Flag.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(Flag.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }

    public static SchedulerConfig getDefault(Clock clock) {
        return builder().addConfig(Priority.DEFAULT, ConfigValue.builder().setDelta(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).setMaxAllowedDelay(86400000).build()).addConfig(Priority.HIGHEST, ConfigValue.builder().setDelta(1000).setMaxAllowedDelay(86400000).build()).addConfig(Priority.VERY_LOW, ConfigValue.builder().setDelta(86400000).setMaxAllowedDelay(86400000).setFlags(m5091e(Flag.NETWORK_UNMETERED, Flag.DEVICE_IDLE)).build()).setClock(clock).build();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract Clock mo11467c();

    @RequiresApi(api = 21)
    public JobInfo.Builder configureJob(JobInfo.Builder builder, Priority priority, long j, int i) {
        builder.setMinimumLatency(getScheduleDelay(priority, j, i));
        m5092f(builder, mo11469d().get(priority).mo11476b());
        return builder;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract Map<Priority, ConfigValue> mo11469d();

    public Set<Flag> getFlags(Priority priority) {
        return mo11469d().get(priority).mo11476b();
    }

    public long getScheduleDelay(Priority priority, long j, int i) {
        long time = j - mo11467c().getTime();
        ConfigValue configValue = mo11469d().get(priority);
        return Math.min(Math.max(m5089a(i, configValue.mo11475a()), time), configValue.mo11477c());
    }
}
