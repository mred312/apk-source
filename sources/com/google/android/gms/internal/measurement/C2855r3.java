package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.measurement.r3 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2855r3 extends zzhd {

    /* renamed from: d */
    private final byte[] f17436d;

    /* renamed from: e */
    private int f17437e;

    /* renamed from: f */
    private int f17438f;

    /* renamed from: g */
    private int f17439g;

    /* renamed from: h */
    private int f17440h;

    /* renamed from: i */
    private int f17441i;

    /* renamed from: j */
    private int f17442j;

    private C2855r3(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.f17442j = Integer.MAX_VALUE;
        this.f17436d = bArr;
        this.f17437e = i2 + i;
        this.f17439g = i;
        this.f17440h = i;
    }

    /* renamed from: c */
    private final byte m9763c() {
        int i = this.f17439g;
        if (i != this.f17437e) {
            byte[] bArr = this.f17436d;
            this.f17439g = i + 1;
            return bArr[i];
        }
        throw zzih.m10387a();
    }

    /* renamed from: d */
    private final void m9764d(int i) {
        if (i >= 0) {
            int i2 = this.f17437e;
            int i3 = this.f17439g;
            if (i <= i2 - i3) {
                this.f17439g = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzih.m10388b();
        }
        throw zzih.m10387a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r2[r3] >= 0) goto L_0x0068;
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int m9765e() {
        /*
            r5 = this;
            int r0 = r5.f17439g
            int r1 = r5.f17437e
            if (r1 == r0) goto L_0x006b
            byte[] r2 = r5.f17436d
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0011
            r5.f17439g = r3
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
            r5.f17439g = r1
            return r0
        L_0x006b:
            long r0 = r5.mo18819b()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C2855r3.m9765e():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b0, code lost:
        if (((long) r2[r0]) >= 0) goto L_0x006e;
     */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long m9766f() {
        /*
            r11 = this;
            int r0 = r11.f17439g
            int r1 = r11.f17437e
            if (r1 == r0) goto L_0x00b8
            byte[] r2 = r11.f17436d
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r11.f17439g = r3
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
            r11.f17439g = r1
            return r2
        L_0x00b8:
            long r0 = r11.mo18819b()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C2855r3.m9766f():long");
    }

    /* renamed from: g */
    private final int m9767g() {
        int i = this.f17439g;
        if (this.f17437e - i >= 4) {
            byte[] bArr = this.f17436d;
            this.f17439g = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }
        throw zzih.m10387a();
    }

    /* renamed from: h */
    private final long m9768h() {
        int i = this.f17439g;
        if (this.f17437e - i >= 8) {
            byte[] bArr = this.f17436d;
            this.f17439g = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }
        throw zzih.m10387a();
    }

    /* renamed from: i */
    private final void m9769i() {
        int i = this.f17437e + this.f17438f;
        this.f17437e = i;
        int i2 = i - this.f17440h;
        int i3 = this.f17442j;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.f17438f = i4;
            this.f17437e = i - i4;
            return;
        }
        this.f17438f = 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final long mo18819b() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte c = m9763c();
            j |= ((long) (c & Byte.MAX_VALUE)) << i;
            if ((c & 128) == 0) {
                return j;
            }
        }
        throw zzih.m10389c();
    }

    public final int zza() {
        if (zzt()) {
            this.f17441i = 0;
            return 0;
        }
        int e = m9765e();
        this.f17441i = e;
        if ((e >>> 3) != 0) {
            return e;
        }
        throw zzih.m10390d();
    }

    public final boolean zzb(int i) {
        int zza;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.f17437e - this.f17439g >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.f17436d;
                    int i4 = this.f17439g;
                    this.f17439g = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzih.m10389c();
            }
            while (i3 < 10) {
                if (m9763c() < 0) {
                    i3++;
                }
            }
            throw zzih.m10389c();
            return true;
        } else if (i2 == 1) {
            m9764d(8);
            return true;
        } else if (i2 == 2) {
            m9764d(m9765e());
            return true;
        } else if (i2 == 3) {
            do {
                zza = zza();
                if (zza == 0 || !zzb(zza)) {
                    zza(((i >>> 3) << 3) | 4);
                }
                zza = zza();
                break;
            } while (!zzb(zza));
            zza(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                m9764d(4);
                return true;
            }
            throw zzih.m10392f();
        }
    }

    public final float zzc() {
        return Float.intBitsToFloat(m9767g());
    }

    public final long zzd() {
        return m9766f();
    }

    public final long zze() {
        return m9766f();
    }

    public final int zzf() {
        return m9765e();
    }

    public final long zzg() {
        return m9768h();
    }

    public final int zzh() {
        return m9767g();
    }

    public final boolean zzi() {
        return m9766f() != 0;
    }

    public final String zzj() {
        int e = m9765e();
        if (e > 0 && e <= this.f17437e - this.f17439g) {
            String str = new String(this.f17436d, this.f17439g, e, zzic.f17731a);
            this.f17439g += e;
            return str;
        } else if (e == 0) {
            return "";
        } else {
            if (e < 0) {
                throw zzih.m10388b();
            }
            throw zzih.m10387a();
        }
    }

    public final String zzk() {
        int e = m9765e();
        if (e > 0) {
            int i = this.f17437e;
            int i2 = this.f17439g;
            if (e <= i - i2) {
                String k = C2794j6.m9540k(this.f17436d, i2, e);
                this.f17439g += e;
                return k;
            }
        }
        if (e == 0) {
            return "";
        }
        if (e <= 0) {
            throw zzih.m10388b();
        }
        throw zzih.m10387a();
    }

    public final zzgr zzl() {
        byte[] bArr;
        int e = m9765e();
        if (e > 0) {
            int i = this.f17437e;
            int i2 = this.f17439g;
            if (e <= i - i2) {
                zzgr zza = zzgr.zza(this.f17436d, i2, e);
                this.f17439g += e;
                return zza;
            }
        }
        if (e == 0) {
            return zzgr.zza;
        }
        if (e > 0) {
            int i3 = this.f17437e;
            int i4 = this.f17439g;
            if (e <= i3 - i4) {
                int i5 = e + i4;
                this.f17439g = i5;
                bArr = Arrays.copyOfRange(this.f17436d, i4, i5);
                return zzgr.m10349a(bArr);
            }
        }
        if (e > 0) {
            throw zzih.m10387a();
        } else if (e == 0) {
            bArr = zzic.zzb;
            return zzgr.m10349a(bArr);
        } else {
            throw zzih.m10388b();
        }
    }

    public final int zzm() {
        return m9765e();
    }

    public final int zzn() {
        return m9765e();
    }

    public final int zzo() {
        return m9767g();
    }

    public final long zzp() {
        return m9768h();
    }

    public final int zzq() {
        return zzhd.zze(m9765e());
    }

    public final long zzr() {
        return zzhd.zza(m9766f());
    }

    public final boolean zzt() {
        return this.f17439g == this.f17437e;
    }

    public final int zzu() {
        return this.f17439g - this.f17440h;
    }

    public final int zzc(int i) {
        if (i >= 0) {
            int zzu = i + zzu();
            int i2 = this.f17442j;
            if (zzu <= i2) {
                this.f17442j = zzu;
                m9769i();
                return i2;
            }
            throw zzih.m10387a();
        }
        throw zzih.m10388b();
    }

    public final void zzd(int i) {
        this.f17442j = i;
        m9769i();
    }

    public final void zza(int i) {
        if (this.f17441i != i) {
            throw zzih.m10391e();
        }
    }

    public final double zzb() {
        return Double.longBitsToDouble(m9768h());
    }
}
