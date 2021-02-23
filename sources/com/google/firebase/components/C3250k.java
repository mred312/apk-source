package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.firebase.components.k */
/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
final class C3250k extends C3237a {

    /* renamed from: a */
    private final Set<Class<?>> f18941a;

    /* renamed from: b */
    private final Set<Class<?>> f18942b;

    /* renamed from: c */
    private final Set<Class<?>> f18943c;

    /* renamed from: d */
    private final Set<Class<?>> f18944d;

    /* renamed from: e */
    private final Set<Class<?>> f18945e;

    /* renamed from: f */
    private final ComponentContainer f18946f;

    /* renamed from: com.google.firebase.components.k$a */
    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    private static class C3251a implements Publisher {

        /* renamed from: a */
        private final Set<Class<?>> f18947a;

        /* renamed from: b */
        private final Publisher f18948b;

        public C3251a(Set<Class<?>> set, Publisher publisher) {
            this.f18947a = set;
            this.f18948b = publisher;
        }

        public void publish(Event<?> event) {
            if (this.f18947a.contains(event.getType())) {
                this.f18948b.publish(event);
            } else {
                throw new IllegalArgumentException(String.format("Attempting to publish an undeclared event %s.", new Object[]{event}));
            }
        }
    }

    C3250k(Component<?> component, ComponentContainer componentContainer) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (Dependency next : component.getDependencies()) {
            if (next.isDirectInjection()) {
                if (next.isSet()) {
                    hashSet3.add(next.getInterface());
                } else {
                    hashSet.add(next.getInterface());
                }
            } else if (next.isSet()) {
                hashSet4.add(next.getInterface());
            } else {
                hashSet2.add(next.getInterface());
            }
        }
        if (!component.getPublishedEvents().isEmpty()) {
            hashSet.add(Publisher.class);
        }
        this.f18941a = Collections.unmodifiableSet(hashSet);
        this.f18942b = Collections.unmodifiableSet(hashSet2);
        this.f18943c = Collections.unmodifiableSet(hashSet3);
        this.f18944d = Collections.unmodifiableSet(hashSet4);
        this.f18945e = component.getPublishedEvents();
        this.f18946f = componentContainer;
    }

    public <T> T get(Class<T> cls) {
        if (this.f18941a.contains(cls)) {
            T t = this.f18946f.get(cls);
            if (!cls.equals(Publisher.class)) {
                return t;
            }
            return new C3251a(this.f18945e, (Publisher) t);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", new Object[]{cls}));
    }

    public <T> Provider<T> getProvider(Class<T> cls) {
        if (this.f18942b.contains(cls)) {
            return this.f18946f.getProvider(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", new Object[]{cls}));
    }

    public <T> Set<T> setOf(Class<T> cls) {
        if (this.f18943c.contains(cls)) {
            return this.f18946f.setOf(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", new Object[]{cls}));
    }

    public <T> Provider<Set<T>> setOfProvider(Class<T> cls) {
        if (this.f18944d.contains(cls)) {
            return this.f18946f.setOfProvider(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", new Object[]{cls}));
    }
}
