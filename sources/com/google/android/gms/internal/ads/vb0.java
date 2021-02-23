package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class vb0 {

    /* renamed from: a */
    private static final wb0 f11594a;

    static {
        wb0 wb0;
        if (!(sb0.m6918m() && sb0.m6919n()) || i80.m6313a()) {
            wb0 = new zb0();
        } else {
            wb0 = new bc0();
        }
        f11594a = wb0;
    }

    /* renamed from: a */
    static int m7076a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return f11594a.mo13672b(charSequence, bArr, i, i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m7077b(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    /* renamed from: d */
    public static int m7079d(int i, byte[] bArr, int i2, int i3) {
        return f11594a.mo13671a(i, bArr, i2, i3);
    }

    /* renamed from: e */
    static int m7080e(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) >= 65536) {
                                i2++;
                            } else {
                                throw new yb0(i2, length2);
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(((long) i3) + 4294967296L);
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static int m7081f(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public static int m7083h(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    /* renamed from: j */
    public static boolean m7085j(byte[] bArr, int i, int i2) {
        return f11594a.mo14973c(bArr, i, i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public static int m7086k(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 == 0) {
            return m7081f(b);
        }
        if (i3 == 1) {
            return m7077b(b, bArr[i]);
        }
        if (i3 == 2) {
            return m7083h(b, bArr[i], bArr[i + 1]);
        }
        throw new AssertionError();
    }

    /* renamed from: l */
    static String m7087l(byte[] bArr, int i, int i2) {
        return f11594a.mo13673d(bArr, i, i2);
    }

    /* renamed from: n */
    public static boolean m7089n(byte[] bArr) {
        return f11594a.mo14973c(bArr, 0, bArr.length);
    }
}
