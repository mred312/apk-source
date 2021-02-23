package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* renamed from: com.google.firebase.crashlytics.internal.model.c */
/* compiled from: AutoValue_CrashlyticsReport_FilesPayload */
final class C3372c extends CrashlyticsReport.FilesPayload {

    /* renamed from: a */
    private final ImmutableList<CrashlyticsReport.FilesPayload.File> f19280a;

    /* renamed from: b */
    private final String f19281b;

    /* renamed from: com.google.firebase.crashlytics.internal.model.c$b */
    /* compiled from: AutoValue_CrashlyticsReport_FilesPayload */
    static final class C3374b extends CrashlyticsReport.FilesPayload.Builder {

        /* renamed from: a */
        private ImmutableList<CrashlyticsReport.FilesPayload.File> f19282a;

        /* renamed from: b */
        private String f19283b;

        public CrashlyticsReport.FilesPayload build() {
            String str = "";
            if (this.f19282a == null) {
                str = str + " files";
            }
            if (str.isEmpty()) {
                return new C3372c(this.f19282a, this.f19283b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.FilesPayload.Builder setFiles(ImmutableList<CrashlyticsReport.FilesPayload.File> immutableList) {
            if (immutableList != null) {
                this.f19282a = immutableList;
                return this;
            }
            throw new NullPointerException("Null files");
        }

        public CrashlyticsReport.FilesPayload.Builder setOrgId(String str) {
            this.f19283b = str;
            return this;
        }

        C3374b() {
        }

        private C3374b(CrashlyticsReport.FilesPayload filesPayload) {
            this.f19282a = filesPayload.getFiles();
            this.f19283b = filesPayload.getOrgId();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public CrashlyticsReport.FilesPayload.Builder mo21121a() {
        return new C3374b(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.FilesPayload)) {
            return false;
        }
        CrashlyticsReport.FilesPayload filesPayload = (CrashlyticsReport.FilesPayload) obj;
        if (this.f19280a.equals(filesPayload.getFiles())) {
            String str = this.f19281b;
            if (str == null) {
                if (filesPayload.getOrgId() == null) {
                    return true;
                }
            } else if (str.equals(filesPayload.getOrgId())) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public ImmutableList<CrashlyticsReport.FilesPayload.File> getFiles() {
        return this.f19280a;
    }

    @Nullable
    public String getOrgId() {
        return this.f19281b;
    }

    public int hashCode() {
        int hashCode = (this.f19280a.hashCode() ^ 1000003) * 1000003;
        String str = this.f19281b;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FilesPayload{files=" + this.f19280a + ", orgId=" + this.f19281b + "}";
    }

    private C3372c(ImmutableList<CrashlyticsReport.FilesPayload.File> immutableList, @Nullable String str) {
        this.f19280a = immutableList;
        this.f19281b = str;
    }
}
