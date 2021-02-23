package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
abstract class qc0<K, V, V2> implements zzepf<Map<K, V2>> {

    /* renamed from: a */
    private final Map<K, zzeps<V>> f10712a;

    qc0(Map<K, zzeps<V>> map) {
        this.f10712a = Collections.unmodifiableMap(map);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Map<K, zzeps<V>> mo14688a() {
        return this.f10712a;
    }
}
