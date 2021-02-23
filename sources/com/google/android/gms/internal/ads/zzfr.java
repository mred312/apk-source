package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzfr extends zzgl {

    /* renamed from: e */
    private long f16409e;

    public zzfr(zzfa zzfa, String str, String str2, zzcf.zza.C3977zza zza, long j, int i, int i2) {
        super(zzfa, str, str2, zza, i, 25);
        this.f16409e = j;
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        long longValue = ((Long) this.zzabi.invoke((Object) null, new Object[0])).longValue();
        synchronized (this.zzaay) {
            this.zzaay.zzak(longValue);
            long j = this.f16409e;
            if (j != 0) {
                this.zzaay.zzm(longValue - j);
                this.zzaay.zzp(this.f16409e);
            }
        }
    }
}
