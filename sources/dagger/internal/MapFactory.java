package dagger.internal;

import dagger.internal.AbstractMapFactory;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;

public final class MapFactory<K, V> extends AbstractMapFactory<K, V, V> {

    /* renamed from: b */
    private static final Provider<Map<Object, Object>> f21061b = InstanceFactory.create(Collections.emptyMap());

    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, V> {
        public MapFactory<K, V> build() {
            return new MapFactory<>(this.f21053a);
        }

        private Builder(int i) {
            super(i);
        }

        public Builder<K, V> put(K k, Provider<V> provider) {
            super.put(k, provider);
            return this;
        }

        public Builder<K, V> putAll(Provider<Map<K, V>> provider) {
            super.putAll(provider);
            return this;
        }
    }

    public static <K, V> Builder<K, V> builder(int i) {
        return new Builder<>(i);
    }

    public static <K, V> Provider<Map<K, V>> emptyMapProvider() {
        return f21061b;
    }

    private MapFactory(Map<K, Provider<V>> map) {
        super(map);
    }

    public Map<K, V> get() {
        LinkedHashMap newLinkedHashMapWithExpectedSize = DaggerCollections.newLinkedHashMapWithExpectedSize(mo24876b().size());
        for (Map.Entry entry : mo24876b().entrySet()) {
            newLinkedHashMapWithExpectedSize.put(entry.getKey(), ((Provider) entry.getValue()).get());
        }
        return Collections.unmodifiableMap(newLinkedHashMapWithExpectedSize);
    }
}
