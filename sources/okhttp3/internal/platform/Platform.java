package okhttp3.internal.platform;

import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import okio.Buffer;

public class Platform {
    public static final int INFO = 4;
    public static final int WARN = 5;

    /* renamed from: a */
    private static final Platform f20123a = m12048b();

    /* renamed from: b */
    private static final Logger f20124b = Logger.getLogger(OkHttpClient.class.getName());

    /* renamed from: a */
    static byte[] m12047a(List<Protocol> list) {
        Buffer buffer = new Buffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                buffer.writeByte(protocol.toString().length());
                buffer.writeUtf8(protocol.toString());
            }
        }
        return buffer.readByteArray();
    }

    public static List<String> alpnProtocolNames(List<Protocol> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private static Platform m12048b() {
        ConscryptPlatform buildIfSupported;
        Platform f = C3556a.m12052f();
        if (f != null) {
            return f;
        }
        if (isConscryptPreferred() && (buildIfSupported = ConscryptPlatform.buildIfSupported()) != null) {
            return buildIfSupported;
        }
        C3560b d = C3560b.m12057d();
        if (d != null) {
            return d;
        }
        Platform d2 = C3561c.m12058d();
        if (d2 != null) {
            return d2;
        }
        return new Platform();
    }

    @Nullable
    /* renamed from: c */
    static <T> T m12049c(Object obj, Class<T> cls, String str) {
        Object c;
        Class<Object> cls2 = Object.class;
        Class cls3 = obj.getClass();
        while (cls3 != cls2) {
            try {
                Field declaredField = cls3.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (obj2 != null) {
                    if (cls.isInstance(obj2)) {
                        return cls.cast(obj2);
                    }
                }
                return null;
            } catch (NoSuchFieldException unused) {
                cls3 = cls3.getSuperclass();
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        }
        if (str.equals("delegate") || (c = m12049c(obj, cls2, "delegate")) == null) {
            return null;
        }
        return m12049c(c, cls, str);
    }

    public static Platform get() {
        return f20123a;
    }

    public static boolean isConscryptPreferred() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    public void afterHandshake(SSLSocket sSLSocket) {
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        return new BasicCertificateChainCleaner(buildTrustRootIndex(x509TrustManager));
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        return new BasicTrustRootIndex(x509TrustManager.getAcceptedIssuers());
    }

    public void configureSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, @Nullable String str, List<Protocol> list) {
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        socket.connect(inetSocketAddress, i);
    }

    public String getPrefix() {
        return "OkHttp";
    }

    public SSLContext getSSLContext() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    @Nullable
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        return null;
    }

    public Object getStackTraceForCloseable(String str) {
        if (f20124b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean isCleartextTrafficPermitted(String str) {
        return true;
    }

    public void log(int i, String str, @Nullable Throwable th) {
        f20124b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void logCloseableLeak(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        log(5, str, (Throwable) obj);
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        try {
            Object c = m12049c(sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (c == null) {
                return null;
            }
            return (X509TrustManager) m12049c(c, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public CertificateChainCleaner buildCertificateChainCleaner(SSLSocketFactory sSLSocketFactory) {
        X509TrustManager trustManager = trustManager(sSLSocketFactory);
        if (trustManager != null) {
            return buildCertificateChainCleaner(trustManager);
        }
        throw new IllegalStateException("Unable to extract the trust manager on " + get() + ", sslSocketFactory is " + sSLSocketFactory.getClass());
    }
}
