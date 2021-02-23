package com.google.android.gms.measurement.internal;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* renamed from: com.google.android.gms.measurement.internal.x7 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3152x7 extends SSLSocket {

    /* renamed from: a */
    private final SSLSocket f18455a;

    C3152x7(C3161y7 y7Var, SSLSocket sSLSocket) {
        this.f18455a = sSLSocket;
    }

    public final void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.f18455a.addHandshakeCompletedListener(handshakeCompletedListener);
    }

    public final void bind(SocketAddress socketAddress) {
        this.f18455a.bind(socketAddress);
    }

    public final synchronized void close() {
        this.f18455a.close();
    }

    public final void connect(SocketAddress socketAddress) {
        this.f18455a.connect(socketAddress);
    }

    public final boolean equals(Object obj) {
        return this.f18455a.equals(obj);
    }

    public final SocketChannel getChannel() {
        return this.f18455a.getChannel();
    }

    public final boolean getEnableSessionCreation() {
        return this.f18455a.getEnableSessionCreation();
    }

    public final String[] getEnabledCipherSuites() {
        return this.f18455a.getEnabledCipherSuites();
    }

    public final String[] getEnabledProtocols() {
        return this.f18455a.getEnabledProtocols();
    }

    public final InetAddress getInetAddress() {
        return this.f18455a.getInetAddress();
    }

    public final InputStream getInputStream() {
        return this.f18455a.getInputStream();
    }

    public final boolean getKeepAlive() {
        return this.f18455a.getKeepAlive();
    }

    public final InetAddress getLocalAddress() {
        return this.f18455a.getLocalAddress();
    }

    public final int getLocalPort() {
        return this.f18455a.getLocalPort();
    }

    public final SocketAddress getLocalSocketAddress() {
        return this.f18455a.getLocalSocketAddress();
    }

    public final boolean getNeedClientAuth() {
        return this.f18455a.getNeedClientAuth();
    }

    public final boolean getOOBInline() {
        return this.f18455a.getOOBInline();
    }

    public final OutputStream getOutputStream() {
        return this.f18455a.getOutputStream();
    }

    public final int getPort() {
        return this.f18455a.getPort();
    }

    public final synchronized int getReceiveBufferSize() {
        return this.f18455a.getReceiveBufferSize();
    }

    public final SocketAddress getRemoteSocketAddress() {
        return this.f18455a.getRemoteSocketAddress();
    }

    public final boolean getReuseAddress() {
        return this.f18455a.getReuseAddress();
    }

    public final synchronized int getSendBufferSize() {
        return this.f18455a.getSendBufferSize();
    }

    public final SSLSession getSession() {
        return this.f18455a.getSession();
    }

    public final int getSoLinger() {
        return this.f18455a.getSoLinger();
    }

    public final synchronized int getSoTimeout() {
        return this.f18455a.getSoTimeout();
    }

    public final String[] getSupportedCipherSuites() {
        return this.f18455a.getSupportedCipherSuites();
    }

    public final String[] getSupportedProtocols() {
        return this.f18455a.getSupportedProtocols();
    }

    public final boolean getTcpNoDelay() {
        return this.f18455a.getTcpNoDelay();
    }

    public final int getTrafficClass() {
        return this.f18455a.getTrafficClass();
    }

    public final boolean getUseClientMode() {
        return this.f18455a.getUseClientMode();
    }

    public final boolean getWantClientAuth() {
        return this.f18455a.getWantClientAuth();
    }

    public final boolean isBound() {
        return this.f18455a.isBound();
    }

    public final boolean isClosed() {
        return this.f18455a.isClosed();
    }

    public final boolean isConnected() {
        return this.f18455a.isConnected();
    }

    public final boolean isInputShutdown() {
        return this.f18455a.isInputShutdown();
    }

    public final boolean isOutputShutdown() {
        return this.f18455a.isOutputShutdown();
    }

    public final void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.f18455a.removeHandshakeCompletedListener(handshakeCompletedListener);
    }

    public final void sendUrgentData(int i) {
        this.f18455a.sendUrgentData(i);
    }

    public final void setEnableSessionCreation(boolean z) {
        this.f18455a.setEnableSessionCreation(z);
    }

    public final void setEnabledCipherSuites(String[] strArr) {
        this.f18455a.setEnabledCipherSuites(strArr);
    }

    public final void setEnabledProtocols(String[] strArr) {
        if (strArr != null && Arrays.asList(strArr).contains("SSLv3")) {
            ArrayList arrayList = new ArrayList(Arrays.asList(this.f18455a.getEnabledProtocols()));
            if (arrayList.size() > 1) {
                arrayList.remove("SSLv3");
            }
            strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        this.f18455a.setEnabledProtocols(strArr);
    }

    public final void setKeepAlive(boolean z) {
        this.f18455a.setKeepAlive(z);
    }

    public final void setNeedClientAuth(boolean z) {
        this.f18455a.setNeedClientAuth(z);
    }

    public final void setOOBInline(boolean z) {
        this.f18455a.setOOBInline(z);
    }

    public final void setPerformancePreferences(int i, int i2, int i3) {
        this.f18455a.setPerformancePreferences(i, i2, i3);
    }

    public final synchronized void setReceiveBufferSize(int i) {
        this.f18455a.setReceiveBufferSize(i);
    }

    public final void setReuseAddress(boolean z) {
        this.f18455a.setReuseAddress(z);
    }

    public final synchronized void setSendBufferSize(int i) {
        this.f18455a.setSendBufferSize(i);
    }

    public final void setSoLinger(boolean z, int i) {
        this.f18455a.setSoLinger(z, i);
    }

    public final synchronized void setSoTimeout(int i) {
        this.f18455a.setSoTimeout(i);
    }

    public final void setTcpNoDelay(boolean z) {
        this.f18455a.setTcpNoDelay(z);
    }

    public final void setTrafficClass(int i) {
        this.f18455a.setTrafficClass(i);
    }

    public final void setUseClientMode(boolean z) {
        this.f18455a.setUseClientMode(z);
    }

    public final void setWantClientAuth(boolean z) {
        this.f18455a.setWantClientAuth(z);
    }

    public final void shutdownInput() {
        this.f18455a.shutdownInput();
    }

    public final void shutdownOutput() {
        this.f18455a.shutdownOutput();
    }

    public final void startHandshake() {
        this.f18455a.startHandshake();
    }

    public final String toString() {
        return this.f18455a.toString();
    }

    public final void connect(SocketAddress socketAddress, int i) {
        this.f18455a.connect(socketAddress, i);
    }
}
