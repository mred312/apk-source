package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* renamed from: com.google.firebase.crashlytics.internal.model.i */
/* compiled from: AutoValue_CrashlyticsReport_Session_Event */
final class C3390i extends CrashlyticsReport.Session.Event {

    /* renamed from: a */
    private final long f19340a;

    /* renamed from: b */
    private final String f19341b;

    /* renamed from: c */
    private final CrashlyticsReport.Session.Event.Application f19342c;

    /* renamed from: d */
    private final CrashlyticsReport.Session.Event.Device f19343d;

    /* renamed from: e */
    private final CrashlyticsReport.Session.Event.Log f19344e;

    /* renamed from: com.google.firebase.crashlytics.internal.model.i$b */
    /* compiled from: AutoValue_CrashlyticsReport_Session_Event */
    static final class C3392b extends CrashlyticsReport.Session.Event.Builder {

        /* renamed from: a */
        private Long f19345a;

        /* renamed from: b */
        private String f19346b;

        /* renamed from: c */
        private CrashlyticsReport.Session.Event.Application f19347c;

        /* renamed from: d */
        private CrashlyticsReport.Session.Event.Device f19348d;

        /* renamed from: e */
        private CrashlyticsReport.Session.Event.Log f19349e;

        public CrashlyticsReport.Session.Event build() {
            String str = "";
            if (this.f19345a == null) {
                str = str + " timestamp";
            }
            if (this.f19346b == null) {
                str = str + " type";
            }
            if (this.f19347c == null) {
                str = str + " app";
            }
            if (this.f19348d == null) {
                str = str + " device";
            }
            if (str.isEmpty()) {
                return new C3390i(this.f19345a.longValue(), this.f19346b, this.f19347c, this.f19348d, this.f19349e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Event.Builder setApp(CrashlyticsReport.Session.Event.Application application) {
            if (application != null) {
                this.f19347c = application;
                return this;
            }
            throw new NullPointerException("Null app");
        }

        public CrashlyticsReport.Session.Event.Builder setDevice(CrashlyticsReport.Session.Event.Device device) {
            if (device != null) {
                this.f19348d = device;
                return this;
            }
            throw new NullPointerException("Null device");
        }

        public CrashlyticsReport.Session.Event.Builder setLog(CrashlyticsReport.Session.Event.Log log) {
            this.f19349e = log;
            return this;
        }

        public CrashlyticsReport.Session.Event.Builder setTimestamp(long j) {
            this.f19345a = Long.valueOf(j);
            return this;
        }

        public CrashlyticsReport.Session.Event.Builder setType(String str) {
            if (str != null) {
                this.f19346b = str;
                return this;
            }
            throw new NullPointerException("Null type");
        }

        C3392b() {
        }

        private C3392b(CrashlyticsReport.Session.Event event) {
            this.f19345a = Long.valueOf(event.getTimestamp());
            this.f19346b = event.getType();
            this.f19347c = event.getApp();
            this.f19348d = event.getDevice();
            this.f19349e = event.getLog();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event)) {
            return false;
        }
        CrashlyticsReport.Session.Event event = (CrashlyticsReport.Session.Event) obj;
        if (this.f19340a == event.getTimestamp() && this.f19341b.equals(event.getType()) && this.f19342c.equals(event.getApp()) && this.f19343d.equals(event.getDevice())) {
            CrashlyticsReport.Session.Event.Log log = this.f19344e;
            if (log == null) {
                if (event.getLog() == null) {
                    return true;
                }
            } else if (log.equals(event.getLog())) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public CrashlyticsReport.Session.Event.Application getApp() {
        return this.f19342c;
    }

    @NonNull
    public CrashlyticsReport.Session.Event.Device getDevice() {
        return this.f19343d;
    }

    @Nullable
    public CrashlyticsReport.Session.Event.Log getLog() {
        return this.f19344e;
    }

    public long getTimestamp() {
        return this.f19340a;
    }

    @NonNull
    public String getType() {
        return this.f19341b;
    }

    public int hashCode() {
        long j = this.f19340a;
        int hashCode = (((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f19341b.hashCode()) * 1000003) ^ this.f19342c.hashCode()) * 1000003) ^ this.f19343d.hashCode()) * 1000003;
        CrashlyticsReport.Session.Event.Log log = this.f19344e;
        return (log == null ? 0 : log.hashCode()) ^ hashCode;
    }

    public CrashlyticsReport.Session.Event.Builder toBuilder() {
        return new C3392b(this);
    }

    public String toString() {
        return "Event{timestamp=" + this.f19340a + ", type=" + this.f19341b + ", app=" + this.f19342c + ", device=" + this.f19343d + ", log=" + this.f19344e + "}";
    }

    private C3390i(long j, String str, CrashlyticsReport.Session.Event.Application application, CrashlyticsReport.Session.Event.Device device, @Nullable CrashlyticsReport.Session.Event.Log log) {
        this.f19340a = j;
        this.f19341b = str;
        this.f19342c = application;
        this.f19343d = device;
        this.f19344e = log;
    }
}
