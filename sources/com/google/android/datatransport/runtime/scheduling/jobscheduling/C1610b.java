package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.Map;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.b */
/* compiled from: AutoValue_SchedulerConfig */
final class C1610b extends SchedulerConfig {

    /* renamed from: a */
    private final Clock f7311a;

    /* renamed from: b */
    private final Map<Priority, SchedulerConfig.ConfigValue> f7312b;

    C1610b(Clock clock, Map<Priority, SchedulerConfig.ConfigValue> map) {
        if (clock != null) {
            this.f7311a = clock;
            if (map != null) {
                this.f7312b = map;
                return;
            }
            throw new NullPointerException("Null values");
        }
        throw new NullPointerException("Null clock");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Clock mo11467c() {
        return this.f7311a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public Map<Priority, SchedulerConfig.ConfigValue> mo11469d() {
        return this.f7312b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig)) {
            return false;
        }
        SchedulerConfig schedulerConfig = (SchedulerConfig) obj;
        if (!this.f7311a.equals(schedulerConfig.mo11467c()) || !this.f7312b.equals(schedulerConfig.mo11469d())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f7311a.hashCode() ^ 1000003) * 1000003) ^ this.f7312b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f7311a + ", values=" + this.f7312b + "}";
    }
}
