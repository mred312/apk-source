package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class w80 extends zzejj {

    /* renamed from: e */
    private final byte[] f11676e;

    /* renamed from: f */
    private int f11677f;

    /* renamed from: g */
    private int f11678g;

    /* renamed from: h */
    private int f11679h;

    /* renamed from: i */
    private int f11680i;

    /* renamed from: j */
    private int f11681j;

    /* renamed from: k */
    private int f11682k;

    private w80(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.f11682k = Integer.MAX_VALUE;
        this.f11676e = bArr;
        this.f11677f = i2 + i;
        this.f11679h = i;
        this.f11680i = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r2[r3] >= 0) goto L_0x0068;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int m7108c() {
        /*
            r5 = this;
            int r0 = r5.f11679h
            int r1 = r5.f11677f
            if (r1 == r0) goto L_0x006b
            byte[] r2 = r5.f11676e
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0011
            r5.f11679h = r3
            return r0
        L_0x0011:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x006b
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0022
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0068
        L_0x0022:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x002f
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002d:
            r1 = r3
            goto L_0x0068
        L_0x002f:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003d
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0068
        L_0x003d:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0068
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0068
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 < 0) goto L_0x006b
        L_0x0068:
            r5.f11679h = r1
            return r0
        L_0x006b:
            long r0 = r5.mo14900b()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.w80.m7108c():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b0, code lost:
        if (((long) r2[r0]) >= 0) goto L_0x006e;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long m7109d() {
        /*
            r11 = this;
            int r0 = r11.f11679h
            int r1 = r11.f11677f
            if (r1 == r0) goto L_0x00b8
            byte[] r2 = r11.f11676e
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r11.f11679h = r3
            long r0 = (long) r0
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x00b8
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0025
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
        L_0x0022:
            long r2 = (long) r0
            goto L_0x00b5
        L_0x0025:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0036
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            long r0 = (long) r0
            r9 = r0
            r1 = r3
            r2 = r9
            goto L_0x00b5
        L_0x0036:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0044
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0022
        L_0x0044:
            long r3 = (long) r0
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r5 = (long) r1
            r1 = 28
            long r5 = r5 << r1
            long r3 = r3 ^ r5
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x005b
            r1 = 266354560(0xfe03f80, double:1.315966377E-315)
        L_0x0057:
            long r1 = r1 ^ r3
            r2 = r1
            r1 = r0
            goto L_0x00b5
        L_0x005b:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 35
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0070
            r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
        L_0x006d:
            long r3 = r3 ^ r5
        L_0x006e:
            r2 = r3
            goto L_0x00b5
        L_0x0070:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 42
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x0083
            r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            goto L_0x0057
        L_0x0083:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 49
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0096
            r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            goto L_0x006d
        L_0x0096:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 56
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x00b3
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x00b8
            goto L_0x006e
        L_0x00b3:
            r1 = r0
            goto L_0x006e
        L_0x00b5:
            r11.f11679h = r1
            return r2
        L_0x00b8:
            long r0 = r11.mo14900b()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.w80.m7109d():long");
    }

    /* renamed from: e */
    private final int m7110e() {
        int i = this.f11679h;
        if (this.f11677f - i >= 4) {
            byte[] bArr = this.f11676e;
            this.f11679h = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }
        throw zzeks.m8828a();
    }

    /* renamed from: f */
    private final long m7111f() {
        int i = this.f11679h;
        if (this.f11677f - i >= 8) {
            byte[] bArr = this.f11676e;
            this.f11679h = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }
        throw zzeks.m8828a();
    }

    /* renamed from: g */
    private final void m7112g() {
        int i = this.f11677f + this.f11678g;
        this.f11677f = i;
        int i2 = i - this.f11680i;
        int i3 = this.f11682k;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.f11678g = i4;
            this.f11677f = i - i4;
            return;
        }
        this.f11678g = 0;
    }

    /* renamed from: h */
    private final byte m7113h() {
        int i = this.f11679h;
        if (i != this.f11677f) {
            byte[] bArr = this.f11676e;
            this.f11679h = i + 1;
            return bArr[i];
        }
        throw zzeks.m8828a();
    }

    /* renamed from: i */
    private final void m7114i(int i) {
        if (i >= 0) {
            int i2 = this.f11677f;
            int i3 = this.f11679h;
            if (i <= i2 - i3) {
                this.f11679h = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzeks.m8829b();
        }
        throw zzeks.m8828a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final long mo14900b() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte h = m7113h();
            j |= ((long) (h & Byte.MAX_VALUE)) << i;
            if ((h & 128) == 0) {
                return j;
            }
        }
        throw zzeks.m8830c();
    }

    public final double readDouble() {
        return Double.longBitsToDouble(m7111f());
    }

    public final float readFloat() {
        return Float.intBitsToFloat(m7110e());
    }

    public final String readString() {
        int c = m7108c();
        if (c > 0 && c <= this.f11677f - this.f11679h) {
            String str = new String(this.f11676e, this.f11679h, c, zzekk.f16269a);
            this.f11679h += c;
            return str;
        } else if (c == 0) {
            return "";
        } else {
            if (c < 0) {
                throw zzeks.m8829b();
            }
            throw zzeks.m8828a();
        }
    }

    public final int zzbga() {
        if (zzbgq()) {
            this.f11681j = 0;
            return 0;
        }
        int c = m7108c();
        this.f11681j = c;
        if ((c >>> 3) != 0) {
            return c;
        }
        throw zzeks.m8831d();
    }

    public final long zzbgb() {
        return m7109d();
    }

    public final long zzbgc() {
        return m7109d();
    }

    public final int zzbgd() {
        return m7108c();
    }

    public final long zzbge() {
        return m7111f();
    }

    public final int zzbgf() {
        return m7110e();
    }

    public final boolean zzbgg() {
        return m7109d() != 0;
    }

    public final String zzbgh() {
        int c = m7108c();
        if (c > 0) {
            int i = this.f11677f;
            int i2 = this.f11679h;
            if (c <= i - i2) {
                String l = vb0.m7087l(this.f11676e, i2, c);
                this.f11679h += c;
                return l;
            }
        }
        if (c == 0) {
            return "";
        }
        if (c <= 0) {
            throw zzeks.m8829b();
        }
        throw zzeks.m8828a();
    }

    public final zzeiu zzbgi() {
        byte[] bArr;
        int c = m7108c();
        if (c > 0) {
            int i = this.f11677f;
            int i2 = this.f11679h;
            if (c <= i - i2) {
                zzeiu zzh = zzeiu.zzh(this.f11676e, i2, c);
                this.f11679h += c;
                return zzh;
            }
        }
        if (c == 0) {
            return zzeiu.zziiy;
        }
        if (c > 0) {
            int i3 = this.f11677f;
            int i4 = this.f11679h;
            if (c <= i3 - i4) {
                int i5 = c + i4;
                this.f11679h = i5;
                bArr = Arrays.copyOfRange(this.f11676e, i4, i5);
                return zzeiu.m8791g(bArr);
            }
        }
        if (c > 0) {
            throw zzeks.m8828a();
        } else if (c == 0) {
            bArr = zzekk.zzijg;
            return zzeiu.m8791g(bArr);
        } else {
            throw zzeks.m8829b();
        }
    }

    public final int zzbgj() {
        return m7108c();
    }

    public final int zzbgk() {
        return m7108c();
    }

    public final int zzbgl() {
        return m7110e();
    }

    public final long zzbgm() {
        return m7111f();
    }

    public final int zzbgn() {
        return zzejj.zzgg(m7108c());
    }

    public final long zzbgo() {
        return zzejj.zzfg(m7109d());
    }

    public final boolean zzbgq() {
        return this.f11679h == this.f11677f;
    }

    public final int zzbgr() {
        return this.f11679h - this.f11680i;
    }

    public final void zzgc(int i) {
        if (this.f11681j != i) {
            throw zzeks.m8832e();
        }
    }

    public final boolean zzgd(int i) {
        int zzbga;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.f11677f - this.f11679h >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.f11676e;
                    int i4 = this.f11679h;
                    this.f11679h = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzeks.m8830c();
            }
            while (i3 < 10) {
                if (m7113h() < 0) {
                    i3++;
                }
            }
            throw zzeks.m8830c();
            return true;
        } else if (i2 == 1) {
            m7114i(8);
            return true;
        } else if (i2 == 2) {
            m7114i(m7108c());
            return true;
        } else if (i2 == 3) {
            do {
                zzbga = zzbga();
                if (zzbga == 0 || !zzgd(zzbga)) {
                    zzgc(((i >>> 3) << 3) | 4);
                }
                zzbga = zzbga();
                break;
            } while (!zzgd(zzbga));
            zzgc(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                m7114i(4);
                return true;
            }
            throw zzeks.m8833f();
        }
    }

    public final int zzge(int i) {
        if (i >= 0) {
            int zzbgr = i + zzbgr();
            int i2 = this.f11682k;
            if (zzbgr <= i2) {
                this.f11682k = zzbgr;
                m7112g();
                return i2;
            }
            throw zzeks.m8828a();
        }
        throw zzeks.m8829b();
    }

    public final void zzgf(int i) {
        this.f11682k = i;
        m7112g();
    }
}
