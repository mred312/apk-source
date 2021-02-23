package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class LocalUriFetcher<T> implements DataFetcher<T> {

    /* renamed from: a */
    private final Uri f5637a;

    /* renamed from: b */
    private final ContentResolver f5638b;

    /* renamed from: c */
    private T f5639c;

    public LocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        this.f5638b = contentResolver;
        this.f5637a = uri;
    }

    public void cancel() {
    }

    public void cleanup() {
        T t = this.f5639c;
        if (t != null) {
            try {
                close(t);
            } catch (IOException unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void close(T t);

    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    public final void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T loadResource = loadResource(this.f5637a, this.f5638b);
            this.f5639c = loadResource;
            dataCallback.onDataReady(loadResource);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e);
            }
            dataCallback.onLoadFailed(e);
        }
    }

    /* access modifiers changed from: protected */
    public abstract T loadResource(Uri uri, ContentResolver contentResolver);
}
