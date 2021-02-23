package com.bumptech.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.p003os.BuildCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class GlideBuilder {

    /* renamed from: a */
    private final Map<Class<?>, TransitionOptions<?, ?>> f5418a = new ArrayMap();

    /* renamed from: b */
    private Engine f5419b;

    /* renamed from: c */
    private BitmapPool f5420c;

    /* renamed from: d */
    private ArrayPool f5421d;

    /* renamed from: e */
    private MemoryCache f5422e;

    /* renamed from: f */
    private GlideExecutor f5423f;

    /* renamed from: g */
    private GlideExecutor f5424g;

    /* renamed from: h */
    private DiskCache.Factory f5425h;

    /* renamed from: i */
    private MemorySizeCalculator f5426i;

    /* renamed from: j */
    private ConnectivityMonitorFactory f5427j;

    /* renamed from: k */
    private int f5428k = 4;

    /* renamed from: l */
    private Glide.RequestOptionsFactory f5429l = new C1151a(this);
    @Nullable

    /* renamed from: m */
    private RequestManagerRetriever.RequestManagerFactory f5430m;

    /* renamed from: n */
    private GlideExecutor f5431n;

    /* renamed from: o */
    private boolean f5432o;
    @Nullable

    /* renamed from: p */
    private List<RequestListener<Object>> f5433p;

    /* renamed from: q */
    private boolean f5434q;

    /* renamed from: r */
    private boolean f5435r;

    /* renamed from: s */
    private int f5436s = HardwareConfigState.DEFAULT_MAXIMUM_FDS_FOR_HARDWARE_CONFIGS;

    /* renamed from: t */
    private int f5437t = 128;

    /* renamed from: com.bumptech.glide.GlideBuilder$a */
    class C1151a implements Glide.RequestOptionsFactory {
        C1151a(GlideBuilder glideBuilder) {
        }

        @NonNull
        public RequestOptions build() {
            return new RequestOptions();
        }
    }

    /* renamed from: com.bumptech.glide.GlideBuilder$b */
    class C1152b implements Glide.RequestOptionsFactory {

        /* renamed from: a */
        final /* synthetic */ RequestOptions f5438a;

        C1152b(GlideBuilder glideBuilder, RequestOptions requestOptions) {
            this.f5438a = requestOptions;
        }

        @NonNull
        public RequestOptions build() {
            RequestOptions requestOptions = this.f5438a;
            return requestOptions != null ? requestOptions : new RequestOptions();
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: a */
    public Glide mo9145a(@NonNull Context context) {
        Context context2 = context;
        if (this.f5423f == null) {
            this.f5423f = GlideExecutor.newSourceExecutor();
        }
        if (this.f5424g == null) {
            this.f5424g = GlideExecutor.newDiskCacheExecutor();
        }
        if (this.f5431n == null) {
            this.f5431n = GlideExecutor.newAnimationExecutor();
        }
        if (this.f5426i == null) {
            this.f5426i = new MemorySizeCalculator.Builder(context2).build();
        }
        if (this.f5427j == null) {
            this.f5427j = new DefaultConnectivityMonitorFactory();
        }
        if (this.f5420c == null) {
            int bitmapPoolSize = this.f5426i.getBitmapPoolSize();
            if (bitmapPoolSize > 0) {
                this.f5420c = new LruBitmapPool((long) bitmapPoolSize);
            } else {
                this.f5420c = new BitmapPoolAdapter();
            }
        }
        if (this.f5421d == null) {
            this.f5421d = new LruArrayPool(this.f5426i.getArrayPoolSizeInBytes());
        }
        if (this.f5422e == null) {
            this.f5422e = new LruResourceCache((long) this.f5426i.getMemoryCacheSize());
        }
        if (this.f5425h == null) {
            this.f5425h = new InternalCacheDiskCacheFactory(context2);
        }
        if (this.f5419b == null) {
            this.f5419b = new Engine(this.f5422e, this.f5425h, this.f5424g, this.f5423f, GlideExecutor.newUnlimitedSourceExecutor(), this.f5431n, this.f5432o);
        }
        List<RequestListener<Object>> list = this.f5433p;
        if (list == null) {
            this.f5433p = Collections.emptyList();
        } else {
            this.f5433p = Collections.unmodifiableList(list);
        }
        return new Glide(context, this.f5419b, this.f5422e, this.f5420c, this.f5421d, new RequestManagerRetriever(this.f5430m), this.f5427j, this.f5428k, this.f5429l, this.f5418a, this.f5433p, this.f5434q, this.f5435r, this.f5436s, this.f5437t);
    }

    @NonNull
    public GlideBuilder addGlobalRequestListener(@NonNull RequestListener<Object> requestListener) {
        if (this.f5433p == null) {
            this.f5433p = new ArrayList();
        }
        this.f5433p.add(requestListener);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo9147b(@Nullable RequestManagerRetriever.RequestManagerFactory requestManagerFactory) {
        this.f5430m = requestManagerFactory;
    }

    @NonNull
    public GlideBuilder setAnimationExecutor(@Nullable GlideExecutor glideExecutor) {
        this.f5431n = glideExecutor;
        return this;
    }

    @NonNull
    public GlideBuilder setArrayPool(@Nullable ArrayPool arrayPool) {
        this.f5421d = arrayPool;
        return this;
    }

    @NonNull
    public GlideBuilder setBitmapPool(@Nullable BitmapPool bitmapPool) {
        this.f5420c = bitmapPool;
        return this;
    }

    @NonNull
    public GlideBuilder setConnectivityMonitorFactory(@Nullable ConnectivityMonitorFactory connectivityMonitorFactory) {
        this.f5427j = connectivityMonitorFactory;
        return this;
    }

    @NonNull
    public GlideBuilder setDefaultRequestOptions(@Nullable RequestOptions requestOptions) {
        return setDefaultRequestOptions((Glide.RequestOptionsFactory) new C1152b(this, requestOptions));
    }

    @NonNull
    public <T> GlideBuilder setDefaultTransitionOptions(@NonNull Class<T> cls, @Nullable TransitionOptions<?, T> transitionOptions) {
        this.f5418a.put(cls, transitionOptions);
        return this;
    }

    @NonNull
    public GlideBuilder setDiskCache(@Nullable DiskCache.Factory factory) {
        this.f5425h = factory;
        return this;
    }

    @NonNull
    public GlideBuilder setDiskCacheExecutor(@Nullable GlideExecutor glideExecutor) {
        this.f5424g = glideExecutor;
        return this;
    }

    public GlideBuilder setImageDecoderEnabledForBitmaps(boolean z) {
        if (!BuildCompat.isAtLeastQ()) {
            return this;
        }
        this.f5435r = z;
        return this;
    }

    @NonNull
    public GlideBuilder setIsActiveResourceRetentionAllowed(boolean z) {
        this.f5432o = z;
        return this;
    }

    @NonNull
    public GlideBuilder setLogLevel(int i) {
        if (i < 2 || i > 6) {
            throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
        }
        this.f5428k = i;
        return this;
    }

    public GlideBuilder setLogRequestOrigins(boolean z) {
        this.f5434q = z;
        return this;
    }

    @NonNull
    public GlideBuilder setMemoryCache(@Nullable MemoryCache memoryCache) {
        this.f5422e = memoryCache;
        return this;
    }

    @NonNull
    public GlideBuilder setMemorySizeCalculator(@NonNull MemorySizeCalculator.Builder builder) {
        return setMemorySizeCalculator(builder.build());
    }

    @Deprecated
    public GlideBuilder setResizeExecutor(@Nullable GlideExecutor glideExecutor) {
        return setSourceExecutor(glideExecutor);
    }

    @NonNull
    public GlideBuilder setSourceExecutor(@Nullable GlideExecutor glideExecutor) {
        this.f5423f = glideExecutor;
        return this;
    }

    @NonNull
    public GlideBuilder setDefaultRequestOptions(@NonNull Glide.RequestOptionsFactory requestOptionsFactory) {
        this.f5429l = (Glide.RequestOptionsFactory) Preconditions.checkNotNull(requestOptionsFactory);
        return this;
    }

    @NonNull
    public GlideBuilder setMemorySizeCalculator(@Nullable MemorySizeCalculator memorySizeCalculator) {
        this.f5426i = memorySizeCalculator;
        return this;
    }
}
