package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.r5 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2857r5 implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a */
    private int f17444a;

    /* renamed from: b */
    private Iterator<Map.Entry<K, V>> f17445b;

    /* renamed from: c */
    private final /* synthetic */ C2841p5 f17446c;

    private C2857r5(C2841p5 p5Var) {
        this.f17446c = p5Var;
        this.f17444a = p5Var.f17410b.size();
    }

    /* renamed from: a */
    private final Iterator<Map.Entry<K, V>> m9773a() {
        if (this.f17445b == null) {
            this.f17445b = this.f17446c.f17414f.entrySet().iterator();
        }
        return this.f17445b;
    }

    public final boolean hasNext() {
        int i = this.f17444a;
        return (i > 0 && i <= this.f17446c.f17410b.size()) || m9773a().hasNext();
    }

    public final /* synthetic */ Object next() {
        if (m9773a().hasNext()) {
            return (Map.Entry) m9773a().next();
        }
        List g = this.f17446c.f17410b;
        int i = this.f17444a - 1;
        this.f17444a = i;
        return (Map.Entry) g.get(i);
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ C2857r5(C2841p5 p5Var, C2833o5 o5Var) {
        this(p5Var);
    }
}
