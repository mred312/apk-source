package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdau implements zzdfj<Bundle> {

    /* renamed from: a */
    private final zzvw f15148a;

    /* renamed from: b */
    private final zzazh f15149b;

    public zzdau(zzvw zzvw, zzazh zzazh) {
        this.f15148a = zzvw;
        this.f15149b = zzazh;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        int intValue = ((Integer) zzwq.zzqe().zzd(zzabf.zzcut)).intValue();
        zzazh zzazh = this.f15149b;
        if (zzazh != null && zzazh.zzegm >= intValue) {
            bundle.putString("app_open_version", "2");
        }
        zzvw zzvw = this.f15148a;
        if (zzvw != null) {
            int i = zzvw.orientation;
            if (i == 1) {
                bundle.putString("avo", "p");
            } else if (i == 2) {
                bundle.putString("avo", "l");
            }
        }
    }
}
