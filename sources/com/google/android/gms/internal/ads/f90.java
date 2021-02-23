package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class f90 {

    /* renamed from: a */
    private static final d90<?> f8433a = new c90();

    /* renamed from: b */
    private static final d90<?> f8434b = m6055a();

    /* renamed from: a */
    private static d90<?> m6055a() {
        try {
            return (d90) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    static d90<?> m6056b() {
        return f8433a;
    }

    /* renamed from: c */
    static d90<?> m6057c() {
        d90<?> d90 = f8434b;
        if (d90 != null) {
            return d90;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
