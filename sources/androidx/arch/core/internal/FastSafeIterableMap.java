package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {

    /* renamed from: e */
    private HashMap<K, SafeIterableMap.C0348c<K, V>> f1743e = new HashMap<>();

    public Map.Entry<K, V> ceil(K k) {
        if (contains(k)) {
            return this.f1743e.get(k).f1751d;
        }
        return null;
    }

    public boolean contains(K k) {
        return this.f1743e.containsKey(k);
    }

    /* access modifiers changed from: protected */
    public SafeIterableMap.C0348c<K, V> get(K k) {
        return this.f1743e.get(k);
    }

    public V putIfAbsent(@NonNull K k, @NonNull V v) {
        SafeIterableMap.C0348c cVar = get(k);
        if (cVar != null) {
            return cVar.f1749b;
        }
        this.f1743e.put(k, put(k, v));
        return null;
    }

    public V remove(@NonNull K k) {
        V remove = super.remove(k);
        this.f1743e.remove(k);
        return remove;
    }
}
