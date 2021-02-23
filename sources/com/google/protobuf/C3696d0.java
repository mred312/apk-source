package com.google.protobuf;

/* renamed from: com.google.protobuf.d0 */
/* compiled from: NewInstanceSchemas */
final class C3696d0 {

    /* renamed from: a */
    private static final C3688b0 f20763a = m13266c();

    /* renamed from: b */
    private static final C3688b0 f20764b = new C3692c0();

    /* renamed from: a */
    static C3688b0 m13264a() {
        return f20763a;
    }

    /* renamed from: b */
    static C3688b0 m13265b() {
        return f20764b;
    }

    /* renamed from: c */
    private static C3688b0 m13266c() {
        try {
            return (C3688b0) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
