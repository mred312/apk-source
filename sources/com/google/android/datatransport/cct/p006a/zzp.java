package com.google.android.datatransport.cct.p006a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.p006a.C1554c;
import com.google.auto.value.AutoValue;

@AutoValue
/* renamed from: com.google.android.datatransport.cct.a.zzp */
public abstract class zzp {

    @AutoValue.Builder
    /* renamed from: com.google.android.datatransport.cct.a.zzp$zza */
    public static abstract class zza {
        @NonNull
        public abstract zza zza(@Nullable zza zza);

        @NonNull
        public abstract zza zza(@Nullable zzb zzb);

        @NonNull
        public abstract zzp zza();
    }

    /* renamed from: com.google.android.datatransport.cct.a.zzp$zzb */
    public enum zzb {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);

        static {
            UNKNOWN = new zzb("UNKNOWN", 0, 0);
            ANDROID_FIREBASE = new zzb("ANDROID_FIREBASE", 1, 23);
        }

        private zzb(int i) {
        }
    }

    @NonNull
    public static zza zza() {
        return new C1554c.C1556b();
    }

    @Nullable
    public abstract zza zzb();

    @Nullable
    public abstract zzb zzc();
}
