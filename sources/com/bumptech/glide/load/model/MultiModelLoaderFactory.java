package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MultiModelLoaderFactory {

    /* renamed from: e */
    private static final C1288c f6049e = new C1288c();

    /* renamed from: f */
    private static final ModelLoader<Object, Object> f6050f = new C1286a();

    /* renamed from: a */
    private final List<C1287b<?, ?>> f6051a;

    /* renamed from: b */
    private final C1288c f6052b;

    /* renamed from: c */
    private final Set<C1287b<?, ?>> f6053c;

    /* renamed from: d */
    private final Pools.Pool<List<Throwable>> f6054d;

    /* renamed from: com.bumptech.glide.load.model.MultiModelLoaderFactory$a */
    private static class C1286a implements ModelLoader<Object, Object> {
        C1286a() {
        }

        @Nullable
        public ModelLoader.LoadData<Object> buildLoadData(@NonNull Object obj, int i, int i2, @NonNull Options options) {
            return null;
        }

        public boolean handles(@NonNull Object obj) {
            return false;
        }
    }

    /* renamed from: com.bumptech.glide.load.model.MultiModelLoaderFactory$b */
    private static class C1287b<Model, Data> {

        /* renamed from: a */
        private final Class<Model> f6055a;

        /* renamed from: b */
        final Class<Data> f6056b;

        /* renamed from: c */
        final ModelLoaderFactory<? extends Model, ? extends Data> f6057c;

        public C1287b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
            this.f6055a = cls;
            this.f6056b = cls2;
            this.f6057c = modelLoaderFactory;
        }

        /* renamed from: a */
        public boolean mo9790a(@NonNull Class<?> cls) {
            return this.f6055a.isAssignableFrom(cls);
        }

        /* renamed from: b */
        public boolean mo9791b(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return mo9790a(cls) && this.f6056b.isAssignableFrom(cls2);
        }
    }

    /* renamed from: com.bumptech.glide.load.model.MultiModelLoaderFactory$c */
    static class C1288c {
        C1288c() {
        }

        @NonNull
        /* renamed from: a */
        public <Model, Data> C1290a<Model, Data> mo9792a(@NonNull List<ModelLoader<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            return new C1290a<>(list, pool);
        }
    }

    public MultiModelLoaderFactory(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, f6049e);
    }

    /* renamed from: a */
    private <Model, Data> void m4477a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory, boolean z) {
        C1287b bVar = new C1287b(cls, cls2, modelLoaderFactory);
        List<C1287b<?, ?>> list = this.f6051a;
        list.add(z ? list.size() : 0, bVar);
    }

    @NonNull
    /* renamed from: c */
    private <Model, Data> ModelLoader<Model, Data> m4478c(@NonNull C1287b<?, ?> bVar) {
        return (ModelLoader) Preconditions.checkNotNull(bVar.f6057c.build(this));
    }

    @NonNull
    /* renamed from: e */
    private static <Model, Data> ModelLoader<Model, Data> m4479e() {
        return f6050f;
    }

    @NonNull
    /* renamed from: g */
    private <Model, Data> ModelLoaderFactory<Model, Data> m4480g(@NonNull C1287b<?, ?> bVar) {
        return bVar.f6057c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized <Model, Data> void mo9783b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        m4477a(cls, cls2, modelLoaderFactory, true);
    }

    @NonNull
    public synchronized <Model, Data> ModelLoader<Model, Data> build(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (C1287b next : this.f6051a) {
                if (this.f6053c.contains(next)) {
                    z = true;
                } else if (next.mo9791b(cls, cls2)) {
                    this.f6053c.add(next);
                    arrayList.add(m4478c(next));
                    this.f6053c.remove(next);
                }
            }
            if (arrayList.size() > 1) {
                return this.f6052b.mo9792a(arrayList, this.f6054d);
            } else if (arrayList.size() == 1) {
                return (ModelLoader) arrayList.get(0);
            } else if (z) {
                return m4479e();
            } else {
                throw new Registry.NoModelLoaderAvailableException(cls, cls2);
            }
        } catch (Throwable th) {
            this.f6053c.clear();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: d */
    public synchronized <Model> List<ModelLoader<Model, ?>> mo9785d(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (C1287b next : this.f6051a) {
                if (!this.f6053c.contains(next)) {
                    if (next.mo9790a(cls)) {
                        this.f6053c.add(next);
                        arrayList.add(m4478c(next));
                        this.f6053c.remove(next);
                    }
                }
            }
        } catch (Throwable th) {
            this.f6053c.clear();
            throw th;
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: f */
    public synchronized List<Class<?>> mo9786f(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (C1287b next : this.f6051a) {
            if (!arrayList.contains(next.f6056b) && next.mo9790a(cls)) {
                arrayList.add(next.f6056b);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public synchronized <Model, Data> void mo9787h(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        m4477a(cls, cls2, modelLoaderFactory, false);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: i */
    public synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> mo9788i(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<C1287b<?, ?>> it = this.f6051a.iterator();
        while (it.hasNext()) {
            C1287b next = it.next();
            if (next.mo9791b(cls, cls2)) {
                it.remove();
                arrayList.add(m4480g(next));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: j */
    public synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> mo9789j(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        List<ModelLoaderFactory<? extends Model, ? extends Data>> i;
        i = mo9788i(cls, cls2);
        mo9783b(cls, cls2, modelLoaderFactory);
        return i;
    }

    @VisibleForTesting
    MultiModelLoaderFactory(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull C1288c cVar) {
        this.f6051a = new ArrayList();
        this.f6053c = new HashSet();
        this.f6054d = pool;
        this.f6052b = cVar;
    }
}
