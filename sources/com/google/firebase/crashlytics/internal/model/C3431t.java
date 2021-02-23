package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* renamed from: com.google.firebase.crashlytics.internal.model.t */
/* compiled from: AutoValue_CrashlyticsReport_Session_User */
final class C3431t extends CrashlyticsReport.Session.User {

    /* renamed from: a */
    private final String f19436a;

    /* renamed from: com.google.firebase.crashlytics.internal.model.t$b */
    /* compiled from: AutoValue_CrashlyticsReport_Session_User */
    static final class C3433b extends CrashlyticsReport.Session.User.Builder {

        /* renamed from: a */
        private String f19437a;

        C3433b() {
        }

        public CrashlyticsReport.Session.User build() {
            String str = "";
            if (this.f19437a == null) {
                str = str + " identifier";
            }
            if (str.isEmpty()) {
                return new C3431t(this.f19437a);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.User.Builder setIdentifier(String str) {
            if (str != null) {
                this.f19437a = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.User) {
            return this.f19436a.equals(((CrashlyticsReport.Session.User) obj).getIdentifier());
        }
        return false;
    }

    @NonNull
    public String getIdentifier() {
        return this.f19436a;
    }

    public int hashCode() {
        return this.f19436a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "User{identifier=" + this.f19436a + "}";
    }

    private C3431t(String str) {
        this.f19436a = str;
    }
}
