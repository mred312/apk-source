package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelLoaderRegistry {

    /* renamed from: a */
    private final MultiModelLoaderFactory f6045a;

    /* renamed from: b */
    private final C1284a f6046b;

    /* renamed from: com.bumptech.glide.load.model.ModelLoaderRegistry$a */
    private static class C1284a {

        /* renamed from: a */
        private final Map<Class<?>, C1285a<?>> f6047a = new HashMap();

        /* renamed from: com.bumptech.glide.load.model.ModelLoaderRegistry$a$a */
        private static class C1285a<Model> {

            /* renamed from: a */
            final List<ModelLoader<Model, ?>> f6048a;

            public C1285a(List<ModelLoader<Model, ?>> list) {
                this.f6048a = list;
            }
        }

        C1284a() {
        }

        /* renamed from: a */
        public void mo9780a() {
            this.f6047a.clear();
        }

        @Nullable
        /* renamed from: b */
        public <Model> List<ModelLoader<Model, ?>> mo9781b(Class<Model> cls) {
            C1285a aVar = this.f6047a.get(cls);
            if (aVar == null) {
                return null;
            }
            return aVar.f6048a;
        }

        /* renamed from: c */
        public <Model> void mo9782c(Class<Model> cls, List<ModelLoader<Model, ?>> list) {
            if (this.f6047a.put(cls, new C1285a(list)) != null) {
                throw new IllegalStateException("Already cached loaders for model: " + cls);
            }
        }
    }

    public ModelLoaderRegistry(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(new MultiModelLoaderFactory(pool));
    }

    @NonNull
    /* renamed from: a */
    private static <A> Class<A> m4471a(@NonNull A a) {
        return a.getClass();
    }

    @NonNull
    /* renamed from: b */
    private synchronized <A> List<ModelLoader<A, ?>> m4472b(@NonNull Class<A> cls) {
        List<ModelLoader<A, ?>> b;
        b = this.f6046b.mo9781b(cls);
        if (b == null) {
            b = Collections.unmodifiableList(this.f6045a.mo9785d(cls));
            this.f6046b.mo9782c(cls, b);
        }
        return b;
    }

    /* renamed from: c */
    private <Model, Data> void m4473c(@NonNull List<ModelLoaderFactory<? extends Model, ? extends Data>> list) {
        for (ModelLoaderFactory<? extends Model, ? extends Data> teardown : list) {
            teardown.teardown();
        }
    }

    public synchronized <Model, Data> void append(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.f6045a.mo9783b(cls, cls2, modelLoaderFactory);
        this.f6046b.mo9780a();
    }

    public synchronized <Model, Data> ModelLoader<Model, Data> build(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        return this.f6045a.build(cls, cls2);
    }

    @NonNull
    public synchronized List<Class<?>> getDataClasses(@NonNull Class<?> cls) {
        return this.f6045a.mo9786f(cls);
    }

    @NonNull
    public <A> List<ModelLoader<A, ?>> getModelLoaders(@NonNull A a) {
        List b = m4472b(m4471a(a));
        int size = b.size();
        List<ModelLoader<A, ?>> emptyList = Collections.emptyList();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            ModelLoader modelLoader = (ModelLoader) b.get(i);
            if (modelLoader.handles(a)) {
                if (z) {
                    emptyList = new ArrayList<>(size - i);
                    z = false;
                }
                emptyList.add(modelLoader);
            }
        }
        return emptyList;
    }

    public synchronized <Model, Data> void prepend(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.f6045a.mo9787h(cls, cls2, modelLoaderFactory);
        this.f6046b.mo9780a();
    }

    public synchronized <Model, Data> void remove(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        m4473c(this.f6045a.mo9788i(cls, cls2));
        this.f6046b.mo9780a();
    }

    public synchronized <Model, Data> void replace(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        m4473c(this.f6045a.mo9789j(cls, cls2, modelLoaderFactory));
        this.f6046b.mo9780a();
    }

    private ModelLoaderRegistry(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
        this.f6046b = new C1284a();
        this.f6045a = multiModelLoaderFactory;
    }
}
