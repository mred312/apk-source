package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.IOException;

public abstract class AssetPathFetcher<T> implements DataFetcher<T> {

    /* renamed from: a */
    private final String f5613a;

    /* renamed from: b */
    private final AssetManager f5614b;

    /* renamed from: c */
    private T f5615c;

    public AssetPathFetcher(AssetManager assetManager, String str) {
        this.f5614b = assetManager;
        this.f5613a = str;
    }

    public void cancel() {
    }

    public void cleanup() {
        T t = this.f5615c;
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

    public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T loadResource = loadResource(this.f5614b, this.f5613a);
            this.f5615c = loadResource;
            dataCallback.onDataReady(loadResource);
        } catch (IOException e) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e);
            }
            dataCallback.onLoadFailed(e);
        }
    }

    /* access modifiers changed from: protected */
    public abstract T loadResource(AssetManager assetManager, String str);
}
