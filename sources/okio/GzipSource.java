package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class GzipSource implements Source {

    /* renamed from: a */
    private int f21358a = 0;

    /* renamed from: b */
    private final BufferedSource f21359b;

    /* renamed from: c */
    private final Inflater f21360c;

    /* renamed from: d */
    private final InflaterSource f21361d;

    /* renamed from: e */
    private final CRC32 f21362e = new CRC32();

    public GzipSource(Source source) {
        if (source != null) {
            Inflater inflater = new Inflater(true);
            this.f21360c = inflater;
            BufferedSource buffer = Okio.buffer(source);
            this.f21359b = buffer;
            this.f21361d = new InflaterSource(buffer, inflater);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    private void m14424a(String str, int i, int i2) {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }

    /* renamed from: b */
    private void m14425b() {
        this.f21359b.require(10);
        byte b = this.f21359b.buffer().getByte(3);
        boolean z = ((b >> 1) & 1) == 1;
        if (z) {
            m14427d(this.f21359b.buffer(), 0, 10);
        }
        m14424a("ID1ID2", 8075, this.f21359b.readShort());
        this.f21359b.skip(8);
        if (((b >> 2) & 1) == 1) {
            this.f21359b.require(2);
            if (z) {
                m14427d(this.f21359b.buffer(), 0, 2);
            }
            long readShortLe = (long) this.f21359b.buffer().readShortLe();
            this.f21359b.require(readShortLe);
            if (z) {
                m14427d(this.f21359b.buffer(), 0, readShortLe);
            }
            this.f21359b.skip(readShortLe);
        }
        if (((b >> 3) & 1) == 1) {
            long indexOf = this.f21359b.indexOf((byte) 0);
            if (indexOf != -1) {
                if (z) {
                    m14427d(this.f21359b.buffer(), 0, indexOf + 1);
                }
                this.f21359b.skip(indexOf + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((b >> 4) & 1) == 1) {
            long indexOf2 = this.f21359b.indexOf((byte) 0);
            if (indexOf2 != -1) {
                if (z) {
                    m14427d(this.f21359b.buffer(), 0, indexOf2 + 1);
                }
                this.f21359b.skip(indexOf2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            m14424a("FHCRC", this.f21359b.readShortLe(), (short) ((int) this.f21362e.getValue()));
            this.f21362e.reset();
        }
    }

    /* renamed from: c */
    private void m14426c() {
        m14424a("CRC", this.f21359b.readIntLe(), (int) this.f21362e.getValue());
        m14424a("ISIZE", this.f21359b.readIntLe(), (int) this.f21360c.getBytesWritten());
    }

    /* renamed from: d */
    private void m14427d(Buffer buffer, long j, long j2) {
        C3578d dVar = buffer.f20193a;
        while (true) {
            int i = dVar.f20215c;
            int i2 = dVar.f20214b;
            if (j < ((long) (i - i2))) {
                break;
            }
            j -= (long) (i - i2);
            dVar = dVar.f20218f;
        }
        while (j2 > 0) {
            int i3 = (int) (((long) dVar.f20214b) + j);
            int min = (int) Math.min((long) (dVar.f20215c - i3), j2);
            this.f21362e.update(dVar.f20213a, i3, min);
            j2 -= (long) min;
            dVar = dVar.f20218f;
            j = 0;
        }
    }

    public void close() {
        this.f21361d.close();
    }

    public long read(Buffer buffer, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j == 0) {
            return 0;
        } else {
            if (this.f21358a == 0) {
                m14425b();
                this.f21358a = 1;
            }
            if (this.f21358a == 1) {
                long j2 = buffer.f20194b;
                long read = this.f21361d.read(buffer, j);
                if (read != -1) {
                    m14427d(buffer, j2, read);
                    return read;
                }
                this.f21358a = 2;
            }
            if (this.f21358a == 2) {
                m14426c();
                this.f21358a = 3;
                if (!this.f21359b.exhausted()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public Timeout timeout() {
        return this.f21359b.timeout();
    }
}
