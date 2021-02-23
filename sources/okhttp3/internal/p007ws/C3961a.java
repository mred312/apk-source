package okhttp3.internal.p007ws;

import android.support.p000v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Timeout;

/* renamed from: okhttp3.internal.ws.a */
/* compiled from: WebSocketWriter */
final class C3961a {

    /* renamed from: a */
    final boolean f21333a;

    /* renamed from: b */
    final Random f21334b;

    /* renamed from: c */
    final BufferedSink f21335c;

    /* renamed from: d */
    final Buffer f21336d;

    /* renamed from: e */
    boolean f21337e;

    /* renamed from: f */
    final Buffer f21338f = new Buffer();

    /* renamed from: g */
    final C3962a f21339g = new C3962a();

    /* renamed from: h */
    boolean f21340h;

    /* renamed from: i */
    private final byte[] f21341i;

    /* renamed from: j */
    private final Buffer.UnsafeCursor f21342j;

    /* renamed from: okhttp3.internal.ws.a$a */
    /* compiled from: WebSocketWriter */
    final class C3962a implements Sink {

        /* renamed from: a */
        int f21343a;

        /* renamed from: b */
        long f21344b;

        /* renamed from: c */
        boolean f21345c;

        /* renamed from: d */
        boolean f21346d;

        C3962a() {
        }

        public void close() {
            if (!this.f21346d) {
                C3961a aVar = C3961a.this;
                aVar.mo25150d(this.f21343a, aVar.f21338f.size(), this.f21345c, true);
                this.f21346d = true;
                C3961a.this.f21340h = false;
                return;
            }
            throw new IOException("closed");
        }

        public void flush() {
            if (!this.f21346d) {
                C3961a aVar = C3961a.this;
                aVar.mo25150d(this.f21343a, aVar.f21338f.size(), this.f21345c, false);
                this.f21345c = false;
                return;
            }
            throw new IOException("closed");
        }

        public Timeout timeout() {
            return C3961a.this.f21335c.timeout();
        }

        public void write(Buffer buffer, long j) {
            if (!this.f21346d) {
                C3961a.this.f21338f.write(buffer, j);
                boolean z = this.f21345c && this.f21344b != -1 && C3961a.this.f21338f.size() > this.f21344b - PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                long completeSegmentByteCount = C3961a.this.f21338f.completeSegmentByteCount();
                if (completeSegmentByteCount > 0 && !z) {
                    C3961a.this.mo25150d(this.f21343a, completeSegmentByteCount, this.f21345c, false);
                    this.f21345c = false;
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }
    }

    C3961a(boolean z, BufferedSink bufferedSink, Random random) {
        if (bufferedSink == null) {
            throw new NullPointerException("sink == null");
        } else if (random != null) {
            this.f21333a = z;
            this.f21335c = bufferedSink;
            this.f21336d = bufferedSink.buffer();
            this.f21334b = random;
            Buffer.UnsafeCursor unsafeCursor = null;
            this.f21341i = z ? new byte[4] : null;
            this.f21342j = z ? new Buffer.UnsafeCursor() : unsafeCursor;
        } else {
            throw new NullPointerException("random == null");
        }
    }

    /* renamed from: c */
    private void m14413c(int i, ByteString byteString) {
        if (!this.f21337e) {
            int size = byteString.size();
            if (((long) size) <= 125) {
                this.f21336d.writeByte(i | 128);
                if (this.f21333a) {
                    this.f21336d.writeByte(size | 128);
                    this.f21334b.nextBytes(this.f21341i);
                    this.f21336d.write(this.f21341i);
                    if (size > 0) {
                        long size2 = this.f21336d.size();
                        this.f21336d.write(byteString);
                        this.f21336d.readAndWriteUnsafe(this.f21342j);
                        this.f21342j.seek(size2);
                        WebSocketProtocol.m14405b(this.f21342j, this.f21341i);
                        this.f21342j.close();
                    }
                } else {
                    this.f21336d.writeByte(size);
                    this.f21336d.write(byteString);
                }
                this.f21335c.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        throw new IOException("closed");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Sink mo25148a(int i, long j) {
        if (!this.f21340h) {
            this.f21340h = true;
            C3962a aVar = this.f21339g;
            aVar.f21343a = i;
            aVar.f21344b = j;
            aVar.f21345c = true;
            aVar.f21346d = false;
            return aVar;
        }
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo25149b(int i, ByteString byteString) {
        ByteString byteString2 = ByteString.EMPTY;
        if (!(i == 0 && byteString == null)) {
            if (i != 0) {
                WebSocketProtocol.m14406c(i);
            }
            Buffer buffer = new Buffer();
            buffer.writeShort(i);
            if (byteString != null) {
                buffer.write(byteString);
            }
            byteString2 = buffer.readByteString();
        }
        try {
            m14413c(8, byteString2);
        } finally {
            this.f21337e = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo25150d(int i, long j, boolean z, boolean z2) {
        if (!this.f21337e) {
            int i2 = 0;
            if (!z) {
                i = 0;
            }
            if (z2) {
                i |= 128;
            }
            this.f21336d.writeByte(i);
            if (this.f21333a) {
                i2 = 128;
            }
            if (j <= 125) {
                this.f21336d.writeByte(((int) j) | i2);
            } else if (j <= 65535) {
                this.f21336d.writeByte(i2 | 126);
                this.f21336d.writeShort((int) j);
            } else {
                this.f21336d.writeByte(i2 | 127);
                this.f21336d.writeLong(j);
            }
            if (this.f21333a) {
                this.f21334b.nextBytes(this.f21341i);
                this.f21336d.write(this.f21341i);
                if (j > 0) {
                    long size = this.f21336d.size();
                    this.f21336d.write(this.f21338f, j);
                    this.f21336d.readAndWriteUnsafe(this.f21342j);
                    this.f21342j.seek(size);
                    WebSocketProtocol.m14405b(this.f21342j, this.f21341i);
                    this.f21342j.close();
                }
            } else {
                this.f21336d.write(this.f21338f, j);
            }
            this.f21335c.emit();
            return;
        }
        throw new IOException("closed");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo25151e(ByteString byteString) {
        m14413c(9, byteString);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo25152f(ByteString byteString) {
        m14413c(10, byteString);
    }
}
