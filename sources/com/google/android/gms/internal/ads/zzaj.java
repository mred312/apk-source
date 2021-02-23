package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzaj<T> {
    @Nullable
    public final T result;
    @Nullable
    public final zzn zzbq;
    @Nullable
    public final zzao zzbr;
    public boolean zzbs;

    private zzaj(@Nullable T t, @Nullable zzn zzn) {
        this.zzbs = false;
        this.result = t;
        this.zzbq = zzn;
        this.zzbr = null;
    }

    public static <T> zzaj<T> zza(@Nullable T t, @Nullable zzn zzn) {
        return new zzaj<>(t, zzn);
    }

    public static <T> zzaj<T> zzd(zzao zzao) {
        return new zzaj<>(zzao);
    }

    public final boolean isSuccess() {
        return this.zzbr == null;
    }

    private zzaj(zzao zzao) {
        this.zzbs = false;
        this.result = null;
        this.zzbq = null;
        this.zzbr = zzao;
    }
}
