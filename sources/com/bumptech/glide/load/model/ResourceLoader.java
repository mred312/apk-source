package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;

public class ResourceLoader<Data> implements ModelLoader<Integer, Data> {

    /* renamed from: a */
    private final ModelLoader<Uri, Data> f6058a;

    /* renamed from: b */
    private final Resources f6059b;

    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Integer, AssetFileDescriptor> {

        /* renamed from: a */
        private final Resources f6060a;

        public AssetFileDescriptorFactory(Resources resources) {
            this.f6060a = resources;
        }

        public ModelLoader<Integer, AssetFileDescriptor> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f6060a, multiModelLoaderFactory.build(Uri.class, AssetFileDescriptor.class));
        }

        public void teardown() {
        }
    }

    public static class FileDescriptorFactory implements ModelLoaderFactory<Integer, ParcelFileDescriptor> {

        /* renamed from: a */
        private final Resources f6061a;

        public FileDescriptorFactory(Resources resources) {
            this.f6061a = resources;
        }

        @NonNull
        public ModelLoader<Integer, ParcelFileDescriptor> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f6061a, multiModelLoaderFactory.build(Uri.class, ParcelFileDescriptor.class));
        }

        public void teardown() {
        }
    }

    public static class StreamFactory implements ModelLoaderFactory<Integer, InputStream> {

        /* renamed from: a */
        private final Resources f6062a;

        public StreamFactory(Resources resources) {
            this.f6062a = resources;
        }

        @NonNull
        public ModelLoader<Integer, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f6062a, multiModelLoaderFactory.build(Uri.class, InputStream.class));
        }

        public void teardown() {
        }
    }

    public static class UriFactory implements ModelLoaderFactory<Integer, Uri> {

        /* renamed from: a */
        private final Resources f6063a;

        public UriFactory(Resources resources) {
            this.f6063a = resources;
        }

        @NonNull
        public ModelLoader<Integer, Uri> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f6063a, UnitModelLoader.getInstance());
        }

        public void teardown() {
        }
    }

    public ResourceLoader(Resources resources, ModelLoader<Uri, Data> modelLoader) {
        this.f6059b = resources;
        this.f6058a = modelLoader;
    }

    @Nullable
    /* renamed from: a */
    private Uri m4490a(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f6059b.getResourcePackageName(num.intValue()) + '/' + this.f6059b.getResourceTypeName(num.intValue()) + '/' + this.f6059b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            Log.w("ResourceLoader", "Received invalid resource id: " + num, e);
            return null;
        }
    }

    public boolean handles(@NonNull Integer num) {
        return true;
    }

    public ModelLoader.LoadData<Data> buildLoadData(@NonNull Integer num, int i, int i2, @NonNull Options options) {
        Uri a = m4490a(num);
        if (a == null) {
            return null;
        }
        return this.f6058a.buildLoadData(a, i, i2, options);
    }
}
