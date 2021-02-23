package dagger.internal;

import dagger.Lazy;

public final class InstanceFactory<T> implements Factory<T>, Lazy<T> {

    /* renamed from: b */
    private static final InstanceFactory<Object> f21058b = new InstanceFactory<>((Object) null);

    /* renamed from: a */
    private final T f21059a;

    private InstanceFactory(T t) {
        this.f21059a = t;
    }

    /* renamed from: a */
    private static <T> InstanceFactory<T> m14131a() {
        return f21058b;
    }

    public static <T> Factory<T> create(T t) {
        return new InstanceFactory(Preconditions.checkNotNull(t, "instance cannot be null"));
    }

    public static <T> Factory<T> createNullable(T t) {
        if (t == null) {
            return m14131a();
        }
        return new InstanceFactory(t);
    }

    public T get() {
        return this.f21059a;
    }
}
