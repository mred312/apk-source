package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
public class Lazy<T> implements Provider<T> {

    /* renamed from: c */
    private static final Object f18921c = new Object();

    /* renamed from: a */
    private volatile Object f18922a = f18921c;

    /* renamed from: b */
    private volatile Provider<T> f18923b;

    public Lazy(Provider<T> provider) {
        this.f18923b = provider;
    }

    public T get() {
        T t = this.f18922a;
        T t2 = f18921c;
        if (t == t2) {
            synchronized (this) {
                t = this.f18922a;
                if (t == t2) {
                    t = this.f18923b.get();
                    this.f18922a = t;
                    this.f18923b = null;
                }
            }
        }
        return t;
    }
}
