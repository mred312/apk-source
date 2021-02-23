package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileLoader<Data> implements ModelLoader<File, Data> {

    /* renamed from: a */
    private final FileOpener<Data> f6015a;

    public static class Factory<Data> implements ModelLoaderFactory<File, Data> {

        /* renamed from: a */
        private final FileOpener<Data> f6016a;

        public Factory(FileOpener<Data> fileOpener) {
            this.f6016a = fileOpener;
        }

        @NonNull
        public final ModelLoader<File, Data> build(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new FileLoader(this.f6016a);
        }

        public final void teardown() {
        }
    }

    public static class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {

        /* renamed from: com.bumptech.glide.load.model.FileLoader$FileDescriptorFactory$a */
        class C1276a implements FileOpener<ParcelFileDescriptor> {
            C1276a() {
            }

            /* renamed from: a */
            public void close(ParcelFileDescriptor parcelFileDescriptor) {
                parcelFileDescriptor.close();
            }

            /* renamed from: b */
            public ParcelFileDescriptor open(File file) {
                return ParcelFileDescriptor.open(file, 268435456);
            }

            public Class<ParcelFileDescriptor> getDataClass() {
                return ParcelFileDescriptor.class;
            }
        }

        public FileDescriptorFactory() {
            super(new C1276a());
        }
    }

    public interface FileOpener<Data> {
        void close(Data data);

        Class<Data> getDataClass();

        Data open(File file);
    }

    public static class StreamFactory extends Factory<InputStream> {

        /* renamed from: com.bumptech.glide.load.model.FileLoader$StreamFactory$a */
        class C1277a implements FileOpener<InputStream> {
            C1277a() {
            }

            /* renamed from: a */
            public void close(InputStream inputStream) {
                inputStream.close();
            }

            /* renamed from: b */
            public InputStream open(File file) {
                return new FileInputStream(file);
            }

            public Class<InputStream> getDataClass() {
                return InputStream.class;
            }
        }

        public StreamFactory() {
            super(new C1277a());
        }
    }

    /* renamed from: com.bumptech.glide.load.model.FileLoader$a */
    private static final class C1278a<Data> implements DataFetcher<Data> {

        /* renamed from: a */
        private final File f6017a;

        /* renamed from: b */
        private final FileOpener<Data> f6018b;

        /* renamed from: c */
        private Data f6019c;

        C1278a(File file, FileOpener<Data> fileOpener) {
            this.f6017a = file;
            this.f6018b = fileOpener;
        }

        public void cancel() {
        }

        public void cleanup() {
            Data data = this.f6019c;
            if (data != null) {
                try {
                    this.f6018b.close(data);
                } catch (IOException unused) {
                }
            }
        }

        @NonNull
        public Class<Data> getDataClass() {
            return this.f6018b.getDataClass();
        }

        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Data> dataCallback) {
            try {
                Data open = this.f6018b.open(this.f6017a);
                this.f6019c = open;
                dataCallback.onDataReady(open);
            } catch (FileNotFoundException e) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e);
                }
                dataCallback.onLoadFailed(e);
            }
        }
    }

    public FileLoader(FileOpener<Data> fileOpener) {
        this.f6015a = fileOpener;
    }

    public boolean handles(@NonNull File file) {
        return true;
    }

    public ModelLoader.LoadData<Data> buildLoadData(@NonNull File file, int i, int i2, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(file), new C1278a(file, this.f6015a));
    }
}
