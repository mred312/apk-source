package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzeil {

    /* renamed from: a */
    private final byte[] f16188a = new byte[256];

    /* renamed from: b */
    private int f16189b;

    /* renamed from: c */
    private int f16190c;

    public zzeil(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.f16188a[i] = (byte) i;
        }
        byte b = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            byte[] bArr2 = this.f16188a;
            b = (b + bArr2[i2] + bArr[i2 % bArr.length]) & 255;
            byte b2 = bArr2[i2];
            bArr2[i2] = bArr2[b];
            bArr2[b] = b2;
        }
        this.f16189b = 0;
        this.f16190c = 0;
    }

    public final void zzs(byte[] bArr) {
        int i = this.f16189b;
        int i2 = this.f16190c;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            byte[] bArr2 = this.f16188a;
            i2 = (i2 + bArr2[i]) & 255;
            byte b = bArr2[i];
            bArr2[i] = bArr2[i2];
            bArr2[i2] = b;
            bArr[i3] = (byte) (bArr2[(bArr2[i] + bArr2[i2]) & 255] ^ bArr[i3]);
        }
        this.f16189b = i;
        this.f16190c = i2;
    }
}
