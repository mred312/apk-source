package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzpo implements zzpg {

    /* renamed from: a */
    private boolean f16837a;

    /* renamed from: b */
    private long f16838b;

    /* renamed from: c */
    private long f16839c;

    /* renamed from: d */
    private zzhv f16840d = zzhv.zzahx;

    public final void start() {
        if (!this.f16837a) {
            this.f16839c = SystemClock.elapsedRealtime();
            this.f16837a = true;
        }
    }

    public final void stop() {
        if (this.f16837a) {
            zzel(zzfz());
            this.f16837a = false;
        }
    }

    public final void zza(zzpg zzpg) {
        zzel(zzpg.zzfz());
        this.f16840d = zzpg.zzfs();
    }

    public final zzhv zzb(zzhv zzhv) {
        if (this.f16837a) {
            zzel(zzfz());
        }
        this.f16840d = zzhv;
        return zzhv;
    }

    public final void zzel(long j) {
        this.f16838b = j;
        if (this.f16837a) {
            this.f16839c = SystemClock.elapsedRealtime();
        }
    }

    public final zzhv zzfs() {
        return this.f16840d;
    }

    public final long zzfz() {
        long j;
        long j2 = this.f16838b;
        if (!this.f16837a) {
            return j2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f16839c;
        zzhv zzhv = this.f16840d;
        if (zzhv.zzahy == 1.0f) {
            j = zzhb.zzdn(elapsedRealtime);
        } else {
            j = zzhv.zzdu(elapsedRealtime);
        }
        return j2 + j;
    }
}
