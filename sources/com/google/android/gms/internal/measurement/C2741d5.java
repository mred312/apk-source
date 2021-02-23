package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.d5 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2741d5 {

    /* renamed from: a */
    private static final C2733c5 f17266a = m9354c();

    /* renamed from: b */
    private static final C2733c5 f17267b = new C2749e5();

    /* renamed from: a */
    static C2733c5 m9352a() {
        return f17266a;
    }

    /* renamed from: b */
    static C2733c5 m9353b() {
        return f17267b;
    }

    /* renamed from: c */
    private static C2733c5 m9354c() {
        try {
            return (C2733c5) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
