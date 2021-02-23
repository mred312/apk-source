package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class InflaterSource implements Source {

    /* renamed from: a */
    private final BufferedSource f21365a;

    /* renamed from: b */
    private final Inflater f21366b;

    /* renamed from: c */
    private int f21367c;

    /* renamed from: d */
    private boolean f21368d;

    public InflaterSource(Source source, Inflater inflater) {
        this(Okio.buffer(source), inflater);
    }

    /* renamed from: a */
    private void m14428a() {
        int i = this.f21367c;
        if (i != 0) {
            int remaining = i - this.f21366b.getRemaining();
            this.f21367c -= remaining;
            this.f21365a.skip((long) remaining);
        }
    }

    public void close() {
        if (!this.f21368d) {
            this.f21366b.end();
            this.f21368d = true;
            this.f21365a.close();
        }
    }

    public long read(Buffer buffer, long j) {
        C3578d g;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f21368d) {
            throw new IllegalStateException("closed");
        } else if (j == 0) {
            return 0;
        } else {
            while (true) {
                boolean refill = refill();
                try {
                    g = buffer.mo22432g(1);
                    int inflate = this.f21366b.inflate(g.f20213a, g.f20215c, (int) Math.min(j, (long) (8192 - g.f20215c)));
                    if (inflate > 0) {
                        g.f20215c += inflate;
                        long j2 = (long) inflate;
                        buffer.f20194b += j2;
                        return j2;
                    } else if (this.f21366b.finished()) {
                        break;
                    } else if (this.f21366b.needsDictionary()) {
                        break;
                    } else if (refill) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            }
            m14428a();
            if (g.f20214b != g.f20215c) {
                return -1;
            }
            buffer.f20193a = g.mo22596b();
            C3579e.m12094a(g);
            return -1;
        }
    }

    public final boolean refill() {
        if (!this.f21366b.needsInput()) {
            return false;
        }
        m14428a();
        if (this.f21366b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f21365a.exhausted()) {
            return true;
        } else {
            C3578d dVar = this.f21365a.buffer().f20193a;
            int i = dVar.f20215c;
            int i2 = dVar.f20214b;
            int i3 = i - i2;
            this.f21367c = i3;
            this.f21366b.setInput(dVar.f20213a, i2, i3);
            return false;
        }
    }

    public Timeout timeout() {
        return this.f21365a.timeout();
    }

    InflaterSource(BufferedSource bufferedSource, Inflater inflater) {
        if (bufferedSource == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater != null) {
            this.f21365a = bufferedSource;
            this.f21366b = inflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }
}
