package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.InitializationStatus;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final /* synthetic */ class rj0 implements InitializationStatus {

    /* renamed from: a */
    private final zzzd f10809a;

    rj0(zzzd zzzd) {
        this.f10809a = zzzd;
    }

    public final Map getAdapterStatusMap() {
        zzzd zzzd = this.f10809a;
        HashMap hashMap = new HashMap();
        hashMap.put("com.google.android.gms.ads.MobileAds", new qj0(zzzd));
        return hashMap;
    }
}
