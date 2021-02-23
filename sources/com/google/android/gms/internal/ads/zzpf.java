package com.google.android.gms.internal.ads;

import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzpf {

    /* renamed from: a */
    private static final byte[] f16819a = {0, 0, 0, 1};

    /* renamed from: b */
    private static final int[] f16820b = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* renamed from: c */
    private static final int[] f16821c = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    /* renamed from: a */
    private static int m9043a(zzpk zzpk) {
        int zzbh = zzpk.zzbh(5);
        return zzbh == 31 ? zzpk.zzbh(6) + 32 : zzbh;
    }

    /* renamed from: b */
    private static int m9044b(zzpk zzpk) {
        int zzbh = zzpk.zzbh(4);
        if (zzbh == 15) {
            return zzpk.zzbh(24);
        }
        zzpc.checkArgument(zzbh < 13);
        return f16820b[zzbh];
    }

    public static byte[] zzc(byte[] bArr, int i, int i2) {
        byte[] bArr2 = f16819a;
        byte[] bArr3 = new byte[(bArr2.length + i2)];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, bArr2.length, i2);
        return bArr3;
    }

    public static Pair<Integer, Integer> zze(byte[] bArr) {
        zzpk zzpk = new zzpk(bArr);
        int a = m9043a(zzpk);
        int b = m9044b(zzpk);
        int zzbh = zzpk.zzbh(4);
        if (a == 5 || a == 29) {
            b = m9044b(zzpk);
            if (m9043a(zzpk) == 22) {
                zzbh = zzpk.zzbh(4);
            }
        }
        int i = f16821c[zzbh];
        zzpc.checkArgument(i != -1);
        return Pair.create(Integer.valueOf(b), Integer.valueOf(i));
    }
}
