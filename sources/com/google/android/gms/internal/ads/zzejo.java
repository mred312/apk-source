package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public abstract class zzejo extends zzeiv {

    /* renamed from: b */
    private static final Logger f16203b = Logger.getLogger(zzejo.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final boolean f16204c = sb0.m6918m();

    /* renamed from: a */
    a90 f16205a;

    /* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzejo.zzb.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private zzejo() {
    }

    /* renamed from: a */
    static int m8798a(zzels zzels, wa0 wa0) {
        zzeik zzeik = (zzeik) zzels;
        int a = zzeik.mo17586a();
        if (a == -1) {
            a = wa0.mo14197j(zzeik);
            zzeik.mo17587b(a);
        }
        return zzgw(a) + a;
    }

    /* renamed from: d */
    static int m8799d(int i, zzels zzels, wa0 wa0) {
        return zzgw(i << 3) + m8798a(zzels, wa0);
    }

    @Deprecated
    /* renamed from: f */
    static int m8801f(int i, zzels zzels, wa0 wa0) {
        int zzgw = zzgw(i << 3) << 1;
        zzeik zzeik = (zzeik) zzels;
        int a = zzeik.mo17586a();
        if (a == -1) {
            a = wa0.mo14197j(zzeik);
            zzeik.mo17587b(a);
        }
        return zzgw + a;
    }

    /* renamed from: g */
    private static long m8802g(long j) {
        return (j >> 63) ^ (j << 1);
    }

    /* renamed from: h */
    private static int m8803h(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int zzag(int i, int i2) {
        return zzgw(i << 3) + zzgv(i2);
    }

    public static int zzah(int i, int i2) {
        return zzgw(i << 3) + zzgw(i2);
    }

    public static int zzai(int i, int i2) {
        return zzgw(i << 3) + zzgw(m8803h(i2));
    }

    public static int zzaj(int i, int i2) {
        return zzgw(i << 3) + 4;
    }

    public static int zzak(int i, int i2) {
        return zzgw(i << 3) + 4;
    }

    public static int zzal(int i, int i2) {
        return zzgw(i << 3) + zzgv(i2);
    }

    public static int zzbt(boolean z) {
        return 1;
    }

    public static int zzd(double d) {
        return 8;
    }

    public static int zzd(int i, zzeiu zzeiu) {
        return (zzgw(8) << 1) + zzah(2, i) + zzc(3, zzeiu);
    }

    public static int zzfk(long j) {
        return zzfl(j);
    }

    public static int zzfl(long j) {
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

    public static int zzfm(long j) {
        return zzfl(m8802g(j));
    }

    public static int zzfn(long j) {
        return 8;
    }

    public static int zzfo(long j) {
        return 8;
    }

    public static int zzg(float f) {
        return 4;
    }

    public static int zzgu(int i) {
        return zzgw(i << 3);
    }

    public static int zzgv(int i) {
        if (i >= 0) {
            return zzgw(i);
        }
        return 10;
    }

    public static int zzgw(int i) {
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

    public static int zzgx(int i) {
        return zzgw(m8803h(i));
    }

    public static int zzgy(int i) {
        return 4;
    }

    public static int zzgz(int i) {
        return 4;
    }

    public static int zzh(zzels zzels) {
        int zzbhz = zzels.zzbhz();
        return zzgw(zzbhz) + zzbhz;
    }

    public static int zzha(int i) {
        return zzgv(i);
    }

    @Deprecated
    public static int zzhc(int i) {
        return zzgw(i);
    }

    public static int zzhu(String str) {
        int i;
        try {
            i = vb0.m7080e(str);
        } catch (yb0 unused) {
            i = str.getBytes(zzekk.f16269a).length;
        }
        return zzgw(i) + i;
    }

    public static int zzi(int i, boolean z) {
        return zzgw(i << 3) + 1;
    }

    public static int zzl(int i, long j) {
        return zzgw(i << 3) + zzfl(j);
    }

    public static int zzm(int i, long j) {
        return zzgw(i << 3) + zzfl(j);
    }

    public static int zzn(int i, long j) {
        return zzgw(i << 3) + zzfl(m8802g(j));
    }

    public static int zzo(int i, long j) {
        return zzgw(i << 3) + 8;
    }

    public static int zzp(int i, long j) {
        return zzgw(i << 3) + 8;
    }

    public static zzejo zzv(byte[] bArr) {
        return new C2702a(bArr, 0, bArr.length);
    }

    public static int zzw(byte[] bArr) {
        int length = bArr.length;
        return zzgw(length) + length;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract void mo17611b(int i, zzels zzels, wa0 wa0);

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo17612c(String str, yb0 yb0) {
        f16203b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", yb0);
        byte[] bytes = str.getBytes(zzekk.f16269a);
        try {
            zzgr(bytes.length);
            zzi(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzb(e);
        } catch (zzb e2) {
            throw e2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public abstract void mo17613i(byte[] bArr, int i, int i2);

    public abstract void writeTag(int i, int i2);

    public final void zza(int i, float f) {
        zzaf(i, Float.floatToRawIntBits(f));
    }

    public abstract void zza(int i, zzeiu zzeiu);

    public abstract void zza(int i, zzels zzels);

    public abstract void zzac(int i, int i2);

    public abstract void zzad(int i, int i2);

    public final void zzae(int i, int i2) {
        zzad(i, m8803h(i2));
    }

    public abstract void zzaf(int i, int i2);

    public abstract void zzai(zzeiu zzeiu);

    public final void zzb(int i, double d) {
        zzk(i, Double.doubleToRawLongBits(d));
    }

    public abstract void zzb(int i, zzeiu zzeiu);

    public abstract int zzbha();

    public final void zzbhb() {
        if (zzbha() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzbs(boolean z) {
        zzd(z ? (byte) 1 : 0);
    }

    public final void zzc(double d) {
        zzfj(Double.doubleToRawLongBits(d));
    }

    public abstract void zzd(byte b);

    public final void zzf(float f) {
        zzgt(Float.floatToRawIntBits(f));
    }

    public abstract void zzfh(long j);

    public final void zzfi(long j) {
        zzfh(m8802g(j));
    }

    public abstract void zzfj(long j);

    public abstract void zzg(zzels zzels);

    public abstract void zzgq(int i);

    public abstract void zzgr(int i);

    public final void zzgs(int i) {
        zzgr(m8803h(i));
    }

    public abstract void zzgt(int i);

    public abstract void zzh(int i, boolean z);

    public abstract void zzht(String str);

    public abstract void zzi(int i, long j);

    public abstract void zzi(int i, String str);

    public final void zzj(int i, long j) {
        zzi(i, m8802g(j));
    }

    public abstract void zzk(int i, long j);

    /* renamed from: com.google.android.gms.internal.ads.zzejo$a */
    /* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
    static class C2702a extends zzejo {

        /* renamed from: d */
        private final byte[] f16206d;

        /* renamed from: e */
        private final int f16207e;

        /* renamed from: f */
        private int f16208f;

        C2702a(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            } else if ((i2 | 0 | (bArr.length - i2)) >= 0) {
                this.f16206d = bArr;
                this.f16208f = 0;
                this.f16207e = i2;
            } else {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)}));
            }
        }

        /* renamed from: j */
        private final void m8807j(byte[] bArr, int i, int i2) {
            try {
                System.arraycopy(bArr, i, this.f16206d, this.f16208f, i2);
                this.f16208f += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f16208f), Integer.valueOf(this.f16207e), Integer.valueOf(i2)}), e);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public final void mo17611b(int i, zzels zzels, wa0 wa0) {
            writeTag(i, 2);
            zzeik zzeik = (zzeik) zzels;
            int a = zzeik.mo17586a();
            if (a == -1) {
                a = wa0.mo14197j(zzeik);
                zzeik.mo17587b(a);
            }
            zzgr(a);
            wa0.mo14198k(zzels, this.f16205a);
        }

        /* renamed from: i */
        public final void mo17613i(byte[] bArr, int i, int i2) {
            zzgr(i2);
            m8807j(bArr, 0, i2);
        }

        public final void writeTag(int i, int i2) {
            zzgr((i << 3) | i2);
        }

        public final void zza(int i, zzeiu zzeiu) {
            writeTag(i, 2);
            zzai(zzeiu);
        }

        public final void zzac(int i, int i2) {
            writeTag(i, 0);
            zzgq(i2);
        }

        public final void zzad(int i, int i2) {
            writeTag(i, 0);
            zzgr(i2);
        }

        public final void zzaf(int i, int i2) {
            writeTag(i, 5);
            zzgt(i2);
        }

        public final void zzai(zzeiu zzeiu) {
            zzgr(zzeiu.size());
            zzeiu.mo14719b(this);
        }

        public final void zzb(int i, zzeiu zzeiu) {
            writeTag(1, 3);
            zzad(2, i);
            zza(3, zzeiu);
            writeTag(1, 4);
        }

        public final int zzbha() {
            return this.f16207e - this.f16208f;
        }

        public final void zzd(byte b) {
            try {
                byte[] bArr = this.f16206d;
                int i = this.f16208f;
                this.f16208f = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f16208f), Integer.valueOf(this.f16207e), 1}), e);
            }
        }

        public final void zzfh(long j) {
            if (!zzejo.f16204c || zzbha() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.f16206d;
                    int i = this.f16208f;
                    this.f16208f = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f16206d;
                    int i2 = this.f16208f;
                    this.f16208f = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f16208f), Integer.valueOf(this.f16207e), 1}), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.f16206d;
                    int i3 = this.f16208f;
                    this.f16208f = i3 + 1;
                    sb0.m6913h(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.f16206d;
                int i4 = this.f16208f;
                this.f16208f = i4 + 1;
                sb0.m6913h(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void zzfj(long j) {
            try {
                byte[] bArr = this.f16206d;
                int i = this.f16208f;
                int i2 = i + 1;
                this.f16208f = i2;
                bArr[i] = (byte) ((int) j);
                int i3 = i2 + 1;
                this.f16208f = i3;
                bArr[i2] = (byte) ((int) (j >> 8));
                int i4 = i3 + 1;
                this.f16208f = i4;
                bArr[i3] = (byte) ((int) (j >> 16));
                int i5 = i4 + 1;
                this.f16208f = i5;
                bArr[i4] = (byte) ((int) (j >> 24));
                int i6 = i5 + 1;
                this.f16208f = i6;
                bArr[i5] = (byte) ((int) (j >> 32));
                int i7 = i6 + 1;
                this.f16208f = i7;
                bArr[i6] = (byte) ((int) (j >> 40));
                int i8 = i7 + 1;
                this.f16208f = i8;
                bArr[i7] = (byte) ((int) (j >> 48));
                this.f16208f = i8 + 1;
                bArr[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f16208f), Integer.valueOf(this.f16207e), 1}), e);
            }
        }

        public final void zzg(zzels zzels) {
            zzgr(zzels.zzbhz());
            zzels.zzb(this);
        }

        public final void zzgq(int i) {
            if (i >= 0) {
                zzgr(i);
            } else {
                zzfh((long) i);
            }
        }

        public final void zzgr(int i) {
            if (!zzejo.f16204c || i80.m6313a() || zzbha() < 5) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.f16206d;
                    int i2 = this.f16208f;
                    this.f16208f = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f16206d;
                    int i3 = this.f16208f;
                    this.f16208f = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f16208f), Integer.valueOf(this.f16207e), 1}), e);
                }
            } else if ((i & -128) == 0) {
                byte[] bArr3 = this.f16206d;
                int i4 = this.f16208f;
                this.f16208f = i4 + 1;
                sb0.m6913h(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.f16206d;
                int i5 = this.f16208f;
                this.f16208f = i5 + 1;
                sb0.m6913h(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.f16206d;
                    int i7 = this.f16208f;
                    this.f16208f = i7 + 1;
                    sb0.m6913h(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.f16206d;
                int i8 = this.f16208f;
                this.f16208f = i8 + 1;
                sb0.m6913h(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.f16206d;
                    int i10 = this.f16208f;
                    this.f16208f = i10 + 1;
                    sb0.m6913h(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.f16206d;
                int i11 = this.f16208f;
                this.f16208f = i11 + 1;
                sb0.m6913h(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.f16206d;
                    int i13 = this.f16208f;
                    this.f16208f = i13 + 1;
                    sb0.m6913h(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.f16206d;
                int i14 = this.f16208f;
                this.f16208f = i14 + 1;
                sb0.m6913h(bArr10, (long) i14, (byte) (i12 | 128));
                byte[] bArr11 = this.f16206d;
                int i15 = this.f16208f;
                this.f16208f = i15 + 1;
                sb0.m6913h(bArr11, (long) i15, (byte) (i12 >>> 7));
            }
        }

        public final void zzgt(int i) {
            try {
                byte[] bArr = this.f16206d;
                int i2 = this.f16208f;
                int i3 = i2 + 1;
                this.f16208f = i3;
                bArr[i2] = (byte) i;
                int i4 = i3 + 1;
                this.f16208f = i4;
                bArr[i3] = (byte) (i >> 8);
                int i5 = i4 + 1;
                this.f16208f = i5;
                bArr[i4] = (byte) (i >> 16);
                this.f16208f = i5 + 1;
                bArr[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f16208f), Integer.valueOf(this.f16207e), 1}), e);
            }
        }

        public final void zzh(int i, boolean z) {
            writeTag(i, 0);
            zzd(z ? (byte) 1 : 0);
        }

        public final void zzht(String str) {
            int i = this.f16208f;
            try {
                int zzgw = zzejo.zzgw(str.length() * 3);
                int zzgw2 = zzejo.zzgw(str.length());
                if (zzgw2 == zzgw) {
                    int i2 = i + zzgw2;
                    this.f16208f = i2;
                    int a = vb0.m7076a(str, this.f16206d, i2, zzbha());
                    this.f16208f = i;
                    zzgr((a - i) - zzgw2);
                    this.f16208f = a;
                    return;
                }
                zzgr(vb0.m7080e(str));
                this.f16208f = vb0.m7076a(str, this.f16206d, this.f16208f, zzbha());
            } catch (yb0 e) {
                this.f16208f = i;
                mo17612c(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(e2);
            }
        }

        public final void zzi(int i, long j) {
            writeTag(i, 0);
            zzfh(j);
        }

        public final void zzk(int i, long j) {
            writeTag(i, 1);
            zzfj(j);
        }

        public final void zza(int i, zzels zzels) {
            writeTag(1, 3);
            zzad(2, i);
            writeTag(3, 2);
            zzg(zzels);
            writeTag(1, 4);
        }

        public final void zzi(int i, String str) {
            writeTag(i, 2);
            zzht(str);
        }

        public final void zzi(byte[] bArr, int i, int i2) {
            m8807j(bArr, i, i2);
        }
    }

    public static int zza(int i, zzekx zzekx) {
        int zzgw = zzgw(i << 3);
        int zzbhz = zzekx.zzbhz();
        return zzgw + zzgw(zzbhz) + zzbhz;
    }

    public static int zzaj(zzeiu zzeiu) {
        int size = zzeiu.size();
        return zzgw(size) + size;
    }

    public static int zzb(int i, float f) {
        return zzgw(i << 3) + 4;
    }

    public static int zzc(int i, double d) {
        return zzgw(i << 3) + 8;
    }

    @Deprecated
    public static int zzi(zzels zzels) {
        return zzels.zzbhz();
    }

    public static int zzj(int i, String str) {
        return zzgw(i << 3) + zzhu(str);
    }

    public static int zzb(int i, zzels zzels) {
        return (zzgw(8) << 1) + zzah(2, i) + zzgw(24) + zzh(zzels);
    }

    public static int zzc(int i, zzeiu zzeiu) {
        int zzgw = zzgw(i << 3);
        int size = zzeiu.size();
        return zzgw + zzgw(size) + size;
    }

    public static int zza(zzekx zzekx) {
        int zzbhz = zzekx.zzbhz();
        return zzgw(zzbhz) + zzbhz;
    }

    public static int zzb(int i, zzekx zzekx) {
        return (zzgw(8) << 1) + zzah(2, i) + zza(3, zzekx);
    }
}
