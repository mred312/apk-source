package okhttp3.internal.p007ws;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* renamed from: okhttp3.internal.ws.WebSocketReader */
final class WebSocketReader {

    /* renamed from: a */
    final boolean f21321a;

    /* renamed from: b */
    final BufferedSource f21322b;

    /* renamed from: c */
    final FrameCallback f21323c;

    /* renamed from: d */
    boolean f21324d;

    /* renamed from: e */
    int f21325e;

    /* renamed from: f */
    long f21326f;

    /* renamed from: g */
    boolean f21327g;

    /* renamed from: h */
    boolean f21328h;

    /* renamed from: i */
    private final Buffer f21329i = new Buffer();

    /* renamed from: j */
    private final Buffer f21330j = new Buffer();

    /* renamed from: k */
    private final byte[] f21331k;

    /* renamed from: l */
    private final Buffer.UnsafeCursor f21332l;

    /* renamed from: okhttp3.internal.ws.WebSocketReader$FrameCallback */
    public interface FrameCallback {
        void onReadClose(int i, String str);

        void onReadMessage(String str);

        void onReadMessage(ByteString byteString);

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    WebSocketReader(boolean z, BufferedSource bufferedSource, FrameCallback frameCallback) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        } else if (frameCallback != null) {
            this.f21321a = z;
            this.f21322b = bufferedSource;
            this.f21323c = frameCallback;
            Buffer.UnsafeCursor unsafeCursor = null;
            this.f21331k = z ? null : new byte[4];
            this.f21332l = !z ? new Buffer.UnsafeCursor() : unsafeCursor;
        } else {
            throw new NullPointerException("frameCallback == null");
        }
    }

    /* renamed from: b */
    private void m14407b() {
        String str;
        long j = this.f21326f;
        if (j > 0) {
            this.f21322b.readFully(this.f21329i, j);
            if (!this.f21321a) {
                this.f21329i.readAndWriteUnsafe(this.f21332l);
                this.f21332l.seek(0);
                WebSocketProtocol.m14405b(this.f21332l, this.f21331k);
                this.f21332l.close();
            }
        }
        switch (this.f21325e) {
            case 8:
                short s = 1005;
                long size = this.f21329i.size();
                if (size != 1) {
                    if (size != 0) {
                        s = this.f21329i.readShort();
                        str = this.f21329i.readUtf8();
                        String a = WebSocketProtocol.m14404a(s);
                        if (a != null) {
                            throw new ProtocolException(a);
                        }
                    } else {
                        str = "";
                    }
                    this.f21323c.onReadClose(s, str);
                    this.f21324d = true;
                    return;
                }
                throw new ProtocolException("Malformed close payload length of 1.");
            case 9:
                this.f21323c.onReadPing(this.f21329i.readByteString());
                return;
            case 10:
                this.f21323c.onReadPong(this.f21329i.readByteString());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.f21325e));
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: c */
    private void m14408c() {
        if (!this.f21324d) {
            long timeoutNanos = this.f21322b.timeout().timeoutNanos();
            this.f21322b.timeout().clearTimeout();
            try {
                byte readByte = this.f21322b.readByte() & 255;
                this.f21322b.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                this.f21325e = readByte & 15;
                boolean z = true;
                boolean z2 = (readByte & 128) != 0;
                this.f21327g = z2;
                boolean z3 = (readByte & 8) != 0;
                this.f21328h = z3;
                if (!z3 || z2) {
                    boolean z4 = (readByte & 64) != 0;
                    boolean z5 = (readByte & 32) != 0;
                    boolean z6 = (readByte & 16) != 0;
                    if (z4 || z5 || z6) {
                        throw new ProtocolException("Reserved flags are unsupported.");
                    }
                    byte readByte2 = this.f21322b.readByte() & 255;
                    if ((readByte2 & 128) == 0) {
                        z = false;
                    }
                    if (z == this.f21321a) {
                        throw new ProtocolException(this.f21321a ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
                    }
                    long j = (long) (readByte2 & Byte.MAX_VALUE);
                    this.f21326f = j;
                    if (j == 126) {
                        this.f21326f = ((long) this.f21322b.readShort()) & 65535;
                    } else if (j == 127) {
                        long readLong = this.f21322b.readLong();
                        this.f21326f = readLong;
                        if (readLong < 0) {
                            throw new ProtocolException("Frame length 0x" + Long.toHexString(this.f21326f) + " > 0x7FFFFFFFFFFFFFFF");
                        }
                    }
                    if (this.f21328h && this.f21326f > 125) {
                        throw new ProtocolException("Control frame must be less than 125B.");
                    } else if (z) {
                        this.f21322b.readFully(this.f21331k);
                    }
                } else {
                    throw new ProtocolException("Control frames must be final.");
                }
            } catch (Throwable th) {
                this.f21322b.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                throw th;
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: d */
    private void m14409d() {
        while (!this.f21324d) {
            long j = this.f21326f;
            if (j > 0) {
                this.f21322b.readFully(this.f21330j, j);
                if (!this.f21321a) {
                    this.f21330j.readAndWriteUnsafe(this.f21332l);
                    this.f21332l.seek(this.f21330j.size() - this.f21326f);
                    WebSocketProtocol.m14405b(this.f21332l, this.f21331k);
                    this.f21332l.close();
                }
            }
            if (!this.f21327g) {
                m14411f();
                if (this.f21325e != 0) {
                    throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.f21325e));
                }
            } else {
                return;
            }
        }
        throw new IOException("closed");
    }

    /* renamed from: e */
    private void m14410e() {
        int i = this.f21325e;
        if (i == 1 || i == 2) {
            m14409d();
            if (i == 1) {
                this.f21323c.onReadMessage(this.f21330j.readUtf8());
            } else {
                this.f21323c.onReadMessage(this.f21330j.readByteString());
            }
        } else {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i));
        }
    }

    /* renamed from: f */
    private void m14411f() {
        while (!this.f21324d) {
            m14408c();
            if (this.f21328h) {
                m14407b();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25147a() {
        m14408c();
        if (this.f21328h) {
            m14407b();
        } else {
            m14410e();
        }
    }
}
