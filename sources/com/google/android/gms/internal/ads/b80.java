package com.google.android.gms.internal.ads;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads-base@@19.5.0 */
final class b80 {

    /* renamed from: a */
    private final ConcurrentHashMap<e80, List<Throwable>> f7878a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b */
    private final ReferenceQueue<Throwable> f7879b = new ReferenceQueue<>();

    b80() {
    }

    /* renamed from: a */
    public final List<Throwable> mo13638a(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.f7879b.poll();
        while (poll != null) {
            this.f7878a.remove(poll);
            poll = this.f7879b.poll();
        }
        List<Throwable> list = this.f7878a.get(new e80(th, (ReferenceQueue<Throwable>) null));
        if (!z || list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f7878a.putIfAbsent(new e80(th, this.f7879b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
