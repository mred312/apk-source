package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.C1630c;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.a */
/* compiled from: AutoValue_EventStoreConfig */
final class C1626a extends C1630c {

    /* renamed from: b */
    private final long f7363b;

    /* renamed from: c */
    private final int f7364c;

    /* renamed from: d */
    private final int f7365d;

    /* renamed from: e */
    private final long f7366e;

    /* renamed from: f */
    private final int f7367f;

    /* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.a$b */
    /* compiled from: AutoValue_EventStoreConfig */
    static final class C1628b extends C1630c.C1631a {

        /* renamed from: a */
        private Long f7368a;

        /* renamed from: b */
        private Integer f7369b;

        /* renamed from: c */
        private Integer f7370c;

        /* renamed from: d */
        private Long f7371d;

        /* renamed from: e */
        private Integer f7372e;

        C1628b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1630c mo11528a() {
            String str = "";
            if (this.f7368a == null) {
                str = str + " maxStorageSizeInBytes";
            }
            if (this.f7369b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f7370c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f7371d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f7372e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new C1626a(this.f7368a.longValue(), this.f7369b.intValue(), this.f7370c.intValue(), this.f7371d.longValue(), this.f7372e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C1630c.C1631a mo11529b(int i) {
            this.f7370c = Integer.valueOf(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public C1630c.C1631a mo11530c(long j) {
            this.f7371d = Long.valueOf(j);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public C1630c.C1631a mo11531d(int i) {
            this.f7369b = Integer.valueOf(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public C1630c.C1631a mo11532e(int i) {
            this.f7372e = Integer.valueOf(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public C1630c.C1631a mo11533f(long j) {
            this.f7368a = Long.valueOf(j);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo11520b() {
        return this.f7365d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public long mo11521c() {
        return this.f7366e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo11522d() {
        return this.f7364c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo11523e() {
        return this.f7367f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1630c)) {
            return false;
        }
        C1630c cVar = (C1630c) obj;
        if (this.f7363b == cVar.mo11525f() && this.f7364c == cVar.mo11522d() && this.f7365d == cVar.mo11520b() && this.f7366e == cVar.mo11521c() && this.f7367f == cVar.mo11523e()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public long mo11525f() {
        return this.f7363b;
    }

    public int hashCode() {
        long j = this.f7363b;
        long j2 = this.f7366e;
        return this.f7367f ^ ((((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f7364c) * 1000003) ^ this.f7365d) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f7363b + ", loadBatchSize=" + this.f7364c + ", criticalSectionEnterTimeoutMs=" + this.f7365d + ", eventCleanUpAge=" + this.f7366e + ", maxBlobByteSizePerRow=" + this.f7367f + "}";
    }

    private C1626a(long j, int i, int i2, long j2, int i3) {
        this.f7363b = j;
        this.f7364c = i;
        this.f7365d = i2;
        this.f7366e = j2;
        this.f7367f = i3;
    }
}
