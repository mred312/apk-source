package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcii implements zzbsp {
    @Nullable

    /* renamed from: a */
    private final zzbdv f14435a;

    zzcii(@Nullable zzbdv zzbdv) {
        this.f14435a = !((Boolean) zzwq.zzqe().zzd(zzabf.zzcoh)).booleanValue() ? null : zzbdv;
    }

    public final void zzcc(@Nullable Context context) {
        zzbdv zzbdv = this.f14435a;
        if (zzbdv != null) {
            zzbdv.onPause();
        }
    }

    public final void zzcd(@Nullable Context context) {
        zzbdv zzbdv = this.f14435a;
        if (zzbdv != null) {
            zzbdv.onResume();
        }
    }

    public final void zzce(@Nullable Context context) {
        zzbdv zzbdv = this.f14435a;
        if (zzbdv != null) {
            zzbdv.destroy();
        }
    }
}
