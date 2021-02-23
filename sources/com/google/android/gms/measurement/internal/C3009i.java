package com.google.android.gms.measurement.internal;

import java.util.Iterator;

/* renamed from: com.google.android.gms.measurement.internal.i */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3009i implements Iterator<String> {

    /* renamed from: a */
    private Iterator<String> f18125a;

    /* renamed from: b */
    private final /* synthetic */ zzam f18126b;

    C3009i(zzam zzam) {
        this.f18126b = zzam;
        this.f18125a = zzam.f18510a.keySet().iterator();
    }

    public final boolean hasNext() {
        return this.f18125a.hasNext();
    }

    public final /* synthetic */ Object next() {
        return this.f18125a.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
