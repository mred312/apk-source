package com.bumptech.glide.load.model;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class DataUrlLoader<Model, Data> implements ModelLoader<Model, Data> {

    /* renamed from: a */
    private final DataDecoder<Data> f6010a;

    public interface DataDecoder<Data> {
        void close(Data data);

        Data decode(String str);

        Class<Data> getDataClass();
    }

    public static final class StreamFactory<Model> implements ModelLoaderFactory<Model, InputStream> {

        /* renamed from: a */
        private final DataDecoder<InputStream> f6011a = new C1274a(this);

        /* renamed from: com.bumptech.glide.load.model.DataUrlLoader$StreamFactory$a */
        class C1274a implements DataDecoder<InputStream> {
            C1274a(StreamFactory streamFactory) {
            }

            /* renamed from: a */
            public void close(InputStream inputStream) {
                inputStream.close();
            }

            /* renamed from: b */
            public InputStream decode(String str) {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf == -1) {
                        throw new IllegalArgumentException("Missing comma in data URL.");
                    } else if (str.substring(0, indexOf).endsWith(";base64")) {
                        return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                    } else {
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                } else {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
            }

            public Class<InputStream> getDataClass() {
                return InputStream.class;
            }
        }

        @NonNull
        public ModelLoader<Model, InputStream> build(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DataUrlLoader(this.f6011a);
        }

        public void teardown() {
        }
    }

    /* renamed from: com.bumptech.glide.load.model.DataUrlLoader$a */
    private static final class C1275a<Data> implements DataFetcher<Data> {

        /* renamed from: a */
        private final String f6012a;

        /* renamed from: b */
        private final DataDecoder<Data> f6013b;

        /* renamed from: c */
        private Data f6014c;

        C1275a(String str, DataDecoder<Data> dataDecoder) {
            this.f6012a = str;
            this.f6013b = dataDecoder;
        }

        public void cancel() {
        }

        public void cleanup() {
            try {
                this.f6013b.close(this.f6014c);
            } catch (IOException unused) {
            }
        }

        @NonNull
        public Class<Data> getDataClass() {
            return this.f6013b.getDataClass();
        }

        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Data> dataCallback) {
            try {
                Data decode = this.f6013b.decode(this.f6012a);
                this.f6014c = decode;
                dataCallback.onDataReady(decode);
            } catch (IllegalArgumentException e) {
                dataCallback.onLoadFailed(e);
            }
        }
    }

    public DataUrlLoader(DataDecoder<Data> dataDecoder) {
        this.f6010a = dataDecoder;
    }

    public ModelLoader.LoadData<Data> buildLoadData(@NonNull Model model, int i, int i2, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(model), new C1275a(model.toString(), this.f6010a));
    }

    public boolean handles(@NonNull Model model) {
        return model.toString().startsWith("data:image");
    }
}
