package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class pa0 {

    /* renamed from: c */
    private static final pa0 f10615c = new pa0();

    /* renamed from: a */
    private final za0 f10616a = new v90();

    /* renamed from: b */
    private final ConcurrentMap<Class<?>, wa0<?>> f10617b = new ConcurrentHashMap();

    private pa0() {
    }

    /* renamed from: b */
    public static pa0 m6655b() {
        return f10615c;
    }

    /* renamed from: a */
    public final <T> wa0<T> mo14584a(T t) {
        return mo14585c(t.getClass());
    }

    /* renamed from: c */
    public final <T> wa0<T> mo14585c(Class<T> cls) {
        zzekk.m8825c(cls, "messageType");
        wa0<T> wa0 = (wa0) this.f10617b.get(cls);
        if (wa0 != null) {
            return wa0;
        }
        wa0<T> a = this.f10616a.mo14927a(cls);
        zzekk.m8825c(cls, "messageType");
        zzekk.m8825c(a, "schema");
        wa0<T> putIfAbsent = this.f10617b.putIfAbsent(cls, a);
        return putIfAbsent != null ? putIfAbsent : a;
    }
}
