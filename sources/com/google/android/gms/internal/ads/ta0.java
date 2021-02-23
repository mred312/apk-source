package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class ta0 extends zzeiu {

    /* renamed from: h */
    static final int[] f11155h = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};

    /* renamed from: c */
    private final int f11156c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzeiu f11157d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final zzeiu f11158e;

    /* renamed from: f */
    private final int f11159f;

    /* renamed from: g */
    private final int f11160g;

    private ta0(zzeiu zzeiu, zzeiu zzeiu2) {
        this.f11157d = zzeiu;
        this.f11158e = zzeiu2;
        int size = zzeiu.size();
        this.f11159f = size;
        this.f11156c = size + zzeiu2.size();
        this.f11160g = Math.max(zzeiu.zzbfu(), zzeiu2.zzbfu()) + 1;
    }

    /* renamed from: h */
    static zzeiu m7001h(zzeiu zzeiu, zzeiu zzeiu2) {
        if (zzeiu2.size() == 0) {
            return zzeiu;
        }
        if (zzeiu.size() == 0) {
            return zzeiu2;
        }
        int size = zzeiu.size() + zzeiu2.size();
        if (size < 128) {
            return m7003j(zzeiu, zzeiu2);
        }
        if (zzeiu instanceof ta0) {
            ta0 ta0 = (ta0) zzeiu;
            if (ta0.f11158e.size() + zzeiu2.size() < 128) {
                return new ta0(ta0.f11157d, m7003j(ta0.f11158e, zzeiu2));
            } else if (ta0.f11157d.zzbfu() > ta0.f11158e.zzbfu() && ta0.zzbfu() > zzeiu2.zzbfu()) {
                return new ta0(ta0.f11157d, new ta0(ta0.f11158e, zzeiu2));
            }
        }
        if (size >= m7005l(Math.max(zzeiu.zzbfu(), zzeiu2.zzbfu()) + 1)) {
            return new ta0(zzeiu, zzeiu2);
        }
        return new va0((sa0) null).m7074c(zzeiu, zzeiu2);
    }

    /* renamed from: j */
    private static zzeiu m7003j(zzeiu zzeiu, zzeiu zzeiu2) {
        int size = zzeiu.size();
        int size2 = zzeiu2.size();
        byte[] bArr = new byte[(size + size2)];
        zzeiu.zza(bArr, 0, 0, size);
        zzeiu2.zza(bArr, 0, size, size2);
        return zzeiu.m8791g(bArr);
    }

    /* renamed from: l */
    static int m7005l(int i) {
        int[] iArr = f11155h;
        if (i >= iArr.length) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo14719b(zzeiv zzeiv) {
        this.f11157d.mo14719b(zzeiv);
        this.f11158e.mo14719b(zzeiv);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final byte mo14574d(int i) {
        int i2 = this.f11159f;
        if (i < i2) {
            return this.f11157d.mo14574d(i);
        }
        return this.f11158e.mo14574d(i - i2);
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeiu)) {
            return false;
        }
        zzeiu zzeiu = (zzeiu) obj;
        if (this.f11156c != zzeiu.size()) {
            return false;
        }
        if (this.f11156c == 0) {
            return true;
        }
        int zzbfw = zzbfw();
        int zzbfw2 = zzeiu.zzbfw();
        if (zzbfw != 0 && zzbfw2 != 0 && zzbfw != zzbfw2) {
            return false;
        }
        ua0 ua0 = new ua0(this, (sa0) null);
        s80 s80 = (s80) ua0.next();
        ua0 ua02 = new ua0(zzeiu, (sa0) null);
        s80 s802 = (s80) ua02.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = s80.size() - i;
            int size2 = s802.size() - i2;
            int min = Math.min(size, size2);
            if (i == 0) {
                z = s80.mo14721h(s802, i2, min);
            } else {
                z = s802.mo14721h(s80, i, min);
            }
            if (!z) {
                return false;
            }
            i3 += min;
            int i4 = this.f11156c;
            if (i3 < i4) {
                if (min == size) {
                    s80 = (s80) ua0.next();
                    i = 0;
                } else {
                    i += min;
                }
                if (min == size2) {
                    s802 = (s80) ua02.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
            } else if (i3 == i4) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public final int size() {
        return this.f11156c;
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(toByteArray(), charset);
    }

    public final zzeiu zzaa(int i, int i2) {
        int f = zzeiu.m8790f(i, i2, this.f11156c);
        if (f == 0) {
            return zzeiu.zziiy;
        }
        if (f == this.f11156c) {
            return this;
        }
        int i3 = this.f11159f;
        if (i2 <= i3) {
            return this.f11157d.zzaa(i, i2);
        }
        if (i >= i3) {
            return this.f11158e.zzaa(i - i3, i2 - i3);
        }
        zzeiu zzeiu = this.f11157d;
        return new ta0(zzeiu.zzaa(i, zzeiu.size()), this.f11158e.zzaa(0, i2 - this.f11159f));
    }

    /* access modifiers changed from: protected */
    public final void zzb(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.f11159f;
        if (i4 <= i5) {
            this.f11157d.zzb(bArr, i, i2, i3);
        } else if (i >= i5) {
            this.f11158e.zzb(bArr, i - i5, i2, i3);
        } else {
            int i6 = i5 - i;
            this.f11157d.zzb(bArr, i, i2, i6);
            this.f11158e.zzb(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    public final zzejd zzbfp() {
        return new sa0(this);
    }

    public final boolean zzbfr() {
        int zzg = this.f11157d.zzg(0, 0, this.f11159f);
        zzeiu zzeiu = this.f11158e;
        if (zzeiu.zzg(zzg, 0, zzeiu.size()) == 0) {
            return true;
        }
        return false;
    }

    public final zzejj zzbfs() {
        return new v80(new xa0(this));
    }

    /* access modifiers changed from: protected */
    public final int zzbfu() {
        return this.f11160g;
    }

    /* access modifiers changed from: protected */
    public final boolean zzbfv() {
        return this.f11156c >= m7005l(this.f11160g);
    }

    public final byte zzfy(int i) {
        zzeiu.m8788c(i, this.f11156c);
        return mo14574d(i);
    }

    /* access modifiers changed from: protected */
    public final int zzg(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.f11159f;
        if (i4 <= i5) {
            return this.f11157d.zzg(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.f11158e.zzg(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.f11158e.zzg(this.f11157d.zzg(i, i2, i6), 0, i3 - i6);
    }

    /* access modifiers changed from: protected */
    public final int zzh(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.f11159f;
        if (i4 <= i5) {
            return this.f11157d.zzh(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.f11158e.zzh(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.f11158e.zzh(this.f11157d.zzh(i, i2, i6), 0, i3 - i6);
    }

    /* synthetic */ ta0(zzeiu zzeiu, zzeiu zzeiu2, sa0 sa0) {
        this(zzeiu, zzeiu2);
    }
}
