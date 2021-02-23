package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.x5 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2904x5 implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a */
    private int f17515a;

    /* renamed from: b */
    private boolean f17516b;

    /* renamed from: c */
    private Iterator<Map.Entry<K, V>> f17517c;

    /* renamed from: d */
    private final /* synthetic */ C2841p5 f17518d;

    private C2904x5(C2841p5 p5Var) {
        this.f17518d = p5Var;
        this.f17515a = -1;
    }

    /* renamed from: a */
    private final Iterator<Map.Entry<K, V>> m9932a() {
        if (this.f17517c == null) {
            this.f17517c = this.f17518d.f17411c.entrySet().iterator();
        }
        return this.f17517c;
    }

    public final boolean hasNext() {
        if (this.f17515a + 1 < this.f17518d.f17410b.size() || (!this.f17518d.f17411c.isEmpty() && m9932a().hasNext())) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ Object next() {
        this.f17516b = true;
        int i = this.f17515a + 1;
        this.f17515a = i;
        if (i < this.f17518d.f17410b.size()) {
            return (Map.Entry) this.f17518d.f17410b.get(this.f17515a);
        }
        return (Map.Entry) m9932a().next();
    }

    public final void remove() {
        if (this.f17516b) {
            this.f17516b = false;
            this.f17518d.m9711p();
            if (this.f17515a < this.f17518d.f17410b.size()) {
                C2841p5 p5Var = this.f17518d;
                int i = this.f17515a;
                this.f17515a = i - 1;
                Object unused = p5Var.m9708k(i);
                return;
            }
            m9932a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    /* synthetic */ C2904x5(C2841p5 p5Var, C2833o5 o5Var) {
        this(p5Var);
    }
}
