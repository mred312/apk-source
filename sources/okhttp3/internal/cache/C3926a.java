package okhttp3.internal.cache;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

/* renamed from: okhttp3.internal.cache.a */
/* compiled from: FaultHidingSink */
class C3926a extends ForwardingSink {

    /* renamed from: b */
    private boolean f21109b;

    C3926a(Sink sink) {
        super(sink);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo22316a(IOException iOException) {
        throw null;
    }

    public void close() {
        if (!this.f21109b) {
            try {
                super.close();
            } catch (IOException e) {
                this.f21109b = true;
                mo22316a(e);
            }
        }
    }

    public void flush() {
        if (!this.f21109b) {
            try {
                super.flush();
            } catch (IOException e) {
                this.f21109b = true;
                mo22316a(e);
            }
        }
    }

    public void write(Buffer buffer, long j) {
        if (this.f21109b) {
            buffer.skip(j);
            return;
        }
        try {
            super.write(buffer, j);
        } catch (IOException e) {
            this.f21109b = true;
            mo22316a(e);
        }
    }
}
