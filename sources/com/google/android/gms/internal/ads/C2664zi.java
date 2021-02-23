package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.ads.zi */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2664zi implements zzqu {

    /* renamed from: a */
    private final zzbdv f12305a;

    C2664zi(zzbdv zzbdv) {
        this.f12305a = zzbdv;
    }

    public final void zza(zzqv zzqv) {
        zzbdv zzbdv = this.f12305a;
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", zzqv.zzbqz ? "1" : "0");
        zzbdv.zza("onAdVisibilityChanged", hashMap);
    }
}
