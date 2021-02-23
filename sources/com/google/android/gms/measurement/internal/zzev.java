package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzev {
    @NonNull

    /* renamed from: a */
    private String f18553a;

    /* renamed from: b */
    private long f18554b;
    @NonNull
    public String zza;
    @NonNull
    public Bundle zzb;

    private zzev(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle, long j) {
        this.zza = str;
        this.f18553a = str2;
        this.zzb = bundle == null ? new Bundle() : bundle;
        this.f18554b = j;
    }

    public static zzev zza(zzar zzar) {
        return new zzev(zzar.zza, zzar.zzc, zzar.zzb.zzb(), zzar.zzd);
    }

    public final String toString() {
        String str = this.f18553a;
        String str2 = this.zza;
        String valueOf = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        sb.append(",params=");
        sb.append(valueOf);
        return sb.toString();
    }

    public final zzar zza() {
        return new zzar(this.zza, new zzam(new Bundle(this.zzb)), this.f18553a, this.f18554b);
    }
}
