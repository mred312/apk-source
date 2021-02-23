package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcdx implements zzbsm {

    /* renamed from: a */
    private final zzcce f14155a;

    /* renamed from: b */
    private final zzcci f14156b;

    public zzcdx(zzcce zzcce, zzcci zzcci) {
        this.f14155a = zzcce;
        this.f14156b = zzcci;
    }

    public final void onAdImpression() {
        if (this.f14155a.zzanj() != null) {
            zzbdv zzani = this.f14155a.zzani();
            zzbdv zzanh = this.f14155a.zzanh();
            if (zzani == null) {
                zzani = zzanh != null ? zzanh : null;
            }
            if (this.f14156b.zzamy() && zzani != null) {
                zzani.zza("onSdkImpression", new ArrayMap());
            }
        }
    }
}
