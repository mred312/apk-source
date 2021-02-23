package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdar implements zzdfj<Bundle> {

    /* renamed from: a */
    private final Bundle f15144a;

    private zzdar(Bundle bundle) {
        this.f15144a = bundle;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (!this.f15144a.isEmpty()) {
            bundle.putBundle("installed_adapter_data", this.f15144a);
        }
    }
}
