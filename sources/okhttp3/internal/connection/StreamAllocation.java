package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.HttpCodec;

public final class StreamAllocation {

    /* renamed from: a */
    private RouteSelector.Selection f21127a;
    public final Address address;

    /* renamed from: b */
    private Route f21128b;

    /* renamed from: c */
    private final ConnectionPool f21129c;
    public final Call call;

    /* renamed from: d */
    private final Object f21130d;

    /* renamed from: e */
    private final RouteSelector f21131e;
    public final EventListener eventListener;

    /* renamed from: f */
    private int f21132f;

    /* renamed from: g */
    private RealConnection f21133g;

    /* renamed from: h */
    private boolean f21134h;

    /* renamed from: i */
    private boolean f21135i;

    /* renamed from: j */
    private boolean f21136j;

    /* renamed from: k */
    private HttpCodec f21137k;

    public static final class StreamAllocationReference extends WeakReference<StreamAllocation> {
        public final Object callStackTrace;

        StreamAllocationReference(StreamAllocation streamAllocation, Object obj) {
            super(streamAllocation);
            this.callStackTrace = obj;
        }
    }

    public StreamAllocation(ConnectionPool connectionPool, Address address2, Call call2, EventListener eventListener2, Object obj) {
        this.f21129c = connectionPool;
        this.address = address2;
        this.call = call2;
        this.eventListener = eventListener2;
        this.f21131e = new RouteSelector(address2, m14242f(), call2, eventListener2);
        this.f21130d = obj;
    }

    /* renamed from: a */
    private Socket m14237a(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (z3) {
            this.f21137k = null;
        }
        if (z2) {
            this.f21135i = true;
        }
        RealConnection realConnection = this.f21133g;
        if (realConnection == null) {
            return null;
        }
        if (z) {
            realConnection.noNewStreams = true;
        }
        if (this.f21137k != null) {
            return null;
        }
        if (!this.f21135i && !realConnection.noNewStreams) {
            return null;
        }
        m14240d(realConnection);
        if (this.f21133g.allocations.isEmpty()) {
            this.f21133g.idleAtNanos = System.nanoTime();
            if (Internal.instance.connectionBecameIdle(this.f21129c, this.f21133g)) {
                socket = this.f21133g.socket();
                this.f21133g = null;
                return socket;
            }
        }
        socket = null;
        this.f21133g = null;
        return socket;
    }

    /* renamed from: b */
    private RealConnection m14238b(int i, int i2, int i3, int i4, boolean z) {
        RealConnection realConnection;
        Socket e;
        RealConnection realConnection2;
        Socket socket;
        boolean z2;
        Route route;
        boolean z3;
        RouteSelector.Selection selection;
        synchronized (this.f21129c) {
            if (this.f21135i) {
                throw new IllegalStateException("released");
            } else if (this.f21137k != null) {
                throw new IllegalStateException("codec != null");
            } else if (!this.f21136j) {
                realConnection = this.f21133g;
                e = m14241e();
                realConnection2 = this.f21133g;
                socket = null;
                if (realConnection2 != null) {
                    realConnection = null;
                } else {
                    realConnection2 = null;
                }
                if (!this.f21134h) {
                    realConnection = null;
                }
                if (realConnection2 == null) {
                    Internal.instance.get(this.f21129c, this.address, this, (Route) null);
                    RealConnection realConnection3 = this.f21133g;
                    if (realConnection3 != null) {
                        realConnection2 = realConnection3;
                        z2 = true;
                        route = null;
                    } else {
                        route = this.f21128b;
                    }
                } else {
                    route = null;
                }
                z2 = false;
            } else {
                throw new IOException("Canceled");
            }
        }
        Util.closeQuietly(e);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (z2) {
            this.eventListener.connectionAcquired(this.call, realConnection2);
        }
        if (realConnection2 != null) {
            return realConnection2;
        }
        if (route != null || ((selection = this.f21127a) != null && selection.hasNext())) {
            z3 = false;
        } else {
            this.f21127a = this.f21131e.next();
            z3 = true;
        }
        synchronized (this.f21129c) {
            if (!this.f21136j) {
                if (z3) {
                    List<Route> all = this.f21127a.getAll();
                    int size = all.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size) {
                            break;
                        }
                        Route route2 = all.get(i5);
                        Internal.instance.get(this.f21129c, this.address, this, route2);
                        RealConnection realConnection4 = this.f21133g;
                        if (realConnection4 != null) {
                            this.f21128b = route2;
                            realConnection2 = realConnection4;
                            z2 = true;
                            break;
                        }
                        i5++;
                    }
                }
                if (!z2) {
                    if (route == null) {
                        route = this.f21127a.next();
                    }
                    this.f21128b = route;
                    this.f21132f = 0;
                    realConnection2 = new RealConnection(this.f21129c, route);
                    acquire(realConnection2, false);
                }
            } else {
                throw new IOException("Canceled");
            }
        }
        if (z2) {
            this.eventListener.connectionAcquired(this.call, realConnection2);
            return realConnection2;
        }
        realConnection2.connect(i, i2, i3, i4, z, this.call, this.eventListener);
        m14242f().connected(realConnection2.route());
        synchronized (this.f21129c) {
            this.f21134h = true;
            Internal.instance.put(this.f21129c, realConnection2);
            if (realConnection2.isMultiplexed()) {
                socket = Internal.instance.deduplicate(this.f21129c, this.address, this);
                realConnection2 = this.f21133g;
            }
        }
        Util.closeQuietly(socket);
        this.eventListener.connectionAcquired(this.call, realConnection2);
        return realConnection2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0.isHealthy(r9) != false) goto L_0x0018;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.internal.connection.RealConnection m14239c(int r4, int r5, int r6, int r7, boolean r8, boolean r9) {
        /*
            r3 = this;
        L_0x0000:
            okhttp3.internal.connection.RealConnection r0 = r3.m14238b(r4, r5, r6, r7, r8)
            okhttp3.ConnectionPool r1 = r3.f21129c
            monitor-enter(r1)
            int r2 = r0.successCount     // Catch:{ all -> 0x0019 }
            if (r2 != 0) goto L_0x000d
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            return r0
        L_0x000d:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            boolean r1 = r0.isHealthy(r9)
            if (r1 != 0) goto L_0x0018
            r3.noNewStreams()
            goto L_0x0000
        L_0x0018:
            return r0
        L_0x0019:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            goto L_0x001d
        L_0x001c:
            throw r4
        L_0x001d:
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.StreamAllocation.m14239c(int, int, int, int, boolean, boolean):okhttp3.internal.connection.RealConnection");
    }

    /* renamed from: d */
    private void m14240d(RealConnection realConnection) {
        int size = realConnection.allocations.size();
        for (int i = 0; i < size; i++) {
            if (realConnection.allocations.get(i).get() == this) {
                realConnection.allocations.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    /* renamed from: e */
    private Socket m14241e() {
        RealConnection realConnection = this.f21133g;
        if (realConnection == null || !realConnection.noNewStreams) {
            return null;
        }
        return m14237a(false, false, true);
    }

    /* renamed from: f */
    private RouteDatabase m14242f() {
        return Internal.instance.routeDatabase(this.f21129c);
    }

    public void acquire(RealConnection realConnection, boolean z) {
        if (this.f21133g == null) {
            this.f21133g = realConnection;
            this.f21134h = z;
            realConnection.allocations.add(new StreamAllocationReference(this, this.f21130d));
            return;
        }
        throw new IllegalStateException();
    }

    public void cancel() {
        HttpCodec httpCodec;
        RealConnection realConnection;
        synchronized (this.f21129c) {
            this.f21136j = true;
            httpCodec = this.f21137k;
            realConnection = this.f21133g;
        }
        if (httpCodec != null) {
            httpCodec.cancel();
        } else if (realConnection != null) {
            realConnection.cancel();
        }
    }

    public HttpCodec codec() {
        HttpCodec httpCodec;
        synchronized (this.f21129c) {
            httpCodec = this.f21137k;
        }
        return httpCodec;
    }

    public synchronized RealConnection connection() {
        return this.f21133g;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f21127a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasMoreRoutes() {
        /*
            r1 = this;
            okhttp3.Route r0 = r1.f21128b
            if (r0 != 0) goto L_0x0019
            okhttp3.internal.connection.RouteSelector$Selection r0 = r1.f21127a
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto L_0x0019
        L_0x000e:
            okhttp3.internal.connection.RouteSelector r0 = r1.f21131e
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r0 = 0
            goto L_0x001a
        L_0x0019:
            r0 = 1
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.StreamAllocation.hasMoreRoutes():boolean");
    }

    public HttpCodec newStream(OkHttpClient okHttpClient, Interceptor.Chain chain, boolean z) {
        try {
            HttpCodec newCodec = m14239c(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z).newCodec(okHttpClient, chain, this);
            synchronized (this.f21129c) {
                this.f21137k = newCodec;
            }
            return newCodec;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    public void noNewStreams() {
        RealConnection realConnection;
        Socket a;
        synchronized (this.f21129c) {
            realConnection = this.f21133g;
            a = m14237a(true, false, false);
            if (this.f21133g != null) {
                realConnection = null;
            }
        }
        Util.closeQuietly(a);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
    }

    public void release() {
        RealConnection realConnection;
        Socket a;
        synchronized (this.f21129c) {
            realConnection = this.f21133g;
            a = m14237a(false, true, false);
            if (this.f21133g != null) {
                realConnection = null;
            }
        }
        Util.closeQuietly(a);
        if (realConnection != null) {
            Internal.instance.timeoutExit(this.call, (IOException) null);
            this.eventListener.connectionReleased(this.call, realConnection);
            this.eventListener.callEnd(this.call);
        }
    }

    public Socket releaseAndAcquire(RealConnection realConnection) {
        if (this.f21137k == null && this.f21133g.allocations.size() == 1) {
            Socket a = m14237a(true, false, false);
            this.f21133g = realConnection;
            realConnection.allocations.add(this.f21133g.allocations.get(0));
            return a;
        }
        throw new IllegalStateException();
    }

    public Route route() {
        return this.f21128b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void streamFailed(java.io.IOException r7) {
        /*
            r6 = this;
            okhttp3.ConnectionPool r0 = r6.f21129c
            monitor-enter(r0)
            boolean r1 = r7 instanceof okhttp3.internal.http2.StreamResetException     // Catch:{ all -> 0x0065 }
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0023
            okhttp3.internal.http2.StreamResetException r7 = (okhttp3.internal.http2.StreamResetException) r7     // Catch:{ all -> 0x0065 }
            okhttp3.internal.http2.ErrorCode r7 = r7.errorCode     // Catch:{ all -> 0x0065 }
            okhttp3.internal.http2.ErrorCode r1 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch:{ all -> 0x0065 }
            if (r7 != r1) goto L_0x001c
            int r7 = r6.f21132f     // Catch:{ all -> 0x0065 }
            int r7 = r7 + r4
            r6.f21132f = r7     // Catch:{ all -> 0x0065 }
            if (r7 <= r4) goto L_0x0046
            r6.f21128b = r3     // Catch:{ all -> 0x0065 }
            goto L_0x0044
        L_0x001c:
            okhttp3.internal.http2.ErrorCode r1 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch:{ all -> 0x0065 }
            if (r7 == r1) goto L_0x0046
            r6.f21128b = r3     // Catch:{ all -> 0x0065 }
            goto L_0x0044
        L_0x0023:
            okhttp3.internal.connection.RealConnection r1 = r6.f21133g     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0046
            boolean r1 = r1.isMultiplexed()     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0031
            boolean r1 = r7 instanceof okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0046
        L_0x0031:
            okhttp3.internal.connection.RealConnection r1 = r6.f21133g     // Catch:{ all -> 0x0065 }
            int r1 = r1.successCount     // Catch:{ all -> 0x0065 }
            if (r1 != 0) goto L_0x0044
            okhttp3.Route r1 = r6.f21128b     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0042
            if (r7 == 0) goto L_0x0042
            okhttp3.internal.connection.RouteSelector r5 = r6.f21131e     // Catch:{ all -> 0x0065 }
            r5.connectFailed(r1, r7)     // Catch:{ all -> 0x0065 }
        L_0x0042:
            r6.f21128b = r3     // Catch:{ all -> 0x0065 }
        L_0x0044:
            r7 = 1
            goto L_0x0047
        L_0x0046:
            r7 = 0
        L_0x0047:
            okhttp3.internal.connection.RealConnection r1 = r6.f21133g     // Catch:{ all -> 0x0065 }
            java.net.Socket r7 = r6.m14237a(r7, r2, r4)     // Catch:{ all -> 0x0065 }
            okhttp3.internal.connection.RealConnection r2 = r6.f21133g     // Catch:{ all -> 0x0065 }
            if (r2 != 0) goto L_0x0057
            boolean r2 = r6.f21134h     // Catch:{ all -> 0x0065 }
            if (r2 != 0) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r3 = r1
        L_0x0057:
            monitor-exit(r0)     // Catch:{ all -> 0x0065 }
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r7)
            if (r3 == 0) goto L_0x0064
            okhttp3.EventListener r7 = r6.eventListener
            okhttp3.Call r0 = r6.call
            r7.connectionReleased(r0, r3)
        L_0x0064:
            return
        L_0x0065:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0065 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.StreamAllocation.streamFailed(java.io.IOException):void");
    }

    public void streamFinished(boolean z, HttpCodec httpCodec, long j, IOException iOException) {
        RealConnection realConnection;
        Socket a;
        boolean z2;
        this.eventListener.responseBodyEnd(this.call, j);
        synchronized (this.f21129c) {
            if (httpCodec != null) {
                if (httpCodec == this.f21137k) {
                    if (!z) {
                        this.f21133g.successCount++;
                    }
                    realConnection = this.f21133g;
                    a = m14237a(z, false, true);
                    if (this.f21133g != null) {
                        realConnection = null;
                    }
                    z2 = this.f21135i;
                }
            }
            throw new IllegalStateException("expected " + this.f21137k + " but was " + httpCodec);
        }
        Util.closeQuietly(a);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (iOException != null) {
            this.eventListener.callFailed(this.call, Internal.instance.timeoutExit(this.call, iOException));
        } else if (z2) {
            Internal.instance.timeoutExit(this.call, (IOException) null);
            this.eventListener.callEnd(this.call);
        }
    }

    public String toString() {
        RealConnection connection = connection();
        return connection != null ? connection.toString() : this.address.toString();
    }
}
