package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzni implements zzkh {

    /* renamed from: a */
    private final zzol f16754a;

    /* renamed from: b */
    private final int f16755b;

    /* renamed from: c */
    private final hg0 f16756c = new hg0();

    /* renamed from: d */
    private final zznj f16757d = new zznj();

    /* renamed from: e */
    private final zzpn f16758e = new zzpn(32);

    /* renamed from: f */
    private final AtomicInteger f16759f = new AtomicInteger();

    /* renamed from: g */
    private ig0 f16760g;

    /* renamed from: h */
    private ig0 f16761h;

    /* renamed from: i */
    private zzhp f16762i;

    /* renamed from: j */
    private long f16763j;

    /* renamed from: k */
    private int f16764k;

    /* renamed from: l */
    private zznk f16765l;

    public zzni(zzol zzol) {
        this.f16754a = zzol;
        int zzio = zzol.zzio();
        this.f16755b = zzio;
        this.f16764k = zzio;
        ig0 ig0 = new ig0(0, zzio);
        this.f16760g = ig0;
        this.f16761h = ig0;
    }

    /* renamed from: a */
    private final void m9027a(long j, byte[] bArr, int i) {
        m9029c(j);
        int i2 = 0;
        while (i2 < i) {
            int i3 = (int) (j - this.f16760g.f9320a);
            int min = Math.min(i - i2, this.f16755b - i3);
            zzoi zzoi = this.f16760g.f9323d;
            System.arraycopy(zzoi.data, i3 + 0, bArr, i2, min);
            j += (long) min;
            i2 += min;
            if (j == this.f16760g.f9321b) {
                this.f16754a.zza(zzoi);
                this.f16760g = this.f16760g.mo14270a();
            }
        }
    }

    /* renamed from: b */
    private final int m9028b(int i) {
        if (this.f16764k == this.f16755b) {
            this.f16764k = 0;
            ig0 ig0 = this.f16761h;
            if (ig0.f9322c) {
                this.f16761h = ig0.f9324e;
            }
            ig0 ig02 = this.f16761h;
            zzoi zzin = this.f16754a.zzin();
            ig0 ig03 = new ig0(this.f16761h.f9321b, this.f16755b);
            ig02.f9323d = zzin;
            ig02.f9324e = ig03;
            ig02.f9322c = true;
        }
        return Math.min(i, this.f16755b - this.f16764k);
    }

    /* renamed from: c */
    private final void m9029c(long j) {
        while (true) {
            ig0 ig0 = this.f16760g;
            if (j >= ig0.f9321b) {
                this.f16754a.zza(ig0.f9323d);
                this.f16760g = this.f16760g.mo14270a();
            } else {
                return;
            }
        }
    }

    /* renamed from: d */
    private final void m9030d() {
        this.f16756c.mo14212g();
        ig0 ig0 = this.f16760g;
        if (ig0.f9322c) {
            ig0 ig02 = this.f16761h;
            int i = (ig02.f9322c ? 1 : 0) + (((int) (ig02.f9320a - ig0.f9320a)) / this.f16755b);
            zzoi[] zzoiArr = new zzoi[i];
            for (int i2 = 0; i2 < i; i2++) {
                zzoiArr[i2] = ig0.f9323d;
                ig0 = ig0.mo14270a();
            }
            this.f16754a.zza(zzoiArr);
        }
        ig0 ig03 = new ig0(0, this.f16755b);
        this.f16760g = ig03;
        this.f16761h = ig03;
        this.f16763j = 0;
        this.f16764k = this.f16755b;
        this.f16754a.zzn();
    }

    /* renamed from: e */
    private final boolean m9031e() {
        return this.f16759f.compareAndSet(0, 1);
    }

    /* renamed from: f */
    private final void m9032f() {
        if (!this.f16759f.compareAndSet(1, 0)) {
            m9030d();
        }
    }

    public final void disable() {
        if (this.f16759f.getAndSet(2) == 0) {
            m9030d();
        }
    }

    public final int zza(zzhr zzhr, zzjl zzjl, boolean z, boolean z2, long j) {
        int i;
        zzjl zzjl2 = zzjl;
        int a = this.f16756c.mo14206a(zzhr, zzjl, z, z2, this.f16762i, this.f16757d);
        if (a == -5) {
            this.f16762i = zzhr.zzahv;
            return -5;
        } else if (a == -4) {
            if (!zzjl.zzgl()) {
                if (zzjl2.zzanz < j) {
                    zzjl2.zzaa(Integer.MIN_VALUE);
                }
                if (zzjl.isEncrypted()) {
                    zznj zznj = this.f16757d;
                    long j2 = zznj.zzawl;
                    this.f16758e.reset(1);
                    m9027a(j2, this.f16758e.data, 1);
                    long j3 = j2 + 1;
                    byte b = this.f16758e.data[0];
                    boolean z3 = (b & 128) != 0;
                    byte b2 = b & Byte.MAX_VALUE;
                    zzjh zzjh = zzjl2.zzany;
                    if (zzjh.f16547iv == null) {
                        zzjh.f16547iv = new byte[16];
                    }
                    m9027a(j3, zzjh.f16547iv, b2);
                    long j4 = j3 + ((long) b2);
                    if (z3) {
                        this.f16758e.reset(2);
                        m9027a(j4, this.f16758e.data, 2);
                        j4 += 2;
                        i = this.f16758e.readUnsignedShort();
                    } else {
                        i = 1;
                    }
                    zzjh zzjh2 = zzjl2.zzany;
                    int[] iArr = zzjh2.numBytesOfClearData;
                    if (iArr == null || iArr.length < i) {
                        iArr = new int[i];
                    }
                    int[] iArr2 = iArr;
                    int[] iArr3 = zzjh2.numBytesOfEncryptedData;
                    if (iArr3 == null || iArr3.length < i) {
                        iArr3 = new int[i];
                    }
                    int[] iArr4 = iArr3;
                    if (z3) {
                        int i2 = i * 6;
                        this.f16758e.reset(i2);
                        m9027a(j4, this.f16758e.data, i2);
                        j4 += (long) i2;
                        this.f16758e.zzbl(0);
                        for (int i3 = 0; i3 < i; i3++) {
                            iArr2[i3] = this.f16758e.readUnsignedShort();
                            iArr4[i3] = this.f16758e.zzjf();
                        }
                    } else {
                        iArr2[0] = 0;
                        iArr4[0] = zznj.size - ((int) (j4 - zznj.zzawl));
                    }
                    zzkg zzkg = zznj.zzaro;
                    zzjh zzjh3 = zzjl2.zzany;
                    zzjh3.set(i, iArr2, iArr4, zzkg.zzaoy, zzjh3.f16547iv, zzkg.zzaox);
                    long j5 = zznj.zzawl;
                    int i4 = (int) (j4 - j5);
                    zznj.zzawl = j5 + ((long) i4);
                    zznj.size -= i4;
                }
                zzjl2.zzac(this.f16757d.size);
                zznj zznj2 = this.f16757d;
                long j6 = zznj2.zzawl;
                ByteBuffer byteBuffer = zzjl2.zzda;
                int i5 = zznj2.size;
                m9029c(j6);
                while (i5 > 0) {
                    int i6 = (int) (j6 - this.f16760g.f9320a);
                    int min = Math.min(i5, this.f16755b - i6);
                    zzoi zzoi = this.f16760g.f9323d;
                    byteBuffer.put(zzoi.data, i6 + 0, min);
                    j6 += (long) min;
                    i5 -= min;
                    if (j6 == this.f16760g.f9321b) {
                        this.f16754a.zza(zzoi);
                        this.f16760g = this.f16760g.mo14270a();
                    }
                }
                m9029c(this.f16757d.zzbgi);
            }
            return -4;
        } else if (a == -3) {
            return -3;
        } else {
            throw new IllegalStateException();
        }
    }

    public final boolean zze(long j, boolean z) {
        long c = this.f16756c.mo14208c(j, z);
        if (c == -1) {
            return false;
        }
        m9029c(c);
        return true;
    }

    public final long zzhv() {
        return this.f16756c.mo14211f();
    }

    public final int zzid() {
        return this.f16756c.mo14214i();
    }

    public final boolean zzie() {
        return this.f16756c.mo14215j();
    }

    public final zzhp zzif() {
        return this.f16756c.mo14216k();
    }

    public final void zzih() {
        long l = this.f16756c.mo14217l();
        if (l != -1) {
            m9029c(l);
        }
    }

    public final void zzk(boolean z) {
        int andSet = this.f16759f.getAndSet(z ? 0 : 2);
        m9030d();
        this.f16756c.mo14213h();
        if (andSet == 2) {
            this.f16762i = null;
        }
    }

    public final void zze(zzhp zzhp) {
        if (zzhp == null) {
            zzhp = null;
        }
        boolean e = this.f16756c.mo14210e(zzhp);
        zznk zznk = this.f16765l;
        if (zznk != null && e) {
            zznk.zzf(zzhp);
        }
    }

    public final void zza(zznk zznk) {
        this.f16765l = zznk;
    }

    public final int zza(zzjz zzjz, int i, boolean z) {
        if (!m9031e()) {
            int zzaf = zzjz.zzaf(i);
            if (zzaf != -1) {
                return zzaf;
            }
            throw new EOFException();
        }
        try {
            int read = zzjz.read(this.f16761h.f9323d.data, this.f16764k + 0, m9028b(i));
            if (read != -1) {
                this.f16764k += read;
                this.f16763j += (long) read;
                return read;
            }
            throw new EOFException();
        } finally {
            m9032f();
        }
    }

    public final void zza(zzpn zzpn, int i) {
        if (!m9031e()) {
            zzpn.zzbm(i);
            return;
        }
        while (i > 0) {
            int b = m9028b(i);
            zzpn.zze(this.f16761h.f9323d.data, this.f16764k + 0, b);
            this.f16764k += b;
            this.f16763j += (long) b;
            i -= b;
        }
        m9032f();
    }

    public final void zza(long j, int i, int i2, int i3, zzkg zzkg) {
        if (!m9031e()) {
            long j2 = j;
            this.f16756c.mo14209d(j);
            return;
        }
        long j3 = j;
        try {
            this.f16756c.mo14207b(j, i, (this.f16763j - ((long) i2)) - ((long) i3), i2, zzkg);
        } finally {
            m9032f();
        }
    }
}
