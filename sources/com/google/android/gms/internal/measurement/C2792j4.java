package com.google.android.gms.internal.measurement;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.j4 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2792j4<K> implements Map.Entry<K, Object> {

    /* renamed from: a */
    private Map.Entry<K, zzim> f17353a;

    private C2792j4(Map.Entry<K, zzim> entry) {
        this.f17353a = entry;
    }

    /* renamed from: a */
    public final zzim mo18684a() {
        return this.f17353a.getValue();
    }

    public final K getKey() {
        return this.f17353a.getKey();
    }

    public final Object getValue() {
        if (this.f17353a.getValue() == null) {
            return null;
        }
        return zzim.zza();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzjh) {
            return this.f17353a.getValue().zza((zzjh) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
