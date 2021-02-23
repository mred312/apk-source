package com.google.firebase.components;

/* renamed from: com.google.firebase.components.b */
/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
final /* synthetic */ class C3238b implements ComponentFactory {

    /* renamed from: a */
    private final Object f18924a;

    private C3238b(Object obj) {
        this.f18924a = obj;
    }

    /* renamed from: a */
    public static ComponentFactory m11174a(Object obj) {
        return new C3238b(obj);
    }

    public Object create(ComponentContainer componentContainer) {
        Object obj = this.f18924a;
        Component.m11156b(obj, componentContainer);
        return obj;
    }
}
