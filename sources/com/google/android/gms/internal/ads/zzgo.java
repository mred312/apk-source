package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzgo<T> {

    /* renamed from: a */
    private final Map<String, AtomicReference<T>> f16438a = new HashMap();

    public final AtomicReference<T> zzas(String str) {
        synchronized (this) {
            if (!this.f16438a.containsKey(str)) {
                this.f16438a.put(str, new AtomicReference());
            }
        }
        return this.f16438a.get(str);
    }
}
