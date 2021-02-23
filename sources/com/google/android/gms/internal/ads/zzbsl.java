package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbsl extends zzbwk<zzbsm> {

    /* renamed from: b */
    private boolean f13756b = false;

    public zzbsl(Set<zzbxy<zzbsm>> set) {
        super(set);
    }

    public final synchronized void onAdImpression() {
        if (!this.f13756b) {
            zza(C2134ld.f9835a);
            this.f13756b = true;
        }
    }
}
