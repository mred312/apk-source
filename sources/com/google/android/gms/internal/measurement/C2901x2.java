package com.google.android.gms.internal.measurement;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.measurement.x2 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2901x2 extends WeakReference<Throwable> {

    /* renamed from: a */
    private final int f17514a;

    public C2901x2(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.f17514a = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == C2901x2.class) {
            if (this == obj) {
                return true;
            }
            C2901x2 x2Var = (C2901x2) obj;
            return this.f17514a == x2Var.f17514a && get() == x2Var.get();
        }
    }

    public final int hashCode() {
        return this.f17514a;
    }
}
