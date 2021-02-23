package com.google.android.datatransport.cct.p006a;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.p006a.zzp;

/* renamed from: com.google.android.datatransport.cct.a.c */
final class C1554c extends zzp {

    /* renamed from: a */
    private final zzp.zzb f7103a;

    /* renamed from: b */
    private final zza f7104b;

    /* renamed from: com.google.android.datatransport.cct.a.c$b */
    static final class C1556b extends zzp.zza {

        /* renamed from: a */
        private zzp.zzb f7105a;

        /* renamed from: b */
        private zza f7106b;

        C1556b() {
        }

        public zzp.zza zza(@Nullable zzp.zzb zzb) {
            this.f7105a = zzb;
            return this;
        }

        public zzp.zza zza(@Nullable zza zza) {
            this.f7106b = zza;
            return this;
        }

        public zzp zza() {
            return new C1554c(this.f7105a, this.f7106b, (C1555a) null);
        }
    }

    /* synthetic */ C1554c(zzp.zzb zzb, zza zza, C1555a aVar) {
        this.f7103a = zzb;
        this.f7104b = zza;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzp)) {
            return false;
        }
        zzp.zzb zzb = this.f7103a;
        if (zzb != null ? zzb.equals(((C1554c) obj).f7103a) : ((C1554c) obj).f7103a == null) {
            zza zza = this.f7104b;
            if (zza == null) {
                if (((C1554c) obj).f7104b == null) {
                    return true;
                }
            } else if (zza.equals(((C1554c) obj).f7104b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        zzp.zzb zzb = this.f7103a;
        int i = 0;
        int hashCode = ((zzb == null ? 0 : zzb.hashCode()) ^ 1000003) * 1000003;
        zza zza = this.f7104b;
        if (zza != null) {
            i = zza.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f7103a + ", androidClientInfo=" + this.f7104b + "}";
    }

    @Nullable
    public zza zzb() {
        return this.f7104b;
    }

    @Nullable
    public zzp.zzb zzc() {
        return this.f7103a;
    }
}
