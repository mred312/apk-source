package com.google.android.gms.internal.ads;

import android.net.Uri;

/* renamed from: com.google.android.gms.internal.ads.d8 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1833d8 implements zzon {

    /* renamed from: a */
    private final zzon f8055a;

    /* renamed from: b */
    private final long f8056b;

    /* renamed from: c */
    private final zzon f8057c;

    /* renamed from: d */
    private long f8058d;

    /* renamed from: e */
    private Uri f8059e;

    C1833d8(zzon zzon, int i, zzon zzon2) {
        this.f8055a = zzon;
        this.f8056b = (long) i;
        this.f8057c = zzon2;
    }

    public final void close() {
        this.f8055a.close();
        this.f8057c.close();
    }

    public final Uri getUri() {
        return this.f8059e;
    }

    public final int read(byte[] bArr, int i, int i2) {
        int i3;
        long j = this.f8058d;
        long j2 = this.f8056b;
        if (j < j2) {
            i3 = this.f8055a.read(bArr, i, (int) Math.min((long) i2, j2 - j));
            this.f8058d += (long) i3;
        } else {
            i3 = 0;
        }
        if (this.f8058d < this.f8056b) {
            return i3;
        }
        int read = this.f8057c.read(bArr, i + i3, i2 - i3);
        int i4 = i3 + read;
        this.f8058d += (long) read;
        return i4;
    }

    public final long zza(zzoo zzoo) {
        zzoo zzoo2;
        zzoo zzoo3 = zzoo;
        this.f8059e = zzoo3.uri;
        long j = zzoo3.position;
        long j2 = this.f8056b;
        zzoo zzoo4 = null;
        if (j >= j2) {
            zzoo2 = null;
        } else {
            long j3 = zzoo3.zzcm;
            zzoo2 = new zzoo(zzoo3.uri, j, j3 != -1 ? Math.min(j3, j2 - j) : j2 - j, (String) null);
        }
        long j4 = zzoo3.zzcm;
        if (j4 == -1 || zzoo3.position + j4 > this.f8056b) {
            long max = Math.max(this.f8056b, zzoo3.position);
            long j5 = zzoo3.zzcm;
            zzoo4 = new zzoo(zzoo3.uri, max, j5 != -1 ? Math.min(j5, (zzoo3.position + j5) - this.f8056b) : -1, (String) null);
        }
        long j6 = 0;
        long zza = zzoo2 != null ? this.f8055a.zza(zzoo2) : 0;
        if (zzoo4 != null) {
            j6 = this.f8057c.zza(zzoo4);
        }
        this.f8058d = zzoo3.position;
        if (zza == -1 || j6 == -1) {
            return -1;
        }
        return zza + j6;
    }
}
