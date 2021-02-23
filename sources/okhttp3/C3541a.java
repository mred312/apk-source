package okhttp3;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;
import okio.Timeout;

/* renamed from: okhttp3.a */
/* compiled from: RealCall */
final class C3541a implements Call {

    /* renamed from: a */
    final OkHttpClient f20007a;

    /* renamed from: b */
    final RetryAndFollowUpInterceptor f20008b;

    /* renamed from: c */
    final AsyncTimeout f20009c;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: d */
    public EventListener f20010d;

    /* renamed from: e */
    final Request f20011e;

    /* renamed from: f */
    final boolean f20012f;

    /* renamed from: g */
    private boolean f20013g;

    /* renamed from: okhttp3.a$a */
    /* compiled from: RealCall */
    class C3542a extends AsyncTimeout {
        C3542a() {
        }

        /* access modifiers changed from: protected */
        public void timedOut() {
            C3541a.this.cancel();
        }
    }

    /* renamed from: okhttp3.a$b */
    /* compiled from: RealCall */
    final class C3543b extends NamedRunnable {

        /* renamed from: a */
        private final Callback f20015a;

        static {
            Class<C3541a> cls = C3541a.class;
        }

        C3543b(Callback callback) {
            super("OkHttp %s", C3541a.this.mo22272f());
            this.f20015a = callback;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x004a A[Catch:{ all -> 0x003d }] */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x006a A[Catch:{ all -> 0x003d }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void execute() {
            /*
                r5 = this;
                okhttp3.a r0 = okhttp3.C3541a.this
                okio.AsyncTimeout r0 = r0.f20009c
                r0.enter()
                r0 = 1
                r1 = 0
                okhttp3.a r2 = okhttp3.C3541a.this     // Catch:{ IOException -> 0x003f }
                okhttp3.Response r2 = r2.mo22271d()     // Catch:{ IOException -> 0x003f }
                okhttp3.a r3 = okhttp3.C3541a.this     // Catch:{ IOException -> 0x003f }
                okhttp3.internal.http.RetryAndFollowUpInterceptor r3 = r3.f20008b     // Catch:{ IOException -> 0x003f }
                boolean r1 = r3.isCanceled()     // Catch:{ IOException -> 0x003f }
                if (r1 == 0) goto L_0x0028
                okhttp3.Callback r1 = r5.f20015a     // Catch:{ IOException -> 0x003b }
                okhttp3.a r2 = okhttp3.C3541a.this     // Catch:{ IOException -> 0x003b }
                java.io.IOException r3 = new java.io.IOException     // Catch:{ IOException -> 0x003b }
                java.lang.String r4 = "Canceled"
                r3.<init>(r4)     // Catch:{ IOException -> 0x003b }
                r1.onFailure(r2, r3)     // Catch:{ IOException -> 0x003b }
                goto L_0x002f
            L_0x0028:
                okhttp3.Callback r1 = r5.f20015a     // Catch:{ IOException -> 0x003b }
                okhttp3.a r3 = okhttp3.C3541a.this     // Catch:{ IOException -> 0x003b }
                r1.onResponse(r3, r2)     // Catch:{ IOException -> 0x003b }
            L_0x002f:
                okhttp3.a r0 = okhttp3.C3541a.this
                okhttp3.OkHttpClient r0 = r0.f20007a
                okhttp3.Dispatcher r0 = r0.dispatcher()
                r0.mo21923d(r5)
                goto L_0x007d
            L_0x003b:
                r1 = move-exception
                goto L_0x0042
            L_0x003d:
                r0 = move-exception
                goto L_0x007e
            L_0x003f:
                r0 = move-exception
                r1 = r0
                r0 = 0
            L_0x0042:
                okhttp3.a r2 = okhttp3.C3541a.this     // Catch:{ all -> 0x003d }
                java.io.IOException r1 = r2.mo22274h(r1)     // Catch:{ all -> 0x003d }
                if (r0 == 0) goto L_0x006a
                okhttp3.internal.platform.Platform r0 = okhttp3.internal.platform.Platform.get()     // Catch:{ all -> 0x003d }
                r2 = 4
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x003d }
                r3.<init>()     // Catch:{ all -> 0x003d }
                java.lang.String r4 = "Callback failure for "
                r3.append(r4)     // Catch:{ all -> 0x003d }
                okhttp3.a r4 = okhttp3.C3541a.this     // Catch:{ all -> 0x003d }
                java.lang.String r4 = r4.mo22275i()     // Catch:{ all -> 0x003d }
                r3.append(r4)     // Catch:{ all -> 0x003d }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x003d }
                r0.log(r2, r3, r1)     // Catch:{ all -> 0x003d }
                goto L_0x002f
            L_0x006a:
                okhttp3.a r0 = okhttp3.C3541a.this     // Catch:{ all -> 0x003d }
                okhttp3.EventListener r0 = r0.f20010d     // Catch:{ all -> 0x003d }
                okhttp3.a r2 = okhttp3.C3541a.this     // Catch:{ all -> 0x003d }
                r0.callFailed(r2, r1)     // Catch:{ all -> 0x003d }
                okhttp3.Callback r0 = r5.f20015a     // Catch:{ all -> 0x003d }
                okhttp3.a r2 = okhttp3.C3541a.this     // Catch:{ all -> 0x003d }
                r0.onFailure(r2, r1)     // Catch:{ all -> 0x003d }
                goto L_0x002f
            L_0x007d:
                return
            L_0x007e:
                okhttp3.a r1 = okhttp3.C3541a.this
                okhttp3.OkHttpClient r1 = r1.f20007a
                okhttp3.Dispatcher r1 = r1.dispatcher()
                r1.mo21923d(r5)
                goto L_0x008b
            L_0x008a:
                throw r0
            L_0x008b:
                goto L_0x008a
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.C3541a.C3543b.execute():void");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public void mo22278k(ExecutorService executorService) {
            try {
                executorService.execute(this);
            } catch (RejectedExecutionException e) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause(e);
                C3541a.this.f20010d.callFailed(C3541a.this, interruptedIOException);
                this.f20015a.onFailure(C3541a.this, interruptedIOException);
                C3541a.this.f20007a.dispatcher().mo21923d(this);
            } catch (Throwable th) {
                C3541a.this.f20007a.dispatcher().mo21923d(this);
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: l */
        public C3541a mo22279l() {
            return C3541a.this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: m */
        public String mo22280m() {
            return C3541a.this.f20011e.url().host();
        }
    }

    private C3541a(OkHttpClient okHttpClient, Request request, boolean z) {
        this.f20007a = okHttpClient;
        this.f20011e = request;
        this.f20012f = z;
        this.f20008b = new RetryAndFollowUpInterceptor(okHttpClient, z);
        C3542a aVar = new C3542a();
        this.f20009c = aVar;
        aVar.timeout((long) okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    /* renamed from: b */
    private void m11982b() {
        this.f20008b.setCallStackTrace(Platform.get().getStackTraceForCloseable("response.body().close()"));
    }

    /* renamed from: e */
    static C3541a m11983e(OkHttpClient okHttpClient, Request request, boolean z) {
        C3541a aVar = new C3541a(okHttpClient, request, z);
        aVar.f20010d = okHttpClient.eventListenerFactory().create(aVar);
        return aVar;
    }

    /* renamed from: c */
    public C3541a clone() {
        return m11983e(this.f20007a, this.f20011e, this.f20012f);
    }

    public void cancel() {
        this.f20008b.cancel();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public Response mo22271d() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f20007a.interceptors());
        arrayList.add(this.f20008b);
        arrayList.add(new BridgeInterceptor(this.f20007a.cookieJar()));
        arrayList.add(new CacheInterceptor(this.f20007a.mo22093a()));
        arrayList.add(new ConnectInterceptor(this.f20007a));
        if (!this.f20012f) {
            arrayList.addAll(this.f20007a.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.f20012f));
        return new RealInterceptorChain(arrayList, (StreamAllocation) null, (HttpCodec) null, (RealConnection) null, 0, this.f20011e, this, this.f20010d, this.f20007a.connectTimeoutMillis(), this.f20007a.readTimeoutMillis(), this.f20007a.writeTimeoutMillis()).proceed(this.f20011e);
    }

    public void enqueue(Callback callback) {
        synchronized (this) {
            if (!this.f20013g) {
                this.f20013g = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        m11982b();
        this.f20010d.callStart(this);
        this.f20007a.dispatcher().mo21920a(new C3543b(callback));
    }

    public Response execute() {
        synchronized (this) {
            if (!this.f20013g) {
                this.f20013g = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        m11982b();
        this.f20009c.enter();
        this.f20010d.callStart(this);
        try {
            this.f20007a.dispatcher().mo21921b(this);
            Response d = mo22271d();
            if (d != null) {
                this.f20007a.dispatcher().mo21924e(this);
                return d;
            }
            throw new IOException("Canceled");
        } catch (IOException e) {
            IOException h = mo22274h(e);
            this.f20010d.callFailed(this, h);
            throw h;
        } catch (Throwable th) {
            this.f20007a.dispatcher().mo21924e(this);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public String mo22272f() {
        return this.f20011e.url().redact();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public StreamAllocation mo22273g() {
        return this.f20008b.streamAllocation();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: h */
    public IOException mo22274h(@Nullable IOException iOException) {
        if (!this.f20009c.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public String mo22275i() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.f20012f ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(mo22272f());
        return sb.toString();
    }

    public boolean isCanceled() {
        return this.f20008b.isCanceled();
    }

    public synchronized boolean isExecuted() {
        return this.f20013g;
    }

    public Request request() {
        return this.f20011e;
    }

    public Timeout timeout() {
        return this.f20009c;
    }
}
