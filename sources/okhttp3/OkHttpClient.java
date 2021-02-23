package okhttp3;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.p007ws.RealWebSocket;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {

    /* renamed from: C */
    static final List<Protocol> f19894C = Util.immutableList((T[]) new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});

    /* renamed from: D */
    static final List<ConnectionSpec> f19895D = Util.immutableList((T[]) new ConnectionSpec[]{ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT});

    /* renamed from: A */
    final int f19896A;

    /* renamed from: B */
    final int f19897B;

    /* renamed from: a */
    final Dispatcher f19898a;
    @Nullable

    /* renamed from: b */
    final Proxy f19899b;

    /* renamed from: c */
    final List<Protocol> f19900c;

    /* renamed from: d */
    final List<ConnectionSpec> f19901d;

    /* renamed from: e */
    final List<Interceptor> f19902e;

    /* renamed from: f */
    final List<Interceptor> f19903f;

    /* renamed from: g */
    final EventListener.Factory f19904g;

    /* renamed from: h */
    final ProxySelector f19905h;

    /* renamed from: i */
    final CookieJar f19906i;
    @Nullable

    /* renamed from: j */
    final Cache f19907j;
    @Nullable

    /* renamed from: k */
    final InternalCache f19908k;

    /* renamed from: l */
    final SocketFactory f19909l;

    /* renamed from: m */
    final SSLSocketFactory f19910m;

    /* renamed from: n */
    final CertificateChainCleaner f19911n;

    /* renamed from: o */
    final HostnameVerifier f19912o;

    /* renamed from: p */
    final CertificatePinner f19913p;

    /* renamed from: q */
    final Authenticator f19914q;

    /* renamed from: r */
    final Authenticator f19915r;

    /* renamed from: s */
    final ConnectionPool f19916s;

    /* renamed from: t */
    final Dns f19917t;

    /* renamed from: u */
    final boolean f19918u;

    /* renamed from: v */
    final boolean f19919v;

    /* renamed from: w */
    final boolean f19920w;

    /* renamed from: x */
    final int f19921x;

    /* renamed from: y */
    final int f19922y;

    /* renamed from: z */
    final int f19923z;

    public static final class Builder {

        /* renamed from: A */
        int f19924A;

        /* renamed from: B */
        int f19925B;

        /* renamed from: a */
        Dispatcher f19926a;
        @Nullable

        /* renamed from: b */
        Proxy f19927b;

        /* renamed from: c */
        List<Protocol> f19928c;

        /* renamed from: d */
        List<ConnectionSpec> f19929d;

        /* renamed from: e */
        final List<Interceptor> f19930e;

        /* renamed from: f */
        final List<Interceptor> f19931f;

        /* renamed from: g */
        EventListener.Factory f19932g;

        /* renamed from: h */
        ProxySelector f19933h;

        /* renamed from: i */
        CookieJar f19934i;
        @Nullable

        /* renamed from: j */
        Cache f19935j;
        @Nullable

        /* renamed from: k */
        InternalCache f19936k;

        /* renamed from: l */
        SocketFactory f19937l;
        @Nullable

        /* renamed from: m */
        SSLSocketFactory f19938m;
        @Nullable

        /* renamed from: n */
        CertificateChainCleaner f19939n;

        /* renamed from: o */
        HostnameVerifier f19940o;

        /* renamed from: p */
        CertificatePinner f19941p;

        /* renamed from: q */
        Authenticator f19942q;

        /* renamed from: r */
        Authenticator f19943r;

        /* renamed from: s */
        ConnectionPool f19944s;

        /* renamed from: t */
        Dns f19945t;

        /* renamed from: u */
        boolean f19946u;

        /* renamed from: v */
        boolean f19947v;

        /* renamed from: w */
        boolean f19948w;

        /* renamed from: x */
        int f19949x;

        /* renamed from: y */
        int f19950y;

        /* renamed from: z */
        int f19951z;

        public Builder() {
            this.f19930e = new ArrayList();
            this.f19931f = new ArrayList();
            this.f19926a = new Dispatcher();
            this.f19928c = OkHttpClient.f19894C;
            this.f19929d = OkHttpClient.f19895D;
            this.f19932g = EventListener.m11937a(EventListener.NONE);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.f19933h = proxySelector;
            if (proxySelector == null) {
                this.f19933h = new NullProxySelector();
            }
            this.f19934i = CookieJar.NO_COOKIES;
            this.f19937l = SocketFactory.getDefault();
            this.f19940o = OkHostnameVerifier.INSTANCE;
            this.f19941p = CertificatePinner.DEFAULT;
            Authenticator authenticator = Authenticator.NONE;
            this.f19942q = authenticator;
            this.f19943r = authenticator;
            this.f19944s = new ConnectionPool();
            this.f19945t = Dns.SYSTEM;
            this.f19946u = true;
            this.f19947v = true;
            this.f19948w = true;
            this.f19949x = 0;
            this.f19950y = 10000;
            this.f19951z = 10000;
            this.f19924A = 10000;
            this.f19925B = 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo22122a(@Nullable InternalCache internalCache) {
            this.f19936k = internalCache;
            this.f19935j = null;
        }

        public Builder addInterceptor(Interceptor interceptor) {
            if (interceptor != null) {
                this.f19930e.add(interceptor);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public Builder addNetworkInterceptor(Interceptor interceptor) {
            if (interceptor != null) {
                this.f19931f.add(interceptor);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public Builder authenticator(Authenticator authenticator) {
            if (authenticator != null) {
                this.f19943r = authenticator;
                return this;
            }
            throw new NullPointerException("authenticator == null");
        }

        public OkHttpClient build() {
            return new OkHttpClient(this);
        }

        public Builder cache(@Nullable Cache cache) {
            this.f19935j = cache;
            this.f19936k = null;
            return this;
        }

        public Builder callTimeout(long j, TimeUnit timeUnit) {
            this.f19949x = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder certificatePinner(CertificatePinner certificatePinner) {
            if (certificatePinner != null) {
                this.f19941p = certificatePinner;
                return this;
            }
            throw new NullPointerException("certificatePinner == null");
        }

        public Builder connectTimeout(long j, TimeUnit timeUnit) {
            this.f19950y = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder connectionPool(ConnectionPool connectionPool) {
            if (connectionPool != null) {
                this.f19944s = connectionPool;
                return this;
            }
            throw new NullPointerException("connectionPool == null");
        }

        public Builder connectionSpecs(List<ConnectionSpec> list) {
            this.f19929d = Util.immutableList(list);
            return this;
        }

        public Builder cookieJar(CookieJar cookieJar) {
            if (cookieJar != null) {
                this.f19934i = cookieJar;
                return this;
            }
            throw new NullPointerException("cookieJar == null");
        }

        public Builder dispatcher(Dispatcher dispatcher) {
            if (dispatcher != null) {
                this.f19926a = dispatcher;
                return this;
            }
            throw new IllegalArgumentException("dispatcher == null");
        }

        public Builder dns(Dns dns) {
            if (dns != null) {
                this.f19945t = dns;
                return this;
            }
            throw new NullPointerException("dns == null");
        }

        public Builder eventListener(EventListener eventListener) {
            if (eventListener != null) {
                this.f19932g = EventListener.m11937a(eventListener);
                return this;
            }
            throw new NullPointerException("eventListener == null");
        }

        public Builder eventListenerFactory(EventListener.Factory factory) {
            if (factory != null) {
                this.f19932g = factory;
                return this;
            }
            throw new NullPointerException("eventListenerFactory == null");
        }

        public Builder followRedirects(boolean z) {
            this.f19947v = z;
            return this;
        }

        public Builder followSslRedirects(boolean z) {
            this.f19946u = z;
            return this;
        }

        public Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier != null) {
                this.f19940o = hostnameVerifier;
                return this;
            }
            throw new NullPointerException("hostnameVerifier == null");
        }

        public List<Interceptor> interceptors() {
            return this.f19930e;
        }

        public List<Interceptor> networkInterceptors() {
            return this.f19931f;
        }

        public Builder pingInterval(long j, TimeUnit timeUnit) {
            this.f19925B = Util.checkDuration("interval", j, timeUnit);
            return this;
        }

        public Builder protocols(List<Protocol> list) {
            ArrayList arrayList = new ArrayList(list);
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (!arrayList.contains(protocol) && !arrayList.contains(Protocol.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + arrayList);
            } else if (arrayList.contains(protocol) && arrayList.size() > 1) {
                throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayList);
            } else if (arrayList.contains(Protocol.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
            } else if (!arrayList.contains((Object) null)) {
                arrayList.remove(Protocol.SPDY_3);
                this.f19928c = Collections.unmodifiableList(arrayList);
                return this;
            } else {
                throw new IllegalArgumentException("protocols must not contain null");
            }
        }

        public Builder proxy(@Nullable Proxy proxy) {
            this.f19927b = proxy;
            return this;
        }

        public Builder proxyAuthenticator(Authenticator authenticator) {
            if (authenticator != null) {
                this.f19942q = authenticator;
                return this;
            }
            throw new NullPointerException("proxyAuthenticator == null");
        }

        public Builder proxySelector(ProxySelector proxySelector) {
            if (proxySelector != null) {
                this.f19933h = proxySelector;
                return this;
            }
            throw new NullPointerException("proxySelector == null");
        }

        public Builder readTimeout(long j, TimeUnit timeUnit) {
            this.f19951z = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder retryOnConnectionFailure(boolean z) {
            this.f19948w = z;
            return this;
        }

        public Builder socketFactory(SocketFactory socketFactory) {
            if (socketFactory != null) {
                this.f19937l = socketFactory;
                return this;
            }
            throw new NullPointerException("socketFactory == null");
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory != null) {
                this.f19938m = sSLSocketFactory;
                this.f19939n = Platform.get().buildCertificateChainCleaner(sSLSocketFactory);
                return this;
            }
            throw new NullPointerException("sslSocketFactory == null");
        }

        public Builder writeTimeout(long j, TimeUnit timeUnit) {
            this.f19924A = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        @IgnoreJRERequirement
        public Builder callTimeout(Duration duration) {
            this.f19949x = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @IgnoreJRERequirement
        public Builder connectTimeout(Duration duration) {
            this.f19950y = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @IgnoreJRERequirement
        public Builder pingInterval(Duration duration) {
            this.f19925B = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @IgnoreJRERequirement
        public Builder readTimeout(Duration duration) {
            this.f19951z = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @IgnoreJRERequirement
        public Builder writeTimeout(Duration duration) {
            this.f19924A = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            } else if (x509TrustManager != null) {
                this.f19938m = sSLSocketFactory;
                this.f19939n = CertificateChainCleaner.get(x509TrustManager);
                return this;
            } else {
                throw new NullPointerException("trustManager == null");
            }
        }

        Builder(OkHttpClient okHttpClient) {
            ArrayList arrayList = new ArrayList();
            this.f19930e = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f19931f = arrayList2;
            this.f19926a = okHttpClient.f19898a;
            this.f19927b = okHttpClient.f19899b;
            this.f19928c = okHttpClient.f19900c;
            this.f19929d = okHttpClient.f19901d;
            arrayList.addAll(okHttpClient.f19902e);
            arrayList2.addAll(okHttpClient.f19903f);
            this.f19932g = okHttpClient.f19904g;
            this.f19933h = okHttpClient.f19905h;
            this.f19934i = okHttpClient.f19906i;
            this.f19936k = okHttpClient.f19908k;
            this.f19935j = okHttpClient.f19907j;
            this.f19937l = okHttpClient.f19909l;
            this.f19938m = okHttpClient.f19910m;
            this.f19939n = okHttpClient.f19911n;
            this.f19940o = okHttpClient.f19912o;
            this.f19941p = okHttpClient.f19913p;
            this.f19942q = okHttpClient.f19914q;
            this.f19943r = okHttpClient.f19915r;
            this.f19944s = okHttpClient.f19916s;
            this.f19945t = okHttpClient.f19917t;
            this.f19946u = okHttpClient.f19918u;
            this.f19947v = okHttpClient.f19919v;
            this.f19948w = okHttpClient.f19920w;
            this.f19949x = okHttpClient.f19921x;
            this.f19950y = okHttpClient.f19922y;
            this.f19951z = okHttpClient.f19923z;
            this.f19924A = okHttpClient.f19896A;
            this.f19925B = okHttpClient.f19897B;
        }
    }

    /* renamed from: okhttp3.OkHttpClient$a */
    class C3535a extends Internal {
        C3535a() {
        }

        public void addLenient(Headers.Builder builder, String str) {
            builder.mo21988a(str);
        }

        public void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z) {
            connectionSpec.mo21880a(sSLSocket, z);
        }

        public int code(Response.Builder builder) {
            return builder.f19986c;
        }

        public boolean connectionBecameIdle(ConnectionPool connectionPool, RealConnection realConnection) {
            return connectionPool.mo21872b(realConnection);
        }

        public Socket deduplicate(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
            return connectionPool.mo21873c(address, streamAllocation);
        }

        public boolean equalsNonHost(Address address, Address address2) {
            return address.mo21759a(address2);
        }

        public RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route) {
            return connectionPool.mo21875d(address, streamAllocation, route);
        }

        public boolean isInvalidHttpUrlHost(IllegalArgumentException illegalArgumentException) {
            return illegalArgumentException.getMessage().startsWith("Invalid URL host");
        }

        public Call newWebSocketCall(OkHttpClient okHttpClient, Request request) {
            return C3541a.m11983e(okHttpClient, request, true);
        }

        public void put(ConnectionPool connectionPool, RealConnection realConnection) {
            connectionPool.mo21877f(realConnection);
        }

        public RouteDatabase routeDatabase(ConnectionPool connectionPool) {
            return connectionPool.f19802e;
        }

        public void setCache(Builder builder, InternalCache internalCache) {
            builder.mo22122a(internalCache);
        }

        public StreamAllocation streamAllocation(Call call) {
            return ((C3541a) call).mo22273g();
        }

        @Nullable
        public IOException timeoutExit(Call call, @Nullable IOException iOException) {
            return ((C3541a) call).mo22274h(iOException);
        }

        public void addLenient(Headers.Builder builder, String str, String str2) {
            builder.mo21994b(str, str2);
        }
    }

    static {
        Internal.instance = new C3535a();
    }

    public OkHttpClient() {
        this(new Builder());
    }

    /* renamed from: b */
    private static SSLSocketFactory m11975b(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = Platform.get().getSSLContext();
            sSLContext.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw Util.assertionError("No System TLS", e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public InternalCache mo22093a() {
        Cache cache = this.f19907j;
        return cache != null ? cache.f19731a : this.f19908k;
    }

    public Authenticator authenticator() {
        return this.f19915r;
    }

    @Nullable
    public Cache cache() {
        return this.f19907j;
    }

    public int callTimeoutMillis() {
        return this.f19921x;
    }

    public CertificatePinner certificatePinner() {
        return this.f19913p;
    }

    public int connectTimeoutMillis() {
        return this.f19922y;
    }

    public ConnectionPool connectionPool() {
        return this.f19916s;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.f19901d;
    }

    public CookieJar cookieJar() {
        return this.f19906i;
    }

    public Dispatcher dispatcher() {
        return this.f19898a;
    }

    public Dns dns() {
        return this.f19917t;
    }

    public EventListener.Factory eventListenerFactory() {
        return this.f19904g;
    }

    public boolean followRedirects() {
        return this.f19919v;
    }

    public boolean followSslRedirects() {
        return this.f19918u;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.f19912o;
    }

    public List<Interceptor> interceptors() {
        return this.f19902e;
    }

    public List<Interceptor> networkInterceptors() {
        return this.f19903f;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public Call newCall(Request request) {
        return C3541a.m11983e(this, request, false);
    }

    public WebSocket newWebSocket(Request request, WebSocketListener webSocketListener) {
        RealWebSocket realWebSocket = new RealWebSocket(request, webSocketListener, new Random(), (long) this.f19897B);
        realWebSocket.connect(this);
        return realWebSocket;
    }

    public int pingIntervalMillis() {
        return this.f19897B;
    }

    public List<Protocol> protocols() {
        return this.f19900c;
    }

    @Nullable
    public Proxy proxy() {
        return this.f19899b;
    }

    public Authenticator proxyAuthenticator() {
        return this.f19914q;
    }

    public ProxySelector proxySelector() {
        return this.f19905h;
    }

    public int readTimeoutMillis() {
        return this.f19923z;
    }

    public boolean retryOnConnectionFailure() {
        return this.f19920w;
    }

    public SocketFactory socketFactory() {
        return this.f19909l;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.f19910m;
    }

    public int writeTimeoutMillis() {
        return this.f19896A;
    }

    OkHttpClient(Builder builder) {
        boolean z;
        this.f19898a = builder.f19926a;
        this.f19899b = builder.f19927b;
        this.f19900c = builder.f19928c;
        List<ConnectionSpec> list = builder.f19929d;
        this.f19901d = list;
        this.f19902e = Util.immutableList(builder.f19930e);
        this.f19903f = Util.immutableList(builder.f19931f);
        this.f19904g = builder.f19932g;
        this.f19905h = builder.f19933h;
        this.f19906i = builder.f19934i;
        this.f19907j = builder.f19935j;
        this.f19908k = builder.f19936k;
        this.f19909l = builder.f19937l;
        Iterator<ConnectionSpec> it = list.iterator();
        loop0:
        while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                ConnectionSpec next = it.next();
                if (z || next.isTls()) {
                    z = true;
                }
            }
        }
        SSLSocketFactory sSLSocketFactory = builder.f19938m;
        if (sSLSocketFactory != null || !z) {
            this.f19910m = sSLSocketFactory;
            this.f19911n = builder.f19939n;
        } else {
            X509TrustManager platformTrustManager = Util.platformTrustManager();
            this.f19910m = m11975b(platformTrustManager);
            this.f19911n = CertificateChainCleaner.get(platformTrustManager);
        }
        if (this.f19910m != null) {
            Platform.get().configureSslSocketFactory(this.f19910m);
        }
        this.f19912o = builder.f19940o;
        this.f19913p = builder.f19941p.mo21850d(this.f19911n);
        this.f19914q = builder.f19942q;
        this.f19915r = builder.f19943r;
        this.f19916s = builder.f19944s;
        this.f19917t = builder.f19945t;
        this.f19918u = builder.f19946u;
        this.f19919v = builder.f19947v;
        this.f19920w = builder.f19948w;
        this.f19921x = builder.f19949x;
        this.f19922y = builder.f19950y;
        this.f19923z = builder.f19951z;
        this.f19896A = builder.f19924A;
        this.f19897B = builder.f19925B;
        if (this.f19902e.contains((Object) null)) {
            throw new IllegalStateException("Null interceptor: " + this.f19902e);
        } else if (this.f19903f.contains((Object) null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f19903f);
        }
    }
}
