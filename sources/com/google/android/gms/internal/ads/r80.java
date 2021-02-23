package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
class r80 extends s80 {

    /* renamed from: c */
    protected final byte[] f10771c;

    r80(byte[] bArr) {
        bArr.getClass();
        this.f10771c = bArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo14719b(zzeiv zzeiv) {
        zzeiv.zzi(this.f10771c, mo14575i(), size());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public byte mo14574d(int i) {
        return this.f10771c[i];
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeiu) || size() != ((zzeiu) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof r80)) {
            return obj.equals(this);
        }
        r80 r80 = (r80) obj;
        int zzbfw = zzbfw();
        int zzbfw2 = r80.zzbfw();
        if (zzbfw == 0 || zzbfw2 == 0 || zzbfw == zzbfw2) {
            return mo14721h(r80, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final boolean mo14721h(zzeiu zzeiu, int i, int i2) {
        if (i2 <= zzeiu.size()) {
            int i3 = i + i2;
            if (i3 > zzeiu.size()) {
                int size = zzeiu.size();
                StringBuilder sb = new StringBuilder(59);
                sb.append("Ran off end of other: ");
                sb.append(i);
                sb.append(", ");
                sb.append(i2);
                sb.append(", ");
                sb.append(size);
                throw new IllegalArgumentException(sb.toString());
            } else if (!(zzeiu instanceof r80)) {
                return zzeiu.zzaa(i, i3).equals(zzaa(0, i2));
            } else {
                r80 r80 = (r80) zzeiu;
                byte[] bArr = this.f10771c;
                byte[] bArr2 = r80.f10771c;
                int i4 = mo14575i() + i2;
                int i5 = mo14575i();
                int i6 = r80.mo14575i() + i;
                while (i5 < i4) {
                    if (bArr[i5] != bArr2[i6]) {
                        return false;
                    }
                    i5++;
                    i6++;
                }
                return true;
            }
        } else {
            int size2 = size();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(i2);
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public int mo14575i() {
        return 0;
    }

    public int size() {
        return this.f10771c.length;
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.f10771c, mo14575i(), size(), charset);
    }

    public final zzeiu zzaa(int i, int i2) {
        int f = zzeiu.m8790f(i, i2, size());
        if (f == 0) {
            return zzeiu.zziiy;
        }
        return new p80(this.f10771c, mo14575i() + i, f);
    }

    /* access modifiers changed from: protected */
    public void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f10771c, i, bArr, i2, i3);
    }

    public final boolean zzbfr() {
        int i = mo14575i();
        return vb0.m7085j(this.f10771c, i, size() + i);
    }

    public final zzejj zzbfs() {
        return zzejj.m8796a(this.f10771c, mo14575i(), size(), true);
    }

    public byte zzfy(int i) {
        return this.f10771c[i];
    }

    /* access modifiers changed from: protected */
    public final int zzg(int i, int i2, int i3) {
        int i4 = mo14575i() + i2;
        return vb0.m7079d(i, this.f10771c, i4, i3 + i4);
    }

    /* access modifiers changed from: protected */
    public final int zzh(int i, int i2, int i3) {
        return zzekk.m8824b(i, this.f10771c, mo14575i() + i2, i3);
    }
}
