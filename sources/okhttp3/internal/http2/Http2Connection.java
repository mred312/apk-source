package okhttp3.internal.http2;

import androidx.core.internal.view.SupportMenu;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.http2.C3953b;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

public final class Http2Connection implements Closeable {
    /* access modifiers changed from: private */

    /* renamed from: u */
    public static final ExecutorService f21201u = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Http2Connection", true));

    /* renamed from: a */
    final boolean f21202a;

    /* renamed from: b */
    final Listener f21203b;

    /* renamed from: c */
    final Map<Integer, Http2Stream> f21204c = new LinkedHashMap();

    /* renamed from: d */
    final String f21205d;

    /* renamed from: e */
    int f21206e;

    /* renamed from: f */
    int f21207f;

    /* renamed from: g */
    boolean f21208g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final ScheduledExecutorService f21209h;

    /* renamed from: i */
    private final ExecutorService f21210i;

    /* renamed from: j */
    final PushObserver f21211j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f21212k;

    /* renamed from: l */
    long f21213l = 0;

    /* renamed from: m */
    long f21214m;

    /* renamed from: n */
    Settings f21215n = new Settings();

    /* renamed from: o */
    final Settings f21216o;

    /* renamed from: p */
    boolean f21217p;

    /* renamed from: q */
    final Socket f21218q;

    /* renamed from: r */
    final C3956c f21219r;

    /* renamed from: s */
    final C3945h f21220s;

    /* renamed from: t */
    final Set<Integer> f21221t;

    public static abstract class Listener {
        public static final Listener REFUSE_INCOMING_STREAMS = new C3552a();

        /* renamed from: okhttp3.internal.http2.Http2Connection$Listener$a */
        class C3552a extends Listener {
            C3552a() {
            }

            public void onStream(Http2Stream http2Stream) {
                http2Stream.close(ErrorCode.REFUSED_STREAM);
            }
        }

        public void onSettings(Http2Connection http2Connection) {
        }

        public abstract void onStream(Http2Stream http2Stream);
    }

    /* renamed from: okhttp3.internal.http2.Http2Connection$a */
    class C3938a extends NamedRunnable {

        /* renamed from: a */
        final /* synthetic */ int f21230a;

        /* renamed from: b */
        final /* synthetic */ ErrorCode f21231b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C3938a(String str, Object[] objArr, int i, ErrorCode errorCode) {
            super(str, objArr);
            this.f21230a = i;
            this.f21231b = errorCode;
        }

        public void execute() {
            try {
                Http2Connection.this.mo25059t(this.f21230a, this.f21231b);
            } catch (IOException unused) {
                Http2Connection.this.m14274f();
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.Http2Connection$b */
    class C3939b extends NamedRunnable {

        /* renamed from: a */
        final /* synthetic */ int f21233a;

        /* renamed from: b */
        final /* synthetic */ long f21234b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C3939b(String str, Object[] objArr, int i, long j) {
            super(str, objArr);
            this.f21233a = i;
            this.f21234b = j;
        }

        public void execute() {
            try {
                Http2Connection.this.f21219r.mo25120o(this.f21233a, this.f21234b);
            } catch (IOException unused) {
                Http2Connection.this.m14274f();
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.Http2Connection$c */
    class C3940c extends NamedRunnable {

        /* renamed from: a */
        final /* synthetic */ int f21236a;

        /* renamed from: b */
        final /* synthetic */ List f21237b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C3940c(String str, Object[] objArr, int i, List list) {
            super(str, objArr);
            this.f21236a = i;
            this.f21237b = list;
        }

        public void execute() {
            if (Http2Connection.this.f21211j.onRequest(this.f21236a, this.f21237b)) {
                try {
                    Http2Connection.this.f21219r.mo25116k(this.f21236a, ErrorCode.CANCEL);
                    synchronized (Http2Connection.this) {
                        Http2Connection.this.f21221t.remove(Integer.valueOf(this.f21236a));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.Http2Connection$d */
    class C3941d extends NamedRunnable {

        /* renamed from: a */
        final /* synthetic */ int f21239a;

        /* renamed from: b */
        final /* synthetic */ List f21240b;

        /* renamed from: c */
        final /* synthetic */ boolean f21241c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C3941d(String str, Object[] objArr, int i, List list, boolean z) {
            super(str, objArr);
            this.f21239a = i;
            this.f21240b = list;
            this.f21241c = z;
        }

        public void execute() {
            boolean onHeaders = Http2Connection.this.f21211j.onHeaders(this.f21239a, this.f21240b, this.f21241c);
            if (onHeaders) {
                try {
                    Http2Connection.this.f21219r.mo25116k(this.f21239a, ErrorCode.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (onHeaders || this.f21241c) {
                synchronized (Http2Connection.this) {
                    Http2Connection.this.f21221t.remove(Integer.valueOf(this.f21239a));
                }
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.Http2Connection$e */
    class C3942e extends NamedRunnable {

        /* renamed from: a */
        final /* synthetic */ int f21243a;

        /* renamed from: b */
        final /* synthetic */ Buffer f21244b;

        /* renamed from: c */
        final /* synthetic */ int f21245c;

        /* renamed from: d */
        final /* synthetic */ boolean f21246d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C3942e(String str, Object[] objArr, int i, Buffer buffer, int i2, boolean z) {
            super(str, objArr);
            this.f21243a = i;
            this.f21244b = buffer;
            this.f21245c = i2;
            this.f21246d = z;
        }

        public void execute() {
            try {
                boolean onData = Http2Connection.this.f21211j.onData(this.f21243a, this.f21244b, this.f21245c, this.f21246d);
                if (onData) {
                    Http2Connection.this.f21219r.mo25116k(this.f21243a, ErrorCode.CANCEL);
                }
                if (onData || this.f21246d) {
                    synchronized (Http2Connection.this) {
                        Http2Connection.this.f21221t.remove(Integer.valueOf(this.f21243a));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.Http2Connection$f */
    class C3943f extends NamedRunnable {

        /* renamed from: a */
        final /* synthetic */ int f21248a;

        /* renamed from: b */
        final /* synthetic */ ErrorCode f21249b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C3943f(String str, Object[] objArr, int i, ErrorCode errorCode) {
            super(str, objArr);
            this.f21248a = i;
            this.f21249b = errorCode;
        }

        public void execute() {
            Http2Connection.this.f21211j.onReset(this.f21248a, this.f21249b);
            synchronized (Http2Connection.this) {
                Http2Connection.this.f21221t.remove(Integer.valueOf(this.f21248a));
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.Http2Connection$g */
    final class C3944g extends NamedRunnable {

        /* renamed from: a */
        final boolean f21251a;

        /* renamed from: b */
        final int f21252b;

        /* renamed from: c */
        final int f21253c;

        C3944g(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", Http2Connection.this.f21205d, Integer.valueOf(i), Integer.valueOf(i2));
            this.f21251a = z;
            this.f21252b = i;
            this.f21253c = i2;
        }

        public void execute() {
            Http2Connection.this.mo25054r(this.f21251a, this.f21252b, this.f21253c);
        }
    }

    /* renamed from: okhttp3.internal.http2.Http2Connection$h */
    class C3945h extends NamedRunnable implements C3953b.C3955b {

        /* renamed from: a */
        final C3953b f21255a;

        /* renamed from: okhttp3.internal.http2.Http2Connection$h$a */
        class C3946a extends NamedRunnable {

            /* renamed from: a */
            final /* synthetic */ Http2Stream f21257a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C3946a(String str, Object[] objArr, Http2Stream http2Stream) {
                super(str, objArr);
                this.f21257a = http2Stream;
            }

            public void execute() {
                try {
                    Http2Connection.this.f21203b.onStream(this.f21257a);
                } catch (IOException e) {
                    Platform platform = Platform.get();
                    platform.log(4, "Http2Connection.Listener failure for " + Http2Connection.this.f21205d, e);
                    try {
                        this.f21257a.close(ErrorCode.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        /* renamed from: okhttp3.internal.http2.Http2Connection$h$b */
        class C3947b extends NamedRunnable {
            C3947b(String str, Object... objArr) {
                super(str, objArr);
            }

            public void execute() {
                Http2Connection http2Connection = Http2Connection.this;
                http2Connection.f21203b.onSettings(http2Connection);
            }
        }

        /* renamed from: okhttp3.internal.http2.Http2Connection$h$c */
        class C3948c extends NamedRunnable {

            /* renamed from: a */
            final /* synthetic */ Settings f21260a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C3948c(String str, Object[] objArr, Settings settings) {
                super(str, objArr);
                this.f21260a = settings;
            }

            public void execute() {
                try {
                    Http2Connection.this.f21219r.mo25104a(this.f21260a);
                } catch (IOException unused) {
                    Http2Connection.this.m14274f();
                }
            }
        }

        C3945h(C3953b bVar) {
            super("OkHttp %s", Http2Connection.this.f21205d);
            this.f21255a = bVar;
        }

        /* renamed from: k */
        private void m14292k(Settings settings) {
            try {
                Http2Connection.this.f21209h.execute(new C3948c("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.f21205d}, settings));
            } catch (RejectedExecutionException unused) {
            }
        }

        /* renamed from: a */
        public void mo25069a() {
        }

        /* JADX WARNING: type inference failed for: r1v11, types: [java.lang.Object[]] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo25070b(boolean r11, okhttp3.internal.http2.Settings r12) {
            /*
                r10 = this;
                okhttp3.internal.http2.Http2Connection r0 = okhttp3.internal.http2.Http2Connection.this
                monitor-enter(r0)
                okhttp3.internal.http2.Http2Connection r1 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x008b }
                okhttp3.internal.http2.Settings r1 = r1.f21216o     // Catch:{ all -> 0x008b }
                int r1 = r1.mo25086d()     // Catch:{ all -> 0x008b }
                if (r11 == 0) goto L_0x0014
                okhttp3.internal.http2.Http2Connection r11 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x008b }
                okhttp3.internal.http2.Settings r11 = r11.f21216o     // Catch:{ all -> 0x008b }
                r11.mo25083a()     // Catch:{ all -> 0x008b }
            L_0x0014:
                okhttp3.internal.http2.Http2Connection r11 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x008b }
                okhttp3.internal.http2.Settings r11 = r11.f21216o     // Catch:{ all -> 0x008b }
                r11.mo25090h(r12)     // Catch:{ all -> 0x008b }
                r10.m14292k(r12)     // Catch:{ all -> 0x008b }
                okhttp3.internal.http2.Http2Connection r11 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x008b }
                okhttp3.internal.http2.Settings r11 = r11.f21216o     // Catch:{ all -> 0x008b }
                int r11 = r11.mo25086d()     // Catch:{ all -> 0x008b }
                r12 = -1
                r2 = 0
                r4 = 1
                r5 = 0
                if (r11 == r12) goto L_0x005b
                if (r11 == r1) goto L_0x005b
                int r11 = r11 - r1
                long r11 = (long) r11     // Catch:{ all -> 0x008b }
                okhttp3.internal.http2.Http2Connection r1 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x008b }
                boolean r6 = r1.f21217p     // Catch:{ all -> 0x008b }
                if (r6 != 0) goto L_0x0039
                r1.f21217p = r4     // Catch:{ all -> 0x008b }
            L_0x0039:
                java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r1 = r1.f21204c     // Catch:{ all -> 0x008b }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x008b }
                if (r1 != 0) goto L_0x005c
                okhttp3.internal.http2.Http2Connection r1 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x008b }
                java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r1 = r1.f21204c     // Catch:{ all -> 0x008b }
                java.util.Collection r1 = r1.values()     // Catch:{ all -> 0x008b }
                okhttp3.internal.http2.Http2Connection r5 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x008b }
                java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r5 = r5.f21204c     // Catch:{ all -> 0x008b }
                int r5 = r5.size()     // Catch:{ all -> 0x008b }
                okhttp3.internal.http2.Http2Stream[] r5 = new okhttp3.internal.http2.Http2Stream[r5]     // Catch:{ all -> 0x008b }
                java.lang.Object[] r1 = r1.toArray(r5)     // Catch:{ all -> 0x008b }
                r5 = r1
                okhttp3.internal.http2.Http2Stream[] r5 = (okhttp3.internal.http2.Http2Stream[]) r5     // Catch:{ all -> 0x008b }
                goto L_0x005c
            L_0x005b:
                r11 = r2
            L_0x005c:
                java.util.concurrent.ExecutorService r1 = okhttp3.internal.http2.Http2Connection.f21201u     // Catch:{ all -> 0x008b }
                okhttp3.internal.http2.Http2Connection$h$b r6 = new okhttp3.internal.http2.Http2Connection$h$b     // Catch:{ all -> 0x008b }
                java.lang.String r7 = "OkHttp %s settings"
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x008b }
                okhttp3.internal.http2.Http2Connection r8 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x008b }
                java.lang.String r8 = r8.f21205d     // Catch:{ all -> 0x008b }
                r9 = 0
                r4[r9] = r8     // Catch:{ all -> 0x008b }
                r6.<init>(r7, r4)     // Catch:{ all -> 0x008b }
                r1.execute(r6)     // Catch:{ all -> 0x008b }
                monitor-exit(r0)     // Catch:{ all -> 0x008b }
                if (r5 == 0) goto L_0x008a
                int r0 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
                if (r0 == 0) goto L_0x008a
                int r0 = r5.length
            L_0x007b:
                if (r9 >= r0) goto L_0x008a
                r1 = r5[r9]
                monitor-enter(r1)
                r1.mo22337c(r11)     // Catch:{ all -> 0x0087 }
                monitor-exit(r1)     // Catch:{ all -> 0x0087 }
                int r9 = r9 + 1
                goto L_0x007b
            L_0x0087:
                r11 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0087 }
                throw r11
            L_0x008a:
                return
            L_0x008b:
                r11 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x008b }
                goto L_0x008f
            L_0x008e:
                throw r11
            L_0x008f:
                goto L_0x008e
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.C3945h.mo25070b(boolean, okhttp3.internal.http2.Settings):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x006e, code lost:
            r0.mo22349i(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0071, code lost:
            if (r10 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0073, code lost:
            r0.mo22348h();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            return;
         */
        /* renamed from: c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo25071c(boolean r10, int r11, int r12, java.util.List<okhttp3.internal.http2.Header> r13) {
            /*
                r9 = this;
                okhttp3.internal.http2.Http2Connection r12 = okhttp3.internal.http2.Http2Connection.this
                boolean r12 = r12.mo25047n(r11)
                if (r12 == 0) goto L_0x000e
                okhttp3.internal.http2.Http2Connection r12 = okhttp3.internal.http2.Http2Connection.this
                r12.mo25043k(r11, r13, r10)
                return
            L_0x000e:
                okhttp3.internal.http2.Http2Connection r12 = okhttp3.internal.http2.Http2Connection.this
                monitor-enter(r12)
                okhttp3.internal.http2.Http2Connection r0 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0077 }
                okhttp3.internal.http2.Http2Stream r0 = r0.mo25039g(r11)     // Catch:{ all -> 0x0077 }
                if (r0 != 0) goto L_0x006d
                okhttp3.internal.http2.Http2Connection r0 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0077 }
                boolean r1 = r0.f21208g     // Catch:{ all -> 0x0077 }
                if (r1 == 0) goto L_0x0021
                monitor-exit(r12)     // Catch:{ all -> 0x0077 }
                return
            L_0x0021:
                int r1 = r0.f21206e     // Catch:{ all -> 0x0077 }
                if (r11 > r1) goto L_0x0027
                monitor-exit(r12)     // Catch:{ all -> 0x0077 }
                return
            L_0x0027:
                int r1 = r11 % 2
                int r0 = r0.f21207f     // Catch:{ all -> 0x0077 }
                r2 = 2
                int r0 = r0 % r2
                if (r1 != r0) goto L_0x0031
                monitor-exit(r12)     // Catch:{ all -> 0x0077 }
                return
            L_0x0031:
                okhttp3.Headers r8 = okhttp3.internal.Util.toHeaders(r13)     // Catch:{ all -> 0x0077 }
                okhttp3.internal.http2.Http2Stream r13 = new okhttp3.internal.http2.Http2Stream     // Catch:{ all -> 0x0077 }
                okhttp3.internal.http2.Http2Connection r5 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0077 }
                r6 = 0
                r3 = r13
                r4 = r11
                r7 = r10
                r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0077 }
                okhttp3.internal.http2.Http2Connection r10 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0077 }
                r10.f21206e = r11     // Catch:{ all -> 0x0077 }
                java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r10 = r10.f21204c     // Catch:{ all -> 0x0077 }
                java.lang.Integer r0 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0077 }
                r10.put(r0, r13)     // Catch:{ all -> 0x0077 }
                java.util.concurrent.ExecutorService r10 = okhttp3.internal.http2.Http2Connection.f21201u     // Catch:{ all -> 0x0077 }
                okhttp3.internal.http2.Http2Connection$h$a r0 = new okhttp3.internal.http2.Http2Connection$h$a     // Catch:{ all -> 0x0077 }
                java.lang.String r1 = "OkHttp %s stream %d"
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0077 }
                r3 = 0
                okhttp3.internal.http2.Http2Connection r4 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0077 }
                java.lang.String r4 = r4.f21205d     // Catch:{ all -> 0x0077 }
                r2[r3] = r4     // Catch:{ all -> 0x0077 }
                r3 = 1
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0077 }
                r2[r3] = r11     // Catch:{ all -> 0x0077 }
                r0.<init>(r1, r2, r13)     // Catch:{ all -> 0x0077 }
                r10.execute(r0)     // Catch:{ all -> 0x0077 }
                monitor-exit(r12)     // Catch:{ all -> 0x0077 }
                return
            L_0x006d:
                monitor-exit(r12)     // Catch:{ all -> 0x0077 }
                r0.mo22349i(r13)
                if (r10 == 0) goto L_0x0076
                r0.mo22348h()
            L_0x0076:
                return
            L_0x0077:
                r10 = move-exception
                monitor-exit(r12)     // Catch:{ all -> 0x0077 }
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.C3945h.mo25071c(boolean, int, int, java.util.List):void");
        }

        /* renamed from: d */
        public void mo25072d(int i, long j) {
            if (i == 0) {
                synchronized (Http2Connection.this) {
                    Http2Connection http2Connection = Http2Connection.this;
                    http2Connection.f21214m += j;
                    http2Connection.notifyAll();
                }
                return;
            }
            Http2Stream g = Http2Connection.this.mo25039g(i);
            if (g != null) {
                synchronized (g) {
                    g.mo22337c(j);
                }
            }
        }

        /* renamed from: e */
        public void mo25073e(boolean z, int i, BufferedSource bufferedSource, int i2) {
            if (Http2Connection.this.mo25047n(i)) {
                Http2Connection.this.mo25041i(i, bufferedSource, i2, z);
                return;
            }
            Http2Stream g = Http2Connection.this.mo25039g(i);
            if (g == null) {
                Http2Connection.this.mo25060u(i, ErrorCode.PROTOCOL_ERROR);
                long j = (long) i2;
                Http2Connection.this.mo25053q(j);
                bufferedSource.skip(j);
                return;
            }
            g.mo22342g(bufferedSource, i2);
            if (z) {
                g.mo22348h();
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r0 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r4.f21256b.mo25037e(r0, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x002c, code lost:
            r2 = th;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x001f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void execute() {
            /*
                r4 = this;
                okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.INTERNAL_ERROR
                okhttp3.internal.http2.b r1 = r4.f21255a     // Catch:{ IOException -> 0x001e, all -> 0x001b }
                r1.mo25102c(r4)     // Catch:{ IOException -> 0x001e, all -> 0x001b }
            L_0x0007:
                okhttp3.internal.http2.b r1 = r4.f21255a     // Catch:{ IOException -> 0x001e, all -> 0x001b }
                r2 = 0
                boolean r1 = r1.mo25101b(r2, r4)     // Catch:{ IOException -> 0x001e, all -> 0x001b }
                if (r1 == 0) goto L_0x0011
                goto L_0x0007
            L_0x0011:
                okhttp3.internal.http2.ErrorCode r1 = okhttp3.internal.http2.ErrorCode.NO_ERROR     // Catch:{ IOException -> 0x001e, all -> 0x001b }
                okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch:{ IOException -> 0x001f }
                okhttp3.internal.http2.Http2Connection r2 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x0026 }
                r2.mo25037e(r1, r0)     // Catch:{ IOException -> 0x0026 }
                goto L_0x0026
            L_0x001b:
                r2 = move-exception
                r1 = r0
                goto L_0x002d
            L_0x001e:
                r1 = r0
            L_0x001f:
                okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR     // Catch:{ all -> 0x002c }
                okhttp3.internal.http2.Http2Connection r1 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x0026 }
                r1.mo25037e(r0, r0)     // Catch:{ IOException -> 0x0026 }
            L_0x0026:
                okhttp3.internal.http2.b r0 = r4.f21255a
                okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
                return
            L_0x002c:
                r2 = move-exception
            L_0x002d:
                okhttp3.internal.http2.Http2Connection r3 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x0032 }
                r3.mo25037e(r1, r0)     // Catch:{ IOException -> 0x0032 }
            L_0x0032:
                okhttp3.internal.http2.b r0 = r4.f21255a
                okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
                goto L_0x0039
            L_0x0038:
                throw r2
            L_0x0039:
                goto L_0x0038
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.C3945h.execute():void");
        }

        /* renamed from: f */
        public void mo25074f(boolean z, int i, int i2) {
            if (z) {
                synchronized (Http2Connection.this) {
                    boolean unused = Http2Connection.this.f21212k = false;
                    Http2Connection.this.notifyAll();
                }
                return;
            }
            try {
                Http2Connection.this.f21209h.execute(new C3944g(true, i, i2));
            } catch (RejectedExecutionException unused2) {
            }
        }

        /* renamed from: g */
        public void mo25075g(int i, int i2, int i3, boolean z) {
        }

        /* renamed from: h */
        public void mo25076h(int i, ErrorCode errorCode) {
            if (Http2Connection.this.mo25047n(i)) {
                Http2Connection.this.mo25045m(i, errorCode);
                return;
            }
            Http2Stream o = Http2Connection.this.mo25049o(i);
            if (o != null) {
                o.mo22352j(errorCode);
            }
        }

        /* renamed from: i */
        public void mo25077i(int i, int i2, List<Header> list) {
            Http2Connection.this.mo25044l(i2, list);
        }

        /* renamed from: j */
        public void mo25078j(int i, ErrorCode errorCode, ByteString byteString) {
            Http2Stream[] http2StreamArr;
            byteString.size();
            synchronized (Http2Connection.this) {
                http2StreamArr = (Http2Stream[]) Http2Connection.this.f21204c.values().toArray(new Http2Stream[Http2Connection.this.f21204c.size()]);
                Http2Connection.this.f21208g = true;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.getId() > i && http2Stream.isLocallyInitiated()) {
                    http2Stream.mo22352j(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.mo25049o(http2Stream.getId());
                }
            }
        }
    }

    static {
        Class<Http2Connection> cls = Http2Connection.class;
    }

    Http2Connection(Builder builder) {
        Builder builder2 = builder;
        Settings settings = new Settings();
        this.f21216o = settings;
        this.f21217p = false;
        this.f21221t = new LinkedHashSet();
        this.f21211j = builder2.f21227f;
        boolean z = builder2.f21228g;
        this.f21202a = z;
        this.f21203b = builder2.f21226e;
        int i = z ? 1 : 2;
        this.f21207f = i;
        if (z) {
            this.f21207f = i + 2;
        }
        if (z) {
            this.f21215n.mo25091i(7, 16777216);
        }
        String str = builder2.f21223b;
        this.f21205d = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(Util.format("OkHttp %s Writer", str), false));
        this.f21209h = scheduledThreadPoolExecutor;
        if (builder2.f21229h != 0) {
            C3944g gVar = new C3944g(false, 0, 0);
            int i2 = builder2.f21229h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(gVar, (long) i2, (long) i2, TimeUnit.MILLISECONDS);
        }
        this.f21210i = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(Util.format("OkHttp %s Push Observer", str), true));
        settings.mo25091i(7, SupportMenu.USER_MASK);
        settings.mo25091i(5, 16384);
        this.f21214m = (long) settings.mo25086d();
        this.f21218q = builder2.f21222a;
        this.f21219r = new C3956c(builder2.f21225d, z);
        this.f21220s = new C3945h(new C3953b(builder2.f21224c, z));
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m14274f() {
        try {
            ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
            mo25037e(errorCode, errorCode);
        } catch (IOException unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0041  */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.internal.http2.Http2Stream m14275h(int r11, java.util.List<okhttp3.internal.http2.Header> r12, boolean r13) {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            okhttp3.internal.http2.c r7 = r10.f21219r
            monitor-enter(r7)
            monitor-enter(r10)     // Catch:{ all -> 0x0076 }
            int r0 = r10.f21207f     // Catch:{ all -> 0x0073 }
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L_0x0013
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch:{ all -> 0x0073 }
            r10.shutdown(r0)     // Catch:{ all -> 0x0073 }
        L_0x0013:
            boolean r0 = r10.f21208g     // Catch:{ all -> 0x0073 }
            if (r0 != 0) goto L_0x006d
            int r8 = r10.f21207f     // Catch:{ all -> 0x0073 }
            int r0 = r8 + 2
            r10.f21207f = r0     // Catch:{ all -> 0x0073 }
            okhttp3.internal.http2.Http2Stream r9 = new okhttp3.internal.http2.Http2Stream     // Catch:{ all -> 0x0073 }
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0073 }
            if (r13 == 0) goto L_0x003a
            long r0 = r10.f21214m     // Catch:{ all -> 0x0073 }
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x003a
            long r0 = r9.f20101b     // Catch:{ all -> 0x0073 }
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            r13 = 0
            goto L_0x003b
        L_0x003a:
            r13 = 1
        L_0x003b:
            boolean r0 = r9.isOpen()     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x004a
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r0 = r10.f21204c     // Catch:{ all -> 0x0073 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0073 }
            r0.put(r1, r9)     // Catch:{ all -> 0x0073 }
        L_0x004a:
            monitor-exit(r10)     // Catch:{ all -> 0x0073 }
            if (r11 != 0) goto L_0x0053
            okhttp3.internal.http2.c r0 = r10.f21219r     // Catch:{ all -> 0x0076 }
            r0.mo25119n(r6, r8, r11, r12)     // Catch:{ all -> 0x0076 }
            goto L_0x005c
        L_0x0053:
            boolean r0 = r10.f21202a     // Catch:{ all -> 0x0076 }
            if (r0 != 0) goto L_0x0065
            okhttp3.internal.http2.c r0 = r10.f21219r     // Catch:{ all -> 0x0076 }
            r0.mo25115j(r11, r8, r12)     // Catch:{ all -> 0x0076 }
        L_0x005c:
            monitor-exit(r7)     // Catch:{ all -> 0x0076 }
            if (r13 == 0) goto L_0x0064
            okhttp3.internal.http2.c r11 = r10.f21219r
            r11.flush()
        L_0x0064:
            return r9
        L_0x0065:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0076 }
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch:{ all -> 0x0076 }
            throw r11     // Catch:{ all -> 0x0076 }
        L_0x006d:
            okhttp3.internal.http2.ConnectionShutdownException r11 = new okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x0073 }
            r11.<init>()     // Catch:{ all -> 0x0073 }
            throw r11     // Catch:{ all -> 0x0073 }
        L_0x0073:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0073 }
            throw r11     // Catch:{ all -> 0x0076 }
        L_0x0076:
            r11 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0076 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.m14275h(int, java.util.List, boolean):okhttp3.internal.http2.Http2Stream");
    }

    /* renamed from: j */
    private synchronized void m14276j(NamedRunnable namedRunnable) {
        if (!isShutdown()) {
            this.f21210i.execute(namedRunnable);
        }
    }

    public void close() {
        mo25037e(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo25037e(ErrorCode errorCode, ErrorCode errorCode2) {
        Http2Stream[] http2StreamArr = null;
        try {
            shutdown(errorCode);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            if (!this.f21204c.isEmpty()) {
                http2StreamArr = (Http2Stream[]) this.f21204c.values().toArray(new Http2Stream[this.f21204c.size()]);
                this.f21204c.clear();
            }
        }
        if (http2StreamArr != null) {
            for (Http2Stream close : http2StreamArr) {
                try {
                    close.close(errorCode2);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        try {
            this.f21219r.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.f21218q.close();
        } catch (IOException e4) {
            e = e4;
        }
        this.f21209h.shutdown();
        this.f21210i.shutdown();
        if (e != null) {
            throw e;
        }
    }

    public void flush() {
        this.f21219r.flush();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public synchronized Http2Stream mo25039g(int i) {
        return this.f21204c.get(Integer.valueOf(i));
    }

    public Protocol getProtocol() {
        return Protocol.HTTP_2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo25041i(int i, BufferedSource bufferedSource, int i2, boolean z) {
        Buffer buffer = new Buffer();
        long j = (long) i2;
        bufferedSource.require(j);
        bufferedSource.read(buffer, j);
        if (buffer.size() == j) {
            m14276j(new C3942e("OkHttp %s Push Data[%s]", new Object[]{this.f21205d, Integer.valueOf(i)}, i, buffer, i2, z));
            return;
        }
        throw new IOException(buffer.size() + " != " + i2);
    }

    public synchronized boolean isShutdown() {
        return this.f21208g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo25043k(int i, List<Header> list, boolean z) {
        try {
            m14276j(new C3941d("OkHttp %s Push Headers[%s]", new Object[]{this.f21205d, Integer.valueOf(i)}, i, list, z));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo25044l(int i, List<Header> list) {
        synchronized (this) {
            if (this.f21221t.contains(Integer.valueOf(i))) {
                mo25060u(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.f21221t.add(Integer.valueOf(i));
            try {
                m14276j(new C3940c("OkHttp %s Push Request[%s]", new Object[]{this.f21205d, Integer.valueOf(i)}, i, list));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo25045m(int i, ErrorCode errorCode) {
        m14276j(new C3943f("OkHttp %s Push Reset[%s]", new Object[]{this.f21205d, Integer.valueOf(i)}, i, errorCode));
    }

    public synchronized int maxConcurrentStreams() {
        return this.f21216o.mo25087e(Integer.MAX_VALUE);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public boolean mo25047n(int i) {
        return i != 0 && (i & 1) == 0;
    }

    public Http2Stream newStream(List<Header> list, boolean z) {
        return m14275h(0, list, z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public synchronized Http2Stream mo25049o(int i) {
        Http2Stream remove;
        remove = this.f21204c.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    public synchronized int openStreamCount() {
        return this.f21204c.size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public void mo25051p(boolean z) {
        if (z) {
            this.f21219r.mo25105b();
            this.f21219r.mo25117l(this.f21215n);
            int d = this.f21215n.mo25086d();
            if (d != 65535) {
                this.f21219r.mo25120o(0, (long) (d - SupportMenu.USER_MASK));
            }
        }
        new Thread(this.f21220s).start();
    }

    public Http2Stream pushStream(int i, List<Header> list, boolean z) {
        if (!this.f21202a) {
            return m14275h(i, list, z);
        }
        throw new IllegalStateException("Client cannot push requests.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public synchronized void mo25053q(long j) {
        long j2 = this.f21213l + j;
        this.f21213l = j2;
        if (j2 >= ((long) (this.f21215n.mo25086d() / 2))) {
            mo25061v(0, this.f21213l);
            this.f21213l = 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public void mo25054r(boolean z, int i, int i2) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.f21212k;
                this.f21212k = true;
            }
            if (z2) {
                m14274f();
                return;
            }
        }
        try {
            this.f21219r.mo25114i(z, i, i2);
        } catch (IOException unused) {
            m14274f();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public void mo25055s(int i, boolean z, List<Header> list) {
        this.f21219r.mo25118m(z, i, list);
    }

    public void setSettings(Settings settings) {
        synchronized (this.f21219r) {
            synchronized (this) {
                if (!this.f21208g) {
                    this.f21215n.mo25090h(settings);
                } else {
                    throw new ConnectionShutdownException();
                }
            }
            this.f21219r.mo25117l(settings);
        }
    }

    public void shutdown(ErrorCode errorCode) {
        synchronized (this.f21219r) {
            synchronized (this) {
                if (!this.f21208g) {
                    this.f21208g = true;
                    int i = this.f21206e;
                    this.f21219r.mo25110f(i, errorCode, Util.EMPTY_BYTE_ARRAY);
                }
            }
        }
    }

    public void start() {
        mo25051p(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public void mo25059t(int i, ErrorCode errorCode) {
        this.f21219r.mo25116k(i, errorCode);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public void mo25060u(int i, ErrorCode errorCode) {
        try {
            this.f21209h.execute(new C3938a("OkHttp %s stream %d", new Object[]{this.f21205d, Integer.valueOf(i)}, i, errorCode));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public void mo25061v(int i, long j) {
        try {
            this.f21209h.execute(new C3939b("OkHttp Window Update %s stream %d", new Object[]{this.f21205d, Integer.valueOf(i)}, i, j));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.f21219r.mo25113h());
        r6 = (long) r3;
        r8.f21214m -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0064, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0058 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeData(int r9, boolean r10, okio.Buffer r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x000d
            okhttp3.internal.http2.c r12 = r8.f21219r
            r12.mo25106c(r10, r9, r11, r0)
            return
        L_0x000d:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0067
            monitor-enter(r8)
        L_0x0012:
            long r3 = r8.f21214m     // Catch:{ InterruptedException -> 0x0058 }
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L_0x0030
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r3 = r8.f21204c     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x0058 }
            boolean r3 = r3.containsKey(r4)     // Catch:{ InterruptedException -> 0x0058 }
            if (r3 == 0) goto L_0x0028
            r8.wait()     // Catch:{ InterruptedException -> 0x0058 }
            goto L_0x0012
        L_0x0028:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x0058 }
            throw r9     // Catch:{ InterruptedException -> 0x0058 }
        L_0x0030:
            long r3 = java.lang.Math.min(r12, r3)     // Catch:{ all -> 0x0056 }
            int r4 = (int) r3     // Catch:{ all -> 0x0056 }
            okhttp3.internal.http2.c r3 = r8.f21219r     // Catch:{ all -> 0x0056 }
            int r3 = r3.mo25113h()     // Catch:{ all -> 0x0056 }
            int r3 = java.lang.Math.min(r4, r3)     // Catch:{ all -> 0x0056 }
            long r4 = r8.f21214m     // Catch:{ all -> 0x0056 }
            long r6 = (long) r3     // Catch:{ all -> 0x0056 }
            long r4 = r4 - r6
            r8.f21214m = r4     // Catch:{ all -> 0x0056 }
            monitor-exit(r8)     // Catch:{ all -> 0x0056 }
            long r12 = r12 - r6
            okhttp3.internal.http2.c r4 = r8.f21219r
            if (r10 == 0) goto L_0x0051
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x0051
            r5 = 1
            goto L_0x0052
        L_0x0051:
            r5 = 0
        L_0x0052:
            r4.mo25106c(r5, r9, r11, r3)
            goto L_0x000d
        L_0x0056:
            r9 = move-exception
            goto L_0x0065
        L_0x0058:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0056 }
            r9.interrupt()     // Catch:{ all -> 0x0056 }
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0056 }
            r9.<init>()     // Catch:{ all -> 0x0056 }
            throw r9     // Catch:{ all -> 0x0056 }
        L_0x0065:
            monitor-exit(r8)     // Catch:{ all -> 0x0056 }
            throw r9
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.writeData(int, boolean, okio.Buffer, long):void");
    }

    public static class Builder {

        /* renamed from: a */
        Socket f21222a;

        /* renamed from: b */
        String f21223b;

        /* renamed from: c */
        BufferedSource f21224c;

        /* renamed from: d */
        BufferedSink f21225d;

        /* renamed from: e */
        Listener f21226e = Listener.REFUSE_INCOMING_STREAMS;

        /* renamed from: f */
        PushObserver f21227f = PushObserver.CANCEL;

        /* renamed from: g */
        boolean f21228g;

        /* renamed from: h */
        int f21229h;

        public Builder(boolean z) {
            this.f21228g = z;
        }

        public Http2Connection build() {
            return new Http2Connection(this);
        }

        public Builder listener(Listener listener) {
            this.f21226e = listener;
            return this;
        }

        public Builder pingIntervalMillis(int i) {
            this.f21229h = i;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver) {
            this.f21227f = pushObserver;
            return this;
        }

        public Builder socket(Socket socket) {
            return socket(socket, ((InetSocketAddress) socket.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(socket)), Okio.buffer(Okio.sink(socket)));
        }

        public Builder socket(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.f21222a = socket;
            this.f21223b = str;
            this.f21224c = bufferedSource;
            this.f21225d = bufferedSink;
            return this;
        }
    }
}
