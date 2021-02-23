package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbcb implements zzht {

    /* renamed from: a */
    private final zzor f13138a;

    /* renamed from: b */
    private long f13139b;

    /* renamed from: c */
    private long f13140c;

    /* renamed from: d */
    private long f13141d;

    /* renamed from: e */
    private long f13142e;

    /* renamed from: f */
    private int f13143f;

    /* renamed from: g */
    private boolean f13144g;

    zzbcb() {
        this(15000, 30000, 2500, 5000);
    }

    @VisibleForTesting
    /* renamed from: a */
    private final void m7706a(boolean z) {
        this.f13143f = 0;
        this.f13144g = false;
        if (z) {
            this.f13138a.reset();
        }
    }

    public final void onStopped() {
        m7706a(true);
    }

    public final void zza(zzhy[] zzhyArr, zznq zznq, zzoe zzoe) {
        this.f13143f = 0;
        for (int i = 0; i < zzhyArr.length; i++) {
            if (zzoe.zzbe(i) != null) {
                this.f13143f += zzpt.zzbp(zzhyArr[i].getTrackType());
            }
        }
        this.f13138a.zzbf(this.f13143f);
    }

    public final synchronized boolean zzc(long j, boolean z) {
        boolean z2;
        long j2 = z ? this.f13142e : this.f13141d;
        if (j2 <= 0 || j >= j2) {
            z2 = true;
        } else {
            z2 = false;
        }
        return z2;
    }

    public final synchronized void zzdn(int i) {
        this.f13141d = ((long) i) * 1000;
    }

    public final synchronized void zzdo(int i) {
        this.f13142e = ((long) i) * 1000;
    }

    public final synchronized boolean zzdt(long j) {
        boolean z;
        char c;
        z = false;
        if (j > this.f13140c) {
            c = 0;
        } else {
            c = j < this.f13139b ? (char) 2 : 1;
        }
        boolean z2 = this.f13138a.zzir() >= this.f13143f;
        if (c == 2 || (c == 1 && this.f13144g && !z2)) {
            z = true;
        }
        this.f13144g = z;
        return z;
    }

    public final synchronized void zzdu(int i) {
        this.f13140c = ((long) i) * 1000;
    }

    public final void zzfb() {
        m7706a(false);
    }

    public final void zzfc() {
        m7706a(true);
    }

    public final zzol zzfd() {
        return this.f13138a;
    }

    private zzbcb(int i, int i2, long j, long j2) {
        this.f13138a = new zzor(true, 65536);
        this.f13139b = 15000000;
        this.f13140c = 30000000;
        this.f13141d = 2500000;
        this.f13142e = 5000000;
    }

    public final synchronized void zzdt(int i) {
        this.f13139b = ((long) i) * 1000;
    }
}
