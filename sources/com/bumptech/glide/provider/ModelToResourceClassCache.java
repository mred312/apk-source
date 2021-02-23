package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.util.MultiClassKey;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ModelToResourceClassCache {

    /* renamed from: a */
    private final AtomicReference<MultiClassKey> f6298a = new AtomicReference<>();

    /* renamed from: b */
    private final ArrayMap<MultiClassKey, List<Class<?>>> f6299b = new ArrayMap<>();

    public void clear() {
        synchronized (this.f6299b) {
            this.f6299b.clear();
        }
    }

    @Nullable
    public List<Class<?>> get(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3) {
        List<Class<?>> list;
        MultiClassKey andSet = this.f6298a.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new MultiClassKey(cls, cls2, cls3);
        } else {
            andSet.set(cls, cls2, cls3);
        }
        synchronized (this.f6299b) {
            list = this.f6299b.get(andSet);
        }
        this.f6298a.set(andSet);
        return list;
    }

    public void put(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3, @NonNull List<Class<?>> list) {
        synchronized (this.f6299b) {
            this.f6299b.put(new MultiClassKey(cls, cls2, cls3), list);
        }
    }
}
