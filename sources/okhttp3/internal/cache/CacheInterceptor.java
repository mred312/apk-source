package okhttp3.internal.cache;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class CacheInterceptor implements Interceptor {

    /* renamed from: a */
    final InternalCache f21104a;

    /* renamed from: okhttp3.internal.cache.CacheInterceptor$a */
    class C3925a implements Source {

        /* renamed from: a */
        boolean f21105a;

        /* renamed from: b */
        final /* synthetic */ BufferedSource f21106b;

        /* renamed from: c */
        final /* synthetic */ CacheRequest f21107c;

        /* renamed from: d */
        final /* synthetic */ BufferedSink f21108d;

        C3925a(CacheInterceptor cacheInterceptor, BufferedSource bufferedSource, CacheRequest cacheRequest, BufferedSink bufferedSink) {
            this.f21106b = bufferedSource;
            this.f21107c = cacheRequest;
            this.f21108d = bufferedSink;
        }

        public void close() {
            if (!this.f21105a && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                this.f21105a = true;
                this.f21107c.abort();
            }
            this.f21106b.close();
        }

        public long read(Buffer buffer, long j) {
            try {
                long read = this.f21106b.read(buffer, j);
                if (read == -1) {
                    if (!this.f21105a) {
                        this.f21105a = true;
                        this.f21108d.close();
                    }
                    return -1;
                }
                buffer.copyTo(this.f21108d.buffer(), buffer.size() - read, read);
                this.f21108d.emitCompleteSegments();
                return read;
            } catch (IOException e) {
                if (!this.f21105a) {
                    this.f21105a = true;
                    this.f21107c.abort();
                }
                throw e;
            }
        }

        public Timeout timeout() {
            return this.f21106b.timeout();
        }
    }

    public CacheInterceptor(InternalCache internalCache) {
        this.f21104a = internalCache;
    }

    /* renamed from: a */
    private Response m14225a(CacheRequest cacheRequest, Response response) {
        Sink body;
        if (cacheRequest == null || (body = cacheRequest.body()) == null) {
            return response;
        }
        C3925a aVar = new C3925a(this, response.body().source(), cacheRequest, Okio.buffer(body));
        return response.newBuilder().body(new RealResponseBody(response.header("Content-Type"), response.body().contentLength(), Okio.buffer((Source) aVar))).build();
    }

    /* renamed from: b */
    private static Headers m14226b(Headers headers, Headers headers2) {
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            String value = headers.value(i);
            if ((!"Warning".equalsIgnoreCase(name) || !value.startsWith("1")) && (m14227c(name) || !m14228d(name) || headers2.get(name) == null)) {
                Internal.instance.addLenient(builder, name, value);
            }
        }
        int size2 = headers2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            String name2 = headers2.name(i2);
            if (!m14227c(name2) && m14228d(name2)) {
                Internal.instance.addLenient(builder, name2, headers2.value(i2));
            }
        }
        return builder.build();
    }

    /* renamed from: c */
    static boolean m14227c(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }

    /* renamed from: d */
    static boolean m14228d(String str) {
        return !"Connection".equalsIgnoreCase(str) && !"Keep-Alive".equalsIgnoreCase(str) && !"Proxy-Authenticate".equalsIgnoreCase(str) && !"Proxy-Authorization".equalsIgnoreCase(str) && !"TE".equalsIgnoreCase(str) && !"Trailers".equalsIgnoreCase(str) && !"Transfer-Encoding".equalsIgnoreCase(str) && !"Upgrade".equalsIgnoreCase(str);
    }

    /* renamed from: e */
    private static Response m14229e(Response response) {
        return (response == null || response.body() == null) ? response : response.newBuilder().body((ResponseBody) null).build();
    }

    public Response intercept(Interceptor.Chain chain) {
        InternalCache internalCache = this.f21104a;
        Response response = internalCache != null ? internalCache.get(chain.request()) : null;
        CacheStrategy cacheStrategy = new CacheStrategy.Factory(System.currentTimeMillis(), chain.request(), response).get();
        Request request = cacheStrategy.networkRequest;
        Response response2 = cacheStrategy.cacheResponse;
        InternalCache internalCache2 = this.f21104a;
        if (internalCache2 != null) {
            internalCache2.trackResponse(cacheStrategy);
        }
        if (response != null && response2 == null) {
            Util.closeQuietly((Closeable) response.body());
        }
        if (request == null && response2 == null) {
            return new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1).receivedResponseAtMillis(System.currentTimeMillis()).build();
        }
        if (request == null) {
            return response2.newBuilder().cacheResponse(m14229e(response2)).build();
        }
        try {
            Response proceed = chain.proceed(request);
            if (proceed == null && response != null) {
            }
            if (response2 != null) {
                if (proceed.code() == 304) {
                    Response build = response2.newBuilder().headers(m14226b(response2.headers(), proceed.headers())).sentRequestAtMillis(proceed.sentRequestAtMillis()).receivedResponseAtMillis(proceed.receivedResponseAtMillis()).cacheResponse(m14229e(response2)).networkResponse(m14229e(proceed)).build();
                    proceed.body().close();
                    this.f21104a.trackConditionalCacheHit();
                    this.f21104a.update(response2, build);
                    return build;
                }
                Util.closeQuietly((Closeable) response2.body());
            }
            Response build2 = proceed.newBuilder().cacheResponse(m14229e(response2)).networkResponse(m14229e(proceed)).build();
            if (this.f21104a != null) {
                if (HttpHeaders.hasBody(build2) && CacheStrategy.isCacheable(build2, request)) {
                    return m14225a(this.f21104a.put(build2), build2);
                }
                if (HttpMethod.invalidatesCache(request.method())) {
                    try {
                        this.f21104a.remove(request);
                    } catch (IOException unused) {
                    }
                }
            }
            return build2;
        } finally {
            if (response != null) {
                Util.closeQuietly((Closeable) response.body());
            }
        }
    }
}
