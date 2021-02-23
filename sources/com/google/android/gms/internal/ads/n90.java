package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class n90<K> implements Map.Entry<K, Object> {

    /* renamed from: a */
    private Map.Entry<K, zzekt> f10049a;

    private n90(Map.Entry<K, zzekt> entry) {
        this.f10049a = entry;
    }

    /* renamed from: a */
    public final zzekt mo14470a() {
        return this.f10049a.getValue();
    }

    public final K getKey() {
        return this.f10049a.getKey();
    }

    public final Object getValue() {
        if (this.f10049a.getValue() == null) {
            return null;
        }
        return zzekt.zzbir();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzels) {
            return this.f10049a.getValue().zzn((zzels) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
