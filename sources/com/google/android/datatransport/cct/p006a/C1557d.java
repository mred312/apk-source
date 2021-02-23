package com.google.android.datatransport.cct.p006a;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.p006a.zzq;
import java.util.Arrays;

/* renamed from: com.google.android.datatransport.cct.a.d */
final class C1557d extends zzq {

    /* renamed from: a */
    private final long f7107a;

    /* renamed from: b */
    private final Integer f7108b;

    /* renamed from: c */
    private final long f7109c;

    /* renamed from: d */
    private final byte[] f7110d;

    /* renamed from: e */
    private final String f7111e;

    /* renamed from: f */
    private final long f7112f;

    /* renamed from: g */
    private final zzt f7113g;

    /* renamed from: com.google.android.datatransport.cct.a.d$b */
    static final class C1559b extends zzq.zza {

        /* renamed from: a */
        private Long f7114a;

        /* renamed from: b */
        private Integer f7115b;

        /* renamed from: c */
        private Long f7116c;

        /* renamed from: d */
        private byte[] f7117d;

        /* renamed from: e */
        private String f7118e;

        /* renamed from: f */
        private Long f7119f;

        /* renamed from: g */
        private zzt f7120g;

        C1559b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public zzq.zza mo11314a(@Nullable String str) {
            this.f7118e = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public zzq.zza mo11315b(@Nullable byte[] bArr) {
            this.f7117d = bArr;
            return this;
        }

        public zzq.zza zza(long j) {
            this.f7114a = Long.valueOf(j);
            return this;
        }

        public zzq.zza zzb(long j) {
            this.f7116c = Long.valueOf(j);
            return this;
        }

        public zzq.zza zzc(long j) {
            this.f7119f = Long.valueOf(j);
            return this;
        }

        public zzq.zza zza(@Nullable Integer num) {
            this.f7115b = num;
            return this;
        }

        public zzq.zza zza(@Nullable zzt zzt) {
            this.f7120g = zzt;
            return this;
        }

        public zzq zza() {
            String str = "";
            if (this.f7114a == null) {
                str = str + " eventTimeMs";
            }
            if (this.f7116c == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f7119f == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new C1557d(this.f7114a.longValue(), this.f7115b, this.f7116c.longValue(), this.f7117d, this.f7118e, this.f7119f.longValue(), this.f7120g, (C1558a) null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    /* synthetic */ C1557d(long j, Integer num, long j2, byte[] bArr, String str, long j3, zzt zzt, C1558a aVar) {
        this.f7107a = j;
        this.f7108b = num;
        this.f7109c = j2;
        this.f7110d = bArr;
        this.f7111e = str;
        this.f7112f = j3;
        this.f7113g = zzt;
    }

    public boolean equals(Object obj) {
        Integer num;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzq)) {
            return false;
        }
        zzq zzq = (zzq) obj;
        if (this.f7107a == zzq.zzb() && ((num = this.f7108b) != null ? num.equals(((C1557d) zzq).f7108b) : ((C1557d) zzq).f7108b == null) && this.f7109c == zzq.zzc()) {
            if (Arrays.equals(this.f7110d, zzq instanceof C1557d ? ((C1557d) zzq).f7110d : zzq.zze()) && ((str = this.f7111e) != null ? str.equals(((C1557d) zzq).f7111e) : ((C1557d) zzq).f7111e == null) && this.f7112f == zzq.zzg()) {
                zzt zzt = this.f7113g;
                if (zzt == null) {
                    if (((C1557d) zzq).f7113g == null) {
                        return true;
                    }
                } else if (zzt.equals(((C1557d) zzq).f7113g)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.f7107a;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f7108b;
        int i2 = 0;
        int hashCode = num == null ? 0 : num.hashCode();
        long j2 = this.f7109c;
        int hashCode2 = (((((i ^ hashCode) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f7110d)) * 1000003;
        String str = this.f7111e;
        int hashCode3 = str == null ? 0 : str.hashCode();
        long j3 = this.f7112f;
        int i3 = (((hashCode2 ^ hashCode3) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        zzt zzt = this.f7113g;
        if (zzt != null) {
            i2 = zzt.hashCode();
        }
        return i3 ^ i2;
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f7107a + ", eventCode=" + this.f7108b + ", eventUptimeMs=" + this.f7109c + ", sourceExtension=" + Arrays.toString(this.f7110d) + ", sourceExtensionJsonProto3=" + this.f7111e + ", timezoneOffsetSeconds=" + this.f7112f + ", networkConnectionInfo=" + this.f7113g + "}";
    }

    @Nullable
    public Integer zza() {
        return this.f7108b;
    }

    public long zzb() {
        return this.f7107a;
    }

    public long zzc() {
        return this.f7109c;
    }

    @Nullable
    public zzt zzd() {
        return this.f7113g;
    }

    @Nullable
    public byte[] zze() {
        return this.f7110d;
    }

    @Nullable
    public String zzf() {
        return this.f7111e;
    }

    public long zzg() {
        return this.f7112f;
    }
}
