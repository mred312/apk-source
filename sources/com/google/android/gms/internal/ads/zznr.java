package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zznr {

    /* renamed from: a */
    private final zzhp[] f16772a;

    /* renamed from: b */
    private int f16773b;
    public final int length;

    public zznr(zzhp... zzhpArr) {
        zzpc.checkState(zzhpArr.length > 0);
        this.f16772a = zzhpArr;
        this.length = zzhpArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zznr.class == obj.getClass()) {
            zznr zznr = (zznr) obj;
            return this.length == zznr.length && Arrays.equals(this.f16772a, zznr.f16772a);
        }
    }

    public final int hashCode() {
        if (this.f16773b == 0) {
            this.f16773b = Arrays.hashCode(this.f16772a) + 527;
        }
        return this.f16773b;
    }

    public final zzhp zzbc(int i) {
        return this.f16772a[i];
    }

    public final int zzh(zzhp zzhp) {
        int i = 0;
        while (true) {
            zzhp[] zzhpArr = this.f16772a;
            if (i >= zzhpArr.length) {
                return -1;
            }
            if (zzhp == zzhpArr[i]) {
                return i;
            }
            i++;
        }
    }
}
