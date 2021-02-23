package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.C1238g;
import com.bumptech.glide.load.engine.C1256l;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.Map;
import java.util.concurrent.Executor;

public class Engine implements C1253i, MemoryCache.ResourceRemovedListener, C1256l.C1257a {

    /* renamed from: i */
    private static final boolean f5659i = Log.isLoggable("Engine", 2);

    /* renamed from: a */
    private final C1258m f5660a;

    /* renamed from: b */
    private final C1255k f5661b;

    /* renamed from: c */
    private final MemoryCache f5662c;

    /* renamed from: d */
    private final C1188b f5663d;

    /* renamed from: e */
    private final C1267q f5664e;

    /* renamed from: f */
    private final C1190c f5665f;

    /* renamed from: g */
    private final C1186a f5666g;

    /* renamed from: h */
    private final C1192a f5667h;

    public class LoadStatus {

        /* renamed from: a */
        private final C1247h<?> f5668a;

        /* renamed from: b */
        private final ResourceCallback f5669b;

        LoadStatus(ResourceCallback resourceCallback, C1247h<?> hVar) {
            this.f5669b = resourceCallback;
            this.f5668a = hVar;
        }

        public void cancel() {
            synchronized (Engine.this) {
                this.f5668a.mo9666o(this.f5669b);
            }
        }
    }

    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.Engine$a */
    static class C1186a {

        /* renamed from: a */
        final C1238g.C1243e f5671a;

        /* renamed from: b */
        final Pools.Pool<C1238g<?>> f5672b = FactoryPools.threadSafe(150, new C1187a());

        /* renamed from: c */
        private int f5673c;

        /* renamed from: com.bumptech.glide.load.engine.Engine$a$a */
        class C1187a implements FactoryPools.Factory<C1238g<?>> {
            C1187a() {
            }

            /* renamed from: a */
            public C1238g<?> create() {
                C1186a aVar = C1186a.this;
                return new C1238g<>(aVar.f5671a, aVar.f5672b);
            }
        }

        C1186a(C1238g.C1243e eVar) {
            this.f5671a = eVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public <R> C1238g<R> mo9456a(GlideContext glideContext, Object obj, C1254j jVar, Key key, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, boolean z3, Options options, C1238g.C1240b<R> bVar) {
            C1238g<R> gVar = (C1238g) Preconditions.checkNotNull(this.f5672b.acquire());
            int i3 = this.f5673c;
            int i4 = i3;
            this.f5673c = i3 + 1;
            gVar.mo9640j(glideContext, obj, jVar, key, i, i2, cls, cls2, priority, diskCacheStrategy, map, z, z2, z3, options, bVar, i4);
            return gVar;
        }
    }

    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.Engine$b */
    static class C1188b {

        /* renamed from: a */
        final GlideExecutor f5675a;

        /* renamed from: b */
        final GlideExecutor f5676b;

        /* renamed from: c */
        final GlideExecutor f5677c;

        /* renamed from: d */
        final GlideExecutor f5678d;

        /* renamed from: e */
        final C1253i f5679e;

        /* renamed from: f */
        final C1256l.C1257a f5680f;

        /* renamed from: g */
        final Pools.Pool<C1247h<?>> f5681g = FactoryPools.threadSafe(150, new C1189a());

        /* renamed from: com.bumptech.glide.load.engine.Engine$b$a */
        class C1189a implements FactoryPools.Factory<C1247h<?>> {
            C1189a() {
            }

            /* renamed from: a */
            public C1247h<?> create() {
                C1188b bVar = C1188b.this;
                return new C1247h(bVar.f5675a, bVar.f5676b, bVar.f5677c, bVar.f5678d, bVar.f5679e, bVar.f5680f, bVar.f5681g);
            }
        }

        C1188b(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, C1253i iVar, C1256l.C1257a aVar) {
            this.f5675a = glideExecutor;
            this.f5676b = glideExecutor2;
            this.f5677c = glideExecutor3;
            this.f5678d = glideExecutor4;
            this.f5679e = iVar;
            this.f5680f = aVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public <R> C1247h<R> mo9459a(Key key, boolean z, boolean z2, boolean z3, boolean z4) {
            C1247h<R> hVar = (C1247h) Preconditions.checkNotNull(this.f5681g.acquire());
            hVar.mo9662i(key, z, z2, z3, z4);
            return hVar;
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        /* renamed from: b */
        public void mo9460b() {
            Executors.shutdownAndAwaitTermination(this.f5675a);
            Executors.shutdownAndAwaitTermination(this.f5676b);
            Executors.shutdownAndAwaitTermination(this.f5677c);
            Executors.shutdownAndAwaitTermination(this.f5678d);
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.Engine$c */
    private static class C1190c implements C1238g.C1243e {

        /* renamed from: a */
        private final DiskCache.Factory f5683a;

        /* renamed from: b */
        private volatile DiskCache f5684b;

        C1190c(DiskCache.Factory factory) {
            this.f5683a = factory;
        }

        /* renamed from: a */
        public DiskCache mo9462a() {
            if (this.f5684b == null) {
                synchronized (this) {
                    if (this.f5684b == null) {
                        this.f5684b = this.f5683a.build();
                    }
                    if (this.f5684b == null) {
                        this.f5684b = new DiskCacheAdapter();
                    }
                }
            }
            return this.f5684b;
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        /* renamed from: b */
        public synchronized void mo9463b() {
            if (this.f5684b != null) {
                this.f5684b.clear();
            }
        }
    }

    public Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, boolean z) {
        this(memoryCache, factory, glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, (C1258m) null, (C1255k) null, (C1192a) null, (C1188b) null, (C1186a) null, (C1267q) null, z);
    }

    /* renamed from: a */
    private C1256l<?> m4217a(Key key) {
        Resource<?> remove = this.f5662c.remove(key);
        if (remove == null) {
            return null;
        }
        if (remove instanceof C1256l) {
            return (C1256l) remove;
        }
        return new C1256l<>(remove, true, true, key, this);
    }

    @Nullable
    /* renamed from: b */
    private C1256l<?> m4218b(Key key) {
        C1256l<?> e = this.f5667h.mo9491e(key);
        if (e != null) {
            e.mo9683a();
        }
        return e;
    }

    /* renamed from: c */
    private C1256l<?> m4219c(Key key) {
        C1256l<?> a = m4217a(key);
        if (a != null) {
            a.mo9683a();
            this.f5667h.mo9487a(key, a);
        }
        return a;
    }

    @Nullable
    /* renamed from: d */
    private C1256l<?> m4220d(C1254j jVar, boolean z, long j) {
        if (!z) {
            return null;
        }
        C1256l<?> b = m4218b(jVar);
        if (b != null) {
            if (f5659i) {
                m4221e("Loaded resource from active resources", j, jVar);
            }
            return b;
        }
        C1256l<?> c = m4219c(jVar);
        if (c == null) {
            return null;
        }
        if (f5659i) {
            m4221e("Loaded resource from cache", j, jVar);
        }
        return c;
    }

    /* renamed from: e */
    private static void m4221e(String str, long j, Key key) {
        Log.v("Engine", str + " in " + LogTime.getElapsedMillis(j) + "ms, key: " + key);
    }

    /* renamed from: f */
    private <R> LoadStatus m4222f(GlideContext glideContext, Object obj, Key key, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, Options options, boolean z3, boolean z4, boolean z5, boolean z6, ResourceCallback resourceCallback, Executor executor, C1254j jVar, long j) {
        ResourceCallback resourceCallback2 = resourceCallback;
        Executor executor2 = executor;
        C1254j jVar2 = jVar;
        long j2 = j;
        C1247h<?> a = this.f5660a.mo9688a(jVar2, z6);
        if (a != null) {
            a.mo9656b(resourceCallback2, executor2);
            if (f5659i) {
                m4221e("Added to existing load", j2, jVar2);
            }
            return new LoadStatus(resourceCallback2, a);
        }
        C1247h a2 = this.f5663d.mo9459a(jVar, z3, z4, z5, z6);
        C1247h hVar = a2;
        C1254j jVar3 = jVar2;
        C1238g<R> a3 = this.f5666g.mo9456a(glideContext, obj, jVar, key, i, i2, cls, cls2, priority, diskCacheStrategy, map, z, z2, z6, options, a2);
        this.f5660a.mo9689c(jVar3, hVar);
        C1247h hVar2 = hVar;
        C1254j jVar4 = jVar3;
        ResourceCallback resourceCallback3 = resourceCallback;
        hVar2.mo9656b(resourceCallback3, executor);
        hVar2.mo9667p(a3);
        if (f5659i) {
            m4221e("Started new load", j, jVar4);
        }
        return new LoadStatus(resourceCallback3, hVar2);
    }

    public void clearDiskCache() {
        this.f5665f.mo9462a().clear();
    }

    public <R> LoadStatus load(GlideContext glideContext, Object obj, Key key, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, Options options, boolean z3, boolean z4, boolean z5, boolean z6, ResourceCallback resourceCallback, Executor executor) {
        long logTime = f5659i ? LogTime.getLogTime() : 0;
        C1254j a = this.f5661b.mo9682a(obj, key, i, i2, map, cls, cls2, options);
        synchronized (this) {
            C1256l<?> d = m4220d(a, z3, logTime);
            if (d == null) {
                LoadStatus f = m4222f(glideContext, obj, key, i, i2, cls, cls2, priority, diskCacheStrategy, map, z, z2, options, z3, z4, z5, z6, resourceCallback, executor, a, logTime);
                return f;
            }
            resourceCallback.onResourceReady(d, DataSource.MEMORY_CACHE);
            return null;
        }
    }

    public synchronized void onEngineJobCancelled(C1247h<?> hVar, Key key) {
        this.f5660a.mo9690d(key, hVar);
    }

    public synchronized void onEngineJobComplete(C1247h<?> hVar, Key key, C1256l<?> lVar) {
        if (lVar != null) {
            if (lVar.mo9685c()) {
                this.f5667h.mo9487a(key, lVar);
            }
        }
        this.f5660a.mo9690d(key, hVar);
    }

    public void onResourceReleased(Key key, C1256l<?> lVar) {
        this.f5667h.mo9490d(key);
        if (lVar.mo9685c()) {
            this.f5662c.put(key, lVar);
        } else {
            this.f5664e.mo9713a(lVar);
        }
    }

    public void onResourceRemoved(@NonNull Resource<?> resource) {
        this.f5664e.mo9713a(resource);
    }

    public void release(Resource<?> resource) {
        if (resource instanceof C1256l) {
            ((C1256l) resource).mo9686d();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    @VisibleForTesting
    public void shutdown() {
        this.f5663d.mo9460b();
        this.f5665f.mo9463b();
        this.f5667h.mo9493g();
    }

    @VisibleForTesting
    Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, C1258m mVar, C1255k kVar, C1192a aVar, C1188b bVar, C1186a aVar2, C1267q qVar, boolean z) {
        this.f5662c = memoryCache;
        DiskCache.Factory factory2 = factory;
        C1190c cVar = new C1190c(factory);
        this.f5665f = cVar;
        C1192a aVar3 = aVar == null ? new C1192a(z) : aVar;
        this.f5667h = aVar3;
        aVar3.mo9492f(this);
        this.f5661b = kVar == null ? new C1255k() : kVar;
        this.f5660a = mVar == null ? new C1258m() : mVar;
        this.f5663d = bVar == null ? new C1188b(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, this, this) : bVar;
        this.f5666g = aVar2 == null ? new C1186a(cVar) : aVar2;
        this.f5664e = qVar == null ? new C1267q() : qVar;
        memoryCache.setResourceRemovedListener(this);
    }
}
