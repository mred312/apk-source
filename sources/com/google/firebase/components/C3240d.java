package com.google.firebase.components;

/* renamed from: com.google.firebase.components.d */
/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
final /* synthetic */ class C3240d implements ComponentFactory {

    /* renamed from: a */
    private final Object f18926a;

    private C3240d(Object obj) {
        this.f18926a = obj;
    }

    /* renamed from: a */
    public static ComponentFactory m11176a(Object obj) {
        return new C3240d(obj);
    }

    public Object create(ComponentContainer componentContainer) {
        Object obj = this.f18926a;
        Component.m11155a(obj, componentContainer);
        return obj;
    }
}
