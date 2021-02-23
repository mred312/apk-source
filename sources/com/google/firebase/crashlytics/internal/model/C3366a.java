package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* renamed from: com.google.firebase.crashlytics.internal.model.a */
/* compiled from: AutoValue_CrashlyticsReport */
final class C3366a extends CrashlyticsReport {

    /* renamed from: b */
    private final String f19260b;

    /* renamed from: c */
    private final String f19261c;

    /* renamed from: d */
    private final int f19262d;

    /* renamed from: e */
    private final String f19263e;

    /* renamed from: f */
    private final String f19264f;

    /* renamed from: g */
    private final String f19265g;

    /* renamed from: h */
    private final CrashlyticsReport.Session f19266h;

    /* renamed from: i */
    private final CrashlyticsReport.FilesPayload f19267i;

    /* renamed from: com.google.firebase.crashlytics.internal.model.a$b */
    /* compiled from: AutoValue_CrashlyticsReport */
    static final class C3368b extends CrashlyticsReport.Builder {

        /* renamed from: a */
        private String f19268a;

        /* renamed from: b */
        private String f19269b;

        /* renamed from: c */
        private Integer f19270c;

        /* renamed from: d */
        private String f19271d;

        /* renamed from: e */
        private String f19272e;

        /* renamed from: f */
        private String f19273f;

        /* renamed from: g */
        private CrashlyticsReport.Session f19274g;

        /* renamed from: h */
        private CrashlyticsReport.FilesPayload f19275h;

        public CrashlyticsReport build() {
            String str = "";
            if (this.f19268a == null) {
                str = str + " sdkVersion";
            }
            if (this.f19269b == null) {
                str = str + " gmpAppId";
            }
            if (this.f19270c == null) {
                str = str + " platform";
            }
            if (this.f19271d == null) {
                str = str + " installationUuid";
            }
            if (this.f19272e == null) {
                str = str + " buildVersion";
            }
            if (this.f19273f == null) {
                str = str + " displayVersion";
            }
            if (str.isEmpty()) {
                return new C3366a(this.f19268a, this.f19269b, this.f19270c.intValue(), this.f19271d, this.f19272e, this.f19273f, this.f19274g, this.f19275h);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Builder setBuildVersion(String str) {
            if (str != null) {
                this.f19272e = str;
                return this;
            }
            throw new NullPointerException("Null buildVersion");
        }

        public CrashlyticsReport.Builder setDisplayVersion(String str) {
            if (str != null) {
                this.f19273f = str;
                return this;
            }
            throw new NullPointerException("Null displayVersion");
        }

        public CrashlyticsReport.Builder setGmpAppId(String str) {
            if (str != null) {
                this.f19269b = str;
                return this;
            }
            throw new NullPointerException("Null gmpAppId");
        }

        public CrashlyticsReport.Builder setInstallationUuid(String str) {
            if (str != null) {
                this.f19271d = str;
                return this;
            }
            throw new NullPointerException("Null installationUuid");
        }

        public CrashlyticsReport.Builder setNdkPayload(CrashlyticsReport.FilesPayload filesPayload) {
            this.f19275h = filesPayload;
            return this;
        }

        public CrashlyticsReport.Builder setPlatform(int i) {
            this.f19270c = Integer.valueOf(i);
            return this;
        }

        public CrashlyticsReport.Builder setSdkVersion(String str) {
            if (str != null) {
                this.f19268a = str;
                return this;
            }
            throw new NullPointerException("Null sdkVersion");
        }

        public CrashlyticsReport.Builder setSession(CrashlyticsReport.Session session) {
            this.f19274g = session;
            return this;
        }

        C3368b() {
        }

        private C3368b(CrashlyticsReport crashlyticsReport) {
            this.f19268a = crashlyticsReport.getSdkVersion();
            this.f19269b = crashlyticsReport.getGmpAppId();
            this.f19270c = Integer.valueOf(crashlyticsReport.getPlatform());
            this.f19271d = crashlyticsReport.getInstallationUuid();
            this.f19272e = crashlyticsReport.getBuildVersion();
            this.f19273f = crashlyticsReport.getDisplayVersion();
            this.f19274g = crashlyticsReport.getSession();
            this.f19275h = crashlyticsReport.getNdkPayload();
        }
    }

    public boolean equals(Object obj) {
        CrashlyticsReport.Session session;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport)) {
            return false;
        }
        CrashlyticsReport crashlyticsReport = (CrashlyticsReport) obj;
        if (this.f19260b.equals(crashlyticsReport.getSdkVersion()) && this.f19261c.equals(crashlyticsReport.getGmpAppId()) && this.f19262d == crashlyticsReport.getPlatform() && this.f19263e.equals(crashlyticsReport.getInstallationUuid()) && this.f19264f.equals(crashlyticsReport.getBuildVersion()) && this.f19265g.equals(crashlyticsReport.getDisplayVersion()) && ((session = this.f19266h) != null ? session.equals(crashlyticsReport.getSession()) : crashlyticsReport.getSession() == null)) {
            CrashlyticsReport.FilesPayload filesPayload = this.f19267i;
            if (filesPayload == null) {
                if (crashlyticsReport.getNdkPayload() == null) {
                    return true;
                }
            } else if (filesPayload.equals(crashlyticsReport.getNdkPayload())) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public String getBuildVersion() {
        return this.f19264f;
    }

    @NonNull
    public String getDisplayVersion() {
        return this.f19265g;
    }

    @NonNull
    public String getGmpAppId() {
        return this.f19261c;
    }

    @NonNull
    public String getInstallationUuid() {
        return this.f19263e;
    }

    @Nullable
    public CrashlyticsReport.FilesPayload getNdkPayload() {
        return this.f19267i;
    }

    public int getPlatform() {
        return this.f19262d;
    }

    @NonNull
    public String getSdkVersion() {
        return this.f19260b;
    }

    @Nullable
    public CrashlyticsReport.Session getSession() {
        return this.f19266h;
    }

    public int hashCode() {
        int hashCode = (((((((((((this.f19260b.hashCode() ^ 1000003) * 1000003) ^ this.f19261c.hashCode()) * 1000003) ^ this.f19262d) * 1000003) ^ this.f19263e.hashCode()) * 1000003) ^ this.f19264f.hashCode()) * 1000003) ^ this.f19265g.hashCode()) * 1000003;
        CrashlyticsReport.Session session = this.f19266h;
        int i = 0;
        int hashCode2 = (hashCode ^ (session == null ? 0 : session.hashCode())) * 1000003;
        CrashlyticsReport.FilesPayload filesPayload = this.f19267i;
        if (filesPayload != null) {
            i = filesPayload.hashCode();
        }
        return hashCode2 ^ i;
    }

    /* access modifiers changed from: protected */
    public CrashlyticsReport.Builder toBuilder() {
        return new C3368b(this);
    }

    public String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.f19260b + ", gmpAppId=" + this.f19261c + ", platform=" + this.f19262d + ", installationUuid=" + this.f19263e + ", buildVersion=" + this.f19264f + ", displayVersion=" + this.f19265g + ", session=" + this.f19266h + ", ndkPayload=" + this.f19267i + "}";
    }

    private C3366a(String str, String str2, int i, String str3, String str4, String str5, @Nullable CrashlyticsReport.Session session, @Nullable CrashlyticsReport.FilesPayload filesPayload) {
        this.f19260b = str;
        this.f19261c = str2;
        this.f19262d = i;
        this.f19263e = str3;
        this.f19264f = str4;
        this.f19265g = str5;
        this.f19266h = session;
        this.f19267i = filesPayload;
    }
}
