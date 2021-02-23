package com.google.protobuf;

/* renamed from: com.google.protobuf.i */
/* compiled from: ExtensionRegistryFactory */
final class C3708i {

    /* renamed from: a */
    static final Class<?> f20784a = m13398e();

    /* renamed from: a */
    public static ExtensionRegistryLite m13394a() {
        ExtensionRegistryLite c = m13396c("newInstance");
        return c != null ? c : new ExtensionRegistryLite();
    }

    /* renamed from: b */
    public static ExtensionRegistryLite m13395b() {
        ExtensionRegistryLite c = m13396c("getEmptyRegistry");
        return c != null ? c : ExtensionRegistryLite.f20480e;
    }

    /* renamed from: c */
    private static final ExtensionRegistryLite m13396c(String str) {
        Class<?> cls = f20784a;
        if (cls == null) {
            return null;
        }
        try {
            return (ExtensionRegistryLite) cls.getDeclaredMethod(str, new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: d */
    static boolean m13397d(ExtensionRegistryLite extensionRegistryLite) {
        Class<?> cls = f20784a;
        return cls != null && cls.isAssignableFrom(extensionRegistryLite.getClass());
    }

    /* renamed from: e */
    static Class<?> m13398e() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
