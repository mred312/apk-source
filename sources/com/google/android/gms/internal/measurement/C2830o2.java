package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.o2 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2830o2<K, V> extends zzfg<Map.Entry<K, V>> {

    /* renamed from: c */
    private final transient zzfc<K, V> f17397c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final transient Object[] f17398d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final transient int f17399e;

    C2830o2(zzfc<K, V> zzfc, Object[] objArr, int i, int i2) {
        this.f17397c = zzfc;
        this.f17398d = objArr;
        this.f17399e = i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo18762a(Object[] objArr, int i) {
        return zze().mo18762a(objArr, i);
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.f17397c.get(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final boolean mo18705e() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final zzfb<Map.Entry<K, V>> mo18776h() {
        return new C2854r2(this);
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public final int size() {
        return this.f17399e;
    }

    public final zzfx<Map.Entry<K, V>> zza() {
        return (zzfx) zze().iterator();
    }
}
