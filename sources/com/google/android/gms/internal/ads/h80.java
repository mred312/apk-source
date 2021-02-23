package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class h80 {
    /* renamed from: a */
    static int m6111a(int i, byte[] bArr, int i2, int i3, k80 k80) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return m6120j(bArr, i2, k80);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return m6118h(bArr, i2, k80) + k80.f9575a;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = m6118h(bArr, i2, k80);
                    i6 = k80.f9575a;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = m6111a(i6, bArr, i2, i3, k80);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw zzeks.m8835h();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw zzeks.m8831d();
            }
        } else {
            throw zzeks.m8831d();
        }
    }

    /* renamed from: b */
    static int m6112b(int i, byte[] bArr, int i2, int i3, zzekp<?> zzekp, k80 k80) {
        m90 m90 = (m90) zzekp;
        int h = m6118h(bArr, i2, k80);
        m90.zzhg(k80.f9575a);
        while (h < i3) {
            int h2 = m6118h(bArr, h, k80);
            if (i != k80.f9575a) {
                break;
            }
            h = m6118h(bArr, h2, k80);
            m90.zzhg(k80.f9575a);
        }
        return h;
    }

    /* renamed from: c */
    static int m6113c(int i, byte[] bArr, int i2, int i3, zzeni zzeni, k80 k80) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int j = m6120j(bArr, i2, k80);
                zzeni.mo17703f(i, Long.valueOf(k80.f9576b));
                return j;
            } else if (i4 == 1) {
                zzeni.mo17703f(i, Long.valueOf(m6125o(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int h = m6118h(bArr, i2, k80);
                int i5 = k80.f9575a;
                if (i5 < 0) {
                    throw zzeks.m8829b();
                } else if (i5 <= bArr.length - h) {
                    if (i5 == 0) {
                        zzeni.mo17703f(i, zzeiu.zziiy);
                    } else {
                        zzeni.mo17703f(i, zzeiu.zzh(bArr, h, i5));
                    }
                    return h + i5;
                } else {
                    throw zzeks.m8828a();
                }
            } else if (i4 == 3) {
                zzeni e = zzeni.m8845e();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int h2 = m6118h(bArr, i2, k80);
                    int i8 = k80.f9575a;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = h2;
                        break;
                    }
                    int c = m6113c(i7, bArr, h2, i3, e, k80);
                    i7 = i8;
                    i2 = c;
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzeks.m8835h();
                }
                zzeni.mo17703f(i, e);
                return i2;
            } else if (i4 == 5) {
                zzeni.mo17703f(i, Integer.valueOf(m6124n(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzeks.m8831d();
            }
        } else {
            throw zzeks.m8831d();
        }
    }

    /* renamed from: d */
    static int m6114d(int i, byte[] bArr, int i2, k80 k80) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            k80.f9575a = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            k80.f9575a = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            k80.f9575a = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            k80.f9575a = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                k80.f9575a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* renamed from: e */
    static int m6115e(wa0<?> wa0, int i, byte[] bArr, int i2, int i3, zzekp<?> zzekp, k80 k80) {
        int g = m6117g(wa0, bArr, i2, i3, k80);
        zzekp.add(k80.f9577c);
        while (g < i3) {
            int h = m6118h(bArr, g, k80);
            if (i != k80.f9575a) {
                break;
            }
            g = m6117g(wa0, bArr, h, i3, k80);
            zzekp.add(k80.f9577c);
        }
        return g;
    }

    /* renamed from: f */
    static int m6116f(wa0 wa0, byte[] bArr, int i, int i2, int i3, k80 k80) {
        ha0 ha0 = (ha0) wa0;
        Object c = ha0.mo14190c();
        int o = ha0.mo14199o(c, bArr, i, i2, i3, k80);
        ha0.mo14196i(c);
        k80.f9577c = c;
        return o;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int m6117g(com.google.android.gms.internal.ads.wa0 r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.ads.k80 r10) {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = m6114d(r8, r7, r0, r10)
            int r8 = r10.f9575a
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.mo14190c()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.mo14193f(r1, r2, r3, r4, r5)
            r6.mo14196i(r9)
            r10.f9577c = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.ads.zzeks r6 = com.google.android.gms.internal.ads.zzeks.m8828a()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.h80.m6117g(com.google.android.gms.internal.ads.wa0, byte[], int, int, com.google.android.gms.internal.ads.k80):int");
    }

    /* renamed from: h */
    static int m6118h(byte[] bArr, int i, k80 k80) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return m6114d(b, bArr, i2, k80);
        }
        k80.f9575a = b;
        return i2;
    }

    /* renamed from: i */
    static int m6119i(byte[] bArr, int i, zzekp<?> zzekp, k80 k80) {
        m90 m90 = (m90) zzekp;
        int h = m6118h(bArr, i, k80);
        int i2 = k80.f9575a + h;
        while (h < i2) {
            h = m6118h(bArr, h, k80);
            m90.zzhg(k80.f9575a);
        }
        if (h == i2) {
            return h;
        }
        throw zzeks.m8828a();
    }

    /* renamed from: j */
    static int m6120j(byte[] bArr, int i, k80 k80) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            k80.f9576b = j;
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
        k80.f9576b = j2;
        return i3;
    }

    /* renamed from: k */
    static int m6121k(byte[] bArr, int i, k80 k80) {
        int h = m6118h(bArr, i, k80);
        int i2 = k80.f9575a;
        if (i2 < 0) {
            throw zzeks.m8829b();
        } else if (i2 == 0) {
            k80.f9577c = "";
            return h;
        } else {
            k80.f9577c = new String(bArr, h, i2, zzekk.f16269a);
            return h + i2;
        }
    }

    /* renamed from: l */
    static int m6122l(byte[] bArr, int i, k80 k80) {
        int h = m6118h(bArr, i, k80);
        int i2 = k80.f9575a;
        if (i2 < 0) {
            throw zzeks.m8829b();
        } else if (i2 == 0) {
            k80.f9577c = "";
            return h;
        } else {
            k80.f9577c = vb0.m7087l(bArr, h, i2);
            return h + i2;
        }
    }

    /* renamed from: m */
    static int m6123m(byte[] bArr, int i, k80 k80) {
        int h = m6118h(bArr, i, k80);
        int i2 = k80.f9575a;
        if (i2 < 0) {
            throw zzeks.m8829b();
        } else if (i2 > bArr.length - h) {
            throw zzeks.m8828a();
        } else if (i2 == 0) {
            k80.f9577c = zzeiu.zziiy;
            return h;
        } else {
            k80.f9577c = zzeiu.zzh(bArr, h, i2);
            return h + i2;
        }
    }

    /* renamed from: n */
    static int m6124n(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* renamed from: o */
    static long m6125o(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    /* renamed from: p */
    static double m6126p(byte[] bArr, int i) {
        return Double.longBitsToDouble(m6125o(bArr, i));
    }

    /* renamed from: q */
    static float m6127q(byte[] bArr, int i) {
        return Float.intBitsToFloat(m6124n(bArr, i));
    }
}
