package okio;

import android.support.p000v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class AsyncTimeout extends Timeout {

    /* renamed from: g */
    private static final long f20182g;

    /* renamed from: h */
    private static final long f20183h;
    @Nullable

    /* renamed from: i */
    static AsyncTimeout f20184i;

    /* renamed from: d */
    private boolean f20185d;
    @Nullable

    /* renamed from: e */
    private AsyncTimeout f20186e;

    /* renamed from: f */
    private long f20187f;

    /* renamed from: okio.AsyncTimeout$a */
    class C3569a implements Sink {

        /* renamed from: a */
        final /* synthetic */ Sink f20188a;

        C3569a(Sink sink) {
            this.f20188a = sink;
        }

        public void close() {
            AsyncTimeout.this.enter();
            try {
                this.f20188a.close();
                AsyncTimeout.this.mo22411d(true);
            } catch (IOException e) {
                throw AsyncTimeout.this.mo22410c(e);
            } catch (Throwable th) {
                AsyncTimeout.this.mo22411d(false);
                throw th;
            }
        }

        public void flush() {
            AsyncTimeout.this.enter();
            try {
                this.f20188a.flush();
                AsyncTimeout.this.mo22411d(true);
            } catch (IOException e) {
                throw AsyncTimeout.this.mo22410c(e);
            } catch (Throwable th) {
                AsyncTimeout.this.mo22411d(false);
                throw th;
            }
        }

        public Timeout timeout() {
            return AsyncTimeout.this;
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f20188a + ")";
        }

        public void write(Buffer buffer, long j) {
            C3972g.m14445b(buffer.f20194b, 0, j);
            while (true) {
                long j2 = 0;
                if (j > 0) {
                    C3578d dVar = buffer.f20193a;
                    while (true) {
                        if (j2 >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                            break;
                        }
                        j2 += (long) (dVar.f20215c - dVar.f20214b);
                        if (j2 >= j) {
                            j2 = j;
                            break;
                        }
                        dVar = dVar.f20218f;
                    }
                    AsyncTimeout.this.enter();
                    try {
                        this.f20188a.write(buffer, j2);
                        j -= j2;
                        AsyncTimeout.this.mo22411d(true);
                    } catch (IOException e) {
                        throw AsyncTimeout.this.mo22410c(e);
                    } catch (Throwable th) {
                        AsyncTimeout.this.mo22411d(false);
                        throw th;
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: okio.AsyncTimeout$b */
    class C3570b implements Source {

        /* renamed from: a */
        final /* synthetic */ Source f20190a;

        C3570b(Source source) {
            this.f20190a = source;
        }

        public void close() {
            try {
                this.f20190a.close();
                AsyncTimeout.this.mo22411d(true);
            } catch (IOException e) {
                throw AsyncTimeout.this.mo22410c(e);
            } catch (Throwable th) {
                AsyncTimeout.this.mo22411d(false);
                throw th;
            }
        }

        public long read(Buffer buffer, long j) {
            AsyncTimeout.this.enter();
            try {
                long read = this.f20190a.read(buffer, j);
                AsyncTimeout.this.mo22411d(true);
                return read;
            } catch (IOException e) {
                throw AsyncTimeout.this.mo22410c(e);
            } catch (Throwable th) {
                AsyncTimeout.this.mo22411d(false);
                throw th;
            }
        }

        public Timeout timeout() {
            return AsyncTimeout.this;
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f20190a + ")";
        }
    }

    /* renamed from: okio.AsyncTimeout$c */
    private static final class C3571c extends Thread {
        C3571c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1.timedOut();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                java.lang.Class<okio.AsyncTimeout> r0 = okio.AsyncTimeout.class
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
                okio.AsyncTimeout r1 = okio.AsyncTimeout.m12065a()     // Catch:{ all -> 0x0019 }
                if (r1 != 0) goto L_0x000b
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                goto L_0x0000
            L_0x000b:
                okio.AsyncTimeout r2 = okio.AsyncTimeout.f20184i     // Catch:{ all -> 0x0019 }
                if (r1 != r2) goto L_0x0014
                r1 = 0
                okio.AsyncTimeout.f20184i = r1     // Catch:{ all -> 0x0019 }
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                return
            L_0x0014:
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                r1.timedOut()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            L_0x0019:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                goto L_0x001d
            L_0x001c:
                throw r1
            L_0x001d:
                goto L_0x001c
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.AsyncTimeout.C3571c.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60);
        f20182g = millis;
        f20183h = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    @Nullable
    /* renamed from: a */
    static AsyncTimeout m12065a() {
        Class<AsyncTimeout> cls = AsyncTimeout.class;
        AsyncTimeout asyncTimeout = f20184i.f20186e;
        if (asyncTimeout == null) {
            long nanoTime = System.nanoTime();
            cls.wait(f20182g);
            if (f20184i.f20186e != null || System.nanoTime() - nanoTime < f20183h) {
                return null;
            }
            return f20184i;
        }
        long e = asyncTimeout.m12067e(System.nanoTime());
        if (e > 0) {
            long j = e / 1000000;
            cls.wait(j, (int) (e - (1000000 * j)));
            return null;
        }
        f20184i.f20186e = asyncTimeout.f20186e;
        asyncTimeout.f20186e = null;
        return asyncTimeout;
    }

    /* renamed from: b */
    private static synchronized boolean m12066b(AsyncTimeout asyncTimeout) {
        synchronized (AsyncTimeout.class) {
            AsyncTimeout asyncTimeout2 = f20184i;
            while (asyncTimeout2 != null) {
                AsyncTimeout asyncTimeout3 = asyncTimeout2.f20186e;
                if (asyncTimeout3 == asyncTimeout) {
                    asyncTimeout2.f20186e = asyncTimeout.f20186e;
                    asyncTimeout.f20186e = null;
                    return false;
                }
                asyncTimeout2 = asyncTimeout3;
            }
            return true;
        }
    }

    /* renamed from: e */
    private long m12067e(long j) {
        return this.f20187f - j;
    }

    /* renamed from: f */
    private static synchronized void m12068f(AsyncTimeout asyncTimeout, long j, boolean z) {
        Class<AsyncTimeout> cls = AsyncTimeout.class;
        synchronized (cls) {
            if (f20184i == null) {
                f20184i = new AsyncTimeout();
                new C3571c().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                asyncTimeout.f20187f = Math.min(j, asyncTimeout.deadlineNanoTime() - nanoTime) + nanoTime;
            } else if (j != 0) {
                asyncTimeout.f20187f = j + nanoTime;
            } else if (z) {
                asyncTimeout.f20187f = asyncTimeout.deadlineNanoTime();
            } else {
                throw new AssertionError();
            }
            long e = asyncTimeout.m12067e(nanoTime);
            AsyncTimeout asyncTimeout2 = f20184i;
            while (true) {
                AsyncTimeout asyncTimeout3 = asyncTimeout2.f20186e;
                if (asyncTimeout3 == null) {
                    break;
                } else if (e < asyncTimeout3.m12067e(nanoTime)) {
                    break;
                } else {
                    asyncTimeout2 = asyncTimeout2.f20186e;
                }
            }
            asyncTimeout.f20186e = asyncTimeout2.f20186e;
            asyncTimeout2.f20186e = asyncTimeout;
            if (asyncTimeout2 == f20184i) {
                cls.notify();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final IOException mo22410c(IOException iOException) {
        if (!exit()) {
            return iOException;
        }
        return newTimeoutException(iOException);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo22411d(boolean z) {
        if (exit() && z) {
            throw newTimeoutException((IOException) null);
        }
    }

    public final void enter() {
        if (!this.f20185d) {
            long timeoutNanos = timeoutNanos();
            boolean hasDeadline = hasDeadline();
            if (timeoutNanos != 0 || hasDeadline) {
                this.f20185d = true;
                m12068f(this, timeoutNanos, hasDeadline);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    public final boolean exit() {
        if (!this.f20185d) {
            return false;
        }
        this.f20185d = false;
        return m12066b(this);
    }

    /* access modifiers changed from: protected */
    public IOException newTimeoutException(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final Sink sink(Sink sink) {
        return new C3569a(sink);
    }

    public final Source source(Source source) {
        return new C3570b(source);
    }

    /* access modifiers changed from: protected */
    public void timedOut() {
    }
}
