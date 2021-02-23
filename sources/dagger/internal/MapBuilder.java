package dagger.internal;

import java.util.Collections;
import java.util.Map;

public final class MapBuilder<K, V> {

    /* renamed from: a */
    private final Map<K, V> f21060a;

    private MapBuilder(int i) {
        this.f21060a = DaggerCollections.newLinkedHashMapWithExpectedSize(i);
    }

    public static <K, V> MapBuilder<K, V> newMapBuilder(int i) {
        return new MapBuilder<>(i);
    }

    public Map<K, V> build() {
        if (this.f21060a.size() != 0) {
            return Collections.unmodifiableMap(this.f21060a);
        }
        return Collections.emptyMap();
    }

    public MapBuilder<K, V> put(K k, V v) {
        this.f21060a.put(k, v);
        return this;
    }

    public MapBuilder<K, V> putAll(Map<K, V> map) {
        this.f21060a.putAll(map);
        return this;
    }
}
