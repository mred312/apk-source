package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class kb0 implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a */
    private int f9742a;

    /* renamed from: b */
    private boolean f9743b;

    /* renamed from: c */
    private Iterator<Map.Entry<K, V>> f9744c;

    /* renamed from: d */
    private final /* synthetic */ bb0 f9745d;

    private kb0(bb0 bb0) {
        this.f9745d = bb0;
        this.f9742a = -1;
    }

    /* renamed from: a */
    private final Iterator<Map.Entry<K, V>> m6423a() {
        if (this.f9744c == null) {
            this.f9744c = this.f9745d.f7901c.entrySet().iterator();
        }
        return this.f9744c;
    }

    public final boolean hasNext() {
        if (this.f9742a + 1 < this.f9745d.f7900b.size() || (!this.f9745d.f7901c.isEmpty() && m6423a().hasNext())) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ Object next() {
        this.f9743b = true;
        int i = this.f9742a + 1;
        this.f9742a = i;
        if (i < this.f9745d.f7900b.size()) {
            return (Map.Entry) this.f9745d.f7900b.get(this.f9742a);
        }
        return (Map.Entry) m6423a().next();
    }

    public final void remove() {
        if (this.f9743b) {
            this.f9743b = false;
            this.f9745d.m5842k();
            if (this.f9742a < this.f9745d.f7900b.size()) {
                bb0 bb0 = this.f9745d;
                int i = this.f9742a;
                this.f9742a = i - 1;
                Object unused = bb0.m5847q(i);
                return;
            }
            m6423a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    /* synthetic */ kb0(bb0 bb0, ab0 ab0) {
        this(bb0);
    }
}
