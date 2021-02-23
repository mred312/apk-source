package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.LogTime;
import java.util.Collections;
import java.util.List;

/* renamed from: com.bumptech.glide.load.engine.r */
/* compiled from: SourceGenerator */
class C1269r implements DataFetcherGenerator, DataFetcher.DataCallback<Object>, DataFetcherGenerator.FetcherReadyCallback {

    /* renamed from: a */
    private final C1237f<?> f5994a;

    /* renamed from: b */
    private final DataFetcherGenerator.FetcherReadyCallback f5995b;

    /* renamed from: c */
    private int f5996c;

    /* renamed from: d */
    private C1215c f5997d;

    /* renamed from: e */
    private Object f5998e;

    /* renamed from: f */
    private volatile ModelLoader.LoadData<?> f5999f;

    /* renamed from: g */
    private C1228d f6000g;

    C1269r(C1237f<?> fVar, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.f5994a = fVar;
        this.f5995b = fetcherReadyCallback;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: b */
    private void m4447b(Object obj) {
        long logTime = LogTime.getLogTime();
        try {
            Encoder<X> p = this.f5994a.mo9628p(obj);
            C1229e eVar = new C1229e(p, obj, this.f5994a.mo9623k());
            this.f6000g = new C1228d(this.f5999f.sourceKey, this.f5994a.mo9627o());
            this.f5994a.mo9616d().put(this.f6000g, eVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.f6000g + ", data: " + obj + ", encoder: " + p + ", duration: " + LogTime.getElapsedMillis(logTime));
            }
            this.f5999f.fetcher.cleanup();
            this.f5997d = new C1215c(Collections.singletonList(this.f5999f.sourceKey), this.f5994a, this);
        } catch (Throwable th) {
            this.f5999f.fetcher.cleanup();
            throw th;
        }
    }

    /* renamed from: c */
    private boolean m4448c() {
        return this.f5996c < this.f5994a.mo9619g().size();
    }

    /* renamed from: a */
    public boolean mo9435a() {
        Object obj = this.f5998e;
        if (obj != null) {
            this.f5998e = null;
            m4447b(obj);
        }
        C1215c cVar = this.f5997d;
        if (cVar != null && cVar.mo9435a()) {
            return true;
        }
        this.f5997d = null;
        this.f5999f = null;
        boolean z = false;
        while (!z && m4448c()) {
            List<ModelLoader.LoadData<?>> g = this.f5994a.mo9619g();
            int i = this.f5996c;
            this.f5996c = i + 1;
            this.f5999f = g.get(i);
            if (this.f5999f != null && (this.f5994a.mo9617e().isDataCacheable(this.f5999f.fetcher.getDataSource()) || this.f5994a.mo9632t(this.f5999f.fetcher.getDataClass()))) {
                this.f5999f.fetcher.loadData(this.f5994a.mo9624l(), this);
                z = true;
            }
        }
        return z;
    }

    public void cancel() {
        ModelLoader.LoadData<?> loadData = this.f5999f;
        if (loadData != null) {
            loadData.fetcher.cancel();
        }
    }

    public void onDataFetcherFailed(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        this.f5995b.onDataFetcherFailed(key, exc, dataFetcher, this.f5999f.fetcher.getDataSource());
    }

    public void onDataFetcherReady(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.f5995b.onDataFetcherReady(key, obj, dataFetcher, this.f5999f.fetcher.getDataSource(), key);
    }

    public void onDataReady(Object obj) {
        DiskCacheStrategy e = this.f5994a.mo9617e();
        if (obj == null || !e.isDataCacheable(this.f5999f.fetcher.getDataSource())) {
            this.f5995b.onDataFetcherReady(this.f5999f.sourceKey, obj, this.f5999f.fetcher, this.f5999f.fetcher.getDataSource(), this.f6000g);
            return;
        }
        this.f5998e = obj;
        this.f5995b.reschedule();
    }

    public void onLoadFailed(@NonNull Exception exc) {
        this.f5995b.onDataFetcherFailed(this.f6000g, exc, this.f5999f.fetcher, this.f5999f.fetcher.getDataSource());
    }

    public void reschedule() {
        throw new UnsupportedOperationException();
    }
}
