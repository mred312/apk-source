package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteArrayLoader<Data> implements ModelLoader<byte[], Data> {

    /* renamed from: a */
    private final Converter<Data> f6006a;

    public static class ByteBufferFactory implements ModelLoaderFactory<byte[], ByteBuffer> {

        /* renamed from: com.bumptech.glide.load.model.ByteArrayLoader$ByteBufferFactory$a */
        class C1270a implements Converter<ByteBuffer> {
            C1270a(ByteBufferFactory byteBufferFactory) {
            }

            /* renamed from: a */
            public ByteBuffer convert(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }

            public Class<ByteBuffer> getDataClass() {
                return ByteBuffer.class;
            }
        }

        @NonNull
        public ModelLoader<byte[], ByteBuffer> build(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new C1270a(this));
        }

        public void teardown() {
        }
    }

    public interface Converter<Data> {
        Data convert(byte[] bArr);

        Class<Data> getDataClass();
    }

    public static class StreamFactory implements ModelLoaderFactory<byte[], InputStream> {

        /* renamed from: com.bumptech.glide.load.model.ByteArrayLoader$StreamFactory$a */
        class C1271a implements Converter<InputStream> {
            C1271a(StreamFactory streamFactory) {
            }

            /* renamed from: a */
            public InputStream convert(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }

            public Class<InputStream> getDataClass() {
                return InputStream.class;
            }
        }

        @NonNull
        public ModelLoader<byte[], InputStream> build(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new C1271a(this));
        }

        public void teardown() {
        }
    }

    /* renamed from: com.bumptech.glide.load.model.ByteArrayLoader$a */
    private static class C1272a<Data> implements DataFetcher<Data> {

        /* renamed from: a */
        private final byte[] f6007a;

        /* renamed from: b */
        private final Converter<Data> f6008b;

        C1272a(byte[] bArr, Converter<Data> converter) {
            this.f6007a = bArr;
            this.f6008b = converter;
        }

        public void cancel() {
        }

        public void cleanup() {
        }

        @NonNull
        public Class<Data> getDataClass() {
            return this.f6008b.getDataClass();
        }

        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Data> dataCallback) {
            dataCallback.onDataReady(this.f6008b.convert(this.f6007a));
        }
    }

    public ByteArrayLoader(Converter<Data> converter) {
        this.f6006a = converter;
    }

    public boolean handles(@NonNull byte[] bArr) {
        return true;
    }

    public ModelLoader.LoadData<Data> buildLoadData(@NonNull byte[] bArr, int i, int i2, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(bArr), new C1272a(bArr, this.f6006a));
    }
}
