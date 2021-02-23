package com.bumptech.glide.provider;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.util.Pools;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.util.MultiClassKey;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class LoadPathCache {

    /* renamed from: c */
    private static final LoadPath<?, ?, ?> f6295c = new LoadPath(Object.class, Object.class, Object.class, Collections.singletonList(new DecodePath(Object.class, Object.class, Object.class, Collections.emptyList(), new UnitTranscoder(), (Pools.Pool<List<Throwable>>) null)), (Pools.Pool<List<Throwable>>) null);

    /* renamed from: a */
    private final ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> f6296a = new ArrayMap<>();

    /* renamed from: b */
    private final AtomicReference<MultiClassKey> f6297b = new AtomicReference<>();

    /* renamed from: a */
    private MultiClassKey m4662a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        MultiClassKey andSet = this.f6297b.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new MultiClassKey();
        }
        andSet.set(cls, cls2, cls3);
        return andSet;
    }

    @Nullable
    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> get(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        LoadPath<Data, TResource, Transcode> loadPath;
        MultiClassKey a = m4662a(cls, cls2, cls3);
        synchronized (this.f6296a) {
            loadPath = this.f6296a.get(a);
        }
        this.f6297b.set(a);
        return loadPath;
    }

    public boolean isEmptyLoadPath(@Nullable LoadPath<?, ?, ?> loadPath) {
        return f6295c.equals(loadPath);
    }

    public void put(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable LoadPath<?, ?, ?> loadPath) {
        synchronized (this.f6296a) {
            ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> arrayMap = this.f6296a;
            MultiClassKey multiClassKey = new MultiClassKey(cls, cls2, cls3);
            if (loadPath == null) {
                loadPath = f6295c;
            }
            arrayMap.put(multiClassKey, loadPath);
        }
    }
}
