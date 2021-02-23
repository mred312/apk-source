package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzegk implements zzehr {

    /* renamed from: d */
    private static final ThreadLocal<Cipher> f16142d = new o70();

    /* renamed from: a */
    private final SecretKeySpec f16143a;

    /* renamed from: b */
    private final int f16144b;

    /* renamed from: c */
    private final int f16145c;

    public zzegk(byte[] bArr, int i) {
        zzeic.zzft(bArr.length);
        this.f16143a = new SecretKeySpec(bArr, "AES");
        int blockSize = f16142d.get().getBlockSize();
        this.f16145c = blockSize;
        if (i < 12 || i > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.f16144b = i;
    }

    public final byte[] zzn(byte[] bArr) {
        int length = bArr.length;
        int i = this.f16144b;
        if (length <= Integer.MAX_VALUE - i) {
            byte[] bArr2 = new byte[(bArr.length + i)];
            byte[] zzfs = zzehx.zzfs(i);
            System.arraycopy(zzfs, 0, bArr2, 0, this.f16144b);
            int length2 = bArr.length;
            int i2 = this.f16144b;
            Cipher cipher = f16142d.get();
            byte[] bArr3 = new byte[this.f16145c];
            System.arraycopy(zzfs, 0, bArr3, 0, this.f16144b);
            cipher.init(1, this.f16143a, new IvParameterSpec(bArr3));
            if (cipher.doFinal(bArr, 0, length2, bArr2, i2) == length2) {
                return bArr2;
            }
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
        StringBuilder sb = new StringBuilder(43);
        sb.append("plaintext length can not exceed ");
        sb.append(Integer.MAX_VALUE - this.f16144b);
        throw new GeneralSecurityException(sb.toString());
    }
}
