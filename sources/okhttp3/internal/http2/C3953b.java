package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okhttp3.internal.http2.C3950a;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* renamed from: okhttp3.internal.http2.b */
/* compiled from: Http2Reader */
final class C3953b implements Closeable {

    /* renamed from: e */
    static final Logger f21283e = Logger.getLogger(Http2.class.getName());

    /* renamed from: a */
    private final BufferedSource f21284a;

    /* renamed from: b */
    private final C3954a f21285b;

    /* renamed from: c */
    private final boolean f21286c;

    /* renamed from: d */
    final C3950a.C3951a f21287d;

    /* renamed from: okhttp3.internal.http2.b$a */
    /* compiled from: Http2Reader */
    static final class C3954a implements Source {

        /* renamed from: a */
        private final BufferedSource f21288a;

        /* renamed from: b */
        int f21289b;

        /* renamed from: c */
        byte f21290c;

        /* renamed from: d */
        int f21291d;

        /* renamed from: e */
        int f21292e;

        /* renamed from: f */
        short f21293f;

        C3954a(BufferedSource bufferedSource) {
            this.f21288a = bufferedSource;
        }

        /* renamed from: a */
        private void m14355a() {
            int i = this.f21291d;
            int h = C3953b.m14345h(this.f21288a);
            this.f21292e = h;
            this.f21289b = h;
            byte readByte = (byte) (this.f21288a.readByte() & 255);
            this.f21290c = (byte) (this.f21288a.readByte() & 255);
            Logger logger = C3953b.f21283e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Http2.m14266b(true, this.f21291d, this.f21289b, readByte, this.f21290c));
            }
            int readInt = this.f21288a.readInt() & Integer.MAX_VALUE;
            this.f21291d = readInt;
            if (readByte != 9) {
                Http2.m14268d("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
                throw null;
            } else if (readInt != i) {
                Http2.m14268d("TYPE_CONTINUATION streamId changed", new Object[0]);
                throw null;
            }
        }

        public void close() {
        }

        public long read(Buffer buffer, long j) {
            while (true) {
                int i = this.f21292e;
                if (i == 0) {
                    this.f21288a.skip((long) this.f21293f);
                    this.f21293f = 0;
                    if ((this.f21290c & 4) != 0) {
                        return -1;
                    }
                    m14355a();
                } else {
                    long read = this.f21288a.read(buffer, Math.min(j, (long) i));
                    if (read == -1) {
                        return -1;
                    }
                    this.f21292e = (int) (((long) this.f21292e) - read);
                    return read;
                }
            }
        }

        public Timeout timeout() {
            return this.f21288a.timeout();
        }
    }

    /* renamed from: okhttp3.internal.http2.b$b */
    /* compiled from: Http2Reader */
    interface C3955b {
        /* renamed from: a */
        void mo25069a();

        /* renamed from: b */
        void mo25070b(boolean z, Settings settings);

        /* renamed from: c */
        void mo25071c(boolean z, int i, int i2, List<Header> list);

        /* renamed from: d */
        void mo25072d(int i, long j);

        /* renamed from: e */
        void mo25073e(boolean z, int i, BufferedSource bufferedSource, int i2);

        /* renamed from: f */
        void mo25074f(boolean z, int i, int i2);

        /* renamed from: g */
        void mo25075g(int i, int i2, int i3, boolean z);

        /* renamed from: h */
        void mo25076h(int i, ErrorCode errorCode);

        /* renamed from: i */
        void mo25077i(int i, int i2, List<Header> list);

        /* renamed from: j */
        void mo25078j(int i, ErrorCode errorCode, ByteString byteString);
    }

    C3953b(BufferedSource bufferedSource, boolean z) {
        this.f21284a = bufferedSource;
        this.f21286c = z;
        C3954a aVar = new C3954a(bufferedSource);
        this.f21285b = aVar;
        this.f21287d = new C3950a.C3951a(4096, aVar);
    }

    /* renamed from: a */
    static int m14340a(int i, byte b, short s) {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        Http2.m14268d("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
        throw null;
    }

    /* renamed from: d */
    private void m14341d(C3955b bVar, int i, byte b, int i2) {
        short s = 0;
        if (i2 != 0) {
            boolean z = true;
            boolean z2 = (b & 1) != 0;
            if ((b & 32) == 0) {
                z = false;
            }
            if (!z) {
                if ((b & 8) != 0) {
                    s = (short) (this.f21284a.readByte() & 255);
                }
                bVar.mo25073e(z2, i2, this.f21284a, m14340a(i, b, s));
                this.f21284a.skip((long) s);
                return;
            }
            Http2.m14268d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            throw null;
        }
        Http2.m14268d("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        throw null;
    }

    /* renamed from: e */
    private void m14342e(C3955b bVar, int i, byte b, int i2) {
        if (i < 8) {
            Http2.m14268d("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
            throw null;
        } else if (i2 == 0) {
            int readInt = this.f21284a.readInt();
            int readInt2 = this.f21284a.readInt();
            int i3 = i - 8;
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt2);
            if (fromHttp2 != null) {
                ByteString byteString = ByteString.EMPTY;
                if (i3 > 0) {
                    byteString = this.f21284a.readByteString((long) i3);
                }
                bVar.mo25078j(readInt, fromHttp2, byteString);
                return;
            }
            Http2.m14268d("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
            throw null;
        } else {
            Http2.m14268d("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }
    }

    /* renamed from: f */
    private List<Header> m14343f(int i, short s, byte b, int i2) {
        C3954a aVar = this.f21285b;
        aVar.f21292e = i;
        aVar.f21289b = i;
        aVar.f21293f = s;
        aVar.f21290c = b;
        aVar.f21291d = i2;
        this.f21287d.mo25095k();
        return this.f21287d.mo25093e();
    }

    /* renamed from: g */
    private void m14344g(C3955b bVar, int i, byte b, int i2) {
        short s = 0;
        if (i2 != 0) {
            boolean z = (b & 1) != 0;
            if ((b & 8) != 0) {
                s = (short) (this.f21284a.readByte() & 255);
            }
            if ((b & 32) != 0) {
                m14347j(bVar, i2);
                i -= 5;
            }
            bVar.mo25071c(z, i2, -1, m14343f(m14340a(i, b, s), s, b, i2));
            return;
        }
        Http2.m14268d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        throw null;
    }

    /* renamed from: h */
    static int m14345h(BufferedSource bufferedSource) {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    /* renamed from: i */
    private void m14346i(C3955b bVar, int i, byte b, int i2) {
        boolean z = false;
        if (i != 8) {
            Http2.m14268d("TYPE_PING length != 8: %s", Integer.valueOf(i));
            throw null;
        } else if (i2 == 0) {
            int readInt = this.f21284a.readInt();
            int readInt2 = this.f21284a.readInt();
            if ((b & 1) != 0) {
                z = true;
            }
            bVar.mo25074f(z, readInt, readInt2);
        } else {
            Http2.m14268d("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }
    }

    /* renamed from: j */
    private void m14347j(C3955b bVar, int i) {
        int readInt = this.f21284a.readInt();
        bVar.mo25075g(i, readInt & Integer.MAX_VALUE, (this.f21284a.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    /* renamed from: k */
    private void m14348k(C3955b bVar, int i, byte b, int i2) {
        if (i != 5) {
            Http2.m14268d("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
            throw null;
        } else if (i2 != 0) {
            m14347j(bVar, i2);
        } else {
            Http2.m14268d("TYPE_PRIORITY streamId == 0", new Object[0]);
            throw null;
        }
    }

    /* renamed from: l */
    private void m14349l(C3955b bVar, int i, byte b, int i2) {
        short s = 0;
        if (i2 != 0) {
            if ((b & 8) != 0) {
                s = (short) (this.f21284a.readByte() & 255);
            }
            bVar.mo25077i(i2, this.f21284a.readInt() & Integer.MAX_VALUE, m14343f(m14340a(i - 4, b, s), s, b, i2));
            return;
        }
        Http2.m14268d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        throw null;
    }

    /* renamed from: m */
    private void m14350m(C3955b bVar, int i, byte b, int i2) {
        if (i != 4) {
            Http2.m14268d("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
            throw null;
        } else if (i2 != 0) {
            int readInt = this.f21284a.readInt();
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt);
            if (fromHttp2 != null) {
                bVar.mo25076h(i2, fromHttp2);
                return;
            }
            Http2.m14268d("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
            throw null;
        } else {
            Http2.m14268d("TYPE_RST_STREAM streamId == 0", new Object[0]);
            throw null;
        }
    }

    /* renamed from: n */
    private void m14351n(C3955b bVar, int i, byte b, int i2) {
        if (i2 != 0) {
            Http2.m14268d("TYPE_SETTINGS streamId != 0", new Object[0]);
            throw null;
        } else if ((b & 1) != 0) {
            if (i == 0) {
                bVar.mo25069a();
            } else {
                Http2.m14268d("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                throw null;
            }
        } else if (i % 6 == 0) {
            Settings settings = new Settings();
            for (int i3 = 0; i3 < i; i3 += 6) {
                short readShort = this.f21284a.readShort() & 65535;
                int readInt = this.f21284a.readInt();
                if (readShort != 2) {
                    if (readShort == 3) {
                        readShort = 4;
                    } else if (readShort == 4) {
                        readShort = 7;
                        if (readInt < 0) {
                            Http2.m14268d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            throw null;
                        }
                    } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                        Http2.m14268d("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                        throw null;
                    }
                } else if (!(readInt == 0 || readInt == 1)) {
                    Http2.m14268d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    throw null;
                }
                settings.mo25091i(readShort, readInt);
            }
            bVar.mo25070b(false, settings);
        } else {
            Http2.m14268d("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
            throw null;
        }
    }

    /* renamed from: o */
    private void m14352o(C3955b bVar, int i, byte b, int i2) {
        if (i == 4) {
            long readInt = ((long) this.f21284a.readInt()) & 2147483647L;
            if (readInt != 0) {
                bVar.mo25072d(i2, readInt);
                return;
            }
            Http2.m14268d("windowSizeIncrement was 0", Long.valueOf(readInt));
            throw null;
        }
        Http2.m14268d("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        throw null;
    }

    /* renamed from: b */
    public boolean mo25101b(boolean z, C3955b bVar) {
        try {
            this.f21284a.require(9);
            int h = m14345h(this.f21284a);
            if (h < 0 || h > 16384) {
                Http2.m14268d("FRAME_SIZE_ERROR: %s", Integer.valueOf(h));
                throw null;
            }
            byte readByte = (byte) (this.f21284a.readByte() & 255);
            if (!z || readByte == 4) {
                byte readByte2 = (byte) (this.f21284a.readByte() & 255);
                int readInt = this.f21284a.readInt() & Integer.MAX_VALUE;
                Logger logger = f21283e;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(Http2.m14266b(true, readInt, h, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        m14341d(bVar, h, readByte2, readInt);
                        break;
                    case 1:
                        m14344g(bVar, h, readByte2, readInt);
                        break;
                    case 2:
                        m14348k(bVar, h, readByte2, readInt);
                        break;
                    case 3:
                        m14350m(bVar, h, readByte2, readInt);
                        break;
                    case 4:
                        m14351n(bVar, h, readByte2, readInt);
                        break;
                    case 5:
                        m14349l(bVar, h, readByte2, readInt);
                        break;
                    case 6:
                        m14346i(bVar, h, readByte2, readInt);
                        break;
                    case 7:
                        m14342e(bVar, h, readByte2, readInt);
                        break;
                    case 8:
                        m14352o(bVar, h, readByte2, readInt);
                        break;
                    default:
                        this.f21284a.skip((long) h);
                        break;
                }
                return true;
            }
            Http2.m14268d("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
            throw null;
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: c */
    public void mo25102c(C3955b bVar) {
        if (!this.f21286c) {
            BufferedSource bufferedSource = this.f21284a;
            ByteString byteString = Http2.f21187a;
            ByteString readByteString = bufferedSource.readByteString((long) byteString.size());
            Logger logger = f21283e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Util.format("<< CONNECTION %s", readByteString.hex()));
            }
            if (!byteString.equals(readByteString)) {
                Http2.m14268d("Expected a connection header but was %s", readByteString.utf8());
                throw null;
            }
        } else if (!mo25101b(true, bVar)) {
            Http2.m14268d("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
    }

    public void close() {
        this.f21284a.close();
    }
}
