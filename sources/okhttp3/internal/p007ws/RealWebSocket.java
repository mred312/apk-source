package okhttp3.internal.p007ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.p007ws.WebSocketReader;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* renamed from: okhttp3.internal.ws.RealWebSocket */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {

    /* renamed from: x */
    private static final List<Protocol> f20148x = Collections.singletonList(Protocol.HTTP_1_1);

    /* renamed from: a */
    private final Request f20149a;

    /* renamed from: b */
    final WebSocketListener f20150b;

    /* renamed from: c */
    private final Random f20151c;

    /* renamed from: d */
    private final long f20152d;

    /* renamed from: e */
    private final String f20153e;

    /* renamed from: f */
    private Call f20154f;

    /* renamed from: g */
    private final Runnable f20155g;

    /* renamed from: h */
    private WebSocketReader f20156h;

    /* renamed from: i */
    private C3961a f20157i;

    /* renamed from: j */
    private ScheduledExecutorService f20158j;

    /* renamed from: k */
    private Streams f20159k;

    /* renamed from: l */
    private final ArrayDeque<ByteString> f20160l = new ArrayDeque<>();

    /* renamed from: m */
    private final ArrayDeque<Object> f20161m = new ArrayDeque<>();

    /* renamed from: n */
    private long f20162n;

    /* renamed from: o */
    private boolean f20163o;

    /* renamed from: p */
    private ScheduledFuture<?> f20164p;

    /* renamed from: q */
    private int f20165q = -1;

    /* renamed from: r */
    private String f20166r;

    /* renamed from: s */
    private boolean f20167s;

    /* renamed from: t */
    private int f20168t;

    /* renamed from: u */
    private int f20169u;

    /* renamed from: v */
    private int f20170v;

    /* renamed from: w */
    private boolean f20171w;

    /* renamed from: okhttp3.internal.ws.RealWebSocket$Streams */
    public static abstract class Streams implements Closeable {
        public final boolean client;
        public final BufferedSink sink;
        public final BufferedSource source;

        public Streams(boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.client = z;
            this.source = bufferedSource;
            this.sink = bufferedSink;
        }
    }

    /* renamed from: okhttp3.internal.ws.RealWebSocket$a */
    class C3563a implements Runnable {
        C3563a() {
        }

        public void run() {
            do {
                try {
                } catch (IOException e) {
                    RealWebSocket.this.failWebSocket(e, (Response) null);
                    return;
                }
            } while (RealWebSocket.this.mo22395e());
        }
    }

    /* renamed from: okhttp3.internal.ws.RealWebSocket$b */
    class C3564b implements Callback {

        /* renamed from: a */
        final /* synthetic */ Request f20173a;

        C3564b(Request request) {
            this.f20173a = request;
        }

        public void onFailure(Call call, IOException iOException) {
            RealWebSocket.this.failWebSocket(iOException, (Response) null);
        }

        public void onResponse(Call call, Response response) {
            try {
                RealWebSocket.this.mo22392a(response);
                StreamAllocation streamAllocation = Internal.instance.streamAllocation(call);
                streamAllocation.noNewStreams();
                Streams newWebSocketStreams = streamAllocation.connection().newWebSocketStreams(streamAllocation);
                try {
                    RealWebSocket realWebSocket = RealWebSocket.this;
                    realWebSocket.f20150b.onOpen(realWebSocket, response);
                    RealWebSocket.this.initReaderAndWriter("OkHttp WebSocket " + this.f20173a.url().redact(), newWebSocketStreams);
                    streamAllocation.connection().socket().setSoTimeout(0);
                    RealWebSocket.this.loopReader();
                } catch (Exception e) {
                    RealWebSocket.this.failWebSocket(e, (Response) null);
                }
            } catch (ProtocolException e2) {
                RealWebSocket.this.failWebSocket(e2, response);
                Util.closeQuietly((Closeable) response);
            }
        }
    }

    /* renamed from: okhttp3.internal.ws.RealWebSocket$c */
    final class C3565c implements Runnable {
        C3565c() {
        }

        public void run() {
            RealWebSocket.this.cancel();
        }
    }

    /* renamed from: okhttp3.internal.ws.RealWebSocket$d */
    static final class C3566d {

        /* renamed from: a */
        final int f20176a;

        /* renamed from: b */
        final ByteString f20177b;

        /* renamed from: c */
        final long f20178c;

        C3566d(int i, ByteString byteString, long j) {
            this.f20176a = i;
            this.f20177b = byteString;
            this.f20178c = j;
        }
    }

    /* renamed from: okhttp3.internal.ws.RealWebSocket$e */
    static final class C3567e {

        /* renamed from: a */
        final int f20179a;

        /* renamed from: b */
        final ByteString f20180b;

        C3567e(int i, ByteString byteString) {
            this.f20179a = i;
            this.f20180b = byteString;
        }
    }

    /* renamed from: okhttp3.internal.ws.RealWebSocket$f */
    private final class C3568f implements Runnable {
        C3568f() {
        }

        public void run() {
            RealWebSocket.this.mo22396f();
        }
    }

    public RealWebSocket(Request request, WebSocketListener webSocketListener, Random random, long j) {
        if ("GET".equals(request.method())) {
            this.f20149a = request;
            this.f20150b = webSocketListener;
            this.f20151c = random;
            this.f20152d = j;
            byte[] bArr = new byte[16];
            random.nextBytes(bArr);
            this.f20153e = ByteString.m12083of(bArr).base64();
            this.f20155g = new C3563a();
            return;
        }
        throw new IllegalArgumentException("Request must be GET: " + request.method());
    }

    /* renamed from: c */
    private void m12059c() {
        ScheduledExecutorService scheduledExecutorService = this.f20158j;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(this.f20155g);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        return false;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean m12060d(okio.ByteString r7, int r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.f20167s     // Catch:{ all -> 0x003e }
            r1 = 0
            if (r0 != 0) goto L_0x003c
            boolean r0 = r6.f20163o     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x000b
            goto L_0x003c
        L_0x000b:
            long r2 = r6.f20162n     // Catch:{ all -> 0x003e }
            int r0 = r7.size()     // Catch:{ all -> 0x003e }
            long r4 = (long) r0     // Catch:{ all -> 0x003e }
            long r2 = r2 + r4
            r4 = 16777216(0x1000000, double:8.289046E-317)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0022
            r7 = 1001(0x3e9, float:1.403E-42)
            r8 = 0
            r6.close(r7, r8)     // Catch:{ all -> 0x003e }
            monitor-exit(r6)
            return r1
        L_0x0022:
            long r0 = r6.f20162n     // Catch:{ all -> 0x003e }
            int r2 = r7.size()     // Catch:{ all -> 0x003e }
            long r2 = (long) r2     // Catch:{ all -> 0x003e }
            long r0 = r0 + r2
            r6.f20162n = r0     // Catch:{ all -> 0x003e }
            java.util.ArrayDeque<java.lang.Object> r0 = r6.f20161m     // Catch:{ all -> 0x003e }
            okhttp3.internal.ws.RealWebSocket$e r1 = new okhttp3.internal.ws.RealWebSocket$e     // Catch:{ all -> 0x003e }
            r1.<init>(r8, r7)     // Catch:{ all -> 0x003e }
            r0.add(r1)     // Catch:{ all -> 0x003e }
            r6.m12059c()     // Catch:{ all -> 0x003e }
            r7 = 1
            monitor-exit(r6)
            return r7
        L_0x003c:
            monitor-exit(r6)
            return r1
        L_0x003e:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p007ws.RealWebSocket.m12060d(okio.ByteString, int):boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo22392a(Response response) {
        if (response.code() == 101) {
            String header = response.header("Connection");
            if ("Upgrade".equalsIgnoreCase(header)) {
                String header2 = response.header("Upgrade");
                if ("websocket".equalsIgnoreCase(header2)) {
                    String header3 = response.header("Sec-WebSocket-Accept");
                    String base64 = ByteString.encodeUtf8(this.f20153e + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
                    if (!base64.equals(header3)) {
                        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + header3 + "'");
                    }
                    return;
                }
                throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header2 + "'");
            }
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header + "'");
        }
        throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + " " + response.message() + "'");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized boolean mo22393b(int i, String str, long j) {
        WebSocketProtocol.m14406c(i);
        ByteString byteString = null;
        if (str != null) {
            byteString = ByteString.encodeUtf8(str);
            if (((long) byteString.size()) > 123) {
                throw new IllegalArgumentException("reason.size() > 123: " + str);
            }
        }
        if (!this.f20167s) {
            if (!this.f20163o) {
                this.f20163o = true;
                this.f20161m.add(new C3566d(i, byteString, j));
                m12059c();
                return true;
            }
        }
        return false;
    }

    public void cancel() {
        this.f20154f.cancel();
    }

    public boolean close(int i, String str) {
        return mo22393b(i, str, 60000);
    }

    public void connect(OkHttpClient okHttpClient) {
        OkHttpClient build = okHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(f20148x).build();
        Request build2 = this.f20149a.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.f20153e).header("Sec-WebSocket-Version", "13").build();
        Call newWebSocketCall = Internal.instance.newWebSocketCall(build, build2);
        this.f20154f = newWebSocketCall;
        newWebSocketCall.timeout().clearTimeout();
        this.f20154f.enqueue(new C3564b(build2));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        if (r2 == null) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r0.mo25152f(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005e, code lost:
        if ((r4 instanceof okhttp3.internal.p007ws.RealWebSocket.C3567e) == false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0060, code lost:
        r2 = ((okhttp3.internal.p007ws.RealWebSocket.C3567e) r4).f20180b;
        r0 = okio.Okio.buffer(r0.mo25148a(((okhttp3.internal.p007ws.RealWebSocket.C3567e) r4).f20179a, (long) r2.size()));
        r0.write(r2);
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007c, code lost:
        monitor-enter(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r12.f20162n -= (long) r2.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0087, code lost:
        monitor-exit(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008e, code lost:
        if ((r4 instanceof okhttp3.internal.p007ws.RealWebSocket.C3566d) == false) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0090, code lost:
        r4 = (okhttp3.internal.p007ws.RealWebSocket.C3566d) r4;
        r0.mo25149b(r4.f20176a, r4.f20177b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0099, code lost:
        if (r1 == null) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009b, code lost:
        r12.f20150b.onClosed(r12, r3, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a0, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a4, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00aa, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ab, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ac, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00af, code lost:
        throw r0;
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo22395e() {
        /*
            r12 = this;
            monitor-enter(r12)
            boolean r0 = r12.f20167s     // Catch:{ all -> 0x00b0 }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r12)     // Catch:{ all -> 0x00b0 }
            return r1
        L_0x0008:
            okhttp3.internal.ws.a r0 = r12.f20157i     // Catch:{ all -> 0x00b0 }
            java.util.ArrayDeque<okio.ByteString> r2 = r12.f20160l     // Catch:{ all -> 0x00b0 }
            java.lang.Object r2 = r2.poll()     // Catch:{ all -> 0x00b0 }
            okio.ByteString r2 = (okio.ByteString) r2     // Catch:{ all -> 0x00b0 }
            r3 = -1
            r4 = 0
            if (r2 != 0) goto L_0x0053
            java.util.ArrayDeque<java.lang.Object> r5 = r12.f20161m     // Catch:{ all -> 0x00b0 }
            java.lang.Object r5 = r5.poll()     // Catch:{ all -> 0x00b0 }
            boolean r6 = r5 instanceof okhttp3.internal.p007ws.RealWebSocket.C3566d     // Catch:{ all -> 0x00b0 }
            if (r6 == 0) goto L_0x004b
            int r1 = r12.f20165q     // Catch:{ all -> 0x00b0 }
            java.lang.String r6 = r12.f20166r     // Catch:{ all -> 0x00b0 }
            if (r1 == r3) goto L_0x0034
            okhttp3.internal.ws.RealWebSocket$Streams r3 = r12.f20159k     // Catch:{ all -> 0x00b0 }
            r12.f20159k = r4     // Catch:{ all -> 0x00b0 }
            java.util.concurrent.ScheduledExecutorService r4 = r12.f20158j     // Catch:{ all -> 0x00b0 }
            r4.shutdown()     // Catch:{ all -> 0x00b0 }
            r4 = r5
            r11 = r3
            r3 = r1
            r1 = r11
            goto L_0x0055
        L_0x0034:
            java.util.concurrent.ScheduledExecutorService r3 = r12.f20158j     // Catch:{ all -> 0x00b0 }
            okhttp3.internal.ws.RealWebSocket$c r7 = new okhttp3.internal.ws.RealWebSocket$c     // Catch:{ all -> 0x00b0 }
            r7.<init>()     // Catch:{ all -> 0x00b0 }
            r8 = r5
            okhttp3.internal.ws.RealWebSocket$d r8 = (okhttp3.internal.p007ws.RealWebSocket.C3566d) r8     // Catch:{ all -> 0x00b0 }
            long r8 = r8.f20178c     // Catch:{ all -> 0x00b0 }
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00b0 }
            java.util.concurrent.ScheduledFuture r3 = r3.schedule(r7, r8, r10)     // Catch:{ all -> 0x00b0 }
            r12.f20164p = r3     // Catch:{ all -> 0x00b0 }
            r3 = r1
            r1 = r4
            goto L_0x0051
        L_0x004b:
            if (r5 != 0) goto L_0x004f
            monitor-exit(r12)     // Catch:{ all -> 0x00b0 }
            return r1
        L_0x004f:
            r1 = r4
            r6 = r1
        L_0x0051:
            r4 = r5
            goto L_0x0055
        L_0x0053:
            r1 = r4
            r6 = r1
        L_0x0055:
            monitor-exit(r12)     // Catch:{ all -> 0x00b0 }
            if (r2 == 0) goto L_0x005c
            r0.mo25152f(r2)     // Catch:{ all -> 0x00ab }
            goto L_0x00a0
        L_0x005c:
            boolean r2 = r4 instanceof okhttp3.internal.p007ws.RealWebSocket.C3567e     // Catch:{ all -> 0x00ab }
            if (r2 == 0) goto L_0x008c
            r2 = r4
            okhttp3.internal.ws.RealWebSocket$e r2 = (okhttp3.internal.p007ws.RealWebSocket.C3567e) r2     // Catch:{ all -> 0x00ab }
            okio.ByteString r2 = r2.f20180b     // Catch:{ all -> 0x00ab }
            okhttp3.internal.ws.RealWebSocket$e r4 = (okhttp3.internal.p007ws.RealWebSocket.C3567e) r4     // Catch:{ all -> 0x00ab }
            int r3 = r4.f20179a     // Catch:{ all -> 0x00ab }
            int r4 = r2.size()     // Catch:{ all -> 0x00ab }
            long r4 = (long) r4     // Catch:{ all -> 0x00ab }
            okio.Sink r0 = r0.mo25148a(r3, r4)     // Catch:{ all -> 0x00ab }
            okio.BufferedSink r0 = okio.Okio.buffer((okio.Sink) r0)     // Catch:{ all -> 0x00ab }
            r0.write((okio.ByteString) r2)     // Catch:{ all -> 0x00ab }
            r0.close()     // Catch:{ all -> 0x00ab }
            monitor-enter(r12)     // Catch:{ all -> 0x00ab }
            long r3 = r12.f20162n     // Catch:{ all -> 0x0089 }
            int r0 = r2.size()     // Catch:{ all -> 0x0089 }
            long r5 = (long) r0     // Catch:{ all -> 0x0089 }
            long r3 = r3 - r5
            r12.f20162n = r3     // Catch:{ all -> 0x0089 }
            monitor-exit(r12)     // Catch:{ all -> 0x0089 }
            goto L_0x00a0
        L_0x0089:
            r0 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x0089 }
            throw r0     // Catch:{ all -> 0x00ab }
        L_0x008c:
            boolean r2 = r4 instanceof okhttp3.internal.p007ws.RealWebSocket.C3566d     // Catch:{ all -> 0x00ab }
            if (r2 == 0) goto L_0x00a5
            okhttp3.internal.ws.RealWebSocket$d r4 = (okhttp3.internal.p007ws.RealWebSocket.C3566d) r4     // Catch:{ all -> 0x00ab }
            int r2 = r4.f20176a     // Catch:{ all -> 0x00ab }
            okio.ByteString r4 = r4.f20177b     // Catch:{ all -> 0x00ab }
            r0.mo25149b(r2, r4)     // Catch:{ all -> 0x00ab }
            if (r1 == 0) goto L_0x00a0
            okhttp3.WebSocketListener r0 = r12.f20150b     // Catch:{ all -> 0x00ab }
            r0.onClosed(r12, r3, r6)     // Catch:{ all -> 0x00ab }
        L_0x00a0:
            r0 = 1
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1)
            return r0
        L_0x00a5:
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch:{ all -> 0x00ab }
            r0.<init>()     // Catch:{ all -> 0x00ab }
            throw r0     // Catch:{ all -> 0x00ab }
        L_0x00ab:
            r0 = move-exception
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1)
            throw r0
        L_0x00b0:
            r0 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x00b0 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p007ws.RealWebSocket.mo22395e():boolean");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        if (r1 == -1) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        failWebSocket(new java.net.SocketTimeoutException("sent ping but didn't receive pong within " + r7.f20152d + "ms (after " + (r1 - 1) + " successful ping/pongs)"), (okhttp3.Response) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0.mo25151e(okio.ByteString.EMPTY);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004f, code lost:
        failWebSocket(r0, (okhttp3.Response) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo22396f() {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.f20167s     // Catch:{ all -> 0x0053 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r7)     // Catch:{ all -> 0x0053 }
            return
        L_0x0007:
            okhttp3.internal.ws.a r0 = r7.f20157i     // Catch:{ all -> 0x0053 }
            boolean r1 = r7.f20171w     // Catch:{ all -> 0x0053 }
            r2 = -1
            if (r1 == 0) goto L_0x0011
            int r1 = r7.f20168t     // Catch:{ all -> 0x0053 }
            goto L_0x0012
        L_0x0011:
            r1 = -1
        L_0x0012:
            int r3 = r7.f20168t     // Catch:{ all -> 0x0053 }
            r4 = 1
            int r3 = r3 + r4
            r7.f20168t = r3     // Catch:{ all -> 0x0053 }
            r7.f20171w = r4     // Catch:{ all -> 0x0053 }
            monitor-exit(r7)     // Catch:{ all -> 0x0053 }
            r3 = 0
            if (r1 == r2) goto L_0x0048
            java.net.SocketTimeoutException r0 = new java.net.SocketTimeoutException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "sent ping but didn't receive pong within "
            r2.append(r5)
            long r5 = r7.f20152d
            r2.append(r5)
            java.lang.String r5 = "ms (after "
            r2.append(r5)
            int r1 = r1 - r4
            r2.append(r1)
            java.lang.String r1 = " successful ping/pongs)"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            r7.failWebSocket(r0, r3)
            return
        L_0x0048:
            okio.ByteString r1 = okio.ByteString.EMPTY     // Catch:{ IOException -> 0x004e }
            r0.mo25151e(r1)     // Catch:{ IOException -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r0 = move-exception
            r7.failWebSocket(r0, r3)
        L_0x0052:
            return
        L_0x0053:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0053 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p007ws.RealWebSocket.mo22396f():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r3.f20150b.onFailure(r3, r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0028, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002c, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void failWebSocket(java.lang.Exception r4, @javax.annotation.Nullable okhttp3.Response r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.f20167s     // Catch:{ all -> 0x002d }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)     // Catch:{ all -> 0x002d }
            return
        L_0x0007:
            r0 = 1
            r3.f20167s = r0     // Catch:{ all -> 0x002d }
            okhttp3.internal.ws.RealWebSocket$Streams r0 = r3.f20159k     // Catch:{ all -> 0x002d }
            r1 = 0
            r3.f20159k = r1     // Catch:{ all -> 0x002d }
            java.util.concurrent.ScheduledFuture<?> r1 = r3.f20164p     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x0017
            r2 = 0
            r1.cancel(r2)     // Catch:{ all -> 0x002d }
        L_0x0017:
            java.util.concurrent.ScheduledExecutorService r1 = r3.f20158j     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x001e
            r1.shutdown()     // Catch:{ all -> 0x002d }
        L_0x001e:
            monitor-exit(r3)     // Catch:{ all -> 0x002d }
            okhttp3.WebSocketListener r1 = r3.f20150b     // Catch:{ all -> 0x0028 }
            r1.onFailure(r3, r4, r5)     // Catch:{ all -> 0x0028 }
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
            return
        L_0x0028:
            r4 = move-exception
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
            throw r4
        L_0x002d:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x002d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p007ws.RealWebSocket.failWebSocket(java.lang.Exception, okhttp3.Response):void");
    }

    public void initReaderAndWriter(String str, Streams streams) {
        synchronized (this) {
            this.f20159k = streams;
            this.f20157i = new C3961a(streams.client, streams.sink, this.f20151c);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(str, false));
            this.f20158j = scheduledThreadPoolExecutor;
            long j = this.f20152d;
            if (j != 0) {
                scheduledThreadPoolExecutor.scheduleAtFixedRate(new C3568f(), j, j, TimeUnit.MILLISECONDS);
            }
            if (!this.f20161m.isEmpty()) {
                m12059c();
            }
        }
        this.f20156h = new WebSocketReader(streams.client, streams.source, this);
    }

    public void loopReader() {
        while (this.f20165q == -1) {
            this.f20156h.mo25147a();
        }
    }

    public void onReadClose(int i, String str) {
        Streams streams;
        if (i != -1) {
            synchronized (this) {
                if (this.f20165q == -1) {
                    this.f20165q = i;
                    this.f20166r = str;
                    streams = null;
                    if (this.f20163o && this.f20161m.isEmpty()) {
                        Streams streams2 = this.f20159k;
                        this.f20159k = streams;
                        ScheduledFuture<?> scheduledFuture = this.f20164p;
                        if (scheduledFuture != null) {
                            scheduledFuture.cancel(false);
                        }
                        this.f20158j.shutdown();
                        streams = streams2;
                    }
                } else {
                    throw new IllegalStateException("already closed");
                }
            }
            try {
                this.f20150b.onClosing(this, i, str);
                if (streams != null) {
                    this.f20150b.onClosed(this, i, str);
                }
            } finally {
                Util.closeQuietly((Closeable) streams);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void onReadMessage(String str) {
        this.f20150b.onMessage((WebSocket) this, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onReadPing(okio.ByteString r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f20167s     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0022
            boolean r0 = r1.f20163o     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0012
            java.util.ArrayDeque<java.lang.Object> r0 = r1.f20161m     // Catch:{ all -> 0x0024 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0012
            goto L_0x0022
        L_0x0012:
            java.util.ArrayDeque<okio.ByteString> r0 = r1.f20160l     // Catch:{ all -> 0x0024 }
            r0.add(r2)     // Catch:{ all -> 0x0024 }
            r1.m12059c()     // Catch:{ all -> 0x0024 }
            int r2 = r1.f20169u     // Catch:{ all -> 0x0024 }
            int r2 = r2 + 1
            r1.f20169u = r2     // Catch:{ all -> 0x0024 }
            monitor-exit(r1)
            return
        L_0x0022:
            monitor-exit(r1)
            return
        L_0x0024:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p007ws.RealWebSocket.onReadPing(okio.ByteString):void");
    }

    public synchronized void onReadPong(ByteString byteString) {
        this.f20170v++;
        this.f20171w = false;
    }

    public synchronized long queueSize() {
        return this.f20162n;
    }

    public Request request() {
        return this.f20149a;
    }

    public boolean send(String str) {
        if (str != null) {
            return m12060d(ByteString.encodeUtf8(str), 1);
        }
        throw new NullPointerException("text == null");
    }

    public void onReadMessage(ByteString byteString) {
        this.f20150b.onMessage((WebSocket) this, byteString);
    }

    public boolean send(ByteString byteString) {
        if (byteString != null) {
            return m12060d(byteString, 2);
        }
        throw new NullPointerException("bytes == null");
    }
}
