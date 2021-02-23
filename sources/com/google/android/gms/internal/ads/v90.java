package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class v90 implements za0 {

    /* renamed from: b */
    private static final da0 f11486b = new y90();

    /* renamed from: a */
    private final da0 f11487a;

    public v90() {
        this(new x90(k90.m6378c(), m7069c()));
    }

    /* renamed from: b */
    private static boolean m7068b(ea0 ea0) {
        return ea0.mo13895a() == zzemd.zziqj;
    }

    /* renamed from: c */
    private static da0 m7069c() {
        try {
            return (da0) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return f11486b;
        }
    }

    /* renamed from: a */
    public final <T> wa0<T> mo14927a(Class<T> cls) {
        Class<zzekh> cls2 = zzekh.class;
        ya0.m7333O(cls);
        ea0 a = this.f11487a.mo13817a(cls);
        if (a.mo13896b()) {
            if (cls2.isAssignableFrom(cls)) {
                return ia0.m6321a(ya0.m7372x(), f90.m6056b(), a.mo13897c());
            }
            return ia0.m6321a(ya0.m7370v(), f90.m6057c(), a.mo13897c());
        } else if (cls2.isAssignableFrom(cls)) {
            if (m7068b(a)) {
                return ha0.m6223q(cls, a, ma0.m6491b(), s90.m6836e(), ya0.m7372x(), f90.m6056b(), ba0.m5836b());
            }
            return ha0.m6223q(cls, a, ma0.m6491b(), s90.m6836e(), ya0.m7372x(), (d90<?>) null, ba0.m5836b());
        } else if (m7068b(a)) {
            return ha0.m6223q(cls, a, ma0.m6490a(), s90.m6835d(), ya0.m7370v(), f90.m6057c(), ba0.m5835a());
        } else {
            return ha0.m6223q(cls, a, ma0.m6490a(), s90.m6835d(), ya0.m7371w(), (d90<?>) null, ba0.m5835a());
        }
    }

    private v90(da0 da0) {
        zzekk.m8825c(da0, "messageInfoFactory");
        this.f11487a = da0;
    }
}
