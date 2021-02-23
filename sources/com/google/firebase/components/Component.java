package com.google.firebase.components;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
public final class Component<T> {

    /* renamed from: a */
    private final Set<Class<? super T>> f18897a;

    /* renamed from: b */
    private final Set<Dependency> f18898b;

    /* renamed from: c */
    private final int f18899c;

    /* renamed from: d */
    private final int f18900d;

    /* renamed from: e */
    private final ComponentFactory<T> f18901e;

    /* renamed from: f */
    private final Set<Class<?>> f18902f;

    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    public static class Builder<T> {

        /* renamed from: a */
        private final Set<Class<? super T>> f18903a;

        /* renamed from: b */
        private final Set<Dependency> f18904b;

        /* renamed from: c */
        private int f18905c;

        /* renamed from: d */
        private int f18906d;

        /* renamed from: e */
        private ComponentFactory<T> f18907e;

        /* renamed from: f */
        private Set<Class<?>> f18908f;

        /* access modifiers changed from: private */
        /* renamed from: b */
        public Builder<T> m11161b() {
            this.f18906d = 1;
            return this;
        }

        /* renamed from: c */
        private Builder<T> m11162c(int i) {
            Preconditions.checkState(this.f18905c == 0, "Instantiation type has already been set.");
            this.f18905c = i;
            return this;
        }

        /* renamed from: d */
        private void m11163d(Class<?> cls) {
            Preconditions.checkArgument(!this.f18903a.contains(cls), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public Builder<T> add(Dependency dependency) {
            Preconditions.checkNotNull(dependency, "Null dependency");
            m11163d(dependency.getInterface());
            this.f18904b.add(dependency);
            return this;
        }

        public Builder<T> alwaysEager() {
            m11162c(1);
            return this;
        }

        public Component<T> build() {
            Preconditions.checkState(this.f18907e != null, "Missing required property: factory.");
            return new Component(new HashSet(this.f18903a), new HashSet(this.f18904b), this.f18905c, this.f18906d, this.f18907e, this.f18908f);
        }

        public Builder<T> eagerInDefaultApp() {
            m11162c(2);
            return this;
        }

        public Builder<T> factory(ComponentFactory<T> componentFactory) {
            this.f18907e = (ComponentFactory) Preconditions.checkNotNull(componentFactory, "Null factory");
            return this;
        }

        public Builder<T> publishes(Class<?> cls) {
            this.f18908f.add(cls);
            return this;
        }

        @SafeVarargs
        private Builder(Class<T> cls, Class<? super T>... clsArr) {
            HashSet hashSet = new HashSet();
            this.f18903a = hashSet;
            this.f18904b = new HashSet();
            this.f18905c = 0;
            this.f18906d = 0;
            this.f18908f = new HashSet();
            Preconditions.checkNotNull(cls, "Null interface");
            hashSet.add(cls);
            for (Class<? super T> checkNotNull : clsArr) {
                Preconditions.checkNotNull(checkNotNull, "Null interface");
            }
            Collections.addAll(this.f18903a, clsArr);
        }
    }

    /* renamed from: a */
    static /* synthetic */ Object m11155a(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    /* renamed from: b */
    static /* synthetic */ Object m11156b(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    public static <T> Builder<T> builder(Class<T> cls) {
        return new Builder<>(cls, new Class[0]);
    }

    /* renamed from: c */
    static /* synthetic */ Object m11157c(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    public static <T> Component<T> intoSet(T t, Class<T> cls) {
        return intoSetBuilder(cls).factory(C3240d.m11176a(t)).build();
    }

    public static <T> Builder<T> intoSetBuilder(Class<T> cls) {
        Builder<T> builder = builder(cls);
        Builder unused = builder.m11161b();
        return builder;
    }

    @Deprecated
    /* renamed from: of */
    public static <T> Component<T> m11158of(Class<T> cls, T t) {
        return builder(cls).factory(C3238b.m11174a(t)).build();
    }

    public Set<Dependency> getDependencies() {
        return this.f18898b;
    }

    public ComponentFactory<T> getFactory() {
        return this.f18901e;
    }

    public Set<Class<? super T>> getProvidedInterfaces() {
        return this.f18897a;
    }

    public Set<Class<?>> getPublishedEvents() {
        return this.f18902f;
    }

    public boolean isAlwaysEager() {
        return this.f18899c == 1;
    }

    public boolean isEagerInDefaultApp() {
        return this.f18899c == 2;
    }

    public boolean isLazy() {
        return this.f18899c == 0;
    }

    public boolean isValue() {
        return this.f18900d == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f18897a.toArray()) + ">{" + this.f18899c + ", type=" + this.f18900d + ", deps=" + Arrays.toString(this.f18898b.toArray()) + "}";
    }

    private Component(Set<Class<? super T>> set, Set<Dependency> set2, int i, int i2, ComponentFactory<T> componentFactory, Set<Class<?>> set3) {
        this.f18897a = Collections.unmodifiableSet(set);
        this.f18898b = Collections.unmodifiableSet(set2);
        this.f18899c = i;
        this.f18900d = i2;
        this.f18901e = componentFactory;
        this.f18902f = Collections.unmodifiableSet(set3);
    }

    @SafeVarargs
    public static <T> Builder<T> builder(Class<T> cls, Class<? super T>... clsArr) {
        return new Builder<>(cls, clsArr);
    }

    @SafeVarargs
    /* renamed from: of */
    public static <T> Component<T> m11159of(T t, Class<T> cls, Class<? super T>... clsArr) {
        return builder(cls, clsArr).factory(C3239c.m11175a(t)).build();
    }
}
