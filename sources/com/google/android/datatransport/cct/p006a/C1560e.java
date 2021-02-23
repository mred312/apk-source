package com.google.android.datatransport.cct.p006a;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.p006a.zzr;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

/* renamed from: com.google.android.datatransport.cct.a.e */
final class C1560e extends zzr {

    /* renamed from: a */
    private final long f7121a;

    /* renamed from: b */
    private final long f7122b;

    /* renamed from: c */
    private final zzp f7123c;

    /* renamed from: d */
    private final Integer f7124d;

    /* renamed from: e */
    private final String f7125e;

    /* renamed from: f */
    private final List<zzq> f7126f;

    /* renamed from: g */
    private final zzu f7127g;

    /* renamed from: com.google.android.datatransport.cct.a.e$b */
    static final class C1562b extends zzr.zza {

        /* renamed from: a */
        private Long f7128a;

        /* renamed from: b */
        private Long f7129b;

        /* renamed from: c */
        private zzp f7130c;

        /* renamed from: d */
        private Integer f7131d;

        /* renamed from: e */
        private String f7132e;

        /* renamed from: f */
        private List<zzq> f7133f;

        /* renamed from: g */
        private zzu f7134g;

        C1562b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public zzr.zza mo11332a(@Nullable Integer num) {
            this.f7131d = num;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public zzr.zza mo11333b(@Nullable String str) {
            this.f7132e = str;
            return this;
        }

        public zzr.zza zza(long j) {
            this.f7128a = Long.valueOf(j);
            return this;
        }

        public zzr.zza zzb(long j) {
            this.f7129b = Long.valueOf(j);
            return this;
        }

        public zzr.zza zza(@Nullable zzp zzp) {
            this.f7130c = zzp;
            return this;
        }

        public zzr.zza zza(@Nullable List<zzq> list) {
            this.f7133f = list;
            return this;
        }

        public zzr.zza zza(@Nullable zzu zzu) {
            this.f7134g = zzu;
            return this;
        }

        public zzr zza() {
            String str = "";
            if (this.f7128a == null) {
                str = str + " requestTimeMs";
            }
            if (this.f7129b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new C1560e(this.f7128a.longValue(), this.f7129b.longValue(), this.f7130c, this.f7131d, this.f7132e, this.f7133f, this.f7134g, (C1561a) null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    /* synthetic */ C1560e(long j, long j2, zzp zzp, Integer num, String str, List list, zzu zzu, C1561a aVar) {
        this.f7121a = j;
        this.f7122b = j2;
        this.f7123c = zzp;
        this.f7124d = num;
        this.f7125e = str;
        this.f7126f = list;
        this.f7127g = zzu;
    }

    public boolean equals(Object obj) {
        zzp zzp;
        Integer num;
        String str;
        List<zzq> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzr)) {
            return false;
        }
        zzr zzr = (zzr) obj;
        if (this.f7121a == zzr.zzg() && this.f7122b == zzr.zzh() && ((zzp = this.f7123c) != null ? zzp.equals(((C1560e) zzr).f7123c) : ((C1560e) zzr).f7123c == null) && ((num = this.f7124d) != null ? num.equals(((C1560e) zzr).f7124d) : ((C1560e) zzr).f7124d == null) && ((str = this.f7125e) != null ? str.equals(((C1560e) zzr).f7125e) : ((C1560e) zzr).f7125e == null) && ((list = this.f7126f) != null ? list.equals(((C1560e) zzr).f7126f) : ((C1560e) zzr).f7126f == null)) {
            zzu zzu = this.f7127g;
            if (zzu == null) {
                if (((C1560e) zzr).f7127g == null) {
                    return true;
                }
            } else if (zzu.equals(((C1560e) zzr).f7127g)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.f7121a;
        long j2 = this.f7122b;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        zzp zzp = this.f7123c;
        int i2 = 0;
        int hashCode = (i ^ (zzp == null ? 0 : zzp.hashCode())) * 1000003;
        Integer num = this.f7124d;
        int hashCode2 = (hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f7125e;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<zzq> list = this.f7126f;
        int hashCode4 = (hashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        zzu zzu = this.f7127g;
        if (zzu != null) {
            i2 = zzu.hashCode();
        }
        return hashCode4 ^ i2;
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f7121a + ", requestUptimeMs=" + this.f7122b + ", clientInfo=" + this.f7123c + ", logSource=" + this.f7124d + ", logSourceName=" + this.f7125e + ", logEvents=" + this.f7126f + ", qosTier=" + this.f7127g + "}";
    }

    @Nullable
    public zzp zzb() {
        return this.f7123c;
    }

    @Nullable
    @Encodable.Field(name = "logEvent")
    public List<zzq> zzc() {
        return this.f7126f;
    }

    @Nullable
    public Integer zzd() {
        return this.f7124d;
    }

    @Nullable
    public String zze() {
        return this.f7125e;
    }

    @Nullable
    public zzu zzf() {
        return this.f7127g;
    }

    public long zzg() {
        return this.f7121a;
    }

    public long zzh() {
        return this.f7122b;
    }
}
