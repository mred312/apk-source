package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.measurement.b2 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2722b2 extends AbstractSet<Map.Entry<K, V>> {

    /* renamed from: a */
    private final /* synthetic */ C2900x1 f17231a;

    C2722b2(C2900x1 x1Var) {
        this.f17231a = x1Var;
    }

    public final void clear() {
        this.f17231a.clear();
    }

    public final boolean contains(@NullableDecl Object obj) {
        Map l = this.f17231a.mo18966l();
        if (l != null) {
            return l.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int j = this.f17231a.m9900d(entry.getKey());
            if (j == -1 || !zzdz.zza(this.f17231a.f17508d[j], entry.getValue())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return this.f17231a.mo18972s();
    }

    public final boolean remove(@NullableDecl Object obj) {
        Map l = this.f17231a.mo18966l();
        if (l != null) {
            return l.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (this.f17231a.mo18962g()) {
            return false;
        }
        int i = this.f17231a.m9910v();
        Object key = entry.getKey();
        Object value = entry.getValue();
        Object n = this.f17231a.f17505a;
        C2900x1 x1Var = this.f17231a;
        int c = C2782i2.m9507c(key, value, i, n, x1Var.f17506b, x1Var.f17507c, x1Var.f17508d);
        if (c == -1) {
            return false;
        }
        this.f17231a.mo18961f(c, i);
        C2900x1.m9908q(this.f17231a);
        this.f17231a.mo18967o();
        return true;
    }

    public final int size() {
        return this.f17231a.size();
    }
}
