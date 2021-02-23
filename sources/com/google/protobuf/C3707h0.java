package com.google.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.protobuf.h0 */
/* compiled from: Protobuf */
final class C3707h0 {

    /* renamed from: c */
    private static final C3707h0 f20781c = new C3707h0();

    /* renamed from: a */
    private final C3724n0 f20782a = new C3747s();

    /* renamed from: b */
    private final ConcurrentMap<Class<?>, C3722m0<?>> f20783b = new ConcurrentHashMap();

    private C3707h0() {
    }

    /* renamed from: a */
    public static C3707h0 m13389a() {
        return f20781c;
    }

    /* renamed from: b */
    public <T> void mo23884b(T t, C3714k0 k0Var, ExtensionRegistryLite extensionRegistryLite) {
        mo23887e(t).mo23809h(t, k0Var, extensionRegistryLite);
    }

    /* renamed from: c */
    public C3722m0<?> mo23885c(Class<?> cls, C3722m0<?> m0Var) {
        Internal.m12791b(cls, "messageType");
        Internal.m12791b(m0Var, "schema");
        return this.f20783b.putIfAbsent(cls, m0Var);
    }

    /* renamed from: d */
    public <T> C3722m0<T> mo23886d(Class<T> cls) {
        Internal.m12791b(cls, "messageType");
        C3722m0<T> m0Var = (C3722m0) this.f20783b.get(cls);
        if (m0Var != null) {
            return m0Var;
        }
        C3722m0<T> a = this.f20782a.mo23926a(cls);
        C3722m0<?> c = mo23885c(cls, a);
        return c != null ? c : a;
    }

    /* renamed from: e */
    public <T> C3722m0<T> mo23887e(T t) {
        return mo23886d(t.getClass());
    }
}
