package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.annotations.Encodable;

/* renamed from: com.google.firebase.crashlytics.internal.model.l */
/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage */
final class C3399l extends CrashlyticsReport.Session.Event.Application.Execution.BinaryImage {

    /* renamed from: a */
    private final long f19366a;

    /* renamed from: b */
    private final long f19367b;

    /* renamed from: c */
    private final String f19368c;

    /* renamed from: d */
    private final String f19369d;

    /* renamed from: com.google.firebase.crashlytics.internal.model.l$b */
    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage */
    static final class C3401b extends CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder {

        /* renamed from: a */
        private Long f19370a;

        /* renamed from: b */
        private Long f19371b;

        /* renamed from: c */
        private String f19372c;

        /* renamed from: d */
        private String f19373d;

        C3401b() {
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage build() {
            String str = "";
            if (this.f19370a == null) {
                str = str + " baseAddress";
            }
            if (this.f19371b == null) {
                str = str + " size";
            }
            if (this.f19372c == null) {
                str = str + " name";
            }
            if (str.isEmpty()) {
                return new C3399l(this.f19370a.longValue(), this.f19371b.longValue(), this.f19372c, this.f19373d);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setBaseAddress(long j) {
            this.f19370a = Long.valueOf(j);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setName(String str) {
            if (str != null) {
                this.f19372c = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setSize(long j) {
            this.f19371b = Long.valueOf(j);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setUuid(@Nullable String str) {
            this.f19373d = str;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.BinaryImage)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.BinaryImage binaryImage = (CrashlyticsReport.Session.Event.Application.Execution.BinaryImage) obj;
        if (this.f19366a == binaryImage.getBaseAddress() && this.f19367b == binaryImage.getSize() && this.f19368c.equals(binaryImage.getName())) {
            String str = this.f19369d;
            if (str == null) {
                if (binaryImage.getUuid() == null) {
                    return true;
                }
            } else if (str.equals(binaryImage.getUuid())) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public long getBaseAddress() {
        return this.f19366a;
    }

    @NonNull
    public String getName() {
        return this.f19368c;
    }

    public long getSize() {
        return this.f19367b;
    }

    @Encodable.Ignore
    @Nullable
    public String getUuid() {
        return this.f19369d;
    }

    public int hashCode() {
        long j = this.f19366a;
        long j2 = this.f19367b;
        int hashCode = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.f19368c.hashCode()) * 1000003;
        String str = this.f19369d;
        return (str == null ? 0 : str.hashCode()) ^ hashCode;
    }

    public String toString() {
        return "BinaryImage{baseAddress=" + this.f19366a + ", size=" + this.f19367b + ", name=" + this.f19368c + ", uuid=" + this.f19369d + "}";
    }

    private C3399l(long j, long j2, String str, @Nullable String str2) {
        this.f19366a = j;
        this.f19367b = j2;
        this.f19368c = str;
        this.f19369d = str2;
    }
}
