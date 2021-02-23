package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbjt implements zzbsp {

    /* renamed from: a */
    private final zzdoe f13360a;

    public zzbjt(zzdoe zzdoe) {
        this.f13360a = zzdoe;
    }

    public final void zzcc(@Nullable Context context) {
        try {
            this.f13360a.pause();
        } catch (zzdnr e) {
            zzaza.zzd("Cannot invoke onPause for the mediation adapter.", e);
        }
    }

    public final void zzcd(@Nullable Context context) {
        try {
            this.f13360a.resume();
            if (context != null) {
                this.f13360a.onContextChanged(context);
            }
        } catch (zzdnr e) {
            zzaza.zzd("Cannot invoke onResume for the mediation adapter.", e);
        }
    }

    public final void zzce(@Nullable Context context) {
        try {
            this.f13360a.destroy();
        } catch (zzdnr e) {
            zzaza.zzd("Cannot invoke onDestroy for the mediation adapter.", e);
        }
    }
}
