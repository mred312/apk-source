package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.e3 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2747e3 {
    /* renamed from: a */
    static int m9378a(int i, byte[] bArr, int i2, int i3, C2739d3 d3Var) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return m9388k(bArr, i2, d3Var);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return m9386i(bArr, i2, d3Var) + d3Var.f17257a;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = m9386i(bArr, i2, d3Var);
                    i6 = d3Var.f17257a;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = m9378a(i6, bArr, i2, i3, d3Var);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw zzih.m10393g();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw zzih.m10390d();
            }
        } else {
            throw zzih.m10390d();
        }
    }

    /* renamed from: b */
    static int m9379b(int i, byte[] bArr, int i2, int i3, zzii<?> zzii, C2739d3 d3Var) {
        C2768g4 g4Var = (C2768g4) zzii;
        int i4 = m9386i(bArr, i2, d3Var);
        g4Var.mo18654c(d3Var.f17257a);
        while (i4 < i3) {
            int i5 = m9386i(bArr, i4, d3Var);
            if (i != d3Var.f17257a) {
                break;
            }
            i4 = m9386i(bArr, i5, d3Var);
            g4Var.mo18654c(d3Var.f17257a);
        }
        return i4;
    }

    /* renamed from: c */
    static int m9380c(int i, byte[] bArr, int i2, int i3, zzku zzku, C2739d3 d3Var) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int k = m9388k(bArr, i2, d3Var);
                zzku.mo19557b(i, Long.valueOf(d3Var.f17258b));
                return k;
            } else if (i4 == 1) {
                zzku.mo19557b(i, Long.valueOf(m9389l(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int i5 = m9386i(bArr, i2, d3Var);
                int i6 = d3Var.f17257a;
                if (i6 < 0) {
                    throw zzih.m10388b();
                } else if (i6 <= bArr.length - i5) {
                    if (i6 == 0) {
                        zzku.mo19557b(i, zzgr.zza);
                    } else {
                        zzku.mo19557b(i, zzgr.zza(bArr, i5, i6));
                    }
                    return i5 + i6;
                } else {
                    throw zzih.m10387a();
                }
            } else if (i4 == 3) {
                zzku f = zzku.m10404f();
                int i7 = (i & -8) | 4;
                int i8 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int i9 = m9386i(bArr, i2, d3Var);
                    int i10 = d3Var.f17257a;
                    i8 = i10;
                    if (i10 == i7) {
                        i2 = i9;
                        break;
                    }
                    int c = m9380c(i8, bArr, i9, i3, f, d3Var);
                    i8 = i10;
                    i2 = c;
                }
                if (i2 > i3 || i8 != i7) {
                    throw zzih.m10393g();
                }
                zzku.mo19557b(i, f);
                return i2;
            } else if (i4 == 5) {
                zzku.mo19557b(i, Integer.valueOf(m9385h(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzih.m10390d();
            }
        } else {
            throw zzih.m10390d();
        }
    }

    /* renamed from: d */
    static int m9381d(int i, byte[] bArr, int i2, C2739d3 d3Var) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            d3Var.f17257a = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            d3Var.f17257a = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            d3Var.f17257a = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            d3Var.f17257a = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                d3Var.f17257a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* renamed from: e */
    static int m9382e(C2793j5<?> j5Var, int i, byte[] bArr, int i2, int i3, zzii<?> zzii, C2739d3 d3Var) {
        int g = m9384g(j5Var, bArr, i2, i3, d3Var);
        zzii.add(d3Var.f17259c);
        while (g < i3) {
            int i4 = m9386i(bArr, g, d3Var);
            if (i != d3Var.f17257a) {
                break;
            }
            g = m9384g(j5Var, bArr, i4, i3, d3Var);
            zzii.add(d3Var.f17259c);
        }
        return g;
    }

    /* renamed from: f */
    static int m9383f(C2793j5 j5Var, byte[] bArr, int i, int i2, int i3, C2739d3 d3Var) {
        C2910y4 y4Var = (C2910y4) j5Var;
        Object zza = y4Var.zza();
        int n = y4Var.mo18992n(zza, bArr, i, i2, i3, d3Var);
        y4Var.mo18543c(zza);
        d3Var.f17259c = zza;
        return n;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int m9384g(com.google.android.gms.internal.measurement.C2793j5 r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.measurement.C2739d3 r10) {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = m9381d(r8, r7, r0, r10)
            int r8 = r10.f17257a
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.zza()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.mo18545e(r1, r2, r3, r4, r5)
            r6.mo18543c(r9)
            r10.f17259c = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.measurement.zzih r6 = com.google.android.gms.internal.measurement.zzih.m10387a()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C2747e3.m9384g(com.google.android.gms.internal.measurement.j5, byte[], int, int, com.google.android.gms.internal.measurement.d3):int");
    }

    /* renamed from: h */
    static int m9385h(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* renamed from: i */
    static int m9386i(byte[] bArr, int i, C2739d3 d3Var) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return m9381d(b, bArr, i2, d3Var);
        }
        d3Var.f17257a = b;
        return i2;
    }

    /* renamed from: j */
    static int m9387j(byte[] bArr, int i, zzii<?> zzii, C2739d3 d3Var) {
        C2768g4 g4Var = (C2768g4) zzii;
        int i2 = m9386i(bArr, i, d3Var);
        int i3 = d3Var.f17257a + i2;
        while (i2 < i3) {
            i2 = m9386i(bArr, i2, d3Var);
            g4Var.mo18654c(d3Var.f17257a);
        }
        if (i2 == i3) {
            return i2;
        }
        throw zzih.m10387a();
    }

    /* renamed from: k */
    static int m9388k(byte[] bArr, int i, C2739d3 d3Var) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            d3Var.f17258b = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & Byte.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & Byte.MAX_VALUE)) << i4;
            int i6 = i5;
            b = b2;
            i3 = i6;
        }
        d3Var.f17258b = j2;
        return i3;
    }

    /* renamed from: l */
    static long m9389l(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    /* renamed from: m */
    static double m9390m(byte[] bArr, int i) {
        return Double.longBitsToDouble(m9389l(bArr, i));
    }

    /* renamed from: n */
    static int m9391n(byte[] bArr, int i, C2739d3 d3Var) {
        int i2 = m9386i(bArr, i, d3Var);
        int i3 = d3Var.f17257a;
        if (i3 < 0) {
            throw zzih.m10388b();
        } else if (i3 == 0) {
            d3Var.f17259c = "";
            return i2;
        } else {
            d3Var.f17259c = new String(bArr, i2, i3, zzic.f17731a);
            return i2 + i3;
        }
    }

    /* renamed from: o */
    static float m9392o(byte[] bArr, int i) {
        return Float.intBitsToFloat(m9385h(bArr, i));
    }

    /* renamed from: p */
    static int m9393p(byte[] bArr, int i, C2739d3 d3Var) {
        int i2 = m9386i(bArr, i, d3Var);
        int i3 = d3Var.f17257a;
        if (i3 < 0) {
            throw zzih.m10388b();
        } else if (i3 == 0) {
            d3Var.f17259c = "";
            return i2;
        } else {
            d3Var.f17259c = C2794j6.m9540k(bArr, i2, i3);
            return i2 + i3;
        }
    }

    /* renamed from: q */
    static int m9394q(byte[] bArr, int i, C2739d3 d3Var) {
        int i2 = m9386i(bArr, i, d3Var);
        int i3 = d3Var.f17257a;
        if (i3 < 0) {
            throw zzih.m10388b();
        } else if (i3 > bArr.length - i2) {
            throw zzih.m10387a();
        } else if (i3 == 0) {
            d3Var.f17259c = zzgr.zza;
            return i2;
        } else {
            d3Var.f17259c = zzgr.zza(bArr, i2, i3);
            return i2 + i3;
        }
    }
}
