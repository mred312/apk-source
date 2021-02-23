package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzge extends zzgl {

    /* renamed from: e */
    private final boolean f16420e;

    public zzge(zzfa zzfa, String str, String str2, zzcf.zza.C3977zza zza, int i, int i2) {
        super(zzfa, str, str2, zza, i, 61);
        this.f16420e = zzfa.zzcf();
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        long longValue = ((Long) this.zzabi.invoke((Object) null, new Object[]{this.zzwb.getContext(), Boolean.valueOf(this.f16420e)})).longValue();
        synchronized (this.zzaay) {
            this.zzaay.zzah(longValue);
        }
    }
}
