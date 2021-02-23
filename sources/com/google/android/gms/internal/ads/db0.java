package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class db0 implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a */
    private int f8245a;

    /* renamed from: b */
    private Iterator<Map.Entry<K, V>> f8246b;

    /* renamed from: c */
    private final /* synthetic */ bb0 f8247c;

    private db0(bb0 bb0) {
        this.f8247c = bb0;
        this.f8245a = bb0.f7900b.size();
    }

    /* renamed from: a */
    private final Iterator<Map.Entry<K, V>> m5982a() {
        if (this.f8246b == null) {
            this.f8246b = this.f8247c.f7904f.entrySet().iterator();
        }
        return this.f8246b;
    }

    public final boolean hasNext() {
        int i = this.f8245a;
        return (i > 0 && i <= this.f8247c.f7900b.size()) || m5982a().hasNext();
    }

    public final /* synthetic */ Object next() {
        if (m5982a().hasNext()) {
            return (Map.Entry) m5982a().next();
        }
        List f = this.f8247c.f7900b;
        int i = this.f8245a - 1;
        this.f8245a = i;
        return (Map.Entry) f.get(i);
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ db0(bb0 bb0, ab0 ab0) {
        this(bb0);
    }
}
