package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* renamed from: com.google.firebase.crashlytics.internal.model.q */
/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Device */
final class C3414q extends CrashlyticsReport.Session.Event.Device {

    /* renamed from: a */
    private final Double f19406a;

    /* renamed from: b */
    private final int f19407b;

    /* renamed from: c */
    private final boolean f19408c;

    /* renamed from: d */
    private final int f19409d;

    /* renamed from: e */
    private final long f19410e;

    /* renamed from: f */
    private final long f19411f;

    /* renamed from: com.google.firebase.crashlytics.internal.model.q$b */
    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_Device */
    static final class C3416b extends CrashlyticsReport.Session.Event.Device.Builder {

        /* renamed from: a */
        private Double f19412a;

        /* renamed from: b */
        private Integer f19413b;

        /* renamed from: c */
        private Boolean f19414c;

        /* renamed from: d */
        private Integer f19415d;

        /* renamed from: e */
        private Long f19416e;

        /* renamed from: f */
        private Long f19417f;

        C3416b() {
        }

        public CrashlyticsReport.Session.Event.Device build() {
            String str = "";
            if (this.f19413b == null) {
                str = str + " batteryVelocity";
            }
            if (this.f19414c == null) {
                str = str + " proximityOn";
            }
            if (this.f19415d == null) {
                str = str + " orientation";
            }
            if (this.f19416e == null) {
                str = str + " ramUsed";
            }
            if (this.f19417f == null) {
                str = str + " diskUsed";
            }
            if (str.isEmpty()) {
                return new C3414q(this.f19412a, this.f19413b.intValue(), this.f19414c.booleanValue(), this.f19415d.intValue(), this.f19416e.longValue(), this.f19417f.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Event.Device.Builder setBatteryLevel(Double d) {
            this.f19412a = d;
            return this;
        }

        public CrashlyticsReport.Session.Event.Device.Builder setBatteryVelocity(int i) {
            this.f19413b = Integer.valueOf(i);
            return this;
        }

        public CrashlyticsReport.Session.Event.Device.Builder setDiskUsed(long j) {
            this.f19417f = Long.valueOf(j);
            return this;
        }

        public CrashlyticsReport.Session.Event.Device.Builder setOrientation(int i) {
            this.f19415d = Integer.valueOf(i);
            return this;
        }

        public CrashlyticsReport.Session.Event.Device.Builder setProximityOn(boolean z) {
            this.f19414c = Boolean.valueOf(z);
            return this;
        }

        public CrashlyticsReport.Session.Event.Device.Builder setRamUsed(long j) {
            this.f19416e = Long.valueOf(j);
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Device)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Device device = (CrashlyticsReport.Session.Event.Device) obj;
        Double d = this.f19406a;
        if (d != null ? d.equals(device.getBatteryLevel()) : device.getBatteryLevel() == null) {
            if (this.f19407b == device.getBatteryVelocity() && this.f19408c == device.isProximityOn() && this.f19409d == device.getOrientation() && this.f19410e == device.getRamUsed() && this.f19411f == device.getDiskUsed()) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Nullable
    public Double getBatteryLevel() {
        return this.f19406a;
    }

    public int getBatteryVelocity() {
        return this.f19407b;
    }

    public long getDiskUsed() {
        return this.f19411f;
    }

    public int getOrientation() {
        return this.f19409d;
    }

    public long getRamUsed() {
        return this.f19410e;
    }

    public int hashCode() {
        Double d = this.f19406a;
        int hashCode = ((((d == null ? 0 : d.hashCode()) ^ 1000003) * 1000003) ^ this.f19407b) * 1000003;
        int i = this.f19408c ? 1231 : 1237;
        long j = this.f19410e;
        long j2 = this.f19411f;
        return ((((((hashCode ^ i) * 1000003) ^ this.f19409d) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public boolean isProximityOn() {
        return this.f19408c;
    }

    public String toString() {
        return "Device{batteryLevel=" + this.f19406a + ", batteryVelocity=" + this.f19407b + ", proximityOn=" + this.f19408c + ", orientation=" + this.f19409d + ", ramUsed=" + this.f19410e + ", diskUsed=" + this.f19411f + "}";
    }

    private C3414q(@Nullable Double d, int i, boolean z, int i2, long j, long j2) {
        this.f19406a = d;
        this.f19407b = i;
        this.f19408c = z;
        this.f19409d = i2;
        this.f19410e = j;
        this.f19411f = j2;
    }
}
