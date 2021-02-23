package com.google.protobuf;

/* renamed from: com.google.protobuf.b */
/* compiled from: Android */
final class C3687b {

    /* renamed from: a */
    private static final Class<?> f20749a = m13154a("libcore.io.Memory");

    /* renamed from: b */
    private static final boolean f20750b = (m13154a("org.robolectric.Robolectric") != null);

    /* renamed from: a */
    private static <T> Class<T> m13154a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: b */
    static Class<?> m13155b() {
        return f20749a;
    }

    /* renamed from: c */
    static boolean m13156c() {
        return f20749a != null && !f20750b;
    }
}
