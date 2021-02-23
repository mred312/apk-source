package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class ve0 {

    /* renamed from: d */
    private static final long[] f11606d = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: a */
    private final byte[] f11607a = new byte[8];

    /* renamed from: b */
    private int f11608b;

    /* renamed from: c */
    private int f11609c;

    /* renamed from: c */
    public static long m7091c(byte[] bArr, int i, boolean z) {
        long j = ((long) bArr[0]) & 255;
        if (z) {
            j &= f11606d[i - 1] ^ -1;
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (((long) bArr[i2]) & 255);
        }
        return j;
    }

    /* renamed from: d */
    public static int m7092d(int i) {
        int i2 = 0;
        while (true) {
            long[] jArr = f11606d;
            if (i2 >= jArr.length) {
                return -1;
            }
            if ((jArr[i2] & ((long) i)) != 0) {
                return i2 + 1;
            }
            i2++;
        }
    }

    /* renamed from: a */
    public final void mo14933a() {
        this.f11608b = 0;
        this.f11609c = 0;
    }

    /* renamed from: b */
    public final long mo14934b(zzjz zzjz, boolean z, boolean z2, int i) {
        if (this.f11608b == 0) {
            if (!zzjz.zza(this.f11607a, 0, 1, z)) {
                return -1;
            }
            int d = m7092d(this.f11607a[0] & 255);
            this.f11609c = d;
            if (d != -1) {
                this.f11608b = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i2 = this.f11609c;
        if (i2 > i) {
            this.f11608b = 0;
            return -2;
        }
        if (i2 != 1) {
            zzjz.readFully(this.f11607a, 1, i2 - 1);
        }
        this.f11608b = 0;
        return m7091c(this.f11607a, this.f11609c, z2);
    }

    /* renamed from: e */
    public final int mo14935e() {
        return this.f11609c;
    }
}
