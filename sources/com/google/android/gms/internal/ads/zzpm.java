package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzpm {

    /* renamed from: a */
    private byte[] f16831a;

    /* renamed from: b */
    private int f16832b;

    /* renamed from: c */
    private int f16833c;

    /* renamed from: d */
    private int f16834d = 0;

    public zzpm(byte[] bArr, int i, int i2) {
        this.f16831a = bArr;
        this.f16833c = i;
        this.f16832b = i2;
        m9048c();
    }

    /* renamed from: a */
    private final boolean m9046a(int i) {
        if (2 > i || i >= this.f16832b) {
            return false;
        }
        byte[] bArr = this.f16831a;
        return bArr[i] == 3 && bArr[i + -2] == 0 && bArr[i - 1] == 0;
    }

    /* renamed from: b */
    private final int m9047b() {
        int i = 0;
        int i2 = 0;
        while (!zziv()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = zzbh(i2);
        }
        return i3 + i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r3.f16834d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000c, code lost:
        r2 = r3.f16832b;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m9048c() {
        /*
            r3 = this;
            int r0 = r3.f16833c
            if (r0 < 0) goto L_0x0016
            int r1 = r3.f16834d
            if (r1 < 0) goto L_0x0016
            r2 = 8
            if (r1 >= r2) goto L_0x0016
            int r2 = r3.f16832b
            if (r0 < r2) goto L_0x0014
            if (r0 != r2) goto L_0x0016
            if (r1 != 0) goto L_0x0016
        L_0x0014:
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            com.google.android.gms.internal.ads.zzpc.checkState(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpm.m9048c():void");
    }

    public final int zzbh(int i) {
        byte b;
        byte b2;
        if (i == 0) {
            return 0;
        }
        int i2 = i / 8;
        byte b3 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = m9046a(this.f16833c + 1) ? this.f16833c + 2 : this.f16833c + 1;
            int i5 = this.f16834d;
            if (i5 != 0) {
                byte[] bArr = this.f16831a;
                b2 = ((bArr[i4] & 255) >>> (8 - i5)) | ((bArr[this.f16833c] & 255) << i5);
            } else {
                b2 = this.f16831a[this.f16833c];
            }
            i -= 8;
            b3 |= (255 & b2) << i;
            this.f16833c = i4;
        }
        if (i > 0) {
            int i6 = this.f16834d + i;
            byte b4 = (byte) (255 >> (8 - i));
            int i7 = m9046a(this.f16833c + 1) ? this.f16833c + 2 : this.f16833c + 1;
            if (i6 > 8) {
                byte[] bArr2 = this.f16831a;
                b = (b4 & (((255 & bArr2[i7]) >> (16 - i6)) | ((bArr2[this.f16833c] & 255) << (i6 - 8)))) | b3;
                this.f16833c = i7;
            } else {
                b = (b4 & ((255 & this.f16831a[this.f16833c]) >> (8 - i6))) | b3;
                if (i6 == 8) {
                    this.f16833c = i7;
                }
            }
            b3 = b;
            this.f16834d = i6 % 8;
        }
        m9048c();
        return b3;
    }

    public final void zzbi(int i) {
        int i2 = this.f16833c;
        int i3 = (i / 8) + i2;
        this.f16833c = i3;
        int i4 = this.f16834d + (i % 8);
        this.f16834d = i4;
        if (i4 > 7) {
            this.f16833c = i3 + 1;
            this.f16834d = i4 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.f16833c) {
                m9048c();
                return;
            } else if (m9046a(i2)) {
                this.f16833c++;
                i2 += 2;
            }
        }
    }

    public final boolean zziv() {
        return zzbh(1) == 1;
    }

    public final int zziw() {
        return m9047b();
    }

    public final int zzix() {
        int b = m9047b();
        return (b % 2 == 0 ? -1 : 1) * ((b + 1) / 2);
    }
}
