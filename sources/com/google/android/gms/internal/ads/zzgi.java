package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzgi extends zzgl {

    /* renamed from: e */
    private static volatile Long f16423e;

    /* renamed from: f */
    private static final Object f16424f = new Object();

    public zzgi(zzfa zzfa, String str, String str2, zzcf.zza.C3977zza zza, int i, int i2) {
        super(zzfa, str, str2, zza, i, 33);
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        if (f16423e == null) {
            synchronized (f16424f) {
                if (f16423e == null) {
                    f16423e = (Long) this.zzabi.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzaay) {
            this.zzaay.zzs(f16423e.longValue());
        }
    }
}
