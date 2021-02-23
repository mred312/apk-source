package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzpk {

    /* renamed from: a */
    private byte[] f16827a;

    /* renamed from: b */
    private int f16828b;

    /* renamed from: c */
    private int f16829c;

    /* renamed from: d */
    private int f16830d;

    public zzpk() {
    }

    public final int zzbh(int i) {
        int i2;
        int i3;
        byte b;
        byte b2;
        boolean z = false;
        if (i == 0) {
            return 0;
        }
        int i4 = i / 8;
        byte b3 = 0;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = this.f16829c;
            if (i6 != 0) {
                byte[] bArr = this.f16827a;
                int i7 = this.f16828b;
                b2 = ((bArr[i7 + 1] & 255) >>> (8 - i6)) | ((bArr[i7] & 255) << i6);
            } else {
                b2 = this.f16827a[this.f16828b];
            }
            i -= 8;
            b3 |= (255 & b2) << i;
            this.f16828b++;
        }
        if (i > 0) {
            int i8 = this.f16829c + i;
            byte b4 = (byte) (255 >> (8 - i));
            if (i8 > 8) {
                byte[] bArr2 = this.f16827a;
                int i9 = this.f16828b;
                b = (b4 & (((255 & bArr2[i9 + 1]) >> (16 - i8)) | ((bArr2[i9] & 255) << (i8 - 8)))) | b3;
                this.f16828b = i9 + 1;
            } else {
                byte[] bArr3 = this.f16827a;
                int i10 = this.f16828b;
                b = (b4 & ((255 & bArr3[i10]) >> (8 - i8))) | b3;
                if (i8 == 8) {
                    this.f16828b = i10 + 1;
                }
            }
            b3 = b;
            this.f16829c = i8 % 8;
        }
        int i11 = this.f16828b;
        if (i11 >= 0 && (i2 = this.f16829c) >= 0 && i2 < 8 && (i11 < (i3 = this.f16830d) || (i11 == i3 && i2 == 0))) {
            z = true;
        }
        zzpc.checkState(z);
        return b3;
    }

    public zzpk(byte[] bArr) {
        this(bArr, bArr.length);
    }

    private zzpk(byte[] bArr, int i) {
        this.f16827a = bArr;
        this.f16830d = i;
    }
}
