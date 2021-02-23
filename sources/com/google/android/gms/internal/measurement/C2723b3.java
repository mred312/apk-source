package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.b3 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2723b3 {

    /* renamed from: a */
    private static final Class<?> f17232a = m9320a("libcore.io.Memory");

    /* renamed from: b */
    private static final boolean f17233b = (m9320a("org.robolectric.Robolectric") != null);

    /* renamed from: a */
    private static <T> Class<T> m9320a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: b */
    static boolean m9321b() {
        return f17232a != null && !f17233b;
    }

    /* renamed from: c */
    static Class<?> m9322c() {
        return f17232a;
    }
}
