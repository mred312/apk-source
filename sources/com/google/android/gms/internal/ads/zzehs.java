package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzehs {

    /* renamed from: a */
    private final byte[] f16176a;

    private zzehs(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.f16176a = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i2);
    }

    public static zzehs zzr(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new zzehs(bArr, 0, bArr.length);
    }

    public final byte[] getBytes() {
        byte[] bArr = this.f16176a;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }
}
