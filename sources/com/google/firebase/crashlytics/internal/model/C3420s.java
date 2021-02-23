package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* renamed from: com.google.firebase.crashlytics.internal.model.s */
/* compiled from: AutoValue_CrashlyticsReport_Session_OperatingSystem */
final class C3420s extends CrashlyticsReport.Session.OperatingSystem {

    /* renamed from: a */
    private final int f19420a;

    /* renamed from: b */
    private final String f19421b;

    /* renamed from: c */
    private final String f19422c;

    /* renamed from: d */
    private final boolean f19423d;

    /* renamed from: com.google.firebase.crashlytics.internal.model.s$b */
    /* compiled from: AutoValue_CrashlyticsReport_Session_OperatingSystem */
    static final class C3422b extends CrashlyticsReport.Session.OperatingSystem.Builder {

        /* renamed from: a */
        private Integer f19424a;

        /* renamed from: b */
        private String f19425b;

        /* renamed from: c */
        private String f19426c;

        /* renamed from: d */
        private Boolean f19427d;

        C3422b() {
        }

        public CrashlyticsReport.Session.OperatingSystem build() {
            String str = "";
            if (this.f19424a == null) {
                str = str + " platform";
            }
            if (this.f19425b == null) {
                str = str + " version";
            }
            if (this.f19426c == null) {
                str = str + " buildVersion";
            }
            if (this.f19427d == null) {
                str = str + " jailbroken";
            }
            if (str.isEmpty()) {
                return new C3420s(this.f19424a.intValue(), this.f19425b, this.f19426c, this.f19427d.booleanValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.OperatingSystem.Builder setBuildVersion(String str) {
            if (str != null) {
                this.f19426c = str;
                return this;
            }
            throw new NullPointerException("Null buildVersion");
        }

        public CrashlyticsReport.Session.OperatingSystem.Builder setJailbroken(boolean z) {
            this.f19427d = Boolean.valueOf(z);
            return this;
        }

        public CrashlyticsReport.Session.OperatingSystem.Builder setPlatform(int i) {
            this.f19424a = Integer.valueOf(i);
            return this;
        }

        public CrashlyticsReport.Session.OperatingSystem.Builder setVersion(String str) {
            if (str != null) {
                this.f19425b = str;
                return this;
            }
            throw new NullPointerException("Null version");
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.OperatingSystem)) {
            return false;
        }
        CrashlyticsReport.Session.OperatingSystem operatingSystem = (CrashlyticsReport.Session.OperatingSystem) obj;
        if (this.f19420a != operatingSystem.getPlatform() || !this.f19421b.equals(operatingSystem.getVersion()) || !this.f19422c.equals(operatingSystem.getBuildVersion()) || this.f19423d != operatingSystem.isJailbroken()) {
            return false;
        }
        return true;
    }

    @NonNull
    public String getBuildVersion() {
        return this.f19422c;
    }

    public int getPlatform() {
        return this.f19420a;
    }

    @NonNull
    public String getVersion() {
        return this.f19421b;
    }

    public int hashCode() {
        return ((((((this.f19420a ^ 1000003) * 1000003) ^ this.f19421b.hashCode()) * 1000003) ^ this.f19422c.hashCode()) * 1000003) ^ (this.f19423d ? 1231 : 1237);
    }

    public boolean isJailbroken() {
        return this.f19423d;
    }

    public String toString() {
        return "OperatingSystem{platform=" + this.f19420a + ", version=" + this.f19421b + ", buildVersion=" + this.f19422c + ", jailbroken=" + this.f19423d + "}";
    }

    private C3420s(int i, String str, String str2, boolean z) {
        this.f19420a = i;
        this.f19421b = str;
        this.f19422c = str2;
        this.f19423d = z;
    }
}
