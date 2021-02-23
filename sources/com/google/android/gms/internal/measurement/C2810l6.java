package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.l6 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2810l6 {
    /* access modifiers changed from: private */
    /* renamed from: f */
    public static void m9594f(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) {
        if (m9603o(b2) || (((b << 28) + (b2 + 112)) >> 30) != 0 || m9603o(b3) || m9603o(b4)) {
            throw zzih.m10394h();
        }
        byte b5 = ((b & 7) << 18) | ((b2 & 63) << 12) | ((b3 & 63) << 6) | (b4 & 63);
        cArr[i] = (char) ((b5 >>> 10) + 55232);
        cArr[i + 1] = (char) ((b5 & 1023) + 56320);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public static void m9595g(byte b, byte b2, byte b3, char[] cArr, int i) {
        if (m9603o(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || m9603o(b3)))) {
            throw zzih.m10394h();
        }
        cArr[i] = (char) (((b & 15) << 12) | ((b2 & 63) << 6) | (b3 & 63));
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public static void m9596h(byte b, byte b2, char[] cArr, int i) {
        if (b < -62 || m9603o(b2)) {
            throw zzih.m10394h();
        }
        cArr[i] = (char) (((b & 31) << 6) | (b2 & 63));
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public static void m9597i(byte b, char[] cArr, int i) {
        cArr[i] = (char) b;
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public static boolean m9600l(byte b) {
        return b >= 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public static boolean m9601m(byte b) {
        return b < -32;
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public static boolean m9602n(byte b) {
        return b < -16;
    }

    /* renamed from: o */
    private static boolean m9603o(byte b) {
        return b > -65;
    }
}
