package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class l20 extends zzdwm<Map.Entry<K, V>> {

    /* renamed from: c */
    private final /* synthetic */ i20 f9797c;

    l20(i20 i20) {
        this.f9797c = i20;
    }

    /* renamed from: e */
    public final boolean mo13936e() {
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        zzdvv.zzt(i, this.f9797c.f9251e);
        int i2 = i * 2;
        return new AbstractMap.SimpleImmutableEntry(this.f9797c.f9250d[i2], this.f9797c.f9250d[i2 + 1]);
    }

    public final int size() {
        return this.f9797c.f9251e;
    }
}
