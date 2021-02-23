package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okhttp3.internal.http2.C3950a;
import okio.Buffer;
import okio.BufferedSink;

/* renamed from: okhttp3.internal.http2.c */
/* compiled from: Http2Writer */
final class C3956c implements Closeable {

    /* renamed from: g */
    private static final Logger f21294g = Logger.getLogger(Http2.class.getName());

    /* renamed from: a */
    private final BufferedSink f21295a;

    /* renamed from: b */
    private final boolean f21296b;

    /* renamed from: c */
    private final Buffer f21297c;

    /* renamed from: d */
    private int f21298d = 16384;

    /* renamed from: e */
    private boolean f21299e;

    /* renamed from: f */
    final C3950a.C3952b f21300f;

    C3956c(BufferedSink bufferedSink, boolean z) {
        this.f21295a = bufferedSink;
        this.f21296b = z;
        Buffer buffer = new Buffer();
        this.f21297c = buffer;
        this.f21300f = new C3950a.C3952b(buffer);
    }

    /* renamed from: p */
    private void m14366p(int i, long j) {
        while (j > 0) {
            int min = (int) Math.min((long) this.f21298d, j);
            long j2 = (long) min;
            j -= j2;
            mo25109e(i, min, (byte) 9, j == 0 ? (byte) 4 : 0);
            this.f21295a.write(this.f21297c, j2);
        }
    }

    /* renamed from: q */
    private static void m14367q(BufferedSink bufferedSink, int i) {
        bufferedSink.writeByte((i >>> 16) & 255);
        bufferedSink.writeByte((i >>> 8) & 255);
        bufferedSink.writeByte(i & 255);
    }

    /* renamed from: a */
    public synchronized void mo25104a(Settings settings) {
        if (!this.f21299e) {
            this.f21298d = settings.mo25088f(this.f21298d);
            if (settings.mo25085c() != -1) {
                this.f21300f.mo25097e(settings.mo25085c());
            }
            mo25109e(0, 0, (byte) 4, (byte) 1);
            this.f21295a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: b */
    public synchronized void mo25105b() {
        if (this.f21299e) {
            throw new IOException("closed");
        } else if (this.f21296b) {
            Logger logger = f21294g;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Util.format(">> CONNECTION %s", Http2.f21187a.hex()));
            }
            this.f21295a.write(Http2.f21187a.toByteArray());
            this.f21295a.flush();
        }
    }

    /* renamed from: c */
    public synchronized void mo25106c(boolean z, int i, Buffer buffer, int i2) {
        if (!this.f21299e) {
            byte b = 0;
            if (z) {
                b = (byte) 1;
            }
            mo25108d(i, b, buffer, i2);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void close() {
        this.f21299e = true;
        this.f21295a.close();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo25108d(int i, byte b, Buffer buffer, int i2) {
        mo25109e(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.f21295a.write(buffer, (long) i2);
        }
    }

    /* renamed from: e */
    public void mo25109e(int i, int i2, byte b, byte b2) {
        Logger logger = f21294g;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Http2.m14266b(false, i, i2, b, b2));
        }
        int i3 = this.f21298d;
        if (i2 > i3) {
            Http2.m14267c("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
            throw null;
        } else if ((Integer.MIN_VALUE & i) == 0) {
            m14367q(this.f21295a, i2);
            this.f21295a.writeByte(b & 255);
            this.f21295a.writeByte(b2 & 255);
            this.f21295a.writeInt(i & Integer.MAX_VALUE);
        } else {
            Http2.m14267c("reserved bit set: %s", Integer.valueOf(i));
            throw null;
        }
    }

    /* renamed from: f */
    public synchronized void mo25110f(int i, ErrorCode errorCode, byte[] bArr) {
        if (this.f21299e) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            mo25109e(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f21295a.writeInt(i);
            this.f21295a.writeInt(errorCode.httpCode);
            if (bArr.length > 0) {
                this.f21295a.write(bArr);
            }
            this.f21295a.flush();
        } else {
            Http2.m14267c("errorCode.httpCode == -1", new Object[0]);
            throw null;
        }
    }

    public synchronized void flush() {
        if (!this.f21299e) {
            this.f21295a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo25112g(boolean z, int i, List<Header> list) {
        if (!this.f21299e) {
            this.f21300f.mo25099g(list);
            long size = this.f21297c.size();
            int min = (int) Math.min((long) this.f21298d, size);
            long j = (long) min;
            byte b = size == j ? (byte) 4 : 0;
            if (z) {
                b = (byte) (b | 1);
            }
            mo25109e(i, min, (byte) 1, b);
            this.f21295a.write(this.f21297c, j);
            if (size > j) {
                m14366p(i, size - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    /* renamed from: h */
    public int mo25113h() {
        return this.f21298d;
    }

    /* renamed from: i */
    public synchronized void mo25114i(boolean z, int i, int i2) {
        if (!this.f21299e) {
            mo25109e(0, 8, (byte) 6, z ? (byte) 1 : 0);
            this.f21295a.writeInt(i);
            this.f21295a.writeInt(i2);
            this.f21295a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: j */
    public synchronized void mo25115j(int i, int i2, List<Header> list) {
        if (!this.f21299e) {
            this.f21300f.mo25099g(list);
            long size = this.f21297c.size();
            int min = (int) Math.min((long) (this.f21298d - 4), size);
            long j = (long) min;
            mo25109e(i, min + 4, (byte) 5, size == j ? (byte) 4 : 0);
            this.f21295a.writeInt(i2 & Integer.MAX_VALUE);
            this.f21295a.write(this.f21297c, j);
            if (size > j) {
                m14366p(i, size - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: k */
    public synchronized void mo25116k(int i, ErrorCode errorCode) {
        if (this.f21299e) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            mo25109e(i, 4, (byte) 3, (byte) 0);
            this.f21295a.writeInt(errorCode.httpCode);
            this.f21295a.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: l */
    public synchronized void mo25117l(Settings settings) {
        if (!this.f21299e) {
            int i = 0;
            mo25109e(0, settings.mo25092j() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (settings.mo25089g(i)) {
                    this.f21295a.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.f21295a.writeInt(settings.mo25084b(i));
                }
                i++;
            }
            this.f21295a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: m */
    public synchronized void mo25118m(boolean z, int i, List<Header> list) {
        if (!this.f21299e) {
            mo25112g(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: n */
    public synchronized void mo25119n(boolean z, int i, int i2, List<Header> list) {
        if (!this.f21299e) {
            mo25112g(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: o */
    public synchronized void mo25120o(int i, long j) {
        if (this.f21299e) {
            throw new IOException("closed");
        } else if (j == 0 || j > 2147483647L) {
            Http2.m14267c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            throw null;
        } else {
            mo25109e(i, 4, (byte) 8, (byte) 0);
            this.f21295a.writeInt((int) j);
            this.f21295a.flush();
        }
    }
}
