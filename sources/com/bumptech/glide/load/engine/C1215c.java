package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

/* renamed from: com.bumptech.glide.load.engine.c */
/* compiled from: DataCacheGenerator */
class C1215c implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {

    /* renamed from: a */
    private final List<Key> f5755a;

    /* renamed from: b */
    private final C1237f<?> f5756b;

    /* renamed from: c */
    private final DataFetcherGenerator.FetcherReadyCallback f5757c;

    /* renamed from: d */
    private int f5758d;

    /* renamed from: e */
    private Key f5759e;

    /* renamed from: f */
    private List<ModelLoader<File, ?>> f5760f;

    /* renamed from: g */
    private int f5761g;

    /* renamed from: h */
    private volatile ModelLoader.LoadData<?> f5762h;

    /* renamed from: i */
    private File f5763i;

    C1215c(C1237f<?> fVar, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this(fVar.mo9615c(), fVar, fetcherReadyCallback);
    }

    /* renamed from: b */
    private boolean m4310b() {
        return this.f5761g < this.f5760f.size();
    }

    /* renamed from: a */
    public boolean mo9435a() {
        while (true) {
            boolean z = false;
            if (this.f5760f == null || !m4310b()) {
                int i = this.f5758d + 1;
                this.f5758d = i;
                if (i >= this.f5755a.size()) {
                    return false;
                }
                Key key = this.f5755a.get(this.f5758d);
                File file = this.f5756b.mo9616d().get(new C1228d(key, this.f5756b.mo9627o()));
                this.f5763i = file;
                if (file != null) {
                    this.f5759e = key;
                    this.f5760f = this.f5756b.mo9622j(file);
                    this.f5761g = 0;
                }
            } else {
                this.f5762h = null;
                while (!z && m4310b()) {
                    List<ModelLoader<File, ?>> list = this.f5760f;
                    int i2 = this.f5761g;
                    this.f5761g = i2 + 1;
                    this.f5762h = list.get(i2).buildLoadData(this.f5763i, this.f5756b.mo9631s(), this.f5756b.mo9618f(), this.f5756b.mo9623k());
                    if (this.f5762h != null && this.f5756b.mo9632t(this.f5762h.fetcher.getDataClass())) {
                        this.f5762h.fetcher.loadData(this.f5756b.mo9624l(), this);
                        z = true;
                    }
                }
                return z;
            }
        }
    }

    public void cancel() {
        ModelLoader.LoadData<?> loadData = this.f5762h;
        if (loadData != null) {
            loadData.fetcher.cancel();
        }
    }

    public void onDataReady(Object obj) {
        this.f5757c.onDataFetcherReady(this.f5759e, obj, this.f5762h.fetcher, DataSource.DATA_DISK_CACHE, this.f5759e);
    }

    public void onLoadFailed(@NonNull Exception exc) {
        this.f5757c.onDataFetcherFailed(this.f5759e, exc, this.f5762h.fetcher, DataSource.DATA_DISK_CACHE);
    }

    C1215c(List<Key> list, C1237f<?> fVar, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.f5758d = -1;
        this.f5755a = list;
        this.f5756b = fVar;
        this.f5757c = fetcherReadyCallback;
    }
}
