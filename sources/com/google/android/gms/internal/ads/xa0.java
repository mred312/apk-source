package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class xa0 extends InputStream {

    /* renamed from: a */
    private ua0 f11873a;

    /* renamed from: b */
    private s80 f11874b;

    /* renamed from: c */
    private int f11875c;

    /* renamed from: d */
    private int f11876d;

    /* renamed from: e */
    private int f11877e;

    /* renamed from: f */
    private int f11878f;

    /* renamed from: g */
    private final /* synthetic */ ta0 f11879g;

    public xa0(ta0 ta0) {
        this.f11879g = ta0;
        m7211a();
    }

    /* renamed from: a */
    private final void m7211a() {
        ua0 ua0 = new ua0(this.f11879g, (sa0) null);
        this.f11873a = ua0;
        s80 s80 = (s80) ua0.next();
        this.f11874b = s80;
        this.f11875c = s80.size();
        this.f11876d = 0;
        this.f11877e = 0;
    }

    /* renamed from: b */
    private final void m7212b() {
        int i;
        if (this.f11874b != null && this.f11876d == (i = this.f11875c)) {
            this.f11877e += i;
            this.f11876d = 0;
            if (this.f11873a.hasNext()) {
                s80 s80 = (s80) this.f11873a.next();
                this.f11874b = s80;
                this.f11875c = s80.size();
                return;
            }
            this.f11874b = null;
            this.f11875c = 0;
        }
    }

    /* renamed from: c */
    private final int m7213c(byte[] bArr, int i, int i2) {
        int i3 = i2;
        while (i3 > 0) {
            m7212b();
            if (this.f11874b == null) {
                break;
            }
            int min = Math.min(this.f11875c - this.f11876d, i3);
            if (bArr != null) {
                this.f11874b.zza(bArr, this.f11876d, i, min);
                i += min;
            }
            this.f11876d += min;
            i3 -= min;
        }
        return i2 - i3;
    }

    public final int available() {
        return this.f11879g.size() - (this.f11877e + this.f11876d);
    }

    public final void mark(int i) {
        this.f11878f = this.f11877e + this.f11876d;
    }

    public final boolean markSupported() {
        return true;
    }

    public final int read(byte[] bArr, int i, int i2) {
        bArr.getClass();
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        int c = m7213c(bArr, i, i2);
        if (c == 0) {
            return -1;
        }
        return c;
    }

    public final synchronized void reset() {
        m7211a();
        m7213c((byte[]) null, 0, this.f11878f);
    }

    public final long skip(long j) {
        if (j >= 0) {
            if (j > 2147483647L) {
                j = 2147483647L;
            }
            return (long) m7213c((byte[]) null, 0, (int) j);
        }
        throw new IndexOutOfBoundsException();
    }

    public final int read() {
        m7212b();
        s80 s80 = this.f11874b;
        if (s80 == null) {
            return -1;
        }
        int i = this.f11876d;
        this.f11876d = i + 1;
        return s80.zzfy(i) & 255;
    }
}
