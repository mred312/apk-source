package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzjx implements zzjz {

    /* renamed from: g */
    private static final byte[] f16559g = new byte[4096];

    /* renamed from: a */
    private final zzon f16560a;

    /* renamed from: b */
    private final long f16561b;

    /* renamed from: c */
    private long f16562c;

    /* renamed from: d */
    private byte[] f16563d = new byte[65536];

    /* renamed from: e */
    private int f16564e;

    /* renamed from: f */
    private int f16565f;

    public zzjx(zzon zzon, long j, long j2) {
        this.f16560a = zzon;
        this.f16562c = j;
        this.f16561b = j2;
    }

    /* renamed from: a */
    private final int m8984a(byte[] bArr, int i, int i2, int i3, boolean z) {
        if (!Thread.interrupted()) {
            int read = this.f16560a.read(bArr, i + i3, i2 - i3);
            if (read != -1) {
                return i3 + read;
            }
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedException();
    }

    /* renamed from: b */
    private final int m8985b(int i) {
        int min = Math.min(this.f16565f, i);
        m8986c(min);
        return min;
    }

    /* renamed from: c */
    private final void m8986c(int i) {
        int i2 = this.f16565f - i;
        this.f16565f = i2;
        this.f16564e = 0;
        byte[] bArr = this.f16563d;
        byte[] bArr2 = i2 < bArr.length - 524288 ? new byte[(65536 + i2)] : bArr;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        this.f16563d = bArr2;
    }

    /* renamed from: d */
    private final void m8987d(int i) {
        if (i != -1) {
            this.f16562c += (long) i;
        }
    }

    /* renamed from: e */
    private final int m8988e(byte[] bArr, int i, int i2) {
        int i3 = this.f16565f;
        if (i3 == 0) {
            return 0;
        }
        int min = Math.min(i3, i2);
        System.arraycopy(this.f16563d, 0, bArr, i, min);
        m8986c(min);
        return min;
    }

    /* renamed from: f */
    private final boolean m8989f(int i, boolean z) {
        int i2 = this.f16564e + i;
        byte[] bArr = this.f16563d;
        if (i2 > bArr.length) {
            this.f16563d = Arrays.copyOf(this.f16563d, zzpt.zzd(bArr.length << 1, 65536 + i2, i2 + 524288));
        }
        int min = Math.min(this.f16565f - this.f16564e, i);
        while (min < i) {
            min = m8984a(this.f16563d, this.f16564e, i, min, false);
            if (min == -1) {
                return false;
            }
        }
        int i3 = this.f16564e + i;
        this.f16564e = i3;
        this.f16565f = Math.max(this.f16565f, i3);
        return true;
    }

    public final long getLength() {
        return this.f16561b;
    }

    public final long getPosition() {
        return this.f16562c;
    }

    public final int read(byte[] bArr, int i, int i2) {
        int e = m8988e(bArr, i, i2);
        if (e == 0) {
            e = m8984a(bArr, i, i2, 0, true);
        }
        m8987d(e);
        return e;
    }

    public final void readFully(byte[] bArr, int i, int i2) {
        zza(bArr, i, i2, false);
    }

    public final boolean zza(byte[] bArr, int i, int i2, boolean z) {
        int e = m8988e(bArr, i, i2);
        while (e < i2 && e != -1) {
            e = m8984a(bArr, i, i2, e, z);
        }
        m8987d(e);
        return e != -1;
    }

    public final int zzaf(int i) {
        int b = m8985b(i);
        if (b == 0) {
            byte[] bArr = f16559g;
            b = m8984a(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        m8987d(b);
        return b;
    }

    public final void zzag(int i) {
        int b = m8985b(i);
        while (b < i && b != -1) {
            byte[] bArr = f16559g;
            b = m8984a(bArr, -b, Math.min(i, bArr.length + b), b, false);
        }
        m8987d(b);
    }

    public final void zzah(int i) {
        m8989f(i, false);
    }

    public final void zzgq() {
        this.f16564e = 0;
    }

    public final void zza(byte[] bArr, int i, int i2) {
        if (m8989f(i2, false)) {
            System.arraycopy(this.f16563d, this.f16564e - i2, bArr, i, i2);
        }
    }
}
