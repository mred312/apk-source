package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzeni {

    /* renamed from: f */
    private static final zzeni f16280f = new zzeni(0, new int[0], new Object[0], false);

    /* renamed from: a */
    private int f16281a;

    /* renamed from: b */
    private int[] f16282b;

    /* renamed from: c */
    private Object[] f16283c;

    /* renamed from: d */
    private int f16284d;

    /* renamed from: e */
    private boolean f16285e;

    private zzeni() {
        this(0, new int[8], new Object[8], true);
    }

    /* renamed from: a */
    static zzeni m8843a(zzeni zzeni, zzeni zzeni2) {
        int i = zzeni.f16281a + zzeni2.f16281a;
        int[] copyOf = Arrays.copyOf(zzeni.f16282b, i);
        System.arraycopy(zzeni2.f16282b, 0, copyOf, zzeni.f16281a, zzeni2.f16281a);
        Object[] copyOf2 = Arrays.copyOf(zzeni.f16283c, i);
        System.arraycopy(zzeni2.f16283c, 0, copyOf2, zzeni.f16281a, zzeni2.f16281a);
        return new zzeni(i, copyOf, copyOf2, true);
    }

    /* renamed from: d */
    private static void m8844d(int i, Object obj, hc0 hc0) {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            hc0.mo13546D(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            hc0.mo13543A(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            hc0.mo13558P(i2, (zzeiu) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                hc0.mo13555M(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzeks.m8833f());
        } else if (hc0.mo13554L() == zzeob.zziug) {
            hc0.mo13553K(i2);
            ((zzeni) obj).zzb(hc0);
            hc0.mo13556N(i2);
        } else {
            hc0.mo13556N(i2);
            ((zzeni) obj).zzb(hc0);
            hc0.mo13553K(i2);
        }
    }

    /* renamed from: e */
    static zzeni m8845e() {
        return new zzeni();
    }

    public static zzeni zzbkg() {
        return f16280f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo17700b(hc0 hc0) {
        if (hc0.mo13554L() == zzeob.zziuh) {
            for (int i = this.f16281a - 1; i >= 0; i--) {
                hc0.mo13578u(this.f16282b[i] >>> 3, this.f16283c[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.f16281a; i2++) {
            hc0.mo13578u(this.f16282b[i2] >>> 3, this.f16283c[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo17701c(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.f16281a; i2++) {
            fa0.m6060c(sb, i, String.valueOf(this.f16282b[i2] >>> 3), this.f16283c[i2]);
        }
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzeni)) {
            return false;
        }
        zzeni zzeni = (zzeni) obj;
        int i = this.f16281a;
        if (i == zzeni.f16281a) {
            int[] iArr = this.f16282b;
            int[] iArr2 = zzeni.f16282b;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                Object[] objArr = this.f16283c;
                Object[] objArr2 = zzeni.f16283c;
                int i3 = this.f16281a;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                return z2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final void mo17703f(int i, Object obj) {
        if (this.f16285e) {
            int i2 = this.f16281a;
            int[] iArr = this.f16282b;
            if (i2 == iArr.length) {
                int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
                this.f16282b = Arrays.copyOf(iArr, i3);
                this.f16283c = Arrays.copyOf(this.f16283c, i3);
            }
            int[] iArr2 = this.f16282b;
            int i4 = this.f16281a;
            iArr2[i4] = i;
            this.f16283c[i4] = obj;
            this.f16281a = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final int hashCode() {
        int i = this.f16281a;
        int i2 = (i + 527) * 31;
        int[] iArr = this.f16282b;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.f16283c;
        int i7 = this.f16281a;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final void zzb(hc0 hc0) {
        if (this.f16281a != 0) {
            if (hc0.mo13554L() == zzeob.zziug) {
                for (int i = 0; i < this.f16281a; i++) {
                    m8844d(this.f16282b[i], this.f16283c[i], hc0);
                }
                return;
            }
            for (int i2 = this.f16281a - 1; i2 >= 0; i2--) {
                m8844d(this.f16282b[i2], this.f16283c[i2], hc0);
            }
        }
    }

    public final void zzbfl() {
        this.f16285e = false;
    }

    public final int zzbhz() {
        int i;
        int i2 = this.f16284d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f16281a; i4++) {
            int i5 = this.f16282b[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzejo.zzm(i6, ((Long) this.f16283c[i4]).longValue());
            } else if (i7 == 1) {
                i = zzejo.zzo(i6, ((Long) this.f16283c[i4]).longValue());
            } else if (i7 == 2) {
                i = zzejo.zzc(i6, (zzeiu) this.f16283c[i4]);
            } else if (i7 == 3) {
                i = (zzejo.zzgu(i6) << 1) + ((zzeni) this.f16283c[i4]).zzbhz();
            } else if (i7 == 5) {
                i = zzejo.zzaj(i6, ((Integer) this.f16283c[i4]).intValue());
            } else {
                throw new IllegalStateException(zzeks.m8833f());
            }
            i3 += i;
        }
        this.f16284d = i3;
        return i3;
    }

    public final int zzbki() {
        int i = this.f16284d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f16281a; i3++) {
            i2 += zzejo.zzd(this.f16282b[i3] >>> 3, (zzeiu) this.f16283c[i3]);
        }
        this.f16284d = i2;
        return i2;
    }

    private zzeni(int i, int[] iArr, Object[] objArr, boolean z) {
        this.f16284d = -1;
        this.f16281a = i;
        this.f16282b = iArr;
        this.f16283c = objArr;
        this.f16285e = z;
    }
}
