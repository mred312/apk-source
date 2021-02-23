package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.measurement.d2 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2738d2 extends AbstractSet<K> {

    /* renamed from: a */
    private final /* synthetic */ C2900x1 f17256a;

    C2738d2(C2900x1 x1Var) {
        this.f17256a = x1Var;
    }

    public final void clear() {
        this.f17256a.clear();
    }

    public final boolean contains(Object obj) {
        return this.f17256a.containsKey(obj);
    }

    public final Iterator<K> iterator() {
        return this.f17256a.mo18970r();
    }

    public final boolean remove(@NullableDecl Object obj) {
        Map l = this.f17256a.mo18966l();
        if (l != null) {
            return l.keySet().remove(obj);
        }
        return this.f17256a.m9905k(obj) != C2900x1.f17504j;
    }

    public final int size() {
        return this.f17256a.size();
    }
}
