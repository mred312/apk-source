package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* renamed from: com.google.firebase.crashlytics.internal.model.h */
/* compiled from: AutoValue_CrashlyticsReport_Session_Device */
final class C3387h extends CrashlyticsReport.Session.Device {

    /* renamed from: a */
    private final int f19322a;

    /* renamed from: b */
    private final String f19323b;

    /* renamed from: c */
    private final int f19324c;

    /* renamed from: d */
    private final long f19325d;

    /* renamed from: e */
    private final long f19326e;

    /* renamed from: f */
    private final boolean f19327f;

    /* renamed from: g */
    private final int f19328g;

    /* renamed from: h */
    private final String f19329h;

    /* renamed from: i */
    private final String f19330i;

    /* renamed from: com.google.firebase.crashlytics.internal.model.h$b */
    /* compiled from: AutoValue_CrashlyticsReport_Session_Device */
    static final class C3389b extends CrashlyticsReport.Session.Device.Builder {

        /* renamed from: a */
        private Integer f19331a;

        /* renamed from: b */
        private String f19332b;

        /* renamed from: c */
        private Integer f19333c;

        /* renamed from: d */
        private Long f19334d;

        /* renamed from: e */
        private Long f19335e;

        /* renamed from: f */
        private Boolean f19336f;

        /* renamed from: g */
        private Integer f19337g;

        /* renamed from: h */
        private String f19338h;

        /* renamed from: i */
        private String f19339i;

        C3389b() {
        }

        public CrashlyticsReport.Session.Device build() {
            String str = "";
            if (this.f19331a == null) {
                str = str + " arch";
            }
            if (this.f19332b == null) {
                str = str + " model";
            }
            if (this.f19333c == null) {
                str = str + " cores";
            }
            if (this.f19334d == null) {
                str = str + " ram";
            }
            if (this.f19335e == null) {
                str = str + " diskSpace";
            }
            if (this.f19336f == null) {
                str = str + " simulator";
            }
            if (this.f19337g == null) {
                str = str + " state";
            }
            if (this.f19338h == null) {
                str = str + " manufacturer";
            }
            if (this.f19339i == null) {
                str = str + " modelClass";
            }
            if (str.isEmpty()) {
                return new C3387h(this.f19331a.intValue(), this.f19332b, this.f19333c.intValue(), this.f19334d.longValue(), this.f19335e.longValue(), this.f19336f.booleanValue(), this.f19337g.intValue(), this.f19338h, this.f19339i);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Device.Builder setArch(int i) {
            this.f19331a = Integer.valueOf(i);
            return this;
        }

        public CrashlyticsReport.Session.Device.Builder setCores(int i) {
            this.f19333c = Integer.valueOf(i);
            return this;
        }

        public CrashlyticsReport.Session.Device.Builder setDiskSpace(long j) {
            this.f19335e = Long.valueOf(j);
            return this;
        }

        public CrashlyticsReport.Session.Device.Builder setManufacturer(String str) {
            if (str != null) {
                this.f19338h = str;
                return this;
            }
            throw new NullPointerException("Null manufacturer");
        }

        public CrashlyticsReport.Session.Device.Builder setModel(String str) {
            if (str != null) {
                this.f19332b = str;
                return this;
            }
            throw new NullPointerException("Null model");
        }

        public CrashlyticsReport.Session.Device.Builder setModelClass(String str) {
            if (str != null) {
                this.f19339i = str;
                return this;
            }
            throw new NullPointerException("Null modelClass");
        }

        public CrashlyticsReport.Session.Device.Builder setRam(long j) {
            this.f19334d = Long.valueOf(j);
            return this;
        }

        public CrashlyticsReport.Session.Device.Builder setSimulator(boolean z) {
            this.f19336f = Boolean.valueOf(z);
            return this;
        }

        public CrashlyticsReport.Session.Device.Builder setState(int i) {
            this.f19337g = Integer.valueOf(i);
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Device)) {
            return false;
        }
        CrashlyticsReport.Session.Device device = (CrashlyticsReport.Session.Device) obj;
        if (this.f19322a == device.getArch() && this.f19323b.equals(device.getModel()) && this.f19324c == device.getCores() && this.f19325d == device.getRam() && this.f19326e == device.getDiskSpace() && this.f19327f == device.isSimulator() && this.f19328g == device.getState() && this.f19329h.equals(device.getManufacturer()) && this.f19330i.equals(device.getModelClass())) {
            return true;
        }
        return false;
    }

    @NonNull
    public int getArch() {
        return this.f19322a;
    }

    public int getCores() {
        return this.f19324c;
    }

    public long getDiskSpace() {
        return this.f19326e;
    }

    @NonNull
    public String getManufacturer() {
        return this.f19329h;
    }

    @NonNull
    public String getModel() {
        return this.f19323b;
    }

    @NonNull
    public String getModelClass() {
        return this.f19330i;
    }

    public long getRam() {
        return this.f19325d;
    }

    public int getState() {
        return this.f19328g;
    }

    public int hashCode() {
        long j = this.f19325d;
        long j2 = this.f19326e;
        return ((((((((((((((((this.f19322a ^ 1000003) * 1000003) ^ this.f19323b.hashCode()) * 1000003) ^ this.f19324c) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ (this.f19327f ? 1231 : 1237)) * 1000003) ^ this.f19328g) * 1000003) ^ this.f19329h.hashCode()) * 1000003) ^ this.f19330i.hashCode();
    }

    public boolean isSimulator() {
        return this.f19327f;
    }

    public String toString() {
        return "Device{arch=" + this.f19322a + ", model=" + this.f19323b + ", cores=" + this.f19324c + ", ram=" + this.f19325d + ", diskSpace=" + this.f19326e + ", simulator=" + this.f19327f + ", state=" + this.f19328g + ", manufacturer=" + this.f19329h + ", modelClass=" + this.f19330i + "}";
    }

    private C3387h(int i, String str, int i2, long j, long j2, boolean z, int i3, String str2, String str3) {
        this.f19322a = i;
        this.f19323b = str;
        this.f19324c = i2;
        this.f19325d = j;
        this.f19326e = j2;
        this.f19327f = z;
        this.f19328g = i3;
        this.f19329h = str2;
        this.f19330i = str3;
    }
}
