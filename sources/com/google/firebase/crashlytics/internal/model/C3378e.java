package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.annotations.Encodable;

/* renamed from: com.google.firebase.crashlytics.internal.model.e */
/* compiled from: AutoValue_CrashlyticsReport_Session */
final class C3378e extends CrashlyticsReport.Session {

    /* renamed from: a */
    private final String f19288a;

    /* renamed from: b */
    private final String f19289b;

    /* renamed from: c */
    private final long f19290c;

    /* renamed from: d */
    private final Long f19291d;

    /* renamed from: e */
    private final boolean f19292e;

    /* renamed from: f */
    private final CrashlyticsReport.Session.Application f19293f;

    /* renamed from: g */
    private final CrashlyticsReport.Session.User f19294g;

    /* renamed from: h */
    private final CrashlyticsReport.Session.OperatingSystem f19295h;

    /* renamed from: i */
    private final CrashlyticsReport.Session.Device f19296i;

    /* renamed from: j */
    private final ImmutableList<CrashlyticsReport.Session.Event> f19297j;

    /* renamed from: k */
    private final int f19298k;

    /* renamed from: com.google.firebase.crashlytics.internal.model.e$b */
    /* compiled from: AutoValue_CrashlyticsReport_Session */
    static final class C3380b extends CrashlyticsReport.Session.Builder {

        /* renamed from: a */
        private String f19299a;

        /* renamed from: b */
        private String f19300b;

        /* renamed from: c */
        private Long f19301c;

        /* renamed from: d */
        private Long f19302d;

        /* renamed from: e */
        private Boolean f19303e;

        /* renamed from: f */
        private CrashlyticsReport.Session.Application f19304f;

        /* renamed from: g */
        private CrashlyticsReport.Session.User f19305g;

        /* renamed from: h */
        private CrashlyticsReport.Session.OperatingSystem f19306h;

        /* renamed from: i */
        private CrashlyticsReport.Session.Device f19307i;

        /* renamed from: j */
        private ImmutableList<CrashlyticsReport.Session.Event> f19308j;

        /* renamed from: k */
        private Integer f19309k;

        public CrashlyticsReport.Session build() {
            String str = "";
            if (this.f19299a == null) {
                str = str + " generator";
            }
            if (this.f19300b == null) {
                str = str + " identifier";
            }
            if (this.f19301c == null) {
                str = str + " startedAt";
            }
            if (this.f19303e == null) {
                str = str + " crashed";
            }
            if (this.f19304f == null) {
                str = str + " app";
            }
            if (this.f19309k == null) {
                str = str + " generatorType";
            }
            if (str.isEmpty()) {
                return new C3378e(this.f19299a, this.f19300b, this.f19301c.longValue(), this.f19302d, this.f19303e.booleanValue(), this.f19304f, this.f19305g, this.f19306h, this.f19307i, this.f19308j, this.f19309k.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Builder setApp(CrashlyticsReport.Session.Application application) {
            if (application != null) {
                this.f19304f = application;
                return this;
            }
            throw new NullPointerException("Null app");
        }

        public CrashlyticsReport.Session.Builder setCrashed(boolean z) {
            this.f19303e = Boolean.valueOf(z);
            return this;
        }

        public CrashlyticsReport.Session.Builder setDevice(CrashlyticsReport.Session.Device device) {
            this.f19307i = device;
            return this;
        }

        public CrashlyticsReport.Session.Builder setEndedAt(Long l) {
            this.f19302d = l;
            return this;
        }

        public CrashlyticsReport.Session.Builder setEvents(ImmutableList<CrashlyticsReport.Session.Event> immutableList) {
            this.f19308j = immutableList;
            return this;
        }

        public CrashlyticsReport.Session.Builder setGenerator(String str) {
            if (str != null) {
                this.f19299a = str;
                return this;
            }
            throw new NullPointerException("Null generator");
        }

        public CrashlyticsReport.Session.Builder setGeneratorType(int i) {
            this.f19309k = Integer.valueOf(i);
            return this;
        }

        public CrashlyticsReport.Session.Builder setIdentifier(String str) {
            if (str != null) {
                this.f19300b = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }

        public CrashlyticsReport.Session.Builder setOs(CrashlyticsReport.Session.OperatingSystem operatingSystem) {
            this.f19306h = operatingSystem;
            return this;
        }

        public CrashlyticsReport.Session.Builder setStartedAt(long j) {
            this.f19301c = Long.valueOf(j);
            return this;
        }

        public CrashlyticsReport.Session.Builder setUser(CrashlyticsReport.Session.User user) {
            this.f19305g = user;
            return this;
        }

        C3380b() {
        }

        private C3380b(CrashlyticsReport.Session session) {
            this.f19299a = session.getGenerator();
            this.f19300b = session.getIdentifier();
            this.f19301c = Long.valueOf(session.getStartedAt());
            this.f19302d = session.getEndedAt();
            this.f19303e = Boolean.valueOf(session.isCrashed());
            this.f19304f = session.getApp();
            this.f19305g = session.getUser();
            this.f19306h = session.getOs();
            this.f19307i = session.getDevice();
            this.f19308j = session.getEvents();
            this.f19309k = Integer.valueOf(session.getGeneratorType());
        }
    }

    public boolean equals(Object obj) {
        Long l;
        CrashlyticsReport.Session.User user;
        CrashlyticsReport.Session.OperatingSystem operatingSystem;
        CrashlyticsReport.Session.Device device;
        ImmutableList<CrashlyticsReport.Session.Event> immutableList;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session)) {
            return false;
        }
        CrashlyticsReport.Session session = (CrashlyticsReport.Session) obj;
        if (!this.f19288a.equals(session.getGenerator()) || !this.f19289b.equals(session.getIdentifier()) || this.f19290c != session.getStartedAt() || ((l = this.f19291d) != null ? !l.equals(session.getEndedAt()) : session.getEndedAt() != null) || this.f19292e != session.isCrashed() || !this.f19293f.equals(session.getApp()) || ((user = this.f19294g) != null ? !user.equals(session.getUser()) : session.getUser() != null) || ((operatingSystem = this.f19295h) != null ? !operatingSystem.equals(session.getOs()) : session.getOs() != null) || ((device = this.f19296i) != null ? !device.equals(session.getDevice()) : session.getDevice() != null) || ((immutableList = this.f19297j) != null ? !immutableList.equals(session.getEvents()) : session.getEvents() != null) || this.f19298k != session.getGeneratorType()) {
            return false;
        }
        return true;
    }

    @NonNull
    public CrashlyticsReport.Session.Application getApp() {
        return this.f19293f;
    }

    @Nullable
    public CrashlyticsReport.Session.Device getDevice() {
        return this.f19296i;
    }

    @Nullable
    public Long getEndedAt() {
        return this.f19291d;
    }

    @Nullable
    public ImmutableList<CrashlyticsReport.Session.Event> getEvents() {
        return this.f19297j;
    }

    @NonNull
    public String getGenerator() {
        return this.f19288a;
    }

    public int getGeneratorType() {
        return this.f19298k;
    }

    @NonNull
    @Encodable.Ignore
    public String getIdentifier() {
        return this.f19289b;
    }

    @Nullable
    public CrashlyticsReport.Session.OperatingSystem getOs() {
        return this.f19295h;
    }

    public long getStartedAt() {
        return this.f19290c;
    }

    @Nullable
    public CrashlyticsReport.Session.User getUser() {
        return this.f19294g;
    }

    public int hashCode() {
        long j = this.f19290c;
        int hashCode = (((((this.f19288a.hashCode() ^ 1000003) * 1000003) ^ this.f19289b.hashCode()) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        Long l = this.f19291d;
        int i = 0;
        int hashCode2 = (((((hashCode ^ (l == null ? 0 : l.hashCode())) * 1000003) ^ (this.f19292e ? 1231 : 1237)) * 1000003) ^ this.f19293f.hashCode()) * 1000003;
        CrashlyticsReport.Session.User user = this.f19294g;
        int hashCode3 = (hashCode2 ^ (user == null ? 0 : user.hashCode())) * 1000003;
        CrashlyticsReport.Session.OperatingSystem operatingSystem = this.f19295h;
        int hashCode4 = (hashCode3 ^ (operatingSystem == null ? 0 : operatingSystem.hashCode())) * 1000003;
        CrashlyticsReport.Session.Device device = this.f19296i;
        int hashCode5 = (hashCode4 ^ (device == null ? 0 : device.hashCode())) * 1000003;
        ImmutableList<CrashlyticsReport.Session.Event> immutableList = this.f19297j;
        if (immutableList != null) {
            i = immutableList.hashCode();
        }
        return ((hashCode5 ^ i) * 1000003) ^ this.f19298k;
    }

    public boolean isCrashed() {
        return this.f19292e;
    }

    public CrashlyticsReport.Session.Builder toBuilder() {
        return new C3380b(this);
    }

    public String toString() {
        return "Session{generator=" + this.f19288a + ", identifier=" + this.f19289b + ", startedAt=" + this.f19290c + ", endedAt=" + this.f19291d + ", crashed=" + this.f19292e + ", app=" + this.f19293f + ", user=" + this.f19294g + ", os=" + this.f19295h + ", device=" + this.f19296i + ", events=" + this.f19297j + ", generatorType=" + this.f19298k + "}";
    }

    private C3378e(String str, String str2, long j, @Nullable Long l, boolean z, CrashlyticsReport.Session.Application application, @Nullable CrashlyticsReport.Session.User user, @Nullable CrashlyticsReport.Session.OperatingSystem operatingSystem, @Nullable CrashlyticsReport.Session.Device device, @Nullable ImmutableList<CrashlyticsReport.Session.Event> immutableList, int i) {
        this.f19288a = str;
        this.f19289b = str2;
        this.f19290c = j;
        this.f19291d = l;
        this.f19292e = z;
        this.f19293f = application;
        this.f19294g = user;
        this.f19295h = operatingSystem;
        this.f19296i = device;
        this.f19297j = immutableList;
        this.f19298k = i;
    }
}
