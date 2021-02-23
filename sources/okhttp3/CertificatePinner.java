package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;

public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = new Builder().build();

    /* renamed from: a */
    private final Set<C3531a> f19788a;
    @Nullable

    /* renamed from: b */
    private final CertificateChainCleaner f19789b;

    public static final class Builder {

        /* renamed from: a */
        private final List<C3531a> f19790a = new ArrayList();

        public Builder add(String str, String... strArr) {
            if (str != null) {
                for (String aVar : strArr) {
                    this.f19790a.add(new C3531a(str, aVar));
                }
                return this;
            }
            throw new NullPointerException("pattern == null");
        }

        public CertificatePinner build() {
            return new CertificatePinner(new LinkedHashSet(this.f19790a), (CertificateChainCleaner) null);
        }
    }

    /* renamed from: okhttp3.CertificatePinner$a */
    static final class C3531a {

        /* renamed from: a */
        final String f19791a;

        /* renamed from: b */
        final String f19792b;

        /* renamed from: c */
        final String f19793c;

        /* renamed from: d */
        final ByteString f19794d;

        C3531a(String str, String str2) {
            String str3;
            this.f19791a = str;
            if (str.startsWith("*.")) {
                str3 = HttpUrl.get("http://" + str.substring(2)).host();
            } else {
                str3 = HttpUrl.get("http://" + str).host();
            }
            this.f19792b = str3;
            if (str2.startsWith("sha1/")) {
                this.f19793c = "sha1/";
                this.f19794d = ByteString.decodeBase64(str2.substring(5));
            } else if (str2.startsWith("sha256/")) {
                this.f19793c = "sha256/";
                this.f19794d = ByteString.decodeBase64(str2.substring(7));
            } else {
                throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + str2);
            }
            if (this.f19794d == null) {
                throw new IllegalArgumentException("pins must be base64: " + str2);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo21855a(String str) {
            if (!this.f19791a.startsWith("*.")) {
                return str.equals(this.f19792b);
            }
            int indexOf = str.indexOf(46);
            if ((str.length() - indexOf) - 1 == this.f19792b.length()) {
                String str2 = this.f19792b;
                if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C3531a) {
                C3531a aVar = (C3531a) obj;
                return this.f19791a.equals(aVar.f19791a) && this.f19793c.equals(aVar.f19793c) && this.f19794d.equals(aVar.f19794d);
            }
        }

        public int hashCode() {
            return ((((527 + this.f19791a.hashCode()) * 31) + this.f19793c.hashCode()) * 31) + this.f19794d.hashCode();
        }

        public String toString() {
            return this.f19793c + this.f19794d.base64();
        }
    }

    CertificatePinner(Set<C3531a> set, @Nullable CertificateChainCleaner certificateChainCleaner) {
        this.f19788a = set;
        this.f19789b = certificateChainCleaner;
    }

    /* renamed from: b */
    static ByteString m11908b(X509Certificate x509Certificate) {
        return ByteString.m12083of(x509Certificate.getPublicKey().getEncoded()).sha1();
    }

    /* renamed from: c */
    static ByteString m11909c(X509Certificate x509Certificate) {
        return ByteString.m12083of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }

    public static String pin(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + m11909c((X509Certificate) certificate).base64();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<C3531a> mo21847a(String str) {
        List<C3531a> emptyList = Collections.emptyList();
        for (C3531a next : this.f19788a) {
            if (next.mo21855a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(next);
            }
        }
        return emptyList;
    }

    public void check(String str, List<Certificate> list) {
        List<C3531a> a = mo21847a(str);
        if (!a.isEmpty()) {
            CertificateChainCleaner certificateChainCleaner = this.f19789b;
            if (certificateChainCleaner != null) {
                list = certificateChainCleaner.clean(list, str);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i);
                int size2 = a.size();
                ByteString byteString = null;
                ByteString byteString2 = null;
                for (int i2 = 0; i2 < size2; i2++) {
                    C3531a aVar = a.get(i2);
                    if (aVar.f19793c.equals("sha256/")) {
                        if (byteString == null) {
                            byteString = m11909c(x509Certificate);
                        }
                        if (aVar.f19794d.equals(byteString)) {
                            return;
                        }
                    } else if (aVar.f19793c.equals("sha1/")) {
                        if (byteString2 == null) {
                            byteString2 = m11908b(x509Certificate);
                        }
                        if (aVar.f19794d.equals(byteString2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError("unsupported hashAlgorithm: " + aVar.f19793c);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Certificate pinning failure!");
            sb.append("\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i3 = 0; i3 < size3; i3++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
                sb.append("\n    ");
                sb.append(pin(x509Certificate2));
                sb.append(": ");
                sb.append(x509Certificate2.getSubjectDN().getName());
            }
            sb.append("\n  Pinned certificates for ");
            sb.append(str);
            sb.append(":");
            int size4 = a.size();
            for (int i4 = 0; i4 < size4; i4++) {
                sb.append("\n    ");
                sb.append(a.get(i4));
            }
            throw new SSLPeerUnverifiedException(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public CertificatePinner mo21850d(@Nullable CertificateChainCleaner certificateChainCleaner) {
        if (Util.equal(this.f19789b, certificateChainCleaner)) {
            return this;
        }
        return new CertificatePinner(this.f19788a, certificateChainCleaner);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (!Util.equal(this.f19789b, certificatePinner.f19789b) || !this.f19788a.equals(certificatePinner.f19788a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        CertificateChainCleaner certificateChainCleaner = this.f19789b;
        return ((certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0) * 31) + this.f19788a.hashCode();
    }

    public void check(String str, Certificate... certificateArr) {
        check(str, (List<Certificate>) Arrays.asList(certificateArr));
    }
}
