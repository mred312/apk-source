package com.google.android.gms.internal.ads;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads-base@@19.5.0 */
final class e80 extends WeakReference<Throwable> {

    /* renamed from: a */
    private final int f8324a;

    public e80(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.f8324a = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == e80.class) {
            if (this == obj) {
                return true;
            }
            e80 e80 = (e80) obj;
            return this.f8324a == e80.f8324a && get() == e80.get();
        }
    }

    public final int hashCode() {
        return this.f8324a;
    }
}
