package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbi extends ByteArrayOutputStream {

    /* renamed from: a */
    private final zzat f13323a;

    public zzbi(zzat zzat, int i) {
        this.f13323a = zzat;
        this.buf = zzat.zzf(Math.max(i, 256));
    }

    /* renamed from: a */
    private final void m7807a(int i) {
        int i2 = this.count;
        if (i2 + i > this.buf.length) {
            byte[] zzf = this.f13323a.zzf((i2 + i) << 1);
            System.arraycopy(this.buf, 0, zzf, 0, this.count);
            this.f13323a.zza(this.buf);
            this.buf = zzf;
        }
    }

    public final void close() {
        this.f13323a.zza(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.f13323a.zza(this.buf);
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        m7807a(i2);
        super.write(bArr, i, i2);
    }

    public final synchronized void write(int i) {
        m7807a(1);
        super.write(i);
    }
}
