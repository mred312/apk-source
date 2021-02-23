package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.r4 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2856r4 implements C2903x4 {

    /* renamed from: a */
    private C2903x4[] f17443a;

    C2856r4(C2903x4... x4VarArr) {
        this.f17443a = x4VarArr;
    }

    /* renamed from: a */
    public final boolean mo18613a(Class<?> cls) {
        for (C2903x4 a : this.f17443a) {
            if (a.mo18613a(cls)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public final C2888v4 mo18614b(Class<?> cls) {
        for (C2903x4 x4Var : this.f17443a) {
            if (x4Var.mo18613a(cls)) {
                return x4Var.mo18614b(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
