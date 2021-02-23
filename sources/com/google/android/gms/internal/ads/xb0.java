package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class xb0 {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public static void m7214a(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) {
        if (m7225l(b2) || (((b << 28) + (b2 + 112)) >> 30) != 0 || m7225l(b3) || m7225l(b4)) {
            throw zzeks.m8836i();
        }
        byte b5 = ((b & 7) << 18) | ((b2 & 63) << 12) | ((b3 & 63) << 6) | (b4 & 63);
        cArr[i] = (char) ((b5 >>> 10) + 55232);
        cArr[i + 1] = (char) ((b5 & 1023) + 56320);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m7215b(byte b, byte b2, byte b3, char[] cArr, int i) {
        if (m7225l(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || m7225l(b3)))) {
            throw zzeks.m8836i();
        }
        cArr[i] = (char) (((b & 15) << 12) | ((b2 & 63) << 6) | (b3 & 63));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m7216c(byte b, byte b2, char[] cArr, int i) {
        if (b < -62 || m7225l(b2)) {
            throw zzeks.m8836i();
        }
        cArr[i] = (char) (((b & 31) << 6) | (b2 & 63));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static void m7217d(byte b, char[] cArr, int i) {
        cArr[i] = (char) b;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public static boolean m7222i(byte b) {
        return b >= 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public static boolean m7223j(byte b) {
        return b < -32;
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public static boolean m7224k(byte b) {
        return b < -16;
    }

    /* renamed from: l */
    private static boolean m7225l(byte b) {
        return b > -65;
    }
}
