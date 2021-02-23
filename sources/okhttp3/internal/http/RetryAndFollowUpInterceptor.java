package okhttp3.internal.http;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http2.ConnectionShutdownException;

public final class RetryAndFollowUpInterceptor implements Interceptor {

    /* renamed from: a */
    private final OkHttpClient f21158a;

    /* renamed from: b */
    private volatile StreamAllocation f21159b;

    /* renamed from: c */
    private Object f21160c;

    /* renamed from: d */
    private volatile boolean f21161d;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient, boolean z) {
        this.f21158a = okHttpClient;
    }

    /* renamed from: a */
    private Address m14254a(HttpUrl httpUrl) {
        CertificatePinner certificatePinner;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (httpUrl.isHttps()) {
            SSLSocketFactory sslSocketFactory = this.f21158a.sslSocketFactory();
            hostnameVerifier = this.f21158a.hostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            certificatePinner = this.f21158a.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.f21158a.dns(), this.f21158a.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.f21158a.proxyAuthenticator(), this.f21158a.proxy(), this.f21158a.protocols(), this.f21158a.connectionSpecs(), this.f21158a.proxySelector());
    }

    /* renamed from: b */
    private Request m14255b(Response response, Route route) {
        String header;
        HttpUrl resolve;
        Proxy proxy;
        if (response != null) {
            int code = response.code();
            String method = response.request().method();
            RequestBody requestBody = null;
            if (code == 307 || code == 308) {
                if (!method.equals("GET") && !method.equals("HEAD")) {
                    return null;
                }
            } else if (code == 401) {
                return this.f21158a.authenticator().authenticate(route, response);
            } else {
                if (code != 503) {
                    if (code == 407) {
                        if (route != null) {
                            proxy = route.proxy();
                        } else {
                            proxy = this.f21158a.proxy();
                        }
                        if (proxy.type() == Proxy.Type.HTTP) {
                            return this.f21158a.proxyAuthenticator().authenticate(route, response);
                        }
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    } else if (code != 408) {
                        switch (code) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                break;
                            default:
                                return null;
                        }
                    } else if (!this.f21158a.retryOnConnectionFailure() || (response.request().body() instanceof UnrepeatableRequestBody)) {
                        return null;
                    } else {
                        if ((response.priorResponse() == null || response.priorResponse().code() != 408) && m14258e(response, 0) <= 0) {
                            return response.request();
                        }
                        return null;
                    }
                } else if ((response.priorResponse() == null || response.priorResponse().code() != 503) && m14258e(response, Integer.MAX_VALUE) == 0) {
                    return response.request();
                } else {
                    return null;
                }
            }
            if (!this.f21158a.followRedirects() || (header = response.header("Location")) == null || (resolve = response.request().url().resolve(header)) == null) {
                return null;
            }
            if (!resolve.scheme().equals(response.request().url().scheme()) && !this.f21158a.followSslRedirects()) {
                return null;
            }
            Request.Builder newBuilder = response.request().newBuilder();
            if (HttpMethod.permitsRequestBody(method)) {
                boolean redirectsWithBody = HttpMethod.redirectsWithBody(method);
                if (HttpMethod.redirectsToGet(method)) {
                    newBuilder.method("GET", (RequestBody) null);
                } else {
                    if (redirectsWithBody) {
                        requestBody = response.request().body();
                    }
                    newBuilder.method(method, requestBody);
                }
                if (!redirectsWithBody) {
                    newBuilder.removeHeader("Transfer-Encoding");
                    newBuilder.removeHeader("Content-Length");
                    newBuilder.removeHeader("Content-Type");
                }
            }
            if (!m14259f(response, resolve)) {
                newBuilder.removeHeader("Authorization");
            }
            return newBuilder.url(resolve).build();
        }
        throw new IllegalStateException();
    }

    /* renamed from: c */
    private boolean m14256c(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || z) {
                return false;
            }
            return true;
        } else if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: d */
    private boolean m14257d(IOException iOException, StreamAllocation streamAllocation, boolean z, Request request) {
        streamAllocation.streamFailed(iOException);
        if (!this.f21158a.retryOnConnectionFailure()) {
            return false;
        }
        if ((!z || !(request.body() instanceof UnrepeatableRequestBody)) && m14256c(iOException, z) && streamAllocation.hasMoreRoutes()) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    private int m14258e(Response response, int i) {
        String header = response.header("Retry-After");
        if (header == null) {
            return i;
        }
        if (header.matches("\\d+")) {
            return Integer.valueOf(header).intValue();
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: f */
    private boolean m14259f(Response response, HttpUrl httpUrl) {
        HttpUrl url = response.request().url();
        return url.host().equals(httpUrl.host()) && url.port() == httpUrl.port() && url.scheme().equals(httpUrl.scheme());
    }

    public void cancel() {
        this.f21161d = true;
        StreamAllocation streamAllocation = this.f21159b;
        if (streamAllocation != null) {
            streamAllocation.cancel();
        }
    }

    public Response intercept(Interceptor.Chain chain) {
        Request request = chain.request();
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Call call = realInterceptorChain.call();
        EventListener eventListener = realInterceptorChain.eventListener();
        StreamAllocation streamAllocation = new StreamAllocation(this.f21158a.connectionPool(), m14254a(request.url()), call, eventListener, this.f21160c);
        this.f21159b = streamAllocation;
        Response response = null;
        int i = 0;
        while (!this.f21161d) {
            try {
                Response proceed = realInterceptorChain.proceed(request, streamAllocation, (HttpCodec) null, (RealConnection) null);
                if (response != null) {
                    proceed = proceed.newBuilder().priorResponse(response.newBuilder().body((ResponseBody) null).build()).build();
                }
                try {
                    Request b = m14255b(proceed, streamAllocation.route());
                    if (b == null) {
                        streamAllocation.release();
                        return proceed;
                    }
                    Util.closeQuietly((Closeable) proceed.body());
                    int i2 = i + 1;
                    if (i2 > 20) {
                        streamAllocation.release();
                        throw new ProtocolException("Too many follow-up requests: " + i2);
                    } else if (!(b.body() instanceof UnrepeatableRequestBody)) {
                        if (!m14259f(proceed, b.url())) {
                            streamAllocation.release();
                            streamAllocation = new StreamAllocation(this.f21158a.connectionPool(), m14254a(b.url()), call, eventListener, this.f21160c);
                            this.f21159b = streamAllocation;
                        } else if (streamAllocation.codec() != null) {
                            throw new IllegalStateException("Closing the body of " + proceed + " didn't close its backing stream. Bad interceptor?");
                        }
                        response = proceed;
                        request = b;
                        i = i2;
                    } else {
                        streamAllocation.release();
                        throw new HttpRetryException("Cannot retry streamed HTTP body", proceed.code());
                    }
                } catch (IOException e) {
                    streamAllocation.release();
                    throw e;
                }
            } catch (RouteException e2) {
                if (!m14257d(e2.getLastConnectException(), streamAllocation, false, request)) {
                    throw e2.getFirstConnectException();
                }
            } catch (IOException e3) {
                if (!m14257d(e3, streamAllocation, !(e3 instanceof ConnectionShutdownException), request)) {
                    throw e3;
                }
            } catch (Throwable th) {
                streamAllocation.streamFailed((IOException) null);
                streamAllocation.release();
                throw th;
            }
        }
        streamAllocation.release();
        throw new IOException("Canceled");
    }

    public boolean isCanceled() {
        return this.f21161d;
    }

    public void setCallStackTrace(Object obj) {
        this.f21160c = obj;
    }

    public StreamAllocation streamAllocation() {
        return this.f21159b;
    }
}
