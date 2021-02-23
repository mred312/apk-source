package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* renamed from: com.google.firebase.crashlytics.internal.model.p */
/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame */
final class C3411p extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame {

    /* renamed from: a */
    private final long f19396a;

    /* renamed from: b */
    private final String f19397b;

    /* renamed from: c */
    private final String f19398c;

    /* renamed from: d */
    private final long f19399d;

    /* renamed from: e */
    private final int f19400e;

    /* renamed from: com.google.firebase.crashlytics.internal.model.p$b */
    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame */
    static final class C3413b extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder {

        /* renamed from: a */
        private Long f19401a;

        /* renamed from: b */
        private String f19402b;

        /* renamed from: c */
        private String f19403c;

        /* renamed from: d */
        private Long f19404d;

        /* renamed from: e */
        private Integer f19405e;

        C3413b() {
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame build() {
            String str = "";
            if (this.f19401a == null) {
                str = str + " pc";
            }
            if (this.f19402b == null) {
                str = str + " symbol";
            }
            if (this.f19404d == null) {
                str = str + " offset";
            }
            if (this.f19405e == null) {
                str = str + " importance";
            }
            if (str.isEmpty()) {
                return new C3411p(this.f19401a.longValue(), this.f19402b, this.f19403c, this.f19404d.longValue(), this.f19405e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setFile(String str) {
            this.f19403c = str;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setImportance(int i) {
            this.f19405e = Integer.valueOf(i);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setOffset(long j) {
            this.f19404d = Long.valueOf(j);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setPc(long j) {
            this.f19401a = Long.valueOf(j);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setSymbol(String str) {
            if (str != null) {
                this.f19402b = str;
                return this;
            }
            throw new NullPointerException("Null symbol");
        }
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame frame = (CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame) obj;
        if (this.f19396a == frame.getPc() && this.f19397b.equals(frame.getSymbol()) && ((str = this.f19398c) != null ? str.equals(frame.getFile()) : frame.getFile() == null) && this.f19399d == frame.getOffset() && this.f19400e == frame.getImportance()) {
            return true;
        }
        return false;
    }

    @Nullable
    public String getFile() {
        return this.f19398c;
    }

    public int getImportance() {
        return this.f19400e;
    }

    public long getOffset() {
        return this.f19399d;
    }

    public long getPc() {
        return this.f19396a;
    }

    @NonNull
    public String getSymbol() {
        return this.f19397b;
    }

    public int hashCode() {
        long j = this.f19396a;
        int hashCode = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f19397b.hashCode()) * 1000003;
        String str = this.f19398c;
        int hashCode2 = str == null ? 0 : str.hashCode();
        long j2 = this.f19399d;
        return this.f19400e ^ ((((hashCode ^ hashCode2) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "Frame{pc=" + this.f19396a + ", symbol=" + this.f19397b + ", file=" + this.f19398c + ", offset=" + this.f19399d + ", importance=" + this.f19400e + "}";
    }

    private C3411p(long j, String str, @Nullable String str2, long j2, int i) {
        this.f19396a = j;
        this.f19397b = str;
        this.f19398c = str2;
        this.f19399d = j2;
        this.f19400e = i;
    }
}
