package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdbr implements zzdfj<Bundle> {

    /* renamed from: a */
    private final double f15194a;

    /* renamed from: b */
    private final boolean f15195b;

    public zzdbr(double d, boolean z) {
        this.f15194a = d;
        this.f15195b = z;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle zza = zzdnx.zza(bundle, "device");
        bundle.putBundle("device", zza);
        Bundle zza2 = zzdnx.zza(zza, "battery");
        zza.putBundle("battery", zza2);
        zza2.putBoolean("is_charging", this.f15195b);
        zza2.putDouble("battery_level", this.f15194a);
    }
}
