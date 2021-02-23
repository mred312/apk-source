package com.google.protobuf;

/* renamed from: com.google.protobuf.l */
/* compiled from: ExtensionSchemas */
final class C3715l {

    /* renamed from: a */
    private static final C3710j<?> f20793a = new C3712k();

    /* renamed from: b */
    private static final C3710j<?> f20794b = m13471c();

    /* renamed from: a */
    static C3710j<?> m13469a() {
        C3710j<?> jVar = f20794b;
        if (jVar != null) {
            return jVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    /* renamed from: b */
    static C3710j<?> m13470b() {
        return f20793a;
    }

    /* renamed from: c */
    private static C3710j<?> m13471c() {
        try {
            return (C3710j) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
