package com.google.android.datatransport.cct.p006a;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.p006a.zzt;

/* renamed from: com.google.android.datatransport.cct.a.g */
final class C1564g extends zzt {

    /* renamed from: a */
    private final zzt.zzc f7136a;

    /* renamed from: b */
    private final zzt.zzb f7137b;

    /* renamed from: com.google.android.datatransport.cct.a.g$b */
    static final class C1566b extends zzt.zza {

        /* renamed from: a */
        private zzt.zzc f7138a;

        /* renamed from: b */
        private zzt.zzb f7139b;

        C1566b() {
        }

        public zzt.zza zza(@Nullable zzt.zzc zzc) {
            this.f7138a = zzc;
            return this;
        }

        public zzt.zza zza(@Nullable zzt.zzb zzb) {
            this.f7139b = zzb;
            return this;
        }

        public zzt zza() {
            return new C1564g(this.f7138a, this.f7139b, (C1565a) null);
        }
    }

    /* synthetic */ C1564g(zzt.zzc zzc, zzt.zzb zzb, C1565a aVar) {
        this.f7136a = zzc;
        this.f7137b = zzb;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzt)) {
            return false;
        }
        zzt.zzc zzc = this.f7136a;
        if (zzc != null ? zzc.equals(((C1564g) obj).f7136a) : ((C1564g) obj).f7136a == null) {
            zzt.zzb zzb = this.f7137b;
            if (zzb == null) {
                if (((C1564g) obj).f7137b == null) {
                    return true;
                }
            } else if (zzb.equals(((C1564g) obj).f7137b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        zzt.zzc zzc = this.f7136a;
        int i = 0;
        int hashCode = ((zzc == null ? 0 : zzc.hashCode()) ^ 1000003) * 1000003;
        zzt.zzb zzb = this.f7137b;
        if (zzb != null) {
            i = zzb.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f7136a + ", mobileSubtype=" + this.f7137b + "}";
    }

    @Nullable
    public zzt.zzb zzb() {
        return this.f7137b;
    }

    @Nullable
    public zzt.zzc zzc() {
        return this.f7136a;
    }
}
