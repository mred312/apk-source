package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.j6 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2794j6 {

    /* renamed from: a */
    private static final C2802k6 f17354a;

    static {
        C2802k6 k6Var;
        if (!(C2758f6.m9435m() && C2758f6.m9440r()) || C2723b3.m9321b()) {
            k6Var = new C2826n6();
        } else {
            k6Var = new C2842p6();
        }
        f17354a = k6Var;
    }

    /* renamed from: d */
    static int m9533d(CharSequence charSequence) {
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
                                throw new C2818m6(i2, length2);
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

    /* renamed from: e */
    static int m9534e(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return f17354a.mo18697b(charSequence, bArr, i, i2);
    }

    /* renamed from: f */
    public static boolean m9535f(byte[] bArr) {
        return f17354a.mo18698c(bArr, 0, bArr.length);
    }

    /* renamed from: g */
    public static boolean m9536g(byte[] bArr, int i, int i2) {
        return f17354a.mo18698c(bArr, i, i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public static int m9537h(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public static int m9538i(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public static int m9539j(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    /* renamed from: k */
    static String m9540k(byte[] bArr, int i, int i2) {
        return f17354a.mo18699d(bArr, i, i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public static int m9542m(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 == 0) {
            return m9537h(b);
        }
        if (i3 == 1) {
            return m9538i(b, bArr[i]);
        }
        if (i3 == 2) {
            return m9539j(b, bArr[i], bArr[i + 1]);
        }
        throw new AssertionError();
    }
}
