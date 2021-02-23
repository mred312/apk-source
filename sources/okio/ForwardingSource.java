package okio;

public abstract class ForwardingSource implements Source {

    /* renamed from: a */
    private final Source f21351a;

    public ForwardingSource(Source source) {
        if (source != null) {
            this.f21351a = source;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public void close() {
        this.f21351a.close();
    }

    public final Source delegate() {
        return this.f21351a;
    }

    public long read(Buffer buffer, long j) {
        return this.f21351a.read(buffer, j);
    }

    public Timeout timeout() {
        return this.f21351a.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f21351a.toString() + ")";
    }
}
