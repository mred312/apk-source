package okhttp3.internal.cache;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.p009io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class DiskLruCache implements Closeable, Flushable {

    /* renamed from: u */
    static final Pattern f20042u = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: a */
    final FileSystem f20043a;

    /* renamed from: b */
    final File f20044b;

    /* renamed from: c */
    private final File f20045c;

    /* renamed from: d */
    private final File f20046d;

    /* renamed from: e */
    private final File f20047e;

    /* renamed from: f */
    private final int f20048f;

    /* renamed from: g */
    private long f20049g;

    /* renamed from: h */
    final int f20050h;

    /* renamed from: i */
    private long f20051i = 0;

    /* renamed from: j */
    BufferedSink f20052j;

    /* renamed from: k */
    final LinkedHashMap<String, C3550d> f20053k = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: l */
    int f20054l;

    /* renamed from: m */
    boolean f20055m;

    /* renamed from: n */
    boolean f20056n;

    /* renamed from: o */
    boolean f20057o;

    /* renamed from: p */
    boolean f20058p;

    /* renamed from: q */
    boolean f20059q;

    /* renamed from: r */
    private long f20060r = 0;

    /* renamed from: s */
    private final Executor f20061s;

    /* renamed from: t */
    private final Runnable f20062t = new C3547a();

    public final class Snapshot implements Closeable {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final String f20063a;

        /* renamed from: b */
        private final long f20064b;

        /* renamed from: c */
        private final Source[] f20065c;

        /* renamed from: d */
        private final long[] f20066d;

        Snapshot(String str, long j, Source[] sourceArr, long[] jArr) {
            this.f20063a = str;
            this.f20064b = j;
            this.f20065c = sourceArr;
            this.f20066d = jArr;
        }

        public void close() {
            for (Source closeQuietly : this.f20065c) {
                Util.closeQuietly((Closeable) closeQuietly);
            }
        }

        @Nullable
        public Editor edit() {
            return DiskLruCache.this.mo22286c(this.f20063a, this.f20064b);
        }

        public long getLength(int i) {
            return this.f20066d[i];
        }

        public Source getSource(int i) {
            return this.f20065c[i];
        }

        public String key() {
            return this.f20063a;
        }
    }

    public final class Editor {

        /* renamed from: a */
        final C3550d f20068a;

        /* renamed from: b */
        final boolean[] f20069b;

        /* renamed from: c */
        private boolean f20070c;

        /* renamed from: okhttp3.internal.cache.DiskLruCache$Editor$a */
        class C3546a extends C3926a {
            C3546a(Sink sink) {
                super(sink);
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo22316a(IOException iOException) {
                synchronized (DiskLruCache.this) {
                    Editor.this.mo22310a();
                }
            }
        }

        Editor(C3550d dVar) {
            this.f20068a = dVar;
            this.f20069b = dVar.f20083e ? null : new boolean[DiskLruCache.this.f20050h];
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo22310a() {
            if (this.f20068a.f20084f == this) {
                int i = 0;
                while (true) {
                    DiskLruCache diskLruCache = DiskLruCache.this;
                    if (i < diskLruCache.f20050h) {
                        try {
                            diskLruCache.f20043a.delete(this.f20068a.f20082d[i]);
                        } catch (IOException unused) {
                        }
                        i++;
                    } else {
                        this.f20068a.f20084f = null;
                        return;
                    }
                }
            }
        }

        public void abort() {
            synchronized (DiskLruCache.this) {
                if (!this.f20070c) {
                    if (this.f20068a.f20084f == this) {
                        DiskLruCache.this.mo22285b(this, false);
                    }
                    this.f20070c = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(2:7|8)|9|10) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0013 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void abortUnlessCommitted() {
            /*
                r3 = this;
                okhttp3.internal.cache.DiskLruCache r0 = okhttp3.internal.cache.DiskLruCache.this
                monitor-enter(r0)
                boolean r1 = r3.f20070c     // Catch:{ all -> 0x0015 }
                if (r1 != 0) goto L_0x0013
                okhttp3.internal.cache.DiskLruCache$d r1 = r3.f20068a     // Catch:{ all -> 0x0015 }
                okhttp3.internal.cache.DiskLruCache$Editor r1 = r1.f20084f     // Catch:{ all -> 0x0015 }
                if (r1 != r3) goto L_0x0013
                okhttp3.internal.cache.DiskLruCache r1 = okhttp3.internal.cache.DiskLruCache.this     // Catch:{ IOException -> 0x0013 }
                r2 = 0
                r1.mo22285b(r3, r2)     // Catch:{ IOException -> 0x0013 }
            L_0x0013:
                monitor-exit(r0)     // Catch:{ all -> 0x0015 }
                return
            L_0x0015:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0015 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.Editor.abortUnlessCommitted():void");
        }

        public void commit() {
            synchronized (DiskLruCache.this) {
                if (!this.f20070c) {
                    if (this.f20068a.f20084f == this) {
                        DiskLruCache.this.mo22285b(this, true);
                    }
                    this.f20070c = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        public Sink newSink(int i) {
            synchronized (DiskLruCache.this) {
                if (!this.f20070c) {
                    C3550d dVar = this.f20068a;
                    if (dVar.f20084f != this) {
                        Sink blackhole = Okio.blackhole();
                        return blackhole;
                    }
                    if (!dVar.f20083e) {
                        this.f20069b[i] = true;
                    }
                    try {
                        C3546a aVar = new C3546a(DiskLruCache.this.f20043a.sink(dVar.f20082d[i]));
                        return aVar;
                    } catch (FileNotFoundException unused) {
                        return Okio.blackhole();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public okio.Source newSource(int r5) {
            /*
                r4 = this;
                okhttp3.internal.cache.DiskLruCache r0 = okhttp3.internal.cache.DiskLruCache.this
                monitor-enter(r0)
                boolean r1 = r4.f20070c     // Catch:{ all -> 0x002b }
                if (r1 != 0) goto L_0x0025
                okhttp3.internal.cache.DiskLruCache$d r1 = r4.f20068a     // Catch:{ all -> 0x002b }
                boolean r2 = r1.f20083e     // Catch:{ all -> 0x002b }
                r3 = 0
                if (r2 == 0) goto L_0x0023
                okhttp3.internal.cache.DiskLruCache$Editor r2 = r1.f20084f     // Catch:{ all -> 0x002b }
                if (r2 == r4) goto L_0x0013
                goto L_0x0023
            L_0x0013:
                okhttp3.internal.cache.DiskLruCache r2 = okhttp3.internal.cache.DiskLruCache.this     // Catch:{ FileNotFoundException -> 0x0021 }
                okhttp3.internal.io.FileSystem r2 = r2.f20043a     // Catch:{ FileNotFoundException -> 0x0021 }
                java.io.File[] r1 = r1.f20081c     // Catch:{ FileNotFoundException -> 0x0021 }
                r5 = r1[r5]     // Catch:{ FileNotFoundException -> 0x0021 }
                okio.Source r5 = r2.source(r5)     // Catch:{ FileNotFoundException -> 0x0021 }
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                return r5
            L_0x0021:
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                return r3
            L_0x0023:
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                return r3
            L_0x0025:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x002b }
                r5.<init>()     // Catch:{ all -> 0x002b }
                throw r5     // Catch:{ all -> 0x002b }
            L_0x002b:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.Editor.newSource(int):okio.Source");
        }
    }

    /* renamed from: okhttp3.internal.cache.DiskLruCache$a */
    class C3547a implements Runnable {
        C3547a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r1 = r6.f20073a;
            r1.f20059q = true;
            r1.f20052j = okio.Okio.buffer(okio.Okio.blackhole());
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x002f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                okhttp3.internal.cache.DiskLruCache r0 = okhttp3.internal.cache.DiskLruCache.this
                monitor-enter(r0)
                okhttp3.internal.cache.DiskLruCache r1 = okhttp3.internal.cache.DiskLruCache.this     // Catch:{ all -> 0x003f }
                boolean r2 = r1.f20056n     // Catch:{ all -> 0x003f }
                r3 = 0
                r4 = 1
                if (r2 != 0) goto L_0x000d
                r2 = 1
                goto L_0x000e
            L_0x000d:
                r2 = 0
            L_0x000e:
                boolean r5 = r1.f20057o     // Catch:{ all -> 0x003f }
                r2 = r2 | r5
                if (r2 == 0) goto L_0x0015
                monitor-exit(r0)     // Catch:{ all -> 0x003f }
                return
            L_0x0015:
                r1.mo22300k()     // Catch:{ IOException -> 0x0019 }
                goto L_0x001d
            L_0x0019:
                okhttp3.internal.cache.DiskLruCache r1 = okhttp3.internal.cache.DiskLruCache.this     // Catch:{ all -> 0x003f }
                r1.f20058p = r4     // Catch:{ all -> 0x003f }
            L_0x001d:
                okhttp3.internal.cache.DiskLruCache r1 = okhttp3.internal.cache.DiskLruCache.this     // Catch:{ IOException -> 0x002f }
                boolean r1 = r1.mo22288d()     // Catch:{ IOException -> 0x002f }
                if (r1 == 0) goto L_0x003d
                okhttp3.internal.cache.DiskLruCache r1 = okhttp3.internal.cache.DiskLruCache.this     // Catch:{ IOException -> 0x002f }
                r1.mo22296i()     // Catch:{ IOException -> 0x002f }
                okhttp3.internal.cache.DiskLruCache r1 = okhttp3.internal.cache.DiskLruCache.this     // Catch:{ IOException -> 0x002f }
                r1.f20054l = r3     // Catch:{ IOException -> 0x002f }
                goto L_0x003d
            L_0x002f:
                okhttp3.internal.cache.DiskLruCache r1 = okhttp3.internal.cache.DiskLruCache.this     // Catch:{ all -> 0x003f }
                r1.f20059q = r4     // Catch:{ all -> 0x003f }
                okio.Sink r2 = okio.Okio.blackhole()     // Catch:{ all -> 0x003f }
                okio.BufferedSink r2 = okio.Okio.buffer((okio.Sink) r2)     // Catch:{ all -> 0x003f }
                r1.f20052j = r2     // Catch:{ all -> 0x003f }
            L_0x003d:
                monitor-exit(r0)     // Catch:{ all -> 0x003f }
                return
            L_0x003f:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x003f }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.C3547a.run():void");
        }
    }

    /* renamed from: okhttp3.internal.cache.DiskLruCache$b */
    class C3548b extends C3926a {
        static {
            Class<DiskLruCache> cls = DiskLruCache.class;
        }

        C3548b(Sink sink) {
            super(sink);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo22316a(IOException iOException) {
            DiskLruCache.this.f20055m = true;
        }
    }

    /* renamed from: okhttp3.internal.cache.DiskLruCache$c */
    class C3549c implements Iterator<Snapshot> {

        /* renamed from: a */
        final Iterator<C3550d> f20075a;

        /* renamed from: b */
        Snapshot f20076b;

        /* renamed from: c */
        Snapshot f20077c;

        C3549c() {
            this.f20075a = new ArrayList(DiskLruCache.this.f20053k.values()).iterator();
        }

        /* renamed from: a */
        public Snapshot next() {
            if (hasNext()) {
                Snapshot snapshot = this.f20076b;
                this.f20077c = snapshot;
                this.f20076b = null;
                return snapshot;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.f20076b != null) {
                return true;
            }
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.f20057o) {
                    return false;
                }
                while (this.f20075a.hasNext()) {
                    Snapshot c = this.f20075a.next().mo22323c();
                    if (c != null) {
                        this.f20076b = c;
                        return true;
                    }
                }
                return false;
            }
        }

        public void remove() {
            Snapshot snapshot = this.f20077c;
            if (snapshot != null) {
                try {
                    DiskLruCache.this.remove(snapshot.f20063a);
                } catch (IOException unused) {
                } catch (Throwable th) {
                    this.f20077c = null;
                    throw th;
                }
                this.f20077c = null;
                return;
            }
            throw new IllegalStateException("remove() before next()");
        }
    }

    /* renamed from: okhttp3.internal.cache.DiskLruCache$d */
    private final class C3550d {

        /* renamed from: a */
        final String f20079a;

        /* renamed from: b */
        final long[] f20080b;

        /* renamed from: c */
        final File[] f20081c;

        /* renamed from: d */
        final File[] f20082d;

        /* renamed from: e */
        boolean f20083e;

        /* renamed from: f */
        Editor f20084f;

        /* renamed from: g */
        long f20085g;

        C3550d(String str) {
            this.f20079a = str;
            int i = DiskLruCache.this.f20050h;
            this.f20080b = new long[i];
            this.f20081c = new File[i];
            this.f20082d = new File[i];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < DiskLruCache.this.f20050h; i2++) {
                sb.append(i2);
                this.f20081c[i2] = new File(DiskLruCache.this.f20044b, sb.toString());
                sb.append(".tmp");
                this.f20082d[i2] = new File(DiskLruCache.this.f20044b, sb.toString());
                sb.setLength(length);
            }
        }

        /* renamed from: a */
        private IOException m12020a(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo22322b(String[] strArr) {
            if (strArr.length == DiskLruCache.this.f20050h) {
                int i = 0;
                while (i < strArr.length) {
                    try {
                        this.f20080b[i] = Long.parseLong(strArr[i]);
                        i++;
                    } catch (NumberFormatException unused) {
                        m12020a(strArr);
                        throw null;
                    }
                }
                return;
            }
            m12020a(strArr);
            throw null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public Snapshot mo22323c() {
            if (Thread.holdsLock(DiskLruCache.this)) {
                Source[] sourceArr = new Source[DiskLruCache.this.f20050h];
                long[] jArr = (long[]) this.f20080b.clone();
                int i = 0;
                int i2 = 0;
                while (true) {
                    try {
                        DiskLruCache diskLruCache = DiskLruCache.this;
                        if (i2 >= diskLruCache.f20050h) {
                            return new Snapshot(this.f20079a, this.f20085g, sourceArr, jArr);
                        }
                        sourceArr[i2] = diskLruCache.f20043a.source(this.f20081c[i2]);
                        i2++;
                    } catch (FileNotFoundException unused) {
                        while (true) {
                            DiskLruCache diskLruCache2 = DiskLruCache.this;
                            if (i >= diskLruCache2.f20050h || sourceArr[i] == null) {
                                try {
                                    diskLruCache2.mo22299j(this);
                                    return null;
                                } catch (IOException unused2) {
                                    return null;
                                }
                            } else {
                                Util.closeQuietly((Closeable) sourceArr[i]);
                                i++;
                            }
                        }
                    }
                }
            } else {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo22324d(BufferedSink bufferedSink) {
            for (long writeDecimalLong : this.f20080b) {
                bufferedSink.writeByte(32).writeDecimalLong(writeDecimalLong);
            }
        }
    }

    static {
        Class<DiskLruCache> cls = DiskLruCache.class;
    }

    DiskLruCache(FileSystem fileSystem, File file, int i, int i2, long j, Executor executor) {
        this.f20043a = fileSystem;
        this.f20044b = file;
        this.f20048f = i;
        this.f20045c = new File(file, "journal");
        this.f20046d = new File(file, "journal.tmp");
        this.f20047e = new File(file, "journal.bkp");
        this.f20050h = i2;
        this.f20049g = j;
        this.f20061s = executor;
    }

    /* renamed from: a */
    private synchronized void m12003a() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public static DiskLruCache create(FileSystem fileSystem, File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 > 0) {
            return new DiskLruCache(fileSystem, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    /* renamed from: e */
    private BufferedSink m12004e() {
        return Okio.buffer((Sink) new C3548b(this.f20043a.appendingSink(this.f20045c)));
    }

    /* renamed from: f */
    private void m12005f() {
        this.f20043a.delete(this.f20046d);
        Iterator<C3550d> it = this.f20053k.values().iterator();
        while (it.hasNext()) {
            C3550d next = it.next();
            int i = 0;
            if (next.f20084f == null) {
                while (i < this.f20050h) {
                    this.f20051i += next.f20080b[i];
                    i++;
                }
            } else {
                next.f20084f = null;
                while (i < this.f20050h) {
                    this.f20043a.delete(next.f20081c[i]);
                    this.f20043a.delete(next.f20082d[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.f20054l = r0 - r9.f20053k.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006a, code lost:
        if (r1.exhausted() == false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006c, code lost:
        mo22296i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r9.f20052j = m12004e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0079, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005d */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x007a=Splitter:B:23:0x007a, B:16:0x005d=Splitter:B:16:0x005d} */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m12006g() {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            okhttp3.internal.io.FileSystem r1 = r9.f20043a
            java.io.File r2 = r9.f20045c
            okio.Source r1 = r1.source(r2)
            okio.BufferedSource r1 = okio.Okio.buffer((okio.Source) r1)
            java.lang.String r2 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00a8 }
            java.lang.String r3 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00a8 }
            java.lang.String r4 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00a8 }
            java.lang.String r5 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00a8 }
            java.lang.String r6 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00a8 }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x00a8 }
            if (r7 == 0) goto L_0x007a
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x00a8 }
            if (r7 == 0) goto L_0x007a
            int r7 = r9.f20048f     // Catch:{ all -> 0x00a8 }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00a8 }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00a8 }
            if (r4 == 0) goto L_0x007a
            int r4 = r9.f20050h     // Catch:{ all -> 0x00a8 }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x00a8 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00a8 }
            if (r4 == 0) goto L_0x007a
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x00a8 }
            if (r4 == 0) goto L_0x007a
            r0 = 0
        L_0x0053:
            java.lang.String r2 = r1.readUtf8LineStrict()     // Catch:{ EOFException -> 0x005d }
            r9.m12007h(r2)     // Catch:{ EOFException -> 0x005d }
            int r0 = r0 + 1
            goto L_0x0053
        L_0x005d:
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$d> r2 = r9.f20053k     // Catch:{ all -> 0x00a8 }
            int r2 = r2.size()     // Catch:{ all -> 0x00a8 }
            int r0 = r0 - r2
            r9.f20054l = r0     // Catch:{ all -> 0x00a8 }
            boolean r0 = r1.exhausted()     // Catch:{ all -> 0x00a8 }
            if (r0 != 0) goto L_0x0070
            r9.mo22296i()     // Catch:{ all -> 0x00a8 }
            goto L_0x0076
        L_0x0070:
            okio.BufferedSink r0 = r9.m12004e()     // Catch:{ all -> 0x00a8 }
            r9.f20052j = r0     // Catch:{ all -> 0x00a8 }
        L_0x0076:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1)
            return
        L_0x007a:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00a8 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a8 }
            r7.<init>()     // Catch:{ all -> 0x00a8 }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x00a8 }
            r7.append(r2)     // Catch:{ all -> 0x00a8 }
            r7.append(r0)     // Catch:{ all -> 0x00a8 }
            r7.append(r3)     // Catch:{ all -> 0x00a8 }
            r7.append(r0)     // Catch:{ all -> 0x00a8 }
            r7.append(r5)     // Catch:{ all -> 0x00a8 }
            r7.append(r0)     // Catch:{ all -> 0x00a8 }
            r7.append(r6)     // Catch:{ all -> 0x00a8 }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x00a8 }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00a8 }
            r4.<init>(r0)     // Catch:{ all -> 0x00a8 }
            throw r4     // Catch:{ all -> 0x00a8 }
        L_0x00a8:
            r0 = move-exception
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1)
            goto L_0x00ae
        L_0x00ad:
            throw r0
        L_0x00ae:
            goto L_0x00ad
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.m12006g():void");
    }

    /* renamed from: h */
    private void m12007h(String str) {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                str2 = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f20053k.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i, indexOf2);
            }
            C3550d dVar = this.f20053k.get(str2);
            if (dVar == null) {
                dVar = new C3550d(str2);
                this.f20053k.put(str2, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.f20083e = true;
                dVar.f20084f = null;
                dVar.mo22322b(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f20084f = new Editor(dVar);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* renamed from: l */
    private void m12008l(String str) {
        if (!f20042u.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f4, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo22285b(okhttp3.internal.cache.DiskLruCache.Editor r10, boolean r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            okhttp3.internal.cache.DiskLruCache$d r0 = r10.f20068a     // Catch:{ all -> 0x00fb }
            okhttp3.internal.cache.DiskLruCache$Editor r1 = r0.f20084f     // Catch:{ all -> 0x00fb }
            if (r1 != r10) goto L_0x00f5
            r1 = 0
            if (r11 == 0) goto L_0x0047
            boolean r2 = r0.f20083e     // Catch:{ all -> 0x00fb }
            if (r2 != 0) goto L_0x0047
            r2 = 0
        L_0x000f:
            int r3 = r9.f20050h     // Catch:{ all -> 0x00fb }
            if (r2 >= r3) goto L_0x0047
            boolean[] r3 = r10.f20069b     // Catch:{ all -> 0x00fb }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x00fb }
            if (r3 == 0) goto L_0x002d
            okhttp3.internal.io.FileSystem r3 = r9.f20043a     // Catch:{ all -> 0x00fb }
            java.io.File[] r4 = r0.f20082d     // Catch:{ all -> 0x00fb }
            r4 = r4[r2]     // Catch:{ all -> 0x00fb }
            boolean r3 = r3.exists(r4)     // Catch:{ all -> 0x00fb }
            if (r3 != 0) goto L_0x002a
            r10.abort()     // Catch:{ all -> 0x00fb }
            monitor-exit(r9)
            return
        L_0x002a:
            int r2 = r2 + 1
            goto L_0x000f
        L_0x002d:
            r10.abort()     // Catch:{ all -> 0x00fb }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fb }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fb }
            r11.<init>()     // Catch:{ all -> 0x00fb }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x00fb }
            r11.append(r2)     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00fb }
            r10.<init>(r11)     // Catch:{ all -> 0x00fb }
            throw r10     // Catch:{ all -> 0x00fb }
        L_0x0047:
            int r10 = r9.f20050h     // Catch:{ all -> 0x00fb }
            if (r1 >= r10) goto L_0x007f
            java.io.File[] r10 = r0.f20082d     // Catch:{ all -> 0x00fb }
            r10 = r10[r1]     // Catch:{ all -> 0x00fb }
            if (r11 == 0) goto L_0x0077
            okhttp3.internal.io.FileSystem r2 = r9.f20043a     // Catch:{ all -> 0x00fb }
            boolean r2 = r2.exists(r10)     // Catch:{ all -> 0x00fb }
            if (r2 == 0) goto L_0x007c
            java.io.File[] r2 = r0.f20081c     // Catch:{ all -> 0x00fb }
            r2 = r2[r1]     // Catch:{ all -> 0x00fb }
            okhttp3.internal.io.FileSystem r3 = r9.f20043a     // Catch:{ all -> 0x00fb }
            r3.rename(r10, r2)     // Catch:{ all -> 0x00fb }
            long[] r10 = r0.f20080b     // Catch:{ all -> 0x00fb }
            r3 = r10[r1]     // Catch:{ all -> 0x00fb }
            okhttp3.internal.io.FileSystem r10 = r9.f20043a     // Catch:{ all -> 0x00fb }
            long r5 = r10.size(r2)     // Catch:{ all -> 0x00fb }
            long[] r10 = r0.f20080b     // Catch:{ all -> 0x00fb }
            r10[r1] = r5     // Catch:{ all -> 0x00fb }
            long r7 = r9.f20051i     // Catch:{ all -> 0x00fb }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f20051i = r7     // Catch:{ all -> 0x00fb }
            goto L_0x007c
        L_0x0077:
            okhttp3.internal.io.FileSystem r2 = r9.f20043a     // Catch:{ all -> 0x00fb }
            r2.delete(r10)     // Catch:{ all -> 0x00fb }
        L_0x007c:
            int r1 = r1 + 1
            goto L_0x0047
        L_0x007f:
            int r10 = r9.f20054l     // Catch:{ all -> 0x00fb }
            r1 = 1
            int r10 = r10 + r1
            r9.f20054l = r10     // Catch:{ all -> 0x00fb }
            r10 = 0
            r0.f20084f = r10     // Catch:{ all -> 0x00fb }
            boolean r10 = r0.f20083e     // Catch:{ all -> 0x00fb }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00bb
            r0.f20083e = r1     // Catch:{ all -> 0x00fb }
            okio.BufferedSink r10 = r9.f20052j     // Catch:{ all -> 0x00fb }
            java.lang.String r1 = "CLEAN"
            okio.BufferedSink r10 = r10.writeUtf8(r1)     // Catch:{ all -> 0x00fb }
            r10.writeByte(r3)     // Catch:{ all -> 0x00fb }
            okio.BufferedSink r10 = r9.f20052j     // Catch:{ all -> 0x00fb }
            java.lang.String r1 = r0.f20079a     // Catch:{ all -> 0x00fb }
            r10.writeUtf8(r1)     // Catch:{ all -> 0x00fb }
            okio.BufferedSink r10 = r9.f20052j     // Catch:{ all -> 0x00fb }
            r0.mo22324d(r10)     // Catch:{ all -> 0x00fb }
            okio.BufferedSink r10 = r9.f20052j     // Catch:{ all -> 0x00fb }
            r10.writeByte(r2)     // Catch:{ all -> 0x00fb }
            if (r11 == 0) goto L_0x00d9
            long r10 = r9.f20060r     // Catch:{ all -> 0x00fb }
            r1 = 1
            long r1 = r1 + r10
            r9.f20060r = r1     // Catch:{ all -> 0x00fb }
            r0.f20085g = r10     // Catch:{ all -> 0x00fb }
            goto L_0x00d9
        L_0x00bb:
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$d> r10 = r9.f20053k     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = r0.f20079a     // Catch:{ all -> 0x00fb }
            r10.remove(r11)     // Catch:{ all -> 0x00fb }
            okio.BufferedSink r10 = r9.f20052j     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = "REMOVE"
            okio.BufferedSink r10 = r10.writeUtf8(r11)     // Catch:{ all -> 0x00fb }
            r10.writeByte(r3)     // Catch:{ all -> 0x00fb }
            okio.BufferedSink r10 = r9.f20052j     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = r0.f20079a     // Catch:{ all -> 0x00fb }
            r10.writeUtf8(r11)     // Catch:{ all -> 0x00fb }
            okio.BufferedSink r10 = r9.f20052j     // Catch:{ all -> 0x00fb }
            r10.writeByte(r2)     // Catch:{ all -> 0x00fb }
        L_0x00d9:
            okio.BufferedSink r10 = r9.f20052j     // Catch:{ all -> 0x00fb }
            r10.flush()     // Catch:{ all -> 0x00fb }
            long r10 = r9.f20051i     // Catch:{ all -> 0x00fb }
            long r0 = r9.f20049g     // Catch:{ all -> 0x00fb }
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00ec
            boolean r10 = r9.mo22288d()     // Catch:{ all -> 0x00fb }
            if (r10 == 0) goto L_0x00f3
        L_0x00ec:
            java.util.concurrent.Executor r10 = r9.f20061s     // Catch:{ all -> 0x00fb }
            java.lang.Runnable r11 = r9.f20062t     // Catch:{ all -> 0x00fb }
            r10.execute(r11)     // Catch:{ all -> 0x00fb }
        L_0x00f3:
            monitor-exit(r9)
            return
        L_0x00f5:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fb }
            r10.<init>()     // Catch:{ all -> 0x00fb }
            throw r10     // Catch:{ all -> 0x00fb }
        L_0x00fb:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x00ff
        L_0x00fe:
            throw r10
        L_0x00ff:
            goto L_0x00fe
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.mo22285b(okhttp3.internal.cache.DiskLruCache$Editor, boolean):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        return null;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized okhttp3.internal.cache.DiskLruCache.Editor mo22286c(java.lang.String r6, long r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.initialize()     // Catch:{ all -> 0x0074 }
            r5.m12003a()     // Catch:{ all -> 0x0074 }
            r5.m12008l(r6)     // Catch:{ all -> 0x0074 }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$d> r0 = r5.f20053k     // Catch:{ all -> 0x0074 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0074 }
            okhttp3.internal.cache.DiskLruCache$d r0 = (okhttp3.internal.cache.DiskLruCache.C3550d) r0     // Catch:{ all -> 0x0074 }
            r1 = -1
            r3 = 0
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x0023
            if (r0 == 0) goto L_0x0021
            long r1 = r0.f20085g     // Catch:{ all -> 0x0074 }
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x0023
        L_0x0021:
            monitor-exit(r5)
            return r3
        L_0x0023:
            if (r0 == 0) goto L_0x002b
            okhttp3.internal.cache.DiskLruCache$Editor r7 = r0.f20084f     // Catch:{ all -> 0x0074 }
            if (r7 == 0) goto L_0x002b
            monitor-exit(r5)
            return r3
        L_0x002b:
            boolean r7 = r5.f20058p     // Catch:{ all -> 0x0074 }
            if (r7 != 0) goto L_0x006b
            boolean r7 = r5.f20059q     // Catch:{ all -> 0x0074 }
            if (r7 == 0) goto L_0x0034
            goto L_0x006b
        L_0x0034:
            okio.BufferedSink r7 = r5.f20052j     // Catch:{ all -> 0x0074 }
            java.lang.String r8 = "DIRTY"
            okio.BufferedSink r7 = r7.writeUtf8(r8)     // Catch:{ all -> 0x0074 }
            r8 = 32
            okio.BufferedSink r7 = r7.writeByte(r8)     // Catch:{ all -> 0x0074 }
            okio.BufferedSink r7 = r7.writeUtf8(r6)     // Catch:{ all -> 0x0074 }
            r8 = 10
            r7.writeByte(r8)     // Catch:{ all -> 0x0074 }
            okio.BufferedSink r7 = r5.f20052j     // Catch:{ all -> 0x0074 }
            r7.flush()     // Catch:{ all -> 0x0074 }
            boolean r7 = r5.f20055m     // Catch:{ all -> 0x0074 }
            if (r7 == 0) goto L_0x0056
            monitor-exit(r5)
            return r3
        L_0x0056:
            if (r0 != 0) goto L_0x0062
            okhttp3.internal.cache.DiskLruCache$d r0 = new okhttp3.internal.cache.DiskLruCache$d     // Catch:{ all -> 0x0074 }
            r0.<init>(r6)     // Catch:{ all -> 0x0074 }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$d> r7 = r5.f20053k     // Catch:{ all -> 0x0074 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0074 }
        L_0x0062:
            okhttp3.internal.cache.DiskLruCache$Editor r6 = new okhttp3.internal.cache.DiskLruCache$Editor     // Catch:{ all -> 0x0074 }
            r6.<init>(r0)     // Catch:{ all -> 0x0074 }
            r0.f20084f = r6     // Catch:{ all -> 0x0074 }
            monitor-exit(r5)
            return r6
        L_0x006b:
            java.util.concurrent.Executor r6 = r5.f20061s     // Catch:{ all -> 0x0074 }
            java.lang.Runnable r7 = r5.f20062t     // Catch:{ all -> 0x0074 }
            r6.execute(r7)     // Catch:{ all -> 0x0074 }
            monitor-exit(r5)
            return r3
        L_0x0074:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.mo22286c(java.lang.String, long):okhttp3.internal.cache.DiskLruCache$Editor");
    }

    public synchronized void close() {
        if (this.f20056n) {
            if (!this.f20057o) {
                for (C3550d dVar : (C3550d[]) this.f20053k.values().toArray(new C3550d[this.f20053k.size()])) {
                    Editor editor = dVar.f20084f;
                    if (editor != null) {
                        editor.abort();
                    }
                }
                mo22300k();
                this.f20052j.close();
                this.f20052j = null;
                this.f20057o = true;
                return;
            }
        }
        this.f20057o = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo22288d() {
        int i = this.f20054l;
        return i >= 2000 && i >= this.f20053k.size();
    }

    public void delete() {
        close();
        this.f20043a.deleteContents(this.f20044b);
    }

    @Nullable
    public Editor edit(String str) {
        return mo22286c(str, -1);
    }

    public synchronized void evictAll() {
        initialize();
        for (C3550d j : (C3550d[]) this.f20053k.values().toArray(new C3550d[this.f20053k.size()])) {
            mo22299j(j);
        }
        this.f20058p = false;
    }

    public synchronized void flush() {
        if (this.f20056n) {
            m12003a();
            mo22300k();
            this.f20052j.flush();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized okhttp3.internal.cache.DiskLruCache.Snapshot get(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.initialize()     // Catch:{ all -> 0x0050 }
            r3.m12003a()     // Catch:{ all -> 0x0050 }
            r3.m12008l(r4)     // Catch:{ all -> 0x0050 }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$d> r0 = r3.f20053k     // Catch:{ all -> 0x0050 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0050 }
            okhttp3.internal.cache.DiskLruCache$d r0 = (okhttp3.internal.cache.DiskLruCache.C3550d) r0     // Catch:{ all -> 0x0050 }
            r1 = 0
            if (r0 == 0) goto L_0x004e
            boolean r2 = r0.f20083e     // Catch:{ all -> 0x0050 }
            if (r2 != 0) goto L_0x001a
            goto L_0x004e
        L_0x001a:
            okhttp3.internal.cache.DiskLruCache$Snapshot r0 = r0.mo22323c()     // Catch:{ all -> 0x0050 }
            if (r0 != 0) goto L_0x0022
            monitor-exit(r3)
            return r1
        L_0x0022:
            int r1 = r3.f20054l     // Catch:{ all -> 0x0050 }
            int r1 = r1 + 1
            r3.f20054l = r1     // Catch:{ all -> 0x0050 }
            okio.BufferedSink r1 = r3.f20052j     // Catch:{ all -> 0x0050 }
            java.lang.String r2 = "READ"
            okio.BufferedSink r1 = r1.writeUtf8(r2)     // Catch:{ all -> 0x0050 }
            r2 = 32
            okio.BufferedSink r1 = r1.writeByte(r2)     // Catch:{ all -> 0x0050 }
            okio.BufferedSink r4 = r1.writeUtf8(r4)     // Catch:{ all -> 0x0050 }
            r1 = 10
            r4.writeByte(r1)     // Catch:{ all -> 0x0050 }
            boolean r4 = r3.mo22288d()     // Catch:{ all -> 0x0050 }
            if (r4 == 0) goto L_0x004c
            java.util.concurrent.Executor r4 = r3.f20061s     // Catch:{ all -> 0x0050 }
            java.lang.Runnable r1 = r3.f20062t     // Catch:{ all -> 0x0050 }
            r4.execute(r1)     // Catch:{ all -> 0x0050 }
        L_0x004c:
            monitor-exit(r3)
            return r0
        L_0x004e:
            monitor-exit(r3)
            return r1
        L_0x0050:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.get(java.lang.String):okhttp3.internal.cache.DiskLruCache$Snapshot");
    }

    public File getDirectory() {
        return this.f20044b;
    }

    public synchronized long getMaxSize() {
        return this.f20049g;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public synchronized void mo22296i() {
        BufferedSink bufferedSink = this.f20052j;
        if (bufferedSink != null) {
            bufferedSink.close();
        }
        BufferedSink buffer = Okio.buffer(this.f20043a.sink(this.f20046d));
        try {
            buffer.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
            buffer.writeUtf8("1").writeByte(10);
            buffer.writeDecimalLong((long) this.f20048f).writeByte(10);
            buffer.writeDecimalLong((long) this.f20050h).writeByte(10);
            buffer.writeByte(10);
            for (C3550d next : this.f20053k.values()) {
                if (next.f20084f != null) {
                    buffer.writeUtf8("DIRTY").writeByte(32);
                    buffer.writeUtf8(next.f20079a);
                    buffer.writeByte(10);
                } else {
                    buffer.writeUtf8("CLEAN").writeByte(32);
                    buffer.writeUtf8(next.f20079a);
                    next.mo22324d(buffer);
                    buffer.writeByte(10);
                }
            }
            buffer.close();
            if (this.f20043a.exists(this.f20045c)) {
                this.f20043a.rename(this.f20045c, this.f20047e);
            }
            this.f20043a.rename(this.f20046d, this.f20045c);
            this.f20043a.delete(this.f20047e);
            this.f20052j = m12004e();
            this.f20055m = false;
            this.f20059q = false;
        } catch (Throwable th) {
            buffer.close();
            throw th;
        }
    }

    public synchronized void initialize() {
        if (!this.f20056n) {
            if (this.f20043a.exists(this.f20047e)) {
                if (this.f20043a.exists(this.f20045c)) {
                    this.f20043a.delete(this.f20047e);
                } else {
                    this.f20043a.rename(this.f20047e, this.f20045c);
                }
            }
            if (this.f20043a.exists(this.f20045c)) {
                try {
                    m12006g();
                    m12005f();
                    this.f20056n = true;
                    return;
                } catch (IOException e) {
                    Platform platform = Platform.get();
                    platform.log(5, "DiskLruCache " + this.f20044b + " is corrupt: " + e.getMessage() + ", removing", e);
                    delete();
                    this.f20057o = false;
                } catch (Throwable th) {
                    this.f20057o = false;
                    throw th;
                }
            }
            mo22296i();
            this.f20056n = true;
        }
    }

    public synchronized boolean isClosed() {
        return this.f20057o;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public boolean mo22299j(C3550d dVar) {
        Editor editor = dVar.f20084f;
        if (editor != null) {
            editor.mo22310a();
        }
        for (int i = 0; i < this.f20050h; i++) {
            this.f20043a.delete(dVar.f20081c[i]);
            long j = this.f20051i;
            long[] jArr = dVar.f20080b;
            this.f20051i = j - jArr[i];
            jArr[i] = 0;
        }
        this.f20054l++;
        this.f20052j.writeUtf8("REMOVE").writeByte(32).writeUtf8(dVar.f20079a).writeByte(10);
        this.f20053k.remove(dVar.f20079a);
        if (mo22288d()) {
            this.f20061s.execute(this.f20062t);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo22300k() {
        while (this.f20051i > this.f20049g) {
            mo22299j(this.f20053k.values().iterator().next());
        }
        this.f20058p = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean remove(java.lang.String r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            r6.initialize()     // Catch:{ all -> 0x0029 }
            r6.m12003a()     // Catch:{ all -> 0x0029 }
            r6.m12008l(r7)     // Catch:{ all -> 0x0029 }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$d> r0 = r6.f20053k     // Catch:{ all -> 0x0029 }
            java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x0029 }
            okhttp3.internal.cache.DiskLruCache$d r7 = (okhttp3.internal.cache.DiskLruCache.C3550d) r7     // Catch:{ all -> 0x0029 }
            r0 = 0
            if (r7 != 0) goto L_0x0017
            monitor-exit(r6)
            return r0
        L_0x0017:
            boolean r7 = r6.mo22299j(r7)     // Catch:{ all -> 0x0029 }
            if (r7 == 0) goto L_0x0027
            long r1 = r6.f20051i     // Catch:{ all -> 0x0029 }
            long r3 = r6.f20049g     // Catch:{ all -> 0x0029 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0027
            r6.f20058p = r0     // Catch:{ all -> 0x0029 }
        L_0x0027:
            monitor-exit(r6)
            return r7
        L_0x0029:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.remove(java.lang.String):boolean");
    }

    public synchronized void setMaxSize(long j) {
        this.f20049g = j;
        if (this.f20056n) {
            this.f20061s.execute(this.f20062t);
        }
    }

    public synchronized long size() {
        initialize();
        return this.f20051i;
    }

    public synchronized Iterator<Snapshot> snapshots() {
        initialize();
        return new C3549c();
    }
}
