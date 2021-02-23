package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzox {

    /* renamed from: a */
    private final Map<String, String> f16816a = new HashMap();

    /* renamed from: b */
    private Map<String, String> f16817b;

    public final synchronized Map<String, String> zzit() {
        if (this.f16817b == null) {
            this.f16817b = Collections.unmodifiableMap(new HashMap(this.f16816a));
        }
        return this.f16817b;
    }
}
