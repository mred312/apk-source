package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* renamed from: com.google.firebase.crashlytics.internal.model.m */
/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception */
final class C3402m extends CrashlyticsReport.Session.Event.Application.Execution.Exception {

    /* renamed from: a */
    private final String f19374a;

    /* renamed from: b */
    private final String f19375b;

    /* renamed from: c */
    private final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> f19376c;

    /* renamed from: d */
    private final CrashlyticsReport.Session.Event.Application.Execution.Exception f19377d;

    /* renamed from: e */
    private final int f19378e;

    /* renamed from: com.google.firebase.crashlytics.internal.model.m$b */
    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception */
    static final class C3404b extends CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder {

        /* renamed from: a */
        private String f19379a;

        /* renamed from: b */
        private String f19380b;

        /* renamed from: c */
        private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> f19381c;

        /* renamed from: d */
        private CrashlyticsReport.Session.Event.Application.Execution.Exception f19382d;

        /* renamed from: e */
        private Integer f19383e;

        C3404b() {
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Exception build() {
            String str = "";
            if (this.f19379a == null) {
                str = str + " type";
            }
            if (this.f19381c == null) {
                str = str + " frames";
            }
            if (this.f19383e == null) {
                str = str + " overflowCount";
            }
            if (str.isEmpty()) {
                return new C3402m(this.f19379a, this.f19380b, this.f19381c, this.f19382d, this.f19383e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setCausedBy(CrashlyticsReport.Session.Event.Application.Execution.Exception exception) {
            this.f19382d = exception;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setFrames(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> immutableList) {
            if (immutableList != null) {
                this.f19381c = immutableList;
                return this;
            }
            throw new NullPointerException("Null frames");
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setOverflowCount(int i) {
            this.f19383e = Integer.valueOf(i);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setReason(String str) {
            this.f19380b = str;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setType(String str) {
            if (str != null) {
                this.f19379a = str;
                return this;
            }
            throw new NullPointerException("Null type");
        }
    }

    public boolean equals(Object obj) {
        String str;
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Exception)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception2 = (CrashlyticsReport.Session.Event.Application.Execution.Exception) obj;
        if (!this.f19374a.equals(exception2.getType()) || ((str = this.f19375b) != null ? !str.equals(exception2.getReason()) : exception2.getReason() != null) || !this.f19376c.equals(exception2.getFrames()) || ((exception = this.f19377d) != null ? !exception.equals(exception2.getCausedBy()) : exception2.getCausedBy() != null) || this.f19378e != exception2.getOverflowCount()) {
            return false;
        }
        return true;
    }

    @Nullable
    public CrashlyticsReport.Session.Event.Application.Execution.Exception getCausedBy() {
        return this.f19377d;
    }

    @NonNull
    public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> getFrames() {
        return this.f19376c;
    }

    public int getOverflowCount() {
        return this.f19378e;
    }

    @Nullable
    public String getReason() {
        return this.f19375b;
    }

    @NonNull
    public String getType() {
        return this.f19374a;
    }

    public int hashCode() {
        int hashCode = (this.f19374a.hashCode() ^ 1000003) * 1000003;
        String str = this.f19375b;
        int i = 0;
        int hashCode2 = (((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f19376c.hashCode()) * 1000003;
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception = this.f19377d;
        if (exception != null) {
            i = exception.hashCode();
        }
        return ((hashCode2 ^ i) * 1000003) ^ this.f19378e;
    }

    public String toString() {
        return "Exception{type=" + this.f19374a + ", reason=" + this.f19375b + ", frames=" + this.f19376c + ", causedBy=" + this.f19377d + ", overflowCount=" + this.f19378e + "}";
    }

    private C3402m(String str, @Nullable String str2, ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> immutableList, @Nullable CrashlyticsReport.Session.Event.Application.Execution.Exception exception, int i) {
        this.f19374a = str;
        this.f19375b = str2;
        this.f19376c = immutableList;
        this.f19377d = exception;
        this.f19378e = i;
    }
}
