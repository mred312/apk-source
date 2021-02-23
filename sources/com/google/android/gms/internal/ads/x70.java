package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class x70 {
    /* renamed from: a */
    private static void m7157a(byte[] bArr, long j, int i) {
        int i2 = 0;
        while (i2 < 4) {
            bArr[i + i2] = (byte) ((int) (255 & j));
            i2++;
            j >>= 8;
        }
    }

    /* renamed from: b */
    static byte[] m7158b(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        if (bArr3.length == 32) {
            long d = m7160d(bArr3, 0, 0) & 67108863;
            int i = 3;
            long d2 = m7160d(bArr3, 3, 2) & 67108611;
            long d3 = m7160d(bArr3, 6, 4) & 67092735;
            long d4 = m7160d(bArr3, 9, 6) & 66076671;
            long d5 = m7160d(bArr3, 12, 8) & 1048575;
            long j = d2 * 5;
            long j2 = d3 * 5;
            long j3 = d4 * 5;
            long j4 = d5 * 5;
            int i2 = 17;
            byte[] bArr5 = new byte[17];
            long j5 = 0;
            long j6 = 0;
            long j7 = 0;
            long j8 = 0;
            long j9 = 0;
            int i3 = 0;
            while (i3 < bArr4.length) {
                int min = Math.min(16, bArr4.length - i3);
                System.arraycopy(bArr4, i3, bArr5, 0, min);
                bArr5[min] = 1;
                if (min != 16) {
                    Arrays.fill(bArr5, min + 1, i2, (byte) 0);
                }
                long d6 = j9 + m7160d(bArr5, 0, 0);
                long d7 = j5 + m7160d(bArr5, i, 2);
                long d8 = j6 + m7160d(bArr5, 6, 4);
                long d9 = j7 + m7160d(bArr5, 9, 6);
                long d10 = j8 + (m7160d(bArr5, 12, 8) | ((long) (bArr5[16] << 24)));
                long j10 = (d6 * d) + (d7 * j4) + (d8 * j3) + (d9 * j2) + (d10 * j);
                long j11 = (d6 * d2) + (d7 * d) + (d8 * j4) + (d9 * j3) + (d10 * j2) + (j10 >> 26);
                long j12 = (d6 * d3) + (d7 * d2) + (d8 * d) + (d9 * j4) + (d10 * j3) + (j11 >> 26);
                long j13 = (d6 * d4) + (d7 * d3) + (d8 * d2) + (d9 * d) + (d10 * j4) + (j12 >> 26);
                long j14 = (d6 * d5) + (d7 * d4) + (d8 * d3) + (d9 * d2) + (d10 * d) + (j13 >> 26);
                long j15 = (j10 & 67108863) + ((j14 >> 26) * 5);
                j5 = (j11 & 67108863) + (j15 >> 26);
                i3 += 16;
                j6 = j12 & 67108863;
                j7 = j13 & 67108863;
                j8 = j14 & 67108863;
                i2 = 17;
                i = 3;
                j9 = j15 & 67108863;
            }
            long j16 = j6 + (j5 >> 26);
            long j17 = j16 & 67108863;
            long j18 = j7 + (j16 >> 26);
            long j19 = j18 & 67108863;
            long j20 = j8 + (j18 >> 26);
            long j21 = j20 & 67108863;
            long j22 = j9 + ((j20 >> 26) * 5);
            long j23 = j22 & 67108863;
            long j24 = (j5 & 67108863) + (j22 >> 26);
            long j25 = j23 + 5;
            long j26 = j25 & 67108863;
            long j27 = (j25 >> 26) + j24;
            long j28 = j17 + (j27 >> 26);
            long j29 = j19 + (j28 >> 26);
            long j30 = j29 & 67108863;
            long j31 = (j21 + (j29 >> 26)) - 67108864;
            long j32 = j31 >> 63;
            long j33 = j23 & j32;
            long j34 = j24 & j32;
            long j35 = j17 & j32;
            long j36 = j19 & j32;
            long j37 = j21 & j32;
            long j38 = j32 ^ -1;
            long j39 = (j27 & 67108863 & j38) | j34;
            long j40 = (j28 & 67108863 & j38) | j35;
            long j41 = (j30 & j38) | j36;
            long j42 = (j31 & j38) | j37;
            long c = (((j39 << 26) | j33 | (j26 & j38)) & 4294967295L) + m7159c(bArr3, 16);
            long c2 = (((j39 >> 6) | (j40 << 20)) & 4294967295L) + m7159c(bArr3, 20) + (c >> 32);
            long c3 = (((j40 >> 12) | (j41 << 14)) & 4294967295L) + m7159c(bArr3, 24) + (c2 >> 32);
            byte[] bArr6 = new byte[16];
            m7157a(bArr6, c & 4294967295L, 0);
            m7157a(bArr6, c2 & 4294967295L, 4);
            m7157a(bArr6, c3 & 4294967295L, 8);
            m7157a(bArr6, ((((j41 >> 18) | (j42 << 8)) & 4294967295L) + m7159c(bArr3, 28) + (c3 >> 32)) & 4294967295L, 12);
            return bArr6;
        }
        throw new IllegalArgumentException("The key length in bytes must be 32.");
    }

    /* renamed from: c */
    private static long m7159c(byte[] bArr, int i) {
        return ((long) (((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16))) & 4294967295L;
    }

    /* renamed from: d */
    private static long m7160d(byte[] bArr, int i, int i2) {
        return (m7159c(bArr, i) >> i2) & 67108863;
    }
}
