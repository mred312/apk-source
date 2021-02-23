package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.measurement.i2 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2782i2 {
    /* renamed from: a */
    static int m9505a(int i, int i2, int i3) {
        return (i & (i3 ^ -1)) | (i2 & i3);
    }

    /* renamed from: b */
    static int m9506b(Object obj, int i) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i] & 255;
        }
        if (obj instanceof short[]) {
            return ((short[]) obj)[i] & 65535;
        }
        return ((int[]) obj)[i];
    }

    /* renamed from: c */
    static int m9507c(@NullableDecl Object obj, @NullableDecl Object obj2, int i, Object obj3, int[] iArr, Object[] objArr, @NullableDecl Object[] objArr2) {
        int i2;
        int i3;
        int b = C2790j2.m9520b(obj);
        int i4 = b & i;
        int b2 = m9506b(obj3, i4);
        if (b2 == 0) {
            return -1;
        }
        int i5 = i ^ -1;
        int i6 = b & i5;
        int i7 = -1;
        while (true) {
            i2 = b2 - 1;
            i3 = iArr[i2];
            if ((i3 & i5) != i6 || !zzdz.zza(obj, objArr[i2]) || (objArr2 != null && !zzdz.zza(obj2, objArr2[i2]))) {
                int i8 = i3 & i;
                if (i8 == 0) {
                    return -1;
                }
                int i9 = i8;
                i7 = i2;
                b2 = i9;
            }
        }
        int i10 = i3 & i;
        if (i7 == -1) {
            m9509e(obj3, i4, i10);
        } else {
            iArr[i7] = m9505a(iArr[i7], i10, i);
        }
        return i2;
    }

    /* renamed from: d */
    static Object m9508d(int i) {
        if (i < 2 || i > 1073741824 || Integer.highestOneBit(i) != i) {
            StringBuilder sb = new StringBuilder(52);
            sb.append("must be power of 2 between 2^1 and 2^30: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } else if (i <= 256) {
            return new byte[i];
        } else {
            if (i <= 65536) {
                return new short[i];
            }
            return new int[i];
        }
    }

    /* renamed from: e */
    static void m9509e(Object obj, int i, int i2) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i] = (byte) i2;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i] = (short) i2;
        } else {
            ((int[]) obj)[i] = i2;
        }
    }

    /* renamed from: f */
    static int m9510f(int i) {
        return (i < 32 ? 4 : 2) * (i + 1);
    }
}
