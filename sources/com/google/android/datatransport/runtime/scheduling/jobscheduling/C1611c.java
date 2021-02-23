package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Set;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.c */
/* compiled from: AutoValue_SchedulerConfig_ConfigValue */
final class C1611c extends SchedulerConfig.ConfigValue {

    /* renamed from: a */
    private final long f7313a;

    /* renamed from: b */
    private final long f7314b;

    /* renamed from: c */
    private final Set<SchedulerConfig.Flag> f7315c;

    /* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.c$b */
    /* compiled from: AutoValue_SchedulerConfig_ConfigValue */
    static final class C1613b extends SchedulerConfig.ConfigValue.Builder {

        /* renamed from: a */
        private Long f7316a;

        /* renamed from: b */
        private Long f7317b;

        /* renamed from: c */
        private Set<SchedulerConfig.Flag> f7318c;

        C1613b() {
        }

        public SchedulerConfig.ConfigValue build() {
            String str = "";
            if (this.f7316a == null) {
                str = str + " delta";
            }
            if (this.f7317b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f7318c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new C1611c(this.f7316a.longValue(), this.f7317b.longValue(), this.f7318c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public SchedulerConfig.ConfigValue.Builder setDelta(long j) {
            this.f7316a = Long.valueOf(j);
            return this;
        }

        public SchedulerConfig.ConfigValue.Builder setFlags(Set<SchedulerConfig.Flag> set) {
            if (set != null) {
                this.f7318c = set;
                return this;
            }
            throw new NullPointerException("Null flags");
        }

        public SchedulerConfig.ConfigValue.Builder setMaxAllowedDelay(long j) {
            this.f7317b = Long.valueOf(j);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo11475a() {
        return this.f7313a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Set<SchedulerConfig.Flag> mo11476b() {
        return this.f7315c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public long mo11477c() {
        return this.f7314b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig.ConfigValue)) {
            return false;
        }
        SchedulerConfig.ConfigValue configValue = (SchedulerConfig.ConfigValue) obj;
        if (this.f7313a == configValue.mo11475a() && this.f7314b == configValue.mo11477c() && this.f7315c.equals(configValue.mo11476b())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.f7313a;
        long j2 = this.f7314b;
        return this.f7315c.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f7313a + ", maxAllowedDelay=" + this.f7314b + ", flags=" + this.f7315c + "}";
    }

    private C1611c(long j, long j2, Set<SchedulerConfig.Flag> set) {
        this.f7313a = j;
        this.f7314b = j2;
        this.f7315c = set;
    }
}
