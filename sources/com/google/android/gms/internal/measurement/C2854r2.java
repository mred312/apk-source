package com.google.android.gms.internal.measurement;

import java.util.AbstractMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.r2 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2854r2 extends zzfb<Map.Entry<K, V>> {

    /* renamed from: c */
    private final /* synthetic */ C2830o2 f17435c;

    C2854r2(C2830o2 o2Var) {
        this.f17435c = o2Var;
    }

    /* renamed from: e */
    public final boolean mo18705e() {
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        zzeb.zza(i, this.f17435c.f17399e);
        int i2 = i * 2;
        return new AbstractMap.SimpleImmutableEntry(this.f17435c.f17398d[i2], this.f17435c.f17398d[i2 + 1]);
    }

    public final int size() {
        return this.f17435c.f17399e;
    }
}
