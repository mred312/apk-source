package okhttp3;

import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.Util;

public final class Handshake {

    /* renamed from: a */
    private final TlsVersion f19851a;

    /* renamed from: b */
    private final CipherSuite f19852b;

    /* renamed from: c */
    private final List<Certificate> f19853c;

    /* renamed from: d */
    private final List<Certificate> f19854d;

    private Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        this.f19851a = tlsVersion;
        this.f19852b = cipherSuite;
        this.f19853c = list;
        this.f19854d = list2;
    }

    public static Handshake get(SSLSession sSLSession) {
        Certificate[] certificateArr;
        List list;
        List list2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        } else if (!"SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            CipherSuite forJavaName = CipherSuite.forJavaName(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            } else if (!"NONE".equals(protocol)) {
                TlsVersion forJavaName2 = TlsVersion.forJavaName(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                if (certificateArr != null) {
                    list = Util.immutableList((T[]) certificateArr);
                } else {
                    list = Collections.emptyList();
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    list2 = Util.immutableList((T[]) localCertificates);
                } else {
                    list2 = Collections.emptyList();
                }
                return new Handshake(forJavaName2, forJavaName, list, list2);
            } else {
                throw new IOException("tlsVersion == NONE");
            }
        } else {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
    }

    public CipherSuite cipherSuite() {
        return this.f19852b;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake handshake = (Handshake) obj;
        if (!this.f19851a.equals(handshake.f19851a) || !this.f19852b.equals(handshake.f19852b) || !this.f19853c.equals(handshake.f19853c) || !this.f19854d.equals(handshake.f19854d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((527 + this.f19851a.hashCode()) * 31) + this.f19852b.hashCode()) * 31) + this.f19853c.hashCode()) * 31) + this.f19854d.hashCode();
    }

    public List<Certificate> localCertificates() {
        return this.f19854d;
    }

    @Nullable
    public Principal localPrincipal() {
        if (!this.f19854d.isEmpty()) {
            return ((X509Certificate) this.f19854d.get(0)).getSubjectX500Principal();
        }
        return null;
    }

    public List<Certificate> peerCertificates() {
        return this.f19853c;
    }

    @Nullable
    public Principal peerPrincipal() {
        if (!this.f19853c.isEmpty()) {
            return ((X509Certificate) this.f19853c.get(0)).getSubjectX500Principal();
        }
        return null;
    }

    public TlsVersion tlsVersion() {
        return this.f19851a;
    }

    public static Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        if (tlsVersion == null) {
            throw new NullPointerException("tlsVersion == null");
        } else if (cipherSuite != null) {
            return new Handshake(tlsVersion, cipherSuite, Util.immutableList(list), Util.immutableList(list2));
        } else {
            throw new NullPointerException("cipherSuite == null");
        }
    }
}
