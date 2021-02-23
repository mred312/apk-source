package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* renamed from: com.google.firebase.crashlytics.internal.model.r */
/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Log */
final class C3417r extends CrashlyticsReport.Session.Event.Log {

    /* renamed from: a */
    private final String f19418a;

    /* renamed from: com.google.firebase.crashlytics.internal.model.r$b */
    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_Log */
    static final class C3419b extends CrashlyticsReport.Session.Event.Log.Builder {

        /* renamed from: a */
        private String f19419a;

        C3419b() {
        }

        public CrashlyticsReport.Session.Event.Log build() {
            String str = "";
            if (this.f19419a == null) {
                str = str + " content";
            }
            if (str.isEmpty()) {
                return new C3417r(this.f19419a);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Event.Log.Builder setContent(String str) {
            if (str != null) {
                this.f19419a = str;
                return this;
            }
            throw new NullPointerException("Null content");
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Event.Log) {
            return this.f19418a.equals(((CrashlyticsReport.Session.Event.Log) obj).getContent());
        }
        return false;
    }

    @NonNull
    public String getContent() {
        return this.f19418a;
    }

    public int hashCode() {
        return this.f19418a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Log{content=" + this.f19418a + "}";
    }

    private C3417r(String str) {
        this.f19418a = str;
    }
}
