package com.google.android.gms.internal.ads;

import java.io.OutputStream;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzejh extends OutputStream {

    /* renamed from: f */
    private static final byte[] f16193f = new byte[0];

    /* renamed from: a */
    private final int f16194a = 128;

    /* renamed from: b */
    private final ArrayList<zzeiu> f16195b = new ArrayList<>();

    /* renamed from: c */
    private int f16196c;

    /* renamed from: d */
    private byte[] f16197d = new byte[128];

    /* renamed from: e */
    private int f16198e;

    zzejh(int i) {
    }

    /* renamed from: a */
    private final synchronized int m8794a() {
        return this.f16196c + this.f16198e;
    }

    /* renamed from: b */
    private final void m8795b(int i) {
        this.f16195b.add(new r80(this.f16197d));
        int length = this.f16196c + this.f16197d.length;
        this.f16196c = length;
        this.f16197d = new byte[Math.max(this.f16194a, Math.max(i, length >>> 1))];
        this.f16198e = 0;
    }

    public final String toString() {
        return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(m8794a())});
    }

    public final synchronized void write(int i) {
        if (this.f16198e == this.f16197d.length) {
            m8795b(1);
        }
        byte[] bArr = this.f16197d;
        int i2 = this.f16198e;
        this.f16198e = i2 + 1;
        bArr[i2] = (byte) i;
    }

    public final synchronized zzeiu zzbfg() {
        int i = this.f16198e;
        byte[] bArr = this.f16197d;
        if (i >= bArr.length) {
            this.f16195b.add(new r80(this.f16197d));
            this.f16197d = f16193f;
        } else if (i > 0) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
            this.f16195b.add(new r80(bArr2));
        }
        this.f16196c += this.f16198e;
        this.f16198e = 0;
        return zzeiu.zzl(this.f16195b);
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.f16197d;
        int length = bArr2.length;
        int i3 = this.f16198e;
        if (i2 <= length - i3) {
            System.arraycopy(bArr, i, bArr2, i3, i2);
            this.f16198e += i2;
            return;
        }
        int length2 = bArr2.length - i3;
        System.arraycopy(bArr, i, bArr2, i3, length2);
        int i4 = i2 - length2;
        m8795b(i4);
        System.arraycopy(bArr, i + length2, this.f16197d, 0, i4);
        this.f16198e = i4;
    }
}
