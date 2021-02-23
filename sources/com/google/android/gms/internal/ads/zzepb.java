package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzepb<K, V, V2> {

    /* renamed from: a */
    final LinkedHashMap<K, zzeps<V>> f16353a;

    zzepb(int i) {
        this.f16353a = zzepe.zzie(i);
    }

    /* access modifiers changed from: package-private */
    public zzepb<K, V, V2> zza(K k, zzeps<V> zzeps) {
        this.f16353a.put(zzepl.zza(k, "key"), zzepl.zza(zzeps, "provider"));
        return this;
    }
}
