package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class ba0 {

    /* renamed from: a */
    private static final aa0 f7888a = m5837c();

    /* renamed from: b */
    private static final aa0 f7889b = new ca0();

    /* renamed from: a */
    static aa0 m5835a() {
        return f7888a;
    }

    /* renamed from: b */
    static aa0 m5836b() {
        return f7889b;
    }

    /* renamed from: c */
    private static aa0 m5837c() {
        try {
            return (aa0) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
