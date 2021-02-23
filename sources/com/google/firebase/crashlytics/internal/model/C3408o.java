package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* renamed from: com.google.firebase.crashlytics.internal.model.o */
/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread */
final class C3408o extends CrashlyticsReport.Session.Event.Application.Execution.Thread {

    /* renamed from: a */
    private final String f19390a;

    /* renamed from: b */
    private final int f19391b;

    /* renamed from: c */
    private final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> f19392c;

    /* renamed from: com.google.firebase.crashlytics.internal.model.o$b */
    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread */
    static final class C3410b extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder {

        /* renamed from: a */
        private String f19393a;

        /* renamed from: b */
        private Integer f19394b;

        /* renamed from: c */
        private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> f19395c;

        C3410b() {
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread build() {
            String str = "";
            if (this.f19393a == null) {
                str = str + " name";
            }
            if (this.f19394b == null) {
                str = str + " importance";
            }
            if (this.f19395c == null) {
                str = str + " frames";
            }
            if (str.isEmpty()) {
                return new C3408o(this.f19393a, this.f19394b.intValue(), this.f19395c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder setFrames(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> immutableList) {
            if (immutableList != null) {
                this.f19395c = immutableList;
                return this;
            }
            throw new NullPointerException("Null frames");
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder setImportance(int i) {
            this.f19394b = Integer.valueOf(i);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder setName(String str) {
            if (str != null) {
                this.f19393a = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Thread)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Thread thread = (CrashlyticsReport.Session.Event.Application.Execution.Thread) obj;
        if (!this.f19390a.equals(thread.getName()) || this.f19391b != thread.getImportance() || !this.f19392c.equals(thread.getFrames())) {
            return false;
        }
        return true;
    }

    @NonNull
    public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> getFrames() {
        return this.f19392c;
    }

    public int getImportance() {
        return this.f19391b;
    }

    @NonNull
    public String getName() {
        return this.f19390a;
    }

    public int hashCode() {
        return ((((this.f19390a.hashCode() ^ 1000003) * 1000003) ^ this.f19391b) * 1000003) ^ this.f19392c.hashCode();
    }

    public String toString() {
        return "Thread{name=" + this.f19390a + ", importance=" + this.f19391b + ", frames=" + this.f19392c + "}";
    }

    private C3408o(String str, int i, ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> immutableList) {
        this.f19390a = str;
        this.f19391b = i;
        this.f19392c = immutableList;
    }
}
