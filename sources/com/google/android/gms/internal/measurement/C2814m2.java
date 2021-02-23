package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.measurement.m2 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2814m2 extends zzfx<T> {

    /* renamed from: a */
    private boolean f17376a;

    /* renamed from: b */
    private final /* synthetic */ Object f17377b;

    C2814m2(Object obj) {
        this.f17377b = obj;
    }

    public final boolean hasNext() {
        return !this.f17376a;
    }

    public final T next() {
        if (!this.f17376a) {
            this.f17376a = true;
            return this.f17377b;
        }
        throw new NoSuchElementException();
    }
}
