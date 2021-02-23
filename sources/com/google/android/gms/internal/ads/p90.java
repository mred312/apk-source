package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class p90<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: a */
    private Iterator<Map.Entry<K, Object>> f10458a;

    public p90(Iterator<Map.Entry<K, Object>> it) {
        this.f10458a = it;
    }

    public final boolean hasNext() {
        return this.f10458a.hasNext();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.f10458a.next();
        return next.getValue() instanceof zzekt ? new n90(next) : next;
    }

    public final void remove() {
        this.f10458a.remove();
    }
}
