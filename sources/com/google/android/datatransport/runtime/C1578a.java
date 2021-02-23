package com.google.android.datatransport.runtime;

import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.EventInternal;
import java.util.Map;

/* renamed from: com.google.android.datatransport.runtime.a */
/* compiled from: AutoValue_EventInternal */
final class C1578a extends EventInternal {

    /* renamed from: a */
    private final String f7177a;

    /* renamed from: b */
    private final Integer f7178b;

    /* renamed from: c */
    private final EncodedPayload f7179c;

    /* renamed from: d */
    private final long f7180d;

    /* renamed from: e */
    private final long f7181e;

    /* renamed from: f */
    private final Map<String, String> f7182f;

    /* renamed from: com.google.android.datatransport.runtime.a$b */
    /* compiled from: AutoValue_EventInternal */
    static final class C1580b extends EventInternal.Builder {

        /* renamed from: a */
        private String f7183a;

        /* renamed from: b */
        private Integer f7184b;

        /* renamed from: c */
        private EncodedPayload f7185c;

        /* renamed from: d */
        private Long f7186d;

        /* renamed from: e */
        private Long f7187e;

        /* renamed from: f */
        private Map<String, String> f7188f;

        C1580b() {
        }

        public EventInternal build() {
            String str = "";
            if (this.f7183a == null) {
                str = str + " transportName";
            }
            if (this.f7185c == null) {
                str = str + " encodedPayload";
            }
            if (this.f7186d == null) {
                str = str + " eventMillis";
            }
            if (this.f7187e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f7188f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new C1578a(this.f7183a, this.f7184b, this.f7185c, this.f7186d.longValue(), this.f7187e.longValue(), this.f7188f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: protected */
        public Map<String, String> getAutoMetadata() {
            Map<String, String> map = this.f7188f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        /* access modifiers changed from: protected */
        public EventInternal.Builder setAutoMetadata(Map<String, String> map) {
            if (map != null) {
                this.f7188f = map;
                return this;
            }
            throw new NullPointerException("Null autoMetadata");
        }

        public EventInternal.Builder setCode(Integer num) {
            this.f7184b = num;
            return this;
        }

        public EventInternal.Builder setEncodedPayload(EncodedPayload encodedPayload) {
            if (encodedPayload != null) {
                this.f7185c = encodedPayload;
                return this;
            }
            throw new NullPointerException("Null encodedPayload");
        }

        public EventInternal.Builder setEventMillis(long j) {
            this.f7186d = Long.valueOf(j);
            return this;
        }

        public EventInternal.Builder setTransportName(String str) {
            if (str != null) {
                this.f7183a = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }

        public EventInternal.Builder setUptimeMillis(long j) {
            this.f7187e = Long.valueOf(j);
            return this;
        }
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventInternal)) {
            return false;
        }
        EventInternal eventInternal = (EventInternal) obj;
        if (!this.f7177a.equals(eventInternal.getTransportName()) || ((num = this.f7178b) != null ? !num.equals(eventInternal.getCode()) : eventInternal.getCode() != null) || !this.f7179c.equals(eventInternal.getEncodedPayload()) || this.f7180d != eventInternal.getEventMillis() || this.f7181e != eventInternal.getUptimeMillis() || !this.f7182f.equals(eventInternal.getAutoMetadata())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public Map<String, String> getAutoMetadata() {
        return this.f7182f;
    }

    @Nullable
    public Integer getCode() {
        return this.f7178b;
    }

    public EncodedPayload getEncodedPayload() {
        return this.f7179c;
    }

    public long getEventMillis() {
        return this.f7180d;
    }

    public String getTransportName() {
        return this.f7177a;
    }

    public long getUptimeMillis() {
        return this.f7181e;
    }

    public int hashCode() {
        int hashCode = (this.f7177a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f7178b;
        int hashCode2 = num == null ? 0 : num.hashCode();
        long j = this.f7180d;
        long j2 = this.f7181e;
        return ((((((((hashCode ^ hashCode2) * 1000003) ^ this.f7179c.hashCode()) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.f7182f.hashCode();
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f7177a + ", code=" + this.f7178b + ", encodedPayload=" + this.f7179c + ", eventMillis=" + this.f7180d + ", uptimeMillis=" + this.f7181e + ", autoMetadata=" + this.f7182f + "}";
    }

    private C1578a(String str, @Nullable Integer num, EncodedPayload encodedPayload, long j, long j2, Map<String, String> map) {
        this.f7177a = str;
        this.f7178b = num;
        this.f7179c = encodedPayload;
        this.f7180d = j;
        this.f7181e = j2;
        this.f7182f = map;
    }
}
