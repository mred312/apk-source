package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzfs extends zzgl {

    /* renamed from: e */
    private static volatile Long f16410e;

    /* renamed from: f */
    private static final Object f16411f = new Object();

    public zzfs(zzfa zzfa, String str, String str2, zzcf.zza.C3977zza zza, int i, int i2) {
        super(zzfa, str, str2, zza, i, 44);
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        if (f16410e == null) {
            synchronized (f16411f) {
                if (f16410e == null) {
                    f16410e = (Long) this.zzabi.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzaay) {
            this.zzaay.zzaa(f16410e.longValue());
        }
    }
}
