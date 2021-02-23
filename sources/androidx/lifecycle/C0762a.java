package androidx.lifecycle;

import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.lifecycle.a */
/* compiled from: ClassesInfoCache */
final class C0762a {

    /* renamed from: c */
    static C0762a f3557c = new C0762a();

    /* renamed from: a */
    private final Map<Class<?>, C0763a> f3558a = new HashMap();

    /* renamed from: b */
    private final Map<Class<?>, Boolean> f3559b = new HashMap();

    /* renamed from: androidx.lifecycle.a$a */
    /* compiled from: ClassesInfoCache */
    static class C0763a {

        /* renamed from: a */
        final Map<Lifecycle.Event, List<C0764b>> f3560a = new HashMap();

        /* renamed from: b */
        final Map<C0764b, Lifecycle.Event> f3561b;

        C0763a(Map<C0764b, Lifecycle.Event> map) {
            this.f3561b = map;
            for (Map.Entry next : map.entrySet()) {
                Lifecycle.Event event = (Lifecycle.Event) next.getValue();
                List list = this.f3560a.get(event);
                if (list == null) {
                    list = new ArrayList();
                    this.f3560a.put(event, list);
                }
                list.add(next.getKey());
            }
        }

        /* renamed from: b */
        private static void m2609b(List<C0764b> list, LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).mo6285a(lifecycleOwner, event, obj);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6284a(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            m2609b(this.f3560a.get(event), lifecycleOwner, event, obj);
            m2609b(this.f3560a.get(Lifecycle.Event.ON_ANY), lifecycleOwner, event, obj);
        }
    }

    /* renamed from: androidx.lifecycle.a$b */
    /* compiled from: ClassesInfoCache */
    static final class C0764b {

        /* renamed from: a */
        final int f3562a;

        /* renamed from: b */
        final Method f3563b;

        C0764b(int i, Method method) {
            this.f3562a = i;
            this.f3563b = method;
            method.setAccessible(true);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6285a(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            try {
                int i = this.f3562a;
                if (i == 0) {
                    this.f3563b.invoke(obj, new Object[0]);
                } else if (i == 1) {
                    this.f3563b.invoke(obj, new Object[]{lifecycleOwner});
                } else if (i == 2) {
                    this.f3563b.invoke(obj, new Object[]{lifecycleOwner, event});
                }
            } catch (InvocationTargetException e) {
                throw new RuntimeException("Failed to call observer method", e.getCause());
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0764b)) {
                return false;
            }
            C0764b bVar = (C0764b) obj;
            if (this.f3562a != bVar.f3562a || !this.f3563b.getName().equals(bVar.f3563b.getName())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f3562a * 31) + this.f3563b.getName().hashCode();
        }
    }

    C0762a() {
    }

    /* renamed from: a */
    private C0763a m2604a(Class<?> cls, @Nullable Method[] methodArr) {
        int i;
        C0763a c;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (c = mo6282c(superclass)) == null)) {
            hashMap.putAll(c.f3561b);
        }
        for (Class c2 : cls.getInterfaces()) {
            for (Map.Entry next : mo6282c(c2).f3561b.entrySet()) {
                m2606e(hashMap, (C0764b) next.getKey(), (Lifecycle.Event) next.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = m2605b(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            OnLifecycleEvent onLifecycleEvent = (OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class);
            if (onLifecycleEvent != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (parameterTypes[0].isAssignableFrom(LifecycleOwner.class)) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                Lifecycle.Event value = onLifecycleEvent.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(Lifecycle.Event.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value == Lifecycle.Event.ON_ANY) {
                        i = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    m2606e(hashMap, new C0764b(i, method), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        C0763a aVar = new C0763a(hashMap);
        this.f3558a.put(cls, aVar);
        this.f3559b.put(cls, Boolean.valueOf(z));
        return aVar;
    }

    /* renamed from: b */
    private Method[] m2605b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    /* renamed from: e */
    private void m2606e(Map<C0764b, Lifecycle.Event> map, C0764b bVar, Lifecycle.Event event, Class<?> cls) {
        Lifecycle.Event event2 = map.get(bVar);
        if (event2 != null && event != event2) {
            Method method = bVar.f3563b;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
        } else if (event2 == null) {
            map.put(bVar, event);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C0763a mo6282c(Class<?> cls) {
        C0763a aVar = this.f3558a.get(cls);
        if (aVar != null) {
            return aVar;
        }
        return m2604a(cls, (Method[]) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo6283d(Class<?> cls) {
        Boolean bool = this.f3559b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b = m2605b(cls);
        for (Method annotation : b) {
            if (((OnLifecycleEvent) annotation.getAnnotation(OnLifecycleEvent.class)) != null) {
                m2604a(cls, b);
                return true;
            }
        }
        this.f3559b.put(cls, Boolean.FALSE);
        return false;
    }
}
