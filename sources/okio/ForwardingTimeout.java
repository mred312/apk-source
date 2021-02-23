package okio;

import java.util.concurrent.TimeUnit;

public class ForwardingTimeout extends Timeout {

    /* renamed from: d */
    private Timeout f21352d;

    public ForwardingTimeout(Timeout timeout) {
        if (timeout != null) {
            this.f21352d = timeout;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public Timeout clearDeadline() {
        return this.f21352d.clearDeadline();
    }

    public Timeout clearTimeout() {
        return this.f21352d.clearTimeout();
    }

    public long deadlineNanoTime() {
        return this.f21352d.deadlineNanoTime();
    }

    public final Timeout delegate() {
        return this.f21352d;
    }

    public boolean hasDeadline() {
        return this.f21352d.hasDeadline();
    }

    public final ForwardingTimeout setDelegate(Timeout timeout) {
        if (timeout != null) {
            this.f21352d = timeout;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public void throwIfReached() {
        this.f21352d.throwIfReached();
    }

    public Timeout timeout(long j, TimeUnit timeUnit) {
        return this.f21352d.timeout(j, timeUnit);
    }

    public long timeoutNanos() {
        return this.f21352d.timeoutNanos();
    }

    public Timeout deadlineNanoTime(long j) {
        return this.f21352d.deadlineNanoTime(j);
    }
}
