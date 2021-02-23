package okio;

public abstract class ForwardingSink implements Sink {

    /* renamed from: a */
    private final Sink f20202a;

    public ForwardingSink(Sink sink) {
        if (sink != null) {
            this.f20202a = sink;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public void close() {
        this.f20202a.close();
    }

    public final Sink delegate() {
        return this.f20202a;
    }

    public void flush() {
        this.f20202a.flush();
    }

    public Timeout timeout() {
        return this.f20202a.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f20202a.toString() + ")";
    }

    public void write(Buffer buffer, long j) {
        this.f20202a.write(buffer, j);
    }
}
