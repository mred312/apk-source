package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zznq {
    public static final zznq zzbgs = new zznq(new zznr[0]);

    /* renamed from: a */
    private final zznr[] f16770a;

    /* renamed from: b */
    private int f16771b;
    public final int length;

    public zznq(zznr... zznrArr) {
        this.f16770a = zznrArr;
        this.length = zznrArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zznq.class == obj.getClass()) {
            zznq zznq = (zznq) obj;
            return this.length == zznq.length && Arrays.equals(this.f16770a, zznq.f16770a);
        }
    }

    public final int hashCode() {
        if (this.f16771b == 0) {
            this.f16771b = Arrays.hashCode(this.f16770a);
        }
        return this.f16771b;
    }

    public final int zza(zznr zznr) {
        for (int i = 0; i < this.length; i++) {
            if (this.f16770a[i] == zznr) {
                return i;
            }
        }
        return -1;
    }

    public final zznr zzbb(int i) {
        return this.f16770a[i];
    }
}
