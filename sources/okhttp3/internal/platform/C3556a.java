package okhttp3.internal.platform;

import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

/* renamed from: okhttp3.internal.platform.a */
/* compiled from: AndroidPlatform */
class C3556a extends Platform {

    /* renamed from: c */
    private final Class<?> f20125c;

    /* renamed from: d */
    private final C3960d<Socket> f20126d;

    /* renamed from: e */
    private final C3960d<Socket> f20127e;

    /* renamed from: f */
    private final C3960d<Socket> f20128f;

    /* renamed from: g */
    private final C3960d<Socket> f20129g;

    /* renamed from: h */
    private final C3559c f20130h = C3559c.m12054b();

    /* renamed from: okhttp3.internal.platform.a$a */
    /* compiled from: AndroidPlatform */
    static final class C3557a extends CertificateChainCleaner {

        /* renamed from: a */
        private final Object f20131a;

        /* renamed from: b */
        private final Method f20132b;

        C3557a(Object obj, Method method) {
            this.f20131a = obj;
            this.f20132b = method;
        }

        public List<Certificate> clean(List<Certificate> list, String str) {
            try {
                return (List) this.f20132b.invoke(this.f20131a, new Object[]{(X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str});
            } catch (InvocationTargetException e) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
                sSLPeerUnverifiedException.initCause(e);
                throw sSLPeerUnverifiedException;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C3557a;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* renamed from: okhttp3.internal.platform.a$b */
    /* compiled from: AndroidPlatform */
    static final class C3558b implements TrustRootIndex {

        /* renamed from: a */
        private final X509TrustManager f20133a;

        /* renamed from: b */
        private final Method f20134b;

        C3558b(X509TrustManager x509TrustManager, Method method) {
            this.f20134b = method;
            this.f20133a = x509TrustManager;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C3558b)) {
                return false;
            }
            C3558b bVar = (C3558b) obj;
            if (!this.f20133a.equals(bVar.f20133a) || !this.f20134b.equals(bVar.f20134b)) {
                return false;
            }
            return true;
        }

        public X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f20134b.invoke(this.f20133a, new Object[]{x509Certificate});
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e) {
                throw Util.assertionError("unable to get issues and signature", e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public int hashCode() {
            return this.f20133a.hashCode() + (this.f20134b.hashCode() * 31);
        }
    }

    /* renamed from: okhttp3.internal.platform.a$c */
    /* compiled from: AndroidPlatform */
    static final class C3559c {

        /* renamed from: a */
        private final Method f20135a;

        /* renamed from: b */
        private final Method f20136b;

        /* renamed from: c */
        private final Method f20137c;

        C3559c(Method method, Method method2, Method method3) {
            this.f20135a = method;
            this.f20136b = method2;
            this.f20137c = method3;
        }

        /* renamed from: b */
        static C3559c m12054b() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method = cls.getMethod("open", new Class[]{String.class});
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method2 = null;
                method = null;
            }
            return new C3559c(method3, method, method2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public Object mo22389a(String str) {
            Method method = this.f20135a;
            if (method != null) {
                try {
                    Object invoke = method.invoke((Object) null, new Object[0]);
                    this.f20136b.invoke(invoke, new Object[]{str});
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public boolean mo22390c(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f20137c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    C3556a(Class<?> cls, C3960d<Socket> dVar, C3960d<Socket> dVar2, C3960d<Socket> dVar3, C3960d<Socket> dVar4) {
        this.f20125c = cls;
        this.f20126d = dVar;
        this.f20127e = dVar2;
        this.f20128f = dVar3;
        this.f20129g = dVar4;
    }

    /* renamed from: d */
    private boolean m12050d(String str, Class<?> cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.isCleartextTrafficPermitted(str);
        }
    }

    /* renamed from: e */
    private boolean m12051e(String str, Class<?> cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(obj, new Object[]{str})).booleanValue();
        } catch (NoSuchMethodException unused) {
            return m12050d(str, cls, obj);
        }
    }

    /* renamed from: f */
    public static Platform m12052f() {
        Class<?> cls;
        C3960d dVar;
        C3960d dVar2;
        Class<byte[]> cls2 = byte[].class;
        try {
            cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
        } catch (ClassNotFoundException unused) {
            try {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }
        Class<?> cls3 = cls;
        C3960d dVar3 = new C3960d((Class<?>) null, "setUseSessionTickets", Boolean.TYPE);
        C3960d dVar4 = new C3960d((Class<?>) null, "setHostname", String.class);
        if (m12053g()) {
            C3960d dVar5 = new C3960d(cls2, "getAlpnSelectedProtocol", new Class[0]);
            dVar = new C3960d((Class<?>) null, "setAlpnProtocols", cls2);
            dVar2 = dVar5;
        } else {
            dVar2 = null;
            dVar = null;
        }
        return new C3556a(cls3, dVar3, dVar4, dVar2, dVar);
    }

    /* renamed from: g */
    private static boolean m12053g() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        Class<String> cls = String.class;
        try {
            Class<?> cls2 = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C3557a(cls2.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{x509TrustManager}), cls2.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, cls, cls}));
        } catch (Exception unused) {
            return super.buildCertificateChainCleaner(x509TrustManager);
        }
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            declaredMethod.setAccessible(true);
            return new C3558b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.buildTrustRootIndex(x509TrustManager);
        }
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (str != null) {
            this.f20126d.mo25134e(sSLSocket, Boolean.TRUE);
            this.f20127e.mo25134e(sSLSocket, str);
        }
        C3960d<Socket> dVar = this.f20129g;
        if (dVar != null && dVar.mo25136g(sSLSocket)) {
            this.f20129g.mo25135f(sSLSocket, Platform.m12047a(list));
        }
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (Util.isAndroidGetsocknameError(e)) {
                throw new IOException(e);
            }
            throw e;
        } catch (SecurityException e2) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e2);
            throw iOException;
        } catch (ClassCastException e3) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException2 = new IOException("Exception in connect");
                iOException2.initCause(e3);
                throw iOException2;
            }
            throw e3;
        }
    }

    public SSLContext getSSLContext() {
        boolean z = true;
        try {
            int i = Build.VERSION.SDK_INT;
            if (i < 16 || i >= 22) {
                z = false;
            }
        } catch (NoClassDefFoundError unused) {
        }
        if (z) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused2) {
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
        byte[] bArr;
        C3960d<Socket> dVar = this.f20128f;
        if (dVar == null || !dVar.mo25136g(sSLSocket) || (bArr = (byte[]) this.f20128f.mo25135f(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, Util.UTF_8);
    }

    public Object getStackTraceForCloseable(String str) {
        return this.f20130h.mo22389a(str);
    }

    public boolean isCleartextTrafficPermitted(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return m12051e(str, cls, cls.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.isCleartextTrafficPermitted(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw Util.assertionError("unable to determine cleartext support", e);
        }
    }

    public void log(int i, String str, @Nullable Throwable th) {
        int min;
        int i2 = 5;
        if (i != 5) {
            i2 = 3;
        }
        if (th != null) {
            str = str + 10 + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int indexOf = str.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + 4000);
                Log.println(i2, "OkHttp", str.substring(i3, min));
                if (min >= indexOf) {
                    break;
                }
                i3 = min;
            }
            i3 = min + 1;
        }
    }

    public void logCloseableLeak(String str, Object obj) {
        if (!this.f20130h.mo22390c(obj)) {
            log(5, str, (Throwable) null);
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        Object c = Platform.m12049c(sSLSocketFactory, this.f20125c, "sslParameters");
        if (c == null) {
            try {
                c = Platform.m12049c(sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
            } catch (ClassNotFoundException unused) {
                return super.trustManager(sSLSocketFactory);
            }
        }
        X509TrustManager x509TrustManager = (X509TrustManager) Platform.m12049c(c, X509TrustManager.class, "x509TrustManager");
        if (x509TrustManager != null) {
            return x509TrustManager;
        }
        return (X509TrustManager) Platform.m12049c(c, X509TrustManager.class, "trustManager");
    }
}
