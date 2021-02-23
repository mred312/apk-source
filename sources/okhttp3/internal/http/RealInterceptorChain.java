package okhttp3.internal.http;

import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;

public final class RealInterceptorChain implements Interceptor.Chain {

    /* renamed from: a */
    private final List<Interceptor> f21146a;

    /* renamed from: b */
    private final StreamAllocation f21147b;

    /* renamed from: c */
    private final HttpCodec f21148c;

    /* renamed from: d */
    private final RealConnection f21149d;

    /* renamed from: e */
    private final int f21150e;

    /* renamed from: f */
    private final Request f21151f;

    /* renamed from: g */
    private final Call f21152g;

    /* renamed from: h */
    private final EventListener f21153h;

    /* renamed from: i */
    private final int f21154i;

    /* renamed from: j */
    private final int f21155j;

    /* renamed from: k */
    private final int f21156k;

    /* renamed from: l */
    private int f21157l;

    public RealInterceptorChain(List<Interceptor> list, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection, int i, Request request, Call call, EventListener eventListener, int i2, int i3, int i4) {
        this.f21146a = list;
        this.f21149d = realConnection;
        this.f21147b = streamAllocation;
        this.f21148c = httpCodec;
        this.f21150e = i;
        this.f21151f = request;
        this.f21152g = call;
        this.f21153h = eventListener;
        this.f21154i = i2;
        this.f21155j = i3;
        this.f21156k = i4;
    }

    public Call call() {
        return this.f21152g;
    }

    public int connectTimeoutMillis() {
        return this.f21154i;
    }

    public Connection connection() {
        return this.f21149d;
    }

    public EventListener eventListener() {
        return this.f21153h;
    }

    public HttpCodec httpStream() {
        return this.f21148c;
    }

    public Response proceed(Request request) {
        return proceed(request, this.f21147b, this.f21148c, this.f21149d);
    }

    public int readTimeoutMillis() {
        return this.f21155j;
    }

    public Request request() {
        return this.f21151f;
    }

    public StreamAllocation streamAllocation() {
        return this.f21147b;
    }

    public Interceptor.Chain withConnectTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.f21146a, this.f21147b, this.f21148c, this.f21149d, this.f21150e, this.f21151f, this.f21152g, this.f21153h, Util.checkDuration("timeout", (long) i, timeUnit), this.f21155j, this.f21156k);
    }

    public Interceptor.Chain withReadTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.f21146a, this.f21147b, this.f21148c, this.f21149d, this.f21150e, this.f21151f, this.f21152g, this.f21153h, this.f21154i, Util.checkDuration("timeout", (long) i, timeUnit), this.f21156k);
    }

    public Interceptor.Chain withWriteTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.f21146a, this.f21147b, this.f21148c, this.f21149d, this.f21150e, this.f21151f, this.f21152g, this.f21153h, this.f21154i, this.f21155j, Util.checkDuration("timeout", (long) i, timeUnit));
    }

    public int writeTimeoutMillis() {
        return this.f21156k;
    }

    public Response proceed(Request request, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection) {
        if (this.f21150e < this.f21146a.size()) {
            this.f21157l++;
            if (this.f21148c != null && !this.f21149d.supportsUrl(request.url())) {
                throw new IllegalStateException("network interceptor " + this.f21146a.get(this.f21150e - 1) + " must retain the same host and port");
            } else if (this.f21148c == null || this.f21157l <= 1) {
                RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.f21146a, streamAllocation, httpCodec, realConnection, this.f21150e + 1, request, this.f21152g, this.f21153h, this.f21154i, this.f21155j, this.f21156k);
                Interceptor interceptor = this.f21146a.get(this.f21150e);
                Response intercept = interceptor.intercept(realInterceptorChain);
                if (httpCodec != null && this.f21150e + 1 < this.f21146a.size() && realInterceptorChain.f21157l != 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                } else if (intercept == null) {
                    throw new NullPointerException("interceptor " + interceptor + " returned null");
                } else if (intercept.body() != null) {
                    return intercept;
                } else {
                    throw new IllegalStateException("interceptor " + interceptor + " returned a response with no body");
                }
            } else {
                throw new IllegalStateException("network interceptor " + this.f21146a.get(this.f21150e - 1) + " must call proceed() exactly once");
            }
        } else {
            throw new AssertionError();
        }
    }
}
