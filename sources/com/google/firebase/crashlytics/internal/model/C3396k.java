package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* renamed from: com.google.firebase.crashlytics.internal.model.k */
/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution */
final class C3396k extends CrashlyticsReport.Session.Event.Application.Execution {

    /* renamed from: a */
    private final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> f19358a;

    /* renamed from: b */
    private final CrashlyticsReport.Session.Event.Application.Execution.Exception f19359b;

    /* renamed from: c */
    private final CrashlyticsReport.Session.Event.Application.Execution.Signal f19360c;

    /* renamed from: d */
    private final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> f19361d;

    /* renamed from: com.google.firebase.crashlytics.internal.model.k$b */
    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution */
    static final class C3398b extends CrashlyticsReport.Session.Event.Application.Execution.Builder {

        /* renamed from: a */
        private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> f19362a;

        /* renamed from: b */
        private CrashlyticsReport.Session.Event.Application.Execution.Exception f19363b;

        /* renamed from: c */
        private CrashlyticsReport.Session.Event.Application.Execution.Signal f19364c;

        /* renamed from: d */
        private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> f19365d;

        C3398b() {
        }

        public CrashlyticsReport.Session.Event.Application.Execution build() {
            String str = "";
            if (this.f19362a == null) {
                str = str + " threads";
            }
            if (this.f19363b == null) {
                str = str + " exception";
            }
            if (this.f19364c == null) {
                str = str + " signal";
            }
            if (this.f19365d == null) {
                str = str + " binaries";
            }
            if (str.isEmpty()) {
                return new C3396k(this.f19362a, this.f19363b, this.f19364c, this.f19365d);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Builder setBinaries(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> immutableList) {
            if (immutableList != null) {
                this.f19365d = immutableList;
                return this;
            }
            throw new NullPointerException("Null binaries");
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Builder setException(CrashlyticsReport.Session.Event.Application.Execution.Exception exception) {
            if (exception != null) {
                this.f19363b = exception;
                return this;
            }
            throw new NullPointerException("Null exception");
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Builder setSignal(CrashlyticsReport.Session.Event.Application.Execution.Signal signal) {
            if (signal != null) {
                this.f19364c = signal;
                return this;
            }
            throw new NullPointerException("Null signal");
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Builder setThreads(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> immutableList) {
            if (immutableList != null) {
                this.f19362a = immutableList;
                return this;
            }
            throw new NullPointerException("Null threads");
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution execution = (CrashlyticsReport.Session.Event.Application.Execution) obj;
        if (!this.f19358a.equals(execution.getThreads()) || !this.f19359b.equals(execution.getException()) || !this.f19360c.equals(execution.getSignal()) || !this.f19361d.equals(execution.getBinaries())) {
            return false;
        }
        return true;
    }

    @NonNull
    public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> getBinaries() {
        return this.f19361d;
    }

    @NonNull
    public CrashlyticsReport.Session.Event.Application.Execution.Exception getException() {
        return this.f19359b;
    }

    @NonNull
    public CrashlyticsReport.Session.Event.Application.Execution.Signal getSignal() {
        return this.f19360c;
    }

    @NonNull
    public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> getThreads() {
        return this.f19358a;
    }

    public int hashCode() {
        return ((((((this.f19358a.hashCode() ^ 1000003) * 1000003) ^ this.f19359b.hashCode()) * 1000003) ^ this.f19360c.hashCode()) * 1000003) ^ this.f19361d.hashCode();
    }

    public String toString() {
        return "Execution{threads=" + this.f19358a + ", exception=" + this.f19359b + ", signal=" + this.f19360c + ", binaries=" + this.f19361d + "}";
    }

    private C3396k(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> immutableList, CrashlyticsReport.Session.Event.Application.Execution.Exception exception, CrashlyticsReport.Session.Event.Application.Execution.Signal signal, ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> immutableList2) {
        this.f19358a = immutableList;
        this.f19359b = exception;
        this.f19360c = signal;
        this.f19361d = immutableList2;
    }
}
