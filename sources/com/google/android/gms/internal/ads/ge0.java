package com.google.android.gms.internal.ads;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class ge0 {

    /* renamed from: a */
    private final int f8744a;

    /* renamed from: b */
    private final int f8745b;

    /* renamed from: c */
    private final int f8746c;

    /* renamed from: d */
    private final int f8747d;

    /* renamed from: e */
    private final int f8748e;

    /* renamed from: f */
    private final short[] f8749f;

    /* renamed from: g */
    private int f8750g;

    /* renamed from: h */
    private short[] f8751h;

    /* renamed from: i */
    private int f8752i;

    /* renamed from: j */
    private short[] f8753j;

    /* renamed from: k */
    private int f8754k;

    /* renamed from: l */
    private short[] f8755l;

    /* renamed from: m */
    private int f8756m = 0;

    /* renamed from: n */
    private int f8757n = 0;

    /* renamed from: o */
    private float f8758o = 1.0f;

    /* renamed from: p */
    private float f8759p = 1.0f;

    /* renamed from: q */
    private int f8760q;

    /* renamed from: r */
    private int f8761r;

    /* renamed from: s */
    private int f8762s;

    /* renamed from: t */
    private int f8763t;

    /* renamed from: u */
    private int f8764u = 0;

    /* renamed from: v */
    private int f8765v;

    /* renamed from: w */
    private int f8766w;

    /* renamed from: x */
    private int f8767x;

    public ge0(int i, int i2) {
        this.f8744a = i;
        this.f8745b = i2;
        this.f8746c = i / 400;
        int i3 = i / 65;
        this.f8747d = i3;
        int i4 = i3 * 2;
        this.f8748e = i4;
        this.f8749f = new short[i4];
        this.f8750g = i4;
        this.f8751h = new short[(i4 * i2)];
        this.f8752i = i4;
        this.f8753j = new short[(i4 * i2)];
        this.f8754k = i4;
        this.f8755l = new short[(i4 * i2)];
    }

    /* renamed from: b */
    private final int m6083b(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.f8745b;
        int i5 = 1;
        int i6 = 255;
        int i7 = 0;
        int i8 = 0;
        while (i2 <= i3) {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                short s = sArr[i4 + i10];
                short s2 = sArr[i4 + i2 + i10];
                i9 += s >= s2 ? s - s2 : s2 - s;
            }
            if (i9 * i7 < i5 * i2) {
                i7 = i2;
                i5 = i9;
            }
            if (i9 * i6 > i8 * i2) {
                i6 = i2;
                i8 = i9;
            }
            i2++;
        }
        this.f8766w = i5 / i7;
        this.f8767x = i8 / i6;
        return i7;
    }

    /* renamed from: c */
    private static void m6084c(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i3 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i4 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i7] = (short) (((sArr2[i9] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i7 += i2;
                i9 += i2;
                i8 += i2;
            }
        }
    }

    /* renamed from: e */
    private final void m6085e(short[] sArr, int i, int i2) {
        m6088l(i2);
        int i3 = this.f8745b;
        System.arraycopy(sArr, i * i3, this.f8753j, this.f8761r * i3, i3 * i2);
        this.f8761r += i2;
    }

    /* renamed from: g */
    private final void m6086g(short[] sArr, int i, int i2) {
        int i3 = this.f8748e / i2;
        int i4 = this.f8745b;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.f8749f[i7] = (short) (i8 / i5);
        }
    }

    /* renamed from: k */
    private final void m6087k() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = this.f8761r;
        float f = this.f8758o / this.f8759p;
        double d = (double) f;
        int i8 = 1;
        if (d > 1.00001d || d < 0.99999d) {
            int i9 = this.f8760q;
            if (i9 >= this.f8748e) {
                int i10 = 0;
                while (true) {
                    int i11 = this.f8763t;
                    if (i11 > 0) {
                        int min = Math.min(this.f8748e, i11);
                        m6085e(this.f8751h, i10, min);
                        this.f8763t -= min;
                        i10 += min;
                    } else {
                        short[] sArr = this.f8751h;
                        int i12 = this.f8744a;
                        int i13 = i12 > 4000 ? i12 / 4000 : 1;
                        if (this.f8745b == i8 && i13 == i8) {
                            i4 = m6083b(sArr, i10, this.f8746c, this.f8747d);
                        } else {
                            m6086g(sArr, i10, i13);
                            int b = m6083b(this.f8749f, 0, this.f8746c / i13, this.f8747d / i13);
                            if (i13 != i8) {
                                int i14 = b * i13;
                                int i15 = i13 << 2;
                                int i16 = i14 - i15;
                                int i17 = i14 + i15;
                                int i18 = this.f8746c;
                                if (i16 < i18) {
                                    i16 = i18;
                                }
                                int i19 = this.f8747d;
                                if (i17 > i19) {
                                    i17 = i19;
                                }
                                if (this.f8745b == i8) {
                                    i4 = m6083b(sArr, i10, i16, i17);
                                } else {
                                    m6086g(sArr, i10, i8);
                                    i4 = m6083b(this.f8749f, 0, i16, i17);
                                }
                            } else {
                                i4 = b;
                            }
                        }
                        int i20 = this.f8766w;
                        int i21 = i20 != 0 && this.f8764u != 0 && this.f8767x <= i20 * 3 && (i20 << 1) > this.f8765v * 3 ? this.f8764u : i4;
                        this.f8765v = i20;
                        this.f8764u = i4;
                        if (d > 1.0d) {
                            short[] sArr2 = this.f8751h;
                            if (f >= 2.0f) {
                                i6 = (int) (((float) i21) / (f - 1.0f));
                            } else {
                                this.f8763t = (int) ((((float) i21) * (2.0f - f)) / (f - 1.0f));
                                i6 = i21;
                            }
                            m6088l(i6);
                            int i22 = i6;
                            m6084c(i6, this.f8745b, this.f8753j, this.f8761r, sArr2, i10, sArr2, i10 + i21);
                            this.f8761r += i22;
                            i10 += i21 + i22;
                        } else {
                            int i23 = i21;
                            short[] sArr3 = this.f8751h;
                            if (f < 0.5f) {
                                i5 = (int) ((((float) i23) * f) / (1.0f - f));
                            } else {
                                this.f8763t = (int) ((((float) i23) * ((2.0f * f) - 1.0f)) / (1.0f - f));
                                i5 = i23;
                            }
                            int i24 = i23 + i5;
                            m6088l(i24);
                            int i25 = this.f8745b;
                            System.arraycopy(sArr3, i10 * i25, this.f8753j, this.f8761r * i25, i25 * i23);
                            m6084c(i5, this.f8745b, this.f8753j, this.f8761r + i23, sArr3, i23 + i10, sArr3, i10);
                            this.f8761r += i24;
                            i10 += i5;
                        }
                    }
                    if (this.f8748e + i10 > i9) {
                        break;
                    }
                    i8 = 1;
                }
                int i26 = this.f8760q - i10;
                short[] sArr4 = this.f8751h;
                int i27 = this.f8745b;
                System.arraycopy(sArr4, i10 * i27, sArr4, 0, i27 * i26);
                this.f8760q = i26;
            }
        } else {
            m6085e(this.f8751h, 0, this.f8760q);
            this.f8760q = 0;
        }
        float f2 = this.f8759p;
        if (f2 != 1.0f && this.f8761r != i7) {
            int i28 = this.f8744a;
            int i29 = (int) (((float) i28) / f2);
            while (true) {
                if (i29 <= 16384 && i28 <= 16384) {
                    break;
                }
                i29 /= 2;
                i28 /= 2;
            }
            int i30 = this.f8761r - i7;
            int i31 = this.f8762s + i30;
            int i32 = this.f8754k;
            if (i31 > i32) {
                int i33 = i32 + (i32 / 2) + i30;
                this.f8754k = i33;
                this.f8755l = Arrays.copyOf(this.f8755l, i33 * this.f8745b);
            }
            short[] sArr5 = this.f8753j;
            int i34 = this.f8745b;
            System.arraycopy(sArr5, i7 * i34, this.f8755l, this.f8762s * i34, i34 * i30);
            this.f8761r = i7;
            this.f8762s += i30;
            int i35 = 0;
            while (true) {
                i = this.f8762s;
                if (i35 >= i - 1) {
                    break;
                }
                while (true) {
                    i2 = this.f8756m;
                    int i36 = (i2 + 1) * i29;
                    i3 = this.f8757n;
                    if (i36 <= i3 * i28) {
                        break;
                    }
                    m6088l(1);
                    int i37 = 0;
                    while (true) {
                        int i38 = this.f8745b;
                        if (i37 >= i38) {
                            break;
                        }
                        short[] sArr6 = this.f8755l;
                        int i39 = (i35 * i38) + i37;
                        short s = sArr6[i39];
                        short s2 = sArr6[i39 + i38];
                        int i40 = this.f8756m;
                        int i41 = i40 * i29;
                        int i42 = (i40 + 1) * i29;
                        int i43 = i42 - (this.f8757n * i28);
                        int i44 = i42 - i41;
                        this.f8753j[(this.f8761r * i38) + i37] = (short) (((s * i43) + ((i44 - i43) * s2)) / i44);
                        i37++;
                    }
                    this.f8757n++;
                    this.f8761r++;
                }
                int i45 = i2 + 1;
                this.f8756m = i45;
                if (i45 == i28) {
                    this.f8756m = 0;
                    zzpc.checkState(i3 == i29);
                    this.f8757n = 0;
                }
                i35++;
            }
            int i46 = i - 1;
            if (i46 != 0) {
                short[] sArr7 = this.f8755l;
                int i47 = this.f8745b;
                System.arraycopy(sArr7, i46 * i47, sArr7, 0, (i - i46) * i47);
                this.f8762s -= i46;
            }
        }
    }

    /* renamed from: l */
    private final void m6088l(int i) {
        int i2 = this.f8761r + i;
        int i3 = this.f8752i;
        if (i2 > i3) {
            int i4 = i3 + (i3 / 2) + i;
            this.f8752i = i4;
            this.f8753j = Arrays.copyOf(this.f8753j, i4 * this.f8745b);
        }
    }

    /* renamed from: m */
    private final void m6089m(int i) {
        int i2 = this.f8760q + i;
        int i3 = this.f8750g;
        if (i2 > i3) {
            int i4 = i3 + (i3 / 2) + i;
            this.f8750g = i4;
            this.f8751h = Arrays.copyOf(this.f8751h, i4 * this.f8745b);
        }
    }

    /* renamed from: a */
    public final void mo14042a(float f) {
        this.f8758o = f;
    }

    /* renamed from: d */
    public final void mo14043d(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i = this.f8745b;
        int i2 = remaining / i;
        m6089m(i2);
        shortBuffer.get(this.f8751h, this.f8760q * this.f8745b, ((i * i2) << 1) / 2);
        this.f8760q += i2;
        m6087k();
    }

    /* renamed from: f */
    public final void mo14044f(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.f8745b, this.f8761r);
        shortBuffer.put(this.f8753j, 0, this.f8745b * min);
        int i = this.f8761r - min;
        this.f8761r = i;
        short[] sArr = this.f8753j;
        int i2 = this.f8745b;
        System.arraycopy(sArr, min * i2, sArr, 0, i * i2);
    }

    /* renamed from: h */
    public final void mo14045h(float f) {
        this.f8759p = f;
    }

    /* renamed from: i */
    public final void mo14046i() {
        int i;
        int i2 = this.f8760q;
        float f = this.f8758o;
        float f2 = this.f8759p;
        int i3 = this.f8761r + ((int) ((((((float) i2) / (f / f2)) + ((float) this.f8762s)) / f2) + 0.5f));
        m6089m((this.f8748e * 2) + i2);
        int i4 = 0;
        while (true) {
            i = this.f8748e;
            int i5 = this.f8745b;
            if (i4 >= i * 2 * i5) {
                break;
            }
            this.f8751h[(i5 * i2) + i4] = 0;
            i4++;
        }
        this.f8760q += i * 2;
        m6087k();
        if (this.f8761r > i3) {
            this.f8761r = i3;
        }
        this.f8760q = 0;
        this.f8763t = 0;
        this.f8762s = 0;
    }

    /* renamed from: j */
    public final int mo14047j() {
        return this.f8761r;
    }
}
