package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzegl implements zzdzt {

    /* renamed from: e */
    private static final ThreadLocal<Cipher> f16146e = new q70();

    /* renamed from: f */
    private static final ThreadLocal<Cipher> f16147f = new p70();

    /* renamed from: a */
    private final byte[] f16148a;

    /* renamed from: b */
    private final byte[] f16149b;

    /* renamed from: c */
    private final SecretKeySpec f16150c;

    /* renamed from: d */
    private final int f16151d;

    public zzegl(byte[] bArr, int i) {
        if (i == 12 || i == 16) {
            this.f16151d = i;
            zzeic.zzft(bArr.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            this.f16150c = secretKeySpec;
            Cipher cipher = f16146e.get();
            cipher.init(1, secretKeySpec);
            byte[] c = m8770c(cipher.doFinal(new byte[16]));
            this.f16148a = c;
            this.f16149b = m8770c(c);
            return;
        }
        throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
    }

    /* renamed from: a */
    private final byte[] m8768a(Cipher cipher, int i, byte[] bArr, int i2, int i3) {
        byte[] bArr2;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i;
        if (i3 == 0) {
            return cipher.doFinal(m8769b(bArr3, this.f16148a));
        }
        byte[] doFinal = cipher.doFinal(bArr3);
        int i4 = 0;
        while (i3 - i4 > 16) {
            for (int i5 = 0; i5 < 16; i5++) {
                doFinal[i5] = (byte) (doFinal[i5] ^ bArr[(i2 + i4) + i5]);
            }
            doFinal = cipher.doFinal(doFinal);
            i4 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i4 + i2, i2 + i3);
        if (copyOfRange.length == 16) {
            bArr2 = m8769b(copyOfRange, this.f16148a);
        } else {
            byte[] copyOf = Arrays.copyOf(this.f16149b, 16);
            for (int i6 = 0; i6 < copyOfRange.length; i6++) {
                copyOf[i6] = (byte) (copyOf[i6] ^ copyOfRange[i6]);
            }
            copyOf[copyOfRange.length] = (byte) (copyOf[copyOfRange.length] ^ 128);
            bArr2 = copyOf;
        }
        return cipher.doFinal(m8769b(doFinal, bArr2));
    }

    /* renamed from: b */
    private static byte[] m8769b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    /* renamed from: c */
    private static byte[] m8770c(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        int i2 = 0;
        while (i2 < 15) {
            int i3 = i2 + 1;
            bArr2[i2] = (byte) ((bArr[i2] << 1) ^ ((bArr[i3] & 255) >>> 7));
            i2 = i3;
        }
        int i4 = bArr[15] << 1;
        if ((bArr[0] & 128) != 0) {
            i = 135;
        }
        bArr2[15] = (byte) (i4 ^ i);
        return bArr2;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        int length = bArr3.length;
        int i = this.f16151d;
        if (length <= (Integer.MAX_VALUE - i) - 16) {
            byte[] bArr4 = new byte[(bArr3.length + i + 16)];
            byte[] zzfs = zzehx.zzfs(i);
            System.arraycopy(zzfs, 0, bArr4, 0, this.f16151d);
            Cipher cipher = f16146e.get();
            cipher.init(1, this.f16150c);
            byte[] a = m8768a(cipher, 0, zzfs, 0, zzfs.length);
            byte[] bArr5 = bArr2 == null ? new byte[0] : bArr2;
            byte[] a2 = m8768a(cipher, 1, bArr5, 0, bArr5.length);
            Cipher cipher2 = f16147f.get();
            cipher2.init(1, this.f16150c, new IvParameterSpec(a));
            cipher2.doFinal(bArr, 0, bArr3.length, bArr4, this.f16151d);
            byte[] a3 = m8768a(cipher, 2, bArr4, this.f16151d, bArr3.length);
            int length2 = bArr3.length + this.f16151d;
            for (int i2 = 0; i2 < 16; i2++) {
                bArr4[length2 + i2] = (byte) ((a2[i2] ^ a[i2]) ^ a3[i2]);
            }
            return bArr4;
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
