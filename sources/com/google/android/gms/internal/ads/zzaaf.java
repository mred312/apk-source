package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.OnPaidEventListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzaaf extends zzyl {
    @Nullable

    /* renamed from: a */
    private final OnPaidEventListener f12331a;

    public zzaaf(@Nullable OnPaidEventListener onPaidEventListener) {
        this.f12331a = onPaidEventListener;
    }

    public final void zza(zzvp zzvp) {
        if (this.f12331a != null) {
            this.f12331a.onPaidEvent(AdValue.zza(zzvp.zzacz, zzvp.zzada, zzvp.zzadb));
        }
    }
}
