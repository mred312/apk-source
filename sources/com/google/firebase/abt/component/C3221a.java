package com.google.firebase.abt.component;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* renamed from: com.google.firebase.abt.component.a */
/* compiled from: AbtRegistrar */
final /* synthetic */ class C3221a implements ComponentFactory {

    /* renamed from: a */
    private static final C3221a f18868a = new C3221a();

    private C3221a() {
    }

    /* renamed from: a */
    public static ComponentFactory m11147a() {
        return f18868a;
    }

    public Object create(ComponentContainer componentContainer) {
        return AbtRegistrar.lambda$getComponents$0(componentContainer);
    }
}
