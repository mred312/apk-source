package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
abstract class t70 implements zzehr {

    /* renamed from: c */
    private static final int[] f11139c = m6991i(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});

    /* renamed from: a */
    int[] f11140a;

    /* renamed from: b */
    private final int f11141b;

    t70(byte[] bArr, int i) {
        if (bArr.length == 32) {
            this.f11140a = m6991i(bArr);
            this.f11141b = i;
            return;
        }
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }

    /* renamed from: a */
    private static int m6987a(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    /* renamed from: c */
    private static void m6988c(int[] iArr, int i, int i2, int i3, int i4) {
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = m6987a(iArr[i4] ^ iArr[i], 16);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = m6987a(iArr[i2] ^ iArr[i3], 12);
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = m6987a(iArr[i] ^ iArr[i4], 8);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = m6987a(iArr[i2] ^ iArr[i3], 7);
    }

    /* renamed from: d */
    static void m6989d(int[] iArr, int[] iArr2) {
        int[] iArr3 = f11139c;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, iArr3.length, 8);
    }

    /* renamed from: g */
    static void m6990g(int[] iArr) {
        int[] iArr2 = iArr;
        for (int i = 0; i < 10; i++) {
            m6988c(iArr2, 0, 4, 8, 12);
            m6988c(iArr2, 1, 5, 9, 13);
            m6988c(iArr2, 2, 6, 10, 14);
            m6988c(iArr2, 3, 7, 11, 15);
            m6988c(iArr2, 0, 5, 10, 15);
            m6988c(iArr2, 1, 6, 11, 12);
            m6988c(iArr2, 2, 7, 8, 13);
            m6988c(iArr2, 3, 4, 9, 14);
        }
    }

    /* renamed from: i */
    private static int[] m6991i(byte[] bArr) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo14828b(ByteBuffer byteBuffer, byte[] bArr) {
        if (byteBuffer.remaining() - mo13540f() >= bArr.length) {
            byte[] zzfs = zzehx.zzfs(mo13540f());
            byteBuffer.put(zzfs);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int remaining = wrap.remaining();
            int i = (remaining / 64) + 1;
            for (int i2 = 0; i2 < i; i2++) {
                ByteBuffer h = mo14829h(zzfs, this.f11141b + i2);
                if (i2 == i - 1) {
                    zzegr.zza(byteBuffer, wrap, h, remaining % 64);
                } else {
                    zzegr.zza(byteBuffer, wrap, h, 64);
                }
            }
            return;
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public abstract int[] mo13539e(int[] iArr, int i);

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public abstract int mo13540f();

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final ByteBuffer mo14829h(byte[] bArr, int i) {
        int[] e = mo13539e(m6991i(bArr), i);
        int[] iArr = (int[]) e.clone();
        m6990g(iArr);
        for (int i2 = 0; i2 < e.length; i2++) {
            e[i2] = e[i2] + iArr[i2];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(e, 0, 16);
        return order;
    }

    public final byte[] zzn(byte[] bArr) {
        if (bArr.length <= Integer.MAX_VALUE - mo13540f()) {
            ByteBuffer allocate = ByteBuffer.allocate(mo13540f() + bArr.length);
            mo14828b(allocate, bArr);
            return allocate.array();
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
