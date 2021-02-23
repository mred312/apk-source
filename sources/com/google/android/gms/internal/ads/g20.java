package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class g20 extends zzdxh<T> {

    /* renamed from: a */
    private boolean f8502a;

    /* renamed from: b */
    private final /* synthetic */ Object f8503b;

    g20(Object obj) {
        this.f8503b = obj;
    }

    public final boolean hasNext() {
        return !this.f8502a;
    }

    public final T next() {
        if (!this.f8502a) {
            this.f8502a = true;
            return this.f8503b;
        }
        throw new NoSuchElementException();
    }
}
