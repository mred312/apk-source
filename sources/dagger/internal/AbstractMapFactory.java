package dagger.internal;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;

abstract class AbstractMapFactory<K, V, V2> implements Factory<Map<K, V2>> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Map<K, Provider<V>> f21052a;

    public static abstract class Builder<K, V, V2> {

        /* renamed from: a */
        final LinkedHashMap<K, Provider<V>> f21053a;

        Builder(int i) {
            this.f21053a = DaggerCollections.newLinkedHashMapWithExpectedSize(i);
        }

        /* access modifiers changed from: package-private */
        public Builder<K, V, V2> put(K k, Provider<V> provider) {
            this.f21053a.put(Preconditions.checkNotNull(k, "key"), Preconditions.checkNotNull(provider, "provider"));
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder<K, V, V2> putAll(Provider<Map<K, V2>> provider) {
            if (provider instanceof DelegateFactory) {
                return putAll(((DelegateFactory) provider).mo24879a());
            }
            this.f21053a.putAll(((AbstractMapFactory) provider).f21052a);
            return this;
        }
    }

    AbstractMapFactory(Map<K, Provider<V>> map) {
        this.f21052a = Collections.unmodifiableMap(map);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final Map<K, Provider<V>> mo24876b() {
        return this.f21052a;
    }
}
