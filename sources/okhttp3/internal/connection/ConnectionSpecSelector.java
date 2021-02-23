package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import okhttp3.ConnectionSpec;
import okhttp3.internal.Internal;

public final class ConnectionSpecSelector {

    /* renamed from: a */
    private final List<ConnectionSpec> f21110a;

    /* renamed from: b */
    private int f21111b = 0;

    /* renamed from: c */
    private boolean f21112c;

    /* renamed from: d */
    private boolean f21113d;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        this.f21110a = list;
    }

    /* renamed from: a */
    private boolean m14231a(SSLSocket sSLSocket) {
        for (int i = this.f21111b; i < this.f21110a.size(); i++) {
            if (this.f21110a.get(i).isCompatible(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public ConnectionSpec configureSecureSocket(SSLSocket sSLSocket) {
        ConnectionSpec connectionSpec;
        int i = this.f21111b;
        int size = this.f21110a.size();
        while (true) {
            if (i >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = this.f21110a.get(i);
            if (connectionSpec.isCompatible(sSLSocket)) {
                this.f21111b = i + 1;
                break;
            }
            i++;
        }
        if (connectionSpec != null) {
            this.f21112c = m14231a(sSLSocket);
            Internal.instance.apply(connectionSpec, sSLSocket, this.f21113d);
            return connectionSpec;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f21113d + ", modes=" + this.f21110a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean connectionFailed(IOException iOException) {
        this.f21113d = true;
        if (!this.f21112c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        if (z || (iOException instanceof SSLProtocolException) || (iOException instanceof SSLException)) {
            return true;
        }
        return false;
    }
}
