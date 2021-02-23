package com.google.android.gms.internal.measurement;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.gms.internal.measurement.y2 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2908y2 {

    /* renamed from: a */
    private final ConcurrentHashMap<C2901x2, List<Throwable>> f17523a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b */
    private final ReferenceQueue<Throwable> f17524b = new ReferenceQueue<>();

    C2908y2() {
    }

    /* renamed from: a */
    public final List<Throwable> mo18981a(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.f17524b.poll();
        while (poll != null) {
            this.f17523a.remove(poll);
            poll = this.f17524b.poll();
        }
        List<Throwable> list = this.f17523a.get(new C2901x2(th, (ReferenceQueue<Throwable>) null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f17523a.putIfAbsent(new C2901x2(th, this.f17524b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
