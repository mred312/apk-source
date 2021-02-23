package com.google.android.gms.internal.ads;

import android.support.p000v4.media.session.PlaybackStateCompat;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class se0 {

    /* renamed from: a */
    private final zzpn f11078a = new zzpn(8);

    /* renamed from: b */
    private int f11079b;

    /* renamed from: b */
    private final long m6968b(zzjz zzjz) {
        int i = 0;
        zzjz.zza(this.f11078a.data, 0, 1);
        byte b = this.f11078a.data[0] & 255;
        if (b == 0) {
            return Long.MIN_VALUE;
        }
        int i2 = 128;
        int i3 = 0;
        while ((b & i2) == 0) {
            i2 >>= 1;
            i3++;
        }
        int i4 = b & (i2 ^ -1);
        zzjz.zza(this.f11078a.data, 1, i3);
        while (i < i3) {
            i++;
            i4 = (this.f11078a.data[i] & 255) + (i4 << 8);
        }
        this.f11079b += i3 + 1;
        return (long) i4;
    }

    /* renamed from: a */
    public final boolean mo14795a(zzjz zzjz) {
        zzjz zzjz2 = zzjz;
        long length = zzjz.getLength();
        long j = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        if (length != -1 && length <= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            j = length;
        }
        int i = (int) j;
        zzjz2.zza(this.f11078a.data, 0, 4);
        this.f11079b = 4;
        for (long zzjc = this.f11078a.zzjc(); zzjc != 440786851; zzjc = ((zzjc << 8) & -256) | ((long) (this.f11078a.data[0] & 255))) {
            int i2 = this.f11079b + 1;
            this.f11079b = i2;
            if (i2 == i) {
                return false;
            }
            zzjz2.zza(this.f11078a.data, 0, 1);
        }
        long b = m6968b(zzjz);
        long j2 = (long) this.f11079b;
        if (b != Long.MIN_VALUE && (length == -1 || j2 + b < length)) {
            while (true) {
                int i3 = this.f11079b;
                long j3 = j2 + b;
                if (((long) i3) < j3) {
                    if (m6968b(zzjz) == Long.MIN_VALUE) {
                        return false;
                    }
                    long b2 = m6968b(zzjz);
                    if (b2 < 0 || b2 > 2147483647L) {
                        return false;
                    }
                    if (b2 != 0) {
                        zzjz2.zzah((int) b2);
                        this.f11079b = (int) (((long) this.f11079b) + b2);
                    }
                } else if (((long) i3) == j3) {
                    return true;
                }
            }
        }
        return false;
    }
}
