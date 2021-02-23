package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzry {

    /* renamed from: a */
    final long f16965a;

    /* renamed from: b */
    final String f16966b;

    /* renamed from: c */
    final int f16967c;

    zzry(long j, String str, int i) {
        this.f16965a = j;
        this.f16966b = str;
        this.f16967c = i;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj != null && (obj instanceof zzry)) {
            zzry zzry = (zzry) obj;
            if (zzry.f16965a == this.f16965a && zzry.f16967c == this.f16967c) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return (int) this.f16965a;
    }
}
