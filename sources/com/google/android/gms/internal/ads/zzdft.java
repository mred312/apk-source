package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdft implements zzdfj<Bundle> {

    /* renamed from: a */
    private final String f15555a;

    /* renamed from: b */
    private final int f15556b;

    /* renamed from: c */
    private final int f15557c;

    /* renamed from: d */
    private final int f15558d;

    /* renamed from: e */
    private final boolean f15559e;

    /* renamed from: f */
    private final int f15560f;

    public zzdft(String str, int i, int i2, int i3, boolean z, int i4) {
        this.f15555a = str;
        this.f15556b = i;
        this.f15557c = i2;
        this.f15558d = i3;
        this.f15559e = z;
        this.f15560f = i4;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        String str = this.f15555a;
        boolean z = true;
        zzdnx.zza(bundle, "carrier", str, !TextUtils.isEmpty(str));
        Integer valueOf = Integer.valueOf(this.f15556b);
        if (this.f15556b == -2) {
            z = false;
        }
        zzdnx.zza(bundle, "cnt", valueOf, z);
        bundle.putInt("gnt", this.f15557c);
        bundle.putInt("pt", this.f15558d);
        Bundle zza = zzdnx.zza(bundle, "device");
        bundle.putBundle("device", zza);
        Bundle zza2 = zzdnx.zza(zza, "network");
        zza.putBundle("network", zza2);
        zza2.putInt("active_network_state", this.f15560f);
        zza2.putBoolean("active_network_metered", this.f15559e);
    }
}
