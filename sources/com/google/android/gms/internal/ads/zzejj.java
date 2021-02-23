package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public abstract class zzejj {

    /* renamed from: a */
    int f16199a;

    /* renamed from: b */
    int f16200b;

    /* renamed from: c */
    int f16201c;

    /* renamed from: d */
    x80 f16202d;

    private zzejj() {
        this.f16200b = 100;
        this.f16201c = Integer.MAX_VALUE;
    }

    /* renamed from: a */
    static zzejj m8796a(byte[] bArr, int i, int i2, boolean z) {
        w80 w80 = new w80(bArr, i, i2, z);
        try {
            w80.zzge(i2);
            return w80;
        } catch (zzeks e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static long zzfg(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static int zzgg(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract long mo14900b();

    public abstract double readDouble();

    public abstract float readFloat();

    public abstract String readString();

    public abstract int zzbga();

    public abstract long zzbgb();

    public abstract long zzbgc();

    public abstract int zzbgd();

    public abstract long zzbge();

    public abstract int zzbgf();

    public abstract boolean zzbgg();

    public abstract String zzbgh();

    public abstract zzeiu zzbgi();

    public abstract int zzbgj();

    public abstract int zzbgk();

    public abstract int zzbgl();

    public abstract long zzbgm();

    public abstract int zzbgn();

    public abstract long zzbgo();

    public abstract boolean zzbgq();

    public abstract int zzbgr();

    public abstract void zzgc(int i);

    public abstract boolean zzgd(int i);

    public abstract int zzge(int i);

    public abstract void zzgf(int i);
}
