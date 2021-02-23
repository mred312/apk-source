package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzeph<K, V> extends qc0<K, V, V> {

    /* renamed from: b */
    private static final zzeps<Map<Object, Object>> f16358b = zzepi.zzbb(Collections.emptyMap());

    private zzeph(Map<K, zzeps<V>> map) {
        super(map);
    }

    public static <K, V> zzepj<K, V> zzig(int i) {
        return new zzepj<>(i);
    }

    public final /* synthetic */ Object get() {
        LinkedHashMap zzie = zzepe.zzie(mo14688a().size());
        for (Map.Entry entry : mo14688a().entrySet()) {
            zzie.put(entry.getKey(), ((zzeps) entry.getValue()).get());
        }
        return Collections.unmodifiableMap(zzie);
    }
}
