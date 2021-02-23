package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzddg implements zzdfj<Bundle> {

    /* renamed from: a */
    private final zzdms f15448a;

    public zzddg(zzdms zzdms) {
        this.f15448a = zzdms;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzdms zzdms = this.f15448a;
        if (zzdms != null) {
            bundle.putBoolean("render_in_browser", zzdms.zzaui());
            bundle.putBoolean("disable_ml", this.f15448a.zzauj());
        }
    }
}
