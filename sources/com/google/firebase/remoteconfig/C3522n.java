package com.google.firebase.remoteconfig;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* renamed from: com.google.firebase.remoteconfig.n */
/* compiled from: RemoteConfigRegistrar */
final /* synthetic */ class C3522n implements ComponentFactory {

    /* renamed from: a */
    private static final C3522n f19719a = new C3522n();

    private C3522n() {
    }

    /* renamed from: a */
    public static ComponentFactory m11890a() {
        return f19719a;
    }

    public Object create(ComponentContainer componentContainer) {
        return RemoteConfigRegistrar.lambda$getComponents$0(componentContainer);
    }
}
