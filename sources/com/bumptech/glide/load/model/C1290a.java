package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.bumptech.glide.load.model.a */
/* compiled from: MultiModelLoader */
class C1290a<Model, Data> implements ModelLoader<Model, Data> {

    /* renamed from: a */
    private final List<ModelLoader<Model, Data>> f6076a;

    /* renamed from: b */
    private final Pools.Pool<List<Throwable>> f6077b;

    /* renamed from: com.bumptech.glide.load.model.a$a */
    /* compiled from: MultiModelLoader */
    static class C1291a<Data> implements DataFetcher<Data>, DataFetcher.DataCallback<Data> {

        /* renamed from: a */
        private final List<DataFetcher<Data>> f6078a;

        /* renamed from: b */
        private final Pools.Pool<List<Throwable>> f6079b;

        /* renamed from: c */
        private int f6080c = 0;

        /* renamed from: d */
        private Priority f6081d;

        /* renamed from: e */
        private DataFetcher.DataCallback<? super Data> f6082e;
        @Nullable

        /* renamed from: f */
        private List<Throwable> f6083f;

        /* renamed from: g */
        private boolean f6084g;

        C1291a(@NonNull List<DataFetcher<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.f6079b = pool;
            Preconditions.checkNotEmpty(list);
            this.f6078a = list;
        }

        /* renamed from: a */
        private void m4493a() {
            if (!this.f6084g) {
                if (this.f6080c < this.f6078a.size() - 1) {
                    this.f6080c++;
                    loadData(this.f6081d, this.f6082e);
                    return;
                }
                Preconditions.checkNotNull(this.f6083f);
                this.f6082e.onLoadFailed(new GlideException("Fetch failed", (List<Throwable>) new ArrayList(this.f6083f)));
            }
        }

        public void cancel() {
            this.f6084g = true;
            for (DataFetcher<Data> cancel : this.f6078a) {
                cancel.cancel();
            }
        }

        public void cleanup() {
            List<Throwable> list = this.f6083f;
            if (list != null) {
                this.f6079b.release(list);
            }
            this.f6083f = null;
            for (DataFetcher<Data> cleanup : this.f6078a) {
                cleanup.cleanup();
            }
        }

        @NonNull
        public Class<Data> getDataClass() {
            return this.f6078a.get(0).getDataClass();
        }

        @NonNull
        public DataSource getDataSource() {
            return this.f6078a.get(0).getDataSource();
        }

        public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Data> dataCallback) {
            this.f6081d = priority;
            this.f6082e = dataCallback;
            this.f6083f = this.f6079b.acquire();
            this.f6078a.get(this.f6080c).loadData(priority, this);
            if (this.f6084g) {
                cancel();
            }
        }

        public void onDataReady(@Nullable Data data) {
            if (data != null) {
                this.f6082e.onDataReady(data);
            } else {
                m4493a();
            }
        }

        public void onLoadFailed(@NonNull Exception exc) {
            ((List) Preconditions.checkNotNull(this.f6083f)).add(exc);
            m4493a();
        }
    }

    C1290a(@NonNull List<ModelLoader<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.f6076a = list;
        this.f6077b = pool;
    }

    public ModelLoader.LoadData<Data> buildLoadData(@NonNull Model model, int i, int i2, @NonNull Options options) {
        ModelLoader.LoadData buildLoadData;
        int size = this.f6076a.size();
        ArrayList arrayList = new ArrayList(size);
        Key key = null;
        for (int i3 = 0; i3 < size; i3++) {
            ModelLoader modelLoader = this.f6076a.get(i3);
            if (modelLoader.handles(model) && (buildLoadData = modelLoader.buildLoadData(model, i, i2, options)) != null) {
                key = buildLoadData.sourceKey;
                arrayList.add(buildLoadData.fetcher);
            }
        }
        if (arrayList.isEmpty() || key == null) {
            return null;
        }
        return new ModelLoader.LoadData<>(key, new C1291a(arrayList, this.f6077b));
    }

    public boolean handles(@NonNull Model model) {
        for (ModelLoader<Model, Data> handles : this.f6076a) {
            if (handles.handles(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f6076a.toArray()) + '}';
    }
}
