package com.google.android.datatransport.cct.p006a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.p006a.C1560e;
import com.google.auto.value.AutoValue;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

@AutoValue
/* renamed from: com.google.android.datatransport.cct.a.zzr */
public abstract class zzr {

    @AutoValue.Builder
    /* renamed from: com.google.android.datatransport.cct.a.zzr$zza */
    public static abstract class zza {
        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: a */
        public abstract zza mo11332a(@Nullable Integer num);

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: b */
        public abstract zza mo11333b(@Nullable String str);

        @NonNull
        public zza zza(int i) {
            return mo11332a(Integer.valueOf(i));
        }

        @NonNull
        public abstract zza zza(long j);

        @NonNull
        public abstract zza zza(@Nullable zzp zzp);

        @NonNull
        public abstract zza zza(@Nullable zzu zzu);

        @NonNull
        public abstract zza zza(@Nullable List<zzq> list);

        @NonNull
        public abstract zzr zza();

        @NonNull
        public abstract zza zzb(long j);

        @NonNull
        public zza zzb(@NonNull String str) {
            return mo11333b(str);
        }
    }

    @NonNull
    public static zza zza() {
        return new C1560e.C1562b();
    }

    @Nullable
    public abstract zzp zzb();

    @Nullable
    @Encodable.Field(name = "logEvent")
    public abstract List<zzq> zzc();

    @Nullable
    public abstract Integer zzd();

    @Nullable
    public abstract String zze();

    @Nullable
    public abstract zzu zzf();

    public abstract long zzg();

    public abstract long zzh();
}
