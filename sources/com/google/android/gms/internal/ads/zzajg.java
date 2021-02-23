package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzajg implements InitializationStatus {

    /* renamed from: a */
    private final Map<String, AdapterStatus> f12484a;

    public zzajg(Map<String, AdapterStatus> map) {
        this.f12484a = map;
    }

    public final Map<String, AdapterStatus> getAdapterStatusMap() {
        return this.f12484a;
    }
}
