package com.google.firebase.components;

/* renamed from: com.google.firebase.components.c */
/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
final /* synthetic */ class C3239c implements ComponentFactory {

    /* renamed from: a */
    private final Object f18925a;

    private C3239c(Object obj) {
        this.f18925a = obj;
    }

    /* renamed from: a */
    public static ComponentFactory m11175a(Object obj) {
        return new C3239c(obj);
    }

    public Object create(ComponentContainer componentContainer) {
        Object obj = this.f18925a;
        Component.m11157c(obj, componentContainer);
        return obj;
    }
}
