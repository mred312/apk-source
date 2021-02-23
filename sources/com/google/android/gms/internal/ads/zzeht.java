package com.google.android.gms.internal.ads;

import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzeht implements zzedb {

    /* renamed from: a */
    private final SecretKey f16177a;

    /* renamed from: b */
    private byte[] f16178b;

    /* renamed from: c */
    private byte[] f16179c;

    public zzeht(byte[] bArr) {
        zzeic.zzft(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.f16177a = secretKeySpec;
        Cipher a = m8776a();
        a.init(1, secretKeySpec);
        byte[] a2 = s70.m6833a(a.doFinal(new byte[16]));
        this.f16178b = a2;
        this.f16179c = s70.m6833a(a2);
    }

    /* renamed from: a */
    private static Cipher m8776a() {
        return zzehh.zzihd.zzhq("AES/ECB/NoPadding");
    }

    public final byte[] zzd(byte[] bArr, int i) {
        byte[] bArr2;
        if (i <= 16) {
            Cipher a = m8776a();
            a.init(1, this.f16177a);
            double length = (double) bArr.length;
            Double.isNaN(length);
            int max = Math.max(1, (int) Math.ceil(length / 16.0d));
            if ((max << 4) == bArr.length) {
                bArr2 = zzegr.zza(bArr, (max - 1) << 4, this.f16178b, 0, 16);
            } else {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, (max - 1) << 4, bArr.length);
                if (copyOfRange.length < 16) {
                    byte[] copyOf = Arrays.copyOf(copyOfRange, 16);
                    copyOf[copyOfRange.length] = Byte.MIN_VALUE;
                    bArr2 = zzegr.zzd(copyOf, this.f16179c);
                } else {
                    throw new IllegalArgumentException("x must be smaller than a block.");
                }
            }
            byte[] bArr3 = new byte[16];
            for (int i2 = 0; i2 < max - 1; i2++) {
                bArr3 = a.doFinal(zzegr.zza(bArr3, 0, bArr, i2 << 4, 16));
            }
            return Arrays.copyOf(a.doFinal(zzegr.zzd(bArr2, bArr3)), i);
        }
        throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
    }
}
