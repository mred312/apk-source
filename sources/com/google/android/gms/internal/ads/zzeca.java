package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzeca implements zzdzt {

    /* renamed from: b */
    private static final ThreadLocal<Cipher> f16117b = new j50();

    /* renamed from: a */
    private final SecretKey f16118a;

    public zzeca(byte[] bArr) {
        zzeic.zzft(bArr.length);
        this.f16118a = new SecretKeySpec(bArr, "AES");
    }

    /* renamed from: a */
    private static AlgorithmParameterSpec m8633a(byte[] bArr, int i, int i2) {
        try {
            Class.forName("javax.crypto.spec.GCMParameterSpec");
            return new GCMParameterSpec(128, bArr, 0, i2);
        } catch (ClassNotFoundException unused) {
            if (zzehz.zzbfe()) {
                return new IvParameterSpec(bArr, 0, i2);
            }
            throw new GeneralSecurityException("cannot use AES-GCM: javax.crypto.spec.GCMParameterSpec not found");
        }
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) {
        if (bArr.length <= 2147483619) {
            byte[] bArr3 = new byte[(bArr.length + 12 + 16)];
            byte[] zzfs = zzehx.zzfs(12);
            System.arraycopy(zzfs, 0, bArr3, 0, 12);
            AlgorithmParameterSpec a = m8633a(zzfs, 0, zzfs.length);
            ThreadLocal<Cipher> threadLocal = f16117b;
            threadLocal.get().init(1, this.f16118a, a);
            if (!(bArr2 == null || bArr2.length == 0)) {
                threadLocal.get().updateAAD(bArr2);
            }
            int doFinal = threadLocal.get().doFinal(bArr, 0, bArr.length, bArr3, 12);
            if (doFinal == bArr.length + 16) {
                return bArr3;
            }
            throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", new Object[]{16, Integer.valueOf(doFinal - bArr.length)}));
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
