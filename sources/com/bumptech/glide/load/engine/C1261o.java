package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

/* renamed from: com.bumptech.glide.load.engine.o */
/* compiled from: ResourceCacheGenerator */
class C1261o implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {

    /* renamed from: a */
    private final DataFetcherGenerator.FetcherReadyCallback f5946a;

    /* renamed from: b */
    private final C1237f<?> f5947b;

    /* renamed from: c */
    private int f5948c;

    /* renamed from: d */
    private int f5949d = -1;

    /* renamed from: e */
    private Key f5950e;

    /* renamed from: f */
    private List<ModelLoader<File, ?>> f5951f;

    /* renamed from: g */
    private int f5952g;

    /* renamed from: h */
    private volatile ModelLoader.LoadData<?> f5953h;

    /* renamed from: i */
    private File f5954i;

    /* renamed from: j */
    private C1262p f5955j;

    C1261o(C1237f<?> fVar, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.f5947b = fVar;
        this.f5946a = fetcherReadyCallback;
    }

    /* renamed from: b */
    private boolean m4427b() {
        return this.f5952g < this.f5951f.size();
    }

    /* renamed from: a */
    public boolean mo9435a() {
        List<Key> c = this.f5947b.mo9615c();
        boolean z = false;
        if (c.isEmpty()) {
            return false;
        }
        List<Class<?>> m = this.f5947b.mo9625m();
        if (!m.isEmpty()) {
            while (true) {
                if (this.f5951f == null || !m4427b()) {
                    int i = this.f5949d + 1;
                    this.f5949d = i;
                    if (i >= m.size()) {
                        int i2 = this.f5948c + 1;
                        this.f5948c = i2;
                        if (i2 >= c.size()) {
                            return false;
                        }
                        this.f5949d = 0;
                    }
                    Key key = c.get(this.f5948c);
                    Class cls = m.get(this.f5949d);
                    Key key2 = key;
                    this.f5955j = new C1262p(this.f5947b.mo9614b(), key2, this.f5947b.mo9627o(), this.f5947b.mo9631s(), this.f5947b.mo9618f(), this.f5947b.mo9630r(cls), cls, this.f5947b.mo9623k());
                    File file = this.f5947b.mo9616d().get(this.f5955j);
                    this.f5954i = file;
                    if (file != null) {
                        this.f5950e = key;
                        this.f5951f = this.f5947b.mo9622j(file);
                        this.f5952g = 0;
                    }
                } else {
                    this.f5953h = null;
                    while (!z && m4427b()) {
                        List<ModelLoader<File, ?>> list = this.f5951f;
                        int i3 = this.f5952g;
                        this.f5952g = i3 + 1;
                        this.f5953h = list.get(i3).buildLoadData(this.f5954i, this.f5947b.mo9631s(), this.f5947b.mo9618f(), this.f5947b.mo9623k());
                        if (this.f5953h != null && this.f5947b.mo9632t(this.f5953h.fetcher.getDataClass())) {
                            this.f5953h.fetcher.loadData(this.f5947b.mo9624l(), this);
                            z = true;
                        }
                    }
                    return z;
                }
            }
        } else if (File.class.equals(this.f5947b.mo9629q())) {
            return false;
        } else {
            throw new IllegalStateException("Failed to find any load path from " + this.f5947b.mo9621i() + " to " + this.f5947b.mo9629q());
        }
    }

    public void cancel() {
        ModelLoader.LoadData<?> loadData = this.f5953h;
        if (loadData != null) {
            loadData.fetcher.cancel();
        }
    }

    public void onDataReady(Object obj) {
        this.f5946a.onDataFetcherReady(this.f5950e, obj, this.f5953h.fetcher, DataSource.RESOURCE_DISK_CACHE, this.f5955j);
    }

    public void onLoadFailed(@NonNull Exception exc) {
        this.f5946a.onDataFetcherFailed(this.f5955j, exc, this.f5953h.fetcher, DataSource.RESOURCE_DISK_CACHE);
    }
}
