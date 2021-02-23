package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.measurement.g6 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2770g6 implements Iterator<String> {

    /* renamed from: a */
    private Iterator<String> f17328a;

    /* renamed from: b */
    private final /* synthetic */ zzkw f17329b;

    C2770g6(zzkw zzkw) {
        this.f17329b = zzkw;
        this.f17328a = zzkw.f17747a.iterator();
    }

    public final boolean hasNext() {
        return this.f17328a.hasNext();
    }

    public final /* synthetic */ Object next() {
        return this.f17328a.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
