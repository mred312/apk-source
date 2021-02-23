package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzoe {

    /* renamed from: a */
    private final zzoc[] f16783a;

    /* renamed from: b */
    private int f16784b;
    public final int length;

    public zzoe(zzoc... zzocArr) {
        this.f16783a = zzocArr;
        this.length = zzocArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzoe.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f16783a, ((zzoe) obj).f16783a);
    }

    public final int hashCode() {
        if (this.f16784b == 0) {
            this.f16784b = Arrays.hashCode(this.f16783a) + 527;
        }
        return this.f16784b;
    }

    public final zzoc zzbe(int i) {
        return this.f16783a[i];
    }

    public final zzoc[] zzim() {
        return (zzoc[]) this.f16783a.clone();
    }
}
