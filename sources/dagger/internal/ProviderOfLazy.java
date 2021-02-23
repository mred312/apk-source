package dagger.internal;

import dagger.Lazy;
import javax.inject.Provider;

public final class ProviderOfLazy<T> implements Provider<Lazy<T>> {

    /* renamed from: a */
    private final Provider<T> f21064a;

    private ProviderOfLazy(Provider<T> provider) {
        this.f21064a = provider;
    }

    public static <T> Provider<Lazy<T>> create(Provider<T> provider) {
        return new ProviderOfLazy((Provider) Preconditions.checkNotNull(provider));
    }

    public Lazy<T> get() {
        return DoubleCheck.lazy(this.f21064a);
    }
}
