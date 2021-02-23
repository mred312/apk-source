package dagger.internal;

import javax.inject.Provider;

public final class SingleCheck<T> implements Provider<T> {

    /* renamed from: c */
    private static final Object f21071c = new Object();

    /* renamed from: a */
    private volatile Provider<T> f21072a;

    /* renamed from: b */
    private volatile Object f21073b = f21071c;

    private SingleCheck(Provider<T> provider) {
        this.f21072a = provider;
    }

    public static <P extends Provider<T>, T> Provider<T> provider(P p) {
        return ((p instanceof SingleCheck) || (p instanceof DoubleCheck)) ? p : new SingleCheck((Provider) Preconditions.checkNotNull(p));
    }

    public T get() {
        T t = this.f21073b;
        if (t != f21071c) {
            return t;
        }
        Provider<T> provider = this.f21072a;
        if (provider == null) {
            return this.f21073b;
        }
        T t2 = provider.get();
        this.f21073b = t2;
        this.f21072a = null;
        return t2;
    }
}
