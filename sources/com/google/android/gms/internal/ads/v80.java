package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class v80 extends zzejj {

    /* renamed from: e */
    private final InputStream f11478e;

    /* renamed from: f */
    private final byte[] f11479f;

    /* renamed from: g */
    private int f11480g;

    /* renamed from: h */
    private int f11481h;

    /* renamed from: i */
    private int f11482i;

    /* renamed from: j */
    private int f11483j;

    /* renamed from: k */
    private int f11484k;

    /* renamed from: l */
    private int f11485l;

    private v80(InputStream inputStream, int i) {
        super();
        this.f11485l = Integer.MAX_VALUE;
        zzekk.m8825c(inputStream, "input");
        this.f11478e = inputStream;
        this.f11479f = new byte[4096];
        this.f11480g = 0;
        this.f11482i = 0;
        this.f11484k = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r2[r3] >= 0) goto L_0x0068;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int m7055c() {
        /*
            r5 = this;
            int r0 = r5.f11482i
            int r1 = r5.f11480g
            if (r1 == r0) goto L_0x006b
            byte[] r2 = r5.f11479f
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0011
            r5.f11482i = r3
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
            r5.f11482i = r1
            return r0
        L_0x006b:
            long r0 = r5.mo14900b()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.v80.m7055c():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b0, code lost:
        if (((long) r2[r0]) >= 0) goto L_0x006e;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long m7056d() {
        /*
            r11 = this;
            int r0 = r11.f11482i
            int r1 = r11.f11480g
            if (r1 == r0) goto L_0x00b8
            byte[] r2 = r11.f11479f
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r11.f11482i = r3
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
            r11.f11482i = r1
            return r2
        L_0x00b8:
            long r0 = r11.mo14900b()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.v80.m7056d():long");
    }

    /* renamed from: e */
    private final int m7057e() {
        int i = this.f11482i;
        if (this.f11480g - i < 4) {
            m7062j(4);
            i = this.f11482i;
        }
        byte[] bArr = this.f11479f;
        this.f11482i = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* renamed from: f */
    private final long m7058f() {
        int i = this.f11482i;
        if (this.f11480g - i < 8) {
            m7062j(8);
            i = this.f11482i;
        }
        byte[] bArr = this.f11479f;
        this.f11482i = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    /* renamed from: g */
    private final void m7059g() {
        int i = this.f11480g + this.f11481h;
        this.f11480g = i;
        int i2 = this.f11484k + i;
        int i3 = this.f11485l;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.f11481h = i4;
            this.f11480g = i - i4;
            return;
        }
        this.f11481h = 0;
    }

    /* renamed from: h */
    private final byte m7060h() {
        if (this.f11482i == this.f11480g) {
            m7062j(1);
        }
        byte[] bArr = this.f11479f;
        int i = this.f11482i;
        this.f11482i = i + 1;
        return bArr[i];
    }

    /* renamed from: i */
    private final byte[] m7061i(int i, boolean z) {
        byte[] l = m7064l(i);
        if (l != null) {
            return l;
        }
        int i2 = this.f11482i;
        int i3 = this.f11480g;
        int i4 = i3 - i2;
        this.f11484k += i3;
        this.f11482i = 0;
        this.f11480g = 0;
        List<byte[]> m = m7065m(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.f11479f, i2, bArr, 0, i4);
        for (byte[] next : m) {
            System.arraycopy(next, 0, bArr, i4, next.length);
            i4 += next.length;
        }
        return bArr;
    }

    /* renamed from: j */
    private final void m7062j(int i) {
        if (m7063k(i)) {
            return;
        }
        if (i > (this.f16201c - this.f11484k) - this.f11482i) {
            throw zzeks.m8834g();
        }
        throw zzeks.m8828a();
    }

    /* renamed from: k */
    private final boolean m7063k(int i) {
        do {
            int i2 = this.f11482i;
            int i3 = i2 + i;
            int i4 = this.f11480g;
            if (i3 > i4) {
                int i5 = this.f16201c;
                int i6 = this.f11484k;
                if (i > (i5 - i6) - i2 || i6 + i2 + i > this.f11485l) {
                    return false;
                }
                if (i2 > 0) {
                    if (i4 > i2) {
                        byte[] bArr = this.f11479f;
                        System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
                    }
                    this.f11484k += i2;
                    this.f11480g -= i2;
                    this.f11482i = 0;
                }
                InputStream inputStream = this.f11478e;
                byte[] bArr2 = this.f11479f;
                int i7 = this.f11480g;
                int read = inputStream.read(bArr2, i7, Math.min(bArr2.length - i7, (this.f16201c - this.f11484k) - i7));
                if (read == 0 || read < -1 || read > this.f11479f.length) {
                    String valueOf = String.valueOf(this.f11478e.getClass());
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 91);
                    sb.append(valueOf);
                    sb.append("#read(byte[]) returned invalid result: ");
                    sb.append(read);
                    sb.append("\nThe InputStream implementation is buggy.");
                    throw new IllegalStateException(sb.toString());
                } else if (read <= 0) {
                    return false;
                } else {
                    this.f11480g += read;
                    m7059g();
                }
            } else {
                StringBuilder sb2 = new StringBuilder(77);
                sb2.append("refillBuffer() called when ");
                sb2.append(i);
                sb2.append(" bytes were already available in buffer");
                throw new IllegalStateException(sb2.toString());
            }
        } while (this.f11480g < i);
        return true;
    }

    /* renamed from: l */
    private final byte[] m7064l(int i) {
        if (i == 0) {
            return zzekk.zzijg;
        }
        if (i >= 0) {
            int i2 = this.f11484k;
            int i3 = this.f11482i;
            int i4 = i2 + i3 + i;
            if (i4 - this.f16201c <= 0) {
                int i5 = this.f11485l;
                if (i4 <= i5) {
                    int i6 = this.f11480g - i3;
                    int i7 = i - i6;
                    if (i7 >= 4096 && i7 > this.f11478e.available()) {
                        return null;
                    }
                    byte[] bArr = new byte[i];
                    System.arraycopy(this.f11479f, this.f11482i, bArr, 0, i6);
                    this.f11484k += this.f11480g;
                    this.f11482i = 0;
                    this.f11480g = 0;
                    while (i6 < i) {
                        int read = this.f11478e.read(bArr, i6, i - i6);
                        if (read != -1) {
                            this.f11484k += read;
                            i6 += read;
                        } else {
                            throw zzeks.m8828a();
                        }
                    }
                    return bArr;
                }
                m7066n((i5 - i2) - i3);
                throw zzeks.m8828a();
            }
            throw zzeks.m8834g();
        }
        throw zzeks.m8829b();
    }

    /* renamed from: m */
    private final List<byte[]> m7065m(int i) {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int min = Math.min(i, 4096);
            byte[] bArr = new byte[min];
            int i2 = 0;
            while (i2 < min) {
                int read = this.f11478e.read(bArr, i2, min - i2);
                if (read != -1) {
                    this.f11484k += read;
                    i2 += read;
                } else {
                    throw zzeks.m8828a();
                }
            }
            i -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    /* renamed from: n */
    private final void m7066n(int i) {
        int i2 = this.f11480g;
        int i3 = this.f11482i;
        if (i <= i2 - i3 && i >= 0) {
            this.f11482i = i3 + i;
        } else if (i >= 0) {
            int i4 = this.f11484k;
            int i5 = i4 + i3 + i;
            int i6 = this.f11485l;
            if (i5 <= i6) {
                this.f11484k = i4 + i3;
                int i7 = i2 - i3;
                this.f11480g = 0;
                this.f11482i = 0;
                while (i7 < i) {
                    try {
                        long j = (long) (i - i7);
                        long skip = this.f11478e.skip(j);
                        if (skip >= 0 && skip <= j) {
                            if (skip == 0) {
                                break;
                            }
                            i7 += (int) skip;
                        } else {
                            String valueOf = String.valueOf(this.f11478e.getClass());
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 92);
                            sb.append(valueOf);
                            sb.append("#skip returned invalid result: ");
                            sb.append(skip);
                            sb.append("\nThe InputStream implementation is buggy.");
                            throw new IllegalStateException(sb.toString());
                        }
                    } catch (Throwable th) {
                        this.f11484k += i7;
                        m7059g();
                        throw th;
                    }
                }
                this.f11484k += i7;
                m7059g();
                if (i7 < i) {
                    int i8 = this.f11480g;
                    int i9 = i8 - this.f11482i;
                    this.f11482i = i8;
                    m7062j(1);
                    while (true) {
                        int i10 = i - i9;
                        int i11 = this.f11480g;
                        if (i10 > i11) {
                            i9 += i11;
                            this.f11482i = i11;
                            m7062j(1);
                        } else {
                            this.f11482i = i10;
                            return;
                        }
                    }
                }
            } else {
                m7066n((i6 - i4) - i3);
                throw zzeks.m8828a();
            }
        } else {
            throw zzeks.m8829b();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final long mo14900b() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte h = m7060h();
            j |= ((long) (h & Byte.MAX_VALUE)) << i;
            if ((h & 128) == 0) {
                return j;
            }
        }
        throw zzeks.m8830c();
    }

    public final double readDouble() {
        return Double.longBitsToDouble(m7058f());
    }

    public final float readFloat() {
        return Float.intBitsToFloat(m7057e());
    }

    public final String readString() {
        int c = m7055c();
        if (c > 0 && c <= this.f11480g - this.f11482i) {
            String str = new String(this.f11479f, this.f11482i, c, zzekk.f16269a);
            this.f11482i += c;
            return str;
        } else if (c == 0) {
            return "";
        } else {
            if (c > this.f11480g) {
                return new String(m7061i(c, false), zzekk.f16269a);
            }
            m7062j(c);
            String str2 = new String(this.f11479f, this.f11482i, c, zzekk.f16269a);
            this.f11482i += c;
            return str2;
        }
    }

    public final int zzbga() {
        if (zzbgq()) {
            this.f11483j = 0;
            return 0;
        }
        int c = m7055c();
        this.f11483j = c;
        if ((c >>> 3) != 0) {
            return c;
        }
        throw zzeks.m8831d();
    }

    public final long zzbgb() {
        return m7056d();
    }

    public final long zzbgc() {
        return m7056d();
    }

    public final int zzbgd() {
        return m7055c();
    }

    public final long zzbge() {
        return m7058f();
    }

    public final int zzbgf() {
        return m7057e();
    }

    public final boolean zzbgg() {
        return m7056d() != 0;
    }

    public final String zzbgh() {
        byte[] bArr;
        int c = m7055c();
        int i = this.f11482i;
        int i2 = this.f11480g;
        if (c <= i2 - i && c > 0) {
            bArr = this.f11479f;
            this.f11482i = i + c;
        } else if (c == 0) {
            return "";
        } else {
            if (c <= i2) {
                m7062j(c);
                bArr = this.f11479f;
                this.f11482i = c;
            } else {
                bArr = m7061i(c, false);
            }
            i = 0;
        }
        return vb0.m7087l(bArr, i, c);
    }

    public final zzeiu zzbgi() {
        int c = m7055c();
        int i = this.f11480g;
        int i2 = this.f11482i;
        if (c <= i - i2 && c > 0) {
            zzeiu zzh = zzeiu.zzh(this.f11479f, i2, c);
            this.f11482i += c;
            return zzh;
        } else if (c == 0) {
            return zzeiu.zziiy;
        } else {
            byte[] l = m7064l(c);
            if (l != null) {
                return zzeiu.zzt(l);
            }
            int i3 = this.f11482i;
            int i4 = this.f11480g;
            int i5 = i4 - i3;
            this.f11484k += i4;
            this.f11482i = 0;
            this.f11480g = 0;
            List<byte[]> m = m7065m(c - i5);
            byte[] bArr = new byte[c];
            System.arraycopy(this.f11479f, i3, bArr, 0, i5);
            for (byte[] next : m) {
                System.arraycopy(next, 0, bArr, i5, next.length);
                i5 += next.length;
            }
            return zzeiu.m8791g(bArr);
        }
    }

    public final int zzbgj() {
        return m7055c();
    }

    public final int zzbgk() {
        return m7055c();
    }

    public final int zzbgl() {
        return m7057e();
    }

    public final long zzbgm() {
        return m7058f();
    }

    public final int zzbgn() {
        return zzejj.zzgg(m7055c());
    }

    public final long zzbgo() {
        return zzejj.zzfg(m7056d());
    }

    public final boolean zzbgq() {
        return this.f11482i == this.f11480g && !m7063k(1);
    }

    public final int zzbgr() {
        return this.f11484k + this.f11482i;
    }

    public final void zzgc(int i) {
        if (this.f11483j != i) {
            throw zzeks.m8832e();
        }
    }

    public final boolean zzgd(int i) {
        int zzbga;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.f11480g - this.f11482i >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.f11479f;
                    int i4 = this.f11482i;
                    this.f11482i = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzeks.m8830c();
            }
            while (i3 < 10) {
                if (m7060h() < 0) {
                    i3++;
                }
            }
            throw zzeks.m8830c();
            return true;
        } else if (i2 == 1) {
            m7066n(8);
            return true;
        } else if (i2 == 2) {
            m7066n(m7055c());
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
                m7066n(4);
                return true;
            }
            throw zzeks.m8833f();
        }
    }

    public final int zzge(int i) {
        if (i >= 0) {
            int i2 = i + this.f11484k + this.f11482i;
            int i3 = this.f11485l;
            if (i2 <= i3) {
                this.f11485l = i2;
                m7059g();
                return i3;
            }
            throw zzeks.m8828a();
        }
        throw zzeks.m8829b();
    }

    public final void zzgf(int i) {
        this.f11485l = i;
        m7059g();
    }
}
