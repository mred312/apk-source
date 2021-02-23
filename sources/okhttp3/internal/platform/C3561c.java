package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import okhttp3.internal.Util;

/* renamed from: okhttp3.internal.platform.c */
/* compiled from: JdkWithJettyBootPlatform */
class C3561c extends Platform {

    /* renamed from: c */
    private final Method f20140c;

    /* renamed from: d */
    private final Method f20141d;

    /* renamed from: e */
    private final Method f20142e;

    /* renamed from: f */
    private final Class<?> f20143f;

    /* renamed from: g */
    private final Class<?> f20144g;

    /* renamed from: okhttp3.internal.platform.c$a */
    /* compiled from: JdkWithJettyBootPlatform */
    private static class C3562a implements InvocationHandler {

        /* renamed from: a */
        private final List<String> f20145a;

        /* renamed from: b */
        boolean f20146b;

        /* renamed from: c */
        String f20147c;

        C3562a(List<String> list) {
            this.f20145a = list;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = Util.EMPTY_STRING_ARRAY;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f20146b = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f20145a;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f20145a.contains(list.get(i))) {
                            String str = (String) list.get(i);
                            this.f20147c = str;
                            return str;
                        }
                    }
                    String str2 = this.f20145a.get(0);
                    this.f20147c = str2;
                    return str2;
                } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.f20147c = (String) objArr[0];
                    return null;
                }
            }
        }
    }

    C3561c(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f20140c = method;
        this.f20141d = method2;
        this.f20142e = method3;
        this.f20143f = cls;
        this.f20144g = cls2;
    }

    /* renamed from: d */
    public static Platform m12058d() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider");
            Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider");
            Method method = cls.getMethod("put", new Class[]{SSLSocket.class, cls2});
            return new C3561c(method, cls.getMethod("get", new Class[]{SSLSocket.class}), cls.getMethod("remove", new Class[]{SSLSocket.class}), cls3, cls4);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    public void afterHandshake(SSLSocket sSLSocket) {
        try {
            this.f20142e.invoke((Object) null, new Object[]{sSLSocket});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw Util.assertionError("unable to remove alpn", e);
        }
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        List<String> alpnProtocolNames = Platform.alpnProtocolNames(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.f20143f, this.f20144g}, new C3562a(alpnProtocolNames));
            this.f20140c.invoke((Object) null, new Object[]{sSLSocket, newProxyInstance});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw Util.assertionError("unable to set alpn", e);
        }
    }

    @Nullable
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        try {
            C3562a aVar = (C3562a) Proxy.getInvocationHandler(this.f20141d.invoke((Object) null, new Object[]{sSLSocket}));
            boolean z = aVar.f20146b;
            if (!z && aVar.f20147c == null) {
                Platform.get().log(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (z) {
                return null;
            } else {
                return aVar.f20147c;
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw Util.assertionError("unable to get selected protocol", e);
        }
    }
}
