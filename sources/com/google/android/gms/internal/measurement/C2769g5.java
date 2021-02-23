package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.android.gms.internal.measurement.g5 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2769g5 {

    /* renamed from: c */
    private static final C2769g5 f17325c = new C2769g5();

    /* renamed from: a */
    private final C2825n5 f17326a = new C2848q4();

    /* renamed from: b */
    private final ConcurrentMap<Class<?>, C2793j5<?>> f17327b = new ConcurrentHashMap();

    private C2769g5() {
    }

    /* renamed from: a */
    public static C2769g5 m9493a() {
        return f17325c;
    }

    /* renamed from: b */
    public final <T> C2793j5<T> mo18661b(Class<T> cls) {
        zzic.m10385d(cls, "messageType");
        C2793j5<T> j5Var = (C2793j5) this.f17327b.get(cls);
        if (j5Var != null) {
            return j5Var;
        }
        C2793j5<T> a = this.f17326a.mo18773a(cls);
        zzic.m10385d(cls, "messageType");
        zzic.m10385d(a, "schema");
        C2793j5<T> putIfAbsent = this.f17327b.putIfAbsent(cls, a);
        return putIfAbsent != null ? putIfAbsent : a;
    }

    /* renamed from: c */
    public final <T> C2793j5<T> mo18662c(T t) {
        return mo18661b(t.getClass());
    }
}
