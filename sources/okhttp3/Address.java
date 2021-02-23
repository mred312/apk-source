package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;

public final class Address {

    /* renamed from: a */
    final HttpUrl f19720a;

    /* renamed from: b */
    final Dns f19721b;

    /* renamed from: c */
    final SocketFactory f19722c;

    /* renamed from: d */
    final Authenticator f19723d;

    /* renamed from: e */
    final List<Protocol> f19724e;

    /* renamed from: f */
    final List<ConnectionSpec> f19725f;

    /* renamed from: g */
    final ProxySelector f19726g;
    @Nullable

    /* renamed from: h */
    final Proxy f19727h;
    @Nullable

    /* renamed from: i */
    final SSLSocketFactory f19728i;
    @Nullable

    /* renamed from: j */
    final HostnameVerifier f19729j;
    @Nullable

    /* renamed from: k */
    final CertificatePinner f19730k;

    public Address(String str, int i, Dns dns, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable CertificatePinner certificatePinner, Authenticator authenticator, @Nullable Proxy proxy, List<Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        this.f19720a = new HttpUrl.Builder().scheme(sSLSocketFactory != null ? "https" : "http").host(str).port(i).build();
        if (dns != null) {
            this.f19721b = dns;
            if (socketFactory != null) {
                this.f19722c = socketFactory;
                if (authenticator != null) {
                    this.f19723d = authenticator;
                    if (list != null) {
                        this.f19724e = Util.immutableList(list);
                        if (list2 != null) {
                            this.f19725f = Util.immutableList(list2);
                            if (proxySelector != null) {
                                this.f19726g = proxySelector;
                                this.f19727h = proxy;
                                this.f19728i = sSLSocketFactory;
                                this.f19729j = hostnameVerifier;
                                this.f19730k = certificatePinner;
                                return;
                            }
                            throw new NullPointerException("proxySelector == null");
                        }
                        throw new NullPointerException("connectionSpecs == null");
                    }
                    throw new NullPointerException("protocols == null");
                }
                throw new NullPointerException("proxyAuthenticator == null");
            }
            throw new NullPointerException("socketFactory == null");
        }
        throw new NullPointerException("dns == null");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo21759a(Address address) {
        return this.f19721b.equals(address.f19721b) && this.f19723d.equals(address.f19723d) && this.f19724e.equals(address.f19724e) && this.f19725f.equals(address.f19725f) && this.f19726g.equals(address.f19726g) && Util.equal(this.f19727h, address.f19727h) && Util.equal(this.f19728i, address.f19728i) && Util.equal(this.f19729j, address.f19729j) && Util.equal(this.f19730k, address.f19730k) && url().port() == address.url().port();
    }

    @Nullable
    public CertificatePinner certificatePinner() {
        return this.f19730k;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.f19725f;
    }

    public Dns dns() {
        return this.f19721b;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            return this.f19720a.equals(address.f19720a) && mo21759a(address);
        }
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f19720a.hashCode()) * 31) + this.f19721b.hashCode()) * 31) + this.f19723d.hashCode()) * 31) + this.f19724e.hashCode()) * 31) + this.f19725f.hashCode()) * 31) + this.f19726g.hashCode()) * 31;
        Proxy proxy = this.f19727h;
        int i = 0;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f19728i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f19729j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        CertificatePinner certificatePinner = this.f19730k;
        if (certificatePinner != null) {
            i = certificatePinner.hashCode();
        }
        return hashCode4 + i;
    }

    @Nullable
    public HostnameVerifier hostnameVerifier() {
        return this.f19729j;
    }

    public List<Protocol> protocols() {
        return this.f19724e;
    }

    @Nullable
    public Proxy proxy() {
        return this.f19727h;
    }

    public Authenticator proxyAuthenticator() {
        return this.f19723d;
    }

    public ProxySelector proxySelector() {
        return this.f19726g;
    }

    public SocketFactory socketFactory() {
        return this.f19722c;
    }

    @Nullable
    public SSLSocketFactory sslSocketFactory() {
        return this.f19728i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f19720a.host());
        sb.append(":");
        sb.append(this.f19720a.port());
        if (this.f19727h != null) {
            sb.append(", proxy=");
            sb.append(this.f19727h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f19726g);
        }
        sb.append("}");
        return sb.toString();
    }

    public HttpUrl url() {
        return this.f19720a;
    }
}
