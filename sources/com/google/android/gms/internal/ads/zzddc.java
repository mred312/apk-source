package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzddc implements zzdfj<Bundle> {

    /* renamed from: a */
    private final Bundle f15442a;

    public zzddc(Bundle bundle) {
        this.f15442a = bundle;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle zza = zzdnx.zza(bundle, "device");
        zza.putBundle("android_mem_info", this.f15442a);
        bundle.putBundle("device", zza);
    }
}
