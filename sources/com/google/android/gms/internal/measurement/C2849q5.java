package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.q5 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2849q5 extends C2897w5 {

    /* renamed from: b */
    private final /* synthetic */ C2841p5 f17430b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private C2849q5(C2841p5 p5Var) {
        super(p5Var, (C2833o5) null);
        this.f17430b = p5Var;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new C2857r5(this.f17430b, (C2833o5) null);
    }

    /* synthetic */ C2849q5(C2841p5 p5Var, C2833o5 o5Var) {
        this(p5Var);
    }
}
