package okhttp3.internal.cache;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.http.HttpHeaders;

public final class CacheStrategy {
    @Nullable
    public final Response cacheResponse;
    @Nullable
    public final Request networkRequest;

    public static class Factory {

        /* renamed from: a */
        final long f20030a;

        /* renamed from: b */
        final Request f20031b;

        /* renamed from: c */
        final Response f20032c;

        /* renamed from: d */
        private Date f20033d;

        /* renamed from: e */
        private String f20034e;

        /* renamed from: f */
        private Date f20035f;

        /* renamed from: g */
        private String f20036g;

        /* renamed from: h */
        private Date f20037h;

        /* renamed from: i */
        private long f20038i;

        /* renamed from: j */
        private long f20039j;

        /* renamed from: k */
        private String f20040k;

        /* renamed from: l */
        private int f20041l = -1;

        public Factory(long j, Request request, Response response) {
            this.f20030a = j;
            this.f20031b = request;
            this.f20032c = response;
            if (response != null) {
                this.f20038i = response.sentRequestAtMillis();
                this.f20039j = response.receivedResponseAtMillis();
                Headers headers = response.headers();
                int size = headers.size();
                for (int i = 0; i < size; i++) {
                    String name = headers.name(i);
                    String value = headers.value(i);
                    if ("Date".equalsIgnoreCase(name)) {
                        this.f20033d = HttpDate.parse(value);
                        this.f20034e = value;
                    } else if ("Expires".equalsIgnoreCase(name)) {
                        this.f20037h = HttpDate.parse(value);
                    } else if ("Last-Modified".equalsIgnoreCase(name)) {
                        this.f20035f = HttpDate.parse(value);
                        this.f20036g = value;
                    } else if ("ETag".equalsIgnoreCase(name)) {
                        this.f20040k = value;
                    } else if ("Age".equalsIgnoreCase(name)) {
                        this.f20041l = HttpHeaders.parseSeconds(value, -1);
                    }
                }
            }
        }

        /* renamed from: a */
        private long m11998a() {
            Date date = this.f20033d;
            long j = 0;
            if (date != null) {
                j = Math.max(0, this.f20039j - date.getTime());
            }
            int i = this.f20041l;
            if (i != -1) {
                j = Math.max(j, TimeUnit.SECONDS.toMillis((long) i));
            }
            long j2 = this.f20039j;
            return j + (j2 - this.f20038i) + (this.f20030a - j2);
        }

        /* renamed from: b */
        private long m11999b() {
            long j;
            long j2;
            CacheControl cacheControl = this.f20032c.cacheControl();
            if (cacheControl.maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis((long) cacheControl.maxAgeSeconds());
            }
            if (this.f20037h != null) {
                Date date = this.f20033d;
                if (date != null) {
                    j2 = date.getTime();
                } else {
                    j2 = this.f20039j;
                }
                long time = this.f20037h.getTime() - j2;
                if (time > 0) {
                    return time;
                }
                return 0;
            } else if (this.f20035f == null || this.f20032c.request().url().query() != null) {
                return 0;
            } else {
                Date date2 = this.f20033d;
                if (date2 != null) {
                    j = date2.getTime();
                } else {
                    j = this.f20038i;
                }
                long time2 = j - this.f20035f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
                return 0;
            }
        }

        /* renamed from: c */
        private CacheStrategy m12000c() {
            if (this.f20032c == null) {
                return new CacheStrategy(this.f20031b, (Response) null);
            }
            if (this.f20031b.isHttps() && this.f20032c.handshake() == null) {
                return new CacheStrategy(this.f20031b, (Response) null);
            }
            if (!CacheStrategy.isCacheable(this.f20032c, this.f20031b)) {
                return new CacheStrategy(this.f20031b, (Response) null);
            }
            CacheControl cacheControl = this.f20031b.cacheControl();
            if (cacheControl.noCache() || m12001d(this.f20031b)) {
                return new CacheStrategy(this.f20031b, (Response) null);
            }
            CacheControl cacheControl2 = this.f20032c.cacheControl();
            long a = m11998a();
            long b = m11999b();
            if (cacheControl.maxAgeSeconds() != -1) {
                b = Math.min(b, TimeUnit.SECONDS.toMillis((long) cacheControl.maxAgeSeconds()));
            }
            long j = 0;
            long millis = cacheControl.minFreshSeconds() != -1 ? TimeUnit.SECONDS.toMillis((long) cacheControl.minFreshSeconds()) : 0;
            if (!cacheControl2.mustRevalidate() && cacheControl.maxStaleSeconds() != -1) {
                j = TimeUnit.SECONDS.toMillis((long) cacheControl.maxStaleSeconds());
            }
            if (!cacheControl2.noCache()) {
                long j2 = millis + a;
                if (j2 < j + b) {
                    Response.Builder newBuilder = this.f20032c.newBuilder();
                    if (j2 >= b) {
                        newBuilder.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (a > 86400000 && m12002e()) {
                        newBuilder.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new CacheStrategy((Request) null, newBuilder.build());
                }
            }
            String str = this.f20040k;
            String str2 = "If-Modified-Since";
            if (str != null) {
                str2 = "If-None-Match";
            } else if (this.f20035f != null) {
                str = this.f20036g;
            } else if (this.f20033d == null) {
                return new CacheStrategy(this.f20031b, (Response) null);
            } else {
                str = this.f20034e;
            }
            Headers.Builder newBuilder2 = this.f20031b.headers().newBuilder();
            Internal.instance.addLenient(newBuilder2, str2, str);
            return new CacheStrategy(this.f20031b.newBuilder().headers(newBuilder2.build()).build(), this.f20032c);
        }

        /* renamed from: d */
        private static boolean m12001d(Request request) {
            return (request.header("If-Modified-Since") == null && request.header("If-None-Match") == null) ? false : true;
        }

        /* renamed from: e */
        private boolean m12002e() {
            return this.f20032c.cacheControl().maxAgeSeconds() == -1 && this.f20037h == null;
        }

        public CacheStrategy get() {
            CacheStrategy c = m12000c();
            return (c.networkRequest == null || !this.f20031b.cacheControl().onlyIfCached()) ? c : new CacheStrategy((Request) null, (Response) null);
        }
    }

    CacheStrategy(Request request, Response response) {
        this.networkRequest = request;
        this.cacheResponse = response;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0056, code lost:
        if (r3.cacheControl().isPrivate() == false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0059, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isCacheable(okhttp3.Response r3, okhttp3.Request r4) {
        /*
            int r0 = r3.code()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L_0x005a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L_0x0031
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L_0x005a
            switch(r0) {
                case 300: goto L_0x005a;
                case 301: goto L_0x005a;
                case 302: goto L_0x0031;
                default: goto L_0x0030;
            }
        L_0x0030:
            goto L_0x0059
        L_0x0031:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.header(r0)
            if (r0 != 0) goto L_0x005a
            okhttp3.CacheControl r0 = r3.cacheControl()
            int r0 = r0.maxAgeSeconds()
            r1 = -1
            if (r0 != r1) goto L_0x005a
            okhttp3.CacheControl r0 = r3.cacheControl()
            boolean r0 = r0.isPublic()
            if (r0 != 0) goto L_0x005a
            okhttp3.CacheControl r0 = r3.cacheControl()
            boolean r0 = r0.isPrivate()
            if (r0 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            return r2
        L_0x005a:
            okhttp3.CacheControl r3 = r3.cacheControl()
            boolean r3 = r3.noStore()
            if (r3 != 0) goto L_0x006f
            okhttp3.CacheControl r3 = r4.cacheControl()
            boolean r3 = r3.noStore()
            if (r3 != 0) goto L_0x006f
            r2 = 1
        L_0x006f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.CacheStrategy.isCacheable(okhttp3.Response, okhttp3.Request):boolean");
    }
}
