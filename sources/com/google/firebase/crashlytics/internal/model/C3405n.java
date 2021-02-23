package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* renamed from: com.google.firebase.crashlytics.internal.model.n */
/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal */
final class C3405n extends CrashlyticsReport.Session.Event.Application.Execution.Signal {

    /* renamed from: a */
    private final String f19384a;

    /* renamed from: b */
    private final String f19385b;

    /* renamed from: c */
    private final long f19386c;

    /* renamed from: com.google.firebase.crashlytics.internal.model.n$b */
    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal */
    static final class C3407b extends CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder {

        /* renamed from: a */
        private String f19387a;

        /* renamed from: b */
        private String f19388b;

        /* renamed from: c */
        private Long f19389c;

        C3407b() {
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Signal build() {
            String str = "";
            if (this.f19387a == null) {
                str = str + " name";
            }
            if (this.f19388b == null) {
                str = str + " code";
            }
            if (this.f19389c == null) {
                str = str + " address";
            }
            if (str.isEmpty()) {
                return new C3405n(this.f19387a, this.f19388b, this.f19389c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder setAddress(long j) {
            this.f19389c = Long.valueOf(j);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder setCode(String str) {
            if (str != null) {
                this.f19388b = str;
                return this;
            }
            throw new NullPointerException("Null code");
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder setName(String str) {
            if (str != null) {
                this.f19387a = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Signal)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Signal signal = (CrashlyticsReport.Session.Event.Application.Execution.Signal) obj;
        if (!this.f19384a.equals(signal.getName()) || !this.f19385b.equals(signal.getCode()) || this.f19386c != signal.getAddress()) {
            return false;
        }
        return true;
    }

    @NonNull
    public long getAddress() {
        return this.f19386c;
    }

    @NonNull
    public String getCode() {
        return this.f19385b;
    }

    @NonNull
    public String getName() {
        return this.f19384a;
    }

    public int hashCode() {
        long j = this.f19386c;
        return ((((this.f19384a.hashCode() ^ 1000003) * 1000003) ^ this.f19385b.hashCode()) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "Signal{name=" + this.f19384a + ", code=" + this.f19385b + ", address=" + this.f19386c + "}";
    }

    private C3405n(String str, String str2, long j) {
        this.f19384a = str;
        this.f19385b = str2;
        this.f19386c = j;
    }
}
