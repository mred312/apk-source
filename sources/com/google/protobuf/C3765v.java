package com.google.protobuf;

/* renamed from: com.google.protobuf.v */
/* compiled from: MapFieldSchemas */
final class C3765v {

    /* renamed from: a */
    private static final C3751t f20878a = m13913c();

    /* renamed from: b */
    private static final C3751t f20879b = new C3758u();

    /* renamed from: a */
    static C3751t m13911a() {
        return f20878a;
    }

    /* renamed from: b */
    static C3751t m13912b() {
        return f20879b;
    }

    /* renamed from: c */
    private static C3751t m13913c() {
        try {
            return (C3751t) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
