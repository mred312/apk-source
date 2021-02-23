package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* renamed from: com.google.firebase.crashlytics.internal.common.b */
/* compiled from: AutoValue_CrashlyticsReportWithSessionId */
final class C3277b extends CrashlyticsReportWithSessionId {

    /* renamed from: a */
    private final CrashlyticsReport f19072a;

    /* renamed from: b */
    private final String f19073b;

    C3277b(CrashlyticsReport crashlyticsReport, String str) {
        if (crashlyticsReport != null) {
            this.f19072a = crashlyticsReport;
            if (str != null) {
                this.f19073b = str;
                return;
            }
            throw new NullPointerException("Null sessionId");
        }
        throw new NullPointerException("Null report");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReportWithSessionId)) {
            return false;
        }
        CrashlyticsReportWithSessionId crashlyticsReportWithSessionId = (CrashlyticsReportWithSessionId) obj;
        if (!this.f19072a.equals(crashlyticsReportWithSessionId.getReport()) || !this.f19073b.equals(crashlyticsReportWithSessionId.getSessionId())) {
            return false;
        }
        return true;
    }

    public CrashlyticsReport getReport() {
        return this.f19072a;
    }

    public String getSessionId() {
        return this.f19073b;
    }

    public int hashCode() {
        return ((this.f19072a.hashCode() ^ 1000003) * 1000003) ^ this.f19073b.hashCode();
    }

    public String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.f19072a + ", sessionId=" + this.f19073b + "}";
    }
}
