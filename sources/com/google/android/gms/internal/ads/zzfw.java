package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzfw extends zzgl {

    /* renamed from: e */
    private static volatile Long f16414e;

    /* renamed from: f */
    private static final Object f16415f = new Object();

    public zzfw(zzfa zzfa, String str, String str2, zzcf.zza.C3977zza zza, int i, int i2) {
        super(zzfa, str, str2, zza, i, 22);
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        if (f16414e == null) {
            synchronized (f16415f) {
                if (f16414e == null) {
                    f16414e = (Long) this.zzabi.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzaay) {
            this.zzaay.zzo(f16414e.longValue());
        }
    }
}
