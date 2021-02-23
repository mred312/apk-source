package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zznv implements zzoc {

    /* renamed from: a */
    private final zznr f16774a;

    /* renamed from: b */
    private final int f16775b;

    /* renamed from: c */
    private final int[] f16776c;

    /* renamed from: d */
    private final zzhp[] f16777d;

    /* renamed from: e */
    private int f16778e;

    public zznv(zznr zznr, int... iArr) {
        int i = 0;
        zzpc.checkState(iArr.length > 0);
        this.f16774a = (zznr) zzpc.checkNotNull(zznr);
        int length = iArr.length;
        this.f16775b = length;
        this.f16777d = new zzhp[length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.f16777d[i2] = zznr.zzbc(iArr[i2]);
        }
        Arrays.sort(this.f16777d, new kg0());
        this.f16776c = new int[this.f16775b];
        while (true) {
            int i3 = this.f16775b;
            if (i < i3) {
                this.f16776c[i] = zznr.zzh(this.f16777d[i]);
                i++;
            } else {
                long[] jArr = new long[i3];
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zznv zznv = (zznv) obj;
            return this.f16774a == zznv.f16774a && Arrays.equals(this.f16776c, zznv.f16776c);
        }
    }

    public int hashCode() {
        if (this.f16778e == 0) {
            this.f16778e = (System.identityHashCode(this.f16774a) * 31) + Arrays.hashCode(this.f16776c);
        }
        return this.f16778e;
    }

    public final int length() {
        return this.f16776c.length;
    }

    public final zzhp zzbc(int i) {
        return this.f16777d[i];
    }

    public final int zzbd(int i) {
        return this.f16776c[0];
    }

    public final zznr zzil() {
        return this.f16774a;
    }
}
