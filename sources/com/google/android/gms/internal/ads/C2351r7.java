package com.google.android.gms.internal.ads;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.google.android.gms.internal.ads.r7 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2351r7 extends SSLSocketFactory {

    /* renamed from: a */
    private SSLSocketFactory f10768a = ((SSLSocketFactory) SSLSocketFactory.getDefault());

    /* renamed from: b */
    private final /* synthetic */ C2277p7 f10769b;

    C2351r7(C2277p7 p7Var) {
        this.f10769b = p7Var;
    }

    /* renamed from: a */
    private final Socket m6797a(Socket socket) {
        if (this.f10769b.f10452o > 0) {
            socket.setReceiveBufferSize(this.f10769b.f10452o);
        }
        this.f10769b.m6607d(socket);
        return socket;
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) {
        Socket createSocket = this.f10768a.createSocket(socket, str, i, z);
        m6797a(createSocket);
        return createSocket;
    }

    public final String[] getDefaultCipherSuites() {
        return this.f10768a.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.f10768a.getSupportedCipherSuites();
    }

    public final Socket createSocket(String str, int i) {
        Socket createSocket = this.f10768a.createSocket(str, i);
        m6797a(createSocket);
        return createSocket;
    }

    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        Socket createSocket = this.f10768a.createSocket(str, i, inetAddress, i2);
        m6797a(createSocket);
        return createSocket;
    }

    public final Socket createSocket(InetAddress inetAddress, int i) {
        Socket createSocket = this.f10768a.createSocket(inetAddress, i);
        m6797a(createSocket);
        return createSocket;
    }

    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        Socket createSocket = this.f10768a.createSocket(inetAddress, i, inetAddress2, i2);
        m6797a(createSocket);
        return createSocket;
    }
}
