package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.Util;

public final class ConnectionSpec {
    public static final ConnectionSpec CLEARTEXT = new Builder(false).build();
    public static final ConnectionSpec COMPATIBLE_TLS;
    public static final ConnectionSpec MODERN_TLS;
    public static final ConnectionSpec RESTRICTED_TLS;

    /* renamed from: e */
    private static final CipherSuite[] f19805e;

    /* renamed from: f */
    private static final CipherSuite[] f19806f;

    /* renamed from: a */
    final boolean f19807a;

    /* renamed from: b */
    final boolean f19808b;
    @Nullable

    /* renamed from: c */
    final String[] f19809c;
    @Nullable

    /* renamed from: d */
    final String[] f19810d;

    static {
        CipherSuite cipherSuite = CipherSuite.TLS_AES_128_GCM_SHA256;
        CipherSuite cipherSuite2 = CipherSuite.TLS_AES_256_GCM_SHA384;
        CipherSuite cipherSuite3 = CipherSuite.TLS_CHACHA20_POLY1305_SHA256;
        CipherSuite cipherSuite4 = CipherSuite.TLS_AES_128_CCM_SHA256;
        CipherSuite cipherSuite5 = CipherSuite.TLS_AES_256_CCM_8_SHA256;
        CipherSuite cipherSuite6 = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
        CipherSuite cipherSuite7 = CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
        CipherSuite cipherSuite8 = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
        CipherSuite cipherSuite9 = CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
        CipherSuite cipherSuite10 = CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
        CipherSuite cipherSuite11 = CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
        CipherSuite[] cipherSuiteArr = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9, cipherSuite10, cipherSuite11};
        f19805e = cipherSuiteArr;
        CipherSuite[] cipherSuiteArr2 = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9, cipherSuite10, cipherSuite11, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        f19806f = cipherSuiteArr2;
        Builder cipherSuites = new Builder(true).cipherSuites(cipherSuiteArr);
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        RESTRICTED_TLS = cipherSuites.tlsVersions(tlsVersion, tlsVersion2).supportsTlsExtensions(true).build();
        Builder cipherSuites2 = new Builder(true).cipherSuites(cipherSuiteArr2);
        TlsVersion tlsVersion3 = TlsVersion.TLS_1_0;
        MODERN_TLS = cipherSuites2.tlsVersions(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, tlsVersion3).supportsTlsExtensions(true).build();
        COMPATIBLE_TLS = new Builder(true).cipherSuites(cipherSuiteArr2).tlsVersions(tlsVersion3).supportsTlsExtensions(true).build();
    }

    ConnectionSpec(Builder builder) {
        this.f19807a = builder.f19811a;
        this.f19809c = builder.f19812b;
        this.f19810d = builder.f19813c;
        this.f19808b = builder.f19814d;
    }

    /* renamed from: b */
    private ConnectionSpec m11919b(SSLSocket sSLSocket, boolean z) {
        String[] strArr;
        String[] strArr2;
        if (this.f19809c != null) {
            strArr = Util.intersect(CipherSuite.f21097b, sSLSocket.getEnabledCipherSuites(), this.f19809c);
        } else {
            strArr = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f19810d != null) {
            strArr2 = Util.intersect(Util.NATURAL_ORDER, sSLSocket.getEnabledProtocols(), this.f19810d);
        } else {
            strArr2 = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int indexOf = Util.indexOf(CipherSuite.f21097b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && indexOf != -1) {
            strArr = Util.concat(strArr, supportedCipherSuites[indexOf]);
        }
        return new Builder(this).cipherSuites(strArr).tlsVersions(strArr2).build();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo21880a(SSLSocket sSLSocket, boolean z) {
        ConnectionSpec b = m11919b(sSLSocket, z);
        String[] strArr = b.f19810d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b.f19809c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    @Nullable
    public List<CipherSuite> cipherSuites() {
        String[] strArr = this.f19809c;
        if (strArr != null) {
            return CipherSuite.m14220a(strArr);
        }
        return null;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        boolean z = this.f19807a;
        if (z != connectionSpec.f19807a) {
            return false;
        }
        return !z || (Arrays.equals(this.f19809c, connectionSpec.f19809c) && Arrays.equals(this.f19810d, connectionSpec.f19810d) && this.f19808b == connectionSpec.f19808b);
    }

    public int hashCode() {
        if (this.f19807a) {
            return ((((527 + Arrays.hashCode(this.f19809c)) * 31) + Arrays.hashCode(this.f19810d)) * 31) + (this.f19808b ^ true ? 1 : 0);
        }
        return 17;
    }

    public boolean isCompatible(SSLSocket sSLSocket) {
        if (!this.f19807a) {
            return false;
        }
        String[] strArr = this.f19810d;
        if (strArr != null && !Util.nonEmptyIntersection(Util.NATURAL_ORDER, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f19809c;
        if (strArr2 == null || Util.nonEmptyIntersection(CipherSuite.f21097b, strArr2, sSLSocket.getEnabledCipherSuites())) {
            return true;
        }
        return false;
    }

    public boolean isTls() {
        return this.f19807a;
    }

    public boolean supportsTlsExtensions() {
        return this.f19808b;
    }

    @Nullable
    public List<TlsVersion> tlsVersions() {
        String[] strArr = this.f19810d;
        if (strArr != null) {
            return TlsVersion.m14224a(strArr);
        }
        return null;
    }

    public String toString() {
        if (!this.f19807a) {
            return "ConnectionSpec()";
        }
        String str = "[all enabled]";
        String obj = this.f19809c != null ? cipherSuites().toString() : str;
        if (this.f19810d != null) {
            str = tlsVersions().toString();
        }
        return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + str + ", supportsTlsExtensions=" + this.f19808b + ")";
    }

    public static final class Builder {

        /* renamed from: a */
        boolean f19811a;
        @Nullable

        /* renamed from: b */
        String[] f19812b;
        @Nullable

        /* renamed from: c */
        String[] f19813c;

        /* renamed from: d */
        boolean f19814d;

        Builder(boolean z) {
            this.f19811a = z;
        }

        public Builder allEnabledCipherSuites() {
            if (this.f19811a) {
                this.f19812b = null;
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public Builder allEnabledTlsVersions() {
            if (this.f19811a) {
                this.f19813c = null;
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public ConnectionSpec build() {
            return new ConnectionSpec(this);
        }

        public Builder cipherSuites(CipherSuite... cipherSuiteArr) {
            if (this.f19811a) {
                String[] strArr = new String[cipherSuiteArr.length];
                for (int i = 0; i < cipherSuiteArr.length; i++) {
                    strArr[i] = cipherSuiteArr[i].f21099a;
                }
                return cipherSuites(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public Builder supportsTlsExtensions(boolean z) {
            if (this.f19811a) {
                this.f19814d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public Builder tlsVersions(TlsVersion... tlsVersionArr) {
            if (this.f19811a) {
                String[] strArr = new String[tlsVersionArr.length];
                for (int i = 0; i < tlsVersionArr.length; i++) {
                    strArr[i] = tlsVersionArr[i].f21103a;
                }
                return tlsVersions(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public Builder(ConnectionSpec connectionSpec) {
            this.f19811a = connectionSpec.f19807a;
            this.f19812b = connectionSpec.f19809c;
            this.f19813c = connectionSpec.f19810d;
            this.f19814d = connectionSpec.f19808b;
        }

        public Builder cipherSuites(String... strArr) {
            if (!this.f19811a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length != 0) {
                this.f19812b = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
        }

        public Builder tlsVersions(String... strArr) {
            if (!this.f19811a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length != 0) {
                this.f19813c = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
        }
    }
}
