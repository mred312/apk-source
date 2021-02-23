package com.bumptech.glide.load.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;

public final class MediaStoreFileLoader implements ModelLoader<Uri, File> {

    /* renamed from: a */
    private final Context f6035a;

    public static final class Factory implements ModelLoaderFactory<Uri, File> {

        /* renamed from: a */
        private final Context f6036a;

        public Factory(Context context) {
            this.f6036a = context;
        }

        @NonNull
        public ModelLoader<Uri, File> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreFileLoader(this.f6036a);
        }

        public void teardown() {
        }
    }

    /* renamed from: com.bumptech.glide.load.model.MediaStoreFileLoader$a */
    private static class C1281a implements DataFetcher<File> {

        /* renamed from: c */
        private static final String[] f6037c = {"_data"};

        /* renamed from: a */
        private final Context f6038a;

        /* renamed from: b */
        private final Uri f6039b;

        C1281a(Context context, Uri uri) {
            this.f6038a = context;
            this.f6039b = uri;
        }

        public void cancel() {
        }

        public void cleanup() {
        }

        @NonNull
        public Class<File> getDataClass() {
            return File.class;
        }

        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super File> dataCallback) {
            Cursor query = this.f6038a.getContentResolver().query(this.f6039b, f6037c, (String) null, (String[]) null, (String) null);
            String str = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(str)) {
                dataCallback.onLoadFailed(new FileNotFoundException("Failed to find file path for: " + this.f6039b));
                return;
            }
            dataCallback.onDataReady(new File(str));
        }
    }

    public MediaStoreFileLoader(Context context) {
        this.f6035a = context;
    }

    public ModelLoader.LoadData<File> buildLoadData(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(uri), new C1281a(this.f6035a, uri));
    }

    public boolean handles(@NonNull Uri uri) {
        return MediaStoreUtil.isMediaStoreUri(uri);
    }
}
