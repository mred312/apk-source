package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.i4 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2784i4<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: a */
    private Iterator<Map.Entry<K, Object>> f17346a;

    public C2784i4(Iterator<Map.Entry<K, Object>> it) {
        this.f17346a = it;
    }

    public final boolean hasNext() {
        return this.f17346a.hasNext();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.f17346a.next();
        return next.getValue() instanceof zzim ? new C2792j4(next) : next;
    }

    public final void remove() {
        this.f17346a.remove();
    }
}
