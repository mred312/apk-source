package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* renamed from: com.google.firebase.components.e */
/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
final /* synthetic */ class C3241e implements Provider {

    /* renamed from: a */
    private final ComponentRuntime f18927a;

    /* renamed from: b */
    private final Component f18928b;

    private C3241e(ComponentRuntime componentRuntime, Component component) {
        this.f18927a = componentRuntime;
        this.f18928b = component;
    }

    /* renamed from: a */
    public static Provider m11177a(ComponentRuntime componentRuntime, Component component) {
        return new C3241e(componentRuntime, component);
    }

    public Object get() {
        return this.f18928b.getFactory().create(new C3250k(this.f18928b, this.f18927a));
    }
}
