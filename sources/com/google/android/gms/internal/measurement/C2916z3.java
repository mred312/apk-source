package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.z3 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2916z3 {

    /* renamed from: a */
    private static final C2902x3<?> f17552a = new C2895w3();

    /* renamed from: b */
    private static final C2902x3<?> f17553b = m10011c();

    /* renamed from: a */
    static C2902x3<?> m10009a() {
        return f17552a;
    }

    /* renamed from: b */
    static C2902x3<?> m10010b() {
        C2902x3<?> x3Var = f17553b;
        if (x3Var != null) {
            return x3Var;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    /* renamed from: c */
    private static C2902x3<?> m10011c() {
        try {
            return (C2902x3) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
