package com.google.android.datatransport.cct.p006a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.p006a.C1557d;
import com.google.auto.value.AutoValue;

@AutoValue
/* renamed from: com.google.android.datatransport.cct.a.zzq */
public abstract class zzq {

    @AutoValue.Builder
    /* renamed from: com.google.android.datatransport.cct.a.zzq$zza */
    public static abstract class zza {
        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: a */
        public abstract zza mo11314a(@Nullable String str);

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: b */
        public abstract zza mo11315b(@Nullable byte[] bArr);

        @NonNull
        public abstract zza zza(long j);

        @NonNull
        public abstract zza zza(@Nullable zzt zzt);

        @NonNull
        public abstract zza zza(@Nullable Integer num);

        @NonNull
        public abstract zzq zza();

        @NonNull
        public abstract zza zzb(long j);

        @NonNull
        public abstract zza zzc(long j);
    }

    @NonNull
    public static zza zza(@NonNull String str) {
        C1557d.C1559b bVar = new C1557d.C1559b();
        bVar.mo11314a(str);
        return bVar;
    }

    @Nullable
    public abstract Integer zza();

    public abstract long zzb();

    public abstract long zzc();

    @Nullable
    public abstract zzt zzd();

    @Nullable
    public abstract byte[] zze();

    @Nullable
    public abstract String zzf();

    public abstract long zzg();

    @NonNull
    public static zza zza(@NonNull byte[] bArr) {
        C1557d.C1559b bVar = new C1557d.C1559b();
        bVar.mo11315b(bArr);
        return bVar;
    }
}
