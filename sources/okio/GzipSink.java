package okio;

import java.util.zip.CRC32;
import java.util.zip.Deflater;

public final class GzipSink implements Sink {

    /* renamed from: a */
    private final BufferedSink f21353a;

    /* renamed from: b */
    private final Deflater f21354b;

    /* renamed from: c */
    private final DeflaterSink f21355c;

    /* renamed from: d */
    private boolean f21356d;

    /* renamed from: e */
    private final CRC32 f21357e = new CRC32();

    public GzipSink(Sink sink) {
        if (sink != null) {
            Deflater deflater = new Deflater(-1, true);
            this.f21354b = deflater;
            BufferedSink buffer = Okio.buffer(sink);
            this.f21353a = buffer;
            this.f21355c = new DeflaterSink(buffer, deflater);
            m14423c();
            return;
        }
        throw new IllegalArgumentException("sink == null");
    }

    /* renamed from: a */
    private void m14421a(Buffer buffer, long j) {
        C3578d dVar = buffer.f20193a;
        while (j > 0) {
            int min = (int) Math.min(j, (long) (dVar.f20215c - dVar.f20214b));
            this.f21357e.update(dVar.f20213a, dVar.f20214b, min);
            j -= (long) min;
            dVar = dVar.f20218f;
        }
    }

    /* renamed from: b */
    private void m14422b() {
        this.f21353a.writeIntLe((int) this.f21357e.getValue());
        this.f21353a.writeIntLe((int) this.f21354b.getBytesRead());
    }

    /* renamed from: c */
    private void m14423c() {
        Buffer buffer = this.f21353a.buffer();
        buffer.writeShort(8075);
        buffer.writeByte(8);
        buffer.writeByte(0);
        buffer.writeInt(0);
        buffer.writeByte(0);
        buffer.writeByte(0);
    }

    public void close() {
        if (!this.f21356d) {
            try {
                this.f21355c.mo25153b();
                m14422b();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f21354b.end();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            try {
                this.f21353a.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f21356d = true;
            if (th != null) {
                C3972g.m14449f(th);
                throw null;
            }
        }
    }

    public final Deflater deflater() {
        return this.f21354b;
    }

    public void flush() {
        this.f21355c.flush();
    }

    public Timeout timeout() {
        return this.f21353a.timeout();
    }

    public void write(Buffer buffer, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j != 0) {
            m14421a(buffer, j);
            this.f21355c.write(buffer, j);
        }
    }
}
