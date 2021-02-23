package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class u70 extends t70 {
    u70(byte[] bArr, int i) {
        super(bArr, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final int[] mo13539e(int[] iArr, int i) {
        if (iArr.length == 3) {
            int[] iArr2 = new int[16];
            t70.m6989d(iArr2, this.f11140a);
            iArr2[12] = i;
            System.arraycopy(iArr, 0, iArr2, 13, iArr.length);
            return iArr2;
        }
        throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", new Object[]{Integer.valueOf(iArr.length << 5)}));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final int mo13540f() {
        return 12;
    }
}
