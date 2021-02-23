package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.engine.g */
/* compiled from: DecodeJob */
class C1238g<R> implements DataFetcherGenerator.FetcherReadyCallback, Runnable, Comparable<C1238g<?>>, FactoryPools.Poolable {

    /* renamed from: A */
    private DataSource f5838A;

    /* renamed from: B */
    private DataFetcher<?> f5839B;

    /* renamed from: C */
    private volatile DataFetcherGenerator f5840C;

    /* renamed from: D */
    private volatile boolean f5841D;

    /* renamed from: E */
    private volatile boolean f5842E;

    /* renamed from: a */
    private final C1237f<R> f5843a = new C1237f<>();

    /* renamed from: b */
    private final List<Throwable> f5844b = new ArrayList();

    /* renamed from: c */
    private final StateVerifier f5845c = StateVerifier.newInstance();

    /* renamed from: d */
    private final C1243e f5846d;

    /* renamed from: e */
    private final Pools.Pool<C1238g<?>> f5847e;

    /* renamed from: f */
    private final C1242d<?> f5848f = new C1242d<>();

    /* renamed from: g */
    private final C1244f f5849g = new C1244f();

    /* renamed from: h */
    private GlideContext f5850h;

    /* renamed from: i */
    private Key f5851i;

    /* renamed from: j */
    private Priority f5852j;

    /* renamed from: k */
    private C1254j f5853k;

    /* renamed from: l */
    private int f5854l;

    /* renamed from: m */
    private int f5855m;

    /* renamed from: n */
    private DiskCacheStrategy f5856n;

    /* renamed from: o */
    private Options f5857o;

    /* renamed from: p */
    private C1240b<R> f5858p;

    /* renamed from: q */
    private int f5859q;

    /* renamed from: r */
    private C1246h f5860r;

    /* renamed from: s */
    private C1245g f5861s;

    /* renamed from: t */
    private long f5862t;

    /* renamed from: u */
    private boolean f5863u;

    /* renamed from: v */
    private Object f5864v;

    /* renamed from: w */
    private Thread f5865w;

    /* renamed from: x */
    private Key f5866x;

    /* renamed from: y */
    private Key f5867y;

    /* renamed from: z */
    private Object f5868z;

    /* renamed from: com.bumptech.glide.load.engine.g$a */
    /* compiled from: DecodeJob */
    static /* synthetic */ class C1239a {

        /* renamed from: a */
        static final /* synthetic */ int[] f5869a;

        /* renamed from: b */
        static final /* synthetic */ int[] f5870b;

        /* renamed from: c */
        static final /* synthetic */ int[] f5871c;

        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|18|19|20|21|23|24|25|26|27|28|30) */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x006a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0074 */
        static {
            /*
                com.bumptech.glide.load.EncodeStrategy[] r0 = com.bumptech.glide.load.EncodeStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5871c = r0
                r1 = 1
                com.bumptech.glide.load.EncodeStrategy r2 = com.bumptech.glide.load.EncodeStrategy.SOURCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f5871c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bumptech.glide.load.EncodeStrategy r3 = com.bumptech.glide.load.EncodeStrategy.TRANSFORMED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.bumptech.glide.load.engine.g$h[] r2 = com.bumptech.glide.load.engine.C1238g.C1246h.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f5870b = r2
                com.bumptech.glide.load.engine.g$h r3 = com.bumptech.glide.load.engine.C1238g.C1246h.RESOURCE_CACHE     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r2 = f5870b     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.bumptech.glide.load.engine.g$h r3 = com.bumptech.glide.load.engine.C1238g.C1246h.DATA_CACHE     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                r2 = 3
                int[] r3 = f5870b     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.bumptech.glide.load.engine.g$h r4 = com.bumptech.glide.load.engine.C1238g.C1246h.SOURCE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r3 = f5870b     // Catch:{ NoSuchFieldError -> 0x004e }
                com.bumptech.glide.load.engine.g$h r4 = com.bumptech.glide.load.engine.C1238g.C1246h.FINISHED     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r3 = f5870b     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.bumptech.glide.load.engine.g$h r4 = com.bumptech.glide.load.engine.C1238g.C1246h.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                com.bumptech.glide.load.engine.g$g[] r3 = com.bumptech.glide.load.engine.C1238g.C1245g.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f5869a = r3
                com.bumptech.glide.load.engine.g$g r4 = com.bumptech.glide.load.engine.C1238g.C1245g.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x006a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x006a }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x006a }
            L_0x006a:
                int[] r1 = f5869a     // Catch:{ NoSuchFieldError -> 0x0074 }
                com.bumptech.glide.load.engine.g$g r3 = com.bumptech.glide.load.engine.C1238g.C1245g.SWITCH_TO_SOURCE_SERVICE     // Catch:{ NoSuchFieldError -> 0x0074 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0074 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0074 }
            L_0x0074:
                int[] r0 = f5869a     // Catch:{ NoSuchFieldError -> 0x007e }
                com.bumptech.glide.load.engine.g$g r1 = com.bumptech.glide.load.engine.C1238g.C1245g.DECODE_DATA     // Catch:{ NoSuchFieldError -> 0x007e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.C1238g.C1239a.<clinit>():void");
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.g$b */
    /* compiled from: DecodeJob */
    interface C1240b<R> {
        /* renamed from: a */
        void mo9645a(C1238g<?> gVar);

        void onLoadFailed(GlideException glideException);

        void onResourceReady(Resource<R> resource, DataSource dataSource);
    }

    /* renamed from: com.bumptech.glide.load.engine.g$c */
    /* compiled from: DecodeJob */
    private final class C1241c<Z> implements DecodePath.C1180a<Z> {

        /* renamed from: a */
        private final DataSource f5872a;

        C1241c(DataSource dataSource) {
            this.f5872a = dataSource;
        }

        @NonNull
        /* renamed from: a */
        public Resource<Z> mo9442a(@NonNull Resource<Z> resource) {
            return C1238g.this.mo9641r(this.f5872a, resource);
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.g$d */
    /* compiled from: DecodeJob */
    private static class C1242d<Z> {

        /* renamed from: a */
        private Key f5874a;

        /* renamed from: b */
        private ResourceEncoder<Z> f5875b;

        /* renamed from: c */
        private C1259n<Z> f5876c;

        C1242d() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo9648a() {
            this.f5874a = null;
            this.f5875b = null;
            this.f5876c = null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo9649b(C1243e eVar, Options options) {
            GlideTrace.beginSection("DecodeJob.encode");
            try {
                eVar.mo9462a().put(this.f5874a, new C1229e(this.f5875b, this.f5876c, options));
            } finally {
                this.f5876c.mo9691d();
                GlideTrace.endSection();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public boolean mo9650c() {
            return this.f5876c != null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public <X> void mo9651d(Key key, ResourceEncoder<X> resourceEncoder, C1259n<X> nVar) {
            this.f5874a = key;
            this.f5875b = resourceEncoder;
            this.f5876c = nVar;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.g$e */
    /* compiled from: DecodeJob */
    interface C1243e {
        /* renamed from: a */
        DiskCache mo9462a();
    }

    /* renamed from: com.bumptech.glide.load.engine.g$f */
    /* compiled from: DecodeJob */
    private static class C1244f {

        /* renamed from: a */
        private boolean f5877a;

        /* renamed from: b */
        private boolean f5878b;

        /* renamed from: c */
        private boolean f5879c;

        C1244f() {
        }

        /* renamed from: a */
        private boolean m4386a(boolean z) {
            return (this.f5879c || z || this.f5878b) && this.f5877a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public synchronized boolean mo9652b() {
            this.f5878b = true;
            return m4386a(false);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public synchronized boolean mo9653c() {
            this.f5879c = true;
            return m4386a(false);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public synchronized boolean mo9654d(boolean z) {
            this.f5877a = true;
            return m4386a(z);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public synchronized void mo9655e() {
            this.f5878b = false;
            this.f5877a = false;
            this.f5879c = false;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.g$g */
    /* compiled from: DecodeJob */
    private enum C1245g {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* renamed from: com.bumptech.glide.load.engine.g$h */
    /* compiled from: DecodeJob */
    private enum C1246h {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    C1238g(C1243e eVar, Pools.Pool<C1238g<?>> pool) {
        this.f5846d = eVar;
        this.f5847e = pool;
    }

    /* renamed from: c */
    private <Data> Resource<R> m4354c(DataFetcher<?> dataFetcher, Data data, DataSource dataSource) {
        if (data == null) {
            dataFetcher.cleanup();
            return null;
        }
        try {
            long logTime = LogTime.getLogTime();
            Resource<R> d = m4355d(data, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                m4361k("Decoded result " + d, logTime);
            }
            return d;
        } finally {
            dataFetcher.cleanup();
        }
    }

    /* renamed from: d */
    private <Data> Resource<R> m4355d(Data data, DataSource dataSource) {
        return m4370v(data, dataSource, this.f5843a.mo9620h(data.getClass()));
    }

    /* renamed from: e */
    private void m4356e() {
        if (Log.isLoggable("DecodeJob", 2)) {
            long j = this.f5862t;
            m4362l("Retrieved data", j, "data: " + this.f5868z + ", cache key: " + this.f5866x + ", fetcher: " + this.f5839B);
        }
        Resource<R> resource = null;
        try {
            resource = m4354c(this.f5839B, this.f5868z, this.f5838A);
        } catch (GlideException e) {
            e.mo9464f(this.f5867y, this.f5838A);
            this.f5844b.add(e);
        }
        if (resource != null) {
            m4364n(resource, this.f5838A);
        } else {
            m4369u();
        }
    }

    /* renamed from: f */
    private DataFetcherGenerator m4357f() {
        int i = C1239a.f5870b[this.f5860r.ordinal()];
        if (i == 1) {
            return new C1261o(this.f5843a, this);
        }
        if (i == 2) {
            return new C1215c(this.f5843a, this);
        }
        if (i == 3) {
            return new C1269r(this.f5843a, this);
        }
        if (i == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.f5860r);
    }

    /* renamed from: g */
    private C1246h m4358g(C1246h hVar) {
        int i = C1239a.f5870b[hVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return this.f5863u ? C1246h.FINISHED : C1246h.SOURCE;
            }
            if (i == 3 || i == 4) {
                return C1246h.FINISHED;
            }
            if (i != 5) {
                throw new IllegalArgumentException("Unrecognized stage: " + hVar);
            } else if (this.f5856n.decodeCachedResource()) {
                return C1246h.RESOURCE_CACHE;
            } else {
                return m4358g(C1246h.RESOURCE_CACHE);
            }
        } else if (this.f5856n.decodeCachedData()) {
            return C1246h.DATA_CACHE;
        } else {
            return m4358g(C1246h.DATA_CACHE);
        }
    }

    @NonNull
    /* renamed from: h */
    private Options m4359h(DataSource dataSource) {
        Options options = this.f5857o;
        if (Build.VERSION.SDK_INT < 26) {
            return options;
        }
        boolean z = dataSource == DataSource.RESOURCE_DISK_CACHE || this.f5843a.mo9635w();
        Option option = Downsampler.ALLOW_HARDWARE_CONFIG;
        Boolean bool = (Boolean) options.get(option);
        if (bool != null && (!bool.booleanValue() || z)) {
            return options;
        }
        Options options2 = new Options();
        options2.putAll(this.f5857o);
        options2.set(option, Boolean.valueOf(z));
        return options2;
    }

    /* renamed from: i */
    private int m4360i() {
        return this.f5852j.ordinal();
    }

    /* renamed from: k */
    private void m4361k(String str, long j) {
        m4362l(str, j, (String) null);
    }

    /* renamed from: l */
    private void m4362l(String str, long j, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(LogTime.getElapsedMillis(j));
        sb.append(", load key: ");
        sb.append(this.f5853k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    /* renamed from: m */
    private void m4363m(Resource<R> resource, DataSource dataSource) {
        m4372x();
        this.f5858p.onResourceReady(resource, dataSource);
    }

    /* renamed from: n */
    private void m4364n(Resource<R> resource, DataSource dataSource) {
        if (resource instanceof Initializable) {
            ((Initializable) resource).initialize();
        }
        C1259n<R> nVar = null;
        C1259n<R> nVar2 = resource;
        if (this.f5848f.mo9650c()) {
            C1259n<R> b = C1259n.m4423b(resource);
            nVar = b;
            nVar2 = b;
        }
        m4363m(nVar2, dataSource);
        this.f5860r = C1246h.ENCODE;
        try {
            if (this.f5848f.mo9650c()) {
                this.f5848f.mo9649b(this.f5846d, this.f5857o);
            }
            m4366p();
        } finally {
            if (nVar != null) {
                nVar.mo9691d();
            }
        }
    }

    /* renamed from: o */
    private void m4365o() {
        m4372x();
        this.f5858p.onLoadFailed(new GlideException("Failed to load resource", (List<Throwable>) new ArrayList(this.f5844b)));
        m4367q();
    }

    /* renamed from: p */
    private void m4366p() {
        if (this.f5849g.mo9652b()) {
            m4368t();
        }
    }

    /* renamed from: q */
    private void m4367q() {
        if (this.f5849g.mo9653c()) {
            m4368t();
        }
    }

    /* renamed from: t */
    private void m4368t() {
        this.f5849g.mo9655e();
        this.f5848f.mo9648a();
        this.f5843a.mo9613a();
        this.f5841D = false;
        this.f5850h = null;
        this.f5851i = null;
        this.f5857o = null;
        this.f5852j = null;
        this.f5853k = null;
        this.f5858p = null;
        this.f5860r = null;
        this.f5840C = null;
        this.f5865w = null;
        this.f5866x = null;
        this.f5868z = null;
        this.f5838A = null;
        this.f5839B = null;
        this.f5862t = 0;
        this.f5842E = false;
        this.f5864v = null;
        this.f5844b.clear();
        this.f5847e.release(this);
    }

    /* renamed from: u */
    private void m4369u() {
        this.f5865w = Thread.currentThread();
        this.f5862t = LogTime.getLogTime();
        boolean z = false;
        while (!this.f5842E && this.f5840C != null && !(z = this.f5840C.mo9435a())) {
            this.f5860r = m4358g(this.f5860r);
            this.f5840C = m4357f();
            if (this.f5860r == C1246h.SOURCE) {
                reschedule();
                return;
            }
        }
        if ((this.f5860r == C1246h.FINISHED || this.f5842E) && !z) {
            m4365o();
        }
    }

    /* renamed from: v */
    private <Data, ResourceType> Resource<R> m4370v(Data data, DataSource dataSource, LoadPath<Data, ResourceType, R> loadPath) {
        Options h = m4359h(dataSource);
        DataRewinder rewinder = this.f5850h.getRegistry().getRewinder(data);
        try {
            return loadPath.load(rewinder, h, this.f5854l, this.f5855m, new C1241c(dataSource));
        } finally {
            rewinder.cleanup();
        }
    }

    /* renamed from: w */
    private void m4371w() {
        int i = C1239a.f5869a[this.f5861s.ordinal()];
        if (i == 1) {
            this.f5860r = m4358g(C1246h.INITIALIZE);
            this.f5840C = m4357f();
            m4369u();
        } else if (i == 2) {
            m4369u();
        } else if (i == 3) {
            m4356e();
        } else {
            throw new IllegalStateException("Unrecognized run reason: " + this.f5861s);
        }
    }

    /* renamed from: x */
    private void m4372x() {
        Throwable th;
        this.f5845c.throwIfRecycled();
        if (this.f5841D) {
            if (this.f5844b.isEmpty()) {
                th = null;
            } else {
                List<Throwable> list = this.f5844b;
                th = list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.f5841D = true;
    }

    /* renamed from: a */
    public void mo9637a() {
        this.f5842E = true;
        DataFetcherGenerator dataFetcherGenerator = this.f5840C;
        if (dataFetcherGenerator != null) {
            dataFetcherGenerator.cancel();
        }
    }

    /* renamed from: b */
    public int compareTo(@NonNull C1238g<?> gVar) {
        int i = m4360i() - gVar.m4360i();
        return i == 0 ? this.f5859q - gVar.f5859q : i;
    }

    @NonNull
    public StateVerifier getVerifier() {
        return this.f5845c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public C1238g<R> mo9640j(GlideContext glideContext, Object obj, C1254j jVar, Key key, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, boolean z3, Options options, C1240b<R> bVar, int i3) {
        this.f5843a.mo9633u(glideContext, obj, key, i, i2, diskCacheStrategy, cls, cls2, priority, options, map, z, z2, this.f5846d);
        this.f5850h = glideContext;
        this.f5851i = key;
        this.f5852j = priority;
        this.f5853k = jVar;
        this.f5854l = i;
        this.f5855m = i2;
        this.f5856n = diskCacheStrategy;
        this.f5863u = z3;
        this.f5857o = options;
        this.f5858p = bVar;
        this.f5859q = i3;
        this.f5861s = C1245g.INITIALIZE;
        this.f5864v = obj;
        return this;
    }

    public void onDataFetcherFailed(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        dataFetcher.cleanup();
        GlideException glideException = new GlideException("Fetching data failed", (Throwable) exc);
        glideException.mo9466g(key, dataSource, dataFetcher.getDataClass());
        this.f5844b.add(glideException);
        if (Thread.currentThread() != this.f5865w) {
            this.f5861s = C1245g.SWITCH_TO_SOURCE_SERVICE;
            this.f5858p.mo9645a(this);
            return;
        }
        m4369u();
    }

    public void onDataFetcherReady(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.f5866x = key;
        this.f5868z = obj;
        this.f5839B = dataFetcher;
        this.f5838A = dataSource;
        this.f5867y = key2;
        if (Thread.currentThread() != this.f5865w) {
            this.f5861s = C1245g.DECODE_DATA;
            this.f5858p.mo9645a(this);
            return;
        }
        GlideTrace.beginSection("DecodeJob.decodeFromRetrievedData");
        try {
            m4356e();
        } finally {
            GlideTrace.endSection();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: com.bumptech.glide.load.engine.d} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: com.bumptech.glide.load.engine.p} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.bumptech.glide.load.engine.p} */
    /* JADX WARNING: type inference failed for: r12v5, types: [com.bumptech.glide.load.Key] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.NonNull
    /* renamed from: r */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Z> com.bumptech.glide.load.engine.Resource<Z> mo9641r(com.bumptech.glide.load.DataSource r12, @androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<Z> r13) {
        /*
            r11 = this;
            java.lang.Object r0 = r13.get()
            java.lang.Class r8 = r0.getClass()
            com.bumptech.glide.load.DataSource r0 = com.bumptech.glide.load.DataSource.RESOURCE_DISK_CACHE
            r1 = 0
            if (r12 == r0) goto L_0x0020
            com.bumptech.glide.load.engine.f<R> r0 = r11.f5843a
            com.bumptech.glide.load.Transformation r0 = r0.mo9630r(r8)
            com.bumptech.glide.GlideContext r2 = r11.f5850h
            int r3 = r11.f5854l
            int r4 = r11.f5855m
            com.bumptech.glide.load.engine.Resource r2 = r0.transform(r2, r13, r3, r4)
            r7 = r0
            r0 = r2
            goto L_0x0022
        L_0x0020:
            r0 = r13
            r7 = r1
        L_0x0022:
            boolean r2 = r13.equals(r0)
            if (r2 != 0) goto L_0x002b
            r13.recycle()
        L_0x002b:
            com.bumptech.glide.load.engine.f<R> r13 = r11.f5843a
            boolean r13 = r13.mo9634v(r0)
            if (r13 == 0) goto L_0x0040
            com.bumptech.glide.load.engine.f<R> r13 = r11.f5843a
            com.bumptech.glide.load.ResourceEncoder r1 = r13.mo9626n(r0)
            com.bumptech.glide.load.Options r13 = r11.f5857o
            com.bumptech.glide.load.EncodeStrategy r13 = r1.getEncodeStrategy(r13)
            goto L_0x0042
        L_0x0040:
            com.bumptech.glide.load.EncodeStrategy r13 = com.bumptech.glide.load.EncodeStrategy.NONE
        L_0x0042:
            r10 = r1
            com.bumptech.glide.load.engine.f<R> r1 = r11.f5843a
            com.bumptech.glide.load.Key r2 = r11.f5866x
            boolean r1 = r1.mo9636x(r2)
            r2 = 1
            r1 = r1 ^ r2
            com.bumptech.glide.load.engine.DiskCacheStrategy r3 = r11.f5856n
            boolean r12 = r3.isResourceCacheable(r1, r12, r13)
            if (r12 == 0) goto L_0x00b3
            if (r10 == 0) goto L_0x00a5
            int[] r12 = com.bumptech.glide.load.engine.C1238g.C1239a.f5871c
            int r1 = r13.ordinal()
            r12 = r12[r1]
            if (r12 == r2) goto L_0x0092
            r1 = 2
            if (r12 != r1) goto L_0x007b
            com.bumptech.glide.load.engine.p r12 = new com.bumptech.glide.load.engine.p
            com.bumptech.glide.load.engine.f<R> r13 = r11.f5843a
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r2 = r13.mo9614b()
            com.bumptech.glide.load.Key r3 = r11.f5866x
            com.bumptech.glide.load.Key r4 = r11.f5851i
            int r5 = r11.f5854l
            int r6 = r11.f5855m
            com.bumptech.glide.load.Options r9 = r11.f5857o
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x009b
        L_0x007b:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown strategy: "
            r0.append(r1)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            r12.<init>(r13)
            throw r12
        L_0x0092:
            com.bumptech.glide.load.engine.d r12 = new com.bumptech.glide.load.engine.d
            com.bumptech.glide.load.Key r13 = r11.f5866x
            com.bumptech.glide.load.Key r1 = r11.f5851i
            r12.<init>(r13, r1)
        L_0x009b:
            com.bumptech.glide.load.engine.n r0 = com.bumptech.glide.load.engine.C1259n.m4423b(r0)
            com.bumptech.glide.load.engine.g$d<?> r13 = r11.f5848f
            r13.mo9651d(r12, r10, r0)
            goto L_0x00b3
        L_0x00a5:
            com.bumptech.glide.Registry$NoResultEncoderAvailableException r12 = new com.bumptech.glide.Registry$NoResultEncoderAvailableException
            java.lang.Object r13 = r0.get()
            java.lang.Class r13 = r13.getClass()
            r12.<init>(r13)
            throw r12
        L_0x00b3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.C1238g.mo9641r(com.bumptech.glide.load.DataSource, com.bumptech.glide.load.engine.Resource):com.bumptech.glide.load.engine.Resource");
    }

    public void reschedule() {
        this.f5861s = C1245g.SWITCH_TO_SOURCE_SERVICE;
        this.f5858p.mo9645a(this);
    }

    public void run() {
        GlideTrace.beginSectionFormat("DecodeJob#run(model=%s)", this.f5864v);
        DataFetcher<?> dataFetcher = this.f5839B;
        try {
            if (this.f5842E) {
                m4365o();
                if (dataFetcher != null) {
                    dataFetcher.cleanup();
                }
                GlideTrace.endSection();
                return;
            }
            m4371w();
            if (dataFetcher != null) {
                dataFetcher.cleanup();
            }
            GlideTrace.endSection();
        } catch (C1198b e) {
            throw e;
        } catch (Throwable th) {
            if (dataFetcher != null) {
                dataFetcher.cleanup();
            }
            GlideTrace.endSection();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public void mo9643s(boolean z) {
        if (this.f5849g.mo9654d(z)) {
            m4368t();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: y */
    public boolean mo9644y() {
        C1246h g = m4358g(C1246h.INITIALIZE);
        return g == C1246h.RESOURCE_CACHE || g == C1246h.DATA_CACHE;
    }
}
