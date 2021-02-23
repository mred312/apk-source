package com.google.firebase.crashlytics;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* renamed from: com.google.firebase.crashlytics.b */
/* compiled from: CrashlyticsRegistrar */
final /* synthetic */ class C3257b implements ComponentFactory {

    /* renamed from: a */
    private final CrashlyticsRegistrar f18957a;

    private C3257b(CrashlyticsRegistrar crashlyticsRegistrar) {
        this.f18957a = crashlyticsRegistrar;
    }

    /* renamed from: a */
    public static ComponentFactory m11204a(CrashlyticsRegistrar crashlyticsRegistrar) {
        return new C3257b(crashlyticsRegistrar);
    }

    public Object create(ComponentContainer componentContainer) {
        return this.f18957a.m11196b(componentContainer);
    }
}
