package dagger.internal;

import javax.inject.Provider;

public final class DelegateFactory<T> implements Factory<T> {

    /* renamed from: a */
    private Provider<T> f21054a;

    public static <T> void setDelegate(Provider<T> provider, Provider<T> provider2) {
        Preconditions.checkNotNull(provider2);
        DelegateFactory delegateFactory = (DelegateFactory) provider;
        if (delegateFactory.f21054a == null) {
            delegateFactory.f21054a = provider2;
            return;
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Provider<T> mo24879a() {
        return (Provider) Preconditions.checkNotNull(this.f21054a);
    }

    public T get() {
        Provider<T> provider = this.f21054a;
        if (provider != null) {
            return provider.get();
        }
        throw new IllegalStateException();
    }

    @Deprecated
    public void setDelegatedProvider(Provider<T> provider) {
        setDelegate(this, provider);
    }
}
