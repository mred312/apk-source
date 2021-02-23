package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.q4 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2848q4 implements C2825n5 {

    /* renamed from: b */
    private static final C2903x4 f17428b = new C2840p4();

    /* renamed from: a */
    private final C2903x4 f17429a;

    public C2848q4() {
        this(new C2856r4(C2748e4.m9395c(), m9757b()));
    }

    /* renamed from: b */
    private static C2903x4 m9757b() {
        try {
            return (C2903x4) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return f17428b;
        }
    }

    /* renamed from: c */
    private static boolean m9758c(C2888v4 v4Var) {
        return v4Var.zza() == zzjw.zza;
    }

    /* renamed from: a */
    public final <T> C2793j5<T> mo18773a(Class<T> cls) {
        Class<zzhz> cls2 = zzhz.class;
        C2817m5.m9653p(cls);
        C2888v4 b = this.f17429a.mo18614b(cls);
        if (b.zzb()) {
            if (cls2.isAssignableFrom(cls)) {
                return C2717a5.m9305i(C2817m5.m9609B(), C2916z3.m10009a(), b.zzc());
            }
            return C2717a5.m9305i(C2817m5.m9643f(), C2916z3.m10010b(), b.zzc());
        } else if (cls2.isAssignableFrom(cls)) {
            if (m9758c(b)) {
                return C2910y4.m9984p(cls, b, C2741d5.m9353b(), C2800k4.m9549d(), C2817m5.m9609B(), C2916z3.m10009a(), C2896w4.m9892b());
            }
            return C2910y4.m9984p(cls, b, C2741d5.m9353b(), C2800k4.m9549d(), C2817m5.m9609B(), (C2902x3<?>) null, C2896w4.m9892b());
        } else if (m9758c(b)) {
            return C2910y4.m9984p(cls, b, C2741d5.m9352a(), C2800k4.m9548a(), C2817m5.m9643f(), C2916z3.m10010b(), C2896w4.m9891a());
        } else {
            return C2910y4.m9984p(cls, b, C2741d5.m9352a(), C2800k4.m9548a(), C2817m5.m9659v(), (C2902x3<?>) null, C2896w4.m9891a());
        }
    }

    private C2848q4(C2903x4 x4Var) {
        zzic.m10385d(x4Var, "messageInfoFactory");
        this.f17429a = x4Var;
    }
}
