package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* renamed from: com.google.firebase.crashlytics.internal.model.g */
/* compiled from: AutoValue_CrashlyticsReport_Session_Application_Organization */
final class C3384g extends CrashlyticsReport.Session.Application.Organization {

    /* renamed from: a */
    private final String f19320a;

    /* renamed from: com.google.firebase.crashlytics.internal.model.g$b */
    /* compiled from: AutoValue_CrashlyticsReport_Session_Application_Organization */
    static final class C3386b extends CrashlyticsReport.Session.Application.Organization.Builder {

        /* renamed from: a */
        private String f19321a;

        public CrashlyticsReport.Session.Application.Organization build() {
            String str = "";
            if (this.f19321a == null) {
                str = str + " clsId";
            }
            if (str.isEmpty()) {
                return new C3384g(this.f19321a);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Application.Organization.Builder setClsId(String str) {
            if (str != null) {
                this.f19321a = str;
                return this;
            }
            throw new NullPointerException("Null clsId");
        }

        C3386b() {
        }

        private C3386b(CrashlyticsReport.Session.Application.Organization organization) {
            this.f19321a = organization.getClsId();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Application.Organization) {
            return this.f19320a.equals(((CrashlyticsReport.Session.Application.Organization) obj).getClsId());
        }
        return false;
    }

    @NonNull
    public String getClsId() {
        return this.f19320a;
    }

    public int hashCode() {
        return this.f19320a.hashCode() ^ 1000003;
    }

    /* access modifiers changed from: protected */
    public CrashlyticsReport.Session.Application.Organization.Builder toBuilder() {
        return new C3386b(this);
    }

    public String toString() {
        return "Organization{clsId=" + this.f19320a + "}";
    }

    private C3384g(String str) {
        this.f19320a = str;
    }
}
