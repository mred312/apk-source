package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class oc0 implements Iterator<E> {

    /* renamed from: a */
    private int f10357a = 0;

    /* renamed from: b */
    private final /* synthetic */ zzeov f10358b;

    oc0(zzeov zzeov) {
        this.f10358b = zzeov;
    }

    public final boolean hasNext() {
        return this.f10357a < this.f10358b.f16338a.size() || this.f10358b.f16339b.hasNext();
    }

    public final E next() {
        while (this.f10357a >= this.f10358b.f16338a.size()) {
            zzeov zzeov = this.f10358b;
            zzeov.f16338a.add(zzeov.f16339b.next());
        }
        List<E> list = this.f10358b.f16338a;
        int i = this.f10357a;
        this.f10357a = i + 1;
        return list.get(i);
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
