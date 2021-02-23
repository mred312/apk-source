package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Set;

/* renamed from: com.google.firebase.components.f */
/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
final /* synthetic */ class C3242f implements Provider {

    /* renamed from: a */
    private final Set f18929a;

    private C3242f(Set set) {
        this.f18929a = set;
    }

    /* renamed from: a */
    public static Provider m11178a(Set set) {
        return new C3242f(set);
    }

    public Object get() {
        return ComponentRuntime.m11170b(this.f18929a);
    }
}
