package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzph {

    /* renamed from: a */
    private int f16822a;

    /* renamed from: b */
    private long[] f16823b;

    public zzph() {
        this(32);
    }

    public final void add(long j) {
        int i = this.f16822a;
        long[] jArr = this.f16823b;
        if (i == jArr.length) {
            this.f16823b = Arrays.copyOf(jArr, i << 1);
        }
        long[] jArr2 = this.f16823b;
        int i2 = this.f16822a;
        this.f16822a = i2 + 1;
        jArr2[i2] = j;
    }

    public final long get(int i) {
        if (i >= 0 && i < this.f16822a) {
            return this.f16823b[i];
        }
        int i2 = this.f16822a;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Invalid index ");
        sb.append(i);
        sb.append(", size is ");
        sb.append(i2);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final int size() {
        return this.f16822a;
    }

    private zzph(int i) {
        this.f16823b = new long[32];
    }
}
