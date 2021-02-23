package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;

public class UnitModelLoader<Model> implements ModelLoader<Model, Model> {

    /* renamed from: a */
    private static final UnitModelLoader<?> f6066a = new UnitModelLoader<>();

    public static class Factory<Model> implements ModelLoaderFactory<Model, Model> {

        /* renamed from: a */
        private static final Factory<?> f6067a = new Factory<>();

        public static <T> Factory<T> getInstance() {
            return f6067a;
        }

        @NonNull
        public ModelLoader<Model, Model> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return UnitModelLoader.getInstance();
        }

        public void teardown() {
        }
    }

    /* renamed from: com.bumptech.glide.load.model.UnitModelLoader$a */
    private static class C1289a<Model> implements DataFetcher<Model> {

        /* renamed from: a */
        private final Model f6068a;

        C1289a(Model model) {
            this.f6068a = model;
        }

        public void cancel() {
        }

        public void cleanup() {
        }

        @NonNull
        public Class<Model> getDataClass() {
            return this.f6068a.getClass();
        }

        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Model> dataCallback) {
            dataCallback.onDataReady(this.f6068a);
        }
    }

    public static <T> UnitModelLoader<T> getInstance() {
        return f6066a;
    }

    public ModelLoader.LoadData<Model> buildLoadData(@NonNull Model model, int i, int i2, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(model), new C1289a(model));
    }

    public boolean handles(@NonNull Model model) {
        return true;
    }
}
