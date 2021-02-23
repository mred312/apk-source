package okio;

import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class DeflaterSink implements Sink {

    /* renamed from: a */
    private final BufferedSink f21348a;

    /* renamed from: b */
    private final Deflater f21349b;

    /* renamed from: c */
    private boolean f21350c;

    public DeflaterSink(Sink sink, Deflater deflater) {
        this(Okio.buffer(sink), deflater);
    }

    @IgnoreJRERequirement
    /* renamed from: a */
    private void m14419a(boolean z) {
        C3578d g;
        int i;
        Buffer buffer = this.f21348a.buffer();
        while (true) {
            g = buffer.mo22432g(1);
            if (z) {
                Deflater deflater = this.f21349b;
                byte[] bArr = g.f20213a;
                int i2 = g.f20215c;
                i = deflater.deflate(bArr, i2, 8192 - i2, 2);
            } else {
                Deflater deflater2 = this.f21349b;
                byte[] bArr2 = g.f20213a;
                int i3 = g.f20215c;
                i = deflater2.deflate(bArr2, i3, 8192 - i3);
            }
            if (i > 0) {
                g.f20215c += i;
                buffer.f20194b += (long) i;
                this.f21348a.emitCompleteSegments();
            } else if (this.f21349b.needsInput()) {
                break;
            }
        }
        if (g.f20214b == g.f20215c) {
            buffer.f20193a = g.mo22596b();
            C3579e.m12094a(g);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo25153b() {
        this.f21349b.finish();
        m14419a(false);
    }

    public void close() {
        if (!this.f21350c) {
            try {
                mo25153b();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f21349b.end();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            try {
                this.f21348a.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f21350c = true;
            if (th != null) {
                C3972g.m14449f(th);
                throw null;
            }
        }
    }

    public void flush() {
        m14419a(true);
        this.f21348a.flush();
    }

    public Timeout timeout() {
        return this.f21348a.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.f21348a + ")";
    }

    public void write(Buffer buffer, long j) {
        C3972g.m14445b(buffer.f20194b, 0, j);
        while (j > 0) {
            C3578d dVar = buffer.f20193a;
            int min = (int) Math.min(j, (long) (dVar.f20215c - dVar.f20214b));
            this.f21349b.setInput(dVar.f20213a, dVar.f20214b, min);
            m14419a(false);
            long j2 = (long) min;
            buffer.f20194b -= j2;
            int i = dVar.f20214b + min;
            dVar.f20214b = i;
            if (i == dVar.f20215c) {
                buffer.f20193a = dVar.mo22596b();
                C3579e.m12094a(dVar);
            }
            j -= j2;
        }
    }

    DeflaterSink(BufferedSink bufferedSink, Deflater deflater) {
        if (bufferedSink == null) {
            throw new IllegalArgumentException("source == null");
        } else if (deflater != null) {
            this.f21348a = bufferedSink;
            this.f21349b = deflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }
}
