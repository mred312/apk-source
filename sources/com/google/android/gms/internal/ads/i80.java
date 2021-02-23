package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class i80 {

    /* renamed from: a */
    private static final Class<?> f9275a = m6315c("libcore.io.Memory");

    /* renamed from: b */
    private static final boolean f9276b = (m6315c("org.robolectric.Robolectric") != null);

    /* renamed from: a */
    static boolean m6313a() {
        return f9275a != null && !f9276b;
    }

    /* renamed from: b */
    static Class<?> m6314b() {
        return f9275a;
    }

    /* renamed from: c */
    private static <T> Class<T> m6315c(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
