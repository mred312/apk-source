package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* renamed from: com.google.firebase.crashlytics.internal.model.f */
/* compiled from: AutoValue_CrashlyticsReport_Session_Application */
final class C3381f extends CrashlyticsReport.Session.Application {

    /* renamed from: a */
    private final String f19310a;

    /* renamed from: b */
    private final String f19311b;

    /* renamed from: c */
    private final String f19312c;

    /* renamed from: d */
    private final CrashlyticsReport.Session.Application.Organization f19313d;

    /* renamed from: e */
    private final String f19314e;

    /* renamed from: com.google.firebase.crashlytics.internal.model.f$b */
    /* compiled from: AutoValue_CrashlyticsReport_Session_Application */
    static final class C3383b extends CrashlyticsReport.Session.Application.Builder {

        /* renamed from: a */
        private String f19315a;

        /* renamed from: b */
        private String f19316b;

        /* renamed from: c */
        private String f19317c;

        /* renamed from: d */
        private CrashlyticsReport.Session.Application.Organization f19318d;

        /* renamed from: e */
        private String f19319e;

        public CrashlyticsReport.Session.Application build() {
            String str = "";
            if (this.f19315a == null) {
                str = str + " identifier";
            }
            if (this.f19316b == null) {
                str = str + " version";
            }
            if (str.isEmpty()) {
                return new C3381f(this.f19315a, this.f19316b, this.f19317c, this.f19318d, this.f19319e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Application.Builder setDisplayVersion(String str) {
            this.f19317c = str;
            return this;
        }

        public CrashlyticsReport.Session.Application.Builder setIdentifier(String str) {
            if (str != null) {
                this.f19315a = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }

        public CrashlyticsReport.Session.Application.Builder setInstallationUuid(String str) {
            this.f19319e = str;
            return this;
        }

        public CrashlyticsReport.Session.Application.Builder setOrganization(CrashlyticsReport.Session.Application.Organization organization) {
            this.f19318d = organization;
            return this;
        }

        public CrashlyticsReport.Session.Application.Builder setVersion(String str) {
            if (str != null) {
                this.f19316b = str;
                return this;
            }
            throw new NullPointerException("Null version");
        }

        C3383b() {
        }

        private C3383b(CrashlyticsReport.Session.Application application) {
            this.f19315a = application.getIdentifier();
            this.f19316b = application.getVersion();
            this.f19317c = application.getDisplayVersion();
            this.f19318d = application.getOrganization();
            this.f19319e = application.getInstallationUuid();
        }
    }

    public boolean equals(Object obj) {
        String str;
        CrashlyticsReport.Session.Application.Organization organization;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Application)) {
            return false;
        }
        CrashlyticsReport.Session.Application application = (CrashlyticsReport.Session.Application) obj;
        if (this.f19310a.equals(application.getIdentifier()) && this.f19311b.equals(application.getVersion()) && ((str = this.f19312c) != null ? str.equals(application.getDisplayVersion()) : application.getDisplayVersion() == null) && ((organization = this.f19313d) != null ? organization.equals(application.getOrganization()) : application.getOrganization() == null)) {
            String str2 = this.f19314e;
            if (str2 == null) {
                if (application.getInstallationUuid() == null) {
                    return true;
                }
            } else if (str2.equals(application.getInstallationUuid())) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public String getDisplayVersion() {
        return this.f19312c;
    }

    @NonNull
    public String getIdentifier() {
        return this.f19310a;
    }

    @Nullable
    public String getInstallationUuid() {
        return this.f19314e;
    }

    @Nullable
    public CrashlyticsReport.Session.Application.Organization getOrganization() {
        return this.f19313d;
    }

    @NonNull
    public String getVersion() {
        return this.f19311b;
    }

    public int hashCode() {
        int hashCode = (((this.f19310a.hashCode() ^ 1000003) * 1000003) ^ this.f19311b.hashCode()) * 1000003;
        String str = this.f19312c;
        int i = 0;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        CrashlyticsReport.Session.Application.Organization organization = this.f19313d;
        int hashCode3 = (hashCode2 ^ (organization == null ? 0 : organization.hashCode())) * 1000003;
        String str2 = this.f19314e;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode3 ^ i;
    }

    /* access modifiers changed from: protected */
    public CrashlyticsReport.Session.Application.Builder toBuilder() {
        return new C3383b(this);
    }

    public String toString() {
        return "Application{identifier=" + this.f19310a + ", version=" + this.f19311b + ", displayVersion=" + this.f19312c + ", organization=" + this.f19313d + ", installationUuid=" + this.f19314e + "}";
    }

    private C3381f(String str, String str2, @Nullable String str3, @Nullable CrashlyticsReport.Session.Application.Organization organization, @Nullable String str4) {
        this.f19310a = str;
        this.f19311b = str2;
        this.f19312c = str3;
        this.f19313d = organization;
        this.f19314e = str4;
    }
}
