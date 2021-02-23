package okhttp3;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.platform.Platform;

public final class ConnectionPool {

    /* renamed from: g */
    private static final Executor f19797g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));

    /* renamed from: a */
    private final int f19798a;

    /* renamed from: b */
    private final long f19799b;

    /* renamed from: c */
    private final Runnable f19800c;

    /* renamed from: d */
    private final Deque<RealConnection> f19801d;

    /* renamed from: e */
    final RouteDatabase f19802e;

    /* renamed from: f */
    boolean f19803f;

    /* renamed from: okhttp3.ConnectionPool$a */
    class C3532a implements Runnable {
        C3532a() {
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
            L_0x0000:
                okhttp3.ConnectionPool r0 = okhttp3.ConnectionPool.this
                long r1 = java.lang.System.nanoTime()
                long r0 = r0.mo21871a(r1)
                r2 = -1
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 != 0) goto L_0x0011
                return
            L_0x0011:
                r2 = 0
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 <= 0) goto L_0x0000
                r2 = 1000000(0xf4240, double:4.940656E-318)
                long r4 = r0 / r2
                long r2 = r2 * r4
                long r0 = r0 - r2
                okhttp3.ConnectionPool r2 = okhttp3.ConnectionPool.this
                monitor-enter(r2)
                okhttp3.ConnectionPool r3 = okhttp3.ConnectionPool.this     // Catch:{ InterruptedException -> 0x002b }
                int r1 = (int) r0     // Catch:{ InterruptedException -> 0x002b }
                r3.wait(r4, r1)     // Catch:{ InterruptedException -> 0x002b }
                goto L_0x002b
            L_0x0029:
                r0 = move-exception
                goto L_0x002d
            L_0x002b:
                monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                goto L_0x0000
            L_0x002d:
                monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                goto L_0x0030
            L_0x002f:
                throw r0
            L_0x0030:
                goto L_0x002f
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.ConnectionPool.C3532a.run():void");
        }
    }

    public ConnectionPool() {
        this(5, 5, TimeUnit.MINUTES);
    }

    /* renamed from: e */
    private int m11913e(RealConnection realConnection, long j) {
        List<Reference<StreamAllocation>> list = realConnection.allocations;
        int i = 0;
        while (i < list.size()) {
            Reference reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                Platform.get().logCloseableLeak("A connection to " + realConnection.route().address().url() + " was leaked. Did you forget to close a response body?", ((StreamAllocation.StreamAllocationReference) reference).callStackTrace);
                list.remove(i);
                realConnection.noNewStreams = true;
                if (list.isEmpty()) {
                    realConnection.idleAtNanos = j - this.f19799b;
                    return 0;
                }
            }
        }
        return list.size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo21871a(long j) {
        synchronized (this) {
            RealConnection realConnection = null;
            long j2 = Long.MIN_VALUE;
            int i = 0;
            int i2 = 0;
            for (RealConnection next : this.f19801d) {
                if (m11913e(next, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - next.idleAtNanos;
                    if (j3 > j2) {
                        realConnection = next;
                        j2 = j3;
                    }
                }
            }
            long j4 = this.f19799b;
            if (j2 < j4) {
                if (i <= this.f19798a) {
                    if (i > 0) {
                        long j5 = j4 - j2;
                        return j5;
                    } else if (i2 > 0) {
                        return j4;
                    } else {
                        this.f19803f = false;
                        return -1;
                    }
                }
            }
            this.f19801d.remove(realConnection);
            Util.closeQuietly(realConnection.socket());
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo21872b(RealConnection realConnection) {
        if (realConnection.noNewStreams || this.f19798a == 0) {
            this.f19801d.remove(realConnection);
            return true;
        }
        notifyAll();
        return false;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: c */
    public Socket mo21873c(Address address, StreamAllocation streamAllocation) {
        for (RealConnection next : this.f19801d) {
            if (next.isEligible(address, (Route) null) && next.isMultiplexed() && next != streamAllocation.connection()) {
                return streamAllocation.releaseAndAcquire(next);
            }
        }
        return null;
    }

    public synchronized int connectionCount() {
        return this.f19801d.size();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: d */
    public RealConnection mo21875d(Address address, StreamAllocation streamAllocation, Route route) {
        for (RealConnection next : this.f19801d) {
            if (next.isEligible(address, route)) {
                streamAllocation.acquire(next, true);
                return next;
            }
        }
        return null;
    }

    public void evictAll() {
        ArrayList<RealConnection> arrayList = new ArrayList<>();
        synchronized (this) {
            Iterator<RealConnection> it = this.f19801d.iterator();
            while (it.hasNext()) {
                RealConnection next = it.next();
                if (next.allocations.isEmpty()) {
                    next.noNewStreams = true;
                    arrayList.add(next);
                    it.remove();
                }
            }
        }
        for (RealConnection socket : arrayList) {
            Util.closeQuietly(socket.socket());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo21877f(RealConnection realConnection) {
        if (!this.f19803f) {
            this.f19803f = true;
            f19797g.execute(this.f19800c);
        }
        this.f19801d.add(realConnection);
    }

    public synchronized int idleConnectionCount() {
        int i;
        i = 0;
        for (RealConnection realConnection : this.f19801d) {
            if (realConnection.allocations.isEmpty()) {
                i++;
            }
        }
        return i;
    }

    public ConnectionPool(int i, long j, TimeUnit timeUnit) {
        this.f19800c = new C3532a();
        this.f19801d = new ArrayDeque();
        this.f19802e = new RouteDatabase();
        this.f19798a = i;
        this.f19799b = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
        }
    }
}
