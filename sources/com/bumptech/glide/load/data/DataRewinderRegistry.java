package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DataRewinderRegistry {

    /* renamed from: b */
    private static final DataRewinder.Factory<?> f5620b = new C1171a();

    /* renamed from: a */
    private final Map<Class<?>, DataRewinder.Factory<?>> f5621a = new HashMap();

    /* renamed from: com.bumptech.glide.load.data.DataRewinderRegistry$a */
    class C1171a implements DataRewinder.Factory<Object> {
        C1171a() {
        }

        @NonNull
        public DataRewinder<Object> build(@NonNull Object obj) {
            return new C1172b(obj);
        }

        @NonNull
        public Class<Object> getDataClass() {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    /* renamed from: com.bumptech.glide.load.data.DataRewinderRegistry$b */
    private static final class C1172b implements DataRewinder<Object> {

        /* renamed from: a */
        private final Object f5622a;

        C1172b(@NonNull Object obj) {
            this.f5622a = obj;
        }

        public void cleanup() {
        }

        @NonNull
        public Object rewindAndGet() {
            return this.f5622a;
        }
    }

    @NonNull
    public synchronized <T> DataRewinder<T> build(@NonNull T t) {
        DataRewinder.Factory<?> factory;
        Preconditions.checkNotNull(t);
        factory = this.f5621a.get(t.getClass());
        if (factory == null) {
            Iterator<DataRewinder.Factory<?>> it = this.f5621a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DataRewinder.Factory<?> next = it.next();
                if (next.getDataClass().isAssignableFrom(t.getClass())) {
                    factory = next;
                    break;
                }
            }
        }
        if (factory == null) {
            factory = f5620b;
        }
        return factory.build(t);
    }

    public synchronized void register(@NonNull DataRewinder.Factory<?> factory) {
        this.f5621a.put(factory.getDataClass(), factory);
    }
}
