package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzok implements zzon {

    /* renamed from: a */
    private final byte[] f16786a;

    /* renamed from: b */
    private Uri f16787b;

    /* renamed from: c */
    private int f16788c;

    /* renamed from: d */
    private int f16789d;

    public zzok(byte[] bArr) {
        zzpc.checkNotNull(bArr);
        zzpc.checkArgument(bArr.length > 0);
        this.f16786a = bArr;
    }

    public final void close() {
        this.f16787b = null;
    }

    public final Uri getUri() {
        return this.f16787b;
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.f16789d;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(this.f16786a, this.f16788c, bArr, i, min);
        this.f16788c += min;
        this.f16789d -= min;
        return min;
    }

    public final long zza(zzoo zzoo) {
        this.f16787b = zzoo.uri;
        long j = zzoo.position;
        int i = (int) j;
        this.f16788c = i;
        long j2 = zzoo.zzcm;
        if (j2 == -1) {
            j2 = ((long) this.f16786a.length) - j;
        }
        int i2 = (int) j2;
        this.f16789d = i2;
        if (i2 > 0 && i + i2 <= this.f16786a.length) {
            return (long) i2;
        }
        int i3 = this.f16788c;
        long j3 = zzoo.zzcm;
        int length = this.f16786a.length;
        StringBuilder sb = new StringBuilder(77);
        sb.append("Unsatisfiable range: [");
        sb.append(i3);
        sb.append(", ");
        sb.append(j3);
        sb.append("], length: ");
        sb.append(length);
        throw new IOException(sb.toString());
    }
}
