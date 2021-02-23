package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.w5 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
class C2897w5 extends AbstractSet<Map.Entry<K, V>> {

    /* renamed from: a */
    private final /* synthetic */ C2841p5 f17498a;

    private C2897w5(C2841p5 p5Var) {
        this.f17498a = p5Var;
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.f17498a.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public void clear() {
        this.f17498a.clear();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.f17498a.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new C2904x5(this.f17498a, (C2833o5) null);
    }

    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.f17498a.remove(entry.getKey());
        return true;
    }

    public int size() {
        return this.f17498a.size();
    }

    /* synthetic */ C2897w5(C2841p5 p5Var, C2833o5 o5Var) {
        this(p5Var);
    }
}
