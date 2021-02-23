package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class x90 implements da0 {

    /* renamed from: a */
    private da0[] f11772a;

    x90(da0... da0Arr) {
        this.f11772a = da0Arr;
    }

    /* renamed from: a */
    public final ea0 mo13817a(Class<?> cls) {
        for (da0 da0 : this.f11772a) {
            if (da0.mo13818b(cls)) {
                return da0.mo13817a(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }

    /* renamed from: b */
    public final boolean mo13818b(Class<?> cls) {
        for (da0 b : this.f11772a) {
            if (b.mo13818b(cls)) {
                return true;
            }
        }
        return false;
    }
}
