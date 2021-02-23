package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
public abstract class zzhg extends zzgo {

    /* renamed from: b */
    private static final Logger f17664b = Logger.getLogger(zzhg.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final boolean f17665c = C2758f6.m9435m();

    /* renamed from: a */
    C2879u3 f17666a;

    /* renamed from: com.google.android.gms.internal.measurement.zzhg$a */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
    private static class C2924a extends zzhg {

        /* renamed from: d */
        private final byte[] f17667d;

        /* renamed from: e */
        private final int f17668e;

        /* renamed from: f */
        private int f17669f;

        C2924a(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            } else if ((i2 | 0 | (bArr.length - i2)) >= 0) {
                this.f17667d = bArr;
                this.f17669f = 0;
                this.f17668e = i2;
            } else {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)}));
            }
        }

        /* renamed from: j */
        private final void m10369j(byte[] bArr, int i, int i2) {
            try {
                System.arraycopy(bArr, i, this.f17667d, this.f17669f, i2);
                this.f17669f += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f17669f), Integer.valueOf(this.f17668e), Integer.valueOf(i2)}), e);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public final void mo19469b(int i, zzjh zzjh, C2793j5 j5Var) {
            zza(i, 2);
            zzgh zzgh = (zzgh) zzjh;
            int a = zzgh.mo19457a();
            if (a == -1) {
                a = j5Var.zzb(zzgh);
                zzgh.mo19458b(a);
            }
            zzb(a);
            j5Var.mo18546f(zzjh, this.f17666a);
        }

        /* renamed from: e */
        public final void mo19471e(byte[] bArr, int i, int i2) {
            zzb(i2);
            m10369j(bArr, 0, i2);
        }

        public final void zza(int i, int i2) {
            zzb((i << 3) | i2);
        }

        public final void zzb(int i, int i2) {
            zza(i, 0);
            zza(i2);
        }

        public final void zzc(int i, int i2) {
            zza(i, 0);
            zzb(i2);
        }

        public final void zzd(int i) {
            try {
                byte[] bArr = this.f17667d;
                int i2 = this.f17669f;
                int i3 = i2 + 1;
                this.f17669f = i3;
                bArr[i2] = (byte) i;
                int i4 = i3 + 1;
                this.f17669f = i4;
                bArr[i3] = (byte) (i >> 8);
                int i5 = i4 + 1;
                this.f17669f = i5;
                bArr[i4] = (byte) (i >> 16);
                this.f17669f = i5 + 1;
                bArr[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f17669f), Integer.valueOf(this.f17668e), 1}), e);
            }
        }

        public final void zze(int i, int i2) {
            zza(i, 5);
            zzd(i2);
        }

        public final void zza(int i, long j) {
            zza(i, 0);
            zza(j);
        }

        public final void zzb(int i, zzgr zzgr) {
            zza(1, 3);
            zzc(2, i);
            zza(3, zzgr);
            zza(1, 4);
        }

        public final void zzc(int i, long j) {
            zza(i, 1);
            zzc(j);
        }

        public final void zza(int i, boolean z) {
            zza(i, 0);
            zza(z ? (byte) 1 : 0);
        }

        public final void zzc(long j) {
            try {
                byte[] bArr = this.f17667d;
                int i = this.f17669f;
                int i2 = i + 1;
                this.f17669f = i2;
                bArr[i] = (byte) ((int) j);
                int i3 = i2 + 1;
                this.f17669f = i3;
                bArr[i2] = (byte) ((int) (j >> 8));
                int i4 = i3 + 1;
                this.f17669f = i4;
                bArr[i3] = (byte) ((int) (j >> 16));
                int i5 = i4 + 1;
                this.f17669f = i5;
                bArr[i4] = (byte) ((int) (j >> 24));
                int i6 = i5 + 1;
                this.f17669f = i6;
                bArr[i5] = (byte) ((int) (j >> 32));
                int i7 = i6 + 1;
                this.f17669f = i7;
                bArr[i6] = (byte) ((int) (j >> 40));
                int i8 = i7 + 1;
                this.f17669f = i8;
                bArr[i7] = (byte) ((int) (j >> 48));
                this.f17669f = i8 + 1;
                bArr[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f17669f), Integer.valueOf(this.f17668e), 1}), e);
            }
        }

        public final void zza(int i, String str) {
            zza(i, 2);
            zza(str);
        }

        public final void zzb(int i) {
            if (!zzhg.f17665c || C2723b3.m9321b() || zza() < 5) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.f17667d;
                    int i2 = this.f17669f;
                    this.f17669f = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f17667d;
                    int i3 = this.f17669f;
                    this.f17669f = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f17669f), Integer.valueOf(this.f17668e), 1}), e);
                }
            } else if ((i & -128) == 0) {
                byte[] bArr3 = this.f17667d;
                int i4 = this.f17669f;
                this.f17669f = i4 + 1;
                C2758f6.m9434l(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.f17667d;
                int i5 = this.f17669f;
                this.f17669f = i5 + 1;
                C2758f6.m9434l(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.f17667d;
                    int i7 = this.f17669f;
                    this.f17669f = i7 + 1;
                    C2758f6.m9434l(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.f17667d;
                int i8 = this.f17669f;
                this.f17669f = i8 + 1;
                C2758f6.m9434l(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.f17667d;
                    int i10 = this.f17669f;
                    this.f17669f = i10 + 1;
                    C2758f6.m9434l(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.f17667d;
                int i11 = this.f17669f;
                this.f17669f = i11 + 1;
                C2758f6.m9434l(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.f17667d;
                    int i13 = this.f17669f;
                    this.f17669f = i13 + 1;
                    C2758f6.m9434l(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.f17667d;
                int i14 = this.f17669f;
                this.f17669f = i14 + 1;
                C2758f6.m9434l(bArr10, (long) i14, (byte) (i12 | 128));
                byte[] bArr11 = this.f17667d;
                int i15 = this.f17669f;
                this.f17669f = i15 + 1;
                C2758f6.m9434l(bArr11, (long) i15, (byte) (i12 >>> 7));
            }
        }

        public final void zza(int i, zzgr zzgr) {
            zza(i, 2);
            zza(zzgr);
        }

        public final void zza(zzgr zzgr) {
            zzb(zzgr.zza());
            zzgr.mo18780b(this);
        }

        public final void zza(int i, zzjh zzjh) {
            zza(1, 3);
            zzc(2, i);
            zza(3, 2);
            zza(zzjh);
            zza(1, 4);
        }

        public final void zza(zzjh zzjh) {
            zzb(zzjh.zzbo());
            zzjh.zza(this);
        }

        public final void zza(byte b) {
            try {
                byte[] bArr = this.f17667d;
                int i = this.f17669f;
                this.f17669f = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f17669f), Integer.valueOf(this.f17668e), 1}), e);
            }
        }

        public final void zza(int i) {
            if (i >= 0) {
                zzb(i);
            } else {
                zza((long) i);
            }
        }

        public final void zza(long j) {
            if (!zzhg.f17665c || zza() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.f17667d;
                    int i = this.f17669f;
                    this.f17669f = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f17667d;
                    int i2 = this.f17669f;
                    this.f17669f = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f17669f), Integer.valueOf(this.f17668e), 1}), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.f17667d;
                    int i3 = this.f17669f;
                    this.f17669f = i3 + 1;
                    C2758f6.m9434l(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.f17667d;
                int i4 = this.f17669f;
                this.f17669f = i4 + 1;
                C2758f6.m9434l(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void zza(byte[] bArr, int i, int i2) {
            m10369j(bArr, i, i2);
        }

        public final void zza(String str) {
            int i = this.f17669f;
            try {
                int zzg = zzhg.zzg(str.length() * 3);
                int zzg2 = zzhg.zzg(str.length());
                if (zzg2 == zzg) {
                    int i2 = i + zzg2;
                    this.f17669f = i2;
                    int e = C2794j6.m9534e(str, this.f17667d, i2, zza());
                    this.f17669f = i;
                    zzb((e - i) - zzg2);
                    this.f17669f = e;
                    return;
                }
                zzb(C2794j6.m9533d(str));
                this.f17669f = C2794j6.m9534e(str, this.f17667d, this.f17669f, zza());
            } catch (C2818m6 e2) {
                this.f17669f = i;
                mo19470c(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzb(e3);
            }
        }

        public final int zza() {
            return this.f17668e - this.f17669f;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
    public static class zzb extends IOException {
        zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        zzb(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r0 = r3.length()
                java.lang.String r1 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                if (r0 == 0) goto L_0x0011
                java.lang.String r3 = r1.concat(r3)
                goto L_0x0016
            L_0x0011:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r1)
            L_0x0016:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhg.zzb.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private zzhg() {
    }

    /* renamed from: a */
    static int m10360a(zzjh zzjh, C2793j5 j5Var) {
        zzgh zzgh = (zzgh) zzjh;
        int a = zzgh.mo19457a();
        if (a == -1) {
            a = j5Var.zzb(zzgh);
            zzgh.mo19458b(a);
        }
        return zzg(a) + a;
    }

    /* renamed from: d */
    static int m10361d(int i, zzjh zzjh, C2793j5 j5Var) {
        return zzg(i << 3) + m10360a(zzjh, j5Var);
    }

    @Deprecated
    /* renamed from: f */
    static int m10362f(int i, zzjh zzjh, C2793j5 j5Var) {
        int zzg = zzg(i << 3) << 1;
        zzgh zzgh = (zzgh) zzjh;
        int a = zzgh.mo19457a();
        if (a == -1) {
            a = j5Var.zzb(zzgh);
            zzgh.mo19458b(a);
        }
        return zzg + a;
    }

    /* renamed from: h */
    private static long m10364h(long j) {
        return (j >> 63) ^ (j << 1);
    }

    /* renamed from: i */
    private static int m10365i(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static zzhg zza(byte[] bArr) {
        return new C2924a(bArr, 0, bArr.length);
    }

    public static int zzb(double d) {
        return 8;
    }

    public static int zzb(float f) {
        return 4;
    }

    public static int zzb(boolean z) {
        return 1;
    }

    public static int zze(int i, long j) {
        return zzg(i << 3) + zze(j);
    }

    public static int zze(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static int zzf(int i, int i2) {
        return zzg(i << 3) + zzf(i2);
    }

    public static int zzg(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzg(int i, int i2) {
        return zzg(i << 3) + zzg(i2);
    }

    public static int zzg(long j) {
        return 8;
    }

    public static int zzh(int i, int i2) {
        return zzg(i << 3) + zzg(m10365i(i2));
    }

    public static int zzh(long j) {
        return 8;
    }

    public static int zzi(int i) {
        return 4;
    }

    public static int zzi(int i, int i2) {
        return zzg(i << 3) + 4;
    }

    public static int zzj(int i) {
        return 4;
    }

    public static int zzj(int i, int i2) {
        return zzg(i << 3) + 4;
    }

    public static int zzk(int i, int i2) {
        return zzg(i << 3) + zzf(i2);
    }

    @Deprecated
    public static int zzl(int i) {
        return zzg(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract void mo19469b(int i, zzjh zzjh, C2793j5 j5Var);

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo19470c(String str, C2818m6 m6Var) {
        f17664b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", m6Var);
        byte[] bytes = str.getBytes(zzic.f17731a);
        try {
            zzb(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzb(e);
        } catch (zzb e2) {
            throw e2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public abstract void mo19471e(byte[] bArr, int i, int i2);

    public abstract int zza();

    public abstract void zza(byte b);

    public abstract void zza(int i);

    public abstract void zza(int i, int i2);

    public abstract void zza(int i, long j);

    public abstract void zza(int i, zzgr zzgr);

    public abstract void zza(int i, zzjh zzjh);

    public abstract void zza(int i, String str);

    public abstract void zza(int i, boolean z);

    public abstract void zza(long j);

    public abstract void zza(zzgr zzgr);

    public abstract void zza(zzjh zzjh);

    public abstract void zza(String str);

    public abstract void zzb(int i);

    public abstract void zzb(int i, int i2);

    public final void zzb(int i, long j) {
        zza(i, m10364h(j));
    }

    public abstract void zzb(int i, zzgr zzgr);

    public final void zzc(int i) {
        zzb(m10365i(i));
    }

    public abstract void zzc(int i, int i2);

    public abstract void zzc(int i, long j);

    public abstract void zzc(long j);

    public abstract void zzd(int i);

    public final void zzd(int i, int i2) {
        zzc(i, m10365i(i2));
    }

    public abstract void zze(int i, int i2);

    public static int zzc(int i, zzgr zzgr) {
        int zzg = zzg(i << 3);
        int zza = zzgr.zza();
        return zzg + zzg(zza) + zza;
    }

    public static int zzd(int i, long j) {
        return zzg(i << 3) + zze(j);
    }

    public final void zzb(long j) {
        zza(m10364h(j));
    }

    public static int zzb(int i, float f) {
        return zzg(i << 3) + 4;
    }

    public static int zze(int i) {
        return zzg(i << 3);
    }

    public static int zzf(int i, long j) {
        return zzg(i << 3) + zze(m10364h(j));
    }

    public static int zzg(int i, long j) {
        return zzg(i << 3) + 8;
    }

    public static int zzh(int i, long j) {
        return zzg(i << 3) + 8;
    }

    public static int zzk(int i) {
        return zzf(i);
    }

    public final void zza(int i, float f) {
        zze(i, Float.floatToRawIntBits(f));
    }

    public static int zzb(int i, double d) {
        return zzg(i << 3) + 8;
    }

    public static int zzd(int i, zzgr zzgr) {
        return (zzg(8) << 1) + zzg(2, i) + zzc(3, zzgr);
    }

    public static int zzh(int i) {
        return zzg(m10365i(i));
    }

    public final void zza(int i, double d) {
        zzc(i, Double.doubleToRawLongBits(d));
    }

    public static int zzb(int i, boolean z) {
        return zzg(i << 3) + 1;
    }

    @Deprecated
    public static int zzc(zzjh zzjh) {
        return zzjh.zzbo();
    }

    public static int zzf(int i) {
        if (i >= 0) {
            return zzg(i);
        }
        return 10;
    }

    public final void zza(float f) {
        zzd(Float.floatToRawIntBits(f));
    }

    public static int zzb(int i, String str) {
        return zzg(i << 3) + zzb(str);
    }

    public static int zzf(long j) {
        return zze(m10364h(j));
    }

    public final void zza(double d) {
        zzc(Double.doubleToRawLongBits(d));
    }

    public static int zzd(long j) {
        return zze(j);
    }

    public final void zza(boolean z) {
        zza(z ? (byte) 1 : 0);
    }

    public static int zza(int i, zziq zziq) {
        int zzg = zzg(i << 3);
        int zzb2 = zziq.zzb();
        return zzg + zzg(zzb2) + zzb2;
    }

    public static int zzb(int i, zzjh zzjh) {
        return (zzg(8) << 1) + zzg(2, i) + zzg(24) + zzb(zzjh);
    }

    public static int zza(zziq zziq) {
        int zzb2 = zziq.zzb();
        return zzg(zzb2) + zzb2;
    }

    public static int zzb(int i, zziq zziq) {
        return (zzg(8) << 1) + zzg(2, i) + zza(3, zziq);
    }

    public static int zzb(String str) {
        int i;
        try {
            i = C2794j6.m9533d(str);
        } catch (C2818m6 unused) {
            i = str.getBytes(zzic.f17731a).length;
        }
        return zzg(i) + i;
    }

    public static int zzb(zzgr zzgr) {
        int zza = zzgr.zza();
        return zzg(zza) + zza;
    }

    public static int zzb(byte[] bArr) {
        int length = bArr.length;
        return zzg(length) + length;
    }

    public static int zzb(zzjh zzjh) {
        int zzbo = zzjh.zzbo();
        return zzg(zzbo) + zzbo;
    }

    public final void zzb() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }
}
