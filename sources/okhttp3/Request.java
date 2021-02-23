package okhttp3;

import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

public final class Request {

    /* renamed from: a */
    final HttpUrl f19952a;

    /* renamed from: b */
    final String f19953b;

    /* renamed from: c */
    final Headers f19954c;
    @Nullable

    /* renamed from: d */
    final RequestBody f19955d;

    /* renamed from: e */
    final Map<Class<?>, Object> f19956e;
    @Nullable

    /* renamed from: f */
    private volatile CacheControl f19957f;

    public static class Builder {
        @Nullable

        /* renamed from: a */
        HttpUrl f19958a;

        /* renamed from: b */
        String f19959b;

        /* renamed from: c */
        Headers.Builder f19960c;
        @Nullable

        /* renamed from: d */
        RequestBody f19961d;

        /* renamed from: e */
        Map<Class<?>, Object> f19962e;

        public Builder() {
            this.f19962e = Collections.emptyMap();
            this.f19959b = "GET";
            this.f19960c = new Headers.Builder();
        }

        public Builder addHeader(String str, String str2) {
            this.f19960c.add(str, str2);
            return this;
        }

        public Request build() {
            if (this.f19958a != null) {
                return new Request(this);
            }
            throw new IllegalStateException("url == null");
        }

        public Builder cacheControl(CacheControl cacheControl) {
            String cacheControl2 = cacheControl.toString();
            if (cacheControl2.isEmpty()) {
                return removeHeader("Cache-Control");
            }
            return header("Cache-Control", cacheControl2);
        }

        public Builder delete(@Nullable RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        public Builder get() {
            return method("GET", (RequestBody) null);
        }

        public Builder head() {
            return method("HEAD", (RequestBody) null);
        }

        public Builder header(String str, String str2) {
            this.f19960c.set(str, str2);
            return this;
        }

        public Builder headers(Headers headers) {
            this.f19960c = headers.newBuilder();
            return this;
        }

        public Builder method(String str, @Nullable RequestBody requestBody) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            } else if (requestBody != null && !HttpMethod.permitsRequestBody(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (requestBody != null || !HttpMethod.requiresRequestBody(str)) {
                this.f19959b = str;
                this.f19961d = requestBody;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        public Builder patch(RequestBody requestBody) {
            return method("PATCH", requestBody);
        }

        public Builder post(RequestBody requestBody) {
            return method("POST", requestBody);
        }

        public Builder put(RequestBody requestBody) {
            return method("PUT", requestBody);
        }

        public Builder removeHeader(String str) {
            this.f19960c.removeAll(str);
            return this;
        }

        public Builder tag(@Nullable Object obj) {
            return tag(Object.class, obj);
        }

        public Builder url(HttpUrl httpUrl) {
            if (httpUrl != null) {
                this.f19958a = httpUrl;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public Builder delete() {
            return delete(Util.EMPTY_REQUEST);
        }

        public <T> Builder tag(Class<? super T> cls, @Nullable T t) {
            if (cls != null) {
                if (t == null) {
                    this.f19962e.remove(cls);
                } else {
                    if (this.f19962e.isEmpty()) {
                        this.f19962e = new LinkedHashMap();
                    }
                    this.f19962e.put(cls, cls.cast(t));
                }
                return this;
            }
            throw new NullPointerException("type == null");
        }

        public Builder url(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    str = "http:" + str.substring(3);
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = "https:" + str.substring(4);
                }
                return url(HttpUrl.get(str));
            }
            throw new NullPointerException("url == null");
        }

        Builder(Request request) {
            Map<Class<?>, Object> map;
            this.f19962e = Collections.emptyMap();
            this.f19958a = request.f19952a;
            this.f19959b = request.f19953b;
            this.f19961d = request.f19955d;
            if (request.f19956e.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = new LinkedHashMap<>(request.f19956e);
            }
            this.f19962e = map;
            this.f19960c = request.f19954c.newBuilder();
        }

        public Builder url(URL url) {
            if (url != null) {
                return url(HttpUrl.get(url.toString()));
            }
            throw new NullPointerException("url == null");
        }
    }

    Request(Builder builder) {
        this.f19952a = builder.f19958a;
        this.f19953b = builder.f19959b;
        this.f19954c = builder.f19960c.build();
        this.f19955d = builder.f19961d;
        this.f19956e = Util.immutableMap(builder.f19962e);
    }

    @Nullable
    public RequestBody body() {
        return this.f19955d;
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = this.f19957f;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.parse(this.f19954c);
        this.f19957f = parse;
        return parse;
    }

    @Nullable
    public String header(String str) {
        return this.f19954c.get(str);
    }

    public Headers headers() {
        return this.f19954c;
    }

    public boolean isHttps() {
        return this.f19952a.isHttps();
    }

    public String method() {
        return this.f19953b;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    @Nullable
    public Object tag() {
        return tag(Object.class);
    }

    public String toString() {
        return "Request{method=" + this.f19953b + ", url=" + this.f19952a + ", tags=" + this.f19956e + '}';
    }

    public HttpUrl url() {
        return this.f19952a;
    }

    public List<String> headers(String str) {
        return this.f19954c.values(str);
    }

    @Nullable
    public <T> T tag(Class<? extends T> cls) {
        return cls.cast(this.f19956e.get(cls));
    }
}
