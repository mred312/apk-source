package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Arrays;

/* renamed from: com.google.firebase.crashlytics.internal.model.d */
/* compiled from: AutoValue_CrashlyticsReport_FilesPayload_File */
final class C3375d extends CrashlyticsReport.FilesPayload.File {

    /* renamed from: a */
    private final String f19284a;

    /* renamed from: b */
    private final byte[] f19285b;

    /* renamed from: com.google.firebase.crashlytics.internal.model.d$b */
    /* compiled from: AutoValue_CrashlyticsReport_FilesPayload_File */
    static final class C3377b extends CrashlyticsReport.FilesPayload.File.Builder {

        /* renamed from: a */
        private String f19286a;

        /* renamed from: b */
        private byte[] f19287b;

        C3377b() {
        }

        public CrashlyticsReport.FilesPayload.File build() {
            String str = "";
            if (this.f19286a == null) {
                str = str + " filename";
            }
            if (this.f19287b == null) {
                str = str + " contents";
            }
            if (str.isEmpty()) {
                return new C3375d(this.f19286a, this.f19287b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.FilesPayload.File.Builder setContents(byte[] bArr) {
            if (bArr != null) {
                this.f19287b = bArr;
                return this;
            }
            throw new NullPointerException("Null contents");
        }

        public CrashlyticsReport.FilesPayload.File.Builder setFilename(String str) {
            if (str != null) {
                this.f19286a = str;
                return this;
            }
            throw new NullPointerException("Null filename");
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.FilesPayload.File)) {
            return false;
        }
        CrashlyticsReport.FilesPayload.File file = (CrashlyticsReport.FilesPayload.File) obj;
        if (this.f19284a.equals(file.getFilename())) {
            if (Arrays.equals(this.f19285b, file instanceof C3375d ? ((C3375d) file).f19285b : file.getContents())) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public byte[] getContents() {
        return this.f19285b;
    }

    @NonNull
    public String getFilename() {
        return this.f19284a;
    }

    public int hashCode() {
        return ((this.f19284a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f19285b);
    }

    public String toString() {
        return "File{filename=" + this.f19284a + ", contents=" + Arrays.toString(this.f19285b) + "}";
    }

    private C3375d(String str, byte[] bArr) {
        this.f19284a = str;
        this.f19285b = bArr;
    }
}
