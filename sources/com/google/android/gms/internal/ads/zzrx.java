package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzrx extends zzrq {

    /* renamed from: b */
    private MessageDigest f16964b;

    public final byte[] zzbp(String str) {
        byte[] bArr;
        byte[] bArr2;
        String[] split = str.split(" ");
        int i = 4;
        if (split.length == 1) {
            int zzbr = zzru.zzbr(split[0]);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(zzbr);
            bArr = allocate.array();
        } else {
            if (split.length < 5) {
                bArr2 = new byte[(split.length << 1)];
                for (int i2 = 0; i2 < split.length; i2++) {
                    int zzbr2 = zzru.zzbr(split[i2]);
                    int i3 = (zzbr2 >> 16) ^ (65535 & zzbr2);
                    byte[] bArr3 = {(byte) i3, (byte) (i3 >> 8)};
                    int i4 = i2 << 1;
                    bArr2[i4] = bArr3[0];
                    bArr2[i4 + 1] = bArr3[1];
                }
            } else {
                bArr2 = new byte[split.length];
                for (int i5 = 0; i5 < split.length; i5++) {
                    int zzbr3 = zzru.zzbr(split[i5]);
                    bArr2[i5] = (byte) ((zzbr3 >> 24) ^ (((zzbr3 & 255) ^ ((zzbr3 >> 8) & 255)) ^ ((zzbr3 >> 16) & 255)));
                }
            }
            bArr = bArr2;
        }
        this.f16964b = zzmm();
        synchronized (this.mLock) {
            MessageDigest messageDigest = this.f16964b;
            if (messageDigest == null) {
                byte[] bArr4 = new byte[0];
                return bArr4;
            }
            messageDigest.reset();
            this.f16964b.update(bArr);
            byte[] digest = this.f16964b.digest();
            if (digest.length <= 4) {
                i = digest.length;
            }
            byte[] bArr5 = new byte[i];
            System.arraycopy(digest, 0, bArr5, 0, i);
            return bArr5;
        }
    }
}
