package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzga extends zzgl {

    /* renamed from: e */
    private static volatile String f16416e;

    /* renamed from: f */
    private static final Object f16417f = new Object();

    public zzga(zzfa zzfa, String str, String str2, zzcf.zza.C3977zza zza, int i, int i2) {
        super(zzfa, str, str2, zza, i, 1);
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        this.zzaay.zzt("E");
        if (f16416e == null) {
            synchronized (f16417f) {
                if (f16416e == null) {
                    f16416e = (String) this.zzabi.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzaay) {
            this.zzaay.zzt(f16416e);
        }
    }
}
