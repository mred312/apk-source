package com.google.android.gms.measurement.internal;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.google.android.gms.measurement.internal.y7 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3161y7 extends SSLSocketFactory {

    /* renamed from: a */
    private final SSLSocketFactory f18469a;

    C3161y7() {
        this(HttpsURLConnection.getDefaultSSLSocketFactory());
    }

    /* renamed from: a */
    private final SSLSocket m10639a(SSLSocket sSLSocket) {
        return new C3152x7(this, sSLSocket);
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) {
        return m10639a((SSLSocket) this.f18469a.createSocket(socket, str, i, z));
    }

    public final String[] getDefaultCipherSuites() {
        return this.f18469a.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.f18469a.getSupportedCipherSuites();
    }

    private C3161y7(SSLSocketFactory sSLSocketFactory) {
        this.f18469a = sSLSocketFactory;
    }

    public final Socket createSocket(String str, int i) {
        return m10639a((SSLSocket) this.f18469a.createSocket(str, i));
    }

    public final Socket createSocket(InetAddress inetAddress, int i) {
        return m10639a((SSLSocket) this.f18469a.createSocket(inetAddress, i));
    }

    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return m10639a((SSLSocket) this.f18469a.createSocket(str, i, inetAddress, i2));
    }

    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return m10639a((SSLSocket) this.f18469a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    public final Socket createSocket() {
        return m10639a((SSLSocket) this.f18469a.createSocket());
    }
}
