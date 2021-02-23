package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
public final class zzku {

    /* renamed from: f */
    private static final zzku f17741f = new zzku(0, new int[0], new Object[0], false);

    /* renamed from: a */
    private int f17742a;

    /* renamed from: b */
    private int[] f17743b;

    /* renamed from: c */
    private Object[] f17744c;

    /* renamed from: d */
    private int f17745d;

    /* renamed from: e */
    private boolean f17746e;

    private zzku() {
        this(0, new int[8], new Object[8], true);
    }

    /* renamed from: a */
    static zzku m10402a(zzku zzku, zzku zzku2) {
        int i = zzku.f17742a + zzku2.f17742a;
        int[] copyOf = Arrays.copyOf(zzku.f17743b, i);
        System.arraycopy(zzku2.f17743b, 0, copyOf, zzku.f17742a, zzku2.f17742a);
        Object[] copyOf2 = Arrays.copyOf(zzku.f17744c, i);
        System.arraycopy(zzku2.f17744c, 0, copyOf2, zzku.f17742a, zzku2.f17742a);
        return new zzku(i, copyOf, copyOf2, true);
    }

    /* renamed from: c */
    private static void m10403c(int i, Object obj, C2882u6 u6Var) {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            u6Var.zza(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            u6Var.mo18900r(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            u6Var.mo18876B(i2, (zzgr) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                u6Var.mo18880F(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzih.m10392f());
        } else if (u6Var.zza() == zzln.zza) {
            u6Var.zza(i2);
            ((zzku) obj).zzb(u6Var);
            u6Var.zzb(i2);
        } else {
            u6Var.zzb(i2);
            ((zzku) obj).zzb(u6Var);
            u6Var.zza(i2);
        }
    }

    /* renamed from: f */
    static zzku m10404f() {
        return new zzku();
    }

    public static zzku zza() {
        return f17741f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo19557b(int i, Object obj) {
        if (this.f17746e) {
            int i2 = this.f17742a;
            int[] iArr = this.f17743b;
            if (i2 == iArr.length) {
                int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
                this.f17743b = Arrays.copyOf(iArr, i3);
                this.f17744c = Arrays.copyOf(this.f17744c, i3);
            }
            int[] iArr2 = this.f17743b;
            int i4 = this.f17742a;
            iArr2[i4] = i;
            this.f17744c[i4] = obj;
            this.f17742a = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo19558d(C2882u6 u6Var) {
        if (u6Var.zza() == zzln.zzb) {
            for (int i = this.f17742a - 1; i >= 0; i--) {
                u6Var.zza(this.f17743b[i] >>> 3, this.f17744c[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.f17742a; i2++) {
            u6Var.zza(this.f17743b[i2] >>> 3, this.f17744c[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final void mo19559e(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.f17742a; i2++) {
            C2917z4.m10015d(sb, i, String.valueOf(this.f17743b[i2] >>> 3), this.f17744c[i2]);
        }
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzku)) {
            return false;
        }
        zzku zzku = (zzku) obj;
        int i = this.f17742a;
        if (i == zzku.f17742a) {
            int[] iArr = this.f17743b;
            int[] iArr2 = zzku.f17743b;
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
                Object[] objArr = this.f17744c;
                Object[] objArr2 = zzku.f17744c;
                int i3 = this.f17742a;
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

    public final int hashCode() {
        int i = this.f17742a;
        int i2 = (i + 527) * 31;
        int[] iArr = this.f17743b;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.f17744c;
        int i7 = this.f17742a;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final void zzb(C2882u6 u6Var) {
        if (this.f17742a != 0) {
            if (u6Var.zza() == zzln.zza) {
                for (int i = 0; i < this.f17742a; i++) {
                    m10403c(this.f17743b[i], this.f17744c[i], u6Var);
                }
                return;
            }
            for (int i2 = this.f17742a - 1; i2 >= 0; i2--) {
                m10403c(this.f17743b[i2], this.f17744c[i2], u6Var);
            }
        }
    }

    public final void zzc() {
        this.f17746e = false;
    }

    public final int zzd() {
        int i = this.f17745d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f17742a; i3++) {
            i2 += zzhg.zzd(this.f17743b[i3] >>> 3, (zzgr) this.f17744c[i3]);
        }
        this.f17745d = i2;
        return i2;
    }

    public final int zze() {
        int i;
        int i2 = this.f17745d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f17742a; i4++) {
            int i5 = this.f17743b[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzhg.zze(i6, ((Long) this.f17744c[i4]).longValue());
            } else if (i7 == 1) {
                i = zzhg.zzg(i6, ((Long) this.f17744c[i4]).longValue());
            } else if (i7 == 2) {
                i = zzhg.zzc(i6, (zzgr) this.f17744c[i4]);
            } else if (i7 == 3) {
                i = (zzhg.zze(i6) << 1) + ((zzku) this.f17744c[i4]).zze();
            } else if (i7 == 5) {
                i = zzhg.zzi(i6, ((Integer) this.f17744c[i4]).intValue());
            } else {
                throw new IllegalStateException(zzih.m10392f());
            }
            i3 += i;
        }
        this.f17745d = i3;
        return i3;
    }

    private zzku(int i, int[] iArr, Object[] objArr, boolean z) {
        this.f17745d = -1;
        this.f17742a = i;
        this.f17743b = iArr;
        this.f17744c = objArr;
        this.f17746e = z;
    }
}
