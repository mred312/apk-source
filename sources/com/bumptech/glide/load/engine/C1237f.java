package com.bumptech.glide.load.engine;

import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.C1238g;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.UnitTransformation;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.engine.f */
/* compiled from: DecodeHelper */
final class C1237f<Transcode> {

    /* renamed from: a */
    private final List<ModelLoader.LoadData<?>> f5820a = new ArrayList();

    /* renamed from: b */
    private final List<Key> f5821b = new ArrayList();

    /* renamed from: c */
    private GlideContext f5822c;

    /* renamed from: d */
    private Object f5823d;

    /* renamed from: e */
    private int f5824e;

    /* renamed from: f */
    private int f5825f;

    /* renamed from: g */
    private Class<?> f5826g;

    /* renamed from: h */
    private C1238g.C1243e f5827h;

    /* renamed from: i */
    private Options f5828i;

    /* renamed from: j */
    private Map<Class<?>, Transformation<?>> f5829j;

    /* renamed from: k */
    private Class<Transcode> f5830k;

    /* renamed from: l */
    private boolean f5831l;

    /* renamed from: m */
    private boolean f5832m;

    /* renamed from: n */
    private Key f5833n;

    /* renamed from: o */
    private Priority f5834o;

    /* renamed from: p */
    private DiskCacheStrategy f5835p;

    /* renamed from: q */
    private boolean f5836q;

    /* renamed from: r */
    private boolean f5837r;

    C1237f() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9613a() {
        this.f5822c = null;
        this.f5823d = null;
        this.f5833n = null;
        this.f5826g = null;
        this.f5830k = null;
        this.f5828i = null;
        this.f5834o = null;
        this.f5829j = null;
        this.f5835p = null;
        this.f5820a.clear();
        this.f5831l = false;
        this.f5821b.clear();
        this.f5832m = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ArrayPool mo9614b() {
        return this.f5822c.getArrayPool();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public List<Key> mo9615c() {
        if (!this.f5832m) {
            this.f5832m = true;
            this.f5821b.clear();
            List<ModelLoader.LoadData<?>> g = mo9619g();
            int size = g.size();
            for (int i = 0; i < size; i++) {
                ModelLoader.LoadData loadData = g.get(i);
                if (!this.f5821b.contains(loadData.sourceKey)) {
                    this.f5821b.add(loadData.sourceKey);
                }
                for (int i2 = 0; i2 < loadData.alternateKeys.size(); i2++) {
                    if (!this.f5821b.contains(loadData.alternateKeys.get(i2))) {
                        this.f5821b.add(loadData.alternateKeys.get(i2));
                    }
                }
            }
        }
        return this.f5821b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public DiskCache mo9616d() {
        return this.f5827h.mo9462a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public DiskCacheStrategy mo9617e() {
        return this.f5835p;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo9618f() {
        return this.f5825f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public List<ModelLoader.LoadData<?>> mo9619g() {
        if (!this.f5831l) {
            this.f5831l = true;
            this.f5820a.clear();
            List modelLoaders = this.f5822c.getRegistry().getModelLoaders(this.f5823d);
            int size = modelLoaders.size();
            for (int i = 0; i < size; i++) {
                ModelLoader.LoadData buildLoadData = ((ModelLoader) modelLoaders.get(i)).buildLoadData(this.f5823d, this.f5824e, this.f5825f, this.f5828i);
                if (buildLoadData != null) {
                    this.f5820a.add(buildLoadData);
                }
            }
        }
        return this.f5820a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public <Data> LoadPath<Data, ?, Transcode> mo9620h(Class<Data> cls) {
        return this.f5822c.getRegistry().getLoadPath(cls, this.f5826g, this.f5830k);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public Class<?> mo9621i() {
        return this.f5823d.getClass();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public List<ModelLoader<File, ?>> mo9622j(File file) {
        return this.f5822c.getRegistry().getModelLoaders(file);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public Options mo9623k() {
        return this.f5828i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public Priority mo9624l() {
        return this.f5834o;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public List<Class<?>> mo9625m() {
        return this.f5822c.getRegistry().getRegisteredResourceClasses(this.f5823d.getClass(), this.f5826g, this.f5830k);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public <Z> ResourceEncoder<Z> mo9626n(Resource<Z> resource) {
        return this.f5822c.getRegistry().getResultEncoder(resource);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public Key mo9627o() {
        return this.f5833n;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public <X> Encoder<X> mo9628p(X x) {
        return this.f5822c.getRegistry().getSourceEncoder(x);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public Class<?> mo9629q() {
        return this.f5830k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public <Z> Transformation<Z> mo9630r(Class<Z> cls) {
        Transformation<Z> transformation = this.f5829j.get(cls);
        if (transformation == null) {
            Iterator<Map.Entry<Class<?>, Transformation<?>>> it = this.f5829j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    transformation = (Transformation) next.getValue();
                    break;
                }
            }
        }
        if (transformation != null) {
            return transformation;
        }
        if (!this.f5829j.isEmpty() || !this.f5836q) {
            return UnitTransformation.get();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public int mo9631s() {
        return this.f5824e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public boolean mo9632t(Class<?> cls) {
        return mo9620h(cls) != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public <R> void mo9633u(GlideContext glideContext, Object obj, Key key, int i, int i2, DiskCacheStrategy diskCacheStrategy, Class<?> cls, Class<R> cls2, Priority priority, Options options, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, C1238g.C1243e eVar) {
        this.f5822c = glideContext;
        this.f5823d = obj;
        this.f5833n = key;
        this.f5824e = i;
        this.f5825f = i2;
        this.f5835p = diskCacheStrategy;
        this.f5826g = cls;
        this.f5827h = eVar;
        this.f5830k = cls2;
        this.f5834o = priority;
        this.f5828i = options;
        this.f5829j = map;
        this.f5836q = z;
        this.f5837r = z2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public boolean mo9634v(Resource<?> resource) {
        return this.f5822c.getRegistry().isResourceEncoderAvailable(resource);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public boolean mo9635w() {
        return this.f5837r;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public boolean mo9636x(Key key) {
        List<ModelLoader.LoadData<?>> g = mo9619g();
        int size = g.size();
        for (int i = 0; i < size; i++) {
            if (g.get(i).sourceKey.equals(key)) {
                return true;
            }
        }
        return false;
    }
}
