package okio;

import java.io.IOException;

public final class Pipe {

    /* renamed from: a */
    final long f21376a;

    /* renamed from: b */
    final Buffer f21377b = new Buffer();

    /* renamed from: c */
    boolean f21378c;

    /* renamed from: d */
    boolean f21379d;

    /* renamed from: e */
    private final Sink f21380e = new C3966a();

    /* renamed from: f */
    private final Source f21381f = new C3967b();

    /* renamed from: okio.Pipe$a */
    final class C3966a implements Sink {

        /* renamed from: a */
        final Timeout f21382a = new Timeout();

        C3966a() {
        }

        public void close() {
            synchronized (Pipe.this.f21377b) {
                Pipe pipe = Pipe.this;
                if (!pipe.f21378c) {
                    if (pipe.f21379d) {
                        if (pipe.f21377b.size() > 0) {
                            throw new IOException("source is closed");
                        }
                    }
                    Pipe pipe2 = Pipe.this;
                    pipe2.f21378c = true;
                    pipe2.f21377b.notifyAll();
                }
            }
        }

        public void flush() {
            synchronized (Pipe.this.f21377b) {
                Pipe pipe = Pipe.this;
                if (pipe.f21378c) {
                    throw new IllegalStateException("closed");
                } else if (pipe.f21379d) {
                    if (pipe.f21377b.size() > 0) {
                        throw new IOException("source is closed");
                    }
                }
            }
        }

        public Timeout timeout() {
            return this.f21382a;
        }

        public void write(Buffer buffer, long j) {
            synchronized (Pipe.this.f21377b) {
                if (!Pipe.this.f21378c) {
                    while (j > 0) {
                        Pipe pipe = Pipe.this;
                        if (!pipe.f21379d) {
                            long size = pipe.f21376a - pipe.f21377b.size();
                            if (size == 0) {
                                this.f21382a.waitUntilNotified(Pipe.this.f21377b);
                            } else {
                                long min = Math.min(size, j);
                                Pipe.this.f21377b.write(buffer, min);
                                j -= min;
                                Pipe.this.f21377b.notifyAll();
                            }
                        } else {
                            throw new IOException("source is closed");
                        }
                    }
                } else {
                    throw new IllegalStateException("closed");
                }
            }
        }
    }

    /* renamed from: okio.Pipe$b */
    final class C3967b implements Source {

        /* renamed from: a */
        final Timeout f21384a = new Timeout();

        C3967b() {
        }

        public void close() {
            synchronized (Pipe.this.f21377b) {
                Pipe pipe = Pipe.this;
                pipe.f21379d = true;
                pipe.f21377b.notifyAll();
            }
        }

        public long read(Buffer buffer, long j) {
            synchronized (Pipe.this.f21377b) {
                if (!Pipe.this.f21379d) {
                    while (Pipe.this.f21377b.size() == 0) {
                        Pipe pipe = Pipe.this;
                        if (pipe.f21378c) {
                            return -1;
                        }
                        this.f21384a.waitUntilNotified(pipe.f21377b);
                    }
                    long read = Pipe.this.f21377b.read(buffer, j);
                    Pipe.this.f21377b.notifyAll();
                    return read;
                }
                throw new IllegalStateException("closed");
            }
        }

        public Timeout timeout() {
            return this.f21384a;
        }
    }

    public Pipe(long j) {
        if (j >= 1) {
            this.f21376a = j;
            return;
        }
        throw new IllegalArgumentException("maxBufferSize < 1: " + j);
    }

    public final Sink sink() {
        return this.f21380e;
    }

    public final Source source() {
        return this.f21381f;
    }
}
