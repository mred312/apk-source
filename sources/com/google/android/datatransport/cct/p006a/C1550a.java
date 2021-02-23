package com.google.android.datatransport.cct.p006a;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.p006a.zza;

/* renamed from: com.google.android.datatransport.cct.a.a */
final class C1550a extends zza {

    /* renamed from: a */
    private final Integer f7086a;

    /* renamed from: b */
    private final String f7087b;

    /* renamed from: c */
    private final String f7088c;

    /* renamed from: d */
    private final String f7089d;

    /* renamed from: e */
    private final String f7090e;

    /* renamed from: f */
    private final String f7091f;

    /* renamed from: g */
    private final String f7092g;

    /* renamed from: h */
    private final String f7093h;

    /* renamed from: com.google.android.datatransport.cct.a.a$b */
    static final class C1552b extends zza.C3973zza {

        /* renamed from: a */
        private Integer f7094a;

        /* renamed from: b */
        private String f7095b;

        /* renamed from: c */
        private String f7096c;

        /* renamed from: d */
        private String f7097d;

        /* renamed from: e */
        private String f7098e;

        /* renamed from: f */
        private String f7099f;

        /* renamed from: g */
        private String f7100g;

        /* renamed from: h */
        private String f7101h;

        C1552b() {
        }

        public zza.C3973zza zza(@Nullable Integer num) {
            this.f7094a = num;
            return this;
        }

        public zza.C3973zza zzb(@Nullable String str) {
            this.f7101h = str;
            return this;
        }

        public zza.C3973zza zzc(@Nullable String str) {
            this.f7096c = str;
            return this;
        }

        public zza.C3973zza zzd(@Nullable String str) {
            this.f7100g = str;
            return this;
        }

        public zza.C3973zza zze(@Nullable String str) {
            this.f7095b = str;
            return this;
        }

        public zza.C3973zza zzf(@Nullable String str) {
            this.f7099f = str;
            return this;
        }

        public zza.C3973zza zzg(@Nullable String str) {
            this.f7098e = str;
            return this;
        }

        public zza.C3973zza zza(@Nullable String str) {
            this.f7097d = str;
            return this;
        }

        public zza zza() {
            return new C1550a(this.f7094a, this.f7095b, this.f7096c, this.f7097d, this.f7098e, this.f7099f, this.f7100g, this.f7101h, (C1551a) null);
        }
    }

    /* synthetic */ C1550a(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, C1551a aVar) {
        this.f7086a = num;
        this.f7087b = str;
        this.f7088c = str2;
        this.f7089d = str3;
        this.f7090e = str4;
        this.f7091f = str5;
        this.f7092g = str6;
        this.f7093h = str7;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zza)) {
            return false;
        }
        Integer num = this.f7086a;
        if (num != null ? num.equals(((C1550a) obj).f7086a) : ((C1550a) obj).f7086a == null) {
            String str = this.f7087b;
            if (str != null ? str.equals(((C1550a) obj).f7087b) : ((C1550a) obj).f7087b == null) {
                String str2 = this.f7088c;
                if (str2 != null ? str2.equals(((C1550a) obj).f7088c) : ((C1550a) obj).f7088c == null) {
                    String str3 = this.f7089d;
                    if (str3 != null ? str3.equals(((C1550a) obj).f7089d) : ((C1550a) obj).f7089d == null) {
                        String str4 = this.f7090e;
                        if (str4 != null ? str4.equals(((C1550a) obj).f7090e) : ((C1550a) obj).f7090e == null) {
                            String str5 = this.f7091f;
                            if (str5 != null ? str5.equals(((C1550a) obj).f7091f) : ((C1550a) obj).f7091f == null) {
                                String str6 = this.f7092g;
                                if (str6 != null ? str6.equals(((C1550a) obj).f7092g) : ((C1550a) obj).f7092g == null) {
                                    String str7 = this.f7093h;
                                    if (str7 == null) {
                                        if (((C1550a) obj).f7093h == null) {
                                            return true;
                                        }
                                    } else if (str7.equals(((C1550a) obj).f7093h)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.f7086a;
        int i = 0;
        int hashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.f7087b;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f7088c;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f7089d;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f7090e;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f7091f;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f7092g;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f7093h;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return hashCode7 ^ i;
    }

    public String toString() {
        return "AndroidClientInfo{sdkVersion=" + this.f7086a + ", model=" + this.f7087b + ", hardware=" + this.f7088c + ", device=" + this.f7089d + ", product=" + this.f7090e + ", osBuild=" + this.f7091f + ", manufacturer=" + this.f7092g + ", fingerprint=" + this.f7093h + "}";
    }

    @Nullable
    public String zzb() {
        return this.f7089d;
    }

    @Nullable
    public String zzc() {
        return this.f7093h;
    }

    @Nullable
    public String zzd() {
        return this.f7088c;
    }

    @Nullable
    public String zze() {
        return this.f7092g;
    }

    @Nullable
    public String zzf() {
        return this.f7087b;
    }

    @Nullable
    public String zzg() {
        return this.f7091f;
    }

    @Nullable
    public String zzh() {
        return this.f7090e;
    }

    @Nullable
    public Integer zzi() {
        return this.f7086a;
    }
}
