package com.google.firebase.components;

import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
public class ComponentRuntime extends C3237a {

    /* renamed from: e */
    private static final Provider<Set<Object>> f18912e = C3243g.m11179a();

    /* renamed from: a */
    private final Map<Component<?>, Lazy<?>> f18913a = new HashMap();

    /* renamed from: b */
    private final Map<Class<?>, Lazy<?>> f18914b = new HashMap();

    /* renamed from: c */
    private final Map<Class<?>, Lazy<Set<?>>> f18915c = new HashMap();

    /* renamed from: d */
    private final C3249j f18916d;

    public ComponentRuntime(Executor executor, Iterable<ComponentRegistrar> iterable, Component<?>... componentArr) {
        C3249j jVar = new C3249j(executor);
        this.f18916d = jVar;
        ArrayList<Component> arrayList = new ArrayList<>();
        arrayList.add(Component.m11159of(jVar, C3249j.class, Subscriber.class, Publisher.class));
        for (ComponentRegistrar components : iterable) {
            arrayList.addAll(components.getComponents());
        }
        for (Component<?> component : componentArr) {
            if (component != null) {
                arrayList.add(component);
            }
        }
        C3244h.m11180a(arrayList);
        for (Component component2 : arrayList) {
            this.f18913a.put(component2, new Lazy(C3241e.m11177a(this, component2)));
        }
        m11171c();
        m11172d();
    }

    /* renamed from: b */
    static /* synthetic */ Set m11170b(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(((Lazy) it.next()).get());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* renamed from: c */
    private void m11171c() {
        for (Map.Entry next : this.f18913a.entrySet()) {
            Component component = (Component) next.getKey();
            if (component.isValue()) {
                Lazy lazy = (Lazy) next.getValue();
                for (Class put : component.getProvidedInterfaces()) {
                    this.f18914b.put(put, lazy);
                }
            }
        }
        m11173e();
    }

    /* renamed from: d */
    private void m11172d() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f18913a.entrySet()) {
            Component component = (Component) next.getKey();
            if (!component.isValue()) {
                Lazy lazy = (Lazy) next.getValue();
                for (Class cls : component.getProvidedInterfaces()) {
                    if (!hashMap.containsKey(cls)) {
                        hashMap.put(cls, new HashSet());
                    }
                    ((Set) hashMap.get(cls)).add(lazy);
                }
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            this.f18915c.put((Class) entry.getKey(), new Lazy(C3242f.m11178a((Set) entry.getValue())));
        }
    }

    /* renamed from: e */
    private void m11173e() {
        for (Component next : this.f18913a.keySet()) {
            Iterator<Dependency> it = next.getDependencies().iterator();
            while (true) {
                if (it.hasNext()) {
                    Dependency next2 = it.next();
                    if (next2.isRequired() && !this.f18914b.containsKey(next2.getInterface())) {
                        throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", new Object[]{next, next2.getInterface()}));
                    }
                }
            }
        }
    }

    public /* bridge */ /* synthetic */ Object get(Class cls) {
        return super.get(cls);
    }

    public <T> Provider<T> getProvider(Class<T> cls) {
        Preconditions.checkNotNull(cls, "Null interface requested.");
        return this.f18914b.get(cls);
    }

    public void initializeEagerComponents(boolean z) {
        for (Map.Entry next : this.f18913a.entrySet()) {
            Component component = (Component) next.getKey();
            Lazy lazy = (Lazy) next.getValue();
            if (component.isAlwaysEager() || (component.isEagerInDefaultApp() && z)) {
                lazy.get();
            }
        }
        this.f18916d.mo20827a();
    }

    public /* bridge */ /* synthetic */ Set setOf(Class cls) {
        return super.setOf(cls);
    }

    public <T> Provider<Set<T>> setOfProvider(Class<T> cls) {
        Lazy lazy = this.f18915c.get(cls);
        if (lazy != null) {
            return lazy;
        }
        return f18912e;
    }
}
