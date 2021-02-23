package dagger.internal;

import dagger.Lazy;
import javax.inject.Provider;

public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {

    /* renamed from: c */
    private static final Object f21055c = new Object();

    /* renamed from: a */
    private volatile Provider<T> f21056a;

    /* renamed from: b */
    private volatile Object f21057b = f21055c;

    private DoubleCheck(Provider<T> provider) {
        this.f21056a = provider;
    }

    public static <P extends Provider<T>, T> Lazy<T> lazy(P p) {
        if (p instanceof Lazy) {
            return (Lazy) p;
        }
        return new DoubleCheck((Provider) Preconditions.checkNotNull(p));
    }

    public static <P extends Provider<T>, T> Provider<T> provider(P p) {
        Preconditions.checkNotNull(p);
        if (p instanceof DoubleCheck) {
            return p;
        }
        return new DoubleCheck(p);
    }

    public static Object reentrantCheck(Object obj, Object obj2) {
        if (!(obj != f21055c && !(obj instanceof MemoizedSentinel)) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    public T get() {
        T t = this.f21057b;
        T t2 = f21055c;
        if (t == t2) {
            synchronized (this) {
                t = this.f21057b;
                if (t == t2) {
                    t = this.f21056a.get();
                    this.f21057b = reentrantCheck(this.f21057b, t);
                    this.f21056a = null;
                }
            }
        }
        return t;
    }
}
