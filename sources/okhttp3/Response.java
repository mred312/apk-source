package okhttp3;

import java.io.Closeable;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;

public final class Response implements Closeable {

    /* renamed from: a */
    final Request f19971a;

    /* renamed from: b */
    final Protocol f19972b;

    /* renamed from: c */
    final int f19973c;

    /* renamed from: d */
    final String f19974d;
    @Nullable

    /* renamed from: e */
    final Handshake f19975e;

    /* renamed from: f */
    final Headers f19976f;
    @Nullable

    /* renamed from: g */
    final ResponseBody f19977g;
    @Nullable

    /* renamed from: h */
    final Response f19978h;
    @Nullable

    /* renamed from: i */
    final Response f19979i;
    @Nullable

    /* renamed from: j */
    final Response f19980j;

    /* renamed from: k */
    final long f19981k;

    /* renamed from: l */
    final long f19982l;
    @Nullable

    /* renamed from: m */
    private volatile CacheControl f19983m;

    Response(Builder builder) {
        this.f19971a = builder.f19984a;
        this.f19972b = builder.f19985b;
        this.f19973c = builder.f19986c;
        this.f19974d = builder.f19987d;
        this.f19975e = builder.f19988e;
        this.f19976f = builder.f19989f.build();
        this.f19977g = builder.f19990g;
        this.f19978h = builder.f19991h;
        this.f19979i = builder.f19992i;
        this.f19980j = builder.f19993j;
        this.f19981k = builder.f19994k;
        this.f19982l = builder.f19995l;
    }

    @Nullable
    public ResponseBody body() {
        return this.f19977g;
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = this.f19983m;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.parse(this.f19976f);
        this.f19983m = parse;
        return parse;
    }

    @Nullable
    public Response cacheResponse() {
        return this.f19979i;
    }

    public List<Challenge> challenges() {
        String str;
        int i = this.f19973c;
        if (i == 401) {
            str = "WWW-Authenticate";
        } else if (i != 407) {
            return Collections.emptyList();
        } else {
            str = "Proxy-Authenticate";
        }
        return HttpHeaders.parseChallenges(headers(), str);
    }

    public void close() {
        ResponseBody responseBody = this.f19977g;
        if (responseBody != null) {
            responseBody.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public int code() {
        return this.f19973c;
    }

    @Nullable
    public Handshake handshake() {
        return this.f19975e;
    }

    @Nullable
    public String header(String str) {
        return header(str, (String) null);
    }

    public List<String> headers(String str) {
        return this.f19976f.values(str);
    }

    public boolean isRedirect() {
        int i = this.f19973c;
        if (i == 307 || i == 308) {
            return true;
        }
        switch (i) {
            case 300:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    public boolean isSuccessful() {
        int i = this.f19973c;
        return i >= 200 && i < 300;
    }

    public String message() {
        return this.f19974d;
    }

    @Nullable
    public Response networkResponse() {
        return this.f19978h;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public ResponseBody peekBody(long j) {
        BufferedSource source = this.f19977g.source();
        source.request(j);
        Buffer clone = source.buffer().clone();
        if (clone.size() > j) {
            Buffer buffer = new Buffer();
            buffer.write(clone, j);
            clone.clear();
            clone = buffer;
        }
        return ResponseBody.create(this.f19977g.contentType(), clone.size(), clone);
    }

    @Nullable
    public Response priorResponse() {
        return this.f19980j;
    }

    public Protocol protocol() {
        return this.f19972b;
    }

    public long receivedResponseAtMillis() {
        return this.f19982l;
    }

    public Request request() {
        return this.f19971a;
    }

    public long sentRequestAtMillis() {
        return this.f19981k;
    }

    public String toString() {
        return "Response{protocol=" + this.f19972b + ", code=" + this.f19973c + ", message=" + this.f19974d + ", url=" + this.f19971a.url() + '}';
    }

    @Nullable
    public String header(String str, @Nullable String str2) {
        String str3 = this.f19976f.get(str);
        return str3 != null ? str3 : str2;
    }

    public Headers headers() {
        return this.f19976f;
    }

    public static class Builder {
        @Nullable

        /* renamed from: a */
        Request f19984a;
        @Nullable

        /* renamed from: b */
        Protocol f19985b;

        /* renamed from: c */
        int f19986c;

        /* renamed from: d */
        String f19987d;
        @Nullable

        /* renamed from: e */
        Handshake f19988e;

        /* renamed from: f */
        Headers.Builder f19989f;
        @Nullable

        /* renamed from: g */
        ResponseBody f19990g;
        @Nullable

        /* renamed from: h */
        Response f19991h;
        @Nullable

        /* renamed from: i */
        Response f19992i;
        @Nullable

        /* renamed from: j */
        Response f19993j;

        /* renamed from: k */
        long f19994k;

        /* renamed from: l */
        long f19995l;

        public Builder() {
            this.f19986c = -1;
            this.f19989f = new Headers.Builder();
        }

        /* renamed from: a */
        private void m11978a(Response response) {
            if (response.f19977g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        /* renamed from: b */
        private void m11979b(String str, Response response) {
            if (response.f19977g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (response.f19978h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (response.f19979i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (response.f19980j != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public Builder addHeader(String str, String str2) {
            this.f19989f.add(str, str2);
            return this;
        }

        public Builder body(@Nullable ResponseBody responseBody) {
            this.f19990g = responseBody;
            return this;
        }

        public Response build() {
            if (this.f19984a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f19985b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f19986c < 0) {
                throw new IllegalStateException("code < 0: " + this.f19986c);
            } else if (this.f19987d != null) {
                return new Response(this);
            } else {
                throw new IllegalStateException("message == null");
            }
        }

        public Builder cacheResponse(@Nullable Response response) {
            if (response != null) {
                m11979b("cacheResponse", response);
            }
            this.f19992i = response;
            return this;
        }

        public Builder code(int i) {
            this.f19986c = i;
            return this;
        }

        public Builder handshake(@Nullable Handshake handshake) {
            this.f19988e = handshake;
            return this;
        }

        public Builder header(String str, String str2) {
            this.f19989f.set(str, str2);
            return this;
        }

        public Builder headers(Headers headers) {
            this.f19989f = headers.newBuilder();
            return this;
        }

        public Builder message(String str) {
            this.f19987d = str;
            return this;
        }

        public Builder networkResponse(@Nullable Response response) {
            if (response != null) {
                m11979b("networkResponse", response);
            }
            this.f19991h = response;
            return this;
        }

        public Builder priorResponse(@Nullable Response response) {
            if (response != null) {
                m11978a(response);
            }
            this.f19993j = response;
            return this;
        }

        public Builder protocol(Protocol protocol) {
            this.f19985b = protocol;
            return this;
        }

        public Builder receivedResponseAtMillis(long j) {
            this.f19995l = j;
            return this;
        }

        public Builder removeHeader(String str) {
            this.f19989f.removeAll(str);
            return this;
        }

        public Builder request(Request request) {
            this.f19984a = request;
            return this;
        }

        public Builder sentRequestAtMillis(long j) {
            this.f19994k = j;
            return this;
        }

        Builder(Response response) {
            this.f19986c = -1;
            this.f19984a = response.f19971a;
            this.f19985b = response.f19972b;
            this.f19986c = response.f19973c;
            this.f19987d = response.f19974d;
            this.f19988e = response.f19975e;
            this.f19989f = response.f19976f.newBuilder();
            this.f19990g = response.f19977g;
            this.f19991h = response.f19978h;
            this.f19992i = response.f19979i;
            this.f19993j = response.f19980j;
            this.f19994k = response.f19981k;
            this.f19995l = response.f19982l;
        }
    }
}
