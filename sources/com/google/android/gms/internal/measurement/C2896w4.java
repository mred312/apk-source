package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.w4 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2896w4 {

    /* renamed from: a */
    private static final C2880u4 f17496a = m9893c();

    /* renamed from: b */
    private static final C2880u4 f17497b = new C2872t4();

    /* renamed from: a */
    static C2880u4 m9891a() {
        return f17496a;
    }

    /* renamed from: b */
    static C2880u4 m9892b() {
        return f17497b;
    }

    /* renamed from: c */
    private static C2880u4 m9893c() {
        try {
            return (C2880u4) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
