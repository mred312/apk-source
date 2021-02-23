package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.PriorityQueue;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzrz {
    @VisibleForTesting
    /* renamed from: a */
    private static long m9093a(long j, int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return j;
        }
        if (i % 2 == 0) {
            return m9093a((j * j) % 1073807359, i / 2) % 1073807359;
        }
        return (j * (m9093a((j * j) % 1073807359, i / 2) % 1073807359)) % 1073807359;
    }

    @VisibleForTesting
    /* renamed from: b */
    private static String m9094b(String[] strArr, int i, int i2) {
        int i3 = i2 + i;
        if (strArr.length < i3) {
            zzaza.zzey("Unable to construct shingle");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i4 = i3 - 1;
            if (i < i4) {
                sb.append(strArr[i]);
                sb.append(' ');
                i++;
            } else {
                sb.append(strArr[i4]);
                return sb.toString();
            }
        }
    }

    @VisibleForTesting
    /* renamed from: c */
    private static void m9095c(int i, long j, String str, int i2, PriorityQueue<zzry> priorityQueue) {
        zzry zzry = new zzry(j, str, i2);
        if ((priorityQueue.size() != i || (priorityQueue.peek().f16967c <= zzry.f16967c && priorityQueue.peek().f16965a <= zzry.f16965a)) && !priorityQueue.contains(zzry)) {
            priorityQueue.add(zzry);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    /* renamed from: d */
    private static long m9096d(String[] strArr, int i, int i2) {
        long zzbr = (((long) zzru.zzbr(strArr[0])) + 2147483647L) % 1073807359;
        for (int i3 = 1; i3 < i2; i3++) {
            zzbr = (((zzbr * 16785407) % 1073807359) + ((((long) zzru.zzbr(strArr[i3])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return zzbr;
    }

    public static void zza(String[] strArr, int i, int i2, PriorityQueue<zzry> priorityQueue) {
        String[] strArr2 = strArr;
        int i3 = i2;
        if (strArr2.length < i3) {
            m9095c(i, m9096d(strArr2, 0, strArr2.length), m9094b(strArr2, 0, strArr2.length), strArr2.length, priorityQueue);
            return;
        }
        long d = m9096d(strArr2, 0, i3);
        m9095c(i, d, m9094b(strArr2, 0, i3), i2, priorityQueue);
        long a = m9093a(16785407, i3 - 1);
        for (int i4 = 1; i4 < (strArr2.length - i3) + 1; i4++) {
            long j = d + 1073807359;
            d = (((((j - ((((((long) zzru.zzbr(strArr2[i4 - 1])) + 2147483647L) % 1073807359) * a) % 1073807359)) % 1073807359) * 16785407) % 1073807359) + ((((long) zzru.zzbr(strArr2[(i4 + i3) - 1])) + 2147483647L) % 1073807359)) % 1073807359;
            m9095c(i, d, m9094b(strArr2, i4, i3), strArr2.length, priorityQueue);
        }
    }
}
