package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class ma0 {

    /* renamed from: a */
    private static final la0 f9931a = m6492c();

    /* renamed from: b */
    private static final la0 f9932b = new ja0();

    /* renamed from: a */
    static la0 m6490a() {
        return f9931a;
    }

    /* renamed from: b */
    static la0 m6491b() {
        return f9932b;
    }

    /* renamed from: c */
    private static la0 m6492c() {
        try {
            return (la0) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
