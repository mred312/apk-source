package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public abstract class zzeiu implements Serializable, Iterable<Byte> {

    /* renamed from: b */
    private static final o80 f16191b = (i80.m6313a() ? new t80((l80) null) : new m80((l80) null));
    public static final zzeiu zziiy = new r80(zzekk.zzijg);

    /* renamed from: a */
    private int f16192a = 0;

    zzeiu() {
    }

    /* renamed from: a */
    private static zzeiu m8787a(Iterator<zzeiu> it, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(i)}));
        } else if (i == 1) {
            return it.next();
        } else {
            int i2 = i >>> 1;
            zzeiu a = m8787a(it, i2);
            zzeiu a2 = m8787a(it, i - i2);
            if (Integer.MAX_VALUE - a.size() >= a2.size()) {
                return ta0.m7001h(a, a2);
            }
            int size = a.size();
            int size2 = a2.size();
            StringBuilder sb = new StringBuilder(53);
            sb.append("ByteString would be too long: ");
            sb.append(size);
            sb.append("+");
            sb.append(size2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: c */
    static void m8788c(int i, int i2) {
        if (((i2 - (i + 1)) | i) >= 0) {
            return;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(i2);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    /* renamed from: e */
    static q80 m8789e(int i) {
        return new q80(i, (l80) null);
    }

    /* renamed from: f */
    static int m8790f(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(37);
            sb3.append("End index: ");
            sb3.append(i2);
            sb3.append(" >= ");
            sb3.append(i3);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    /* renamed from: g */
    static zzeiu m8791g(byte[] bArr) {
        return new r80(bArr);
    }

    public static zzejh zzbft() {
        return new zzejh(128);
    }

    public static zzeiu zzg(InputStream inputStream) {
        zzeiu zzeiu;
        ArrayList arrayList = new ArrayList();
        int i = 256;
        while (true) {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            }
            if (i2 == 0) {
                zzeiu = null;
            } else {
                zzeiu = zzh(bArr, 0, i2);
            }
            if (zzeiu == null) {
                return zzl(arrayList);
            }
            arrayList.add(zzeiu);
            i = Math.min(i << 1, 8192);
        }
    }

    public static zzeiu zzh(byte[] bArr, int i, int i2) {
        m8790f(i, i + i2, bArr.length);
        return new r80(f16191b.mo14418a(bArr, i, i2));
    }

    public static zzeiu zzhs(String str) {
        return new r80(str.getBytes(zzekk.f16269a));
    }

    public static zzeiu zzl(Iterable<zzeiu> iterable) {
        int i;
        if (!(iterable instanceof Collection)) {
            i = 0;
            Iterator<zzeiu> it = iterable.iterator();
            while (it.hasNext()) {
                it.next();
                i++;
            }
        } else {
            i = ((Collection) iterable).size();
        }
        if (i == 0) {
            return zziiy;
        }
        return m8787a(iterable.iterator(), i);
    }

    public static zzeiu zzt(byte[] bArr) {
        return zzh(bArr, 0, bArr.length);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract void mo14719b(zzeiv zzeiv);

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract byte mo14574d(int i);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.f16192a;
        if (i == 0) {
            int size = size();
            i = zzh(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.f16192a = i;
        }
        return i;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public abstract int size();

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return zzekk.zzijg;
        }
        byte[] bArr = new byte[size];
        zzb(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(size());
        objArr[2] = size() <= 50 ? lb0.m6451a(this) : String.valueOf(lb0.m6451a(zzaa(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    @Deprecated
    public final void zza(byte[] bArr, int i, int i2, int i3) {
        m8790f(i, i + i3, size());
        m8790f(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            zzb(bArr, i, i2, i3);
        }
    }

    public abstract zzeiu zzaa(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract void zzb(byte[] bArr, int i, int i2, int i3);

    /* renamed from: zzbfp */
    public zzejd iterator() {
        return new l80(this);
    }

    public final String zzbfq() {
        return size() == 0 ? "" : zza(zzekk.f16269a);
    }

    public abstract boolean zzbfr();

    public abstract zzejj zzbfs();

    /* access modifiers changed from: protected */
    public abstract int zzbfu();

    /* access modifiers changed from: protected */
    public abstract boolean zzbfv();

    /* access modifiers changed from: protected */
    public final int zzbfw() {
        return this.f16192a;
    }

    public abstract byte zzfy(int i);

    /* access modifiers changed from: protected */
    public abstract int zzg(int i, int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract int zzh(int i, int i2, int i3);
}
