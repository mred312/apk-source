package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class tb0 implements Iterator<String> {

    /* renamed from: a */
    private Iterator<String> f11162a;

    /* renamed from: b */
    private final /* synthetic */ zzenk f11163b;

    tb0(zzenk zzenk) {
        this.f11163b = zzenk;
        this.f11162a = zzenk.f16286a.iterator();
    }

    public final boolean hasNext() {
        return this.f11162a.hasNext();
    }

    public final /* synthetic */ Object next() {
        return this.f11162a.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
